package org.eclipse.papyrus.uml.textedit.property.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.property.xtext.services.UmlPropertyGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPropertyParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'*'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "':'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'redefines'", "'subsets'", "'='", "'/'"
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
    public static final int RULE_INTEGER_VALUE=9;
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


        public InternalUmlPropertyParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlPropertyParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlPropertyParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g"; }


     
     	private UmlPropertyGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlPropertyGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRulePropertyRule"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:60:1: entryRulePropertyRule : rulePropertyRule EOF ;
    public final void entryRulePropertyRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:61:1: ( rulePropertyRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:62:1: rulePropertyRule EOF
            {
             before(grammarAccess.getPropertyRuleRule()); 
            pushFollow(FOLLOW_rulePropertyRule_in_entryRulePropertyRule61);
            rulePropertyRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyRule68); 

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
    // $ANTLR end "entryRulePropertyRule"


    // $ANTLR start "rulePropertyRule"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:69:1: rulePropertyRule : ( ( rule__PropertyRule__Group__0 ) ) ;
    public final void rulePropertyRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:73:2: ( ( ( rule__PropertyRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:74:1: ( ( rule__PropertyRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:74:1: ( ( rule__PropertyRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:75:1: ( rule__PropertyRule__Group__0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:76:1: ( rule__PropertyRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:76:2: rule__PropertyRule__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0_in_rulePropertyRule94);
            rule__PropertyRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:88:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:89:1: ( ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:90:1: ruleTypeRule EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:97:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:101:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:102:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:102:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:103:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:104:1: ( rule__TypeRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:104:2: rule__TypeRule__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:116:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:117:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:118:1: ruleQualifiedName EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:125:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:129:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:131:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:132:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:132:2: rule__QualifiedName__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:144:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:145:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:146:1: ruleMultiplicityRule EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:153:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:157:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:158:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:158:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:159:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:160:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:160:2: rule__MultiplicityRule__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:172:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:173:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:174:1: ruleBoundSpecification EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:181:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:185:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:186:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:186:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:187:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:188:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:188:2: rule__BoundSpecification__ValueAssignment
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:200:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
    public final void entryRuleUnlimitedLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:201:1: ( ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:202:1: ruleUnlimitedLiteral EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:209:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
    public final void ruleUnlimitedLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:213:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:214:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:214:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:215:1: ( rule__UnlimitedLiteral__Alternatives )
            {
             before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:216:1: ( rule__UnlimitedLiteral__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:216:2: rule__UnlimitedLiteral__Alternatives
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:228:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:229:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:230:1: ruleModifiersRule EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:237:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:241:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:242:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:242:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:243:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:244:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:244:2: rule__ModifiersRule__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:256:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:257:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:258:1: ruleModifierSpecification EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:265:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__Alternatives ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:269:2: ( ( ( rule__ModifierSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:270:1: ( ( rule__ModifierSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:270:1: ( ( rule__ModifierSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:271:1: ( rule__ModifierSpecification__Alternatives )
            {
             before(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:272:1: ( rule__ModifierSpecification__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:272:2: rule__ModifierSpecification__Alternatives
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:284:1: entryRuleRedefinesRule : ruleRedefinesRule EOF ;
    public final void entryRuleRedefinesRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:285:1: ( ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:286:1: ruleRedefinesRule EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:293:1: ruleRedefinesRule : ( ( rule__RedefinesRule__Group__0 ) ) ;
    public final void ruleRedefinesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:297:2: ( ( ( rule__RedefinesRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:298:1: ( ( rule__RedefinesRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:298:1: ( ( rule__RedefinesRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:299:1: ( rule__RedefinesRule__Group__0 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:300:1: ( rule__RedefinesRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:300:2: rule__RedefinesRule__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:312:1: entryRuleSubsetsRule : ruleSubsetsRule EOF ;
    public final void entryRuleSubsetsRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:313:1: ( ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:314:1: ruleSubsetsRule EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:321:1: ruleSubsetsRule : ( ( rule__SubsetsRule__Group__0 ) ) ;
    public final void ruleSubsetsRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:325:2: ( ( ( rule__SubsetsRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:326:1: ( ( rule__SubsetsRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:326:1: ( ( rule__SubsetsRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:327:1: ( rule__SubsetsRule__Group__0 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:328:1: ( rule__SubsetsRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:328:2: rule__SubsetsRule__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:340:1: entryRuleDefaultValueRule : ruleDefaultValueRule EOF ;
    public final void entryRuleDefaultValueRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:341:1: ( ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:342:1: ruleDefaultValueRule EOF
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:349:1: ruleDefaultValueRule : ( ( rule__DefaultValueRule__Group__0 ) ) ;
    public final void ruleDefaultValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:353:2: ( ( ( rule__DefaultValueRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:354:1: ( ( rule__DefaultValueRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:354:1: ( ( rule__DefaultValueRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:355:1: ( rule__DefaultValueRule__Group__0 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:356:1: ( rule__DefaultValueRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:356:2: rule__DefaultValueRule__Group__0
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:369:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:373:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:374:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:374:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:375:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:376:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:376:2: rule__VisibilityKind__Alternatives
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:388:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:392:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:393:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:393:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:394:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:395:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:395:2: rule__ModifierKind__Alternatives
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


    // $ANTLR start "rule__PropertyRule__Alternatives_4"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:406:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__PropertyRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:410:1: ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:411:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:411:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:412:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:413:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:413:2: rule__PropertyRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4802);
                    rule__PropertyRule__TypeAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:417:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:417:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:418:1: '<Undefined>'
                    {
                     before(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,12,FOLLOW_12_in_rule__PropertyRule__Alternatives_4821); 
                     after(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 

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
    // $ANTLR end "rule__PropertyRule__Alternatives_4"


    // $ANTLR start "rule__UnlimitedLiteral__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:430:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:434:1: ( ( RULE_INT ) | ( '*' ) )
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:435:1: ( RULE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:435:1: ( RULE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:436:1: RULE_INT
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives855); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:441:6: ( '*' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:441:6: ( '*' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:442:1: '*'
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:454:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );
    public final void rule__ModifierSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:458:1: ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) )
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:459:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:459:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:460:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:461:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:461:2: rule__ModifierSpecification__ValueAssignment_0
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:465:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:465:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:466:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:467:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:467:2: rule__ModifierSpecification__RedefinesAssignment_1
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:471:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:471:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:472:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:473:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:473:2: rule__ModifierSpecification__SubsetsAssignment_2
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:482:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:486:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:487:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:487:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:488:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:489:1: ( '+' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:489:3: '+'
                    {
                    match(input,14,FOLLOW_14_in_rule__VisibilityKind__Alternatives977); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:494:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:494:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:495:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:496:1: ( '-' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:496:3: '-'
                    {
                    match(input,15,FOLLOW_15_in_rule__VisibilityKind__Alternatives998); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:501:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:501:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:502:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:503:1: ( '#' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:503:3: '#'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives1019); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:508:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:508:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:509:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:510:1: ( '~' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:510:3: '~'
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:520:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:524:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:525:1: ( ( 'readOnly' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:525:1: ( ( 'readOnly' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:526:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:527:1: ( 'readOnly' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:527:3: 'readOnly'
                    {
                    match(input,18,FOLLOW_18_in_rule__ModifierKind__Alternatives1076); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:532:6: ( ( 'union' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:532:6: ( ( 'union' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:533:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:534:1: ( 'union' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:534:3: 'union'
                    {
                    match(input,19,FOLLOW_19_in_rule__ModifierKind__Alternatives1097); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:539:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:539:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:540:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:541:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:541:3: 'ordered'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives1118); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:546:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:546:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:547:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:548:1: ( 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:548:3: 'unique'
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


    // $ANTLR start "rule__PropertyRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:560:1: rule__PropertyRule__Group__0 : rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 ;
    public final void rule__PropertyRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:564:1: ( rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:565:2: rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__01172);
            rule__PropertyRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__01175);
            rule__PropertyRule__Group__1();

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
    // $ANTLR end "rule__PropertyRule__Group__0"


    // $ANTLR start "rule__PropertyRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:572:1: rule__PropertyRule__Group__0__Impl : ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) ;
    public final void rule__PropertyRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:576:1: ( ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:577:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:577:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:578:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:579:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:579:2: rule__PropertyRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl1202);
            rule__PropertyRule__VisibilityAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__0__Impl"


    // $ANTLR start "rule__PropertyRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:589:1: rule__PropertyRule__Group__1 : rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 ;
    public final void rule__PropertyRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:593:1: ( rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:594:2: rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__11232);
            rule__PropertyRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__11235);
            rule__PropertyRule__Group__2();

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
    // $ANTLR end "rule__PropertyRule__Group__1"


    // $ANTLR start "rule__PropertyRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:601:1: rule__PropertyRule__Group__1__Impl : ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) ;
    public final void rule__PropertyRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:605:1: ( ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:606:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:606:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:607:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:608:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==33) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:608:2: rule__PropertyRule__IsDerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl1262);
                    rule__PropertyRule__IsDerivedAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__1__Impl"


    // $ANTLR start "rule__PropertyRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:618:1: rule__PropertyRule__Group__2 : rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 ;
    public final void rule__PropertyRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:622:1: ( rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:623:2: rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__21293);
            rule__PropertyRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__21296);
            rule__PropertyRule__Group__3();

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
    // $ANTLR end "rule__PropertyRule__Group__2"


    // $ANTLR start "rule__PropertyRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:630:1: rule__PropertyRule__Group__2__Impl : ( ( rule__PropertyRule__NameAssignment_2 ) ) ;
    public final void rule__PropertyRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:634:1: ( ( ( rule__PropertyRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:635:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:635:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:636:1: ( rule__PropertyRule__NameAssignment_2 )
            {
             before(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:637:1: ( rule__PropertyRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:637:2: rule__PropertyRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl1323);
            rule__PropertyRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__2__Impl"


    // $ANTLR start "rule__PropertyRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:647:1: rule__PropertyRule__Group__3 : rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 ;
    public final void rule__PropertyRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:651:1: ( rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:652:2: rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__31353);
            rule__PropertyRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__31356);
            rule__PropertyRule__Group__4();

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
    // $ANTLR end "rule__PropertyRule__Group__3"


    // $ANTLR start "rule__PropertyRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:659:1: rule__PropertyRule__Group__3__Impl : ( ':' ) ;
    public final void rule__PropertyRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:663:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:664:1: ( ':' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:664:1: ( ':' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:665:1: ':'
            {
             before(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 
            match(input,22,FOLLOW_22_in_rule__PropertyRule__Group__3__Impl1384); 
             after(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__3__Impl"


    // $ANTLR start "rule__PropertyRule__Group__4"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:678:1: rule__PropertyRule__Group__4 : rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 ;
    public final void rule__PropertyRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:682:1: ( rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:683:2: rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41415);
            rule__PropertyRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41418);
            rule__PropertyRule__Group__5();

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
    // $ANTLR end "rule__PropertyRule__Group__4"


    // $ANTLR start "rule__PropertyRule__Group__4__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:690:1: rule__PropertyRule__Group__4__Impl : ( ( rule__PropertyRule__Alternatives_4 ) ) ;
    public final void rule__PropertyRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:694:1: ( ( ( rule__PropertyRule__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:695:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:695:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:696:1: ( rule__PropertyRule__Alternatives_4 )
            {
             before(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:697:1: ( rule__PropertyRule__Alternatives_4 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:697:2: rule__PropertyRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1445);
            rule__PropertyRule__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__4__Impl"


    // $ANTLR start "rule__PropertyRule__Group__5"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:707:1: rule__PropertyRule__Group__5 : rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 ;
    public final void rule__PropertyRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:711:1: ( rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:712:2: rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51475);
            rule__PropertyRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51478);
            rule__PropertyRule__Group__6();

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
    // $ANTLR end "rule__PropertyRule__Group__5"


    // $ANTLR start "rule__PropertyRule__Group__5__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:719:1: rule__PropertyRule__Group__5__Impl : ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__PropertyRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:723:1: ( ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:724:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:724:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:725:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:726:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:726:2: rule__PropertyRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1505);
                    rule__PropertyRule__MultiplicityAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__5__Impl"


    // $ANTLR start "rule__PropertyRule__Group__6"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:736:1: rule__PropertyRule__Group__6 : rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7 ;
    public final void rule__PropertyRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:740:1: ( rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:741:2: rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61536);
            rule__PropertyRule__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__7_in_rule__PropertyRule__Group__61539);
            rule__PropertyRule__Group__7();

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
    // $ANTLR end "rule__PropertyRule__Group__6"


    // $ANTLR start "rule__PropertyRule__Group__6__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:748:1: rule__PropertyRule__Group__6__Impl : ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) ;
    public final void rule__PropertyRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:752:1: ( ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:753:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:753:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:754:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:755:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:755:2: rule__PropertyRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1566);
                    rule__PropertyRule__ModifiersAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__6__Impl"


    // $ANTLR start "rule__PropertyRule__Group__7"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:765:1: rule__PropertyRule__Group__7 : rule__PropertyRule__Group__7__Impl ;
    public final void rule__PropertyRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:769:1: ( rule__PropertyRule__Group__7__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:770:2: rule__PropertyRule__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__7__Impl_in_rule__PropertyRule__Group__71597);
            rule__PropertyRule__Group__7__Impl();

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
    // $ANTLR end "rule__PropertyRule__Group__7"


    // $ANTLR start "rule__PropertyRule__Group__7__Impl"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:776:1: rule__PropertyRule__Group__7__Impl : ( ( rule__PropertyRule__DefaultAssignment_7 )? ) ;
    public final void rule__PropertyRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:780:1: ( ( ( rule__PropertyRule__DefaultAssignment_7 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:781:1: ( ( rule__PropertyRule__DefaultAssignment_7 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:781:1: ( ( rule__PropertyRule__DefaultAssignment_7 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:782:1: ( rule__PropertyRule__DefaultAssignment_7 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_7()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:783:1: ( rule__PropertyRule__DefaultAssignment_7 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:783:2: rule__PropertyRule__DefaultAssignment_7
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__DefaultAssignment_7_in_rule__PropertyRule__Group__7__Impl1624);
                    rule__PropertyRule__DefaultAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__7__Impl"


    // $ANTLR start "rule__TypeRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:809:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:813:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:814:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01671);
            rule__TypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01674);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:821:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:825:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:826:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:826:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:827:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:828:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==23) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:828:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1701);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:838:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:842:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:843:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11732);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:849:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:853:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:854:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:854:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:855:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:856:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:856:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1759);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:870:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:874:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:875:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01793);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01796);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:882:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:886:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:887:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:887:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:888:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:889:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:889:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1823);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:899:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:903:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:904:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11853);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11856);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:911:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:915:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:916:1: ( '::' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:916:1: ( '::' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:917:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__QualifiedName__Group__1__Impl1884); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:930:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:934:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:935:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21915);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:941:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:945:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:946:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:946:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:947:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:948:1: ( rule__QualifiedName__RemainingAssignment_2 )?
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:948:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1942);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:964:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:968:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:969:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01979);
            rule__MultiplicityRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01982);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:976:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:980:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:981:1: ( '[' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:981:1: ( '[' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:982:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MultiplicityRule__Group__0__Impl2010); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:995:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:999:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1000:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12041);
            rule__MultiplicityRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12044);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1007:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1011:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1012:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1012:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1013:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1014:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1014:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2071);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1024:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1028:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1029:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22101);
            rule__MultiplicityRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22104);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1036:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1040:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1041:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1041:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1042:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1043:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1043:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2131);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1053:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1057:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1058:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32162);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1064:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1068:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1069:1: ( ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1069:1: ( ']' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1070:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__MultiplicityRule__Group__3__Impl2190); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1091:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1095:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1096:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02229);
            rule__MultiplicityRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02232);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1103:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1107:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1108:1: ( '..' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1108:1: ( '..' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1109:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__MultiplicityRule__Group_2__0__Impl2260); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1122:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1126:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1127:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12291);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1133:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1137:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1138:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1138:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1139:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1140:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1140:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2318);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1154:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1158:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1159:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02352);
            rule__ModifiersRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02355);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1166:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1170:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1171:1: ( '{' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1171:1: ( '{' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1172:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__ModifiersRule__Group__0__Impl2383); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1185:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1189:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1190:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12414);
            rule__ModifiersRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12417);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1197:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1201:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1202:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1202:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1203:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1204:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1204:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2444);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1214:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1218:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1219:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22474);
            rule__ModifiersRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22477);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1226:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1230:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1231:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1231:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1232:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1233:1: ( rule__ModifiersRule__Group_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==29) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1233:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2504);
            	    rule__ModifiersRule__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1243:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1247:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1248:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32535);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1254:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1258:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1259:1: ( '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1259:1: ( '}' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1260:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__ModifiersRule__Group__3__Impl2563); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1281:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1285:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1286:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02602);
            rule__ModifiersRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02605);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1293:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1297:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1298:1: ( ',' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1298:1: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1299:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,29,FOLLOW_29_in_rule__ModifiersRule__Group_2__0__Impl2633); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1312:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1316:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1317:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12664);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1323:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1327:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1328:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1328:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1329:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1330:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1330:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2691);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1344:1: rule__RedefinesRule__Group__0 : rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 ;
    public final void rule__RedefinesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1348:1: ( rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1349:2: rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__02725);
            rule__RedefinesRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__02728);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1356:1: rule__RedefinesRule__Group__0__Impl : ( 'redefines' ) ;
    public final void rule__RedefinesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1360:1: ( ( 'redefines' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1361:1: ( 'redefines' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1361:1: ( 'redefines' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1362:1: 'redefines'
            {
             before(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__RedefinesRule__Group__0__Impl2756); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1375:1: rule__RedefinesRule__Group__1 : rule__RedefinesRule__Group__1__Impl ;
    public final void rule__RedefinesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1379:1: ( rule__RedefinesRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1380:2: rule__RedefinesRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__12787);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1386:1: rule__RedefinesRule__Group__1__Impl : ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) ;
    public final void rule__RedefinesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1390:1: ( ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1391:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1391:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1392:1: ( rule__RedefinesRule__PropertyAssignment_1 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1393:1: ( rule__RedefinesRule__PropertyAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1393:2: rule__RedefinesRule__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__PropertyAssignment_1_in_rule__RedefinesRule__Group__1__Impl2814);
            rule__RedefinesRule__PropertyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1407:1: rule__SubsetsRule__Group__0 : rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 ;
    public final void rule__SubsetsRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1411:1: ( rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1412:2: rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__02848);
            rule__SubsetsRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__02851);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1419:1: rule__SubsetsRule__Group__0__Impl : ( 'subsets' ) ;
    public final void rule__SubsetsRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1423:1: ( ( 'subsets' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1424:1: ( 'subsets' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1424:1: ( 'subsets' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1425:1: 'subsets'
            {
             before(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__SubsetsRule__Group__0__Impl2879); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1438:1: rule__SubsetsRule__Group__1 : rule__SubsetsRule__Group__1__Impl ;
    public final void rule__SubsetsRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1442:1: ( rule__SubsetsRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1443:2: rule__SubsetsRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__12910);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1449:1: rule__SubsetsRule__Group__1__Impl : ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) ;
    public final void rule__SubsetsRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1453:1: ( ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1454:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1454:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1455:1: ( rule__SubsetsRule__PropertyAssignment_1 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1456:1: ( rule__SubsetsRule__PropertyAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1456:2: rule__SubsetsRule__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__PropertyAssignment_1_in_rule__SubsetsRule__Group__1__Impl2937);
            rule__SubsetsRule__PropertyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1470:1: rule__DefaultValueRule__Group__0 : rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 ;
    public final void rule__DefaultValueRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1474:1: ( rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1475:2: rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__02971);
            rule__DefaultValueRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__02974);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1482:1: rule__DefaultValueRule__Group__0__Impl : ( '=' ) ;
    public final void rule__DefaultValueRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1486:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1487:1: ( '=' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1487:1: ( '=' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1488:1: '='
            {
             before(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__DefaultValueRule__Group__0__Impl3002); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1501:1: rule__DefaultValueRule__Group__1 : rule__DefaultValueRule__Group__1__Impl ;
    public final void rule__DefaultValueRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1505:1: ( rule__DefaultValueRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1506:2: rule__DefaultValueRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__13033);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1512:1: rule__DefaultValueRule__Group__1__Impl : ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) ;
    public final void rule__DefaultValueRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1516:1: ( ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1517:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1517:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1518:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1519:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1519:2: rule__DefaultValueRule__DefaultAssignment_1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl3060);
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


    // $ANTLR start "rule__PropertyRule__VisibilityAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1534:1: rule__PropertyRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__PropertyRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1538:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1539:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1539:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1540:1: ruleVisibilityKind
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_03099);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__VisibilityAssignment_0"


    // $ANTLR start "rule__PropertyRule__IsDerivedAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1549:1: rule__PropertyRule__IsDerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PropertyRule__IsDerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1553:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1554:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1554:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1555:1: ( '/' )
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1556:1: ( '/' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1557:1: '/'
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            match(input,33,FOLLOW_33_in_rule__PropertyRule__IsDerivedAssignment_13135); 
             after(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 

            }

             after(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__IsDerivedAssignment_1"


    // $ANTLR start "rule__PropertyRule__NameAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1572:1: rule__PropertyRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PropertyRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1576:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1577:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1577:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1578:1: RULE_ID
            {
             before(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_23174); 
             after(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__NameAssignment_2"


    // $ANTLR start "rule__PropertyRule__TypeAssignment_4_0"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1587:1: rule__PropertyRule__TypeAssignment_4_0 : ( ruleTypeRule ) ;
    public final void rule__PropertyRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1591:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1592:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1592:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1593:1: ruleTypeRule
            {
             before(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_03205);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__TypeAssignment_4_0"


    // $ANTLR start "rule__PropertyRule__MultiplicityAssignment_5"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1602:1: rule__PropertyRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__PropertyRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1606:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1607:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1607:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1608:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_53236);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__MultiplicityAssignment_5"


    // $ANTLR start "rule__PropertyRule__ModifiersAssignment_6"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1617:1: rule__PropertyRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__PropertyRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1621:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1622:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1622:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1623:1: ruleModifiersRule
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_63267);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__ModifiersAssignment_6"


    // $ANTLR start "rule__PropertyRule__DefaultAssignment_7"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1632:1: rule__PropertyRule__DefaultAssignment_7 : ( ruleDefaultValueRule ) ;
    public final void rule__PropertyRule__DefaultAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1636:1: ( ( ruleDefaultValueRule ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1637:1: ( ruleDefaultValueRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1637:1: ( ruleDefaultValueRule )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1638:1: ruleDefaultValueRule
            {
             before(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_rule__PropertyRule__DefaultAssignment_73298);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__DefaultAssignment_7"


    // $ANTLR start "rule__TypeRule__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1647:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1651:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1652:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1652:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1653:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03329);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1662:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1666:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1667:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1667:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1668:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1669:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1670:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13364); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1681:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1685:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1686:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1686:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1687:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1688:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1689:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03403); 
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1700:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1704:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1705:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1705:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1706:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23438);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1715:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1719:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1720:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1720:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1721:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13469);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1730:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1734:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1735:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1735:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1736:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13500);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1745:1: rule__BoundSpecification__ValueAssignment : ( ruleUnlimitedLiteral ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1749:1: ( ( ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1750:1: ( ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1750:1: ( ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1751:1: ruleUnlimitedLiteral
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3531);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1760:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1764:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1765:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1765:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1766:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13562);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1775:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1779:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1780:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1780:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1781:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13593);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1790:1: rule__ModifierSpecification__ValueAssignment_0 : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1794:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1795:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1795:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1796:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_03624);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1805:1: rule__ModifierSpecification__RedefinesAssignment_1 : ( ruleRedefinesRule ) ;
    public final void rule__ModifierSpecification__RedefinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1809:1: ( ( ruleRedefinesRule ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1810:1: ( ruleRedefinesRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1810:1: ( ruleRedefinesRule )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1811:1: ruleRedefinesRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_13655);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1820:1: rule__ModifierSpecification__SubsetsAssignment_2 : ( ruleSubsetsRule ) ;
    public final void rule__ModifierSpecification__SubsetsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1824:1: ( ( ruleSubsetsRule ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1825:1: ( ruleSubsetsRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1825:1: ( ruleSubsetsRule )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1826:1: ruleSubsetsRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_23686);
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


    // $ANTLR start "rule__RedefinesRule__PropertyAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1835:1: rule__RedefinesRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RedefinesRule__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1839:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1840:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1840:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1841:1: ( RULE_ID )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1842:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1843:1: RULE_ID
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RedefinesRule__PropertyAssignment_13721); 
             after(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__PropertyAssignment_1"


    // $ANTLR start "rule__SubsetsRule__PropertyAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1854:1: rule__SubsetsRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubsetsRule__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1858:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1859:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1859:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1860:1: ( RULE_ID )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1861:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1862:1: RULE_ID
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubsetsRule__PropertyAssignment_13760); 
             after(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__PropertyAssignment_1"


    // $ANTLR start "rule__DefaultValueRule__DefaultAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1873:1: rule__DefaultValueRule__DefaultAssignment_1 : ( RULE_STRING ) ;
    public final void rule__DefaultValueRule__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1877:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1878:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1878:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1879:1: RULE_STRING
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_13795); 
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


 

    public static final BitSet FOLLOW_rulePropertyRule_in_entryRulePropertyRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0_in_rulePropertyRule94 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PropertyRule__Alternatives_4821 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__01172 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__01175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__11232 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__11235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__21293 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__21296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__31353 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__31356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PropertyRule__Group__3__Impl1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41415 = new BitSet(new long[]{0x0000000109000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51475 = new BitSet(new long[]{0x0000000109000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61536 = new BitSet(new long[]{0x0000000109000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__7_in_rule__PropertyRule__Group__61539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__7__Impl_in_rule__PropertyRule__Group__71597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__DefaultAssignment_7_in_rule__PropertyRule__Group__7__Impl1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01671 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01793 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11853 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__QualifiedName__Group__1__Impl1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01979 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MultiplicityRule__Group__0__Impl2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12041 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22101 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MultiplicityRule__Group__3__Impl2190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02229 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MultiplicityRule__Group_2__0__Impl2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02352 = new BitSet(new long[]{0x00000000C03C0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ModifiersRule__Group__0__Impl2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12414 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22474 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2504 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ModifiersRule__Group__3__Impl2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02602 = new BitSet(new long[]{0x00000000C03C0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ModifiersRule__Group_2__0__Impl2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__02725 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__02728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__RedefinesRule__Group__0__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__12787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__PropertyAssignment_1_in_rule__RedefinesRule__Group__1__Impl2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__02848 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__02851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__SubsetsRule__Group__0__Impl2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__12910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__PropertyAssignment_1_in_rule__SubsetsRule__Group__1__Impl2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__02971 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__02974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__DefaultValueRule__Group__0__Impl3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__13033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_03099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__PropertyRule__IsDerivedAssignment_13135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_23174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_03205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_53236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_63267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rule__PropertyRule__DefaultAssignment_73298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_03624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_13655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_23686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RedefinesRule__PropertyAssignment_13721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubsetsRule__PropertyAssignment_13760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_13795 = new BitSet(new long[]{0x0000000000000002L});

}