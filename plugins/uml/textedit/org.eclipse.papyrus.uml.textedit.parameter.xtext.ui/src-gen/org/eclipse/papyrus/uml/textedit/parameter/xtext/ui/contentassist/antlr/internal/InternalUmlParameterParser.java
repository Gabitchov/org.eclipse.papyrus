package org.eclipse.papyrus.uml.textedit.parameter.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.parameter.xtext.services.UmlParameterGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlParameterParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'*'", "'exception'", "'stream'", "'ordered'", "'unique'", "'create'", "'read'", "'update'", "'delete'", "'+'", "'-'", "'#'", "'~'", "'in'", "'out'", "'inout'", "'return'", "':'", "'{'", "'}'", "','", "'effect: '", "'::'", "'['", "']'", "'..'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalUmlParameterParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlParameterParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlParameterParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g"; }


     
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




    // $ANTLR start "entryRuleParameterRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:60:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:61:1: ( ruleParameterRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:62:1: ruleParameterRule EOF
            {
             before(grammarAccess.getParameterRuleRule()); 
            pushFollow(FOLLOW_ruleParameterRule_in_entryRuleParameterRule61);
            ruleParameterRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleParameterRule"


    // $ANTLR start "ruleParameterRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:69:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:73:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:74:1: ( ( rule__ParameterRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:74:1: ( ( rule__ParameterRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:75:1: ( rule__ParameterRule__Group__0 )
            {
             before(grammarAccess.getParameterRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:76:1: ( rule__ParameterRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:76:2: rule__ParameterRule__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__0_in_ruleParameterRule94);
            rule__ParameterRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleParameterRule"


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:88:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:89:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:90:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule121);
            ruleModifiersRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleModifiersRule"


    // $ANTLR start "ruleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:97:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:101:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:102:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:102:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:103:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:104:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:104:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule154);
            rule__ModifiersRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleModifiersRule"


    // $ANTLR start "entryRuleModifierSpecification"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:116:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:117:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:118:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification181);
            ruleModifierSpecification();

            state._fsp--;

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
    // $ANTLR end "entryRuleModifierSpecification"


    // $ANTLR start "ruleModifierSpecification"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:125:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__ValueAssignment ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:129:2: ( ( ( rule__ModifierSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:130:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:130:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:131:1: ( rule__ModifierSpecification__ValueAssignment )
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:132:1: ( rule__ModifierSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:132:2: rule__ModifierSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification214);
            rule__ModifierSpecification__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleModifierSpecification"


    // $ANTLR start "entryRuleEffectRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:144:1: entryRuleEffectRule : ruleEffectRule EOF ;
    public final void entryRuleEffectRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:145:1: ( ruleEffectRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:146:1: ruleEffectRule EOF
            {
             before(grammarAccess.getEffectRuleRule()); 
            pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule241);
            ruleEffectRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleEffectRule"


    // $ANTLR start "ruleEffectRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:153:1: ruleEffectRule : ( ( rule__EffectRule__Group__0 ) ) ;
    public final void ruleEffectRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:157:2: ( ( ( rule__EffectRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:158:1: ( ( rule__EffectRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:158:1: ( ( rule__EffectRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:159:1: ( rule__EffectRule__Group__0 )
            {
             before(grammarAccess.getEffectRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:160:1: ( rule__EffectRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:160:2: rule__EffectRule__Group__0
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__0_in_ruleEffectRule274);
            rule__EffectRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEffectRule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:172:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:173:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:174:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName301);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:181:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:185:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:186:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:187:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:188:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:188:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334);
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


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:200:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:201:1: ( ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:202:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule361);
            ruleTypeRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:209:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:213:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:214:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:214:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:215:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:216:1: ( rule__TypeRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:216:2: rule__TypeRule__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule394);
            rule__TypeRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:228:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:229:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:230:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule421);
            ruleMultiplicityRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleMultiplicityRule"


    // $ANTLR start "ruleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:237:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:241:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:242:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:242:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:243:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:244:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:244:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule454);
            rule__MultiplicityRule__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleMultiplicityRule"


    // $ANTLR start "entryRuleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:256:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:257:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:258:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification481);
            ruleBoundSpecification();

            state._fsp--;

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
    // $ANTLR end "entryRuleBoundSpecification"


    // $ANTLR start "ruleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:265:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:269:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:270:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:270:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:271:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:272:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:272:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification514);
            rule__BoundSpecification__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleBoundSpecification"


    // $ANTLR start "entryRuleUnlimitedLiteral"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:284:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
    public final void entryRuleUnlimitedLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:285:1: ( ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:286:1: ruleUnlimitedLiteral EOF
            {
             before(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral541);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getUnlimitedLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral548); 

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
    // $ANTLR end "entryRuleUnlimitedLiteral"


    // $ANTLR start "ruleUnlimitedLiteral"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:293:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
    public final void ruleUnlimitedLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:297:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:298:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:298:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:299:1: ( rule__UnlimitedLiteral__Alternatives )
            {
             before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:300:1: ( rule__UnlimitedLiteral__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:300:2: rule__UnlimitedLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral574);
            rule__UnlimitedLiteral__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnlimitedLiteral"


    // $ANTLR start "ruleModifierKind"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:313:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:317:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:318:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:318:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:319:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:320:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:320:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind611);
            rule__ModifierKind__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleModifierKind"


    // $ANTLR start "ruleEffectKind"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:332:1: ruleEffectKind : ( ( rule__EffectKind__Alternatives ) ) ;
    public final void ruleEffectKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:336:1: ( ( ( rule__EffectKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:337:1: ( ( rule__EffectKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:337:1: ( ( rule__EffectKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:338:1: ( rule__EffectKind__Alternatives )
            {
             before(grammarAccess.getEffectKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:339:1: ( rule__EffectKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:339:2: rule__EffectKind__Alternatives
            {
            pushFollow(FOLLOW_rule__EffectKind__Alternatives_in_ruleEffectKind647);
            rule__EffectKind__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleEffectKind"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:351:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:355:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:356:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:356:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:357:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:358:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:358:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind683);
            rule__VisibilityKind__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleVisibilityKind"


    // $ANTLR start "ruleDirection"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:370:1: ruleDirection : ( ( rule__Direction__Alternatives ) ) ;
    public final void ruleDirection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:374:1: ( ( ( rule__Direction__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:375:1: ( ( rule__Direction__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:375:1: ( ( rule__Direction__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:376:1: ( rule__Direction__Alternatives )
            {
             before(grammarAccess.getDirectionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:377:1: ( rule__Direction__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:377:2: rule__Direction__Alternatives
            {
            pushFollow(FOLLOW_rule__Direction__Alternatives_in_ruleDirection719);
            rule__Direction__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleDirection"


    // $ANTLR start "rule__ParameterRule__Alternatives_4"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:388:1: rule__ParameterRule__Alternatives_4 : ( ( ( rule__ParameterRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__ParameterRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:392:1: ( ( ( rule__ParameterRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:393:1: ( ( rule__ParameterRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:393:1: ( ( rule__ParameterRule__TypeAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:394:1: ( rule__ParameterRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getParameterRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:395:1: ( rule__ParameterRule__TypeAssignment_4_0 )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:395:2: rule__ParameterRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__ParameterRule__TypeAssignment_4_0_in_rule__ParameterRule__Alternatives_4754);
                    rule__ParameterRule__TypeAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:399:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:399:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:400:1: '<Undefined>'
                    {
                     before(grammarAccess.getParameterRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,11,FOLLOW_11_in_rule__ParameterRule__Alternatives_4773); 
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
    // $ANTLR end "rule__ParameterRule__Alternatives_4"


    // $ANTLR start "rule__UnlimitedLiteral__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:412:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:416:1: ( ( RULE_INT ) | ( '*' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:417:1: ( RULE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:417:1: ( RULE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:418:1: RULE_INT
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives807); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:423:6: ( '*' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:423:6: ( '*' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:424:1: '*'
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__UnlimitedLiteral__Alternatives825); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 

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
    // $ANTLR end "rule__UnlimitedLiteral__Alternatives"


    // $ANTLR start "rule__ModifierKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:436:1: rule__ModifierKind__Alternatives : ( ( ( 'exception' ) ) | ( ( 'stream' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:440:1: ( ( ( 'exception' ) ) | ( ( 'stream' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            case 16:
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
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:441:1: ( ( 'exception' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:441:1: ( ( 'exception' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:442:1: ( 'exception' )
                    {
                     before(grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:443:1: ( 'exception' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:443:3: 'exception'
                    {
                    match(input,13,FOLLOW_13_in_rule__ModifierKind__Alternatives860); 

                    }

                     after(grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:448:6: ( ( 'stream' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:448:6: ( ( 'stream' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:449:1: ( 'stream' )
                    {
                     before(grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:450:1: ( 'stream' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:450:3: 'stream'
                    {
                    match(input,14,FOLLOW_14_in_rule__ModifierKind__Alternatives881); 

                    }

                     after(grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:455:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:455:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:456:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:457:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:457:3: 'ordered'
                    {
                    match(input,15,FOLLOW_15_in_rule__ModifierKind__Alternatives902); 

                    }

                     after(grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:462:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:462:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:463:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:464:1: ( 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:464:3: 'unique'
                    {
                    match(input,16,FOLLOW_16_in_rule__ModifierKind__Alternatives923); 

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
    // $ANTLR end "rule__ModifierKind__Alternatives"


    // $ANTLR start "rule__EffectKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:474:1: rule__EffectKind__Alternatives : ( ( ( 'create' ) ) | ( ( 'read' ) ) | ( ( 'update' ) ) | ( ( 'delete' ) ) );
    public final void rule__EffectKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:478:1: ( ( ( 'create' ) ) | ( ( 'read' ) ) | ( ( 'update' ) ) | ( ( 'delete' ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            case 19:
                {
                alt4=3;
                }
                break;
            case 20:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:479:1: ( ( 'create' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:479:1: ( ( 'create' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:480:1: ( 'create' )
                    {
                     before(grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:481:1: ( 'create' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:481:3: 'create'
                    {
                    match(input,17,FOLLOW_17_in_rule__EffectKind__Alternatives959); 

                    }

                     after(grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:486:6: ( ( 'read' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:486:6: ( ( 'read' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:487:1: ( 'read' )
                    {
                     before(grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:488:1: ( 'read' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:488:3: 'read'
                    {
                    match(input,18,FOLLOW_18_in_rule__EffectKind__Alternatives980); 

                    }

                     after(grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:493:6: ( ( 'update' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:493:6: ( ( 'update' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:494:1: ( 'update' )
                    {
                     before(grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:495:1: ( 'update' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:495:3: 'update'
                    {
                    match(input,19,FOLLOW_19_in_rule__EffectKind__Alternatives1001); 

                    }

                     after(grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:500:6: ( ( 'delete' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:500:6: ( ( 'delete' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:501:1: ( 'delete' )
                    {
                     before(grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:502:1: ( 'delete' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:502:3: 'delete'
                    {
                    match(input,20,FOLLOW_20_in_rule__EffectKind__Alternatives1022); 

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
    // $ANTLR end "rule__EffectKind__Alternatives"


    // $ANTLR start "rule__VisibilityKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:512:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:516:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt5=1;
                }
                break;
            case 22:
                {
                alt5=2;
                }
                break;
            case 23:
                {
                alt5=3;
                }
                break;
            case 24:
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
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:517:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:517:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:518:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:519:1: ( '+' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:519:3: '+'
                    {
                    match(input,21,FOLLOW_21_in_rule__VisibilityKind__Alternatives1058); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:524:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:524:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:525:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:526:1: ( '-' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:526:3: '-'
                    {
                    match(input,22,FOLLOW_22_in_rule__VisibilityKind__Alternatives1079); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:531:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:531:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:532:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:533:1: ( '#' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:533:3: '#'
                    {
                    match(input,23,FOLLOW_23_in_rule__VisibilityKind__Alternatives1100); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:538:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:538:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:539:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:540:1: ( '~' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:540:3: '~'
                    {
                    match(input,24,FOLLOW_24_in_rule__VisibilityKind__Alternatives1121); 

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
    // $ANTLR end "rule__VisibilityKind__Alternatives"


    // $ANTLR start "rule__Direction__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:550:1: rule__Direction__Alternatives : ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) | ( ( 'return' ) ) );
    public final void rule__Direction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:554:1: ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) | ( ( 'return' ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt6=1;
                }
                break;
            case 26:
                {
                alt6=2;
                }
                break;
            case 27:
                {
                alt6=3;
                }
                break;
            case 28:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:555:1: ( ( 'in' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:555:1: ( ( 'in' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:556:1: ( 'in' )
                    {
                     before(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:557:1: ( 'in' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:557:3: 'in'
                    {
                    match(input,25,FOLLOW_25_in_rule__Direction__Alternatives1157); 

                    }

                     after(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:562:6: ( ( 'out' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:562:6: ( ( 'out' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:563:1: ( 'out' )
                    {
                     before(grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:564:1: ( 'out' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:564:3: 'out'
                    {
                    match(input,26,FOLLOW_26_in_rule__Direction__Alternatives1178); 

                    }

                     after(grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:569:6: ( ( 'inout' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:569:6: ( ( 'inout' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:570:1: ( 'inout' )
                    {
                     before(grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:571:1: ( 'inout' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:571:3: 'inout'
                    {
                    match(input,27,FOLLOW_27_in_rule__Direction__Alternatives1199); 

                    }

                     after(grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:576:6: ( ( 'return' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:576:6: ( ( 'return' ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:577:1: ( 'return' )
                    {
                     before(grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:578:1: ( 'return' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:578:3: 'return'
                    {
                    match(input,28,FOLLOW_28_in_rule__Direction__Alternatives1220); 

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
    // $ANTLR end "rule__Direction__Alternatives"


    // $ANTLR start "rule__ParameterRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:590:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:594:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:595:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__0__Impl_in_rule__ParameterRule__Group__01253);
            rule__ParameterRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__1_in_rule__ParameterRule__Group__01256);
            rule__ParameterRule__Group__1();

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
    // $ANTLR end "rule__ParameterRule__Group__0"


    // $ANTLR start "rule__ParameterRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:602:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__VisibilityAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:606:1: ( ( ( rule__ParameterRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:607:1: ( ( rule__ParameterRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:607:1: ( ( rule__ParameterRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:608:1: ( rule__ParameterRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:609:1: ( rule__ParameterRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:609:2: rule__ParameterRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__ParameterRule__VisibilityAssignment_0_in_rule__ParameterRule__Group__0__Impl1283);
            rule__ParameterRule__VisibilityAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__0__Impl"


    // $ANTLR start "rule__ParameterRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:619:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl rule__ParameterRule__Group__2 ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:623:1: ( rule__ParameterRule__Group__1__Impl rule__ParameterRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:624:2: rule__ParameterRule__Group__1__Impl rule__ParameterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__1__Impl_in_rule__ParameterRule__Group__11313);
            rule__ParameterRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__2_in_rule__ParameterRule__Group__11316);
            rule__ParameterRule__Group__2();

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
    // $ANTLR end "rule__ParameterRule__Group__1"


    // $ANTLR start "rule__ParameterRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:631:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__DirectionAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:635:1: ( ( ( rule__ParameterRule__DirectionAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:636:1: ( ( rule__ParameterRule__DirectionAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:636:1: ( ( rule__ParameterRule__DirectionAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:637:1: ( rule__ParameterRule__DirectionAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getDirectionAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:638:1: ( rule__ParameterRule__DirectionAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:638:2: rule__ParameterRule__DirectionAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterRule__DirectionAssignment_1_in_rule__ParameterRule__Group__1__Impl1343);
            rule__ParameterRule__DirectionAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__1__Impl"


    // $ANTLR start "rule__ParameterRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:648:1: rule__ParameterRule__Group__2 : rule__ParameterRule__Group__2__Impl rule__ParameterRule__Group__3 ;
    public final void rule__ParameterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:652:1: ( rule__ParameterRule__Group__2__Impl rule__ParameterRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:653:2: rule__ParameterRule__Group__2__Impl rule__ParameterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__2__Impl_in_rule__ParameterRule__Group__21373);
            rule__ParameterRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__3_in_rule__ParameterRule__Group__21376);
            rule__ParameterRule__Group__3();

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
    // $ANTLR end "rule__ParameterRule__Group__2"


    // $ANTLR start "rule__ParameterRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:660:1: rule__ParameterRule__Group__2__Impl : ( ( rule__ParameterRule__NameAssignment_2 ) ) ;
    public final void rule__ParameterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:664:1: ( ( ( rule__ParameterRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:665:1: ( ( rule__ParameterRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:665:1: ( ( rule__ParameterRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:666:1: ( rule__ParameterRule__NameAssignment_2 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:667:1: ( rule__ParameterRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:667:2: rule__ParameterRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ParameterRule__NameAssignment_2_in_rule__ParameterRule__Group__2__Impl1403);
            rule__ParameterRule__NameAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__2__Impl"


    // $ANTLR start "rule__ParameterRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:677:1: rule__ParameterRule__Group__3 : rule__ParameterRule__Group__3__Impl rule__ParameterRule__Group__4 ;
    public final void rule__ParameterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:681:1: ( rule__ParameterRule__Group__3__Impl rule__ParameterRule__Group__4 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:682:2: rule__ParameterRule__Group__3__Impl rule__ParameterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__3__Impl_in_rule__ParameterRule__Group__31433);
            rule__ParameterRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__4_in_rule__ParameterRule__Group__31436);
            rule__ParameterRule__Group__4();

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
    // $ANTLR end "rule__ParameterRule__Group__3"


    // $ANTLR start "rule__ParameterRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:689:1: rule__ParameterRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParameterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:693:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:694:1: ( ':' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:694:1: ( ':' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:695:1: ':'
            {
             before(grammarAccess.getParameterRuleAccess().getColonKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__ParameterRule__Group__3__Impl1464); 
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
    // $ANTLR end "rule__ParameterRule__Group__3__Impl"


    // $ANTLR start "rule__ParameterRule__Group__4"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:708:1: rule__ParameterRule__Group__4 : rule__ParameterRule__Group__4__Impl rule__ParameterRule__Group__5 ;
    public final void rule__ParameterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:712:1: ( rule__ParameterRule__Group__4__Impl rule__ParameterRule__Group__5 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:713:2: rule__ParameterRule__Group__4__Impl rule__ParameterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__4__Impl_in_rule__ParameterRule__Group__41495);
            rule__ParameterRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__5_in_rule__ParameterRule__Group__41498);
            rule__ParameterRule__Group__5();

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
    // $ANTLR end "rule__ParameterRule__Group__4"


    // $ANTLR start "rule__ParameterRule__Group__4__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:720:1: rule__ParameterRule__Group__4__Impl : ( ( rule__ParameterRule__Alternatives_4 ) ) ;
    public final void rule__ParameterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:724:1: ( ( ( rule__ParameterRule__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:725:1: ( ( rule__ParameterRule__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:725:1: ( ( rule__ParameterRule__Alternatives_4 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:726:1: ( rule__ParameterRule__Alternatives_4 )
            {
             before(grammarAccess.getParameterRuleAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:727:1: ( rule__ParameterRule__Alternatives_4 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:727:2: rule__ParameterRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__ParameterRule__Alternatives_4_in_rule__ParameterRule__Group__4__Impl1525);
            rule__ParameterRule__Alternatives_4();

            state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__4__Impl"


    // $ANTLR start "rule__ParameterRule__Group__5"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:737:1: rule__ParameterRule__Group__5 : rule__ParameterRule__Group__5__Impl rule__ParameterRule__Group__6 ;
    public final void rule__ParameterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:741:1: ( rule__ParameterRule__Group__5__Impl rule__ParameterRule__Group__6 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:742:2: rule__ParameterRule__Group__5__Impl rule__ParameterRule__Group__6
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__5__Impl_in_rule__ParameterRule__Group__51555);
            rule__ParameterRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__6_in_rule__ParameterRule__Group__51558);
            rule__ParameterRule__Group__6();

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
    // $ANTLR end "rule__ParameterRule__Group__5"


    // $ANTLR start "rule__ParameterRule__Group__5__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:749:1: rule__ParameterRule__Group__5__Impl : ( ( rule__ParameterRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__ParameterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:753:1: ( ( ( rule__ParameterRule__MultiplicityAssignment_5 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:754:1: ( ( rule__ParameterRule__MultiplicityAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:754:1: ( ( rule__ParameterRule__MultiplicityAssignment_5 )? )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:755:1: ( rule__ParameterRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getParameterRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:756:1: ( rule__ParameterRule__MultiplicityAssignment_5 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==35) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:756:2: rule__ParameterRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__ParameterRule__MultiplicityAssignment_5_in_rule__ParameterRule__Group__5__Impl1585);
                    rule__ParameterRule__MultiplicityAssignment_5();

                    state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__5__Impl"


    // $ANTLR start "rule__ParameterRule__Group__6"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:766:1: rule__ParameterRule__Group__6 : rule__ParameterRule__Group__6__Impl rule__ParameterRule__Group__7 ;
    public final void rule__ParameterRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:770:1: ( rule__ParameterRule__Group__6__Impl rule__ParameterRule__Group__7 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:771:2: rule__ParameterRule__Group__6__Impl rule__ParameterRule__Group__7
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__6__Impl_in_rule__ParameterRule__Group__61616);
            rule__ParameterRule__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__7_in_rule__ParameterRule__Group__61619);
            rule__ParameterRule__Group__7();

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
    // $ANTLR end "rule__ParameterRule__Group__6"


    // $ANTLR start "rule__ParameterRule__Group__6__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:778:1: rule__ParameterRule__Group__6__Impl : ( ( rule__ParameterRule__ModifiersAssignment_6 )? ) ;
    public final void rule__ParameterRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:782:1: ( ( ( rule__ParameterRule__ModifiersAssignment_6 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:783:1: ( ( rule__ParameterRule__ModifiersAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:783:1: ( ( rule__ParameterRule__ModifiersAssignment_6 )? )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:784:1: ( rule__ParameterRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getParameterRuleAccess().getModifiersAssignment_6()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:785:1: ( rule__ParameterRule__ModifiersAssignment_6 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==30) ) {
                int LA8_1 = input.LA(2);

                if ( ((LA8_1>=13 && LA8_1<=16)) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:785:2: rule__ParameterRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__ParameterRule__ModifiersAssignment_6_in_rule__ParameterRule__Group__6__Impl1646);
                    rule__ParameterRule__ModifiersAssignment_6();

                    state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__6__Impl"


    // $ANTLR start "rule__ParameterRule__Group__7"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:795:1: rule__ParameterRule__Group__7 : rule__ParameterRule__Group__7__Impl ;
    public final void rule__ParameterRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:799:1: ( rule__ParameterRule__Group__7__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:800:2: rule__ParameterRule__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__7__Impl_in_rule__ParameterRule__Group__71677);
            rule__ParameterRule__Group__7__Impl();

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
    // $ANTLR end "rule__ParameterRule__Group__7"


    // $ANTLR start "rule__ParameterRule__Group__7__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:806:1: rule__ParameterRule__Group__7__Impl : ( ( rule__ParameterRule__EffectAssignment_7 ) ) ;
    public final void rule__ParameterRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:810:1: ( ( ( rule__ParameterRule__EffectAssignment_7 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:811:1: ( ( rule__ParameterRule__EffectAssignment_7 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:811:1: ( ( rule__ParameterRule__EffectAssignment_7 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:812:1: ( rule__ParameterRule__EffectAssignment_7 )
            {
             before(grammarAccess.getParameterRuleAccess().getEffectAssignment_7()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:813:1: ( rule__ParameterRule__EffectAssignment_7 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:813:2: rule__ParameterRule__EffectAssignment_7
            {
            pushFollow(FOLLOW_rule__ParameterRule__EffectAssignment_7_in_rule__ParameterRule__Group__7__Impl1704);
            rule__ParameterRule__EffectAssignment_7();

            state._fsp--;


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
    // $ANTLR end "rule__ParameterRule__Group__7__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:839:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:843:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:844:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01750);
            rule__ModifiersRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01753);
            rule__ModifiersRule__Group__1();

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
    // $ANTLR end "rule__ModifiersRule__Group__0"


    // $ANTLR start "rule__ModifiersRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:851:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:855:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:856:1: ( '{' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:856:1: ( '{' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:857:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__ModifiersRule__Group__0__Impl1781); 
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
    // $ANTLR end "rule__ModifiersRule__Group__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:870:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:874:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:875:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11812);
            rule__ModifiersRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11815);
            rule__ModifiersRule__Group__2();

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
    // $ANTLR end "rule__ModifiersRule__Group__1"


    // $ANTLR start "rule__ModifiersRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:882:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:886:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:887:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:887:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:888:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:889:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:889:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl1842);
            rule__ModifiersRule__ValuesAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__ModifiersRule__Group__1__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:899:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:903:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:904:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__21872);
            rule__ModifiersRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__21875);
            rule__ModifiersRule__Group__3();

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
    // $ANTLR end "rule__ModifiersRule__Group__2"


    // $ANTLR start "rule__ModifiersRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:911:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:915:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:916:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:916:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:917:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:918:1: ( rule__ModifiersRule__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==32) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:918:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl1902);
            	    rule__ModifiersRule__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "rule__ModifiersRule__Group__2__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:928:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:932:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:933:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__31933);
            rule__ModifiersRule__Group__3__Impl();

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
    // $ANTLR end "rule__ModifiersRule__Group__3"


    // $ANTLR start "rule__ModifiersRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:939:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:943:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:944:1: ( '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:944:1: ( '}' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:945:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__ModifiersRule__Group__3__Impl1961); 
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
    // $ANTLR end "rule__ModifiersRule__Group__3__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:966:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:970:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:971:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02000);
            rule__ModifiersRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02003);
            rule__ModifiersRule__Group_2__1();

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
    // $ANTLR end "rule__ModifiersRule__Group_2__0"


    // $ANTLR start "rule__ModifiersRule__Group_2__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:978:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:982:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:983:1: ( ',' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:983:1: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:984:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,32,FOLLOW_32_in_rule__ModifiersRule__Group_2__0__Impl2031); 
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
    // $ANTLR end "rule__ModifiersRule__Group_2__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:997:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1001:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1002:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12062);
            rule__ModifiersRule__Group_2__1__Impl();

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
    // $ANTLR end "rule__ModifiersRule__Group_2__1"


    // $ANTLR start "rule__ModifiersRule__Group_2__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1008:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1012:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1013:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1013:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1014:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1015:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1015:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2089);
            rule__ModifiersRule__ValuesAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__ModifiersRule__Group_2__1__Impl"


    // $ANTLR start "rule__EffectRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1029:1: rule__EffectRule__Group__0 : rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 ;
    public final void rule__EffectRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1033:1: ( rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1034:2: rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__0__Impl_in_rule__EffectRule__Group__02123);
            rule__EffectRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__1_in_rule__EffectRule__Group__02126);
            rule__EffectRule__Group__1();

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
    // $ANTLR end "rule__EffectRule__Group__0"


    // $ANTLR start "rule__EffectRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1041:1: rule__EffectRule__Group__0__Impl : ( '{' ) ;
    public final void rule__EffectRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1045:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1046:1: ( '{' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1046:1: ( '{' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1047:1: '{'
            {
             before(grammarAccess.getEffectRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EffectRule__Group__0__Impl2154); 
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
    // $ANTLR end "rule__EffectRule__Group__0__Impl"


    // $ANTLR start "rule__EffectRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1060:1: rule__EffectRule__Group__1 : rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 ;
    public final void rule__EffectRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1064:1: ( rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1065:2: rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__1__Impl_in_rule__EffectRule__Group__12185);
            rule__EffectRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__2_in_rule__EffectRule__Group__12188);
            rule__EffectRule__Group__2();

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
    // $ANTLR end "rule__EffectRule__Group__1"


    // $ANTLR start "rule__EffectRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1072:1: rule__EffectRule__Group__1__Impl : ( 'effect: ' ) ;
    public final void rule__EffectRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1076:1: ( ( 'effect: ' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1077:1: ( 'effect: ' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1077:1: ( 'effect: ' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1078:1: 'effect: '
            {
             before(grammarAccess.getEffectRuleAccess().getEffectKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__EffectRule__Group__1__Impl2216); 
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
    // $ANTLR end "rule__EffectRule__Group__1__Impl"


    // $ANTLR start "rule__EffectRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1091:1: rule__EffectRule__Group__2 : rule__EffectRule__Group__2__Impl rule__EffectRule__Group__3 ;
    public final void rule__EffectRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1095:1: ( rule__EffectRule__Group__2__Impl rule__EffectRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1096:2: rule__EffectRule__Group__2__Impl rule__EffectRule__Group__3
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__2__Impl_in_rule__EffectRule__Group__22247);
            rule__EffectRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__3_in_rule__EffectRule__Group__22250);
            rule__EffectRule__Group__3();

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
    // $ANTLR end "rule__EffectRule__Group__2"


    // $ANTLR start "rule__EffectRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1103:1: rule__EffectRule__Group__2__Impl : ( ( rule__EffectRule__EffectKindAssignment_2 ) ) ;
    public final void rule__EffectRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1107:1: ( ( ( rule__EffectRule__EffectKindAssignment_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1108:1: ( ( rule__EffectRule__EffectKindAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1108:1: ( ( rule__EffectRule__EffectKindAssignment_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1109:1: ( rule__EffectRule__EffectKindAssignment_2 )
            {
             before(grammarAccess.getEffectRuleAccess().getEffectKindAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1110:1: ( rule__EffectRule__EffectKindAssignment_2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1110:2: rule__EffectRule__EffectKindAssignment_2
            {
            pushFollow(FOLLOW_rule__EffectRule__EffectKindAssignment_2_in_rule__EffectRule__Group__2__Impl2277);
            rule__EffectRule__EffectKindAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__EffectRule__Group__2__Impl"


    // $ANTLR start "rule__EffectRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1120:1: rule__EffectRule__Group__3 : rule__EffectRule__Group__3__Impl ;
    public final void rule__EffectRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1124:1: ( rule__EffectRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1125:2: rule__EffectRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__3__Impl_in_rule__EffectRule__Group__32307);
            rule__EffectRule__Group__3__Impl();

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
    // $ANTLR end "rule__EffectRule__Group__3"


    // $ANTLR start "rule__EffectRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1131:1: rule__EffectRule__Group__3__Impl : ( '}' ) ;
    public final void rule__EffectRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1135:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1136:1: ( '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1136:1: ( '}' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1137:1: '}'
            {
             before(grammarAccess.getEffectRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__EffectRule__Group__3__Impl2335); 
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
    // $ANTLR end "rule__EffectRule__Group__3__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1158:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1162:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1163:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02374);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02377);
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1170:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1174:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1175:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1175:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1176:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1177:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1177:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2404);
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1187:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1191:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1192:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12434);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12437);
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1199:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1203:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1204:1: ( '::' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1204:1: ( '::' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1205:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__QualifiedName__Group__1__Impl2465); 
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1218:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1222:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1223:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22496);
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1229:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1233:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1234:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1234:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1235:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1236:1: ( rule__QualifiedName__RemainingAssignment_2 )?
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
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1236:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2523);
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


    // $ANTLR start "rule__TypeRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1252:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1256:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1257:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02560);
            rule__TypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02563);
            rule__TypeRule__Group__1();

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
    // $ANTLR end "rule__TypeRule__Group__0"


    // $ANTLR start "rule__TypeRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1264:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1268:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1269:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1269:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1270:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1271:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==34) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1271:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2590);
                    rule__TypeRule__PathAssignment_0();

                    state._fsp--;


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
    // $ANTLR end "rule__TypeRule__Group__0__Impl"


    // $ANTLR start "rule__TypeRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1281:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1285:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1286:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12621);
            rule__TypeRule__Group__1__Impl();

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
    // $ANTLR end "rule__TypeRule__Group__1"


    // $ANTLR start "rule__TypeRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1292:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1296:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1297:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1297:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1298:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1299:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1299:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2648);
            rule__TypeRule__TypeAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__TypeRule__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1313:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1317:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1318:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02682);
            rule__MultiplicityRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02685);
            rule__MultiplicityRule__Group__1();

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
    // $ANTLR end "rule__MultiplicityRule__Group__0"


    // $ANTLR start "rule__MultiplicityRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1325:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1329:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1330:1: ( '[' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1330:1: ( '[' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1331:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__MultiplicityRule__Group__0__Impl2713); 
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
    // $ANTLR end "rule__MultiplicityRule__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1344:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1348:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1349:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12744);
            rule__MultiplicityRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12747);
            rule__MultiplicityRule__Group__2();

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
    // $ANTLR end "rule__MultiplicityRule__Group__1"


    // $ANTLR start "rule__MultiplicityRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1356:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1360:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1361:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1361:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1362:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1363:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1363:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2774);
            rule__MultiplicityRule__BoundsAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__MultiplicityRule__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1373:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1377:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1378:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22804);
            rule__MultiplicityRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22807);
            rule__MultiplicityRule__Group__3();

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
    // $ANTLR end "rule__MultiplicityRule__Group__2"


    // $ANTLR start "rule__MultiplicityRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1385:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1389:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1390:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1390:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1391:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1392:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==37) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1392:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2834);
                    rule__MultiplicityRule__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__MultiplicityRule__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1402:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1406:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1407:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32865);
            rule__MultiplicityRule__Group__3__Impl();

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
    // $ANTLR end "rule__MultiplicityRule__Group__3"


    // $ANTLR start "rule__MultiplicityRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1413:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1417:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1418:1: ( ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1418:1: ( ']' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1419:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__MultiplicityRule__Group__3__Impl2893); 
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
    // $ANTLR end "rule__MultiplicityRule__Group__3__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group_2__0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1440:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1444:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1445:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02932);
            rule__MultiplicityRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02935);
            rule__MultiplicityRule__Group_2__1();

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
    // $ANTLR end "rule__MultiplicityRule__Group_2__0"


    // $ANTLR start "rule__MultiplicityRule__Group_2__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1452:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1456:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1457:1: ( '..' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1457:1: ( '..' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1458:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,37,FOLLOW_37_in_rule__MultiplicityRule__Group_2__0__Impl2963); 
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
    // $ANTLR end "rule__MultiplicityRule__Group_2__0__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group_2__1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1471:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1475:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1476:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12994);
            rule__MultiplicityRule__Group_2__1__Impl();

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
    // $ANTLR end "rule__MultiplicityRule__Group_2__1"


    // $ANTLR start "rule__MultiplicityRule__Group_2__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1482:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1486:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1487:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1487:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1488:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1489:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1489:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl3021);
            rule__MultiplicityRule__BoundsAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__MultiplicityRule__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterRule__VisibilityAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1504:1: rule__ParameterRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__ParameterRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1508:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1509:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1509:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1510:1: ruleVisibilityKind
            {
             before(grammarAccess.getParameterRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__ParameterRule__VisibilityAssignment_03060);
            ruleVisibilityKind();

            state._fsp--;

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
    // $ANTLR end "rule__ParameterRule__VisibilityAssignment_0"


    // $ANTLR start "rule__ParameterRule__DirectionAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1519:1: rule__ParameterRule__DirectionAssignment_1 : ( ruleDirection ) ;
    public final void rule__ParameterRule__DirectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1523:1: ( ( ruleDirection ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1524:1: ( ruleDirection )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1524:1: ( ruleDirection )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1525:1: ruleDirection
            {
             before(grammarAccess.getParameterRuleAccess().getDirectionDirectionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDirection_in_rule__ParameterRule__DirectionAssignment_13091);
            ruleDirection();

            state._fsp--;

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
    // $ANTLR end "rule__ParameterRule__DirectionAssignment_1"


    // $ANTLR start "rule__ParameterRule__NameAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1534:1: rule__ParameterRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ParameterRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1538:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1539:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1539:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1540:1: RULE_ID
            {
             before(grammarAccess.getParameterRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParameterRule__NameAssignment_23122); 
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
    // $ANTLR end "rule__ParameterRule__NameAssignment_2"


    // $ANTLR start "rule__ParameterRule__TypeAssignment_4_0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1549:1: rule__ParameterRule__TypeAssignment_4_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1553:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1554:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1554:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1555:1: ruleTypeRule
            {
             before(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__ParameterRule__TypeAssignment_4_03153);
            ruleTypeRule();

            state._fsp--;

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
    // $ANTLR end "rule__ParameterRule__TypeAssignment_4_0"


    // $ANTLR start "rule__ParameterRule__MultiplicityAssignment_5"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1564:1: rule__ParameterRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__ParameterRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1568:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1569:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1569:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1570:1: ruleMultiplicityRule
            {
             before(grammarAccess.getParameterRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__ParameterRule__MultiplicityAssignment_53184);
            ruleMultiplicityRule();

            state._fsp--;

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
    // $ANTLR end "rule__ParameterRule__MultiplicityAssignment_5"


    // $ANTLR start "rule__ParameterRule__ModifiersAssignment_6"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1579:1: rule__ParameterRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__ParameterRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1583:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1584:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1584:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1585:1: ruleModifiersRule
            {
             before(grammarAccess.getParameterRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__ParameterRule__ModifiersAssignment_63215);
            ruleModifiersRule();

            state._fsp--;

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
    // $ANTLR end "rule__ParameterRule__ModifiersAssignment_6"


    // $ANTLR start "rule__ParameterRule__EffectAssignment_7"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1594:1: rule__ParameterRule__EffectAssignment_7 : ( ruleEffectRule ) ;
    public final void rule__ParameterRule__EffectAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1598:1: ( ( ruleEffectRule ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1599:1: ( ruleEffectRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1599:1: ( ruleEffectRule )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1600:1: ruleEffectRule
            {
             before(grammarAccess.getParameterRuleAccess().getEffectEffectRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEffectRule_in_rule__ParameterRule__EffectAssignment_73246);
            ruleEffectRule();

            state._fsp--;

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
    // $ANTLR end "rule__ParameterRule__EffectAssignment_7"


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1609:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1613:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1614:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1614:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1615:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13277);
            ruleModifierSpecification();

            state._fsp--;

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
    // $ANTLR end "rule__ModifiersRule__ValuesAssignment_1"


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_2_1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1624:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1628:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1629:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1629:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1630:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13308);
            ruleModifierSpecification();

            state._fsp--;

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
    // $ANTLR end "rule__ModifiersRule__ValuesAssignment_2_1"


    // $ANTLR start "rule__ModifierSpecification__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1639:1: rule__ModifierSpecification__ValueAssignment : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1643:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1644:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1644:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1645:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment3339);
            ruleModifierKind();

            state._fsp--;

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
    // $ANTLR end "rule__ModifierSpecification__ValueAssignment"


    // $ANTLR start "rule__EffectRule__EffectKindAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1654:1: rule__EffectRule__EffectKindAssignment_2 : ( ruleEffectKind ) ;
    public final void rule__EffectRule__EffectKindAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1658:1: ( ( ruleEffectKind ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1659:1: ( ruleEffectKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1659:1: ( ruleEffectKind )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1660:1: ruleEffectKind
            {
             before(grammarAccess.getEffectRuleAccess().getEffectKindEffectKindEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEffectKind_in_rule__EffectRule__EffectKindAssignment_23370);
            ruleEffectKind();

            state._fsp--;

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
    // $ANTLR end "rule__EffectRule__EffectKindAssignment_2"


    // $ANTLR start "rule__QualifiedName__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1669:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1673:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1674:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1674:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1675:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1676:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1677:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03405); 
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1688:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1692:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1693:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1693:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1694:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23440);
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


    // $ANTLR start "rule__TypeRule__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1703:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1707:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1708:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1708:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1709:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03471);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "rule__TypeRule__PathAssignment_0"


    // $ANTLR start "rule__TypeRule__TypeAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1718:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1722:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1723:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1723:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1724:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeTypeCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1725:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1726:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13506); 
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
    // $ANTLR end "rule__TypeRule__TypeAssignment_1"


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1737:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1741:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1743:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13541);
            ruleBoundSpecification();

            state._fsp--;

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
    // $ANTLR end "rule__MultiplicityRule__BoundsAssignment_1"


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_2_1"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1752:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1756:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1757:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1757:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1758:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13572);
            ruleBoundSpecification();

            state._fsp--;

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
    // $ANTLR end "rule__MultiplicityRule__BoundsAssignment_2_1"


    // $ANTLR start "rule__BoundSpecification__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1767:1: rule__BoundSpecification__ValueAssignment : ( ruleUnlimitedLiteral ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1771:1: ( ( ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1772:1: ( ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1772:1: ( ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1773:1: ruleUnlimitedLiteral
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3603);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoundSpecification__ValueAssignment"

    // Delegated rules


 

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
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectKind__Alternatives_in_ruleEffectKind647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Direction__Alternatives_in_ruleDirection719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__TypeAssignment_4_0_in_rule__ParameterRule__Alternatives_4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ParameterRule__Alternatives_4773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__UnlimitedLiteral__Alternatives825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ModifierKind__Alternatives860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ModifierKind__Alternatives881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ModifierKind__Alternatives902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ModifierKind__Alternatives923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__EffectKind__Alternatives959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__EffectKind__Alternatives980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__EffectKind__Alternatives1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__EffectKind__Alternatives1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__VisibilityKind__Alternatives1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__VisibilityKind__Alternatives1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__VisibilityKind__Alternatives1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__VisibilityKind__Alternatives1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Direction__Alternatives1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Direction__Alternatives1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Direction__Alternatives1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Direction__Alternatives1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__0__Impl_in_rule__ParameterRule__Group__01253 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__1_in_rule__ParameterRule__Group__01256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__VisibilityAssignment_0_in_rule__ParameterRule__Group__0__Impl1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__1__Impl_in_rule__ParameterRule__Group__11313 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__2_in_rule__ParameterRule__Group__11316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__DirectionAssignment_1_in_rule__ParameterRule__Group__1__Impl1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__2__Impl_in_rule__ParameterRule__Group__21373 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__3_in_rule__ParameterRule__Group__21376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__NameAssignment_2_in_rule__ParameterRule__Group__2__Impl1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__3__Impl_in_rule__ParameterRule__Group__31433 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__4_in_rule__ParameterRule__Group__31436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ParameterRule__Group__3__Impl1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__4__Impl_in_rule__ParameterRule__Group__41495 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__5_in_rule__ParameterRule__Group__41498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Alternatives_4_in_rule__ParameterRule__Group__4__Impl1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__5__Impl_in_rule__ParameterRule__Group__51555 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__6_in_rule__ParameterRule__Group__51558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__MultiplicityAssignment_5_in_rule__ParameterRule__Group__5__Impl1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__6__Impl_in_rule__ParameterRule__Group__61616 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__7_in_rule__ParameterRule__Group__61619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__ModifiersAssignment_6_in_rule__ParameterRule__Group__6__Impl1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__7__Impl_in_rule__ParameterRule__Group__71677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__EffectAssignment_7_in_rule__ParameterRule__Group__7__Impl1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01750 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ModifiersRule__Group__0__Impl1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11812 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__21872 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__21875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl1902 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__31933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ModifiersRule__Group__3__Impl1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02000 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ModifiersRule__Group_2__0__Impl2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__0__Impl_in_rule__EffectRule__Group__02123 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__1_in_rule__EffectRule__Group__02126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EffectRule__Group__0__Impl2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__1__Impl_in_rule__EffectRule__Group__12185 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__2_in_rule__EffectRule__Group__12188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EffectRule__Group__1__Impl2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__2__Impl_in_rule__EffectRule__Group__22247 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__3_in_rule__EffectRule__Group__22250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__EffectKindAssignment_2_in_rule__EffectRule__Group__2__Impl2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__3__Impl_in_rule__EffectRule__Group__32307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EffectRule__Group__3__Impl2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02374 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12434 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__QualifiedName__Group__1__Impl2465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02560 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02682 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__MultiplicityRule__Group__0__Impl2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12744 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22804 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__MultiplicityRule__Group__3__Impl2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02932 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__MultiplicityRule__Group_2__0__Impl2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__ParameterRule__VisibilityAssignment_03060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_rule__ParameterRule__DirectionAssignment_13091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParameterRule__NameAssignment_23122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__ParameterRule__TypeAssignment_4_03153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__ParameterRule__MultiplicityAssignment_53184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__ParameterRule__ModifiersAssignment_63215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_rule__ParameterRule__EffectAssignment_73246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectKind_in_rule__EffectRule__EffectKindAssignment_23370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3603 = new BitSet(new long[]{0x0000000000000002L});

}