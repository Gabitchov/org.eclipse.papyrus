package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPortParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_INTEGER_VALUE", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'*'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "':'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'redefines'", "'subsets'", "'='", "'/'"
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
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_INTEGER_VALUE=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalUmlPortParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlPortParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlPortParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g"; }


     
     	private UmlPortGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlPortGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRulePortRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:60:1: entryRulePortRule : rulePortRule EOF ;
    public final void entryRulePortRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:61:1: ( rulePortRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:62:1: rulePortRule EOF
            {
             before(grammarAccess.getPortRuleRule()); 
            pushFollow(FOLLOW_rulePortRule_in_entryRulePortRule61);
            rulePortRule();

            state._fsp--;

             after(grammarAccess.getPortRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortRule68); 

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
    // $ANTLR end "entryRulePortRule"


    // $ANTLR start "rulePortRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:69:1: rulePortRule : ( ( rule__PortRule__Group__0 ) ) ;
    public final void rulePortRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:73:2: ( ( ( rule__PortRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:74:1: ( ( rule__PortRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:74:1: ( ( rule__PortRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:75:1: ( rule__PortRule__Group__0 )
            {
             before(grammarAccess.getPortRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:76:1: ( rule__PortRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:76:2: rule__PortRule__Group__0
            {
            pushFollow(FOLLOW_rule__PortRule__Group__0_in_rulePortRule94);
            rule__PortRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePortRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:88:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:89:1: ( ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:90:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule121);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getTypeRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule128); 

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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:97:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:101:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:102:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:102:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:103:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:104:1: ( rule__TypeRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:104:2: rule__TypeRule__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule154);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:116:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:117:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:118:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:125:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:129:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:131:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:132:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:132:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214);
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


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:144:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:145:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:146:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule241);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule248); 

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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:153:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:157:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:158:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:158:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:159:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:160:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:160:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule274);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:172:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:173:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:174:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification301);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification308); 

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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:181:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:185:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:186:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:186:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:187:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:188:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:188:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification334);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:200:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
    public final void entryRuleUnlimitedLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:201:1: ( ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:202:1: ruleUnlimitedLiteral EOF
            {
             before(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral361);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getUnlimitedLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral368); 

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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:209:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
    public final void ruleUnlimitedLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:213:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:214:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:214:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:215:1: ( rule__UnlimitedLiteral__Alternatives )
            {
             before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:216:1: ( rule__UnlimitedLiteral__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:216:2: rule__UnlimitedLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral394);
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


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:228:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:229:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:230:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule421);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getModifiersRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule428); 

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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:237:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:241:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:242:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:242:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:243:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:244:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:244:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule454);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:256:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:257:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:258:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification481);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification488); 

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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:265:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__Alternatives ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:269:2: ( ( ( rule__ModifierSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:270:1: ( ( rule__ModifierSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:270:1: ( ( rule__ModifierSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:271:1: ( rule__ModifierSpecification__Alternatives )
            {
             before(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:272:1: ( rule__ModifierSpecification__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:272:2: rule__ModifierSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification514);
            rule__ModifierSpecification__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleRedefinesRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:284:1: entryRuleRedefinesRule : ruleRedefinesRule EOF ;
    public final void entryRuleRedefinesRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:285:1: ( ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:286:1: ruleRedefinesRule EOF
            {
             before(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule541);
            ruleRedefinesRule();

            state._fsp--;

             after(grammarAccess.getRedefinesRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule548); 

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
    // $ANTLR end "entryRuleRedefinesRule"


    // $ANTLR start "ruleRedefinesRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:293:1: ruleRedefinesRule : ( ( rule__RedefinesRule__Group__0 ) ) ;
    public final void ruleRedefinesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:297:2: ( ( ( rule__RedefinesRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:298:1: ( ( rule__RedefinesRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:298:1: ( ( rule__RedefinesRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:299:1: ( rule__RedefinesRule__Group__0 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:300:1: ( rule__RedefinesRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:300:2: rule__RedefinesRule__Group__0
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule574);
            rule__RedefinesRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRedefinesRule"


    // $ANTLR start "entryRuleSubsetsRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:312:1: entryRuleSubsetsRule : ruleSubsetsRule EOF ;
    public final void entryRuleSubsetsRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:313:1: ( ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:314:1: ruleSubsetsRule EOF
            {
             before(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule601);
            ruleSubsetsRule();

            state._fsp--;

             after(grammarAccess.getSubsetsRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule608); 

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
    // $ANTLR end "entryRuleSubsetsRule"


    // $ANTLR start "ruleSubsetsRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:321:1: ruleSubsetsRule : ( ( rule__SubsetsRule__Group__0 ) ) ;
    public final void ruleSubsetsRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:325:2: ( ( ( rule__SubsetsRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:326:1: ( ( rule__SubsetsRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:326:1: ( ( rule__SubsetsRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:327:1: ( rule__SubsetsRule__Group__0 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:328:1: ( rule__SubsetsRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:328:2: rule__SubsetsRule__Group__0
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule634);
            rule__SubsetsRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubsetsRule"


    // $ANTLR start "entryRuleDefaultValueRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:340:1: entryRuleDefaultValueRule : ruleDefaultValueRule EOF ;
    public final void entryRuleDefaultValueRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:341:1: ( ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:342:1: ruleDefaultValueRule EOF
            {
             before(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule661);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getDefaultValueRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule668); 

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
    // $ANTLR end "entryRuleDefaultValueRule"


    // $ANTLR start "ruleDefaultValueRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:349:1: ruleDefaultValueRule : ( ( rule__DefaultValueRule__Group__0 ) ) ;
    public final void ruleDefaultValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:353:2: ( ( ( rule__DefaultValueRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:354:1: ( ( rule__DefaultValueRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:354:1: ( ( rule__DefaultValueRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:355:1: ( rule__DefaultValueRule__Group__0 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:356:1: ( rule__DefaultValueRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:356:2: rule__DefaultValueRule__Group__0
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule694);
            rule__DefaultValueRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDefaultValueRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefaultValueRule"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:369:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:373:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:374:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:374:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:375:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:376:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:376:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind731);
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


    // $ANTLR start "ruleModifierKind"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:388:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:392:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:393:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:393:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:394:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:395:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:395:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind767);
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


    // $ANTLR start "rule__PortRule__Alternatives_5"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:406:1: rule__PortRule__Alternatives_5 : ( ( ( rule__PortRule__TypeAssignment_5_0 ) ) | ( '<Undefined>' ) );
    public final void rule__PortRule__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:410:1: ( ( ( rule__PortRule__TypeAssignment_5_0 ) ) | ( '<Undefined>' ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:411:1: ( ( rule__PortRule__TypeAssignment_5_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:411:1: ( ( rule__PortRule__TypeAssignment_5_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:412:1: ( rule__PortRule__TypeAssignment_5_0 )
                    {
                     before(grammarAccess.getPortRuleAccess().getTypeAssignment_5_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:413:1: ( rule__PortRule__TypeAssignment_5_0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:413:2: rule__PortRule__TypeAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__PortRule__TypeAssignment_5_0_in_rule__PortRule__Alternatives_5802);
                    rule__PortRule__TypeAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPortRuleAccess().getTypeAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:417:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:417:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:418:1: '<Undefined>'
                    {
                     before(grammarAccess.getPortRuleAccess().getUndefinedKeyword_5_1()); 
                    match(input,12,FOLLOW_12_in_rule__PortRule__Alternatives_5821); 
                     after(grammarAccess.getPortRuleAccess().getUndefinedKeyword_5_1()); 

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
    // $ANTLR end "rule__PortRule__Alternatives_5"


    // $ANTLR start "rule__UnlimitedLiteral__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:430:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:434:1: ( ( RULE_INT ) | ( '*' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:435:1: ( RULE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:435:1: ( RULE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:436:1: RULE_INT
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives855); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:441:6: ( '*' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:441:6: ( '*' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:442:1: '*'
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__UnlimitedLiteral__Alternatives873); 
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


    // $ANTLR start "rule__ModifierSpecification__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:454:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );
    public final void rule__ModifierSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:458:1: ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 18:
            case 19:
            case 20:
            case 21:
                {
                alt3=1;
                }
                break;
            case 30:
                {
                alt3=2;
                }
                break;
            case 31:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:459:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:459:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:460:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:461:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:461:2: rule__ModifierSpecification__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives907);
                    rule__ModifierSpecification__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:465:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:465:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:466:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:467:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:467:2: rule__ModifierSpecification__RedefinesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives925);
                    rule__ModifierSpecification__RedefinesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:471:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:471:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:472:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:473:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:473:2: rule__ModifierSpecification__SubsetsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives943);
                    rule__ModifierSpecification__SubsetsAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 

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
    // $ANTLR end "rule__ModifierSpecification__Alternatives"


    // $ANTLR start "rule__VisibilityKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:482:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:486:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt4=1;
                }
                break;
            case 15:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                alt4=3;
                }
                break;
            case 17:
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
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:487:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:487:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:488:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:489:1: ( '+' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:489:3: '+'
                    {
                    match(input,14,FOLLOW_14_in_rule__VisibilityKind__Alternatives977); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:494:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:494:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:495:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:496:1: ( '-' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:496:3: '-'
                    {
                    match(input,15,FOLLOW_15_in_rule__VisibilityKind__Alternatives998); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:501:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:501:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:502:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:503:1: ( '#' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:503:3: '#'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives1019); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:508:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:508:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:509:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:510:1: ( '~' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:510:3: '~'
                    {
                    match(input,17,FOLLOW_17_in_rule__VisibilityKind__Alternatives1040); 

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


    // $ANTLR start "rule__ModifierKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:520:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:524:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt5=1;
                }
                break;
            case 19:
                {
                alt5=2;
                }
                break;
            case 20:
                {
                alt5=3;
                }
                break;
            case 21:
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
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:525:1: ( ( 'readOnly' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:525:1: ( ( 'readOnly' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:526:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:527:1: ( 'readOnly' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:527:3: 'readOnly'
                    {
                    match(input,18,FOLLOW_18_in_rule__ModifierKind__Alternatives1076); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:532:6: ( ( 'union' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:532:6: ( ( 'union' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:533:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:534:1: ( 'union' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:534:3: 'union'
                    {
                    match(input,19,FOLLOW_19_in_rule__ModifierKind__Alternatives1097); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:539:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:539:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:540:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:541:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:541:3: 'ordered'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives1118); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:546:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:546:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:547:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:548:1: ( 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:548:3: 'unique'
                    {
                    match(input,21,FOLLOW_21_in_rule__ModifierKind__Alternatives1139); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 

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


    // $ANTLR start "rule__PortRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:560:1: rule__PortRule__Group__0 : rule__PortRule__Group__0__Impl rule__PortRule__Group__1 ;
    public final void rule__PortRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:564:1: ( rule__PortRule__Group__0__Impl rule__PortRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:565:2: rule__PortRule__Group__0__Impl rule__PortRule__Group__1
            {
            pushFollow(FOLLOW_rule__PortRule__Group__0__Impl_in_rule__PortRule__Group__01172);
            rule__PortRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__1_in_rule__PortRule__Group__01175);
            rule__PortRule__Group__1();

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
    // $ANTLR end "rule__PortRule__Group__0"


    // $ANTLR start "rule__PortRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:572:1: rule__PortRule__Group__0__Impl : ( ( rule__PortRule__VisibilityAssignment_0 ) ) ;
    public final void rule__PortRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:576:1: ( ( ( rule__PortRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:577:1: ( ( rule__PortRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:577:1: ( ( rule__PortRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:578:1: ( rule__PortRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getPortRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:579:1: ( rule__PortRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:579:2: rule__PortRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__PortRule__VisibilityAssignment_0_in_rule__PortRule__Group__0__Impl1202);
            rule__PortRule__VisibilityAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getVisibilityAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__0__Impl"


    // $ANTLR start "rule__PortRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:589:1: rule__PortRule__Group__1 : rule__PortRule__Group__1__Impl rule__PortRule__Group__2 ;
    public final void rule__PortRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:593:1: ( rule__PortRule__Group__1__Impl rule__PortRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:594:2: rule__PortRule__Group__1__Impl rule__PortRule__Group__2
            {
            pushFollow(FOLLOW_rule__PortRule__Group__1__Impl_in_rule__PortRule__Group__11232);
            rule__PortRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__2_in_rule__PortRule__Group__11235);
            rule__PortRule__Group__2();

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
    // $ANTLR end "rule__PortRule__Group__1"


    // $ANTLR start "rule__PortRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:601:1: rule__PortRule__Group__1__Impl : ( ( rule__PortRule__IsDerivedAssignment_1 )? ) ;
    public final void rule__PortRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:605:1: ( ( ( rule__PortRule__IsDerivedAssignment_1 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:606:1: ( ( rule__PortRule__IsDerivedAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:606:1: ( ( rule__PortRule__IsDerivedAssignment_1 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:607:1: ( rule__PortRule__IsDerivedAssignment_1 )?
            {
             before(grammarAccess.getPortRuleAccess().getIsDerivedAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:608:1: ( rule__PortRule__IsDerivedAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==33) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:608:2: rule__PortRule__IsDerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PortRule__IsDerivedAssignment_1_in_rule__PortRule__Group__1__Impl1262);
                    rule__PortRule__IsDerivedAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getIsDerivedAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__1__Impl"


    // $ANTLR start "rule__PortRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:618:1: rule__PortRule__Group__2 : rule__PortRule__Group__2__Impl rule__PortRule__Group__3 ;
    public final void rule__PortRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:622:1: ( rule__PortRule__Group__2__Impl rule__PortRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:623:2: rule__PortRule__Group__2__Impl rule__PortRule__Group__3
            {
            pushFollow(FOLLOW_rule__PortRule__Group__2__Impl_in_rule__PortRule__Group__21293);
            rule__PortRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__3_in_rule__PortRule__Group__21296);
            rule__PortRule__Group__3();

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
    // $ANTLR end "rule__PortRule__Group__2"


    // $ANTLR start "rule__PortRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:630:1: rule__PortRule__Group__2__Impl : ( ( rule__PortRule__NameAssignment_2 ) ) ;
    public final void rule__PortRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:634:1: ( ( ( rule__PortRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:635:1: ( ( rule__PortRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:635:1: ( ( rule__PortRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:636:1: ( rule__PortRule__NameAssignment_2 )
            {
             before(grammarAccess.getPortRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:637:1: ( rule__PortRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:637:2: rule__PortRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PortRule__NameAssignment_2_in_rule__PortRule__Group__2__Impl1323);
            rule__PortRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__2__Impl"


    // $ANTLR start "rule__PortRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:647:1: rule__PortRule__Group__3 : rule__PortRule__Group__3__Impl rule__PortRule__Group__4 ;
    public final void rule__PortRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:651:1: ( rule__PortRule__Group__3__Impl rule__PortRule__Group__4 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:652:2: rule__PortRule__Group__3__Impl rule__PortRule__Group__4
            {
            pushFollow(FOLLOW_rule__PortRule__Group__3__Impl_in_rule__PortRule__Group__31353);
            rule__PortRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__4_in_rule__PortRule__Group__31356);
            rule__PortRule__Group__4();

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
    // $ANTLR end "rule__PortRule__Group__3"


    // $ANTLR start "rule__PortRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:659:1: rule__PortRule__Group__3__Impl : ( ':' ) ;
    public final void rule__PortRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:663:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:664:1: ( ':' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:664:1: ( ':' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:665:1: ':'
            {
             before(grammarAccess.getPortRuleAccess().getColonKeyword_3()); 
            match(input,22,FOLLOW_22_in_rule__PortRule__Group__3__Impl1384); 
             after(grammarAccess.getPortRuleAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__3__Impl"


    // $ANTLR start "rule__PortRule__Group__4"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:678:1: rule__PortRule__Group__4 : rule__PortRule__Group__4__Impl rule__PortRule__Group__5 ;
    public final void rule__PortRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:682:1: ( rule__PortRule__Group__4__Impl rule__PortRule__Group__5 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:683:2: rule__PortRule__Group__4__Impl rule__PortRule__Group__5
            {
            pushFollow(FOLLOW_rule__PortRule__Group__4__Impl_in_rule__PortRule__Group__41415);
            rule__PortRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__5_in_rule__PortRule__Group__41418);
            rule__PortRule__Group__5();

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
    // $ANTLR end "rule__PortRule__Group__4"


    // $ANTLR start "rule__PortRule__Group__4__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:690:1: rule__PortRule__Group__4__Impl : ( ( rule__PortRule__IsConjugatedAssignment_4 )? ) ;
    public final void rule__PortRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:694:1: ( ( ( rule__PortRule__IsConjugatedAssignment_4 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:695:1: ( ( rule__PortRule__IsConjugatedAssignment_4 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:695:1: ( ( rule__PortRule__IsConjugatedAssignment_4 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:696:1: ( rule__PortRule__IsConjugatedAssignment_4 )?
            {
             before(grammarAccess.getPortRuleAccess().getIsConjugatedAssignment_4()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:697:1: ( rule__PortRule__IsConjugatedAssignment_4 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:697:2: rule__PortRule__IsConjugatedAssignment_4
                    {
                    pushFollow(FOLLOW_rule__PortRule__IsConjugatedAssignment_4_in_rule__PortRule__Group__4__Impl1445);
                    rule__PortRule__IsConjugatedAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getIsConjugatedAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__4__Impl"


    // $ANTLR start "rule__PortRule__Group__5"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:707:1: rule__PortRule__Group__5 : rule__PortRule__Group__5__Impl rule__PortRule__Group__6 ;
    public final void rule__PortRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:711:1: ( rule__PortRule__Group__5__Impl rule__PortRule__Group__6 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:712:2: rule__PortRule__Group__5__Impl rule__PortRule__Group__6
            {
            pushFollow(FOLLOW_rule__PortRule__Group__5__Impl_in_rule__PortRule__Group__51476);
            rule__PortRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__6_in_rule__PortRule__Group__51479);
            rule__PortRule__Group__6();

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
    // $ANTLR end "rule__PortRule__Group__5"


    // $ANTLR start "rule__PortRule__Group__5__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:719:1: rule__PortRule__Group__5__Impl : ( ( rule__PortRule__Alternatives_5 ) ) ;
    public final void rule__PortRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:723:1: ( ( ( rule__PortRule__Alternatives_5 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:724:1: ( ( rule__PortRule__Alternatives_5 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:724:1: ( ( rule__PortRule__Alternatives_5 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:725:1: ( rule__PortRule__Alternatives_5 )
            {
             before(grammarAccess.getPortRuleAccess().getAlternatives_5()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:726:1: ( rule__PortRule__Alternatives_5 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:726:2: rule__PortRule__Alternatives_5
            {
            pushFollow(FOLLOW_rule__PortRule__Alternatives_5_in_rule__PortRule__Group__5__Impl1506);
            rule__PortRule__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__5__Impl"


    // $ANTLR start "rule__PortRule__Group__6"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:736:1: rule__PortRule__Group__6 : rule__PortRule__Group__6__Impl rule__PortRule__Group__7 ;
    public final void rule__PortRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:740:1: ( rule__PortRule__Group__6__Impl rule__PortRule__Group__7 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:741:2: rule__PortRule__Group__6__Impl rule__PortRule__Group__7
            {
            pushFollow(FOLLOW_rule__PortRule__Group__6__Impl_in_rule__PortRule__Group__61536);
            rule__PortRule__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__7_in_rule__PortRule__Group__61539);
            rule__PortRule__Group__7();

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
    // $ANTLR end "rule__PortRule__Group__6"


    // $ANTLR start "rule__PortRule__Group__6__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:748:1: rule__PortRule__Group__6__Impl : ( ( rule__PortRule__MultiplicityAssignment_6 )? ) ;
    public final void rule__PortRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:752:1: ( ( ( rule__PortRule__MultiplicityAssignment_6 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:753:1: ( ( rule__PortRule__MultiplicityAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:753:1: ( ( rule__PortRule__MultiplicityAssignment_6 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:754:1: ( rule__PortRule__MultiplicityAssignment_6 )?
            {
             before(grammarAccess.getPortRuleAccess().getMultiplicityAssignment_6()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:755:1: ( rule__PortRule__MultiplicityAssignment_6 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:755:2: rule__PortRule__MultiplicityAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PortRule__MultiplicityAssignment_6_in_rule__PortRule__Group__6__Impl1566);
                    rule__PortRule__MultiplicityAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getMultiplicityAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__6__Impl"


    // $ANTLR start "rule__PortRule__Group__7"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:765:1: rule__PortRule__Group__7 : rule__PortRule__Group__7__Impl rule__PortRule__Group__8 ;
    public final void rule__PortRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:769:1: ( rule__PortRule__Group__7__Impl rule__PortRule__Group__8 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:770:2: rule__PortRule__Group__7__Impl rule__PortRule__Group__8
            {
            pushFollow(FOLLOW_rule__PortRule__Group__7__Impl_in_rule__PortRule__Group__71597);
            rule__PortRule__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__8_in_rule__PortRule__Group__71600);
            rule__PortRule__Group__8();

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
    // $ANTLR end "rule__PortRule__Group__7"


    // $ANTLR start "rule__PortRule__Group__7__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:777:1: rule__PortRule__Group__7__Impl : ( ( rule__PortRule__ModifiersAssignment_7 )? ) ;
    public final void rule__PortRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:781:1: ( ( ( rule__PortRule__ModifiersAssignment_7 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:782:1: ( ( rule__PortRule__ModifiersAssignment_7 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:782:1: ( ( rule__PortRule__ModifiersAssignment_7 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:783:1: ( rule__PortRule__ModifiersAssignment_7 )?
            {
             before(grammarAccess.getPortRuleAccess().getModifiersAssignment_7()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:784:1: ( rule__PortRule__ModifiersAssignment_7 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:784:2: rule__PortRule__ModifiersAssignment_7
                    {
                    pushFollow(FOLLOW_rule__PortRule__ModifiersAssignment_7_in_rule__PortRule__Group__7__Impl1627);
                    rule__PortRule__ModifiersAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getModifiersAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__7__Impl"


    // $ANTLR start "rule__PortRule__Group__8"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:794:1: rule__PortRule__Group__8 : rule__PortRule__Group__8__Impl ;
    public final void rule__PortRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:798:1: ( rule__PortRule__Group__8__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:799:2: rule__PortRule__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__PortRule__Group__8__Impl_in_rule__PortRule__Group__81658);
            rule__PortRule__Group__8__Impl();

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
    // $ANTLR end "rule__PortRule__Group__8"


    // $ANTLR start "rule__PortRule__Group__8__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:805:1: rule__PortRule__Group__8__Impl : ( ( rule__PortRule__DefaultAssignment_8 )? ) ;
    public final void rule__PortRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:809:1: ( ( ( rule__PortRule__DefaultAssignment_8 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:810:1: ( ( rule__PortRule__DefaultAssignment_8 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:810:1: ( ( rule__PortRule__DefaultAssignment_8 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:811:1: ( rule__PortRule__DefaultAssignment_8 )?
            {
             before(grammarAccess.getPortRuleAccess().getDefaultAssignment_8()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:812:1: ( rule__PortRule__DefaultAssignment_8 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==32) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:812:2: rule__PortRule__DefaultAssignment_8
                    {
                    pushFollow(FOLLOW_rule__PortRule__DefaultAssignment_8_in_rule__PortRule__Group__8__Impl1685);
                    rule__PortRule__DefaultAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getDefaultAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__Group__8__Impl"


    // $ANTLR start "rule__TypeRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:840:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:844:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:845:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01734);
            rule__TypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01737);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:852:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:856:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:857:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:857:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:858:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:859:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==23) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:859:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1764);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:869:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:873:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:874:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11795);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:880:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:884:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:885:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:885:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:886:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:887:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:887:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1822);
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:901:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:905:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:906:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01856);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01859);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:913:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:917:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:918:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:918:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:919:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:920:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:920:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1886);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:930:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:934:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:935:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11916);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11919);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:942:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:946:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:947:1: ( '::' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:947:1: ( '::' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:948:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__QualifiedName__Group__1__Impl1947); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:961:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:965:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:966:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21978);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:972:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:976:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:977:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:977:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:978:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:979:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==23) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:979:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2005);
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


    // $ANTLR start "rule__MultiplicityRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:995:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:999:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1000:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02042);
            rule__MultiplicityRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02045);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1007:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1011:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1012:1: ( '[' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1012:1: ( '[' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1013:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MultiplicityRule__Group__0__Impl2073); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1026:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1030:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1031:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12104);
            rule__MultiplicityRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12107);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1038:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1042:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1043:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1043:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1044:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1045:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1045:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2134);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1055:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1059:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1060:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22164);
            rule__MultiplicityRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22167);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1067:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1071:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1072:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1072:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1073:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1074:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1074:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2194);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1084:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1088:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1089:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32225);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1095:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1099:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1100:1: ( ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1100:1: ( ']' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1101:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__MultiplicityRule__Group__3__Impl2253); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1122:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1126:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1127:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02292);
            rule__MultiplicityRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02295);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1134:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1138:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1139:1: ( '..' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1139:1: ( '..' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1140:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__MultiplicityRule__Group_2__0__Impl2323); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1153:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1157:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1158:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12354);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1164:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1168:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1169:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1169:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1170:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1171:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1171:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2381);
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


    // $ANTLR start "rule__ModifiersRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1185:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1189:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1190:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02415);
            rule__ModifiersRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02418);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1197:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1201:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1202:1: ( '{' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1202:1: ( '{' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1203:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__ModifiersRule__Group__0__Impl2446); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1216:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1220:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1221:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12477);
            rule__ModifiersRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12480);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1228:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1232:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1233:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1233:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1234:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1235:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1235:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2507);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1245:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1249:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1250:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22537);
            rule__ModifiersRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22540);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1257:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1261:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1262:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1262:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1263:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1264:1: ( rule__ModifiersRule__Group_2__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1264:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2567);
            	    rule__ModifiersRule__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1274:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1278:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1279:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32598);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1285:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1289:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1290:1: ( '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1290:1: ( '}' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1291:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__ModifiersRule__Group__3__Impl2626); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1312:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1316:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1317:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02665);
            rule__ModifiersRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02668);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1324:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1328:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1329:1: ( ',' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1329:1: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1330:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,29,FOLLOW_29_in_rule__ModifiersRule__Group_2__0__Impl2696); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1343:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1347:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1348:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12727);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1354:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1358:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1359:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1359:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1360:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1361:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1361:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2754);
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


    // $ANTLR start "rule__RedefinesRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1375:1: rule__RedefinesRule__Group__0 : rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 ;
    public final void rule__RedefinesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1379:1: ( rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1380:2: rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__02788);
            rule__RedefinesRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__02791);
            rule__RedefinesRule__Group__1();

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
    // $ANTLR end "rule__RedefinesRule__Group__0"


    // $ANTLR start "rule__RedefinesRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1387:1: rule__RedefinesRule__Group__0__Impl : ( 'redefines' ) ;
    public final void rule__RedefinesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1391:1: ( ( 'redefines' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1392:1: ( 'redefines' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1392:1: ( 'redefines' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1393:1: 'redefines'
            {
             before(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__RedefinesRule__Group__0__Impl2819); 
             after(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__Group__0__Impl"


    // $ANTLR start "rule__RedefinesRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1406:1: rule__RedefinesRule__Group__1 : rule__RedefinesRule__Group__1__Impl ;
    public final void rule__RedefinesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1410:1: ( rule__RedefinesRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1411:2: rule__RedefinesRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__12850);
            rule__RedefinesRule__Group__1__Impl();

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
    // $ANTLR end "rule__RedefinesRule__Group__1"


    // $ANTLR start "rule__RedefinesRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1417:1: rule__RedefinesRule__Group__1__Impl : ( ( rule__RedefinesRule__PortAssignment_1 ) ) ;
    public final void rule__RedefinesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1421:1: ( ( ( rule__RedefinesRule__PortAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1422:1: ( ( rule__RedefinesRule__PortAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1422:1: ( ( rule__RedefinesRule__PortAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1423:1: ( rule__RedefinesRule__PortAssignment_1 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPortAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1424:1: ( rule__RedefinesRule__PortAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1424:2: rule__RedefinesRule__PortAssignment_1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__PortAssignment_1_in_rule__RedefinesRule__Group__1__Impl2877);
            rule__RedefinesRule__PortAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getPortAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__Group__1__Impl"


    // $ANTLR start "rule__SubsetsRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1438:1: rule__SubsetsRule__Group__0 : rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 ;
    public final void rule__SubsetsRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1442:1: ( rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1443:2: rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__02911);
            rule__SubsetsRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__02914);
            rule__SubsetsRule__Group__1();

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
    // $ANTLR end "rule__SubsetsRule__Group__0"


    // $ANTLR start "rule__SubsetsRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1450:1: rule__SubsetsRule__Group__0__Impl : ( 'subsets' ) ;
    public final void rule__SubsetsRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1454:1: ( ( 'subsets' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1455:1: ( 'subsets' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1455:1: ( 'subsets' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1456:1: 'subsets'
            {
             before(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__SubsetsRule__Group__0__Impl2942); 
             after(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__Group__0__Impl"


    // $ANTLR start "rule__SubsetsRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1469:1: rule__SubsetsRule__Group__1 : rule__SubsetsRule__Group__1__Impl ;
    public final void rule__SubsetsRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1473:1: ( rule__SubsetsRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1474:2: rule__SubsetsRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__12973);
            rule__SubsetsRule__Group__1__Impl();

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
    // $ANTLR end "rule__SubsetsRule__Group__1"


    // $ANTLR start "rule__SubsetsRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1480:1: rule__SubsetsRule__Group__1__Impl : ( ( rule__SubsetsRule__PortAssignment_1 ) ) ;
    public final void rule__SubsetsRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1484:1: ( ( ( rule__SubsetsRule__PortAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1485:1: ( ( rule__SubsetsRule__PortAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1485:1: ( ( rule__SubsetsRule__PortAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1486:1: ( rule__SubsetsRule__PortAssignment_1 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPortAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1487:1: ( rule__SubsetsRule__PortAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1487:2: rule__SubsetsRule__PortAssignment_1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__PortAssignment_1_in_rule__SubsetsRule__Group__1__Impl3000);
            rule__SubsetsRule__PortAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getPortAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__Group__1__Impl"


    // $ANTLR start "rule__DefaultValueRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1501:1: rule__DefaultValueRule__Group__0 : rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 ;
    public final void rule__DefaultValueRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1505:1: ( rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1506:2: rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__03034);
            rule__DefaultValueRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__03037);
            rule__DefaultValueRule__Group__1();

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
    // $ANTLR end "rule__DefaultValueRule__Group__0"


    // $ANTLR start "rule__DefaultValueRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1513:1: rule__DefaultValueRule__Group__0__Impl : ( '=' ) ;
    public final void rule__DefaultValueRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1517:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1518:1: ( '=' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1518:1: ( '=' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1519:1: '='
            {
             before(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__DefaultValueRule__Group__0__Impl3065); 
             after(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__Group__0__Impl"


    // $ANTLR start "rule__DefaultValueRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1532:1: rule__DefaultValueRule__Group__1 : rule__DefaultValueRule__Group__1__Impl ;
    public final void rule__DefaultValueRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1536:1: ( rule__DefaultValueRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1537:2: rule__DefaultValueRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__13096);
            rule__DefaultValueRule__Group__1__Impl();

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
    // $ANTLR end "rule__DefaultValueRule__Group__1"


    // $ANTLR start "rule__DefaultValueRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1543:1: rule__DefaultValueRule__Group__1__Impl : ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) ;
    public final void rule__DefaultValueRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1547:1: ( ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1548:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1548:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1549:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1550:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1550:2: rule__DefaultValueRule__DefaultAssignment_1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl3123);
            rule__DefaultValueRule__DefaultAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__Group__1__Impl"


    // $ANTLR start "rule__PortRule__VisibilityAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1565:1: rule__PortRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__PortRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1569:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1570:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1570:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1571:1: ruleVisibilityKind
            {
             before(grammarAccess.getPortRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__PortRule__VisibilityAssignment_03162);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__VisibilityAssignment_0"


    // $ANTLR start "rule__PortRule__IsDerivedAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1580:1: rule__PortRule__IsDerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PortRule__IsDerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1584:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1585:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1585:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1586:1: ( '/' )
            {
             before(grammarAccess.getPortRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1587:1: ( '/' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1588:1: '/'
            {
             before(grammarAccess.getPortRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            match(input,33,FOLLOW_33_in_rule__PortRule__IsDerivedAssignment_13198); 
             after(grammarAccess.getPortRuleAccess().getIsDerivedSolidusKeyword_1_0()); 

            }

             after(grammarAccess.getPortRuleAccess().getIsDerivedSolidusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__IsDerivedAssignment_1"


    // $ANTLR start "rule__PortRule__NameAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1603:1: rule__PortRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PortRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1607:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1608:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1608:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1609:1: RULE_ID
            {
             before(grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PortRule__NameAssignment_23237); 
             after(grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__NameAssignment_2"


    // $ANTLR start "rule__PortRule__IsConjugatedAssignment_4"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1618:1: rule__PortRule__IsConjugatedAssignment_4 : ( ( '~' ) ) ;
    public final void rule__PortRule__IsConjugatedAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1622:1: ( ( ( '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1623:1: ( ( '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1623:1: ( ( '~' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1624:1: ( '~' )
            {
             before(grammarAccess.getPortRuleAccess().getIsConjugatedTildeKeyword_4_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1625:1: ( '~' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1626:1: '~'
            {
             before(grammarAccess.getPortRuleAccess().getIsConjugatedTildeKeyword_4_0()); 
            match(input,17,FOLLOW_17_in_rule__PortRule__IsConjugatedAssignment_43273); 
             after(grammarAccess.getPortRuleAccess().getIsConjugatedTildeKeyword_4_0()); 

            }

             after(grammarAccess.getPortRuleAccess().getIsConjugatedTildeKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__IsConjugatedAssignment_4"


    // $ANTLR start "rule__PortRule__TypeAssignment_5_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1641:1: rule__PortRule__TypeAssignment_5_0 : ( ruleTypeRule ) ;
    public final void rule__PortRule__TypeAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1645:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1646:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1646:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1647:1: ruleTypeRule
            {
             before(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__PortRule__TypeAssignment_5_03312);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__TypeAssignment_5_0"


    // $ANTLR start "rule__PortRule__MultiplicityAssignment_6"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1656:1: rule__PortRule__MultiplicityAssignment_6 : ( ruleMultiplicityRule ) ;
    public final void rule__PortRule__MultiplicityAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1660:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1661:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1661:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1662:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PortRule__MultiplicityAssignment_63343);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__MultiplicityAssignment_6"


    // $ANTLR start "rule__PortRule__ModifiersAssignment_7"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1671:1: rule__PortRule__ModifiersAssignment_7 : ( ruleModifiersRule ) ;
    public final void rule__PortRule__ModifiersAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1675:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1676:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1676:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1677:1: ruleModifiersRule
            {
             before(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PortRule__ModifiersAssignment_73374);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__ModifiersAssignment_7"


    // $ANTLR start "rule__PortRule__DefaultAssignment_8"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1686:1: rule__PortRule__DefaultAssignment_8 : ( ruleDefaultValueRule ) ;
    public final void rule__PortRule__DefaultAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1690:1: ( ( ruleDefaultValueRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1691:1: ( ruleDefaultValueRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1691:1: ( ruleDefaultValueRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1692:1: ruleDefaultValueRule
            {
             before(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_rule__PortRule__DefaultAssignment_83405);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PortRule__DefaultAssignment_8"


    // $ANTLR start "rule__TypeRule__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1701:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1705:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1706:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1706:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1707:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03436);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1716:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1720:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1721:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1721:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1722:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1723:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1724:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13471); 
             after(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__QualifiedName__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1735:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1739:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1740:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1740:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1741:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1742:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1743:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03510); 
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1754:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1758:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1759:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1759:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1760:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23545);
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


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1769:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1773:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1774:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1774:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1775:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13576);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1784:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1788:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1789:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1789:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1790:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13607);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1799:1: rule__BoundSpecification__ValueAssignment : ( ruleUnlimitedLiteral ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1803:1: ( ( ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1804:1: ( ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1804:1: ( ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1805:1: ruleUnlimitedLiteral
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3638);
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


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1814:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1818:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1819:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1819:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1820:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13669);
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
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1829:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1833:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1834:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1834:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1835:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13700);
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


    // $ANTLR start "rule__ModifierSpecification__ValueAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1844:1: rule__ModifierSpecification__ValueAssignment_0 : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1848:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1849:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1849:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1850:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_03731);
            ruleModifierKind();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__ValueAssignment_0"


    // $ANTLR start "rule__ModifierSpecification__RedefinesAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1859:1: rule__ModifierSpecification__RedefinesAssignment_1 : ( ruleRedefinesRule ) ;
    public final void rule__ModifierSpecification__RedefinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1863:1: ( ( ruleRedefinesRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1864:1: ( ruleRedefinesRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1864:1: ( ruleRedefinesRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1865:1: ruleRedefinesRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_13762);
            ruleRedefinesRule();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__RedefinesAssignment_1"


    // $ANTLR start "rule__ModifierSpecification__SubsetsAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1874:1: rule__ModifierSpecification__SubsetsAssignment_2 : ( ruleSubsetsRule ) ;
    public final void rule__ModifierSpecification__SubsetsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1878:1: ( ( ruleSubsetsRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1879:1: ( ruleSubsetsRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1879:1: ( ruleSubsetsRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1880:1: ruleSubsetsRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_23793);
            ruleSubsetsRule();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__SubsetsAssignment_2"


    // $ANTLR start "rule__RedefinesRule__PortAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1889:1: rule__RedefinesRule__PortAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RedefinesRule__PortAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1893:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1894:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1894:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1895:1: ( RULE_ID )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1896:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1897:1: RULE_ID
            {
             before(grammarAccess.getRedefinesRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RedefinesRule__PortAssignment_13828); 
             after(grammarAccess.getRedefinesRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__PortAssignment_1"


    // $ANTLR start "rule__SubsetsRule__PortAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1908:1: rule__SubsetsRule__PortAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubsetsRule__PortAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1912:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1913:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1913:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1914:1: ( RULE_ID )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1915:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1916:1: RULE_ID
            {
             before(grammarAccess.getSubsetsRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubsetsRule__PortAssignment_13867); 
             after(grammarAccess.getSubsetsRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__PortAssignment_1"


    // $ANTLR start "rule__DefaultValueRule__DefaultAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1927:1: rule__DefaultValueRule__DefaultAssignment_1 : ( RULE_STRING ) ;
    public final void rule__DefaultValueRule__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1931:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1932:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1932:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1933:1: RULE_STRING
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_13902); 
             after(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__DefaultAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePortRule_in_entryRulePortRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__0_in_rulePortRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__TypeAssignment_5_0_in_rule__PortRule__Alternatives_5802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PortRule__Alternatives_5821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__UnlimitedLiteral__Alternatives873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VisibilityKind__Alternatives977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VisibilityKind__Alternatives998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__VisibilityKind__Alternatives1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ModifierKind__Alternatives1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ModifierKind__Alternatives1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ModifierKind__Alternatives1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ModifierKind__Alternatives1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__0__Impl_in_rule__PortRule__Group__01172 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__PortRule__Group__1_in_rule__PortRule__Group__01175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__VisibilityAssignment_0_in_rule__PortRule__Group__0__Impl1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__1__Impl_in_rule__PortRule__Group__11232 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__PortRule__Group__2_in_rule__PortRule__Group__11235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__IsDerivedAssignment_1_in_rule__PortRule__Group__1__Impl1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__2__Impl_in_rule__PortRule__Group__21293 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__3_in_rule__PortRule__Group__21296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__NameAssignment_2_in_rule__PortRule__Group__2__Impl1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__3__Impl_in_rule__PortRule__Group__31353 = new BitSet(new long[]{0x0000000000021020L});
    public static final BitSet FOLLOW_rule__PortRule__Group__4_in_rule__PortRule__Group__31356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PortRule__Group__3__Impl1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__4__Impl_in_rule__PortRule__Group__41415 = new BitSet(new long[]{0x0000000000021020L});
    public static final BitSet FOLLOW_rule__PortRule__Group__5_in_rule__PortRule__Group__41418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__IsConjugatedAssignment_4_in_rule__PortRule__Group__4__Impl1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__5__Impl_in_rule__PortRule__Group__51476 = new BitSet(new long[]{0x0000000109000000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__6_in_rule__PortRule__Group__51479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Alternatives_5_in_rule__PortRule__Group__5__Impl1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__6__Impl_in_rule__PortRule__Group__61536 = new BitSet(new long[]{0x0000000109000000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__7_in_rule__PortRule__Group__61539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__MultiplicityAssignment_6_in_rule__PortRule__Group__6__Impl1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__7__Impl_in_rule__PortRule__Group__71597 = new BitSet(new long[]{0x0000000109000000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__8_in_rule__PortRule__Group__71600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__ModifiersAssignment_7_in_rule__PortRule__Group__7__Impl1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__8__Impl_in_rule__PortRule__Group__81658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__DefaultAssignment_8_in_rule__PortRule__Group__8__Impl1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01734 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01856 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11916 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__QualifiedName__Group__1__Impl1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02042 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MultiplicityRule__Group__0__Impl2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12104 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22164 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MultiplicityRule__Group__3__Impl2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02292 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MultiplicityRule__Group_2__0__Impl2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02415 = new BitSet(new long[]{0x00000000C03C0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ModifiersRule__Group__0__Impl2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12477 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22537 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2567 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ModifiersRule__Group__3__Impl2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02665 = new BitSet(new long[]{0x00000000C03C0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ModifiersRule__Group_2__0__Impl2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__02788 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__02791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__RedefinesRule__Group__0__Impl2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__12850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__PortAssignment_1_in_rule__RedefinesRule__Group__1__Impl2877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__02911 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__02914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__SubsetsRule__Group__0__Impl2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__12973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__PortAssignment_1_in_rule__SubsetsRule__Group__1__Impl3000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__03034 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__03037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DefaultValueRule__Group__0__Impl3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__13096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__PortRule__VisibilityAssignment_03162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PortRule__IsDerivedAssignment_13198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PortRule__NameAssignment_23237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__PortRule__IsConjugatedAssignment_43273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__PortRule__TypeAssignment_5_03312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PortRule__MultiplicityAssignment_63343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PortRule__ModifiersAssignment_73374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rule__PortRule__DefaultAssignment_83405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_03731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_13762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_23793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RedefinesRule__PortAssignment_13828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubsetsRule__PortAssignment_13867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_13902 = new BitSet(new long[]{0x0000000000000002L});

}