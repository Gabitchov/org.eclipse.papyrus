package org.eclipse.papyrus.message.editor.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.message.editor.xtext.services.UmlMessageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlMessageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NAMERULE", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "':'", "'*'", "'['", "']'"
    };
    public static final int RULE_NAMERULE=4;
    public static final int RULE_ID=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

        public InternalUmlMessageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g"; }



     	private UmlMessageGrammarAccess grammarAccess;
     	
        public InternalUmlMessageParser(TokenStream input, IAstFactory factory, UmlMessageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MessageRule";	
       	}
       	
       	@Override
       	protected UmlMessageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleMessageRule
    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:77:1: entryRuleMessageRule returns [EObject current=null] : iv_ruleMessageRule= ruleMessageRule EOF ;
    public final EObject entryRuleMessageRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageRule = null;


        try {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:78:2: (iv_ruleMessageRule= ruleMessageRule EOF )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:79:2: iv_ruleMessageRule= ruleMessageRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMessageRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleMessageRule_in_entryRuleMessageRule75);
            iv_ruleMessageRule=ruleMessageRule();
            _fsp--;

             current =iv_ruleMessageRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMessageRule85); 

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
    // $ANTLR end entryRuleMessageRule


    // $ANTLR start ruleMessageRule
    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:86:1: ruleMessageRule returns [EObject current=null] : ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) ( '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* ':' ( (lv_name_4_0= RULE_NAMERULE ) ) ) ;
    public final EObject ruleMessageRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_4_0=null;
        EObject lv_sequenceTerm_0_0 = null;

        EObject lv_sequenceTerm_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:91:6: ( ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) ( '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* ':' ( (lv_name_4_0= RULE_NAMERULE ) ) ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:92:1: ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) ( '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* ':' ( (lv_name_4_0= RULE_NAMERULE ) ) )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:92:1: ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) ( '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* ':' ( (lv_name_4_0= RULE_NAMERULE ) ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:92:2: ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) ( '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* ':' ( (lv_name_4_0= RULE_NAMERULE ) )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:92:2: ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:93:1: (lv_sequenceTerm_0_0= ruleSequenceTermRule )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:93:1: (lv_sequenceTerm_0_0= ruleSequenceTermRule )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:94:3: lv_sequenceTerm_0_0= ruleSequenceTermRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSequenceTermRule_in_ruleMessageRule131);
            lv_sequenceTerm_0_0=ruleSequenceTermRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMessageRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"sequenceTerm",
            	        		lv_sequenceTerm_0_0, 
            	        		"SequenceTermRule", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:116:2: ( '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:116:4: '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) )
            	    {
            	    match(input,12,FOLLOW_12_in_ruleMessageRule142); 

            	            createLeafNode(grammarAccess.getMessageRuleAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:120:1: ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) )
            	    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:121:1: (lv_sequenceTerm_2_0= ruleSequenceTermRule )
            	    {
            	    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:121:1: (lv_sequenceTerm_2_0= ruleSequenceTermRule )
            	    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:122:3: lv_sequenceTerm_2_0= ruleSequenceTermRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSequenceTermRule_in_ruleMessageRule163);
            	    lv_sequenceTerm_2_0=ruleSequenceTermRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMessageRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"sequenceTerm",
            	    	        		lv_sequenceTerm_2_0, 
            	    	        		"SequenceTermRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleMessageRule175); 

                    createLeafNode(grammarAccess.getMessageRuleAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:148:1: ( (lv_name_4_0= RULE_NAMERULE ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:149:1: (lv_name_4_0= RULE_NAMERULE )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:149:1: (lv_name_4_0= RULE_NAMERULE )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:150:3: lv_name_4_0= RULE_NAMERULE
            {
            lv_name_4_0=(Token)input.LT(1);
            match(input,RULE_NAMERULE,FOLLOW_RULE_NAMERULE_in_ruleMessageRule192); 

            			createLeafNode(grammarAccess.getMessageRuleAccess().getNameNameRuleTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMessageRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_4_0, 
            	        		"nameRule", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleMessageRule


    // $ANTLR start entryRuleSequenceTermRule
    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:180:1: entryRuleSequenceTermRule returns [EObject current=null] : iv_ruleSequenceTermRule= ruleSequenceTermRule EOF ;
    public final EObject entryRuleSequenceTermRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceTermRule = null;


        try {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:181:2: (iv_ruleSequenceTermRule= ruleSequenceTermRule EOF )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:182:2: iv_ruleSequenceTermRule= ruleSequenceTermRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSequenceTermRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSequenceTermRule_in_entryRuleSequenceTermRule233);
            iv_ruleSequenceTermRule=ruleSequenceTermRule();
            _fsp--;

             current =iv_ruleSequenceTermRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceTermRule243); 

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
    // $ANTLR end entryRuleSequenceTermRule


    // $ANTLR start ruleSequenceTermRule
    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:189:1: ruleSequenceTermRule returns [EObject current=null] : ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? ) ;
    public final EObject ruleSequenceTermRule() throws RecognitionException {
        EObject current = null;

        Token lv_sequencialOrder_0_0=null;
        Token lv_sequenceName_1_0=null;
        AntlrDatatypeRuleToken lv_recurrence_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:194:6: ( ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:195:1: ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:195:1: ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:195:2: ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )?
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:195:2: ( (lv_sequencialOrder_0_0= RULE_INT ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:196:1: (lv_sequencialOrder_0_0= RULE_INT )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:196:1: (lv_sequencialOrder_0_0= RULE_INT )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:197:3: lv_sequencialOrder_0_0= RULE_INT
            {
            lv_sequencialOrder_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSequenceTermRule285); 

            			createLeafNode(grammarAccess.getSequenceTermRuleAccess().getSequencialOrderINTTerminalRuleCall_0_0(), "sequencialOrder"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSequenceTermRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"sequencialOrder",
            	        		lv_sequencialOrder_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:219:2: ( (lv_sequenceName_1_0= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:220:1: (lv_sequenceName_1_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:220:1: (lv_sequenceName_1_0= RULE_ID )
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:221:3: lv_sequenceName_1_0= RULE_ID
                    {
                    lv_sequenceName_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequenceTermRule307); 

                    			createLeafNode(grammarAccess.getSequenceTermRuleAccess().getSequenceNameIDTerminalRuleCall_1_0(), "sequenceName"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSequenceTermRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"sequenceName",
                    	        		lv_sequenceName_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:243:3: ( (lv_recurrence_2_0= ruleRecurrenceRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=14 && LA3_0<=15)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:244:1: (lv_recurrence_2_0= ruleRecurrenceRule )
                    {
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:244:1: (lv_recurrence_2_0= ruleRecurrenceRule )
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:245:3: lv_recurrence_2_0= ruleRecurrenceRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSequenceTermRuleAccess().getRecurrenceRecurrenceRuleParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRecurrenceRule_in_ruleSequenceTermRule334);
                    lv_recurrence_2_0=ruleRecurrenceRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSequenceTermRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"recurrence",
                    	        		lv_recurrence_2_0, 
                    	        		"RecurrenceRule", 
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
    // $ANTLR end ruleSequenceTermRule


    // $ANTLR start entryRuleRecurrenceRule
    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:275:1: entryRuleRecurrenceRule returns [String current=null] : iv_ruleRecurrenceRule= ruleRecurrenceRule EOF ;
    public final String entryRuleRecurrenceRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRecurrenceRule = null;


        try {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:276:2: (iv_ruleRecurrenceRule= ruleRecurrenceRule EOF )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:277:2: iv_ruleRecurrenceRule= ruleRecurrenceRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecurrenceRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecurrenceRule_in_entryRuleRecurrenceRule372);
            iv_ruleRecurrenceRule=ruleRecurrenceRule();
            _fsp--;

             current =iv_ruleRecurrenceRule.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecurrenceRule383); 

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
    // $ANTLR end entryRuleRecurrenceRule


    // $ANTLR start ruleRecurrenceRule
    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:284:1: ruleRecurrenceRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) ) ;
    public final AntlrDatatypeRuleToken ruleRecurrenceRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_2=null;
        Token this_STRING_5=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:289:6: ( ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) ) )
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:290:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )
            {
            // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:290:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("290:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:290:2: (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' )
                    {
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:290:2: (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' )
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:291:2: kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']'
                    {
                    kw=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleRecurrenceRule422); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRecurrenceRuleAccess().getAsteriskKeyword_0_0(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleRecurrenceRule435); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_0_1(), null); 
                        
                    this_STRING_2=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRecurrenceRule450); 

                    		current.merge(this_STRING_2);
                        
                     
                        createLeafNode(grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_0_2(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleRecurrenceRule468); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_0_3(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:316:6: (kw= '[' this_STRING_5= RULE_STRING kw= ']' )
                    {
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:316:6: (kw= '[' this_STRING_5= RULE_STRING kw= ']' )
                    // ../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g:317:2: kw= '[' this_STRING_5= RULE_STRING kw= ']'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleRecurrenceRule489); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    this_STRING_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRecurrenceRule504); 

                    		current.merge(this_STRING_5);
                        
                     
                        createLeafNode(grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_1_1(), null); 
                        
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleRecurrenceRule522); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_1_2(), null); 
                        

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
    // $ANTLR end ruleRecurrenceRule


 

    public static final BitSet FOLLOW_ruleMessageRule_in_entryRuleMessageRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceTermRule_in_ruleMessageRule131 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleMessageRule142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSequenceTermRule_in_ruleMessageRule163 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_ruleMessageRule175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NAMERULE_in_ruleMessageRule192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceTermRule_in_entryRuleSequenceTermRule233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceTermRule243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSequenceTermRule285 = new BitSet(new long[]{0x000000000000C042L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequenceTermRule307 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleRecurrenceRule_in_ruleSequenceTermRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecurrenceRule_in_entryRuleRecurrenceRule372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecurrenceRule383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleRecurrenceRule422 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRecurrenceRule435 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRecurrenceRule450 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRecurrenceRule468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleRecurrenceRule489 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRecurrenceRule504 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRecurrenceRule522 = new BitSet(new long[]{0x0000000000000002L});

}