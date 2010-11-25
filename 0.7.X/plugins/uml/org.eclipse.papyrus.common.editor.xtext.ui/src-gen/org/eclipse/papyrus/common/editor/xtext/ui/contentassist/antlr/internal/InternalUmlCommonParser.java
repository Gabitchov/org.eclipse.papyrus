/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.common.editor.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.common.editor.xtext.services.UmlCommonGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlCommonParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'::'"
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

        public InternalUmlCommonParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g"; }


     
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




    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:61:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:62:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:63:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName61);
            ruleQualifiedName();
            _fsp--;

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:70:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:74:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:75:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:75:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:76:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:77:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:77:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName94);
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


    // $ANTLR start entryRuleBoundSpecification
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:91:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:92:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:93:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification123);
            ruleBoundSpecification();
            _fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification130); 

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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:100:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:104:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:105:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:105:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:106:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:107:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:107:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification156);
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


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:127:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:131:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:132:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0196);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0199);
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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:139:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:143:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:144:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:144:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:145:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:146:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:146:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl226);
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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:156:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:160:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:161:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1256);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__1259);
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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:168:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:172:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:173:1: ( '::' )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:173:1: ( '::' )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:174:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__QualifiedName__Group__1__Impl287); 
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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:187:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:191:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:192:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__2318);
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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:198:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:202:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:203:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:203:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:204:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:205:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:205:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl345);
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


    // $ANTLR start rule__QualifiedName__PathAssignment_0
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:224:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:228:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:229:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:229:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:230:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:231:1: ( RULE_ID )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:232:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_0393); 
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
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:243:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:247:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:248:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:248:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:249:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_2428);
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


    // $ANTLR start rule__BoundSpecification__ValueAssignment
    // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:260:1: rule__BoundSpecification__ValueAssignment : ( RULE_UNLIMITEDLITERAL ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:264:1: ( ( RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:265:1: ( RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:265:1: ( RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g:266:1: RULE_UNLIMITEDLITERAL
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); 
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment461); 
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


 

    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0196 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__1256 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedName__Group__1__Impl287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_0393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment461 = new BitSet(new long[]{0x0000000000000002L});

}