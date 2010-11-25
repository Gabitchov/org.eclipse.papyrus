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
package org.eclipse.papyrus.collaborationuse.editor.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.papyrus.collaborationuse.editor.xtext.services.UmlCollaborationUseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlCollaborationUseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'<Undefined>'", "'::'", "'+'", "'-'", "'#'", "'~'"
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

        public InternalUmlCollaborationUseParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g"; }



     	private UmlCollaborationUseGrammarAccess grammarAccess;
     	
        public InternalUmlCollaborationUseParser(TokenStream input, IAstFactory factory, UmlCollaborationUseGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CollaborationUseRule";	
       	}
       	
       	@Override
       	protected UmlCollaborationUseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleCollaborationUseRule
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:78:1: entryRuleCollaborationUseRule returns [EObject current=null] : iv_ruleCollaborationUseRule= ruleCollaborationUseRule EOF ;
    public final EObject entryRuleCollaborationUseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollaborationUseRule = null;


        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:79:2: (iv_ruleCollaborationUseRule= ruleCollaborationUseRule EOF )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:80:2: iv_ruleCollaborationUseRule= ruleCollaborationUseRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCollaborationUseRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCollaborationUseRule_in_entryRuleCollaborationUseRule75);
            iv_ruleCollaborationUseRule=ruleCollaborationUseRule();
            _fsp--;

             current =iv_ruleCollaborationUseRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollaborationUseRule85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCollaborationUseRule


    // $ANTLR start ruleCollaborationUseRule
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:87:1: ruleCollaborationUseRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' ) ) ;
    public final EObject ruleCollaborationUseRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:92:6: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' ) ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' ) )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_name_1_0= RULE_ID ) ) ':' ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:94:1: (lv_visibility_0_0= ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:94:1: (lv_visibility_0_0= ruleVisibilityKind )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:95:3: lv_visibility_0_0= ruleVisibilityKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVisibilityKind_in_ruleCollaborationUseRule131);
            lv_visibility_0_0=ruleVisibilityKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCollaborationUseRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"visibility",
            	        		lv_visibility_0_0, 
            	        		"VisibilityKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:117:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:118:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:118:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:119:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCollaborationUseRule148); 

            			createLeafNode(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCollaborationUseRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleCollaborationUseRule163); 

                    createLeafNode(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:145:1: ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("145:1: ( ( (lv_type_3_0= ruleTypeRule ) ) | '<Undefined>' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:145:2: ( (lv_type_3_0= ruleTypeRule ) )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:145:2: ( (lv_type_3_0= ruleTypeRule ) )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:146:1: (lv_type_3_0= ruleTypeRule )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:146:1: (lv_type_3_0= ruleTypeRule )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:147:3: lv_type_3_0= ruleTypeRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRule_in_ruleCollaborationUseRule185);
                    lv_type_3_0=ruleTypeRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCollaborationUseRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_3_0, 
                    	        		"TypeRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:170:7: '<Undefined>'
                    {
                    match(input,13,FOLLOW_13_in_ruleCollaborationUseRule201); 

                            createLeafNode(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCollaborationUseRule


    // $ANTLR start entryRuleTypeRule
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:182:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:183:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:184:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule238);
            iv_ruleTypeRule=ruleTypeRule();
            _fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule248); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTypeRule


    // $ANTLR start ruleTypeRule
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:191:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:196:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:197:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:197:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:197:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:197:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==14) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:198:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:198:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:199:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule294);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"path",
                    	        		lv_path_0_0, 
                    	        		"QualifiedName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:221:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:222:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:222:1: ( RULE_ID )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:223:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule313); 

            		createLeafNode(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0(), "type"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeRule


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:243:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:244:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:245:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName349);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName359); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:252:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:257:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:258:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:258:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:258:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:258:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:259:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:259:1: ( RULE_ID )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:260:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName402); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,14,FOLLOW_14_in_ruleQualifiedName412); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:276:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==14) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:277:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:277:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:278:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName433);
                    lv_remaining_2_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"remaining",
                    	        		lv_remaining_2_0, 
                    	        		"QualifiedName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleBoundSpecification
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:310:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:311:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:312:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification472);
            iv_ruleBoundSpecification=ruleBoundSpecification();
            _fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification482); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBoundSpecification


    // $ANTLR start ruleBoundSpecification
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:319:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:324:6: ( ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:325:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:325:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:326:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:326:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:327:3: lv_value_0_0= RULE_UNLIMITEDLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification523); 

            			createLeafNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBoundSpecificationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"UnlimitedLiteral", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBoundSpecification


    // $ANTLR start ruleVisibilityKind
    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:357:1: ruleVisibilityKind returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:361:6: ( ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) )
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:362:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            {
            // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:362:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("362:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:362:2: ( '+' )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:362:2: ( '+' )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:362:4: '+'
                    {
                    match(input,15,FOLLOW_15_in_ruleVisibilityKind575); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:368:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:368:6: ( '-' )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:368:8: '-'
                    {
                    match(input,16,FOLLOW_16_in_ruleVisibilityKind590); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:374:6: ( '#' )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:374:6: ( '#' )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:374:8: '#'
                    {
                    match(input,17,FOLLOW_17_in_ruleVisibilityKind605); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:380:6: ( '~' )
                    {
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:380:6: ( '~' )
                    // ../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g:380:8: '~'
                    {
                    match(input,18,FOLLOW_18_in_ruleVisibilityKind620); 

                            current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVisibilityKind


 

    public static final BitSet FOLLOW_ruleCollaborationUseRule_in_entryRuleCollaborationUseRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollaborationUseRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_ruleCollaborationUseRule131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCollaborationUseRule148 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCollaborationUseRule163 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_ruleTypeRule_in_ruleCollaborationUseRule185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleCollaborationUseRule201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName402 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleQualifiedName412 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVisibilityKind575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVisibilityKind590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVisibilityKind605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVisibilityKind620 = new BitSet(new long[]{0x0000000000000002L});

}