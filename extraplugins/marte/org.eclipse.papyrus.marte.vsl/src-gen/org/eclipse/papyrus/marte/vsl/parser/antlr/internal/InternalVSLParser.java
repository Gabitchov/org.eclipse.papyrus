package org.eclipse.papyrus.marte.vsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.marte.vsl.services.VSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "','", "'='", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
    };
    public static final int RULE_DATETIMELITERAL=7;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_REALLITERAL=6;
    public static final int EOF=-1;
    public static final int RULE_BOOLEANLITERAL=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_INT=11;
    public static final int T__50=50;
    public static final int RULE_NULLLITERAL=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_INTEGERLITERAL=5;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=10;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;

    // delegates
    // delegators


        public InternalVSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVSLParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g"; }



     	private VSLGrammarAccess grammarAccess;
     	
        public InternalVSLParser(TokenStream input, VSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Expression";	
       	}
       	
       	@Override
       	protected VSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:67:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:68:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:69:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression75);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression85); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:76:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:79:28: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:80:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:80:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:81:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:81:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:82:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression130);
            lv_exp_0_0=ruleAndOrXorExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"AndOrXorExpression");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAndOrXorExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:106:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:107:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:108:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             newCompositeNode(grammarAccess.getAndOrXorExpressionRule()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression165);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();

            state._fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression175); 

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
    // $ANTLR end "entryRuleAndOrXorExpression"


    // $ANTLR start "ruleAndOrXorExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:115:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:118:28: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:119:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:119:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:119:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:119:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:120:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:120:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:121:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        newCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression221);
            lv_exp_0_0=ruleEqualityExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAndOrXorExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"EqualityExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:137:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=16 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:137:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:137:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:138:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:138:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:139:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:139:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:140:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)match(input,16,FOLLOW_16_in_ruleAndOrXorExpression242); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:152:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)match(input,17,FOLLOW_17_in_ruleAndOrXorExpression271); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:164:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)match(input,18,FOLLOW_18_in_ruleAndOrXorExpression300); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getAndOrXorExpressionAccess().getOpXorKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:179:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:180:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:180:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:181:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression337);
            	    lv_exp_2_0=ruleEqualityExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndOrXorExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"EqualityExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleAndOrXorExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:205:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:206:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:207:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression375);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression385); 

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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:214:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:217:28: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:218:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:218:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:218:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:218:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:219:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:219:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:220:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression431);
            lv_exp_0_0=ruleRelationalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"RelationalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:236:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=19 && LA4_0<=20)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:236:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:236:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:237:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:237:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:238:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:238:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==19) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==20) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:239:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)match(input,19,FOLLOW_19_in_ruleEqualityExpression452); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:251:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)match(input,20,FOLLOW_20_in_ruleEqualityExpression481); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getEqualityExpressionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:266:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:267:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:267:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:268:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression518);
            	    lv_exp_2_0=ruleRelationalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"RelationalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:292:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:293:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:294:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression556);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression566); 

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:301:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:304:28: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:305:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:305:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:305:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:305:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:306:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:306:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:307:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression612);
            lv_exp_0_0=ruleConditionalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"ConditionalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:323:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=21 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:323:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:323:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:324:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:324:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:325:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:325:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt5=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt5=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:326:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)match(input,21,FOLLOW_21_in_ruleRelationalExpression633); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:338:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)match(input,22,FOLLOW_22_in_ruleRelationalExpression662); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:350:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)match(input,23,FOLLOW_23_in_ruleRelationalExpression691); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:362:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)match(input,24,FOLLOW_24_in_ruleRelationalExpression720); 

            	                    newLeafNode(lv_op_1_4, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_4, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:377:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:378:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:378:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:379:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression757);
            	    lv_exp_2_0=ruleConditionalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"ConditionalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:403:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:404:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:405:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression795);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression805); 

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
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:412:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token otherlv_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:415:28: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:416:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:416:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:416:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:416:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:417:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:417:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:418:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression851);
            lv_exp_0_0=ruleAdditiveExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"AdditiveExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:434:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:434:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:434:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:435:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:435:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:436:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)match(input,25,FOLLOW_25_in_ruleConditionalExpression870); 

                            newLeafNode(lv_op_1_0, grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		addWithLastConsumed(current, "op", lv_op_1_0, "?");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:449:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:450:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:450:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:451:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression904);
                    lv_exp_2_0=ruleAdditiveExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		add(
                           			current, 
                           			"exp",
                            		lv_exp_2_0, 
                            		"AdditiveExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleConditionalExpression916); 

                        	newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:471:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:472:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:472:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:473:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression937);
                    lv_exp_4_0=ruleAdditiveExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		add(
                           			current, 
                           			"exp",
                            		lv_exp_4_0, 
                            		"AdditiveExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:497:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:498:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:499:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression975);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression985); 

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:506:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:509:28: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:510:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:510:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:510:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:510:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:511:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:511:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:512:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1031);
            lv_exp_0_0=ruleMultiplicativeExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"MultiplicativeExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:528:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=27 && LA9_0<=28)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:528:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:528:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:529:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:529:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:530:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:530:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==27) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==28) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:531:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)match(input,27,FOLLOW_27_in_ruleAdditiveExpression1052); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:543:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)match(input,28,FOLLOW_28_in_ruleAdditiveExpression1081); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:558:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:559:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:559:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:560:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1118);
            	    lv_exp_2_0=ruleMultiplicativeExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"MultiplicativeExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:584:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:585:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:586:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1156);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1166); 

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:593:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:596:28: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:597:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:597:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:597:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:597:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:598:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:598:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:599:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1212);
            lv_exp_0_0=ruleUnaryExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"UnaryExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:615:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=29 && LA11_0<=31)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:615:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:615:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:616:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:616:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:617:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:617:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case 29:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:618:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)match(input,29,FOLLOW_29_in_ruleMultiplicativeExpression1233); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:630:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)match(input,30,FOLLOW_30_in_ruleMultiplicativeExpression1262); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:642:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)match(input,31,FOLLOW_31_in_ruleMultiplicativeExpression1291); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:657:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:658:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:658:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:659:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1328);
            	    lv_exp_2_0=ruleUnaryExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"UnaryExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:683:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:684:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:685:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1366);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1376); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:692:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:695:28: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:696:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:696:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=27 && LA13_0<=28)||LA13_0==32) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)||(LA13_0>=29 && LA13_0<=30)||LA13_0==34||(LA13_0>=37 && LA13_0<=38)||LA13_0==40||LA13_0==44||(LA13_0>=46 && LA13_0<=51)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:696:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:696:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:696:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:696:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:697:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:697:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:698:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:698:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt12=3;
                    switch ( input.LA(1) ) {
                    case 32:
                        {
                        alt12=1;
                        }
                        break;
                    case 28:
                        {
                        alt12=2;
                        }
                        break;
                    case 27:
                        {
                        alt12=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }

                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:699:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)match(input,32,FOLLOW_32_in_ruleUnaryExpression1422); 

                                    newLeafNode(lv_op_0_1, grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:711:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)match(input,28,FOLLOW_28_in_ruleUnaryExpression1451); 

                                    newLeafNode(lv_op_0_2, grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:723:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)match(input,27,FOLLOW_27_in_ruleUnaryExpression1480); 

                                    newLeafNode(lv_op_0_3, grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_3, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:738:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:739:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:739:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:740:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1517);
                    lv_unary_1_0=ruleUnaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"unary",
                            		lv_unary_1_0, 
                            		"UnaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:757:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:757:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:758:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:758:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:759:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1545);
                    lv_exp_2_0=rulePrimaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp",
                            		lv_exp_2_0, 
                            		"PrimaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:783:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:784:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:785:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1581);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1591); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:792:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:795:28: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:796:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:796:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:796:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:796:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:797:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:797:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:798:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1637);
            lv_prefix_0_0=ruleValueSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"prefix",
                    		lv_prefix_0_0, 
                    		"ValueSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:814:2: (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:814:4: otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_rulePrimaryExpression1650); 

                        	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:818:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:819:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:819:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:820:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression1671);
                    lv_suffix_2_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_2_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleValueSpecification"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:844:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:845:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:846:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             newCompositeNode(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification1709);
            iv_ruleValueSpecification=ruleValueSpecification();

            state._fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification1719); 

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
    // $ANTLR end "entryRuleValueSpecification"


    // $ANTLR start "ruleValueSpecification"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:853:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) ;
    public final EObject ruleValueSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_Literal_0 = null;

        EObject this_NameOrChoiceOrBehaviorCall_1 = null;

        EObject this_Interval_2 = null;

        EObject this_CollectionOrTuple_3 = null;

        EObject this_Tuple_4 = null;

        EObject this_TimeExpression_5 = null;

        EObject this_VariableDeclaration_6 = null;

        EObject this_Expression_8 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:856:28: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:857:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:857:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            int alt15=8;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:858:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification1766);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:868:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification1793);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();

                    state._fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:878:5: this_Interval_2= ruleInterval
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification1820);
                    this_Interval_2=ruleInterval();

                    state._fsp--;

                     
                            current = this_Interval_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:888:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification1847);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();

                    state._fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:898:5: this_Tuple_4= ruleTuple
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification1874);
                    this_Tuple_4=ruleTuple();

                    state._fsp--;

                     
                            current = this_Tuple_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:908:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification1901);
                    this_TimeExpression_5=ruleTimeExpression();

                    state._fsp--;

                     
                            current = this_TimeExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:918:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification1928);
                    this_VariableDeclaration_6=ruleVariableDeclaration();

                    state._fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:927:6: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:927:6: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:927:8: otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleValueSpecification1946); 

                        	newLeafNode(otherlv_7, grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0());
                        
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification1968);
                    this_Expression_8=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_8; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_9=(Token)match(input,35,FOLLOW_35_in_ruleValueSpecification1979); 

                        	newLeafNode(otherlv_9, grammarAccess.getValueSpecificationAccess().getRightParenthesisKeyword_7_2());
                        

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
    // $ANTLR end "ruleValueSpecification"


    // $ANTLR start "entryRuleSuffixExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:952:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:953:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:954:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             newCompositeNode(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2016);
            iv_ruleSuffixExpression=ruleSuffixExpression();

            state._fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2026); 

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
    // $ANTLR end "entryRuleSuffixExpression"


    // $ANTLR start "ruleSuffixExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:961:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:964:28: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:965:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:965:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==EOF||(LA16_1>=16 && LA16_1<=31)||LA16_1==33||LA16_1==35||(LA16_1>=37 && LA16_1<=39)||(LA16_1>=41 && LA16_1<=42)) ) {
                    alt16=1;
                }
                else if ( (LA16_1==34) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:966:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2073);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();

                    state._fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:976:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2100);
                    this_OperationCallExpression_1=ruleOperationCallExpression();

                    state._fsp--;

                     
                            current = this_OperationCallExpression_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleSuffixExpression"


    // $ANTLR start "entryRulePropertyCallExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:992:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:993:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:994:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2135);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();

            state._fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2145); 

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
    // $ANTLR end "entryRulePropertyCallExpression"


    // $ANTLR start "rulePropertyCallExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1001:1: rulePropertyCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1004:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1005:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1005:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1005:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1005:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1006:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1006:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1007:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyCallExpressionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2190); 

            		newLeafNode(otherlv_0, grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1018:2: (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1018:4: otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_rulePropertyCallExpression2203); 

                        	newLeafNode(otherlv_1, grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1022:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1023:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1023:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1024:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2224);
                    lv_suffix_2_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_2_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "rulePropertyCallExpression"


    // $ANTLR start "entryRuleOperationCallExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1048:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1049:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1050:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             newCompositeNode(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2262);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();

            state._fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2272); 

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
    // $ANTLR end "entryRuleOperationCallExpression"


    // $ANTLR start "ruleOperationCallExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1057:1: ruleOperationCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1060:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1061:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1061:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1061:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1061:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1062:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1062:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1063:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationCallExpressionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2317); 

            		newLeafNode(otherlv_0, grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleOperationCallExpression2329); 

                	newLeafNode(otherlv_1, grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1078:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_STRING)||(LA18_0>=27 && LA18_0<=30)||LA18_0==32||LA18_0==34||(LA18_0>=37 && LA18_0<=38)||LA18_0==40||LA18_0==44||(LA18_0>=46 && LA18_0<=51)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1079:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1079:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1080:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2350);
                    lv_arguments_2_0=ruleListOfValues();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"arguments",
                            		lv_arguments_2_0, 
                            		"ListOfValues");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleOperationCallExpression2363); 

                	newLeafNode(otherlv_3, grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1100:1: (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1100:3: otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleOperationCallExpression2376); 

                        	newLeafNode(otherlv_4, grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1104:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1105:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1105:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1106:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2397);
                    lv_suffix_5_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_5_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleOperationCallExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1130:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1131:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1132:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2435);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2445); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1139:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_DateTimeLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_NullLiteralRule_3 = null;

        EObject this_DefaultLiteralRule_4 = null;

        EObject this_StringLiteralRule_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1142:28: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1143:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1143:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt20=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 29:
                {
                alt20=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt20=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt20=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt20=4;
                }
                break;
            case 30:
                {
                alt20=5;
                }
                break;
            case RULE_STRING:
                {
                alt20=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1144:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2492);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();

                    state._fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1154:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2519);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();

                    state._fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1164:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2546);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();

                    state._fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1174:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral2573);
                    this_NullLiteralRule_3=ruleNullLiteralRule();

                    state._fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1184:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2600);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();

                    state._fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1194:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral2627);
                    this_StringLiteralRule_5=ruleStringLiteralRule();

                    state._fsp--;

                     
                            current = this_StringLiteralRule_5; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleNameOrChoiceOrBehaviorCall"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1210:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1211:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1212:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2662);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();

            state._fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall2672); 

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
    // $ANTLR end "entryRuleNameOrChoiceOrBehaviorCall"


    // $ANTLR start "ruleNameOrChoiceOrBehaviorCall"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1219:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1222:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1223:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1223:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1223:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1223:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==36) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1224:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1224:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1225:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall2718);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1241:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1242:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1242:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1243:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall2739); 

            		newLeafNode(otherlv_1, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1254:2: (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1254:4: otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleNameOrChoiceOrBehaviorCall2752); 

                        	newLeafNode(otherlv_2, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1258:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||(LA22_0>=27 && LA22_0<=30)||LA22_0==32||LA22_0==34||(LA22_0>=37 && LA22_0<=38)||LA22_0==40||LA22_0==44||(LA22_0>=46 && LA22_0<=51)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1259:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1259:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1260:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall2773);
                            lv_arguments_3_0=ruleListOfValues();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"arguments",
                                    		lv_arguments_3_0, 
                                    		"ListOfValues");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleNameOrChoiceOrBehaviorCall2786); 

                        	newLeafNode(otherlv_4, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getRightParenthesisKeyword_2_2());
                        

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
    // $ANTLR end "ruleNameOrChoiceOrBehaviorCall"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1288:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1289:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1290:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2824);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2834); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1297:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1300:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1301:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1301:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1301:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1301:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1302:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1302:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1303:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2879); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleQualifiedName2891); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1318:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==36) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1319:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1319:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1320:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName2912);
                    lv_remaining_2_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                    	        }
                           		set(
                           			current, 
                           			"remaining",
                            		lv_remaining_2_0, 
                            		"QualifiedName");
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleInterval"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1344:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1345:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1346:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval2949);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval2959); 

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
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1353:1: ruleInterval returns [EObject current=null] : ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_isLowerIncluded_1_0=null;
        Token otherlv_3=null;
        Token lv_isUpperIncluded_5_0=null;
        Token otherlv_6=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1356:28: ( ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1357:1: ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1357:1: ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1357:2: (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1357:2: (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1357:4: otherlv_0= ']'
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleInterval2997); 

                        	newLeafNode(otherlv_0, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1362:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1362:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1363:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1363:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1364:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)match(input,38,FOLLOW_38_in_ruleInterval3021); 

                            newLeafNode(lv_isLowerIncluded_1_0, grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntervalRule());
                    	        }
                           		setWithLastConsumed(current, "isLowerIncluded", lv_isLowerIncluded_1_0, "[");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1377:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1378:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1378:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1379:3: lv_lower_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3056);
            lv_lower_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntervalRule());
            	        }
                   		set(
                   			current, 
                   			"lower",
                    		lv_lower_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleInterval3068); 

                	newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1399:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1400:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1400:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1401:3: lv_upper_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3089);
            lv_upper_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntervalRule());
            	        }
                   		set(
                   			current, 
                   			"upper",
                    		lv_upper_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1417:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            else if ( (LA26_0==38) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1417:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1417:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1418:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1418:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1419:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)match(input,37,FOLLOW_37_in_ruleInterval3108); 

                            newLeafNode(lv_isUpperIncluded_5_0, grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntervalRule());
                    	        }
                           		setWithLastConsumed(current, "isUpperIncluded", lv_isUpperIncluded_5_0, "]");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1433:7: otherlv_6= '['
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleInterval3139); 

                        	newLeafNode(otherlv_6, grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_4_1());
                        

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
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleCollectionOrTuple"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1445:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1446:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1447:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             newCompositeNode(grammarAccess.getCollectionOrTupleRule()); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3176);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();

            state._fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3186); 

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
    // $ANTLR end "entryRuleCollectionOrTuple"


    // $ANTLR start "ruleCollectionOrTuple"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1454:1: ruleCollectionOrTuple returns [EObject current=null] : (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_listOfValues_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1457:28: ( (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1458:1: (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1458:1: (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1458:3: otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleCollectionOrTuple3223); 

                	newLeafNode(otherlv_0, grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1462:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1463:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1463:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1464:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        newCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3244);
            lv_listOfValues_1_0=ruleListOfValues();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionOrTupleRule());
            	        }
                   		set(
                   			current, 
                   			"listOfValues",
                    		lv_listOfValues_1_0, 
                    		"ListOfValues");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleCollectionOrTuple3256); 

                	newLeafNode(otherlv_2, grammarAccess.getCollectionOrTupleAccess().getRightCurlyBracketKeyword_2());
                

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
    // $ANTLR end "ruleCollectionOrTuple"


    // $ANTLR start "entryRuleTuple"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1492:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1493:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1494:2: iv_ruleTuple= ruleTuple EOF
            {
             newCompositeNode(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3292);
            iv_ruleTuple=ruleTuple();

            state._fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3302); 

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
    // $ANTLR end "entryRuleTuple"


    // $ANTLR start "ruleTuple"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1501:1: ruleTuple returns [EObject current=null] : (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_listOfValueNamePairs_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1504:28: ( (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1505:1: (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1505:1: (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1505:3: otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleTuple3339); 

                	newLeafNode(otherlv_0, grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1509:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1510:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1510:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1511:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        newCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3360);
            lv_listOfValueNamePairs_1_0=ruleListOfValueNamePairs();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTupleRule());
            	        }
                   		set(
                   			current, 
                   			"listOfValueNamePairs",
                    		lv_listOfValueNamePairs_1_0, 
                    		"ListOfValueNamePairs");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleTuple3372); 

                	newLeafNode(otherlv_2, grammarAccess.getTupleAccess().getRightCurlyBracketKeyword_2());
                

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
    // $ANTLR end "ruleTuple"


    // $ANTLR start "entryRuleListOfValues"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1539:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1540:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1541:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             newCompositeNode(grammarAccess.getListOfValuesRule()); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues3408);
            iv_ruleListOfValues=ruleListOfValues();

            state._fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues3418); 

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
    // $ANTLR end "entryRuleListOfValues"


    // $ANTLR start "ruleListOfValues"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1548:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1551:28: ( ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1552:1: ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1552:1: ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1552:2: ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1552:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1553:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1553:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1554:3: lv_values_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3464);
            lv_values_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListOfValuesRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_0_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1570:2: (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==42) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1570:4: otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleListOfValues3477); 

            	        	newLeafNode(otherlv_1, grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1574:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1575:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1575:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1576:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3498);
            	    lv_values_2_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getListOfValuesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


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
    // $ANTLR end "ruleListOfValues"


    // $ANTLR start "entryRuleListOfValueNamePairs"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1600:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1601:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1602:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             newCompositeNode(grammarAccess.getListOfValueNamePairsRule()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3536);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();

            state._fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs3546); 

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
    // $ANTLR end "entryRuleListOfValueNamePairs"


    // $ANTLR start "ruleListOfValueNamePairs"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1609:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1612:28: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1613:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1613:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1613:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1613:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1614:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1614:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1615:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        newCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3592);
            lv_valueNamePairs_0_0=ruleValueNamePair();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListOfValueNamePairsRule());
            	        }
                   		add(
                   			current, 
                   			"valueNamePairs",
                    		lv_valueNamePairs_0_0, 
                    		"ValueNamePair");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1631:2: (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1631:4: otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleListOfValueNamePairs3605); 

            	        	newLeafNode(otherlv_1, grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1635:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1636:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1636:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1637:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3626);
            	    lv_valueNamePairs_2_0=ruleValueNamePair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getListOfValueNamePairsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"valueNamePairs",
            	            		lv_valueNamePairs_2_0, 
            	            		"ValueNamePair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


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
    // $ANTLR end "ruleListOfValueNamePairs"


    // $ANTLR start "entryRuleValueNamePair"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1661:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1662:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1663:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             newCompositeNode(grammarAccess.getValueNamePairRule()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3664);
            iv_ruleValueNamePair=ruleValueNamePair();

            state._fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair3674); 

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
    // $ANTLR end "entryRuleValueNamePair"


    // $ANTLR start "ruleValueNamePair"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1670:1: ruleValueNamePair returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1673:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1674:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1674:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1674:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1674:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1675:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1675:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1676:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getValueNamePairRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair3719); 

            		newLeafNode(otherlv_0, grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleValueNamePair3731); 

                	newLeafNode(otherlv_1, grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1691:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1692:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1692:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1693:3: lv_value_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair3752);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueNamePairRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleValueNamePair"


    // $ANTLR start "entryRuleTimeExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1717:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1718:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1719:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             newCompositeNode(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression3788);
            iv_ruleTimeExpression=ruleTimeExpression();

            state._fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression3798); 

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
    // $ANTLR end "entryRuleTimeExpression"


    // $ANTLR start "ruleTimeExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1726:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1729:28: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1730:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1730:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt29=1;
                }
                break;
            case 46:
                {
                alt29=2;
                }
                break;
            case 47:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1731:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression3845);
                    this_InstantObsExpression_0=ruleInstantObsExpression();

                    state._fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1741:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression3872);
                    this_DurationObsExpression_1=ruleDurationObsExpression();

                    state._fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1751:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression3899);
                    this_JitterExp_2=ruleJitterExp();

                    state._fsp--;

                     
                            current = this_JitterExp_2; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleTimeExpression"


    // $ANTLR start "entryRuleInstantObsExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1767:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1768:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1769:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             newCompositeNode(grammarAccess.getInstantObsExpressionRule()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression3934);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();

            state._fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression3944); 

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
    // $ANTLR end "entryRuleInstantObsExpression"


    // $ANTLR start "ruleInstantObsExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1776:1: ruleInstantObsExpression returns [EObject current=null] : (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1779:28: ( (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1780:1: (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1780:1: (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1780:3: otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleInstantObsExpression3981); 

                	newLeafNode(otherlv_0, grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1784:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1785:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1785:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1786:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4002);
            lv_id_1_0=ruleInstantObsName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstantObsExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"InstantObsName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1802:2: (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==34) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1802:4: otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleInstantObsExpression4015); 

                        	newLeafNode(otherlv_2, grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1806:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1807:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1807:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1808:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4036);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstantObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleInstantObsExpression4048); 

                        	newLeafNode(otherlv_4, grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1828:3: (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==45) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1828:5: otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleInstantObsExpression4063); 

                        	newLeafNode(otherlv_5, grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleInstantObsExpression4075); 

                        	newLeafNode(otherlv_6, grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1836:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1837:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1837:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1838:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4096);
                    lv_condition_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstantObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleInstantObsExpression4108); 

                        	newLeafNode(otherlv_8, grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_3_3());
                        

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
    // $ANTLR end "ruleInstantObsExpression"


    // $ANTLR start "entryRuleInstantObsName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1866:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1867:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1868:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             newCompositeNode(grammarAccess.getInstantObsNameRule()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4146);
            iv_ruleInstantObsName=ruleInstantObsName();

            state._fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4156); 

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
    // $ANTLR end "entryRuleInstantObsName"


    // $ANTLR start "ruleInstantObsName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1875:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1878:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1879:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1879:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1879:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1879:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==36) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1880:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1880:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1881:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4202);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstantObsNameRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1897:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1898:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1898:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1899:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInstantObsNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4223); 

            		newLeafNode(otherlv_1, grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleInstantObsName"


    // $ANTLR start "entryRuleDurationObsExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1918:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1919:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1920:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             newCompositeNode(grammarAccess.getDurationObsExpressionRule()); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4259);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();

            state._fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4269); 

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
    // $ANTLR end "entryRuleDurationObsExpression"


    // $ANTLR start "ruleDurationObsExpression"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1927:1: ruleDurationObsExpression returns [EObject current=null] : (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1930:28: ( (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1931:1: (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1931:1: (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1931:3: otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleDurationObsExpression4306); 

                	newLeafNode(otherlv_0, grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1935:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1936:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1936:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1937:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4327);
            lv_id_1_0=ruleDurationObsName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDurationObsExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"DurationObsName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1953:2: (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1953:4: otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleDurationObsExpression4340); 

                        	newLeafNode(otherlv_2, grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1957:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1958:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1958:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1959:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4361);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDurationObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleDurationObsExpression4373); 

                        	newLeafNode(otherlv_4, grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1979:3: (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==45) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1979:5: otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleDurationObsExpression4388); 

                        	newLeafNode(otherlv_5, grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleDurationObsExpression4400); 

                        	newLeafNode(otherlv_6, grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1987:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1988:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1988:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1989:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4421);
                    lv_condition_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDurationObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleDurationObsExpression4433); 

                        	newLeafNode(otherlv_8, grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_3_3());
                        

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
    // $ANTLR end "ruleDurationObsExpression"


    // $ANTLR start "entryRuleDurationObsName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2017:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2018:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2019:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             newCompositeNode(grammarAccess.getDurationObsNameRule()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4471);
            iv_ruleDurationObsName=ruleDurationObsName();

            state._fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName4481); 

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
    // $ANTLR end "entryRuleDurationObsName"


    // $ANTLR start "ruleDurationObsName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2026:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2029:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==36) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2031:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2031:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2032:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName4527);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDurationObsNameRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2048:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2049:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2049:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2050:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDurationObsNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName4548); 

            		newLeafNode(otherlv_1, grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleDurationObsName"


    // $ANTLR start "entryRuleJitterExp"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2069:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2070:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2071:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             newCompositeNode(grammarAccess.getJitterExpRule()); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp4584);
            iv_ruleJitterExp=ruleJitterExp();

            state._fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp4594); 

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
    // $ANTLR end "entryRuleJitterExp"


    // $ANTLR start "ruleJitterExp"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2078:1: ruleJitterExp returns [EObject current=null] : (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2081:28: ( (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2082:1: (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2082:1: (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2082:3: otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleJitterExp4631); 

                	newLeafNode(otherlv_0, grammarAccess.getJitterExpAccess().getJitterKeyword_0());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2086:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2087:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2087:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2088:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        newCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4652);
            lv_firstInstant_1_0=ruleInstantObsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJitterExpRule());
            	        }
                   		set(
                   			current, 
                   			"firstInstant",
                    		lv_firstInstant_1_0, 
                    		"InstantObsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2104:2: (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2104:4: otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleJitterExp4665); 

                        	newLeafNode(otherlv_2, grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2108:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2109:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2109:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2110:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4686);
                    lv_secondInstant_3_0=ruleInstantObsExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getJitterExpRule());
                    	        }
                           		set(
                           			current, 
                           			"secondInstant",
                            		lv_secondInstant_3_0, 
                            		"InstantObsExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleJitterExp4700); 

                	newLeafNode(otherlv_4, grammarAccess.getJitterExpAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleJitterExp"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2138:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2139:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2140:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4736);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration4746); 

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2147:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2150:28: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2151:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2151:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2151:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2151:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=49 && LA37_0<=51)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2152:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2152:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2153:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration4792);
                    lv_variableDeclaration_0_0=ruleVariableDirectionKind();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"variableDeclaration",
                            		lv_variableDeclaration_0_0, 
                            		"VariableDirectionKind");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleVariableDeclaration4805); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1());
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2173:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2174:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2174:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2175:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration4822); 

            			newLeafNode(lv_name_2_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2191:2: ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==26) ) {
                alt39=1;
            }
            else if ( (LA39_0==43) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2191:3: (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2191:3: (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2191:5: otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )?
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleVariableDeclaration4841); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2195:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2196:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2196:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2197:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration4862);
                    lv_type_4_0=ruleDataTypeName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"DataTypeName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2213:2: (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==43) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2213:4: otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')'
                            {
                            otherlv_5=(Token)match(input,43,FOLLOW_43_in_ruleVariableDeclaration4875); 

                                	newLeafNode(otherlv_5, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0());
                                
                            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleVariableDeclaration4887); 

                                	newLeafNode(otherlv_6, grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1());
                                
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2221:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2222:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2222:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2223:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration4908);
                            lv_initValue_7_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"initValue",
                                    		lv_initValue_7_0, 
                                    		"Expression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleVariableDeclaration4920); 

                                	newLeafNode(otherlv_8, grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2244:6: (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2244:6: (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2244:8: otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,43,FOLLOW_43_in_ruleVariableDeclaration4942); 

                        	newLeafNode(otherlv_9, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0());
                        
                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleVariableDeclaration4954); 

                        	newLeafNode(otherlv_10, grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1());
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2252:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2253:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2253:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2254:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration4975);
                    lv_initValue_11_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"initValue",
                            		lv_initValue_11_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,35,FOLLOW_35_in_ruleVariableDeclaration4987); 

                        	newLeafNode(otherlv_12, grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_1_3());
                        

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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleVariableDirectionKind"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2282:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2283:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2284:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             newCompositeNode(grammarAccess.getVariableDirectionKindRule()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5026);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();

            state._fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5037); 

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
    // $ANTLR end "entryRuleVariableDirectionKind"


    // $ANTLR start "ruleVariableDirectionKind"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2291:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2294:28: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2295:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2295:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt40=1;
                }
                break;
            case 50:
                {
                alt40=2;
                }
                break;
            case 51:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2296:2: kw= 'in'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleVariableDirectionKind5075); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2303:2: kw= 'out'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleVariableDirectionKind5094); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2310:2: kw= 'inout'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleVariableDirectionKind5113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getInoutKeyword_2()); 
                        

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
    // $ANTLR end "ruleVariableDirectionKind"


    // $ANTLR start "entryRuleDataTypeName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2323:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2324:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2325:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             newCompositeNode(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5153);
            iv_ruleDataTypeName=ruleDataTypeName();

            state._fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5163); 

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
    // $ANTLR end "entryRuleDataTypeName"


    // $ANTLR start "ruleDataTypeName"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2332:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2335:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2336:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2336:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2336:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2336:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==36) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2337:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2337:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2338:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5209);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataTypeNameRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2354:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2355:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2355:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2356:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDataTypeNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5230); 

            		newLeafNode(otherlv_1, grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleDataTypeName"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2375:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2376:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2377:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5266);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();

            state._fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5276); 

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
    // $ANTLR end "entryRuleNumberLiteralRule"


    // $ANTLR start "ruleNumberLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2384:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2387:28: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2388:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2388:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt42=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt42=1;
                }
                break;
            case 29:
                {
                alt42=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2389:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5323);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();

                    state._fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2399:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5350);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();

                    state._fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2409:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5377);
                    this_RealLiteralRule_2=ruleRealLiteralRule();

                    state._fsp--;

                     
                            current = this_RealLiteralRule_2; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2425:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2426:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2427:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5412);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();

            state._fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5422); 

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
    // $ANTLR end "entryRuleIntegerLiteralRule"


    // $ANTLR start "ruleIntegerLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2434:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2437:28: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2438:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2438:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2439:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2439:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2440:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5463); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralRuleAccess().getValueIntegerLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"IntegerLiteral");
            	    

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
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleUnlimitedLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2464:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2465:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2466:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5503);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();

            state._fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5513); 

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
    // $ANTLR end "entryRuleUnlimitedLiteralRule"


    // $ANTLR start "ruleUnlimitedLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2473:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2476:28: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2477:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2477:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2478:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2478:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2479:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)match(input,29,FOLLOW_29_in_ruleUnlimitedLiteralRule5555); 

                    newLeafNode(lv_value_0_0, grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnlimitedLiteralRuleRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "*");
            	    

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
    // $ANTLR end "ruleUnlimitedLiteralRule"


    // $ANTLR start "entryRuleRealLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2500:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2501:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2502:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5603);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();

            state._fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule5613); 

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
    // $ANTLR end "entryRuleRealLiteralRule"


    // $ANTLR start "ruleRealLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2509:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2512:28: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2513:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2513:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2514:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2514:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2515:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5654); 

            			newLeafNode(lv_value_0_0, grammarAccess.getRealLiteralRuleAccess().getValueRealLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRealLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"RealLiteral");
            	    

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
    // $ANTLR end "ruleRealLiteralRule"


    // $ANTLR start "entryRuleDateTimeLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2539:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2540:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2541:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDateTimeLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5694);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();

            state._fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5704); 

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
    // $ANTLR end "entryRuleDateTimeLiteralRule"


    // $ANTLR start "ruleDateTimeLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2548:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2551:28: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2552:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2552:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2553:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2553:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2554:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5745); 

            			newLeafNode(lv_value_0_0, grammarAccess.getDateTimeLiteralRuleAccess().getValueDateTimeLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateTimeLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"DateTimeLiteral");
            	    

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
    // $ANTLR end "ruleDateTimeLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2578:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2579:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2580:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule5785);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();

            state._fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule5795); 

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
    // $ANTLR end "entryRuleBooleanLiteralRule"


    // $ANTLR start "ruleBooleanLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2587:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2590:28: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2591:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2591:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2592:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2592:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2593:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule5836); 

            			newLeafNode(lv_value_0_0, grammarAccess.getBooleanLiteralRuleAccess().getValueBooleanLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"BooleanLiteral");
            	    

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
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleNullLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2617:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2618:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2619:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule5876);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();

            state._fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule5886); 

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
    // $ANTLR end "entryRuleNullLiteralRule"


    // $ANTLR start "ruleNullLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2626:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2629:28: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2630:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2630:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2631:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2631:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2632:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule5927); 

            			newLeafNode(lv_value_0_0, grammarAccess.getNullLiteralRuleAccess().getValueNullLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNullLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"NullLiteral");
            	    

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
    // $ANTLR end "ruleNullLiteralRule"


    // $ANTLR start "entryRuleDefaultLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2656:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2657:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2658:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDefaultLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule5967);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();

            state._fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule5977); 

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
    // $ANTLR end "entryRuleDefaultLiteralRule"


    // $ANTLR start "ruleDefaultLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2665:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2668:28: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2669:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2669:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2670:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2670:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2671:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)match(input,30,FOLLOW_30_in_ruleDefaultLiteralRule6019); 

                    newLeafNode(lv_value_0_0, grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefaultLiteralRuleRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "/");
            	    

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
    // $ANTLR end "ruleDefaultLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2692:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2693:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2694:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6067);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();

            state._fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6077); 

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
    // $ANTLR end "entryRuleStringLiteralRule"


    // $ANTLR start "ruleStringLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2701:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2704:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2705:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2705:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2706:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2706:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2707:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6118); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleStringLiteralRule"

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\13\uffff";
    static final String DFA15_minS =
        "\1\4\3\uffff\1\4\4\uffff\1\20\1\uffff";
    static final String DFA15_maxS =
        "\1\63\3\uffff\1\63\4\uffff\1\53\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\10\1\4\1\uffff\1\5";
    static final String DFA15_specialS =
        "\13\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\6\1\22\uffff\2\1\3\uffff\1\7\2\uffff\2\3\1\uffff\1\4\3"+
            "\uffff\1\5\1\uffff\2\5\4\6",
            "",
            "",
            "",
            "\1\11\6\10\20\uffff\4\10\1\uffff\1\10\1\uffff\1\10\2\uffff"+
            "\2\10\1\uffff\1\10\3\uffff\1\10\1\uffff\6\10",
            "",
            "",
            "",
            "",
            "\12\10\1\uffff\5\10\1\uffff\2\10\1\uffff\1\10\4\uffff\2\10"+
            "\1\12",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "857:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression221 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_16_in_ruleAndOrXorExpression242 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_17_in_ruleAndOrXorExpression271 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_18_in_ruleAndOrXorExpression300 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression337 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression431 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleEqualityExpression452 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_20_in_ruleEqualityExpression481 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression518 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression612 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_21_in_ruleRelationalExpression633 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_22_in_ruleRelationalExpression662 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_23_in_ruleRelationalExpression691 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_24_in_ruleRelationalExpression720 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression757 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression851 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleConditionalExpression870 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression904 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression916 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1031 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleAdditiveExpression1052 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_28_in_ruleAdditiveExpression1081 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1118 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1212 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_29_in_ruleMultiplicativeExpression1233 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_30_in_ruleMultiplicativeExpression1262 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeExpression1291 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1328 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnaryExpression1422 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_28_in_ruleUnaryExpression1451 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_27_in_ruleUnaryExpression1480 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1637 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rulePrimaryExpression1650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification1709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleValueSpecification1946 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification1968 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleValueSpecification1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2190 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rulePropertyCallExpression2203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2317 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleOperationCallExpression2329 = new BitSet(new long[]{0x000FD16D780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2350 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleOperationCallExpression2363 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleOperationCallExpression2376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral2627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall2718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall2739 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleNameOrChoiceOrBehaviorCall2752 = new BitSet(new long[]{0x000FD16D780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall2773 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleNameOrChoiceOrBehaviorCall2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2879 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleQualifiedName2891 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName2912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval2949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleInterval2997 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_38_in_ruleInterval3021 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3056 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleInterval3068 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3089 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_37_in_ruleInterval3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleInterval3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleCollectionOrTuple3223 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3244 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleCollectionOrTuple3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTuple3339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3360 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleTuple3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues3408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3464 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleListOfValues3477 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3498 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3592 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleListOfValueNamePairs3605 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3626 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair3719 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleValueNamePair3731 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression3788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression3899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression3934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleInstantObsExpression3981 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4002 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_34_in_ruleInstantObsExpression4015 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4036 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleInstantObsExpression4048 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleInstantObsExpression4063 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleInstantObsExpression4075 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4096 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleInstantObsExpression4108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDurationObsExpression4306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4327 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_34_in_ruleDurationObsExpression4340 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4361 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleDurationObsExpression4373 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleDurationObsExpression4388 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleDurationObsExpression4400 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4421 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleDurationObsExpression4433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName4527 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName4548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp4584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleJitterExp4631 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4652 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_ruleJitterExp4665 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4686 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleJitterExp4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration4746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration4792 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleVariableDeclaration4805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration4822 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_26_in_ruleVariableDeclaration4841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration4862 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration4875 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleVariableDeclaration4887 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration4908 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleVariableDeclaration4920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration4942 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleVariableDeclaration4954 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration4975 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleVariableDeclaration4987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleVariableDirectionKind5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleVariableDirectionKind5094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleVariableDirectionKind5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleUnlimitedLiteralRule5555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule5785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule5795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule5876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule5927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule5967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule5977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDefaultLiteralRule6019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6118 = new BitSet(new long[]{0x0000000000000002L});

}