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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.connectionpointreference.editor.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.papyrus.connectionpointreference.editor.xtext.services.UMLConnectionPointReferenceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUMLConnectionPointReferenceParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entry'", "','", "'exit'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalUMLConnectionPointReferenceParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g"; }



     	private UMLConnectionPointReferenceGrammarAccess grammarAccess;
     	
        public InternalUMLConnectionPointReferenceParser(TokenStream input, IAstFactory factory, UMLConnectionPointReferenceGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ConnectionPointReferenceRule";	
       	}
       	
       	@Override
       	protected UMLConnectionPointReferenceGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleConnectionPointReferenceRule
    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:77:1: entryRuleConnectionPointReferenceRule returns [EObject current=null] : iv_ruleConnectionPointReferenceRule= ruleConnectionPointReferenceRule EOF ;
    public final EObject entryRuleConnectionPointReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionPointReferenceRule = null;


        try {
            // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:78:2: (iv_ruleConnectionPointReferenceRule= ruleConnectionPointReferenceRule EOF )
            // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:79:2: iv_ruleConnectionPointReferenceRule= ruleConnectionPointReferenceRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConnectionPointReferenceRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleConnectionPointReferenceRule_in_entryRuleConnectionPointReferenceRule75);
            iv_ruleConnectionPointReferenceRule=ruleConnectionPointReferenceRule();
            _fsp--;

             current =iv_ruleConnectionPointReferenceRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionPointReferenceRule85); 

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
    // $ANTLR end entryRuleConnectionPointReferenceRule


    // $ANTLR start ruleConnectionPointReferenceRule
    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:86:1: ruleConnectionPointReferenceRule returns [EObject current=null] : ( ( 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) | ( 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) )? ;
    public final EObject ruleConnectionPointReferenceRule() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:91:6: ( ( ( 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) | ( 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) )? )
            // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:92:1: ( ( 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) | ( 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) )?
            {
            // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:92:1: ( ( 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) | ( 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:92:2: ( 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )
                    {
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:92:2: ( 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:92:4: 'entry' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                    {
                    match(input,11,FOLLOW_11_in_ruleConnectionPointReferenceRule121); 

                            createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0(), null); 
                        
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:96:1: ( ( RULE_ID ) )
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:97:1: ( RULE_ID )
                    {
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:97:1: ( RULE_ID )
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:98:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getConnectionPointReferenceRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule139); 

                    		createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0(), "entry"); 
                    	

                    }


                    }

                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:110:2: ( ',' ( ( RULE_ID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:110:4: ',' ( ( RULE_ID ) )
                    	    {
                    	    match(input,12,FOLLOW_12_in_ruleConnectionPointReferenceRule150); 

                    	            createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0(), null); 
                    	        
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:114:1: ( ( RULE_ID ) )
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:115:1: ( RULE_ID )
                    	    {
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:115:1: ( RULE_ID )
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:116:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getConnectionPointReferenceRuleRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule168); 

                    	    		createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0(), "entry"); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:129:6: ( 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )
                    {
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:129:6: ( 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:129:8: 'exit' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                    {
                    match(input,13,FOLLOW_13_in_ruleConnectionPointReferenceRule188); 

                            createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:133:1: ( ( RULE_ID ) )
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:134:1: ( RULE_ID )
                    {
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:134:1: ( RULE_ID )
                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:135:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getConnectionPointReferenceRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule206); 

                    		createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0(), "exit"); 
                    	

                    }


                    }

                    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:147:2: ( ',' ( ( RULE_ID ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==12) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:147:4: ',' ( ( RULE_ID ) )
                    	    {
                    	    match(input,12,FOLLOW_12_in_ruleConnectionPointReferenceRule217); 

                    	            createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:151:1: ( ( RULE_ID ) )
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:152:1: ( RULE_ID )
                    	    {
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:152:1: ( RULE_ID )
                    	    // ../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:153:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getConnectionPointReferenceRuleRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule235); 

                    	    		createLeafNode(grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0(), "exit"); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


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
    // $ANTLR end ruleConnectionPointReferenceRule


 

    public static final BitSet FOLLOW_ruleConnectionPointReferenceRule_in_entryRuleConnectionPointReferenceRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionPointReferenceRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleConnectionPointReferenceRule121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule139 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleConnectionPointReferenceRule150 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule168 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_13_in_ruleConnectionPointReferenceRule188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule206 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleConnectionPointReferenceRule217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule235 = new BitSet(new long[]{0x0000000000001002L});

}