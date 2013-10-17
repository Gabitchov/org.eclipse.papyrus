package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.services.UMLConnectionPointReferenceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUMLConnectionPointReferenceParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER_VALUE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "'entry'", "','", "'exit'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=9;
    public static final int RULE_INTEGER_VALUE=5;
    public static final int RULE_WS=10;
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
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g"; }



     	private UMLConnectionPointReferenceGrammarAccess grammarAccess;
     	
        public InternalUMLConnectionPointReferenceParser(TokenStream input, UMLConnectionPointReferenceGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ConnectionPointReferenceRule";	
       	}
       	
       	@Override
       	protected UMLConnectionPointReferenceGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleConnectionPointReferenceRule"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:67:1: entryRuleConnectionPointReferenceRule returns [EObject current=null] : iv_ruleConnectionPointReferenceRule= ruleConnectionPointReferenceRule EOF ;
    public final EObject entryRuleConnectionPointReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionPointReferenceRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:68:2: (iv_ruleConnectionPointReferenceRule= ruleConnectionPointReferenceRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:69:2: iv_ruleConnectionPointReferenceRule= ruleConnectionPointReferenceRule EOF
            {
             newCompositeNode(grammarAccess.getConnectionPointReferenceRuleRule()); 
            pushFollow(FOLLOW_ruleConnectionPointReferenceRule_in_entryRuleConnectionPointReferenceRule75);
            iv_ruleConnectionPointReferenceRule=ruleConnectionPointReferenceRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleConnectionPointReferenceRule"


    // $ANTLR start "ruleConnectionPointReferenceRule"
    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:76:1: ruleConnectionPointReferenceRule returns [EObject current=null] : ( (otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) | (otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* ) )? ;
    public final EObject ruleConnectionPointReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:79:28: ( ( (otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) | (otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* ) )? )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:80:1: ( (otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) | (otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:80:1: ( (otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) | (otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:80:2: (otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:80:2: (otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:80:4: otherlv_0= 'entry' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleConnectionPointReferenceRule123); 

                        	newLeafNode(otherlv_0, grammarAccess.getConnectionPointReferenceRuleAccess().getEntryKeyword_0_0());
                        
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:84:1: ( (otherlv_1= RULE_ID ) )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:85:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:85:1: (otherlv_1= RULE_ID )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:86:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionPointReferenceRuleRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule143); 

                    		newLeafNode(otherlv_1, grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:97:2: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:97:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleConnectionPointReferenceRule156); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_0_2_0());
                    	        
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:101:1: ( (otherlv_3= RULE_ID ) )
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:102:1: (otherlv_3= RULE_ID )
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:102:1: (otherlv_3= RULE_ID )
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:103:3: otherlv_3= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionPointReferenceRuleRule());
                    	    	        }
                    	            
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule176); 

                    	    		newLeafNode(otherlv_3, grammarAccess.getConnectionPointReferenceRuleAccess().getEntryPseudostateCrossReference_0_2_1_0()); 
                    	    	

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
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:115:6: (otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:115:6: (otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:115:8: otherlv_4= 'exit' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleConnectionPointReferenceRule198); 

                        	newLeafNode(otherlv_4, grammarAccess.getConnectionPointReferenceRuleAccess().getExitKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:119:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:120:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:120:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:121:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionPointReferenceRuleRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule218); 

                    		newLeafNode(otherlv_5, grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:132:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:132:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleConnectionPointReferenceRule231); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getConnectionPointReferenceRuleAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:136:1: ( (otherlv_7= RULE_ID ) )
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:137:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:137:1: (otherlv_7= RULE_ID )
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g:138:3: otherlv_7= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionPointReferenceRuleRule());
                    	    	        }
                    	            
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule251); 

                    	    		newLeafNode(otherlv_7, grammarAccess.getConnectionPointReferenceRuleAccess().getExitPseudostateCrossReference_1_2_1_0()); 
                    	    	

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
    // $ANTLR end "ruleConnectionPointReferenceRule"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleConnectionPointReferenceRule_in_entryRuleConnectionPointReferenceRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionPointReferenceRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConnectionPointReferenceRule123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule143 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleConnectionPointReferenceRule156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule176 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_14_in_ruleConnectionPointReferenceRule198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule218 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleConnectionPointReferenceRule231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionPointReferenceRule251 = new BitSet(new long[]{0x0000000000002002L});

}