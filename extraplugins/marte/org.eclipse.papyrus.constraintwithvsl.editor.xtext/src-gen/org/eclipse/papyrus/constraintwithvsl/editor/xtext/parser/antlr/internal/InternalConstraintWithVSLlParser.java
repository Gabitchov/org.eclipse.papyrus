package org.eclipse.papyrus.constraintwithvsl.editor.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.services.ConstraintWithVSLlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConstraintWithVSLlParser extends AbstractInternalAntlrParser {
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


        public InternalConstraintWithVSLlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConstraintWithVSLlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConstraintWithVSLlParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g"; }



     	private ConstraintWithVSLlGrammarAccess grammarAccess;
     	
        public InternalConstraintWithVSLlParser(TokenStream input, ConstraintWithVSLlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ConstraintRule";	
       	}
       	
       	@Override
       	protected ConstraintWithVSLlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleConstraintRule"
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:67:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:68:2: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:69:2: iv_ruleConstraintRule= ruleConstraintRule EOF
            {
             newCompositeNode(grammarAccess.getConstraintRuleRule()); 
            pushFollow(FOLLOW_ruleConstraintRule_in_entryRuleConstraintRule75);
            iv_ruleConstraintRule=ruleConstraintRule();

            state._fsp--;

             current =iv_ruleConstraintRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintRule85); 

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
    // $ANTLR end "entryRuleConstraintRule"


    // $ANTLR start "ruleConstraintRule"
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:76:1: ruleConstraintRule returns [EObject current=null] : ( (lv_specification_0_0= ruleConstraintSpecification ) )? ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject lv_specification_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:79:28: ( ( (lv_specification_0_0= ruleConstraintSpecification ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:80:1: ( (lv_specification_0_0= ruleConstraintSpecification ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:80:1: ( (lv_specification_0_0= ruleConstraintSpecification ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||(LA1_0>=27 && LA1_0<=30)||LA1_0==32||LA1_0==34||(LA1_0>=37 && LA1_0<=38)||LA1_0==40||LA1_0==44||(LA1_0>=46 && LA1_0<=51)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:81:1: (lv_specification_0_0= ruleConstraintSpecification )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:81:1: (lv_specification_0_0= ruleConstraintSpecification )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:82:3: lv_specification_0_0= ruleConstraintSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstraintRuleAccess().getSpecificationConstraintSpecificationParserRuleCall_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstraintSpecification_in_ruleConstraintRule130);
                    lv_specification_0_0=ruleConstraintSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstraintRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"specification",
                            		lv_specification_0_0, 
                            		"ConstraintSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleConstraintSpecification"
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:106:1: entryRuleConstraintSpecification returns [EObject current=null] : iv_ruleConstraintSpecification= ruleConstraintSpecification EOF ;
    public final EObject entryRuleConstraintSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSpecification = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:107:2: (iv_ruleConstraintSpecification= ruleConstraintSpecification EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:108:2: iv_ruleConstraintSpecification= ruleConstraintSpecification EOF
            {
             newCompositeNode(grammarAccess.getConstraintSpecificationRule()); 
            pushFollow(FOLLOW_ruleConstraintSpecification_in_entryRuleConstraintSpecification166);
            iv_ruleConstraintSpecification=ruleConstraintSpecification();

            state._fsp--;

             current =iv_ruleConstraintSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSpecification176); 

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
    // $ANTLR end "entryRuleConstraintSpecification"


    // $ANTLR start "ruleConstraintSpecification"
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:115:1: ruleConstraintSpecification returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleConstraintSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:118:28: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:119:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:119:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:120:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:120:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:121:3: lv_expression_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getConstraintSpecificationAccess().getExpressionExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConstraintSpecification221);
            lv_expression_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_0_0, 
                    		"Expression");
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
    // $ANTLR end "ruleConstraintSpecification"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:145:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:146:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:147:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression256);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression266); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:154:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:157:28: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:158:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:158:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:159:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:159:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:160:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression311);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:184:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:185:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:186:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             newCompositeNode(grammarAccess.getAndOrXorExpressionRule()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression346);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();

            state._fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression356); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:193:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:196:28: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:197:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:197:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:197:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:197:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:198:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:198:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:199:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        newCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression402);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:215:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=16 && LA3_0<=18)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:215:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:215:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:216:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:216:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:217:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:217:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:218:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)match(input,16,FOLLOW_16_in_ruleAndOrXorExpression423); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:230:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)match(input,17,FOLLOW_17_in_ruleAndOrXorExpression452); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:242:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)match(input,18,FOLLOW_18_in_ruleAndOrXorExpression481); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:257:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:258:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:258:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:259:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression518);
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
            	    break loop3;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:283:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:284:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:285:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression556);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression566); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:292:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:295:28: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:296:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:296:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:296:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:296:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:297:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:297:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:298:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression612);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:314:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=19 && LA5_0<=20)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:314:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:314:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:315:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:315:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:316:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:316:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==19) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==20) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:317:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)match(input,19,FOLLOW_19_in_ruleEqualityExpression633); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:329:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)match(input,20,FOLLOW_20_in_ruleEqualityExpression662); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:344:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:345:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:345:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:346:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression699);
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
            	    break loop5;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:370:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:371:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:372:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression737);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression747); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:379:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:382:28: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:383:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:383:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:383:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:383:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:384:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:384:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:385:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression793);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:401:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=21 && LA7_0<=24)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:401:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:401:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:402:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:402:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:403:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:403:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt6=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt6=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt6=2;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt6=3;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt6=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:404:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)match(input,21,FOLLOW_21_in_ruleRelationalExpression814); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:416:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)match(input,22,FOLLOW_22_in_ruleRelationalExpression843); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:428:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)match(input,23,FOLLOW_23_in_ruleRelationalExpression872); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:440:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)match(input,24,FOLLOW_24_in_ruleRelationalExpression901); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:455:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:456:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:456:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:457:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression938);
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
            	    break loop7;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:481:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:482:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:483:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression976);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression986); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:490:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token otherlv_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:493:28: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:494:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:494:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:494:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:494:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:495:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:495:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:496:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1032);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:512:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:512:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:512:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:513:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:513:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:514:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)match(input,25,FOLLOW_25_in_ruleConditionalExpression1051); 

                            newLeafNode(lv_op_1_0, grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		addWithLastConsumed(current, "op", lv_op_1_0, "?");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:527:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:528:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:528:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:529:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1085);
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

                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleConditionalExpression1097); 

                        	newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:549:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:550:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:550:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:551:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1118);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:575:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:576:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:577:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1156);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1166); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:584:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:587:28: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:588:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:588:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:588:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:588:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:589:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:589:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:590:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1212);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:606:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=27 && LA10_0<=28)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:606:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:606:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:607:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:607:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:608:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:608:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==27) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==28) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:609:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)match(input,27,FOLLOW_27_in_ruleAdditiveExpression1233); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:621:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)match(input,28,FOLLOW_28_in_ruleAdditiveExpression1262); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:636:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:637:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:637:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:638:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1299);
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
            	    break loop10;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:662:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:663:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:664:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1337);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1347); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:671:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:674:28: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:675:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:675:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:675:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:675:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:676:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:676:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:677:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1393);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:693:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=29 && LA12_0<=31)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:693:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:693:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:694:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:694:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:695:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:695:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt11=3;
            	    switch ( input.LA(1) ) {
            	    case 29:
            	        {
            	        alt11=1;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt11=2;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt11=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt11) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:696:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)match(input,29,FOLLOW_29_in_ruleMultiplicativeExpression1414); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:708:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)match(input,30,FOLLOW_30_in_ruleMultiplicativeExpression1443); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:720:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)match(input,31,FOLLOW_31_in_ruleMultiplicativeExpression1472); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:735:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:736:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:736:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:737:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1509);
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
            	    break loop12;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:761:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:762:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:763:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1547);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1557); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:770:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:773:28: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:774:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:774:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=27 && LA14_0<=28)||LA14_0==32) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=RULE_ID && LA14_0<=RULE_STRING)||(LA14_0>=29 && LA14_0<=30)||LA14_0==34||(LA14_0>=37 && LA14_0<=38)||LA14_0==40||LA14_0==44||(LA14_0>=46 && LA14_0<=51)) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:774:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:774:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:774:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:774:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:775:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:775:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:776:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:776:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt13=3;
                    switch ( input.LA(1) ) {
                    case 32:
                        {
                        alt13=1;
                        }
                        break;
                    case 28:
                        {
                        alt13=2;
                        }
                        break;
                    case 27:
                        {
                        alt13=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }

                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:777:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)match(input,32,FOLLOW_32_in_ruleUnaryExpression1603); 

                                    newLeafNode(lv_op_0_1, grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:789:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)match(input,28,FOLLOW_28_in_ruleUnaryExpression1632); 

                                    newLeafNode(lv_op_0_2, grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:801:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)match(input,27,FOLLOW_27_in_ruleUnaryExpression1661); 

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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:816:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:817:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:817:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:818:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1698);
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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:835:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:835:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:836:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:836:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:837:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1726);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:861:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:862:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:863:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1762);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1772); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:870:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:873:28: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:874:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:874:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:874:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:874:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:875:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:875:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:876:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1818);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:892:2: (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:892:4: otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_rulePrimaryExpression1831); 

                        	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:896:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:897:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:897:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:898:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression1852);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:922:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:923:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:924:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             newCompositeNode(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification1890);
            iv_ruleValueSpecification=ruleValueSpecification();

            state._fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification1900); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:931:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:934:28: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:935:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:935:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            int alt16=8;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:936:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification1947);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:946:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification1974);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();

                    state._fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:956:5: this_Interval_2= ruleInterval
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification2001);
                    this_Interval_2=ruleInterval();

                    state._fsp--;

                     
                            current = this_Interval_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:966:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2028);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();

                    state._fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:976:5: this_Tuple_4= ruleTuple
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2055);
                    this_Tuple_4=ruleTuple();

                    state._fsp--;

                     
                            current = this_Tuple_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:986:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2082);
                    this_TimeExpression_5=ruleTimeExpression();

                    state._fsp--;

                     
                            current = this_TimeExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:996:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2109);
                    this_VariableDeclaration_6=ruleVariableDeclaration();

                    state._fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1005:6: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1005:6: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1005:8: otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleValueSpecification2127); 

                        	newLeafNode(otherlv_7, grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0());
                        
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2149);
                    this_Expression_8=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_8; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_9=(Token)match(input,35,FOLLOW_35_in_ruleValueSpecification2160); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1030:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1031:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1032:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             newCompositeNode(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2197);
            iv_ruleSuffixExpression=ruleSuffixExpression();

            state._fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2207); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1039:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1042:28: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1043:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1043:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==34) ) {
                    alt17=2;
                }
                else if ( (LA17_1==EOF||(LA17_1>=16 && LA17_1<=31)||LA17_1==33||LA17_1==35||(LA17_1>=37 && LA17_1<=39)||(LA17_1>=41 && LA17_1<=42)) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1044:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2254);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();

                    state._fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1054:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2281);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1070:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1071:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1072:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2316);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();

            state._fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2326); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1079:1: rulePropertyCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1082:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1083:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1083:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1083:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1083:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1085:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyCallExpressionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2371); 

            		newLeafNode(otherlv_0, grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1096:2: (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1096:4: otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_rulePropertyCallExpression2384); 

                        	newLeafNode(otherlv_1, grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1100:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1101:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1101:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1102:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2405);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1126:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1127:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1128:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             newCompositeNode(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2443);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();

            state._fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2453); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1135:1: ruleOperationCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1138:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1139:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1139:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1139:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1139:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1140:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1140:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1141:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationCallExpressionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2498); 

            		newLeafNode(otherlv_0, grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleOperationCallExpression2510); 

                	newLeafNode(otherlv_1, grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1156:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)||(LA19_0>=27 && LA19_0<=30)||LA19_0==32||LA19_0==34||(LA19_0>=37 && LA19_0<=38)||LA19_0==40||LA19_0==44||(LA19_0>=46 && LA19_0<=51)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1157:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1157:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1158:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2531);
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

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleOperationCallExpression2544); 

                	newLeafNode(otherlv_3, grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1178:1: (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1178:3: otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleOperationCallExpression2557); 

                        	newLeafNode(otherlv_4, grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1182:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1183:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1183:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1184:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2578);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1208:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1209:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1210:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2616);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2626); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1217:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1220:28: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1221:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1221:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt21=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 29:
                {
                alt21=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt21=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt21=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt21=4;
                }
                break;
            case 30:
                {
                alt21=5;
                }
                break;
            case RULE_STRING:
                {
                alt21=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1222:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2673);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();

                    state._fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1232:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2700);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();

                    state._fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1242:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2727);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();

                    state._fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1252:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral2754);
                    this_NullLiteralRule_3=ruleNullLiteralRule();

                    state._fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1262:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2781);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();

                    state._fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1272:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral2808);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1288:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1289:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1290:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2843);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();

            state._fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall2853); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1297:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1300:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1301:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1301:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1301:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1301:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==36) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1302:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1302:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1303:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall2899);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1319:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1320:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1320:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1321:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall2920); 

            		newLeafNode(otherlv_1, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1332:2: (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1332:4: otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleNameOrChoiceOrBehaviorCall2933); 

                        	newLeafNode(otherlv_2, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1336:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||(LA23_0>=27 && LA23_0<=30)||LA23_0==32||LA23_0==34||(LA23_0>=37 && LA23_0<=38)||LA23_0==40||LA23_0==44||(LA23_0>=46 && LA23_0<=51)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1337:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1337:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1338:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall2954);
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

                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleNameOrChoiceOrBehaviorCall2967); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1366:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1367:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1368:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3005);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3015); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1375:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1378:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1379:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1379:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1379:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1379:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1380:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1380:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1381:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3060); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleQualifiedName3072); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1396:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==36) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1397:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1397:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1398:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3093);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1422:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1423:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1424:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3130);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3140); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1431:1: ruleInterval returns [EObject current=null] : ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1434:28: ( ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1435:1: ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1435:1: ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1435:2: (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1435:2: (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1435:4: otherlv_0= ']'
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleInterval3178); 

                        	newLeafNode(otherlv_0, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1440:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1440:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1441:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1441:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1442:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)match(input,38,FOLLOW_38_in_ruleInterval3202); 

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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1455:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1456:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1456:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1457:3: lv_lower_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3237);
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

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleInterval3249); 

                	newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1477:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1478:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1478:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1479:3: lv_upper_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3270);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1495:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37) ) {
                alt27=1;
            }
            else if ( (LA27_0==38) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1495:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1495:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1496:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1496:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1497:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)match(input,37,FOLLOW_37_in_ruleInterval3289); 

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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1511:7: otherlv_6= '['
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleInterval3320); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1523:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1524:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1525:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             newCompositeNode(grammarAccess.getCollectionOrTupleRule()); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3357);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();

            state._fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3367); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1532:1: ruleCollectionOrTuple returns [EObject current=null] : (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_listOfValues_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1535:28: ( (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1536:1: (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1536:1: (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1536:3: otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleCollectionOrTuple3404); 

                	newLeafNode(otherlv_0, grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1540:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1541:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1541:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1542:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        newCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3425);
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

            otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleCollectionOrTuple3437); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1570:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1571:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1572:2: iv_ruleTuple= ruleTuple EOF
            {
             newCompositeNode(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3473);
            iv_ruleTuple=ruleTuple();

            state._fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3483); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1579:1: ruleTuple returns [EObject current=null] : (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_listOfValueNamePairs_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1582:28: ( (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1583:1: (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1583:1: (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1583:3: otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleTuple3520); 

                	newLeafNode(otherlv_0, grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1587:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1588:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1588:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1589:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        newCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3541);
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

            otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleTuple3553); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1617:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1618:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1619:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             newCompositeNode(grammarAccess.getListOfValuesRule()); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues3589);
            iv_ruleListOfValues=ruleListOfValues();

            state._fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues3599); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1626:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1629:28: ( ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1630:1: ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1630:1: ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1630:2: ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1630:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1631:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1631:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1632:3: lv_values_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3645);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1648:2: (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1648:4: otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleListOfValues3658); 

            	        	newLeafNode(otherlv_1, grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1652:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1653:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1653:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1654:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3679);
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
    // $ANTLR end "ruleListOfValues"


    // $ANTLR start "entryRuleListOfValueNamePairs"
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1678:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1679:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1680:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             newCompositeNode(grammarAccess.getListOfValueNamePairsRule()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3717);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();

            state._fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs3727); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1690:28: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1691:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1691:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1691:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1691:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1692:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1692:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1693:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        newCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3773);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1709:2: (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==42) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1709:4: otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleListOfValueNamePairs3786); 

            	        	newLeafNode(otherlv_1, grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1713:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1714:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1714:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1715:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3807);
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
            	    break loop29;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1739:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1740:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1741:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             newCompositeNode(grammarAccess.getValueNamePairRule()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3845);
            iv_ruleValueNamePair=ruleValueNamePair();

            state._fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair3855); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1748:1: ruleValueNamePair returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1751:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1752:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1752:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1752:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1752:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1753:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1753:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1754:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getValueNamePairRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair3900); 

            		newLeafNode(otherlv_0, grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleValueNamePair3912); 

                	newLeafNode(otherlv_1, grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1769:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1770:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1770:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1771:3: lv_value_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair3933);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1795:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1796:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1797:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             newCompositeNode(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression3969);
            iv_ruleTimeExpression=ruleTimeExpression();

            state._fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression3979); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1804:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1807:28: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1808:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1808:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt30=1;
                }
                break;
            case 46:
                {
                alt30=2;
                }
                break;
            case 47:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1809:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4026);
                    this_InstantObsExpression_0=ruleInstantObsExpression();

                    state._fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1819:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4053);
                    this_DurationObsExpression_1=ruleDurationObsExpression();

                    state._fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1829:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4080);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1845:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1846:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1847:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             newCompositeNode(grammarAccess.getInstantObsExpressionRule()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4115);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();

            state._fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4125); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1854:1: ruleInstantObsExpression returns [EObject current=null] : (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1857:28: ( (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1858:1: (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1858:1: (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1858:3: otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleInstantObsExpression4162); 

                	newLeafNode(otherlv_0, grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1862:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1863:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1863:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1864:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4183);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1880:2: (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1880:4: otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleInstantObsExpression4196); 

                        	newLeafNode(otherlv_2, grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1884:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1885:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1885:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1886:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4217);
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

                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleInstantObsExpression4229); 

                        	newLeafNode(otherlv_4, grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1906:3: (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1906:5: otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleInstantObsExpression4244); 

                        	newLeafNode(otherlv_5, grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleInstantObsExpression4256); 

                        	newLeafNode(otherlv_6, grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1914:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1915:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1915:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1916:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4277);
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

                    otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleInstantObsExpression4289); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1944:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1945:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1946:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             newCompositeNode(grammarAccess.getInstantObsNameRule()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4327);
            iv_ruleInstantObsName=ruleInstantObsName();

            state._fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4337); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1953:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1956:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1957:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1957:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1957:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1957:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==36) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1958:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1958:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1959:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4383);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1975:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1976:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1976:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1977:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInstantObsNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4404); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1996:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1997:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1998:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             newCompositeNode(grammarAccess.getDurationObsExpressionRule()); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4440);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();

            state._fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4450); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2005:1: ruleDurationObsExpression returns [EObject current=null] : (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2008:28: ( (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2009:1: (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2009:1: (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2009:3: otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleDurationObsExpression4487); 

                	newLeafNode(otherlv_0, grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2013:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2014:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2014:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2015:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4508);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2031:2: (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==34) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2031:4: otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleDurationObsExpression4521); 

                        	newLeafNode(otherlv_2, grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2035:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2036:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2036:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2037:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4542);
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

                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleDurationObsExpression4554); 

                        	newLeafNode(otherlv_4, grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2057:3: (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==45) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2057:5: otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleDurationObsExpression4569); 

                        	newLeafNode(otherlv_5, grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleDurationObsExpression4581); 

                        	newLeafNode(otherlv_6, grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2065:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2066:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2066:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2067:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4602);
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

                    otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleDurationObsExpression4614); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2095:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2096:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2097:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             newCompositeNode(grammarAccess.getDurationObsNameRule()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4652);
            iv_ruleDurationObsName=ruleDurationObsName();

            state._fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName4662); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2104:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2107:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2108:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2108:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2108:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2108:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==36) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2109:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2109:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2110:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName4708);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2126:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2127:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2127:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2128:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDurationObsNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName4729); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2147:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2148:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2149:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             newCompositeNode(grammarAccess.getJitterExpRule()); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp4765);
            iv_ruleJitterExp=ruleJitterExp();

            state._fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp4775); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2156:1: ruleJitterExp returns [EObject current=null] : (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2159:28: ( (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2160:1: (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2160:1: (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2160:3: otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleJitterExp4812); 

                	newLeafNode(otherlv_0, grammarAccess.getJitterExpAccess().getJitterKeyword_0());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2164:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2165:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2165:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2166:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        newCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4833);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2182:2: (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==28) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2182:4: otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleJitterExp4846); 

                        	newLeafNode(otherlv_2, grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2186:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2187:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2187:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2188:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4867);
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

            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleJitterExp4881); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2216:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2217:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2218:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4917);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration4927); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2225:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2228:28: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2229:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2229:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2229:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2229:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=49 && LA38_0<=51)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2230:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2230:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2231:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration4973);
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

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleVariableDeclaration4986); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1());
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2251:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2252:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2252:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2253:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration5003); 

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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2269:2: ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==26) ) {
                alt40=1;
            }
            else if ( (LA40_0==43) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2269:3: (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2269:3: (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2269:5: otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )?
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleVariableDeclaration5022); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2273:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2274:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2274:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2275:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5043);
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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2291:2: (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==43) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2291:4: otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')'
                            {
                            otherlv_5=(Token)match(input,43,FOLLOW_43_in_ruleVariableDeclaration5056); 

                                	newLeafNode(otherlv_5, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0());
                                
                            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleVariableDeclaration5068); 

                                	newLeafNode(otherlv_6, grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1());
                                
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2299:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2300:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2300:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2301:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5089);
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

                            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleVariableDeclaration5101); 

                                	newLeafNode(otherlv_8, grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2322:6: (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2322:6: (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2322:8: otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,43,FOLLOW_43_in_ruleVariableDeclaration5123); 

                        	newLeafNode(otherlv_9, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0());
                        
                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleVariableDeclaration5135); 

                        	newLeafNode(otherlv_10, grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1());
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2330:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2331:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2331:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2332:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5156);
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

                    otherlv_12=(Token)match(input,35,FOLLOW_35_in_ruleVariableDeclaration5168); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2360:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2361:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2362:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             newCompositeNode(grammarAccess.getVariableDirectionKindRule()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5207);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();

            state._fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5218); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2369:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2372:28: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2373:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2373:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt41=1;
                }
                break;
            case 50:
                {
                alt41=2;
                }
                break;
            case 51:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2374:2: kw= 'in'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleVariableDirectionKind5256); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2381:2: kw= 'out'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleVariableDirectionKind5275); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2388:2: kw= 'inout'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleVariableDirectionKind5294); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2401:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2402:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2403:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             newCompositeNode(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5334);
            iv_ruleDataTypeName=ruleDataTypeName();

            state._fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5344); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2410:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2413:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2414:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2414:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2414:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2414:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==36) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2415:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2415:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2416:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5390);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2432:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2433:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2433:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2434:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDataTypeNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5411); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2453:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2454:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2455:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5447);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();

            state._fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5457); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2462:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2465:28: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2466:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2466:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt43=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt43=1;
                }
                break;
            case 29:
                {
                alt43=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2467:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5504);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();

                    state._fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2477:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5531);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();

                    state._fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2487:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5558);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2503:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2504:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2505:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5593);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();

            state._fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5603); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2512:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2515:28: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2516:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2516:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2517:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2517:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2518:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5644); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2542:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2543:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2544:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5684);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();

            state._fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5694); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2551:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2554:28: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2555:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2555:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2556:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2556:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2557:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)match(input,29,FOLLOW_29_in_ruleUnlimitedLiteralRule5736); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2578:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2579:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2580:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5784);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();

            state._fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule5794); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2587:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2590:28: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2591:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2591:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2592:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2592:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2593:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5835); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2617:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2618:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2619:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDateTimeLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5875);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();

            state._fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5885); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2626:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2629:28: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2630:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2630:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2631:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2631:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2632:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5926); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2656:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2657:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2658:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule5966);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();

            state._fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule5976); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2665:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2668:28: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2669:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2669:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2670:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2670:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2671:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6017); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2695:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2696:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2697:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6057);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();

            state._fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule6067); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2704:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2707:28: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2708:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2708:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2709:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2709:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2710:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6108); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2734:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2735:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2736:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDefaultLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6148);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();

            state._fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6158); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2743:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2746:28: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2747:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2747:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2748:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2748:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2749:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)match(input,30,FOLLOW_30_in_ruleDefaultLiteralRule6200); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2770:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2771:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2772:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6248);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();

            state._fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6258); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2779:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2782:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2783:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2783:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2784:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2784:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2785:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6299); 

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


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\13\uffff";
    static final String DFA16_eofS =
        "\13\uffff";
    static final String DFA16_minS =
        "\1\4\3\uffff\1\4\4\uffff\1\20\1\uffff";
    static final String DFA16_maxS =
        "\1\63\3\uffff\1\63\4\uffff\1\53\1\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\10\1\4\1\uffff\1\5";
    static final String DFA16_specialS =
        "\13\uffff}>";
    static final String[] DFA16_transitionS = {
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "935:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleConstraintRule_in_entryRuleConstraintRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSpecification_in_ruleConstraintRule130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSpecification_in_entryRuleConstraintSpecification166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSpecification176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstraintSpecification221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression402 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_16_in_ruleAndOrXorExpression423 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_17_in_ruleAndOrXorExpression452 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_18_in_ruleAndOrXorExpression481 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression518 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression612 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleEqualityExpression633 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_20_in_ruleEqualityExpression662 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression699 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression793 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_21_in_ruleRelationalExpression814 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_22_in_ruleRelationalExpression843 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_23_in_ruleRelationalExpression872 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_24_in_ruleRelationalExpression901 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression938 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1032 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleConditionalExpression1051 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1085 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression1097 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1212 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleAdditiveExpression1233 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_28_in_ruleAdditiveExpression1262 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1299 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1393 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_29_in_ruleMultiplicativeExpression1414 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_30_in_ruleMultiplicativeExpression1443 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeExpression1472 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1509 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnaryExpression1603 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_28_in_ruleUnaryExpression1632 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_27_in_ruleUnaryExpression1661 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1818 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rulePrimaryExpression1831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification1890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleValueSpecification2127 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2149 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleValueSpecification2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2371 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rulePropertyCallExpression2384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2498 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleOperationCallExpression2510 = new BitSet(new long[]{0x000FD16D780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2531 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleOperationCallExpression2544 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleOperationCallExpression2557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall2899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall2920 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleNameOrChoiceOrBehaviorCall2933 = new BitSet(new long[]{0x000FD16D780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall2954 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleNameOrChoiceOrBehaviorCall2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3060 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleQualifiedName3072 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleInterval3178 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_38_in_ruleInterval3202 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3237 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleInterval3249 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3270 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_37_in_ruleInterval3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleInterval3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleCollectionOrTuple3404 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3425 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleCollectionOrTuple3437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTuple3520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3541 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleTuple3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues3589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3645 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleListOfValues3658 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3679 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs3727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3773 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleListOfValueNamePairs3786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3807 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair3855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair3900 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleValueNamePair3912 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression3969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleInstantObsExpression4162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4183 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_34_in_ruleInstantObsExpression4196 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4217 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleInstantObsExpression4229 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleInstantObsExpression4244 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleInstantObsExpression4256 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4277 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleInstantObsExpression4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4383 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDurationObsExpression4487 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4508 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_34_in_ruleDurationObsExpression4521 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4542 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleDurationObsExpression4554 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleDurationObsExpression4569 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleDurationObsExpression4581 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4602 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleDurationObsExpression4614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName4708 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp4765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleJitterExp4812 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4833 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_ruleJitterExp4846 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4867 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleJitterExp4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration4927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration4973 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleVariableDeclaration4986 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration5003 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_26_in_ruleVariableDeclaration5022 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5043 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration5056 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleVariableDeclaration5068 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5089 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleVariableDeclaration5101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration5123 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleVariableDeclaration5135 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5156 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleVariableDeclaration5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleVariableDirectionKind5256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleVariableDirectionKind5275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleVariableDirectionKind5294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5390 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleUnlimitedLiteralRule5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule5794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule5966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule6067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDefaultLiteralRule6200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6299 = new BitSet(new long[]{0x0000000000000002L});

}