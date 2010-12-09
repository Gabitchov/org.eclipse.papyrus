package org.eclipse.papyrus.property.editor.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.property.editor.xtext.services.UmlPropertyGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPropertyParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "':'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'/'"
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

        public InternalUmlPropertyParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g"; }


     
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




    // $ANTLR start entryRulePropertyRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:61:1: entryRulePropertyRule : rulePropertyRule EOF ;
    public final void entryRulePropertyRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:62:1: ( rulePropertyRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:63:1: rulePropertyRule EOF
            {
             before(grammarAccess.getPropertyRuleRule()); 
            pushFollow(FOLLOW_rulePropertyRule_in_entryRulePropertyRule61);
            rulePropertyRule();
            _fsp--;

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
    // $ANTLR end entryRulePropertyRule


    // $ANTLR start rulePropertyRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:70:1: rulePropertyRule : ( ( rule__PropertyRule__Group__0 ) ) ;
    public final void rulePropertyRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:74:2: ( ( ( rule__PropertyRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:75:1: ( ( rule__PropertyRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:75:1: ( ( rule__PropertyRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:76:1: ( rule__PropertyRule__Group__0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:77:1: ( rule__PropertyRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:77:2: rule__PropertyRule__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0_in_rulePropertyRule94);
            rule__PropertyRule__Group__0();
            _fsp--;


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
    // $ANTLR end rulePropertyRule


    // $ANTLR start entryRuleTypeRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:89:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:90:1: ( ruleTypeRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:91:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule121);
            ruleTypeRule();
            _fsp--;

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
    // $ANTLR end entryRuleTypeRule


    // $ANTLR start ruleTypeRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:98:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:102:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:103:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:103:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:104:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:105:1: ( rule__TypeRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:105:2: rule__TypeRule__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule154);
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


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:117:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:118:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:119:1: ruleQualifiedName EOF
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:126:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:130:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:132:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:133:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:133:2: rule__QualifiedName__Group__0
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


    // $ANTLR start entryRuleMultiplicityRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:145:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:146:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:147:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule241);
            ruleMultiplicityRule();
            _fsp--;

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
    // $ANTLR end entryRuleMultiplicityRule


    // $ANTLR start ruleMultiplicityRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:154:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:158:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:159:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:159:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:160:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:161:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:161:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule274);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:173:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:174:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:175:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification301);
            ruleBoundSpecification();
            _fsp--;

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
    // $ANTLR end entryRuleBoundSpecification


    // $ANTLR start ruleBoundSpecification
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:182:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:186:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:187:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:187:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:188:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:189:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:189:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification334);
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


    // $ANTLR start entryRuleModifiersRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:201:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:202:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:203:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule361);
            ruleModifiersRule();
            _fsp--;

             after(grammarAccess.getModifiersRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule368); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:210:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:214:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:215:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:215:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:216:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:217:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:217:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule394);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:229:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:230:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:231:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification421);
            ruleModifierSpecification();
            _fsp--;

             after(grammarAccess.getModifierSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification428); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:238:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__ValueAssignment ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:242:2: ( ( ( rule__ModifierSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:243:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:243:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:244:1: ( rule__ModifierSpecification__ValueAssignment )
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:245:1: ( rule__ModifierSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:245:2: rule__ModifierSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification454);
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


    // $ANTLR start ruleVisibilityKind
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:258:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:262:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:263:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:263:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:264:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:265:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:265:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind491);
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


    // $ANTLR start ruleModifierKind
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:277:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:281:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:282:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:282:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:283:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:284:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:284:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind527);
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


    // $ANTLR start rule__PropertyRule__Alternatives_4
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:295:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__PropertyRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:299:1: ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
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
                    new NoViableAltException("295:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:300:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:300:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:301:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:302:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:302:2: rule__PropertyRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4562);
                    rule__PropertyRule__TypeAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:306:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:306:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:307:1: '<Undefined>'
                    {
                     before(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,12,FOLLOW_12_in_rule__PropertyRule__Alternatives_4581); 
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
    // $ANTLR end rule__PropertyRule__Alternatives_4


    // $ANTLR start rule__VisibilityKind__Alternatives
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:319:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:323:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
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
                    new NoViableAltException("319:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:324:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:324:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:325:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:326:1: ( '+' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:326:3: '+'
                    {
                    match(input,13,FOLLOW_13_in_rule__VisibilityKind__Alternatives616); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:331:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:331:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:332:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:333:1: ( '-' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:333:3: '-'
                    {
                    match(input,14,FOLLOW_14_in_rule__VisibilityKind__Alternatives637); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:338:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:338:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:339:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:340:1: ( '#' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:340:3: '#'
                    {
                    match(input,15,FOLLOW_15_in_rule__VisibilityKind__Alternatives658); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:345:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:345:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:346:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:347:1: ( '~' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:347:3: '~'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives679); 

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


    // $ANTLR start rule__ModifierKind__Alternatives
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:357:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:361:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
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
                    new NoViableAltException("357:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:362:1: ( ( 'readOnly' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:362:1: ( ( 'readOnly' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:363:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:364:1: ( 'readOnly' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:364:3: 'readOnly'
                    {
                    match(input,17,FOLLOW_17_in_rule__ModifierKind__Alternatives715); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:369:6: ( ( 'union' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:369:6: ( ( 'union' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:370:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:371:1: ( 'union' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:371:3: 'union'
                    {
                    match(input,18,FOLLOW_18_in_rule__ModifierKind__Alternatives736); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:376:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:376:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:377:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:378:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:378:3: 'ordered'
                    {
                    match(input,19,FOLLOW_19_in_rule__ModifierKind__Alternatives757); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:383:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:383:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:384:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:385:1: ( 'unique' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:385:3: 'unique'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives778); 

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
    // $ANTLR end rule__ModifierKind__Alternatives


    // $ANTLR start rule__PropertyRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:397:1: rule__PropertyRule__Group__0 : rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 ;
    public final void rule__PropertyRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:401:1: ( rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:402:2: rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__0811);
            rule__PropertyRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__0814);
            rule__PropertyRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__0


    // $ANTLR start rule__PropertyRule__Group__0__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:409:1: rule__PropertyRule__Group__0__Impl : ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) ;
    public final void rule__PropertyRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:413:1: ( ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:414:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:414:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:415:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:416:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:416:2: rule__PropertyRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl841);
            rule__PropertyRule__VisibilityAssignment_0();
            _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__0__Impl


    // $ANTLR start rule__PropertyRule__Group__1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:426:1: rule__PropertyRule__Group__1 : rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 ;
    public final void rule__PropertyRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:430:1: ( rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:431:2: rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__1871);
            rule__PropertyRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__1874);
            rule__PropertyRule__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__1


    // $ANTLR start rule__PropertyRule__Group__1__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:438:1: rule__PropertyRule__Group__1__Impl : ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) ;
    public final void rule__PropertyRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:442:1: ( ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:443:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:443:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:444:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:445:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:445:2: rule__PropertyRule__IsDerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl901);
                    rule__PropertyRule__IsDerivedAssignment_1();
                    _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__1__Impl


    // $ANTLR start rule__PropertyRule__Group__2
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:455:1: rule__PropertyRule__Group__2 : rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 ;
    public final void rule__PropertyRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:459:1: ( rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:460:2: rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__2932);
            rule__PropertyRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__2935);
            rule__PropertyRule__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__2


    // $ANTLR start rule__PropertyRule__Group__2__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:467:1: rule__PropertyRule__Group__2__Impl : ( ( rule__PropertyRule__NameAssignment_2 ) ) ;
    public final void rule__PropertyRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:471:1: ( ( ( rule__PropertyRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:472:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:472:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:473:1: ( rule__PropertyRule__NameAssignment_2 )
            {
             before(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:474:1: ( rule__PropertyRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:474:2: rule__PropertyRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl962);
            rule__PropertyRule__NameAssignment_2();
            _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__2__Impl


    // $ANTLR start rule__PropertyRule__Group__3
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:484:1: rule__PropertyRule__Group__3 : rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 ;
    public final void rule__PropertyRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:488:1: ( rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:489:2: rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__3992);
            rule__PropertyRule__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__3995);
            rule__PropertyRule__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__3


    // $ANTLR start rule__PropertyRule__Group__3__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:496:1: rule__PropertyRule__Group__3__Impl : ( ':' ) ;
    public final void rule__PropertyRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:500:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:501:1: ( ':' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:501:1: ( ':' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:502:1: ':'
            {
             before(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__PropertyRule__Group__3__Impl1023); 
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
    // $ANTLR end rule__PropertyRule__Group__3__Impl


    // $ANTLR start rule__PropertyRule__Group__4
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:515:1: rule__PropertyRule__Group__4 : rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 ;
    public final void rule__PropertyRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:519:1: ( rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:520:2: rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41054);
            rule__PropertyRule__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41057);
            rule__PropertyRule__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__4


    // $ANTLR start rule__PropertyRule__Group__4__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:527:1: rule__PropertyRule__Group__4__Impl : ( ( rule__PropertyRule__Alternatives_4 ) ) ;
    public final void rule__PropertyRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:531:1: ( ( ( rule__PropertyRule__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:532:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:532:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:533:1: ( rule__PropertyRule__Alternatives_4 )
            {
             before(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:534:1: ( rule__PropertyRule__Alternatives_4 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:534:2: rule__PropertyRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1084);
            rule__PropertyRule__Alternatives_4();
            _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__4__Impl


    // $ANTLR start rule__PropertyRule__Group__5
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:544:1: rule__PropertyRule__Group__5 : rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 ;
    public final void rule__PropertyRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:548:1: ( rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:549:2: rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51114);
            rule__PropertyRule__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51117);
            rule__PropertyRule__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__5


    // $ANTLR start rule__PropertyRule__Group__5__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:556:1: rule__PropertyRule__Group__5__Impl : ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__PropertyRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:560:1: ( ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:561:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:561:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:562:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:563:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:563:2: rule__PropertyRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1144);
                    rule__PropertyRule__MultiplicityAssignment_5();
                    _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__5__Impl


    // $ANTLR start rule__PropertyRule__Group__6
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:573:1: rule__PropertyRule__Group__6 : rule__PropertyRule__Group__6__Impl ;
    public final void rule__PropertyRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:577:1: ( rule__PropertyRule__Group__6__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:578:2: rule__PropertyRule__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61175);
            rule__PropertyRule__Group__6__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__6


    // $ANTLR start rule__PropertyRule__Group__6__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:584:1: rule__PropertyRule__Group__6__Impl : ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) ;
    public final void rule__PropertyRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:588:1: ( ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:589:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:589:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:590:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:591:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:591:2: rule__PropertyRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1202);
                    rule__PropertyRule__ModifiersAssignment_6();
                    _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__6__Impl


    // $ANTLR start rule__TypeRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:615:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:619:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:620:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01247);
            rule__TypeRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01250);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:627:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:631:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:632:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:632:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:633:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:634:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==22) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:634:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1277);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:644:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:648:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:649:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11308);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:655:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:659:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:660:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:660:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:661:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:662:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:662:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1335);
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


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:676:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:680:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:681:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01369);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01372);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:688:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:692:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:693:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:693:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:694:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:695:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:695:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1399);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:705:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:709:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:710:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11429);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11432);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:717:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:721:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:722:1: ( '::' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:722:1: ( '::' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:723:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,22,FOLLOW_22_in_rule__QualifiedName__Group__1__Impl1460); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:736:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:740:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:741:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21491);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:747:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:751:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:752:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:752:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:753:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:754:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==22) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:754:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1518);
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


    // $ANTLR start rule__MultiplicityRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:770:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:774:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:775:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01555);
            rule__MultiplicityRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01558);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:782:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:786:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:787:1: ( '[' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:787:1: ( '[' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:788:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__MultiplicityRule__Group__0__Impl1586); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:801:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:805:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:806:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__11617);
            rule__MultiplicityRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__11620);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:813:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:817:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:818:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:818:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:819:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:820:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:820:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl1647);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:830:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:834:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:835:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__21677);
            rule__MultiplicityRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__21680);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:842:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:846:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:847:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:847:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:848:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:849:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:849:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl1707);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:859:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:863:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:864:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__31738);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:870:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:874:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:875:1: ( ']' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:875:1: ( ']' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:876:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__MultiplicityRule__Group__3__Impl1766); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:897:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:901:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:902:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__01805);
            rule__MultiplicityRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__01808);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:909:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:913:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:914:1: ( '..' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:914:1: ( '..' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:915:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,25,FOLLOW_25_in_rule__MultiplicityRule__Group_2__0__Impl1836); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:928:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:932:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:933:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__11867);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:939:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:943:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:944:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:944:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:945:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:946:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:946:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl1894);
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


    // $ANTLR start rule__ModifiersRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:960:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:964:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:965:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01928);
            rule__ModifiersRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01931);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:972:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:976:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:977:1: ( '{' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:977:1: ( '{' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:978:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__ModifiersRule__Group__0__Impl1959); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:991:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:995:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:996:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11990);
            rule__ModifiersRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11993);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1003:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1007:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1008:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1008:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1009:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1010:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1010:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2020);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1020:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1024:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1025:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22050);
            rule__ModifiersRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22053);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1032:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1036:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1037:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1037:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1038:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1039:1: ( rule__ModifiersRule__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==28) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1039:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2080);
            	    rule__ModifiersRule__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1049:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1053:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1054:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32111);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1060:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1064:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1065:1: ( '}' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1065:1: ( '}' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1066:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__ModifiersRule__Group__3__Impl2139); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1087:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1091:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1092:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02178);
            rule__ModifiersRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02181);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1099:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1103:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1104:1: ( ',' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1104:1: ( ',' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1105:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,28,FOLLOW_28_in_rule__ModifiersRule__Group_2__0__Impl2209); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1118:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1122:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1123:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12240);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1129:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1133:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1134:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1134:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1135:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1136:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1136:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2267);
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


    // $ANTLR start rule__PropertyRule__VisibilityAssignment_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1151:1: rule__PropertyRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__PropertyRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1155:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1156:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1156:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1157:1: ruleVisibilityKind
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_02306);
            ruleVisibilityKind();
            _fsp--;

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
    // $ANTLR end rule__PropertyRule__VisibilityAssignment_0


    // $ANTLR start rule__PropertyRule__IsDerivedAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1166:1: rule__PropertyRule__IsDerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PropertyRule__IsDerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1170:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1171:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1171:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1172:1: ( '/' )
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1173:1: ( '/' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1174:1: '/'
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            match(input,29,FOLLOW_29_in_rule__PropertyRule__IsDerivedAssignment_12342); 
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
    // $ANTLR end rule__PropertyRule__IsDerivedAssignment_1


    // $ANTLR start rule__PropertyRule__NameAssignment_2
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1189:1: rule__PropertyRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PropertyRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1193:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1194:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1194:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1195:1: RULE_ID
            {
             before(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_22381); 
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
    // $ANTLR end rule__PropertyRule__NameAssignment_2


    // $ANTLR start rule__PropertyRule__TypeAssignment_4_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1204:1: rule__PropertyRule__TypeAssignment_4_0 : ( ruleTypeRule ) ;
    public final void rule__PropertyRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1208:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1209:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1209:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1210:1: ruleTypeRule
            {
             before(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_02412);
            ruleTypeRule();
            _fsp--;

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
    // $ANTLR end rule__PropertyRule__TypeAssignment_4_0


    // $ANTLR start rule__PropertyRule__MultiplicityAssignment_5
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1219:1: rule__PropertyRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__PropertyRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1223:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1224:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1224:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1225:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_52443);
            ruleMultiplicityRule();
            _fsp--;

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
    // $ANTLR end rule__PropertyRule__MultiplicityAssignment_5


    // $ANTLR start rule__PropertyRule__ModifiersAssignment_6
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1234:1: rule__PropertyRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__PropertyRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1238:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1239:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1239:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1240:1: ruleModifiersRule
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_62474);
            ruleModifiersRule();
            _fsp--;

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
    // $ANTLR end rule__PropertyRule__ModifiersAssignment_6


    // $ANTLR start rule__TypeRule__PathAssignment_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1249:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1253:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1254:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1254:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1255:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_02505);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1264:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1268:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1269:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1269:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1270:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1271:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1272:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_12540); 
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
    // $ANTLR end rule__TypeRule__TypeAssignment_1


    // $ANTLR start rule__QualifiedName__PathAssignment_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1283:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1287:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1288:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1288:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1289:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1290:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1291:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_02579); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1302:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1306:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1307:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1307:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1308:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_22614);
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


    // $ANTLR start rule__MultiplicityRule__BoundsAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1317:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1321:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1322:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1322:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1323:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_12645);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1332:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1336:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1337:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1337:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1338:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_12676);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1347:1: rule__BoundSpecification__ValueAssignment : ( RULE_UNLIMITEDLITERAL ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1351:1: ( ( RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1352:1: ( RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1352:1: ( RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1353:1: RULE_UNLIMITEDLITERAL
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); 
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment2707); 
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


    // $ANTLR start rule__ModifiersRule__ValuesAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1362:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1366:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1367:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1367:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1368:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_12738);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1377:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1381:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1382:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1382:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1383:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_12769);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1392:1: rule__ModifierSpecification__ValueAssignment : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1396:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1397:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1397:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1398:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment2800);
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
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PropertyRule__Alternatives_4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VisibilityKind__Alternatives616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VisibilityKind__Alternatives637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VisibilityKind__Alternatives658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ModifierKind__Alternatives715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ModifierKind__Alternatives736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ModifierKind__Alternatives757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ModifierKind__Alternatives778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__0811 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__0814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__1871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__2932 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__3992 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PropertyRule__Group__3__Impl1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41054 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51114 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01369 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11429 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__QualifiedName__Group__1__Impl1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MultiplicityRule__Group__0__Impl1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__11617 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__11620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__21677 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__21680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__31738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MultiplicityRule__Group__3__Impl1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__01805 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__01808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MultiplicityRule__Group_2__0__Impl1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__11867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01928 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ModifiersRule__Group__0__Impl1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11990 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22050 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2080 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ModifiersRule__Group__3__Impl2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02178 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ModifiersRule__Group_2__0__Impl2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_02306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__PropertyRule__IsDerivedAssignment_12342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_22381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_02412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_52443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_62474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_02505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_12540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_02579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_22614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_12645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_12676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_12738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_12769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment2800 = new BitSet(new long[]{0x0000000000000002L});

}