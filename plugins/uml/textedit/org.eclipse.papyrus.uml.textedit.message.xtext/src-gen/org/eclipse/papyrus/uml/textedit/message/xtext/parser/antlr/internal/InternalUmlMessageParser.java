/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.message.xtext.parser.antlr.internal; 

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.message.xtext.services.UmlMessageGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalUmlMessageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NAMERULE", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "':'", "'*'", "'['", "']'"
    };
    public static final int RULE_NAMERULE=4;
    public static final int RULE_ID=6;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators


        public InternalUmlMessageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlMessageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlMessageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g"; }



     	private UmlMessageGrammarAccess grammarAccess;
     	
        public InternalUmlMessageParser(TokenStream input, UmlMessageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MessageRule";	
       	}
       	
       	@Override
       	protected UmlMessageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMessageRule"
    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:67:1: entryRuleMessageRule returns [EObject current=null] : iv_ruleMessageRule= ruleMessageRule EOF ;
    public final EObject entryRuleMessageRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:68:2: (iv_ruleMessageRule= ruleMessageRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:69:2: iv_ruleMessageRule= ruleMessageRule EOF
            {
             newCompositeNode(grammarAccess.getMessageRuleRule()); 
            pushFollow(FOLLOW_ruleMessageRule_in_entryRuleMessageRule75);
            iv_ruleMessageRule=ruleMessageRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleMessageRule"


    // $ANTLR start "ruleMessageRule"
    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:76:1: ruleMessageRule returns [EObject current=null] : ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAMERULE ) ) ) ;
    public final EObject ruleMessageRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        EObject lv_sequenceTerm_0_0 = null;

        EObject lv_sequenceTerm_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:79:28: ( ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAMERULE ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:80:1: ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAMERULE ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:80:1: ( ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAMERULE ) ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:80:2: ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) ) (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_NAMERULE ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:80:2: ( (lv_sequenceTerm_0_0= ruleSequenceTermRule ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:81:1: (lv_sequenceTerm_0_0= ruleSequenceTermRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:81:1: (lv_sequenceTerm_0_0= ruleSequenceTermRule )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:82:3: lv_sequenceTerm_0_0= ruleSequenceTermRule
            {
             
            	        newCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceTermRule_in_ruleMessageRule131);
            lv_sequenceTerm_0_0=ruleSequenceTermRule();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMessageRuleRule());
            	        }
                   		add(
                   			current, 
                   			"sequenceTerm",
                    		lv_sequenceTerm_0_0, 
                    		"SequenceTermRule");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:98:2: (otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:98:4: otherlv_1= '.' ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleMessageRule144); 

            	        	newLeafNode(otherlv_1, grammarAccess.getMessageRuleAccess().getFullStopKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:102:1: ( (lv_sequenceTerm_2_0= ruleSequenceTermRule ) )
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:103:1: (lv_sequenceTerm_2_0= ruleSequenceTermRule )
            	    {
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:103:1: (lv_sequenceTerm_2_0= ruleSequenceTermRule )
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:104:3: lv_sequenceTerm_2_0= ruleSequenceTermRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMessageRuleAccess().getSequenceTermSequenceTermRuleParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSequenceTermRule_in_ruleMessageRule165);
            	    lv_sequenceTerm_2_0=ruleSequenceTermRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMessageRuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sequenceTerm",
            	            		lv_sequenceTerm_2_0, 
            	            		"SequenceTermRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleMessageRule179); 

                	newLeafNode(otherlv_3, grammarAccess.getMessageRuleAccess().getColonKeyword_2());
                
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:124:1: ( (lv_name_4_0= RULE_NAMERULE ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:125:1: (lv_name_4_0= RULE_NAMERULE )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:125:1: (lv_name_4_0= RULE_NAMERULE )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:126:3: lv_name_4_0= RULE_NAMERULE
            {
            lv_name_4_0=(Token)match(input,RULE_NAMERULE,FOLLOW_RULE_NAMERULE_in_ruleMessageRule196); 

            			newLeafNode(lv_name_4_0, grammarAccess.getMessageRuleAccess().getNameNameRuleTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMessageRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"nameRule");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageRule"


    // $ANTLR start "entryRuleSequenceTermRule"
    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:150:1: entryRuleSequenceTermRule returns [EObject current=null] : iv_ruleSequenceTermRule= ruleSequenceTermRule EOF ;
    public final EObject entryRuleSequenceTermRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceTermRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:151:2: (iv_ruleSequenceTermRule= ruleSequenceTermRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:152:2: iv_ruleSequenceTermRule= ruleSequenceTermRule EOF
            {
             newCompositeNode(grammarAccess.getSequenceTermRuleRule()); 
            pushFollow(FOLLOW_ruleSequenceTermRule_in_entryRuleSequenceTermRule237);
            iv_ruleSequenceTermRule=ruleSequenceTermRule();

            state._fsp--;

             current =iv_ruleSequenceTermRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceTermRule247); 

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
    // $ANTLR end "entryRuleSequenceTermRule"


    // $ANTLR start "ruleSequenceTermRule"
    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:159:1: ruleSequenceTermRule returns [EObject current=null] : ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? ) ;
    public final EObject ruleSequenceTermRule() throws RecognitionException {
        EObject current = null;

        Token lv_sequencialOrder_0_0=null;
        Token lv_sequenceName_1_0=null;
        AntlrDatatypeRuleToken lv_recurrence_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:162:28: ( ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:163:1: ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:163:1: ( ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )? )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:163:2: ( (lv_sequencialOrder_0_0= RULE_INT ) ) ( (lv_sequenceName_1_0= RULE_ID ) )? ( (lv_recurrence_2_0= ruleRecurrenceRule ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:163:2: ( (lv_sequencialOrder_0_0= RULE_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:164:1: (lv_sequencialOrder_0_0= RULE_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:164:1: (lv_sequencialOrder_0_0= RULE_INT )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:165:3: lv_sequencialOrder_0_0= RULE_INT
            {
            lv_sequencialOrder_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSequenceTermRule289); 

            			newLeafNode(lv_sequencialOrder_0_0, grammarAccess.getSequenceTermRuleAccess().getSequencialOrderINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSequenceTermRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"sequencialOrder",
                    		lv_sequencialOrder_0_0, 
                    		"INT");
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:181:2: ( (lv_sequenceName_1_0= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:182:1: (lv_sequenceName_1_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:182:1: (lv_sequenceName_1_0= RULE_ID )
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:183:3: lv_sequenceName_1_0= RULE_ID
                    {
                    lv_sequenceName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequenceTermRule311); 

                    			newLeafNode(lv_sequenceName_1_0, grammarAccess.getSequenceTermRuleAccess().getSequenceNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSequenceTermRuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"sequenceName",
                            		lv_sequenceName_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:199:3: ( (lv_recurrence_2_0= ruleRecurrenceRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=14 && LA3_0<=15)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:200:1: (lv_recurrence_2_0= ruleRecurrenceRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:200:1: (lv_recurrence_2_0= ruleRecurrenceRule )
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:201:3: lv_recurrence_2_0= ruleRecurrenceRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getSequenceTermRuleAccess().getRecurrenceRecurrenceRuleParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRecurrenceRule_in_ruleSequenceTermRule338);
                    lv_recurrence_2_0=ruleRecurrenceRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSequenceTermRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"recurrence",
                            		lv_recurrence_2_0, 
                            		"RecurrenceRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceTermRule"


    // $ANTLR start "entryRuleRecurrenceRule"
    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:225:1: entryRuleRecurrenceRule returns [String current=null] : iv_ruleRecurrenceRule= ruleRecurrenceRule EOF ;
    public final String entryRuleRecurrenceRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRecurrenceRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:226:2: (iv_ruleRecurrenceRule= ruleRecurrenceRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:227:2: iv_ruleRecurrenceRule= ruleRecurrenceRule EOF
            {
             newCompositeNode(grammarAccess.getRecurrenceRuleRule()); 
            pushFollow(FOLLOW_ruleRecurrenceRule_in_entryRuleRecurrenceRule376);
            iv_ruleRecurrenceRule=ruleRecurrenceRule();

            state._fsp--;

             current =iv_ruleRecurrenceRule.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecurrenceRule387); 

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
    // $ANTLR end "entryRuleRecurrenceRule"


    // $ANTLR start "ruleRecurrenceRule"
    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:234:1: ruleRecurrenceRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) ) ;
    public final AntlrDatatypeRuleToken ruleRecurrenceRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_2=null;
        Token this_STRING_5=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:237:28: ( ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:238:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:238:1: ( (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' ) | (kw= '[' this_STRING_5= RULE_STRING kw= ']' ) )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:238:2: (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:238:2: (kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']' )
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:239:2: kw= '*' kw= '[' this_STRING_2= RULE_STRING kw= ']'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleRecurrenceRule426); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getAsteriskKeyword_0_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleRecurrenceRule439); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_0_1()); 
                        
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRecurrenceRule454); 

                    		current.merge(this_STRING_2);
                        
                     
                        newLeafNode(this_STRING_2, grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_0_2()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleRecurrenceRule472); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_0_3()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:264:6: (kw= '[' this_STRING_5= RULE_STRING kw= ']' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:264:6: (kw= '[' this_STRING_5= RULE_STRING kw= ']' )
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.g:265:2: kw= '[' this_STRING_5= RULE_STRING kw= ']'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleRecurrenceRule493); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getLeftSquareBracketKeyword_1_0()); 
                        
                    this_STRING_5=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRecurrenceRule508); 

                    		current.merge(this_STRING_5);
                        
                     
                        newLeafNode(this_STRING_5, grammarAccess.getRecurrenceRuleAccess().getSTRINGTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleRecurrenceRule526); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRecurrenceRuleAccess().getRightSquareBracketKeyword_1_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecurrenceRule"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMessageRule_in_entryRuleMessageRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMessageRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceTermRule_in_ruleMessageRule131 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleMessageRule144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSequenceTermRule_in_ruleMessageRule165 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_ruleMessageRule179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NAMERULE_in_ruleMessageRule196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceTermRule_in_entryRuleSequenceTermRule237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceTermRule247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSequenceTermRule289 = new BitSet(new long[]{0x000000000000C042L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequenceTermRule311 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleRecurrenceRule_in_ruleSequenceTermRule338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecurrenceRule_in_entryRuleRecurrenceRule376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecurrenceRule387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleRecurrenceRule426 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRecurrenceRule439 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRecurrenceRule454 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRecurrenceRule472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleRecurrenceRule493 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRecurrenceRule508 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRecurrenceRule526 = new BitSet(new long[]{0x0000000000000002L});

}