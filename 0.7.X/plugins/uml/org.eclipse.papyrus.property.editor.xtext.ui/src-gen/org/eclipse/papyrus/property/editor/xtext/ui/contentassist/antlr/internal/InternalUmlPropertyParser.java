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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "':'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'/'"
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


    // $ANTLR start entryRuleMultiplicityRule
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:89:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:90:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:91:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule121);
            ruleMultiplicityRule();
            _fsp--;

             after(grammarAccess.getMultiplicityRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule128); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:98:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:102:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:103:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:103:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:104:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:105:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:105:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule154);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:117:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:118:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:119:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification181);
            ruleBoundSpecification();
            _fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification188); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:126:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:130:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:131:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:131:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:132:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:133:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:133:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification214);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:145:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:146:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:147:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule241);
            ruleModifiersRule();
            _fsp--;

             after(grammarAccess.getModifiersRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule248); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:154:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:158:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:159:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:159:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:160:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:161:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:161:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule274);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:173:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:174:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:175:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification301);
            ruleModifierSpecification();
            _fsp--;

             after(grammarAccess.getModifierSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification308); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:182:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__ValueAssignment ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:186:2: ( ( ( rule__ModifierSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:187:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:187:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:188:1: ( rule__ModifierSpecification__ValueAssignment )
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:189:1: ( rule__ModifierSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:189:2: rule__ModifierSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification334);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:202:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:206:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:207:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:207:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:208:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:209:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:209:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind371);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:221:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:225:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:226:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:226:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:227:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:228:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:228:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind407);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:239:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__PropertyRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:243:1: ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
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
                    new NoViableAltException("239:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:244:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:244:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:245:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:246:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:246:2: rule__PropertyRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4442);
                    rule__PropertyRule__TypeAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:250:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:250:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:251:1: '<Undefined>'
                    {
                     before(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,12,FOLLOW_12_in_rule__PropertyRule__Alternatives_4461); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:263:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:267:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
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
                    new NoViableAltException("263:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:268:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:268:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:269:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:270:1: ( '+' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:270:3: '+'
                    {
                    match(input,13,FOLLOW_13_in_rule__VisibilityKind__Alternatives496); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:275:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:275:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:276:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:277:1: ( '-' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:277:3: '-'
                    {
                    match(input,14,FOLLOW_14_in_rule__VisibilityKind__Alternatives517); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:282:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:282:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:283:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:284:1: ( '#' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:284:3: '#'
                    {
                    match(input,15,FOLLOW_15_in_rule__VisibilityKind__Alternatives538); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:289:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:289:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:290:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:291:1: ( '~' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:291:3: '~'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives559); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:301:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:305:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
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
                    new NoViableAltException("301:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:306:1: ( ( 'readOnly' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:306:1: ( ( 'readOnly' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:307:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:308:1: ( 'readOnly' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:308:3: 'readOnly'
                    {
                    match(input,17,FOLLOW_17_in_rule__ModifierKind__Alternatives595); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:313:6: ( ( 'union' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:313:6: ( ( 'union' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:314:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:315:1: ( 'union' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:315:3: 'union'
                    {
                    match(input,18,FOLLOW_18_in_rule__ModifierKind__Alternatives616); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:320:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:320:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:321:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:322:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:322:3: 'ordered'
                    {
                    match(input,19,FOLLOW_19_in_rule__ModifierKind__Alternatives637); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:327:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:327:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:328:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:329:1: ( 'unique' )
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:329:3: 'unique'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives658); 

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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:341:1: rule__PropertyRule__Group__0 : rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 ;
    public final void rule__PropertyRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:345:1: ( rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:346:2: rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__0691);
            rule__PropertyRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__0694);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:353:1: rule__PropertyRule__Group__0__Impl : ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) ;
    public final void rule__PropertyRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:357:1: ( ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:358:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:358:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:359:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:360:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:360:2: rule__PropertyRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl721);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:370:1: rule__PropertyRule__Group__1 : rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 ;
    public final void rule__PropertyRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:374:1: ( rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:375:2: rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__1751);
            rule__PropertyRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__1754);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:382:1: rule__PropertyRule__Group__1__Impl : ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) ;
    public final void rule__PropertyRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:386:1: ( ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:387:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:387:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:388:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:389:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:389:2: rule__PropertyRule__IsDerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl781);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:399:1: rule__PropertyRule__Group__2 : rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 ;
    public final void rule__PropertyRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:403:1: ( rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:404:2: rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__2812);
            rule__PropertyRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__2815);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:411:1: rule__PropertyRule__Group__2__Impl : ( ( rule__PropertyRule__NameAssignment_2 ) ) ;
    public final void rule__PropertyRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:415:1: ( ( ( rule__PropertyRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:416:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:416:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:417:1: ( rule__PropertyRule__NameAssignment_2 )
            {
             before(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:418:1: ( rule__PropertyRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:418:2: rule__PropertyRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl842);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:428:1: rule__PropertyRule__Group__3 : rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 ;
    public final void rule__PropertyRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:432:1: ( rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:433:2: rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__3872);
            rule__PropertyRule__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__3875);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:440:1: rule__PropertyRule__Group__3__Impl : ( ':' ) ;
    public final void rule__PropertyRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:444:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:445:1: ( ':' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:445:1: ( ':' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:446:1: ':'
            {
             before(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 
            match(input,21,FOLLOW_21_in_rule__PropertyRule__Group__3__Impl903); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:459:1: rule__PropertyRule__Group__4 : rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 ;
    public final void rule__PropertyRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:463:1: ( rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:464:2: rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__4934);
            rule__PropertyRule__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__4937);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:471:1: rule__PropertyRule__Group__4__Impl : ( ( rule__PropertyRule__Alternatives_4 ) ) ;
    public final void rule__PropertyRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:475:1: ( ( ( rule__PropertyRule__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:476:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:476:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:477:1: ( rule__PropertyRule__Alternatives_4 )
            {
             before(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:478:1: ( rule__PropertyRule__Alternatives_4 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:478:2: rule__PropertyRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl964);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:488:1: rule__PropertyRule__Group__5 : rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 ;
    public final void rule__PropertyRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:492:1: ( rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:493:2: rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__5994);
            rule__PropertyRule__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__5997);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:500:1: rule__PropertyRule__Group__5__Impl : ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__PropertyRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:504:1: ( ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:505:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:505:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:506:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:507:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:507:2: rule__PropertyRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1024);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:517:1: rule__PropertyRule__Group__6 : rule__PropertyRule__Group__6__Impl ;
    public final void rule__PropertyRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:521:1: ( rule__PropertyRule__Group__6__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:522:2: rule__PropertyRule__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61055);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:528:1: rule__PropertyRule__Group__6__Impl : ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) ;
    public final void rule__PropertyRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:532:1: ( ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:533:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:533:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:534:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:535:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:535:2: rule__PropertyRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1082);
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


    // $ANTLR start rule__MultiplicityRule__Group__0
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:559:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:563:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:564:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01127);
            rule__MultiplicityRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01130);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:571:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:575:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:576:1: ( '[' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:576:1: ( '[' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:577:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MultiplicityRule__Group__0__Impl1158); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:590:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:594:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:595:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__11189);
            rule__MultiplicityRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__11192);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:602:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:606:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:607:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:607:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:608:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:609:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:609:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl1219);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:619:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:623:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:624:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__21249);
            rule__MultiplicityRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__21252);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:631:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:635:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:636:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:636:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:637:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:638:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:638:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl1279);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:648:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:652:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:653:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__31310);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:659:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:663:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:664:1: ( ']' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:664:1: ( ']' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:665:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,23,FOLLOW_23_in_rule__MultiplicityRule__Group__3__Impl1338); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:686:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:690:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:691:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__01377);
            rule__MultiplicityRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__01380);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:698:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:702:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:703:1: ( '..' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:703:1: ( '..' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:704:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,24,FOLLOW_24_in_rule__MultiplicityRule__Group_2__0__Impl1408); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:717:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:721:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:722:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__11439);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:728:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:732:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:733:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:733:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:734:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:735:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:735:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl1466);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:749:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:753:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:754:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01500);
            rule__ModifiersRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01503);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:761:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:765:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:766:1: ( '{' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:766:1: ( '{' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:767:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__ModifiersRule__Group__0__Impl1531); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:780:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:784:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:785:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11562);
            rule__ModifiersRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11565);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:792:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:796:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:797:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:797:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:798:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:799:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:799:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl1592);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:809:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:813:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:814:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__21622);
            rule__ModifiersRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__21625);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:821:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:825:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:826:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:826:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:827:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:828:1: ( rule__ModifiersRule__Group_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:828:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl1652);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:838:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:842:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:843:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__31683);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:849:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:853:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:854:1: ( '}' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:854:1: ( '}' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:855:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__ModifiersRule__Group__3__Impl1711); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:876:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:880:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:881:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__01750);
            rule__ModifiersRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__01753);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:888:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:892:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:893:1: ( ',' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:893:1: ( ',' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:894:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__ModifiersRule__Group_2__0__Impl1781); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:907:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:911:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:912:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__11812);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:918:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:922:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:923:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:923:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:924:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:925:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:925:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl1839);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:940:1: rule__PropertyRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__PropertyRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:944:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:945:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:945:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:946:1: ruleVisibilityKind
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_01878);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:955:1: rule__PropertyRule__IsDerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PropertyRule__IsDerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:959:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:960:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:960:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:961:1: ( '/' )
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:962:1: ( '/' )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:963:1: '/'
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__PropertyRule__IsDerivedAssignment_11914); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:978:1: rule__PropertyRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PropertyRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:982:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:983:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:983:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:984:1: RULE_ID
            {
             before(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_21953); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:993:1: rule__PropertyRule__TypeAssignment_4_0 : ( ( RULE_ID ) ) ;
    public final void rule__PropertyRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:997:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:998:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:998:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:999:1: ( RULE_ID )
            {
             before(grammarAccess.getPropertyRuleAccess().getTypeClassifierCrossReference_4_0_0()); 
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1000:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1001:1: RULE_ID
            {
             before(grammarAccess.getPropertyRuleAccess().getTypeClassifierIDTerminalRuleCall_4_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyRule__TypeAssignment_4_01988); 
             after(grammarAccess.getPropertyRuleAccess().getTypeClassifierIDTerminalRuleCall_4_0_0_1()); 

            }

             after(grammarAccess.getPropertyRuleAccess().getTypeClassifierCrossReference_4_0_0()); 

            }


            }

        }
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1012:1: rule__PropertyRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__PropertyRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1016:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1017:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1017:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1018:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_52023);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1027:1: rule__PropertyRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__PropertyRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1031:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1032:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1032:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1033:1: ruleModifiersRule
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_62054);
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


    // $ANTLR start rule__MultiplicityRule__BoundsAssignment_1
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1042:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1046:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1047:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1047:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1048:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_12085);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1057:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1061:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1062:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1062:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1063:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_12116);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1072:1: rule__BoundSpecification__ValueAssignment : ( RULE_UNLIMITEDLITERAL ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1076:1: ( ( RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1077:1: ( RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1077:1: ( RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1078:1: RULE_UNLIMITEDLITERAL
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); 
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment2147); 
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1087:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1091:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1092:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1092:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1093:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_12178);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1102:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1106:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1107:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1107:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1108:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_12209);
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
    // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1117:1: rule__ModifierSpecification__ValueAssignment : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1121:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1122:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1122:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g:1123:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment2240);
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
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PropertyRule__Alternatives_4461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VisibilityKind__Alternatives496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VisibilityKind__Alternatives517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VisibilityKind__Alternatives538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ModifierKind__Alternatives595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ModifierKind__Alternatives616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ModifierKind__Alternatives637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ModifierKind__Alternatives658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__0691 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__0694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__1751 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__2812 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__3872 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PropertyRule__Group__3__Impl903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__4934 = new BitSet(new long[]{0x0000000002400002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__4937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__5994 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__5997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__01127 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__01130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MultiplicityRule__Group__0__Impl1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__11189 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__11192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__21249 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__21252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__31310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MultiplicityRule__Group__3__Impl1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__01377 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__01380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MultiplicityRule__Group_2__0__Impl1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__11439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01500 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ModifiersRule__Group__0__Impl1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11562 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__21622 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__21625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl1652 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__31683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ModifiersRule__Group__3__Impl1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__01750 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__01753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ModifiersRule__Group_2__0__Impl1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__11812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_01878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PropertyRule__IsDerivedAssignment_11914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_21953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyRule__TypeAssignment_4_01988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_52023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_62054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_12085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_12116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_12178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_12209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment2240 = new BitSet(new long[]{0x0000000000000002L});

}