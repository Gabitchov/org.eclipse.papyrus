// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g 2011-03-15 16:59:54

package org.eclipse.papyrus.parsers.antlr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.eclipse.papyrus.parsers.texteditor.parameterlabel.IContext;
import org.eclipse.papyrus.parsers.util.IErrorReporter;
import org.eclipse.papyrus.parsers.util.NameException;
import org.eclipse.papyrus.parsers.util.MultiplicityException;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;
import org.eclipse.papyrus.parsers.util.Messages;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.umlutils.ParameterUtil;
import org.eclipse.papyrus.umlutils.TemplateSignatureUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class ParameterLabelParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "IN", "OUT", "INOUT", "RETURN", "IDENTIFIER", "LSQUARE", "RANGE_VALUE", "INTEGER", "RSQUARE", "STAR", "EQ", "LCURLY", "COMMA", "RCURLY", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "DOUBLE_LCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "RANGE", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "DIV", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "ALPHA", "UNDERSCORE", "REAL", "INTEGER_OR_REAL_OR_RANGE", "'<Undefined>'", "'ordered'", "'unique'", "'nonunique'", "'exception'", "'stream'"
    };
    public static final int DOUBLE_LT=47;
    public static final int COMMA=22;
    public static final int ISEQ=44;
    public static final int MINUS=7;
    public static final int INCR=52;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=32;
    public static final int DECR=53;
    public static final int ARROW=42;
    public static final int DOUBLE_GT=50;
    public static final int OUT=11;
    public static final int RULE_ASSIGN=41;
    public static final int TILDE=9;
    public static final int PIPE=35;
    public static final int DOUBLE_PIPE=36;
    public static final int INTEGER=17;
    public static final int RCURLY=23;
    public static final int QUESTION_MARK=25;
    public static final int NL=24;
    public static final int LCURLY=21;
    public static final int T__62=62;
    public static final int LE=48;
    public static final int RPAREN=30;
    public static final int T__61=61;
    public static final int LPAREN=29;
    public static final int T__59=59;
    public static final int PLUS=6;
    public static final int SINGLE_QUOTE=28;
    public static final int REAL=57;
    public static final int RANGE=38;
    public static final int LSQUARE=15;
    public static final int FOUR_POINTS=40;
    public static final int DOUBLE_LCURLY=31;
    public static final int POINT=37;
    public static final int WS=4;
    public static final int ALPHA=55;
    public static final int EQ=20;
    public static final int T__64=64;
    public static final int LT=46;
    public static final int GT=49;
    public static final int DOUBLE_QUOTE=27;
    public static final int RSQUARE=18;
    public static final int DOUBLE_LOGICAL_AND=34;
    public static final int RANGE_VALUE=16;
    public static final int IN=10;
    public static final int SEMI=39;
    public static final int GE=51;
    public static final int LNOT=26;
    public static final int T__63=63;
    public static final int ISNE=45;
    public static final int RETURN=13;
    public static final int LOGICAL_AND=33;
    public static final int EOF=-1;
    public static final int INOUT=12;
    public static final int COLON=5;
    public static final int INTEGER_OR_REAL_OR_RANGE=58;
    public static final int DIV=43;
    public static final int IDENTIFIER=14;
    public static final int STAR=19;
    public static final int T__60=60;
    public static final int UNDERSCORE=56;
    public static final int CALLOPERATION=54;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "visibility", "parameterModifiers", "expression", 
        "fullMultiplicity", "upperMultiplicity", "lowerMultiplicity", "unlimitedNatural", 
        "parameterModifier", "type", "label", "direction", "defaultValue", 
        "name", "parameter_type"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public ParameterLabelParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public ParameterLabelParser(TokenStream input, int port, RecognizerSharedState state) {
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
    public ParameterLabelParser(TokenStream input, DebugEventListener dbg) {
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


    public String[] getTokenNames() { return ParameterLabelParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g"; }


      public ParameterLabelParser(TokenStream lexer, Parameter parameter, IErrorReporter reporter) {
        this(lexer);
        setParameter(parameter);
        setErrorReporter(reporter);
        this.modifiersUsed = new HashMap<String, Boolean>();
        modifiersUsed.put("ordered", false);  
        modifiersUsed.put("unique", false); 
        modifiersUsed.put("nonunique", false);
        modifiersUsed.put("stream", false);
        modifiersUsed.put("exception", false);
        
      }
      
      /**
       * Validation state (true = validation : does not modify the parameter
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
       * @param isValidation the isValidation to set (true -> do not modify the parameter)
       */
      public void setValidation(boolean isValidation) {
        this.isValidation = isValidation;
      }
      
      private Package nearestPackage;
      
      /**
       * Modified Parameter 
       */
      private Parameter parameter;
      
      /**
       * @return the parameter
       */
      public Parameter getParameter() {
        return parameter;
      }

      /**
       * @param parameter the parameter to set
       */
      public void setParameter(Parameter parameter) {
        this.parameter = parameter;
        this.nearestPackage = parameter.getNearestPackage();
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
        
        // all possible modified elements on parameter (with default values : necessary ?!)
        String name;
        VisibilityKind visibility = VisibilityKind.PUBLIC_LITERAL;
        ParameterDirectionKind direction = ParameterDirectionKind.IN_LITERAL;
        Type type=null;
        int lowerMultiplicity = 1;  // default multiplicity = [1..1]
        int upperMultiplicity = 1;  // default multiplicity = [1..1]
        String defaultValue=null;
        // parameter modifiers
        boolean isUnique = false; // default value = true but easier to use default = nonunique
        boolean isOrdered = false;  // default value = false
        boolean isException = false; // default value = false
        boolean isStream = false; // default value = false
        

      /**
       * Apply values to the parameter. <BR> 
       * Modifications can not be applied directly. The parser must wait the end, 
       * until it reaches the end of the label. If the end is reached without any error,
       * new values can be applied to the target parameter.
       */
      private void applyValues() {
        if(!isValidation){
          debug("\nvalues applied :");
          debug("+  name: "+name);
          debug("+  visibility: "+visibility);
          debug("+  direction: "+direction);
          debug("+  type: "+type);
          debug("+  lower Multiplicity: "+lowerMultiplicity);
          debug("+  upper Multiplicity: "+upperMultiplicity);
          debug("+  default Value: "+defaultValue);
          debug("+  Parameter modifiers");
          debug("+    isUnique: "+isUnique);
          debug("+    isOrdered: "+isOrdered);
          debug("+    isException: "+isException);
          debug("+    isStream: "+isStream);
          
          parameter.setName(name);
          parameter.setVisibility(visibility);
          parameter.setDirection(direction);
          parameter.setType(type);
          parameter.setLower(lowerMultiplicity);
          parameter.setUpper(upperMultiplicity);
          parameter.setDefault(defaultValue);
          parameter.setIsUnique(isUnique);
          parameter.setIsOrdered(isOrdered);
          parameter.setIsException(isException);
          parameter.setIsStream(isStream);
        } 
      }
      
      // vector that keeps modifiers already used (used for completion)
      public Map<String, Boolean> modifiersUsed; 
      
      /**
       * @return the modifiersUsed
       */
      public Map<String, Boolean> getModifiersUsed() {
        return modifiersUsed;
      }

      /**
       * @param modifiersUsed the modifiersUsed to set
       */
      public void setModifiersUsed(Map<String, Boolean> modifiersUsed) {
        this.modifiersUsed = modifiersUsed;
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
           return "Please enter a correct name for the parameter";
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
      throw new RuntimeException("no recover", arg1);
        // do nothing
      }
      


    public static class label_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:256:1: label : ( WS )* ( visibility ( WS )* )? ( direction ( WS )* )? name ( WS )* COLON parameter_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( parameterModifiers ( WS )* )? ;
    public final ParameterLabelParser.label_return label() throws RecognitionException {
        ParameterLabelParser.label_return retval = new ParameterLabelParser.label_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS1=null;
        Token WS3=null;
        Token WS5=null;
        Token WS7=null;
        Token COLON8=null;
        Token WS11=null;
        Token WS14=null;
        ParameterLabelParser.visibility_return visibility2 = null;

        ParameterLabelParser.direction_return direction4 = null;

        ParameterLabelParser.name_return name6 = null;

        ParameterLabelParser.parameter_type_return parameter_type9 = null;

        ParameterLabelParser.fullMultiplicity_return fullMultiplicity10 = null;

        ParameterLabelParser.defaultValue_return defaultValue12 = null;

        ParameterLabelParser.parameterModifiers_return parameterModifiers13 = null;


        Object WS1_tree=null;
        Object WS3_tree=null;
        Object WS5_tree=null;
        Object WS7_tree=null;
        Object COLON8_tree=null;
        Object WS11_tree=null;
        Object WS14_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "label");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(256, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:256:7: ( ( WS )* ( visibility ( WS )* )? ( direction ( WS )* )? name ( WS )* COLON parameter_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( parameterModifiers ( WS )* )? )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:257:3: ( WS )* ( visibility ( WS )* )? ( direction ( WS )* )? name ( WS )* COLON parameter_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( parameterModifiers ( WS )* )?
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(257,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:257:3: ( WS )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==WS) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:257:4: WS
            	    {
            	    dbg.location(257,4);
            	    WS1=(Token)match(input,WS,FOLLOW_WS_in_label46); 
            	    WS1_tree = (Object)adaptor.create(WS1);
            	    adaptor.addChild(root_0, WS1_tree);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(258,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:258:3: ( visibility ( WS )* )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3);

            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=PLUS && LA3_0<=TILDE)) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:258:4: visibility ( WS )*
                    {
                    dbg.location(258,4);
                    pushFollow(FOLLOW_visibility_in_label53);
                    visibility2=visibility();

                    state._fsp--;

                    adaptor.addChild(root_0, visibility2.getTree());
                    dbg.location(258,15);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:258:15: ( WS )*
                    try { dbg.enterSubRule(2);

                    loop2:
                    do {
                        int alt2=2;
                        try { dbg.enterDecision(2);

                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==WS) ) {
                            alt2=1;
                        }


                        } finally {dbg.exitDecision(2);}

                        switch (alt2) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:258:16: WS
                    	    {
                    	    dbg.location(258,16);
                    	    WS3=(Token)match(input,WS,FOLLOW_WS_in_label56); 
                    	    WS3_tree = (Object)adaptor.create(WS3);
                    	    adaptor.addChild(root_0, WS3_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(2);}

                    dbg.location(258,21);
                    context = IContext.VISIBILITY; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(259,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:259:3: ( direction ( WS )* )?
            int alt5=2;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5);

            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=IN && LA5_0<=RETURN)) ) {
                alt5=1;
            }
            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:259:4: direction ( WS )*
                    {
                    dbg.location(259,4);
                    pushFollow(FOLLOW_direction_in_label69);
                    direction4=direction();

                    state._fsp--;

                    adaptor.addChild(root_0, direction4.getTree());
                    dbg.location(259,14);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:259:14: ( WS )*
                    try { dbg.enterSubRule(4);

                    loop4:
                    do {
                        int alt4=2;
                        try { dbg.enterDecision(4);

                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==WS) ) {
                            alt4=1;
                        }


                        } finally {dbg.exitDecision(4);}

                        switch (alt4) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:259:15: WS
                    	    {
                    	    dbg.location(259,15);
                    	    WS5=(Token)match(input,WS,FOLLOW_WS_in_label72); 
                    	    WS5_tree = (Object)adaptor.create(WS5);
                    	    adaptor.addChild(root_0, WS5_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(4);}

                    dbg.location(259,20);
                    context = IContext.DIRECTION; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}

            dbg.location(260,3);
            pushFollow(FOLLOW_name_in_label84);
            name6=name();

            state._fsp--;

            adaptor.addChild(root_0, name6.getTree());
            dbg.location(260,8);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:260:8: ( WS )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==WS) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:260:9: WS
            	    {
            	    dbg.location(260,9);
            	    WS7=(Token)match(input,WS,FOLLOW_WS_in_label87); 
            	    WS7_tree = (Object)adaptor.create(WS7);
            	    adaptor.addChild(root_0, WS7_tree);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}

            dbg.location(261,3);
            COLON8=(Token)match(input,COLON,FOLLOW_COLON_in_label93); 
            COLON8_tree = (Object)adaptor.create(COLON8);
            adaptor.addChild(root_0, COLON8_tree);

            dbg.location(261,9);
            context = IContext.AFTER_COLON;
            dbg.location(262,3);
            pushFollow(FOLLOW_parameter_type_in_label100);
            parameter_type9=parameter_type();

            state._fsp--;

            adaptor.addChild(root_0, parameter_type9.getTree());
            dbg.location(262,19);
             context = IContext.MULTIPLICITY; 
            dbg.location(263,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:263:3: ( fullMultiplicity ( WS )* )?
            int alt8=2;
            try { dbg.enterSubRule(8);
            try { dbg.enterDecision(8);

            int LA8_0 = input.LA(1);

            if ( (LA8_0==LSQUARE) ) {
                alt8=1;
            }
            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:263:4: fullMultiplicity ( WS )*
                    {
                    dbg.location(263,4);
                    pushFollow(FOLLOW_fullMultiplicity_in_label108);
                    fullMultiplicity10=fullMultiplicity();

                    state._fsp--;

                    adaptor.addChild(root_0, fullMultiplicity10.getTree());
                    dbg.location(263,21);
                     context = IContext.AFTER_MULTIPLICITY; 
                    dbg.location(263,64);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:263:64: ( WS )*
                    try { dbg.enterSubRule(7);

                    loop7:
                    do {
                        int alt7=2;
                        try { dbg.enterDecision(7);

                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==WS) ) {
                            alt7=1;
                        }


                        } finally {dbg.exitDecision(7);}

                        switch (alt7) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:263:65: WS
                    	    {
                    	    dbg.location(263,65);
                    	    WS11=(Token)match(input,WS,FOLLOW_WS_in_label113); 
                    	    WS11_tree = (Object)adaptor.create(WS11);
                    	    adaptor.addChild(root_0, WS11_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(7);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(8);}

            dbg.location(264,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:264:3: ( defaultValue )?
            int alt9=2;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9);

            int LA9_0 = input.LA(1);

            if ( (LA9_0==EQ) ) {
                alt9=1;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:264:4: defaultValue
                    {
                    dbg.location(264,4);
                    pushFollow(FOLLOW_defaultValue_in_label122);
                    defaultValue12=defaultValue();

                    state._fsp--;

                    adaptor.addChild(root_0, defaultValue12.getTree());
                    dbg.location(264,17);
                     context = IContext.DEFAULT_VALUE; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}

            dbg.location(265,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:265:3: ( parameterModifiers ( WS )* )?
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==LCURLY) ) {
                alt11=1;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:265:4: parameterModifiers ( WS )*
                    {
                    dbg.location(265,4);
                    pushFollow(FOLLOW_parameterModifiers_in_label132);
                    parameterModifiers13=parameterModifiers();

                    state._fsp--;

                    adaptor.addChild(root_0, parameterModifiers13.getTree());
                    dbg.location(265,23);
                     context = IContext.PARAMETER_MODIFIERS; 
                    dbg.location(265,67);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:265:67: ( WS )*
                    try { dbg.enterSubRule(10);

                    loop10:
                    do {
                        int alt10=2;
                        try { dbg.enterDecision(10);

                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==WS) ) {
                            alt10=1;
                        }


                        } finally {dbg.exitDecision(10);}

                        switch (alt10) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:265:68: WS
                    	    {
                    	    dbg.location(265,68);
                    	    WS14=(Token)match(input,WS,FOLLOW_WS_in_label137); 
                    	    WS14_tree = (Object)adaptor.create(WS14);
                    	    adaptor.addChild(root_0, WS14_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(10);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}

            dbg.location(266,3);

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
        dbg.location(269, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:295:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final ParameterLabelParser.visibility_return visibility() throws RecognitionException {
        ParameterLabelParser.visibility_return retval = new ParameterLabelParser.visibility_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS15=null;
        Token MINUS16=null;
        Token SHARP17=null;
        Token TILDE18=null;

        Object PLUS15_tree=null;
        Object MINUS16_tree=null;
        Object SHARP17_tree=null;
        Object TILDE18_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "visibility");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(295, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:296:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:297:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(297,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:297:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            int alt12=4;
            try { dbg.enterSubRule(12);
            try { dbg.enterDecision(12);

            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt12=1;
                }
                break;
            case MINUS:
                {
                alt12=2;
                }
                break;
            case SHARP:
                {
                alt12=3;
                }
                break;
            case TILDE:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:298:5: ( PLUS )
                    {
                    dbg.location(298,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:298:5: ( PLUS )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:298:9: PLUS
                    {
                    dbg.location(298,9);
                    PLUS15=(Token)match(input,PLUS,FOLLOW_PLUS_in_visibility202); 
                    PLUS15_tree = (Object)adaptor.create(PLUS15);
                    adaptor.addChild(root_0, PLUS15_tree);

                    dbg.location(298,15);
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:299:5: ( MINUS )
                    {
                    dbg.location(299,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:299:5: ( MINUS )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:299:9: MINUS
                    {
                    dbg.location(299,9);
                    MINUS16=(Token)match(input,MINUS,FOLLOW_MINUS_in_visibility217); 
                    MINUS16_tree = (Object)adaptor.create(MINUS16);
                    adaptor.addChild(root_0, MINUS16_tree);

                    dbg.location(299,15);
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:300:5: ( SHARP )
                    {
                    dbg.location(300,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:300:5: ( SHARP )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:300:9: SHARP
                    {
                    dbg.location(300,9);
                    SHARP17=(Token)match(input,SHARP,FOLLOW_SHARP_in_visibility231); 
                    SHARP17_tree = (Object)adaptor.create(SHARP17);
                    adaptor.addChild(root_0, SHARP17_tree);

                    dbg.location(300,15);
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:301:5: ( TILDE )
                    {
                    dbg.location(301,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:301:5: ( TILDE )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:301:9: TILDE
                    {
                    dbg.location(301,9);
                    TILDE18=(Token)match(input,TILDE,FOLLOW_TILDE_in_visibility245); 
                    TILDE18_tree = (Object)adaptor.create(TILDE18);
                    adaptor.addChild(root_0, TILDE18_tree);

                    dbg.location(301,15);
                     visibility = VisibilityKind.PACKAGE_LITERAL;

                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("VisibilityRule"));
               
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
        finally {
        }
        dbg.location(303, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "visibility");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "visibility"

    public static class direction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "direction"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:321:1: direction : ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) ) ;
    public final ParameterLabelParser.direction_return direction() throws RecognitionException {
        ParameterLabelParser.direction_return retval = new ParameterLabelParser.direction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IN19=null;
        Token OUT20=null;
        Token INOUT21=null;
        Token RETURN22=null;

        Object IN19_tree=null;
        Object OUT20_tree=null;
        Object INOUT21_tree=null;
        Object RETURN22_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "direction");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(321, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:322:3: ( ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:323:3: ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(323,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:323:3: ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) )
            int alt13=4;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13);

            switch ( input.LA(1) ) {
            case IN:
                {
                alt13=1;
                }
                break;
            case OUT:
                {
                alt13=2;
                }
                break;
            case INOUT:
                {
                alt13=3;
                }
                break;
            case RETURN:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:324:5: ( IN )
                    {
                    dbg.location(324,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:324:5: ( IN )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:324:9: IN
                    {
                    dbg.location(324,9);
                    IN19=(Token)match(input,IN,FOLLOW_IN_in_direction297); 
                    IN19_tree = (Object)adaptor.create(IN19);
                    adaptor.addChild(root_0, IN19_tree);

                    dbg.location(324,16);
                     direction = ParameterDirectionKind.IN_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:325:5: ( OUT )
                    {
                    dbg.location(325,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:325:5: ( OUT )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:325:9: OUT
                    {
                    dbg.location(325,9);
                    OUT20=(Token)match(input,OUT,FOLLOW_OUT_in_direction315); 
                    OUT20_tree = (Object)adaptor.create(OUT20);
                    adaptor.addChild(root_0, OUT20_tree);

                    dbg.location(325,16);
                     direction = ParameterDirectionKind.OUT_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:326:5: ( INOUT )
                    {
                    dbg.location(326,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:326:5: ( INOUT )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:326:9: INOUT
                    {
                    dbg.location(326,9);
                    INOUT21=(Token)match(input,INOUT,FOLLOW_INOUT_in_direction332); 
                    INOUT21_tree = (Object)adaptor.create(INOUT21);
                    adaptor.addChild(root_0, INOUT21_tree);

                    dbg.location(326,16);
                     direction = ParameterDirectionKind.INOUT_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:327:5: ( RETURN )
                    {
                    dbg.location(327,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:327:5: ( RETURN )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:327:9: RETURN
                    {
                    dbg.location(327,9);
                    RETURN22=(Token)match(input,RETURN,FOLLOW_RETURN_in_direction347); 
                    RETURN22_tree = (Object)adaptor.create(RETURN22);
                    adaptor.addChild(root_0, RETURN22_tree);

                    dbg.location(327,16);
                     direction = ParameterDirectionKind.RETURN_LITERAL;

                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("Direction"));
               
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
        finally {
        }
        dbg.location(329, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "direction");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "direction"

    public static class name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "name"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:346:1: name : id= IDENTIFIER ;
    public final ParameterLabelParser.name_return name() throws RecognitionException {
        ParameterLabelParser.name_return retval = new ParameterLabelParser.name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "name");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(346, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:347:3: (id= IDENTIFIER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:348:3: id= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(348,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name389); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(349,3);
             
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
                  throw(re);
               
        }
        finally {
        }
        dbg.location(353, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "name");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "name"

    public static class parameter_type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter_type"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:373:1: parameter_type : ( WS )* ( type | '<Undefined>' ) ;
    public final ParameterLabelParser.parameter_type_return parameter_type() throws RecognitionException {
        ParameterLabelParser.parameter_type_return retval = new ParameterLabelParser.parameter_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS23=null;
        Token string_literal25=null;
        ParameterLabelParser.type_return type24 = null;


        Object WS23_tree=null;
        Object string_literal25_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "parameter_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(373, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:374:3: ( ( WS )* ( type | '<Undefined>' ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:375:3: ( WS )* ( type | '<Undefined>' )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(375,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:375:3: ( WS )*
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==WS) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:375:4: WS
            	    {
            	    dbg.location(375,4);
            	    WS23=(Token)match(input,WS,FOLLOW_WS_in_parameter_type438); 
            	    WS23_tree = (Object)adaptor.create(WS23);
            	    adaptor.addChild(root_0, WS23_tree);


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);
            } finally {dbg.exitSubRule(14);}

            dbg.location(376,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:376:3: ( type | '<Undefined>' )
            int alt15=2;
            try { dbg.enterSubRule(15);
            try { dbg.enterDecision(15);

            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==59) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(15);}

            switch (alt15) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:376:5: type
                    {
                    dbg.location(376,5);
                    pushFollow(FOLLOW_type_in_parameter_type446);
                    type24=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type24.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:377:5: '<Undefined>'
                    {
                    dbg.location(377,5);
                    string_literal25=(Token)match(input,59,FOLLOW_59_in_parameter_type454); 
                    string_literal25_tree = (Object)adaptor.create(string_literal25);
                    adaptor.addChild(root_0, string_literal25_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(15);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("ParameterTypeRule"));
               
        }
        catch (NoViableAltException noViableAltException) {

                  reportError(noViableAltException);
                  throw new RuntimeException("Waiting for a valid type or <Undefined>");
                
        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(379, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "parameter_type"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:394:1: type : id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* ;
    public final ParameterLabelParser.type_return type() throws RecognitionException {
        ParameterLabelParser.type_return retval = new ParameterLabelParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token id1=null;
        Token WS26=null;
        Token WS27=null;

        Object id_tree=null;
        Object id1_tree=null;
        Object WS26_tree=null;
        Object WS27_tree=null;


            StringBuffer buffer = new StringBuffer();
           
        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(394, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:398:3: (id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:399:3: id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )*
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(399,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type514); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(399,17);
            buffer.append(id.getText());
            dbg.location(400,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:400:3: ( WS )*
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==WS) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:400:4: WS
            	    {
            	    dbg.location(400,4);
            	    WS26=(Token)match(input,WS,FOLLOW_WS_in_type521); 
            	    WS26_tree = (Object)adaptor.create(WS26);
            	    adaptor.addChild(root_0, WS26_tree);

            	    dbg.location(400,7);
            	    //System.err.println("space added"); 
            	      		buffer.append(" ");

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);
            } finally {dbg.exitSubRule(16);}

            dbg.location(402,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:402:3: (id1= IDENTIFIER ( WS )* )*
            try { dbg.enterSubRule(18);

            loop18:
            do {
                int alt18=2;
                try { dbg.enterDecision(18);

                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDENTIFIER) ) {
                    alt18=1;
                }


                } finally {dbg.exitDecision(18);}

                switch (alt18) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:403:5: id1= IDENTIFIER ( WS )*
            	    {
            	    dbg.location(403,8);
            	    id1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type538); 
            	    id1_tree = (Object)adaptor.create(id1);
            	    adaptor.addChild(root_0, id1_tree);

            	    dbg.location(403,20);
            	    buffer.append(id1.getText());
            	    dbg.location(404,5);
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:404:5: ( WS )*
            	    try { dbg.enterSubRule(17);

            	    loop17:
            	    do {
            	        int alt17=2;
            	        try { dbg.enterDecision(17);

            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==WS) ) {
            	            alt17=1;
            	        }


            	        } finally {dbg.exitDecision(17);}

            	        switch (alt17) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:404:6: WS
            	    	    {
            	    	    dbg.location(404,6);
            	    	    WS27=(Token)match(input,WS,FOLLOW_WS_in_type547); 
            	    	    WS27_tree = (Object)adaptor.create(WS27);
            	    	    adaptor.addChild(root_0, WS27_tree);

            	    	    dbg.location(404,9);
            	    	    //System.err.println("space added"); 
            	    	        buffer.append(" ");

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(17);}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);
            } finally {dbg.exitSubRule(18);}

            dbg.location(407,3);

                String typeName = buffer.toString().trim() ;
                //System.err.println("typeName: "+typeName); 
                Type utilType = PackageUtil.findTypeByName(nearestPackage, typeName);
                // type = findTypeByName(typeName, parameter);
                // The type has not been found, but it may have been declared in the context of a template.
                if(utilType != null) {
                  if (utilType instanceof TemplateableElement) {
                    TemplateableElement template = (TemplateableElement)utilType;
                    if (template.isTemplate()) {
                      throw new UnboundTemplateRecognitionException("Parameters of template " + typeName + " are not bound.",
                          template) ;
                    } else {
                      type = utilType;
                    }
                  }
                  else {
                    type = utilType;
                  }
                } else {
                  // The type has not been found, but it may have been declared in the context of a template.
                  if (parameter.getOwner() instanceof TemplateableElement) {
                    TemplateableElement template = (TemplateableElement)parameter.getOwner() ;
                    if (template.isTemplate()) {
                      utilType = TemplateSignatureUtil.findTypeByName(template.getOwnedTemplateSignature(), typeName) ;
                    }
                  }
                  if (utilType == null) // the type actually does not exist
                    throw new TypeRecognitionException("Type "+typeName+" not found for parameter "+parameter.getName(),typeName);
                  else if (utilType instanceof TemplateableElement && ((TemplateableElement)utilType).isTemplate()) {
                    throw new UnboundTemplateRecognitionException("Parameters of template " + typeName + " are not bound.",
                        (TemplateableElement)utilType) ;
                  }
                  else {
                    type = utilType;
                  }
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
        dbg.location(445, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "type"

    public static class fullMultiplicity_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fullMultiplicity"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:456:1: fullMultiplicity : LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE ;
    public final ParameterLabelParser.fullMultiplicity_return fullMultiplicity() throws RecognitionException {
        ParameterLabelParser.fullMultiplicity_return retval = new ParameterLabelParser.fullMultiplicity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ra=null;
        Token up=null;
        Token LSQUARE28=null;
        Token RSQUARE29=null;

        Object ra_tree=null;
        Object up_tree=null;
        Object LSQUARE28_tree=null;
        Object RSQUARE29_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "fullMultiplicity");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(456, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:457:3: ( LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:458:3: LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(458,3);
            LSQUARE28=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_fullMultiplicity600); 
            LSQUARE28_tree = (Object)adaptor.create(LSQUARE28);
            adaptor.addChild(root_0, LSQUARE28_tree);

            dbg.location(459,3);
             context = IContext.IN_MULTIPLICITY; 
            dbg.location(475,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:475:3: (ra= RANGE_VALUE | up= INTEGER )
            int alt19=2;
            try { dbg.enterSubRule(19);
            try { dbg.enterDecision(19);

            int LA19_0 = input.LA(1);

            if ( (LA19_0==RANGE_VALUE) ) {
                alt19=1;
            }
            else if ( (LA19_0==INTEGER) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(19);}

            switch (alt19) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:476:5: ra= RANGE_VALUE
                    {
                    dbg.location(476,7);
                    ra=(Token)match(input,RANGE_VALUE,FOLLOW_RANGE_VALUE_in_fullMultiplicity620); 
                    ra_tree = (Object)adaptor.create(ra);
                    adaptor.addChild(root_0, ra_tree);

                    dbg.location(476,20);
                     
                            // retrieving values. text = upper ',' lower
                            String value = (ra!=null?ra.getText():null);
                            upperMultiplicity = Integer.parseInt(value.substring(0, value.lastIndexOf(',')));
                            lowerMultiplicity = Integer.parseInt(value.substring(value.lastIndexOf(',') + 1, value.length()));

                            if (lowerMultiplicity > upperMultiplicity && upperMultiplicity != -1) {
                              throw new MultiplicityException("Lower bound (" + lowerMultiplicity
                                  + ") is greater than upper bound (" + upperMultiplicity + ")");
                            }
                        
                      

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:488:5: up= INTEGER
                    {
                    dbg.location(488,7);
                    up=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_fullMultiplicity630); 
                    up_tree = (Object)adaptor.create(up);
                    adaptor.addChild(root_0, up_tree);

                    dbg.location(488,16);

                            upperMultiplicity = Integer.parseInt((up!=null?up.getText():null));
                            lowerMultiplicity = upperMultiplicity;
                      

                    }
                    break;

            }
            } finally {dbg.exitSubRule(19);}

            dbg.location(493,3);
            RSQUARE29=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_fullMultiplicity640); 
            RSQUARE29_tree = (Object)adaptor.create(RSQUARE29);
            adaptor.addChild(root_0, RSQUARE29_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("FullMultiplicityRule"));
               
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
                 throw(re);
               
        }
        finally {
        }
        dbg.location(494, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "fullMultiplicity");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "fullMultiplicity"

    public static class lowerMultiplicity_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lowerMultiplicity"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:516:1: lowerMultiplicity : in= INTEGER ;
    public final ParameterLabelParser.lowerMultiplicity_return lowerMultiplicity() throws RecognitionException {
        ParameterLabelParser.lowerMultiplicity_return retval = new ParameterLabelParser.lowerMultiplicity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token in=null;

        Object in_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "lowerMultiplicity");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(516, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:517:3: (in= INTEGER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:518:3: in= INTEGER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(518,5);
            in=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_lowerMultiplicity692); 
            in_tree = (Object)adaptor.create(in);
            adaptor.addChild(root_0, in_tree);

            dbg.location(519,3);

                lowerMultiplicity = Integer.parseInt(in.getText());
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(522, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "lowerMultiplicity");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "lowerMultiplicity"

    public static class upperMultiplicity_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "upperMultiplicity"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:524:1: upperMultiplicity : um= unlimitedNatural ;
    public final ParameterLabelParser.upperMultiplicity_return upperMultiplicity() throws RecognitionException {
        ParameterLabelParser.upperMultiplicity_return retval = new ParameterLabelParser.upperMultiplicity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ParameterLabelParser.unlimitedNatural_return um = null;



        try { dbg.enterRule(getGrammarFileName(), "upperMultiplicity");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(524, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:525:3: (um= unlimitedNatural )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:526:3: um= unlimitedNatural
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(526,5);
            pushFollow(FOLLOW_unlimitedNatural_in_upperMultiplicity713);
            um=unlimitedNatural();

            state._fsp--;

            adaptor.addChild(root_0, um.getTree());
            dbg.location(527,3);

                upperMultiplicity = um.value;
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(530, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "upperMultiplicity");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "upperMultiplicity"

    public static class unlimitedNatural_return extends ParserRuleReturnScope {
        public int value = 0;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unlimitedNatural"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:532:1: unlimitedNatural returns [int value = 0 ] : ( STAR | in= INTEGER ) ;
    public final ParameterLabelParser.unlimitedNatural_return unlimitedNatural() throws RecognitionException {
        ParameterLabelParser.unlimitedNatural_return retval = new ParameterLabelParser.unlimitedNatural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token in=null;
        Token STAR30=null;

        Object in_tree=null;
        Object STAR30_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "unlimitedNatural");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(532, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:533:3: ( ( STAR | in= INTEGER ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:534:3: ( STAR | in= INTEGER )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(534,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:534:3: ( STAR | in= INTEGER )
            int alt20=2;
            try { dbg.enterSubRule(20);
            try { dbg.enterDecision(20);

            int LA20_0 = input.LA(1);

            if ( (LA20_0==STAR) ) {
                alt20=1;
            }
            else if ( (LA20_0==INTEGER) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(20);}

            switch (alt20) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:534:5: STAR
                    {
                    dbg.location(534,5);
                    STAR30=(Token)match(input,STAR,FOLLOW_STAR_in_unlimitedNatural741); 
                    STAR30_tree = (Object)adaptor.create(STAR30);
                    adaptor.addChild(root_0, STAR30_tree);

                    dbg.location(534,15);
                     retval.value = -1; 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:535:5: in= INTEGER
                    {
                    dbg.location(535,7);
                    in=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_unlimitedNatural756); 
                    in_tree = (Object)adaptor.create(in);
                    adaptor.addChild(root_0, in_tree);

                    dbg.location(535,19);
                     retval.value = Integer.parseInt(in.getText()); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(20);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(537, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "unlimitedNatural");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "unlimitedNatural"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:539:1: defaultValue : EQ dv= expression ;
    public final ParameterLabelParser.defaultValue_return defaultValue() throws RecognitionException {
        ParameterLabelParser.defaultValue_return retval = new ParameterLabelParser.defaultValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQ31=null;
        ParameterLabelParser.expression_return dv = null;


        Object EQ31_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "defaultValue");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(539, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:540:3: ( EQ dv= expression )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:541:3: EQ dv= expression
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(541,3);
            EQ31=(Token)match(input,EQ,FOLLOW_EQ_in_defaultValue782); 
            EQ31_tree = (Object)adaptor.create(EQ31);
            adaptor.addChild(root_0, EQ31_tree);

            dbg.location(541,9);
            pushFollow(FOLLOW_expression_in_defaultValue788);
            dv=expression();

            state._fsp--;

            adaptor.addChild(root_0, dv.getTree());
            dbg.location(542,3);

                // remove spaces at the begining 
                defaultValue = dv.value.trim();
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("DefaultValueRule"));
               
        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(546, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "defaultValue");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "defaultValue"

    public static class expression_return extends ParserRuleReturnScope {
        public String value  = "";
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:557:1: expression returns [String value = \"\"] : ( options {greedy=false; } : id=~ ( LCURLY ) )+ ;
    public final ParameterLabelParser.expression_return expression() throws RecognitionException {
        ParameterLabelParser.expression_return retval = new ParameterLabelParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;


            StringBuffer buffer = new StringBuffer();
           
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(557, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:561:3: ( ( options {greedy=false; } : id=~ ( LCURLY ) )+ )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:562:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(562,4);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:562:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            int cnt21=0;
            try { dbg.enterSubRule(21);

            loop21:
            do {
                int alt21=2;
                try { dbg.enterDecision(21);

                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=WS && LA21_0<=EQ)||(LA21_0>=COMMA && LA21_0<=64)) ) {
                    alt21=1;
                }
                else if ( (LA21_0==EOF||LA21_0==LCURLY) ) {
                    alt21=2;
                }


                } finally {dbg.exitDecision(21);}

                switch (alt21) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:566:8: id=~ ( LCURLY )
            	    {
            	    dbg.location(566,10);
            	    id=(Token)input.LT(1);
            	    if ( (input.LA(1)>=WS && input.LA(1)<=EQ)||(input.LA(1)>=COMMA && input.LA(1)<=64) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(id));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(567,5);

            	          buffer.append(id.getText());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt21++;
            } while (true);
            } finally {dbg.exitSubRule(21);}

            dbg.location(571,3);

                retval.value = buffer.toString();
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(574, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expression"

    public static class parameterModifiers_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameterModifiers"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:581:1: parameterModifiers : LCURLY ( WS )* parameterModifier ( WS )* ( COMMA ( WS )* parameterModifier ( WS )* )* RCURLY ;
    public final ParameterLabelParser.parameterModifiers_return parameterModifiers() throws RecognitionException {
        ParameterLabelParser.parameterModifiers_return retval = new ParameterLabelParser.parameterModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LCURLY32=null;
        Token WS33=null;
        Token WS35=null;
        Token COMMA36=null;
        Token WS37=null;
        Token WS39=null;
        Token RCURLY40=null;
        ParameterLabelParser.parameterModifier_return parameterModifier34 = null;

        ParameterLabelParser.parameterModifier_return parameterModifier38 = null;


        Object LCURLY32_tree=null;
        Object WS33_tree=null;
        Object WS35_tree=null;
        Object COMMA36_tree=null;
        Object WS37_tree=null;
        Object WS39_tree=null;
        Object RCURLY40_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "parameterModifiers");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(581, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:582:3: ( LCURLY ( WS )* parameterModifier ( WS )* ( COMMA ( WS )* parameterModifier ( WS )* )* RCURLY )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:583:3: LCURLY ( WS )* parameterModifier ( WS )* ( COMMA ( WS )* parameterModifier ( WS )* )* RCURLY
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(583,3);
            LCURLY32=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_parameterModifiers931); 
            LCURLY32_tree = (Object)adaptor.create(LCURLY32);
            adaptor.addChild(root_0, LCURLY32_tree);

            dbg.location(583,10);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:583:10: ( WS )*
            try { dbg.enterSubRule(22);

            loop22:
            do {
                int alt22=2;
                try { dbg.enterDecision(22);

                int LA22_0 = input.LA(1);

                if ( (LA22_0==WS) ) {
                    alt22=1;
                }


                } finally {dbg.exitDecision(22);}

                switch (alt22) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:583:11: WS
            	    {
            	    dbg.location(583,11);
            	    WS33=(Token)match(input,WS,FOLLOW_WS_in_parameterModifiers934); 
            	    WS33_tree = (Object)adaptor.create(WS33);
            	    adaptor.addChild(root_0, WS33_tree);


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);
            } finally {dbg.exitSubRule(22);}

            dbg.location(584,3);
             context = IContext.PARAMETER_MODIFIER; 
            dbg.location(585,3);
            pushFollow(FOLLOW_parameterModifier_in_parameterModifiers944);
            parameterModifier34=parameterModifier();

            state._fsp--;

            adaptor.addChild(root_0, parameterModifier34.getTree());
            dbg.location(585,21);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:585:21: ( WS )*
            try { dbg.enterSubRule(23);

            loop23:
            do {
                int alt23=2;
                try { dbg.enterDecision(23);

                int LA23_0 = input.LA(1);

                if ( (LA23_0==WS) ) {
                    alt23=1;
                }


                } finally {dbg.exitDecision(23);}

                switch (alt23) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:585:22: WS
            	    {
            	    dbg.location(585,22);
            	    WS35=(Token)match(input,WS,FOLLOW_WS_in_parameterModifiers947); 
            	    WS35_tree = (Object)adaptor.create(WS35);
            	    adaptor.addChild(root_0, WS35_tree);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);
            } finally {dbg.exitSubRule(23);}

            dbg.location(586,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:586:3: ( COMMA ( WS )* parameterModifier ( WS )* )*
            try { dbg.enterSubRule(26);

            loop26:
            do {
                int alt26=2;
                try { dbg.enterDecision(26);

                int LA26_0 = input.LA(1);

                if ( (LA26_0==COMMA) ) {
                    alt26=1;
                }


                } finally {dbg.exitDecision(26);}

                switch (alt26) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:587:5: COMMA ( WS )* parameterModifier ( WS )*
            	    {
            	    dbg.location(587,5);
            	     context = IContext.PARAMETER_MODIFIER; 
            	    dbg.location(588,5);
            	    COMMA36=(Token)match(input,COMMA,FOLLOW_COMMA_in_parameterModifiers966); 
            	    COMMA36_tree = (Object)adaptor.create(COMMA36);
            	    adaptor.addChild(root_0, COMMA36_tree);

            	    dbg.location(588,11);
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:588:11: ( WS )*
            	    try { dbg.enterSubRule(24);

            	    loop24:
            	    do {
            	        int alt24=2;
            	        try { dbg.enterDecision(24);

            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==WS) ) {
            	            alt24=1;
            	        }


            	        } finally {dbg.exitDecision(24);}

            	        switch (alt24) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:588:12: WS
            	    	    {
            	    	    dbg.location(588,12);
            	    	    WS37=(Token)match(input,WS,FOLLOW_WS_in_parameterModifiers969); 
            	    	    WS37_tree = (Object)adaptor.create(WS37);
            	    	    adaptor.addChild(root_0, WS37_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(24);}

            	    dbg.location(588,17);
            	    pushFollow(FOLLOW_parameterModifier_in_parameterModifiers973);
            	    parameterModifier38=parameterModifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, parameterModifier38.getTree());
            	    dbg.location(588,35);
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:588:35: ( WS )*
            	    try { dbg.enterSubRule(25);

            	    loop25:
            	    do {
            	        int alt25=2;
            	        try { dbg.enterDecision(25);

            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==WS) ) {
            	            alt25=1;
            	        }


            	        } finally {dbg.exitDecision(25);}

            	        switch (alt25) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:588:36: WS
            	    	    {
            	    	    dbg.location(588,36);
            	    	    WS39=(Token)match(input,WS,FOLLOW_WS_in_parameterModifiers976); 
            	    	    WS39_tree = (Object)adaptor.create(WS39);
            	    	    adaptor.addChild(root_0, WS39_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop25;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(25);}


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);
            } finally {dbg.exitSubRule(26);}

            dbg.location(590,3);
            RCURLY40=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_parameterModifiers988); 
            RCURLY40_tree = (Object)adaptor.create(RCURLY40);
            adaptor.addChild(root_0, RCURLY40_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("DefaultValueRule"));
               
        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(591, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameterModifiers");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "parameterModifiers"

    public static class parameterModifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameterModifier"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:601:1: parameterModifier : ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' ) ;
    public final ParameterLabelParser.parameterModifier_return parameterModifier() throws RecognitionException {
        ParameterLabelParser.parameterModifier_return retval = new ParameterLabelParser.parameterModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal41=null;
        Token string_literal42=null;
        Token string_literal43=null;
        Token string_literal44=null;
        Token string_literal45=null;

        Object string_literal41_tree=null;
        Object string_literal42_tree=null;
        Object string_literal43_tree=null;
        Object string_literal44_tree=null;
        Object string_literal45_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "parameterModifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(601, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:602:3: ( ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:603:3: ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(603,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:603:3: ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' )
            int alt27=5;
            try { dbg.enterSubRule(27);
            try { dbg.enterDecision(27);

            switch ( input.LA(1) ) {
            case 60:
                {
                alt27=1;
                }
                break;
            case 61:
                {
                alt27=2;
                }
                break;
            case 62:
                {
                alt27=3;
                }
                break;
            case 63:
                {
                alt27=4;
                }
                break;
            case 64:
                {
                alt27=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(27);}

            switch (alt27) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:604:5: 'ordered'
                    {
                    dbg.location(604,5);
                    string_literal41=(Token)match(input,60,FOLLOW_60_in_parameterModifier1028); 
                    string_literal41_tree = (Object)adaptor.create(string_literal41);
                    adaptor.addChild(root_0, string_literal41_tree);

                    dbg.location(604,17);
                     isOrdered = true; modifiersUsed.put("ordered", true); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:605:5: 'unique'
                    {
                    dbg.location(605,5);
                    string_literal42=(Token)match(input,61,FOLLOW_61_in_parameterModifier1038); 
                    string_literal42_tree = (Object)adaptor.create(string_literal42);
                    adaptor.addChild(root_0, string_literal42_tree);

                    dbg.location(605,17);
                     isUnique  = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:606:5: 'nonunique'
                    {
                    dbg.location(606,5);
                    string_literal43=(Token)match(input,62,FOLLOW_62_in_parameterModifier1049); 
                    string_literal43_tree = (Object)adaptor.create(string_literal43);
                    adaptor.addChild(root_0, string_literal43_tree);

                    dbg.location(606,17);
                     isUnique  = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:607:5: 'exception'
                    {
                    dbg.location(607,5);
                    string_literal44=(Token)match(input,63,FOLLOW_63_in_parameterModifier1057); 
                    string_literal44_tree = (Object)adaptor.create(string_literal44);
                    adaptor.addChild(root_0, string_literal44_tree);

                    dbg.location(607,17);
                     isException = true; modifiersUsed.put("exception", true);

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\ParameterLabel.g:608:5: 'stream'
                    {
                    dbg.location(608,5);
                    string_literal45=(Token)match(input,64,FOLLOW_64_in_parameterModifier1065); 
                    string_literal45_tree = (Object)adaptor.create(string_literal45);
                    adaptor.addChild(root_0, string_literal45_tree);

                    dbg.location(608,17);
                     isStream  = true; modifiersUsed.put("stream", true);

                    }
                    break;

            }
            } finally {dbg.exitSubRule(27);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (MismatchedTokenException mte) {

                  reportError(mte);
                  throw (new RuntimeException("ParameterModifierRule"));
               
        }
        catch (RecognitionException re) {

               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        dbg.location(610, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameterModifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "parameterModifier"

    // Delegated rules


 

    public static final BitSet FOLLOW_WS_in_label46 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_visibility_in_label53 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_WS_in_label56 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_direction_in_label69 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_WS_in_label72 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_name_in_label84 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_WS_in_label87 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_COLON_in_label93 = new BitSet(new long[]{0x0800000000004010L});
    public static final BitSet FOLLOW_parameter_type_in_label100 = new BitSet(new long[]{0x0000000000308002L});
    public static final BitSet FOLLOW_fullMultiplicity_in_label108 = new BitSet(new long[]{0x0000000000300012L});
    public static final BitSet FOLLOW_WS_in_label113 = new BitSet(new long[]{0x0000000000300012L});
    public static final BitSet FOLLOW_defaultValue_in_label122 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parameterModifiers_in_label132 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_label137 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_PLUS_in_visibility202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_visibility217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_visibility231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_visibility245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_in_direction297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUT_in_direction315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INOUT_in_direction332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_direction347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_name389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_parameter_type438 = new BitSet(new long[]{0x0800000000004010L});
    public static final BitSet FOLLOW_type_in_parameter_type446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_parameter_type454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type514 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_WS_in_type521 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type538 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_WS_in_type547 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_LSQUARE_in_fullMultiplicity600 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_RANGE_VALUE_in_fullMultiplicity620 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INTEGER_in_fullMultiplicity630 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RSQUARE_in_fullMultiplicity640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_lowerMultiplicity692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unlimitedNatural_in_upperMultiplicity713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_unlimitedNatural741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_unlimitedNatural756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_defaultValue782 = new BitSet(new long[]{0xFFFFFFFFFFDFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_defaultValue788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression882 = new BitSet(new long[]{0xFFFFFFFFFFDFFFF2L,0x0000000000000001L});
    public static final BitSet FOLLOW_LCURLY_in_parameterModifiers931 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers934 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameterModifier_in_parameterModifiers944 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers947 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_COMMA_in_parameterModifiers966 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers969 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameterModifier_in_parameterModifiers973 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers976 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_RCURLY_in_parameterModifiers988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_parameterModifier1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_parameterModifier1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_parameterModifier1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_parameterModifier1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_parameterModifier1065 = new BitSet(new long[]{0x0000000000000002L});

}