package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.services.UMLConnectionPointReferenceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUMLConnectionPointReferenceParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entry'", "','", "'exit'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalUMLConnectionPointReferenceParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUMLConnectionPointReferenceParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUMLConnectionPointReferenceParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g"; }


     
     	private UMLConnectionPointReferenceGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UMLConnectionPointReferenceGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleConnectionPointReferenceRule"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:60:1: entryRuleConnectionPointReferenceRule : ruleConnectionPointReferenceRule EOF ;
    public final void entryRuleConnectionPointReferenceRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:61:1: ( ruleConnectionPointReferenceRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:62:1: ruleConnectionPointReferenceRule EOF
            {
             before(grammarAccess.getConnectionPointReferenceRuleRule()); 
            pushFollow(FOLLOW_ruleConnectionPointReferenceRule_in_entryRuleConnectionPointReferenceRule61);
            ruleConnectionPointReferenceRule();

            state._fsp--;

             after(grammarAccess.getConnectionPointReferenceRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionPointReferenceRule68); 

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
    // $ANTLR end "entryRuleConnectionPointReferenceRule"


    // $ANTLR start "ruleConnectionPointReferenceRule"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:69:1: ruleConnectionPointReferenceRule : ( ( rule__ConnectionPointReferenceRule__Alternatives )? ) ;
    public final void ruleConnectionPointReferenceRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:73:2: ( ( ( rule__ConnectionPointReferenceRule__Alternatives )? ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:74:1: ( ( rule__ConnectionPointReferenceRule__Alternatives )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:74:1: ( ( rule__ConnectionPointReferenceRule__Alternatives )? )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:75:1: ( rule__ConnectionPointReferenceRule__Alternatives )?
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:76:1: ( rule__ConnectionPointReferenceRule__Alternatives )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11||LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:76:2: rule__ConnectionPointReferenceRule__Alternatives
                    {
                    pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Alternatives_in_ruleConnectionPointReferenceRule94);
                    rule__ConnectionPointReferenceRule__Alternatives();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConnectionPointReferenceRule"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:88:1: rule__ConnectionPointReferenceRule__Alternatives : ( ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) ) | ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) ) );
    public final void rule__ConnectionPointReferenceRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:92:1: ( ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) ) | ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
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
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:93:1: ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:93:1: ( ( rule__ConnectionPointReferenceRule__Group_0__0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:94:1: ( rule__ConnectionPointReferenceRule__Group_0__0 )
                    {
                     before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:95:1: ( rule__ConnectionPointReferenceRule__Group_0__0 )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:95:2: rule__ConnectionPointReferenceRule__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0__0_in_rule__ConnectionPointReferenceRule__Alternatives131);
                    rule__ConnectionPointReferenceRule__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:99:6: ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:99:6: ( ( rule__ConnectionPointReferenceRule__Group_1__0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:100:1: ( rule__ConnectionPointReferenceRule__Group_1__0 )
                    {
                     before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:101:1: ( rule__ConnectionPointReferenceRule__Group_1__0 )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:101:2: rule__ConnectionPointReferenceRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1__0_in_rule__ConnectionPointReferenceRule__Alternatives149);
                    rule__ConnectionPointReferenceRule__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Alternatives"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__0"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:112:1: rule__ConnectionPointReferenceRule__Group_0__0 : rule__ConnectionPointReferenceRule__Group_0__0__Impl rule__ConnectionPointReferenceRule__Group_0__1 ;
    public final void rule__ConnectionPointReferenceRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:116:1: ( rule__ConnectionPointReferenceRule__Group_0__0__Impl rule__ConnectionPointReferenceRule__Group_0__1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:117:2: rule__ConnectionPointReferenceRule__Group_0__0__Impl rule__ConnectionPointReferenceRule__Group_0__1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0__0__Impl_in_rule__ConnectionPointReferenceRule__Group_0__0180);
            rule__ConnectionPointReferenceRule__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0__1_in_rule__ConnectionPointReferenceRule__Group_0__0183);
            rule__ConnectionPointReferenceRule__Group_0__1();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__0"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:124:1: rule__ConnectionPointReferenceRule__Group_0__0__Impl : ( 'entry' ) ;
    public final void rule__ConnectionPointReferenceRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:128:1: ( ( 'entry' ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:129:1: ( 'entry' )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:129:1: ( 'entry' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:130:1: 'entry'
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0()); 
            match(input,11,FOLLOW_11_in_rule__ConnectionPointReferenceRule__Group_0__0__Impl211); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__0__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:143:1: rule__ConnectionPointReferenceRule__Group_0__1 : rule__ConnectionPointReferenceRule__Group_0__1__Impl rule__ConnectionPointReferenceRule__Group_0__2 ;
    public final void rule__ConnectionPointReferenceRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:147:1: ( rule__ConnectionPointReferenceRule__Group_0__1__Impl rule__ConnectionPointReferenceRule__Group_0__2 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:148:2: rule__ConnectionPointReferenceRule__Group_0__1__Impl rule__ConnectionPointReferenceRule__Group_0__2
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0__1__Impl_in_rule__ConnectionPointReferenceRule__Group_0__1242);
            rule__ConnectionPointReferenceRule__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0__2_in_rule__ConnectionPointReferenceRule__Group_0__1245);
            rule__ConnectionPointReferenceRule__Group_0__2();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:155:1: rule__ConnectionPointReferenceRule__Group_0__1__Impl : ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) ) ;
    public final void rule__ConnectionPointReferenceRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:159:1: ( ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:160:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:160:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:161:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_1()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:162:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:162:2: rule__ConnectionPointReferenceRule__EntryAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__EntryAssignment_0_1_in_rule__ConnectionPointReferenceRule__Group_0__1__Impl272);
            rule__ConnectionPointReferenceRule__EntryAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__1__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__2"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:172:1: rule__ConnectionPointReferenceRule__Group_0__2 : rule__ConnectionPointReferenceRule__Group_0__2__Impl ;
    public final void rule__ConnectionPointReferenceRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:176:1: ( rule__ConnectionPointReferenceRule__Group_0__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:177:2: rule__ConnectionPointReferenceRule__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0__2__Impl_in_rule__ConnectionPointReferenceRule__Group_0__2302);
            rule__ConnectionPointReferenceRule__Group_0__2__Impl();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__2"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:183:1: rule__ConnectionPointReferenceRule__Group_0__2__Impl : ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* ) ;
    public final void rule__ConnectionPointReferenceRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:187:1: ( ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:188:1: ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:188:1: ( ( rule__ConnectionPointReferenceRule__Group_0_2__0 )* )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:189:1: ( rule__ConnectionPointReferenceRule__Group_0_2__0 )*
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0_2()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:190:1: ( rule__ConnectionPointReferenceRule__Group_0_2__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:190:2: rule__ConnectionPointReferenceRule__Group_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__0_in_rule__ConnectionPointReferenceRule__Group_0__2__Impl329);
            	    rule__ConnectionPointReferenceRule__Group_0_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0__2__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__0"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:206:1: rule__ConnectionPointReferenceRule__Group_0_2__0 : rule__ConnectionPointReferenceRule__Group_0_2__0__Impl rule__ConnectionPointReferenceRule__Group_0_2__1 ;
    public final void rule__ConnectionPointReferenceRule__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:210:1: ( rule__ConnectionPointReferenceRule__Group_0_2__0__Impl rule__ConnectionPointReferenceRule__Group_0_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:211:2: rule__ConnectionPointReferenceRule__Group_0_2__0__Impl rule__ConnectionPointReferenceRule__Group_0_2__1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__0__Impl_in_rule__ConnectionPointReferenceRule__Group_0_2__0366);
            rule__ConnectionPointReferenceRule__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__1_in_rule__ConnectionPointReferenceRule__Group_0_2__0369);
            rule__ConnectionPointReferenceRule__Group_0_2__1();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__0"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:218:1: rule__ConnectionPointReferenceRule__Group_0_2__0__Impl : ( ',' ) ;
    public final void rule__ConnectionPointReferenceRule__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:222:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:223:1: ( ',' )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:223:1: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:224:1: ','
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0()); 
            match(input,12,FOLLOW_12_in_rule__ConnectionPointReferenceRule__Group_0_2__0__Impl397); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__0__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:237:1: rule__ConnectionPointReferenceRule__Group_0_2__1 : rule__ConnectionPointReferenceRule__Group_0_2__1__Impl ;
    public final void rule__ConnectionPointReferenceRule__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:241:1: ( rule__ConnectionPointReferenceRule__Group_0_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:242:2: rule__ConnectionPointReferenceRule__Group_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__1__Impl_in_rule__ConnectionPointReferenceRule__Group_0_2__1428);
            rule__ConnectionPointReferenceRule__Group_0_2__1__Impl();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_0_2__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:248:1: rule__ConnectionPointReferenceRule__Group_0_2__1__Impl : ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) ) ;
    public final void rule__ConnectionPointReferenceRule__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:252:1: ( ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:253:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:253:1: ( ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:254:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:255:1: ( rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:255:2: rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1_in_rule__ConnectionPointReferenceRule__Group_0_2__1__Impl455);
            rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryAssignment_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_0_2__1__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__0"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:269:1: rule__ConnectionPointReferenceRule__Group_1__0 : rule__ConnectionPointReferenceRule__Group_1__0__Impl rule__ConnectionPointReferenceRule__Group_1__1 ;
    public final void rule__ConnectionPointReferenceRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:273:1: ( rule__ConnectionPointReferenceRule__Group_1__0__Impl rule__ConnectionPointReferenceRule__Group_1__1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:274:2: rule__ConnectionPointReferenceRule__Group_1__0__Impl rule__ConnectionPointReferenceRule__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1__0__Impl_in_rule__ConnectionPointReferenceRule__Group_1__0489);
            rule__ConnectionPointReferenceRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1__1_in_rule__ConnectionPointReferenceRule__Group_1__0492);
            rule__ConnectionPointReferenceRule__Group_1__1();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__0"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:281:1: rule__ConnectionPointReferenceRule__Group_1__0__Impl : ( 'exit' ) ;
    public final void rule__ConnectionPointReferenceRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:285:1: ( ( 'exit' ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:286:1: ( 'exit' )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:286:1: ( 'exit' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:287:1: 'exit'
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__ConnectionPointReferenceRule__Group_1__0__Impl520); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__0__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:300:1: rule__ConnectionPointReferenceRule__Group_1__1 : rule__ConnectionPointReferenceRule__Group_1__1__Impl rule__ConnectionPointReferenceRule__Group_1__2 ;
    public final void rule__ConnectionPointReferenceRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:304:1: ( rule__ConnectionPointReferenceRule__Group_1__1__Impl rule__ConnectionPointReferenceRule__Group_1__2 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:305:2: rule__ConnectionPointReferenceRule__Group_1__1__Impl rule__ConnectionPointReferenceRule__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1__1__Impl_in_rule__ConnectionPointReferenceRule__Group_1__1551);
            rule__ConnectionPointReferenceRule__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1__2_in_rule__ConnectionPointReferenceRule__Group_1__1554);
            rule__ConnectionPointReferenceRule__Group_1__2();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:312:1: rule__ConnectionPointReferenceRule__Group_1__1__Impl : ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) ) ;
    public final void rule__ConnectionPointReferenceRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:316:1: ( ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:317:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:317:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:318:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_1()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:319:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:319:2: rule__ConnectionPointReferenceRule__ExitAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__ExitAssignment_1_1_in_rule__ConnectionPointReferenceRule__Group_1__1__Impl581);
            rule__ConnectionPointReferenceRule__ExitAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__1__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__2"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:329:1: rule__ConnectionPointReferenceRule__Group_1__2 : rule__ConnectionPointReferenceRule__Group_1__2__Impl ;
    public final void rule__ConnectionPointReferenceRule__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:333:1: ( rule__ConnectionPointReferenceRule__Group_1__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:334:2: rule__ConnectionPointReferenceRule__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1__2__Impl_in_rule__ConnectionPointReferenceRule__Group_1__2611);
            rule__ConnectionPointReferenceRule__Group_1__2__Impl();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__2"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:340:1: rule__ConnectionPointReferenceRule__Group_1__2__Impl : ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* ) ;
    public final void rule__ConnectionPointReferenceRule__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:344:1: ( ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:345:1: ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:345:1: ( ( rule__ConnectionPointReferenceRule__Group_1_2__0 )* )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:346:1: ( rule__ConnectionPointReferenceRule__Group_1_2__0 )*
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1_2()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:347:1: ( rule__ConnectionPointReferenceRule__Group_1_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:347:2: rule__ConnectionPointReferenceRule__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__0_in_rule__ConnectionPointReferenceRule__Group_1__2__Impl638);
            	    rule__ConnectionPointReferenceRule__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1__2__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__0"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:363:1: rule__ConnectionPointReferenceRule__Group_1_2__0 : rule__ConnectionPointReferenceRule__Group_1_2__0__Impl rule__ConnectionPointReferenceRule__Group_1_2__1 ;
    public final void rule__ConnectionPointReferenceRule__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:367:1: ( rule__ConnectionPointReferenceRule__Group_1_2__0__Impl rule__ConnectionPointReferenceRule__Group_1_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:368:2: rule__ConnectionPointReferenceRule__Group_1_2__0__Impl rule__ConnectionPointReferenceRule__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__0__Impl_in_rule__ConnectionPointReferenceRule__Group_1_2__0675);
            rule__ConnectionPointReferenceRule__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__1_in_rule__ConnectionPointReferenceRule__Group_1_2__0678);
            rule__ConnectionPointReferenceRule__Group_1_2__1();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__0"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:375:1: rule__ConnectionPointReferenceRule__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__ConnectionPointReferenceRule__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:379:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:380:1: ( ',' )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:380:1: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:381:1: ','
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0()); 
            match(input,12,FOLLOW_12_in_rule__ConnectionPointReferenceRule__Group_1_2__0__Impl706); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__0__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:394:1: rule__ConnectionPointReferenceRule__Group_1_2__1 : rule__ConnectionPointReferenceRule__Group_1_2__1__Impl ;
    public final void rule__ConnectionPointReferenceRule__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:398:1: ( rule__ConnectionPointReferenceRule__Group_1_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:399:2: rule__ConnectionPointReferenceRule__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__1__Impl_in_rule__ConnectionPointReferenceRule__Group_1_2__1737);
            rule__ConnectionPointReferenceRule__Group_1_2__1__Impl();

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
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__Group_1_2__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:405:1: rule__ConnectionPointReferenceRule__Group_1_2__1__Impl : ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) ) ;
    public final void rule__ConnectionPointReferenceRule__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:409:1: ( ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:410:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:410:1: ( ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:411:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:412:1: ( rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:412:2: rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1_in_rule__ConnectionPointReferenceRule__Group_1_2__1__Impl764);
            rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__Group_1_2__1__Impl"


    // $ANTLR start "rule__ConnectionPointReferenceRule__EntryAssignment_0_1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:427:1: rule__ConnectionPointReferenceRule__EntryAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionPointReferenceRule__EntryAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:431:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:432:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:432:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:433:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:434:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:435:1: RULE_ID
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__EntryAssignment_0_1807); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__EntryAssignment_0_1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:446:1: rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:450:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:451:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:451:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:452:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:453:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:454:1: RULE_ID
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1846); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateIDTerminalRuleCall_0_2_1_0_1()); 

            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__ExitAssignment_1_1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:465:1: rule__ConnectionPointReferenceRule__ExitAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionPointReferenceRule__ExitAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:469:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:470:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:470:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:471:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:472:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:473:1: RULE_ID
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__ExitAssignment_1_1885); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__ExitAssignment_1_1"


    // $ANTLR start "rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:484:1: rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:488:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:489:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:489:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:490:1: ( RULE_ID )
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:491:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:492:1: RULE_ID
            {
             before(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1924); 
             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateIDTerminalRuleCall_1_2_1_0_1()); 

            }

             after(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleConnectionPointReferenceRule_in_entryRuleConnectionPointReferenceRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionPointReferenceRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Alternatives_in_ruleConnectionPointReferenceRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0__0_in_rule__ConnectionPointReferenceRule__Alternatives131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1__0_in_rule__ConnectionPointReferenceRule__Alternatives149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0__0__Impl_in_rule__ConnectionPointReferenceRule__Group_0__0180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0__1_in_rule__ConnectionPointReferenceRule__Group_0__0183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ConnectionPointReferenceRule__Group_0__0__Impl211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0__1__Impl_in_rule__ConnectionPointReferenceRule__Group_0__1242 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0__2_in_rule__ConnectionPointReferenceRule__Group_0__1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__EntryAssignment_0_1_in_rule__ConnectionPointReferenceRule__Group_0__1__Impl272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0__2__Impl_in_rule__ConnectionPointReferenceRule__Group_0__2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__0_in_rule__ConnectionPointReferenceRule__Group_0__2__Impl329 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__0__Impl_in_rule__ConnectionPointReferenceRule__Group_0_2__0366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__1_in_rule__ConnectionPointReferenceRule__Group_0_2__0369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ConnectionPointReferenceRule__Group_0_2__0__Impl397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_0_2__1__Impl_in_rule__ConnectionPointReferenceRule__Group_0_2__1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1_in_rule__ConnectionPointReferenceRule__Group_0_2__1__Impl455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1__0__Impl_in_rule__ConnectionPointReferenceRule__Group_1__0489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1__1_in_rule__ConnectionPointReferenceRule__Group_1__0492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ConnectionPointReferenceRule__Group_1__0__Impl520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1__1__Impl_in_rule__ConnectionPointReferenceRule__Group_1__1551 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1__2_in_rule__ConnectionPointReferenceRule__Group_1__1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__ExitAssignment_1_1_in_rule__ConnectionPointReferenceRule__Group_1__1__Impl581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1__2__Impl_in_rule__ConnectionPointReferenceRule__Group_1__2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__0_in_rule__ConnectionPointReferenceRule__Group_1__2__Impl638 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__0__Impl_in_rule__ConnectionPointReferenceRule__Group_1_2__0675 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__1_in_rule__ConnectionPointReferenceRule__Group_1_2__0678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ConnectionPointReferenceRule__Group_1_2__0__Impl706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__Group_1_2__1__Impl_in_rule__ConnectionPointReferenceRule__Group_1_2__1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1_in_rule__ConnectionPointReferenceRule__Group_1_2__1__Impl764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__EntryAssignment_0_1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__EntryAssignment_0_2_1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__ExitAssignment_1_1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ConnectionPointReferenceRule__ExitAssignment_1_2_1924 = new BitSet(new long[]{0x0000000000000002L});

}