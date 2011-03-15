// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g 2011-03-15 17:01:07

package org.eclipse.papyrus.parsers.antlr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.eclipse.papyrus.parsers.texteditor.collaborationuselabel.IContext;
import org.eclipse.papyrus.parsers.util.IErrorReporter;
import org.eclipse.papyrus.parsers.util.NameException;
import org.eclipse.papyrus.parsers.util.MultiplicityException;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;
import org.eclipse.papyrus.parsers.util.Messages;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.VisibilityKind;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class CollaborationUseLabelParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "IDENTIFIER", "WS", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURLY", "DOUBLE_LCURLY", "RCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "RANGE", "COMMA", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "STAR", "DIV", "EQ", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "ALPHA", "UNDERSCORE", "INTEGER", "RANGE_VALUE", "REAL", "INTEGER_OR_REAL_OR_RANGE", "'<Undefined>'"
    };
    public static final int COMMA=30;
    public static final int DOUBLE_LT=41;
    public static final int ISEQ=38;
    public static final int MINUS=6;
    public static final int INCR=46;
    public static final int SHARP=7;
    public static final int DOUBLE_RCURLY=23;
    public static final int DECR=47;
    public static final int ARROW=34;
    public static final int DOUBLE_GT=44;
    public static final int RULE_ASSIGN=33;
    public static final int TILDE=8;
    public static final int PIPE=26;
    public static final int DOUBLE_PIPE=27;
    public static final int INTEGER=51;
    public static final int QUESTION_MARK=12;
    public static final int RCURLY=22;
    public static final int NL=11;
    public static final int LCURLY=20;
    public static final int LE=42;
    public static final int RPAREN=17;
    public static final int LPAREN=16;
    public static final int SINGLE_QUOTE=15;
    public static final int PLUS=5;
    public static final int REAL=53;
    public static final int LSQUARE=18;
    public static final int RANGE=29;
    public static final int FOUR_POINTS=32;
    public static final int DOUBLE_LCURLY=21;
    public static final int POINT=28;
    public static final int WS=10;
    public static final int ALPHA=49;
    public static final int EQ=37;
    public static final int LT=40;
    public static final int GT=43;
    public static final int DOUBLE_QUOTE=14;
    public static final int RSQUARE=19;
    public static final int DOUBLE_LOGICAL_AND=25;
    public static final int RANGE_VALUE=52;
    public static final int T__55=55;
    public static final int SEMI=31;
    public static final int GE=45;
    public static final int LNOT=13;
    public static final int LOGICAL_AND=24;
    public static final int ISNE=39;
    public static final int EOF=-1;
    public static final int COLON=4;
    public static final int INTEGER_OR_REAL_OR_RANGE=54;
    public static final int DIV=36;
    public static final int IDENTIFIER=9;
    public static final int STAR=35;
    public static final int UNDERSCORE=50;
    public static final int CALLOPERATION=48;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "visibility", "label", "type", "name", "collaboration_use_type"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public CollaborationUseLabelParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public CollaborationUseLabelParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public CollaborationUseLabelParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return CollaborationUseLabelParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g"; }


      public CollaborationUseLabelParser(TokenStream lexer, CollaborationUse element, IErrorReporter reporter) {
        this(lexer);
        setCollaborationUse(element);
        setErrorReporter(reporter);    
      }
      
      /**
       * Validation state (true = validation : does not modify the CollaborationUse)
       */
      private boolean isValidation = false;
      
      
      private static final boolean DEBUG = false;
      /**
       * @return the isValidation boolean
       */
      public boolean isValidation() {
        return isValidation;
      }

      /**
       * @param isValidation the isValidation to set (true -> do not modify the CollaborationUse)
       */
      public void setValidation(boolean isValidation) {
        this.isValidation = isValidation;
      }
      
      private Package nearestPackage;
      
      /**
       * Modified CollaborationUse 
       */
      private CollaborationUse element;
      
      /**
       * @return the CollaborationUse
       */
      public CollaborationUse getCollaborationUse() {
        return element;
      }

      /**
       * @param element the CollaborationUse to set
       */
      public void setCollaborationUse(CollaborationUse element) {
        this.element = element;
        this.nearestPackage = element.getNearestPackage();
      }
          
         /** debug mode */
        protected final boolean debugMode = false;    
          
        /**
         * Debug method (~System.out.println)
         */
        private void debug(Object debug) {
          if(debugMode) {
            System.out.println(debug);  
          } 
        }
        
        /**
         * Error method (~System.err.println)
         */
        private void error(Object debug) {
          if(debugMode) {
            System.err.println(debug);  
          } 
        }
        
        /**
         * Context (for completion processor)
         */
        private int context = IContext.DEFAULT;
        
        /**
       * @return the context
       */
      public int getContext() {
        return context;
      }

      /**
       * @param context the context to set
       */
      public void setContext(int context) {
        this.context = context;
      }
        
        // all possible modified elements on CollaborationUse
        String name;
        VisibilityKind visibility = VisibilityKind.PUBLIC_LITERAL;
        Collaboration type=null;
        

      /**
       * Apply values to the CollaborationUse. <BR> 
       * Modifications can not be applied directly. The parser must wait the end, 
       * until it reaches the end of the label. If the end is reached without any error,
       * new values can be applied to the target CollaborationUse.
       */
      private void applyValues() {
        if(!isValidation){
          debug("\nvalues applied :");
          debug("+  name: "+name);
          debug("+  visibility: "+visibility);
          debug("+  type: "+type);
          
          element.setName(name);
          element.setVisibility(visibility);
          element.setType(type);
        } 
      }
      
            
      /** reporting errors */
        private IErrorReporter errorReporter = null;
        
        public void setErrorReporter(IErrorReporter errorReporter) {
            this.errorReporter = errorReporter;
        }
        
        public IErrorReporter getErrorReporter() {
            return errorReporter;
        }
        
       /**
        * {@inheritDoc}
        */
       @Override
       public String getErrorMessage(RecognitionException exception, String[] arg1) {
         if (exception instanceof NameException) {
           return "Please enter a correct name for the property";
         }
         return super.getErrorMessage(exception, arg1);
       }

       /**
        * {@inheritDoc}
        */
       @Override
       public void emitErrorMessage(String msg) {
         errorReporter.reportError(msg);
       }

      /**
       * {@inheritDoc}
       */
      @Override
      public void recover(IntStream arg0, RecognitionException arg1) {
        // do nothing
      }


    public static class label_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:201:1: label : ( visibility )? name COLON collaboration_use_type ;
    public final CollaborationUseLabelParser.label_return label() throws RecognitionException {
        CollaborationUseLabelParser.label_return retval = new CollaborationUseLabelParser.label_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON3=null;
        CollaborationUseLabelParser.visibility_return visibility1 = null;

        CollaborationUseLabelParser.name_return name2 = null;

        CollaborationUseLabelParser.collaboration_use_type_return collaboration_use_type4 = null;


        Object COLON3_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "label");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(201, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:201:7: ( ( visibility )? name COLON collaboration_use_type )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:202:3: ( visibility )? name COLON collaboration_use_type
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(202,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:202:3: ( visibility )?
            int alt1=2;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1);

            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=PLUS && LA1_0<=TILDE)) ) {
                alt1=1;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:202:4: visibility
                    {
                    dbg.location(202,4);
                    pushFollow(FOLLOW_visibility_in_label46);
                    visibility1=visibility();

                    state._fsp--;

                    adaptor.addChild(root_0, visibility1.getTree());
                    dbg.location(202,15);
                    context = IContext.VISIBILITY; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}

            dbg.location(203,3);
            pushFollow(FOLLOW_name_in_label55);
            name2=name();

            state._fsp--;

            adaptor.addChild(root_0, name2.getTree());
            dbg.location(204,3);
            COLON3=(Token)match(input,COLON,FOLLOW_COLON_in_label60); 
            COLON3_tree = (Object)adaptor.create(COLON3);
            adaptor.addChild(root_0, COLON3_tree);

            dbg.location(205,3);

                context = IContext.AFTER_COLON;
              
            dbg.location(208,3);
            pushFollow(FOLLOW_collaboration_use_type_in_label69);
            collaboration_use_type4=collaboration_use_type();

            state._fsp--;

            adaptor.addChild(root_0, collaboration_use_type4.getTree());
            dbg.location(208,27);
             context = IContext.COLLABORATION_USE_TYPE; 
            dbg.location(209,3);

                applyValues();
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                 reportError(mte);
                  String index = Integer.toString(mte.index);
                  String description = mte.getLocalizedMessage().substring(mte.getLocalizedMessage().indexOf('('),
                      mte.getLocalizedMessage().length());
                  String tokenText = mte.token.getText();
                  String text = Messages.bind(Messages.MismatchedToken, new String[] { index, description, tokenText });
                  throw new RuntimeException(text);
                
        }
        catch (NoViableAltException noViableAltException) {

               reportError(noViableAltException);
                  String index = Integer.toString(noViableAltException.index);
                 String description = noViableAltException.grammarDecisionDescription.substring(
                      noViableAltException.grammarDecisionDescription.indexOf('('),
                      noViableAltException.grammarDecisionDescription.length());
                  String tokenText = noViableAltException.token.getText();
                  String text = Messages.bind(Messages.NoViableAltException, new String[] { index, description, tokenText });
                  throw new RuntimeException(text);

                
        }
        catch (RecognitionException re) {


                  reportError(re);
                  throw (re);

                
        }
        finally {
        }
        dbg.location(212, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "label");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "label"

    public static class visibility_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "visibility"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:239:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final CollaborationUseLabelParser.visibility_return visibility() throws RecognitionException {
        CollaborationUseLabelParser.visibility_return retval = new CollaborationUseLabelParser.visibility_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS5=null;
        Token MINUS6=null;
        Token SHARP7=null;
        Token TILDE8=null;

        Object PLUS5_tree=null;
        Object MINUS6_tree=null;
        Object SHARP7_tree=null;
        Object TILDE8_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "visibility");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(239, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:240:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:241:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(241,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:241:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            int alt2=4;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2);

            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt2=1;
                }
                break;
            case MINUS:
                {
                alt2=2;
                }
                break;
            case SHARP:
                {
                alt2=3;
                }
                break;
            case TILDE:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:242:5: ( PLUS )
                    {
                    dbg.location(242,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:242:5: ( PLUS )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:242:9: PLUS
                    {
                    dbg.location(242,9);
                    PLUS5=(Token)match(input,PLUS,FOLLOW_PLUS_in_visibility127); 
                    PLUS5_tree = (Object)adaptor.create(PLUS5);
                    adaptor.addChild(root_0, PLUS5_tree);

                    dbg.location(242,15);
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:243:5: ( MINUS )
                    {
                    dbg.location(243,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:243:5: ( MINUS )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:243:9: MINUS
                    {
                    dbg.location(243,9);
                    MINUS6=(Token)match(input,MINUS,FOLLOW_MINUS_in_visibility142); 
                    MINUS6_tree = (Object)adaptor.create(MINUS6);
                    adaptor.addChild(root_0, MINUS6_tree);

                    dbg.location(243,15);
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:244:5: ( SHARP )
                    {
                    dbg.location(244,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:244:5: ( SHARP )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:244:9: SHARP
                    {
                    dbg.location(244,9);
                    SHARP7=(Token)match(input,SHARP,FOLLOW_SHARP_in_visibility156); 
                    SHARP7_tree = (Object)adaptor.create(SHARP7);
                    adaptor.addChild(root_0, SHARP7_tree);

                    dbg.location(244,15);
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:245:5: ( TILDE )
                    {
                    dbg.location(245,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:245:5: ( TILDE )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:245:9: TILDE
                    {
                    dbg.location(245,9);
                    TILDE8=(Token)match(input,TILDE,FOLLOW_TILDE_in_visibility170); 
                    TILDE8_tree = (Object)adaptor.create(TILDE8);
                    adaptor.addChild(root_0, TILDE8_tree);

                    dbg.location(245,15);
                     visibility = VisibilityKind.PACKAGE_LITERAL;

                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("VisibilityRule"));
               
        }
        finally {
        }
        dbg.location(247, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "visibility");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "visibility"

    public static class name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "name"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:254:1: name : id= IDENTIFIER ;
    public final CollaborationUseLabelParser.name_return name() throws RecognitionException {
        CollaborationUseLabelParser.name_return retval = new CollaborationUseLabelParser.name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "name");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(254, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:255:3: (id= IDENTIFIER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:256:3: id= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(256,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name204); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(257,3);
             
                name = id.getText();
                context = IContext.NAME;
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException(Messages.NameMissing));
               
        }
        catch (RecognitionException re) {

                  reportError(re); 
                  throw(re);
               
        }
        finally {
        }
        dbg.location(261, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "name");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "name"

    public static class collaboration_use_type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collaboration_use_type"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:272:1: collaboration_use_type : ( WS )* ( type | '<Undefined>' ) ;
    public final CollaborationUseLabelParser.collaboration_use_type_return collaboration_use_type() throws RecognitionException {
        CollaborationUseLabelParser.collaboration_use_type_return retval = new CollaborationUseLabelParser.collaboration_use_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS9=null;
        Token string_literal11=null;
        CollaborationUseLabelParser.type_return type10 = null;


        Object WS9_tree=null;
        Object string_literal11_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "collaboration_use_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(272, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:273:3: ( ( WS )* ( type | '<Undefined>' ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:274:3: ( WS )* ( type | '<Undefined>' )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(274,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:274:3: ( WS )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==WS) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:274:4: WS
            	    {
            	    dbg.location(274,4);
            	    WS9=(Token)match(input,WS,FOLLOW_WS_in_collaboration_use_type248); 
            	    WS9_tree = (Object)adaptor.create(WS9);
            	    adaptor.addChild(root_0, WS9_tree);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}

            dbg.location(275,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:275:3: ( type | '<Undefined>' )
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            else if ( (LA4_0==55) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:275:5: type
                    {
                    dbg.location(275,5);
                    pushFollow(FOLLOW_type_in_collaboration_use_type256);
                    type10=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type10.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:276:5: '<Undefined>'
                    {
                    dbg.location(276,5);
                    string_literal11=(Token)match(input,55,FOLLOW_55_in_collaboration_use_type264); 
                    string_literal11_tree = (Object)adaptor.create(string_literal11);
                    adaptor.addChild(root_0, string_literal11_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("CollaborationUseTypeRule"));
               
        }
        catch (NoViableAltException noViableAltException) {

                  reportError(noViableAltException);
                  throw new RuntimeException("Waiting for a valid type (Collaboration) or <Undefined>");
                
        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(278, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "collaboration_use_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "collaboration_use_type"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:293:1: type : id= IDENTIFIER ;
    public final CollaborationUseLabelParser.type_return type() throws RecognitionException {
        CollaborationUseLabelParser.type_return retval = new CollaborationUseLabelParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(293, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:294:3: (id= IDENTIFIER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:295:3: id= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(295,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type318); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(296,3);

                String typeName = id.getText() ;
                Collaboration utilType = PackageUtil.findCollaborationByName(nearestPackage, typeName);

                if (utilType != null) {
                    type = utilType;
                } else {
                  // the type actually does not exist
                  throw new TypeRecognitionException("Collaboration "+typeName+" not found for CollaborationUse "+element.getName(),typeName);
                } 
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("TypeRule"));
               
        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(307, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "type"

    // Delegated rules


 

    public static final BitSet FOLLOW_visibility_in_label46 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_name_in_label55 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_label60 = new BitSet(new long[]{0x0080000000000600L});
    public static final BitSet FOLLOW_collaboration_use_type_in_label69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_visibility127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_visibility142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_visibility156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_visibility170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_name204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_collaboration_use_type248 = new BitSet(new long[]{0x0080000000000600L});
    public static final BitSet FOLLOW_type_in_collaboration_use_type256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_collaboration_use_type264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type318 = new BitSet(new long[]{0x0000000000000002L});

}