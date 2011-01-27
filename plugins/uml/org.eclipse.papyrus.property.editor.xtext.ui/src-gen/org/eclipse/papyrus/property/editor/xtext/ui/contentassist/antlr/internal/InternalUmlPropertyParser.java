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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "':'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'redefines'", "'subsets'", "'='", "'/'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_UNLIMITEDLITERAL=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=7;
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:238:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__Alternatives ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:242:2: ( ( ( rule__ModifierSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:243:1: ( ( rule__ModifierSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:243:1: ( ( rule__ModifierSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:244:1: ( rule__ModifierSpecification__Alternatives )
            {
             before(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:245:1: ( rule__ModifierSpecification__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:245:2: rule__ModifierSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification454);
            rule__ModifierSpecification__Alternatives();
            _fsp--;


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
    // $ANTLR end ruleModifierSpecification


    // $ANTLR start entryRuleRedefinesRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:257:1: entryRuleRedefinesRule : ruleRedefinesRule EOF ;
    public final void entryRuleRedefinesRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:258:1: ( ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:259:1: ruleRedefinesRule EOF
            {
             before(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule481);
            ruleRedefinesRule();
            _fsp--;

             after(grammarAccess.getRedefinesRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule488); 

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
    // $ANTLR end entryRuleRedefinesRule


    // $ANTLR start ruleRedefinesRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:266:1: ruleRedefinesRule : ( ( rule__RedefinesRule__Group__0 ) ) ;
    public final void ruleRedefinesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:270:2: ( ( ( rule__RedefinesRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:271:1: ( ( rule__RedefinesRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:271:1: ( ( rule__RedefinesRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:272:1: ( rule__RedefinesRule__Group__0 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:273:1: ( rule__RedefinesRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:273:2: rule__RedefinesRule__Group__0
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule514);
            rule__RedefinesRule__Group__0();
            _fsp--;


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
    // $ANTLR end ruleRedefinesRule


    // $ANTLR start entryRuleSubsetsRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:285:1: entryRuleSubsetsRule : ruleSubsetsRule EOF ;
    public final void entryRuleSubsetsRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:286:1: ( ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:287:1: ruleSubsetsRule EOF
            {
             before(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule541);
            ruleSubsetsRule();
            _fsp--;

             after(grammarAccess.getSubsetsRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule548); 

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
    // $ANTLR end entryRuleSubsetsRule


    // $ANTLR start ruleSubsetsRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:294:1: ruleSubsetsRule : ( ( rule__SubsetsRule__Group__0 ) ) ;
    public final void ruleSubsetsRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:298:2: ( ( ( rule__SubsetsRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:299:1: ( ( rule__SubsetsRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:299:1: ( ( rule__SubsetsRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:300:1: ( rule__SubsetsRule__Group__0 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:301:1: ( rule__SubsetsRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:301:2: rule__SubsetsRule__Group__0
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule574);
            rule__SubsetsRule__Group__0();
            _fsp--;


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
    // $ANTLR end ruleSubsetsRule


    // $ANTLR start entryRuleDefaultValueRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:313:1: entryRuleDefaultValueRule : ruleDefaultValueRule EOF ;
    public final void entryRuleDefaultValueRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:314:1: ( ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:315:1: ruleDefaultValueRule EOF
            {
             before(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule601);
            ruleDefaultValueRule();
            _fsp--;

             after(grammarAccess.getDefaultValueRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule608); 

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
    // $ANTLR end entryRuleDefaultValueRule


    // $ANTLR start ruleDefaultValueRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:322:1: ruleDefaultValueRule : ( ( rule__DefaultValueRule__Group__0 ) ) ;
    public final void ruleDefaultValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:326:2: ( ( ( rule__DefaultValueRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:327:1: ( ( rule__DefaultValueRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:327:1: ( ( rule__DefaultValueRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:328:1: ( rule__DefaultValueRule__Group__0 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:329:1: ( rule__DefaultValueRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:329:2: rule__DefaultValueRule__Group__0
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule634);
            rule__DefaultValueRule__Group__0();
            _fsp--;


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
    // $ANTLR end ruleDefaultValueRule


    // $ANTLR start ruleVisibilityKind
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:342:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:346:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:347:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:347:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:348:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:349:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:349:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind671);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:361:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:365:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:366:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:366:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:367:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:368:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:368:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind707);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:379:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__PropertyRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:383:1: ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
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
                    new NoViableAltException("379:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:384:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:384:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:385:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:386:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:386:2: rule__PropertyRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4742);
                    rule__PropertyRule__TypeAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:390:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:390:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:391:1: '<Undefined>'
                    {
                     before(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,12,FOLLOW_12_in_rule__PropertyRule__Alternatives_4761); 
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


    // $ANTLR start rule__ModifierSpecification__Alternatives
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:403:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );
    public final void rule__ModifierSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:407:1: ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 17:
            case 18:
            case 19:
            case 20:
                {
                alt2=1;
                }
                break;
            case 29:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("403:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:408:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:408:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:409:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:410:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:410:2: rule__ModifierSpecification__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives795);
                    rule__ModifierSpecification__ValueAssignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:414:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:414:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:415:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:416:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:416:2: rule__ModifierSpecification__RedefinesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives813);
                    rule__ModifierSpecification__RedefinesAssignment_1();
                    _fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:420:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:420:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:421:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:422:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:422:2: rule__ModifierSpecification__SubsetsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives831);
                    rule__ModifierSpecification__SubsetsAssignment_2();
                    _fsp--;


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
    // $ANTLR end rule__ModifierSpecification__Alternatives


    // $ANTLR start rule__VisibilityKind__Alternatives
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:431:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:435:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
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
                    new NoViableAltException("431:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:436:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:436:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:437:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:438:1: ( '+' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:438:3: '+'
                    {
                    match(input,13,FOLLOW_13_in_rule__VisibilityKind__Alternatives865); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:443:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:443:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:444:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:445:1: ( '-' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:445:3: '-'
                    {
                    match(input,14,FOLLOW_14_in_rule__VisibilityKind__Alternatives886); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:450:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:450:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:451:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:452:1: ( '#' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:452:3: '#'
                    {
                    match(input,15,FOLLOW_15_in_rule__VisibilityKind__Alternatives907); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:457:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:457:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:458:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:459:1: ( '~' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:459:3: '~'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives928); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:469:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:473:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
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
                    new NoViableAltException("469:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:474:1: ( ( 'readOnly' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:474:1: ( ( 'readOnly' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:475:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:476:1: ( 'readOnly' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:476:3: 'readOnly'
                    {
                    match(input,17,FOLLOW_17_in_rule__ModifierKind__Alternatives964); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:481:6: ( ( 'union' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:481:6: ( ( 'union' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:482:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:483:1: ( 'union' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:483:3: 'union'
                    {
                    match(input,18,FOLLOW_18_in_rule__ModifierKind__Alternatives985); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:488:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:488:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:489:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:490:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:490:3: 'ordered'
                    {
                    match(input,19,FOLLOW_19_in_rule__ModifierKind__Alternatives1006); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:495:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:495:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:496:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:497:1: ( 'unique' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:497:3: 'unique'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives1027); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:509:1: rule__PropertyRule__Group__0 : rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 ;
    public final void rule__PropertyRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:513:1: ( rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:514:2: rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__01060);
            rule__PropertyRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__01063);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:521:1: rule__PropertyRule__Group__0__Impl : ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) ;
    public final void rule__PropertyRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:525:1: ( ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:526:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:526:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:527:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:528:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:528:2: rule__PropertyRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl1090);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:538:1: rule__PropertyRule__Group__1 : rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 ;
    public final void rule__PropertyRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:542:1: ( rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:543:2: rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__11120);
            rule__PropertyRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__11123);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:550:1: rule__PropertyRule__Group__1__Impl : ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) ;
    public final void rule__PropertyRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:554:1: ( ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:555:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:555:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:556:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:557:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==32) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:557:2: rule__PropertyRule__IsDerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl1150);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:567:1: rule__PropertyRule__Group__2 : rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 ;
    public final void rule__PropertyRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:571:1: ( rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:572:2: rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__21181);
            rule__PropertyRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__21184);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:579:1: rule__PropertyRule__Group__2__Impl : ( ( rule__PropertyRule__NameAssignment_2 ) ) ;
    public final void rule__PropertyRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:583:1: ( ( ( rule__PropertyRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:584:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:584:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:585:1: ( rule__PropertyRule__NameAssignment_2 )
            {
             before(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:586:1: ( rule__PropertyRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:586:2: rule__PropertyRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl1211);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:596:1: rule__PropertyRule__Group__3 : rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 ;
    public final void rule__PropertyRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:600:1: ( rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:601:2: rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__31241);
            rule__PropertyRule__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__31244);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:608:1: rule__PropertyRule__Group__3__Impl : ( ':' ) ;
    public final void rule__PropertyRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:612:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:613:1: ( ':' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:613:1: ( ':' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:614:1: ':'
            {
             before(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__PropertyRule__Group__3__Impl1272); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:627:1: rule__PropertyRule__Group__4 : rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 ;
    public final void rule__PropertyRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:631:1: ( rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:632:2: rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41303);
            rule__PropertyRule__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41306);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:639:1: rule__PropertyRule__Group__4__Impl : ( ( rule__PropertyRule__Alternatives_4 ) ) ;
    public final void rule__PropertyRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:643:1: ( ( ( rule__PropertyRule__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:644:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:644:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:645:1: ( rule__PropertyRule__Alternatives_4 )
            {
             before(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:646:1: ( rule__PropertyRule__Alternatives_4 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:646:2: rule__PropertyRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1333);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:656:1: rule__PropertyRule__Group__5 : rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 ;
    public final void rule__PropertyRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:660:1: ( rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:661:2: rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51363);
            rule__PropertyRule__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51366);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:668:1: rule__PropertyRule__Group__5__Impl : ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__PropertyRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:672:1: ( ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:673:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:673:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:674:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:675:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:675:2: rule__PropertyRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1393);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:685:1: rule__PropertyRule__Group__6 : rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7 ;
    public final void rule__PropertyRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:689:1: ( rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:690:2: rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61424);
            rule__PropertyRule__Group__6__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__7_in_rule__PropertyRule__Group__61427);
            rule__PropertyRule__Group__7();
            _fsp--;


            }

        }
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:697:1: rule__PropertyRule__Group__6__Impl : ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) ;
    public final void rule__PropertyRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:701:1: ( ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:702:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:702:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:703:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:704:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:704:2: rule__PropertyRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1454);
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


    // $ANTLR start rule__PropertyRule__Group__7
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:714:1: rule__PropertyRule__Group__7 : rule__PropertyRule__Group__7__Impl ;
    public final void rule__PropertyRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:718:1: ( rule__PropertyRule__Group__7__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:719:2: rule__PropertyRule__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__7__Impl_in_rule__PropertyRule__Group__71485);
            rule__PropertyRule__Group__7__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyRule__Group__7


    // $ANTLR start rule__PropertyRule__Group__7__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:725:1: rule__PropertyRule__Group__7__Impl : ( ( rule__PropertyRule__DefaultAssignment_7 )? ) ;
    public final void rule__PropertyRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:729:1: ( ( ( rule__PropertyRule__DefaultAssignment_7 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:730:1: ( ( rule__PropertyRule__DefaultAssignment_7 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:730:1: ( ( rule__PropertyRule__DefaultAssignment_7 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:731:1: ( rule__PropertyRule__DefaultAssignment_7 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_7()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:732:1: ( rule__PropertyRule__DefaultAssignment_7 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==31) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:732:2: rule__PropertyRule__DefaultAssignment_7
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__DefaultAssignment_7_in_rule__PropertyRule__Group__7__Impl1512);
                    rule__PropertyRule__DefaultAssignment_7();
                    _fsp--;


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
    // $ANTLR end rule__PropertyRule__Group__7__Impl


    // $ANTLR start rule__TypeRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:758:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:762:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:763:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01559);
            rule__TypeRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01562);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:770:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:774:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:775:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:775:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:776:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:777:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==22) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:777:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1589);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:787:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:791:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:792:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11620);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:798:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:802:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:803:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:803:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:804:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:805:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:805:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1647);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:819:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:823:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:824:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01681);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01684);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:831:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:835:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:836:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:836:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:837:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:838:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:838:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1711);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:848:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:852:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:853:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11741);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11744);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:860:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:864:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:865:1: ( '::' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:865:1: ( '::' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:866:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,22,FOLLOW_22_in_rule__QualifiedName__Group__1__Impl1772); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:879:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:883:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:884:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21803);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:890:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:894:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:895:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:895:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:896:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:897:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==22) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:897:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1830);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:913:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:917:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:918:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01867);
            rule__MultiplicityRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01870);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:925:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:929:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:930:1: ( '[' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:930:1: ( '[' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:931:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__MultiplicityRule__Group__0__Impl1898); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:944:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:948:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:949:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__11929);
            rule__MultiplicityRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__11932);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:956:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:960:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:961:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:961:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:962:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:963:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:963:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl1959);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:973:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:977:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:978:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__21989);
            rule__MultiplicityRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__21992);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:985:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:989:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:990:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:990:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:991:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:992:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:992:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2019);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1002:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1006:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1007:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32050);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1013:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1017:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1018:1: ( ']' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1018:1: ( ']' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1019:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__MultiplicityRule__Group__3__Impl2078); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1040:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1044:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1045:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02117);
            rule__MultiplicityRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02120);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1052:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1056:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1057:1: ( '..' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1057:1: ( '..' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1058:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,25,FOLLOW_25_in_rule__MultiplicityRule__Group_2__0__Impl2148); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1071:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1075:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1076:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12179);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1082:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1086:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1087:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1087:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1088:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1089:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1089:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2206);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1103:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1107:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1108:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02240);
            rule__ModifiersRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02243);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1115:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1119:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1120:1: ( '{' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1120:1: ( '{' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1121:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__ModifiersRule__Group__0__Impl2271); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1134:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1138:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1139:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12302);
            rule__ModifiersRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12305);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1146:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1150:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1151:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1151:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1152:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1153:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1153:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2332);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1163:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1167:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1168:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22362);
            rule__ModifiersRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22365);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1175:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1179:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1180:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1180:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1181:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1182:1: ( rule__ModifiersRule__Group_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1182:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2392);
            	    rule__ModifiersRule__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1192:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1196:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1197:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32423);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1203:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1207:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1208:1: ( '}' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1208:1: ( '}' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1209:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,27,FOLLOW_27_in_rule__ModifiersRule__Group__3__Impl2451); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1230:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1234:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1235:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02490);
            rule__ModifiersRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02493);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1242:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1246:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1247:1: ( ',' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1247:1: ( ',' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1248:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,28,FOLLOW_28_in_rule__ModifiersRule__Group_2__0__Impl2521); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1261:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1265:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1266:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12552);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1272:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1276:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1277:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1277:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1278:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1279:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1279:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2579);
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


    // $ANTLR start rule__RedefinesRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1293:1: rule__RedefinesRule__Group__0 : rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 ;
    public final void rule__RedefinesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1297:1: ( rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1298:2: rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__02613);
            rule__RedefinesRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__02616);
            rule__RedefinesRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RedefinesRule__Group__0


    // $ANTLR start rule__RedefinesRule__Group__0__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1305:1: rule__RedefinesRule__Group__0__Impl : ( 'redefines' ) ;
    public final void rule__RedefinesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1309:1: ( ( 'redefines' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1310:1: ( 'redefines' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1310:1: ( 'redefines' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1311:1: 'redefines'
            {
             before(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__RedefinesRule__Group__0__Impl2644); 
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
    // $ANTLR end rule__RedefinesRule__Group__0__Impl


    // $ANTLR start rule__RedefinesRule__Group__1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1324:1: rule__RedefinesRule__Group__1 : rule__RedefinesRule__Group__1__Impl ;
    public final void rule__RedefinesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1328:1: ( rule__RedefinesRule__Group__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1329:2: rule__RedefinesRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__12675);
            rule__RedefinesRule__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RedefinesRule__Group__1


    // $ANTLR start rule__RedefinesRule__Group__1__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1335:1: rule__RedefinesRule__Group__1__Impl : ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) ;
    public final void rule__RedefinesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1339:1: ( ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1340:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1340:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1341:1: ( rule__RedefinesRule__PropertyAssignment_1 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1342:1: ( rule__RedefinesRule__PropertyAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1342:2: rule__RedefinesRule__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__PropertyAssignment_1_in_rule__RedefinesRule__Group__1__Impl2702);
            rule__RedefinesRule__PropertyAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__RedefinesRule__Group__1__Impl


    // $ANTLR start rule__SubsetsRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1356:1: rule__SubsetsRule__Group__0 : rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 ;
    public final void rule__SubsetsRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1360:1: ( rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1361:2: rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__02736);
            rule__SubsetsRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__02739);
            rule__SubsetsRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubsetsRule__Group__0


    // $ANTLR start rule__SubsetsRule__Group__0__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1368:1: rule__SubsetsRule__Group__0__Impl : ( 'subsets' ) ;
    public final void rule__SubsetsRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1372:1: ( ( 'subsets' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1373:1: ( 'subsets' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1373:1: ( 'subsets' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1374:1: 'subsets'
            {
             before(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__SubsetsRule__Group__0__Impl2767); 
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
    // $ANTLR end rule__SubsetsRule__Group__0__Impl


    // $ANTLR start rule__SubsetsRule__Group__1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1387:1: rule__SubsetsRule__Group__1 : rule__SubsetsRule__Group__1__Impl ;
    public final void rule__SubsetsRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1391:1: ( rule__SubsetsRule__Group__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1392:2: rule__SubsetsRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__12798);
            rule__SubsetsRule__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubsetsRule__Group__1


    // $ANTLR start rule__SubsetsRule__Group__1__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1398:1: rule__SubsetsRule__Group__1__Impl : ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) ;
    public final void rule__SubsetsRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1402:1: ( ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1403:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1403:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1404:1: ( rule__SubsetsRule__PropertyAssignment_1 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1405:1: ( rule__SubsetsRule__PropertyAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1405:2: rule__SubsetsRule__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__PropertyAssignment_1_in_rule__SubsetsRule__Group__1__Impl2825);
            rule__SubsetsRule__PropertyAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__SubsetsRule__Group__1__Impl


    // $ANTLR start rule__DefaultValueRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1419:1: rule__DefaultValueRule__Group__0 : rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 ;
    public final void rule__DefaultValueRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1423:1: ( rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1424:2: rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__02859);
            rule__DefaultValueRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__02862);
            rule__DefaultValueRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DefaultValueRule__Group__0


    // $ANTLR start rule__DefaultValueRule__Group__0__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1431:1: rule__DefaultValueRule__Group__0__Impl : ( '=' ) ;
    public final void rule__DefaultValueRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1435:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1436:1: ( '=' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1436:1: ( '=' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1437:1: '='
            {
             before(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__DefaultValueRule__Group__0__Impl2890); 
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
    // $ANTLR end rule__DefaultValueRule__Group__0__Impl


    // $ANTLR start rule__DefaultValueRule__Group__1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1450:1: rule__DefaultValueRule__Group__1 : rule__DefaultValueRule__Group__1__Impl ;
    public final void rule__DefaultValueRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1454:1: ( rule__DefaultValueRule__Group__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1455:2: rule__DefaultValueRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__12921);
            rule__DefaultValueRule__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DefaultValueRule__Group__1


    // $ANTLR start rule__DefaultValueRule__Group__1__Impl
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1461:1: rule__DefaultValueRule__Group__1__Impl : ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) ;
    public final void rule__DefaultValueRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1465:1: ( ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1466:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1466:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1467:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1468:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1468:2: rule__DefaultValueRule__DefaultAssignment_1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl2948);
            rule__DefaultValueRule__DefaultAssignment_1();
            _fsp--;


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
    // $ANTLR end rule__DefaultValueRule__Group__1__Impl


    // $ANTLR start rule__PropertyRule__VisibilityAssignment_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1483:1: rule__PropertyRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__PropertyRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1487:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1488:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1488:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1489:1: ruleVisibilityKind
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_02987);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1498:1: rule__PropertyRule__IsDerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PropertyRule__IsDerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1502:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1503:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1503:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1504:1: ( '/' )
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1505:1: ( '/' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1506:1: '/'
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__PropertyRule__IsDerivedAssignment_13023); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1521:1: rule__PropertyRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PropertyRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1525:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1526:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1526:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1527:1: RULE_ID
            {
             before(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_23062); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1536:1: rule__PropertyRule__TypeAssignment_4_0 : ( ruleTypeRule ) ;
    public final void rule__PropertyRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1540:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1541:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1541:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1542:1: ruleTypeRule
            {
             before(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_03093);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1551:1: rule__PropertyRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__PropertyRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1555:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1556:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1556:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1557:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_53124);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1566:1: rule__PropertyRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__PropertyRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1570:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1571:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1571:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1572:1: ruleModifiersRule
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_63155);
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


    // $ANTLR start rule__PropertyRule__DefaultAssignment_7
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1581:1: rule__PropertyRule__DefaultAssignment_7 : ( ruleDefaultValueRule ) ;
    public final void rule__PropertyRule__DefaultAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1585:1: ( ( ruleDefaultValueRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1586:1: ( ruleDefaultValueRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1586:1: ( ruleDefaultValueRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1587:1: ruleDefaultValueRule
            {
             before(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_rule__PropertyRule__DefaultAssignment_73186);
            ruleDefaultValueRule();
            _fsp--;

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
    // $ANTLR end rule__PropertyRule__DefaultAssignment_7


    // $ANTLR start rule__TypeRule__PathAssignment_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1596:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1600:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1601:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1601:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1602:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03217);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1611:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1615:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1616:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1616:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1617:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1618:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1619:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13252); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1630:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1634:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1635:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1635:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1636:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1637:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1638:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03291); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1649:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1653:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1654:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1654:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1655:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23326);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1664:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1668:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1669:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1669:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1670:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13357);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1679:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1683:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1684:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1684:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1685:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13388);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1694:1: rule__BoundSpecification__ValueAssignment : ( RULE_UNLIMITEDLITERAL ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1698:1: ( ( RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1699:1: ( RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1699:1: ( RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1700:1: RULE_UNLIMITEDLITERAL
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); 
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment3419); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1709:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1713:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1714:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1714:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1715:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13450);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1724:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1728:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1729:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1729:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1730:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13481);
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


    // $ANTLR start rule__ModifierSpecification__ValueAssignment_0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1739:1: rule__ModifierSpecification__ValueAssignment_0 : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1743:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1744:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1744:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1745:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_03512);
            ruleModifierKind();
            _fsp--;

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
    // $ANTLR end rule__ModifierSpecification__ValueAssignment_0


    // $ANTLR start rule__ModifierSpecification__RedefinesAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1754:1: rule__ModifierSpecification__RedefinesAssignment_1 : ( ruleRedefinesRule ) ;
    public final void rule__ModifierSpecification__RedefinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1758:1: ( ( ruleRedefinesRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1759:1: ( ruleRedefinesRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1759:1: ( ruleRedefinesRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1760:1: ruleRedefinesRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_13543);
            ruleRedefinesRule();
            _fsp--;

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
    // $ANTLR end rule__ModifierSpecification__RedefinesAssignment_1


    // $ANTLR start rule__ModifierSpecification__SubsetsAssignment_2
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1769:1: rule__ModifierSpecification__SubsetsAssignment_2 : ( ruleSubsetsRule ) ;
    public final void rule__ModifierSpecification__SubsetsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1773:1: ( ( ruleSubsetsRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1774:1: ( ruleSubsetsRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1774:1: ( ruleSubsetsRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1775:1: ruleSubsetsRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_23574);
            ruleSubsetsRule();
            _fsp--;

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
    // $ANTLR end rule__ModifierSpecification__SubsetsAssignment_2


    // $ANTLR start rule__RedefinesRule__PropertyAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1784:1: rule__RedefinesRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RedefinesRule__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1788:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1789:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1789:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1790:1: ( RULE_ID )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1791:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1792:1: RULE_ID
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RedefinesRule__PropertyAssignment_13609); 
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
    // $ANTLR end rule__RedefinesRule__PropertyAssignment_1


    // $ANTLR start rule__SubsetsRule__PropertyAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1803:1: rule__SubsetsRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubsetsRule__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1807:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1808:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1808:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1809:1: ( RULE_ID )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1810:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1811:1: RULE_ID
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubsetsRule__PropertyAssignment_13648); 
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
    // $ANTLR end rule__SubsetsRule__PropertyAssignment_1


    // $ANTLR start rule__DefaultValueRule__DefaultAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1822:1: rule__DefaultValueRule__DefaultAssignment_1 : ( RULE_STRING ) ;
    public final void rule__DefaultValueRule__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1826:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1827:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1827:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1828:1: RULE_STRING
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_13683); 
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
    // $ANTLR end rule__DefaultValueRule__DefaultAssignment_1


 

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
    public static final BitSet FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PropertyRule__Alternatives_4761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VisibilityKind__Alternatives865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VisibilityKind__Alternatives886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VisibilityKind__Alternatives907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ModifierKind__Alternatives964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ModifierKind__Alternatives985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ModifierKind__Alternatives1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ModifierKind__Alternatives1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__01060 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__01063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__11120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__11123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__21181 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__21184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__31241 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__31244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PropertyRule__Group__3__Impl1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41303 = new BitSet(new long[]{0x0000000084800002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51363 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61424 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__7_in_rule__PropertyRule__Group__61427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__7__Impl_in_rule__PropertyRule__Group__71485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__DefaultAssignment_7_in_rule__PropertyRule__Group__7__Impl1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__01559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__01562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__11620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01681 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11741 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__QualifiedName__Group__1__Impl1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01867 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MultiplicityRule__Group__0__Impl1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__11929 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__11932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__21989 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__21992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MultiplicityRule__Group__3__Impl2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02117 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MultiplicityRule__Group_2__0__Impl2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02240 = new BitSet(new long[]{0x00000000601E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ModifiersRule__Group__0__Impl2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12302 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22362 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2392 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ModifiersRule__Group__3__Impl2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02490 = new BitSet(new long[]{0x00000000601E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ModifiersRule__Group_2__0__Impl2521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__12552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__02613 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__02616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RedefinesRule__Group__0__Impl2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__12675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__PropertyAssignment_1_in_rule__RedefinesRule__Group__1__Impl2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__02736 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__02739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__SubsetsRule__Group__0__Impl2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__12798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__PropertyAssignment_1_in_rule__SubsetsRule__Group__1__Impl2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__02859 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__02862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__DefaultValueRule__Group__0__Impl2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__12921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_02987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__PropertyRule__IsDerivedAssignment_13023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_23062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_03093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_53124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_63155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rule__PropertyRule__DefaultAssignment_73186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_03512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_13543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_23574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RedefinesRule__PropertyAssignment_13609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubsetsRule__PropertyAssignment_13648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_13683 = new BitSet(new long[]{0x0000000000000002L});

}