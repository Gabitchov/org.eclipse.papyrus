package org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr.internal; 

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

@SuppressWarnings("all")
public class InternalUmlCommonParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'::'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalUmlCommonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlCommonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlCommonParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g"; }


     
     	private UmlCommonGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlCommonGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:60:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:61:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:62:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName61);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName68); 

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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:69:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:73:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:74:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:74:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:75:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:76:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:76:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName94);
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


    // $ANTLR start "entryRuleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:92:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:93:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:94:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification125);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification132); 

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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:101:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:105:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:106:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:106:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:107:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:108:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:108:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification158);
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:120:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
    public final void entryRuleUnlimitedLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:121:1: ( ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:122:1: ruleUnlimitedLiteral EOF
            {
             before(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral185);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getUnlimitedLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral192); 

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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:129:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
    public final void ruleUnlimitedLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:133:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:134:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:134:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:135:1: ( rule__UnlimitedLiteral__Alternatives )
            {
             before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:136:1: ( rule__UnlimitedLiteral__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:136:2: rule__UnlimitedLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral218);
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


    // $ANTLR start "rule__UnlimitedLiteral__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:152:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:156:1: ( ( RULE_INT ) | ( '*' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_INT) ) {
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
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:157:1: ( RULE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:157:1: ( RULE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:158:1: RULE_INT
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives258); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:163:6: ( '*' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:163:6: ( '*' )
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:164:1: '*'
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                    match(input,11,FOLLOW_11_in_rule__UnlimitedLiteral__Alternatives276); 
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:180:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:184:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:185:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0310);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0313);
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:192:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:196:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:197:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:197:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:198:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:199:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:199:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl340);
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:209:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:213:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:214:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1370);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__1373);
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:221:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:225:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:226:1: ( '::' )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:226:1: ( '::' )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:227:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__QualifiedName__Group__1__Impl401); 
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:240:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:244:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:245:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__2432);
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:251:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:255:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:256:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:256:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:257:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:258:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:258:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl459);
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


    // $ANTLR start "rule__QualifiedName__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:278:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:282:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:283:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:283:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:284:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:285:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:286:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_0508); 
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
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:297:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:301:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:302:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:302:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:303:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_2543);
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


    // $ANTLR start "rule__BoundSpecification__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:316:1: rule__BoundSpecification__ValueAssignment : ( ruleUnlimitedLiteral ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:320:1: ( ( ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:321:1: ( ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:321:1: ( ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.common.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:322:1: ruleUnlimitedLiteral
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment578);
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


 

    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral185 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__UnlimitedLiteral__Alternatives276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0310 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1370 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedName__Group__1__Impl401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_0508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment578 = new BitSet(new long[]{0x0000000000000002L});

}