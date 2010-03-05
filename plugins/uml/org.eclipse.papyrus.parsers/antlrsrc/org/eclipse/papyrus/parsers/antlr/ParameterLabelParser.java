// $ANTLR 3.0.1 D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g 2010-03-04 18:50:07

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

public class ParameterLabelParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "IN", "OUT", "INOUT", "RETURN", "IDENTIFIER", "LSQUARE", "RANGE_VALUE", "INTEGER", "RSQUARE", "STAR", "EQ", "LCURLY", "COMMA", "RCURLY", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "DOUBLE_LCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "RANGE", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "DIV", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "ALPHA", "UNDERSCORE", "REAL", "INTEGER_OR_REAL_OR_RANGE", "'<Undefined>'", "'ordered'", "'unique'", "'nonunique'", "'exception'", "'stream'"
    };
    public static final int LT=46;
    public static final int ISNE=45;
    public static final int STAR=19;
    public static final int LSQUARE=15;
    public static final int POINT=37;
    public static final int DOUBLE_QUOTE=27;
    public static final int FOUR_POINTS=40;
    public static final int DOUBLE_LCURLY=31;
    public static final int DOUBLE_LT=47;
    public static final int CALLOPERATION=54;
    public static final int EOF=-1;
    public static final int LOGICAL_AND=33;
    public static final int LPAREN=29;
    public static final int INOUT=12;
    public static final int RULE_ASSIGN=41;
    public static final int DOUBLE_PIPE=36;
    public static final int RANGE_VALUE=16;
    public static final int LNOT=26;
    public static final int SINGLE_QUOTE=28;
    public static final int RPAREN=30;
    public static final int IN=10;
    public static final int INCR=52;
    public static final int COMMA=22;
    public static final int IDENTIFIER=14;
    public static final int INTEGER_OR_REAL_OR_RANGE=58;
    public static final int RETURN=13;
    public static final int TILDE=9;
    public static final int QUESTION_MARK=25;
    public static final int DOUBLE_GT=50;
    public static final int PLUS=6;
    public static final int PIPE=35;
    public static final int NL=24;
    public static final int EQ=20;
    public static final int INTEGER=17;
    public static final int GE=51;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=32;
    public static final int RANGE=38;
    public static final int UNDERSCORE=56;
    public static final int LCURLY=21;
    public static final int RSQUARE=18;
    public static final int MINUS=7;
    public static final int SEMI=39;
    public static final int ALPHA=55;
    public static final int COLON=5;
    public static final int REAL=57;
    public static final int WS=4;
    public static final int DOUBLE_LOGICAL_AND=34;
    public static final int OUT=11;
    public static final int RCURLY=23;
    public static final int DECR=53;
    public static final int GT=49;
    public static final int ARROW=42;
    public static final int DIV=43;
    public static final int LE=48;
    public static final int ISEQ=44;

        public ParameterLabelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g"; }

    
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
      public void recoverFromMismatchedToken(IntStream arg0, RecognitionException arg1, int arg2, BitSet arg3)
          throws RecognitionException {
          throw arg1;
      }
    
      /**
       * {@inheritDoc}
       */
      @Override
      public void recover(IntStream arg0, RecognitionException arg1) {
      throw new RuntimeException("no recover", arg1);
        // do nothing
      }
    
      /**
       * {@inheritDoc}
       */
      @Override
      public void recoverFromMismatchedSet(IntStream arg0, RecognitionException arg1, BitSet arg2)
          throws RecognitionException {
           throw arg1;
        // do nothing
      }



    // $ANTLR start label
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:274:1: label : ( WS )* ( visibility ( WS )* )? ( direction ( WS )* )? name ( WS )* COLON parameter_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( parameterModifiers ( WS )* )? ;
    public final void label() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:274:7: ( ( WS )* ( visibility ( WS )* )? ( direction ( WS )* )? name ( WS )* COLON parameter_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( parameterModifiers ( WS )* )? )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:275:3: ( WS )* ( visibility ( WS )* )? ( direction ( WS )* )? name ( WS )* COLON parameter_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( parameterModifiers ( WS )* )?
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:275:3: ( WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:275:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_label46); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:276:3: ( visibility ( WS )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=PLUS && LA3_0<=TILDE)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:276:4: visibility ( WS )*
                    {
                    pushFollow(FOLLOW_visibility_in_label53);
                    visibility();
                    _fsp--;

                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:276:15: ( WS )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==WS) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:276:16: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label56); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    context = IContext.VISIBILITY; 

                    }
                    break;

            }

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:277:3: ( direction ( WS )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=IN && LA5_0<=RETURN)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:277:4: direction ( WS )*
                    {
                    pushFollow(FOLLOW_direction_in_label69);
                    direction();
                    _fsp--;

                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:277:14: ( WS )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==WS) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:277:15: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label72); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    context = IContext.DIRECTION; 

                    }
                    break;

            }

            pushFollow(FOLLOW_name_in_label84);
            name();
            _fsp--;

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:278:8: ( WS )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==WS) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:278:9: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_label87); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,COLON,FOLLOW_COLON_in_label93); 
            context = IContext.AFTER_COLON;
            pushFollow(FOLLOW_parameter_type_in_label100);
            parameter_type();
            _fsp--;

             context = IContext.MULTIPLICITY; 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:281:3: ( fullMultiplicity ( WS )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LSQUARE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:281:4: fullMultiplicity ( WS )*
                    {
                    pushFollow(FOLLOW_fullMultiplicity_in_label108);
                    fullMultiplicity();
                    _fsp--;

                     context = IContext.AFTER_MULTIPLICITY; 
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:281:64: ( WS )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==WS) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:281:65: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label113); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:282:3: ( defaultValue )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EQ) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:282:4: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_label122);
                    defaultValue();
                    _fsp--;

                     context = IContext.DEFAULT_VALUE; 

                    }
                    break;

            }

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:283:3: ( parameterModifiers ( WS )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LCURLY) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:283:4: parameterModifiers ( WS )*
                    {
                    pushFollow(FOLLOW_parameterModifiers_in_label132);
                    parameterModifiers();
                    _fsp--;

                     context = IContext.PARAMETER_MODIFIERS; 
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:283:67: ( WS )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==WS) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:283:68: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label137); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            
                applyValues();
              

            }

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
        return ;
    }
    // $ANTLR end label


    // $ANTLR start visibility
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:313:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final void visibility() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:314:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:315:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:315:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            int alt12=4;
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
                    new NoViableAltException("315:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:316:5: ( PLUS )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:316:5: ( PLUS )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:316:9: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_visibility202); 
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:317:5: ( MINUS )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:317:5: ( MINUS )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:317:9: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_visibility217); 
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:318:5: ( SHARP )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:318:5: ( SHARP )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:318:9: SHARP
                    {
                    match(input,SHARP,FOLLOW_SHARP_in_visibility231); 
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:319:5: ( TILDE )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:319:5: ( TILDE )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:319:9: TILDE
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_visibility245); 
                     visibility = VisibilityKind.PACKAGE_LITERAL;

                    }


                    }
                    break;

            }


            }

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
        return ;
    }
    // $ANTLR end visibility


    // $ANTLR start direction
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:339:1: direction : ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) ) ;
    public final void direction() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:340:3: ( ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:341:3: ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:341:3: ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) )
            int alt13=4;
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
                    new NoViableAltException("341:3: ( ( IN ) | ( OUT ) | ( INOUT ) | ( RETURN ) )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:342:5: ( IN )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:342:5: ( IN )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:342:9: IN
                    {
                    match(input,IN,FOLLOW_IN_in_direction297); 
                     direction = ParameterDirectionKind.IN_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:343:5: ( OUT )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:343:5: ( OUT )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:343:9: OUT
                    {
                    match(input,OUT,FOLLOW_OUT_in_direction315); 
                     direction = ParameterDirectionKind.OUT_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:344:5: ( INOUT )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:344:5: ( INOUT )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:344:9: INOUT
                    {
                    match(input,INOUT,FOLLOW_INOUT_in_direction332); 
                     direction = ParameterDirectionKind.INOUT_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:345:5: ( RETURN )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:345:5: ( RETURN )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:345:9: RETURN
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_direction347); 
                     direction = ParameterDirectionKind.RETURN_LITERAL;

                    }


                    }
                    break;

            }


            }

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
        return ;
    }
    // $ANTLR end direction


    // $ANTLR start name
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:364:1: name : id= IDENTIFIER ;
    public final void name() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:365:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:366:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name389); 
             
                name = id.getText();
                context = IContext.NAME;
              

            }

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
        return ;
    }
    // $ANTLR end name


    // $ANTLR start parameter_type
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:391:1: parameter_type : ( WS )* ( type | '<Undefined>' ) ;
    public final void parameter_type() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:392:3: ( ( WS )* ( type | '<Undefined>' ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:393:3: ( WS )* ( type | '<Undefined>' )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:393:3: ( WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:393:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_parameter_type438); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:394:3: ( type | '<Undefined>' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==59) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("394:3: ( type | '<Undefined>' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:394:5: type
                    {
                    pushFollow(FOLLOW_type_in_parameter_type446);
                    type();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:395:5: '<Undefined>'
                    {
                    match(input,59,FOLLOW_59_in_parameter_type454); 

                    }
                    break;

            }


            }

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
        return ;
    }
    // $ANTLR end parameter_type


    // $ANTLR start type
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:412:1: type : id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* ;
    public final void type() throws RecognitionException {
        Token id=null;
        Token id1=null;

        
            StringBuffer buffer = new StringBuffer();
           
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:416:3: (id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:417:3: id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )*
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type514); 
            buffer.append(id.getText());
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:418:3: ( WS )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==WS) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:418:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_type521); 
            	    System.err.println("space added"); buffer.append(" ");

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:419:3: (id1= IDENTIFIER ( WS )* )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDENTIFIER) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:420:5: id1= IDENTIFIER ( WS )*
            	    {
            	    id1=(Token)input.LT(1);
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type538); 
            	    buffer.append(id1.getText());
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:421:5: ( WS )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==WS) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:421:6: WS
            	    	    {
            	    	    match(input,WS,FOLLOW_WS_in_type547); 
            	    	    System.err.println("space added"); buffer.append(" ");

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            
                String typeName = buffer.toString().trim() ;
                System.err.println("typeName: "+typeName); 
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
        return ;
    }
    // $ANTLR end type


    // $ANTLR start fullMultiplicity
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:472:1: fullMultiplicity : LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE ;
    public final void fullMultiplicity() throws RecognitionException {
        Token ra=null;
        Token up=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:473:3: ( LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:474:3: LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE
            {
            match(input,LSQUARE,FOLLOW_LSQUARE_in_fullMultiplicity600); 
             context = IContext.IN_MULTIPLICITY; 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:491:3: (ra= RANGE_VALUE | up= INTEGER )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RANGE_VALUE) ) {
                alt19=1;
            }
            else if ( (LA19_0==INTEGER) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("491:3: (ra= RANGE_VALUE | up= INTEGER )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:492:5: ra= RANGE_VALUE
                    {
                    ra=(Token)input.LT(1);
                    match(input,RANGE_VALUE,FOLLOW_RANGE_VALUE_in_fullMultiplicity620); 
                     
                            // retrieving values. text = upper ',' lower
                            String value = ra.getText();
                            upperMultiplicity = Integer.parseInt(value.substring(0, value.lastIndexOf(',')));
                            lowerMultiplicity = Integer.parseInt(value.substring(value.lastIndexOf(',') + 1, value.length()));
                    
                            if (lowerMultiplicity > upperMultiplicity && upperMultiplicity != -1) {
                              throw new MultiplicityException("Lower bound (" + lowerMultiplicity
                                  + ") is greater than upper bound (" + upperMultiplicity + ")");
                            }
                        
                      

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:504:5: up= INTEGER
                    {
                    up=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_fullMultiplicity630); 
                    
                            upperMultiplicity = Integer.parseInt(up.getText());
                            lowerMultiplicity = upperMultiplicity;
                      

                    }
                    break;

            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_fullMultiplicity640); 

            }

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
        return ;
    }
    // $ANTLR end fullMultiplicity


    // $ANTLR start lowerMultiplicity
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:532:1: lowerMultiplicity : in= INTEGER ;
    public final void lowerMultiplicity() throws RecognitionException {
        Token in=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:533:3: (in= INTEGER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:534:3: in= INTEGER
            {
            in=(Token)input.LT(1);
            match(input,INTEGER,FOLLOW_INTEGER_in_lowerMultiplicity692); 
            
                lowerMultiplicity = Integer.parseInt(in.getText());
              

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
    // $ANTLR end lowerMultiplicity


    // $ANTLR start upperMultiplicity
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:540:1: upperMultiplicity : um= unlimitedNatural ;
    public final void upperMultiplicity() throws RecognitionException {
        int um = 0;


        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:541:3: (um= unlimitedNatural )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:542:3: um= unlimitedNatural
            {
            pushFollow(FOLLOW_unlimitedNatural_in_upperMultiplicity713);
            um=unlimitedNatural();
            _fsp--;

            
                upperMultiplicity = um;
              

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
    // $ANTLR end upperMultiplicity


    // $ANTLR start unlimitedNatural
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:548:1: unlimitedNatural returns [int value = 0 ] : ( STAR | in= INTEGER ) ;
    public final int unlimitedNatural() throws RecognitionException {
        int value =  0;

        Token in=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:549:3: ( ( STAR | in= INTEGER ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:550:3: ( STAR | in= INTEGER )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:550:3: ( STAR | in= INTEGER )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==STAR) ) {
                alt20=1;
            }
            else if ( (LA20_0==INTEGER) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("550:3: ( STAR | in= INTEGER )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:550:5: STAR
                    {
                    match(input,STAR,FOLLOW_STAR_in_unlimitedNatural741); 
                     value = -1; 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:551:5: in= INTEGER
                    {
                    in=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_unlimitedNatural756); 
                     value = Integer.parseInt(in.getText()); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end unlimitedNatural


    // $ANTLR start defaultValue
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:555:1: defaultValue : EQ dv= expression ;
    public final void defaultValue() throws RecognitionException {
        String dv = null;


        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:556:3: ( EQ dv= expression )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:557:3: EQ dv= expression
            {
            match(input,EQ,FOLLOW_EQ_in_defaultValue782); 
            pushFollow(FOLLOW_expression_in_defaultValue788);
            dv=expression();
            _fsp--;

            
                // remove spaces at the begining 
                defaultValue = dv.trim();
              

            }

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
        return ;
    }
    // $ANTLR end defaultValue


    // $ANTLR start expression
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:573:1: expression returns [String value = \"\"] : ( options {greedy=false; } : id=~ ( LCURLY ) )+ ;
    public final String expression() throws RecognitionException {
        String value =  "";

        Token id=null;

        
            StringBuffer buffer = new StringBuffer();
           
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:577:3: ( ( options {greedy=false; } : id=~ ( LCURLY ) )+ )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:578:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:578:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==EOF||LA21_0==LCURLY) ) {
                    alt21=2;
                }
                else if ( ((LA21_0>=WS && LA21_0<=EQ)||(LA21_0>=COMMA && LA21_0<=64)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:582:8: id=~ ( LCURLY )
            	    {
            	    id=(Token)input.LT(1);
            	    if ( (input.LA(1)>=WS && input.LA(1)<=EQ)||(input.LA(1)>=COMMA && input.LA(1)<=64) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_expression882);    throw mse;
            	    }

            	    
            	          buffer.append(id.getText());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            
                value = buffer.toString();
              

            }

        }
        catch (MismatchedTokenException mte) {
            
                  reportError(mte);
                  throw (new RuntimeException("ExpressionRule"));
               
        }
        catch (RecognitionException re) {
            
               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        return value;
    }
    // $ANTLR end expression


    // $ANTLR start parameterModifiers
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:601:1: parameterModifiers : LCURLY ( WS )* parameterModifier ( WS )* ( COMMA ( WS )* parameterModifier ( WS )* )* RCURLY ;
    public final void parameterModifiers() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:602:3: ( LCURLY ( WS )* parameterModifier ( WS )* ( COMMA ( WS )* parameterModifier ( WS )* )* RCURLY )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:603:3: LCURLY ( WS )* parameterModifier ( WS )* ( COMMA ( WS )* parameterModifier ( WS )* )* RCURLY
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_parameterModifiers939); 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:603:10: ( WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:603:11: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_parameterModifiers942); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             context = IContext.PARAMETER_MODIFIER; 
            pushFollow(FOLLOW_parameterModifier_in_parameterModifiers952);
            parameterModifier();
            _fsp--;

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:605:21: ( WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:605:22: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_parameterModifiers955); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:606:3: ( COMMA ( WS )* parameterModifier ( WS )* )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==COMMA) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:607:5: COMMA ( WS )* parameterModifier ( WS )*
            	    {
            	     context = IContext.PARAMETER_MODIFIER; 
            	    match(input,COMMA,FOLLOW_COMMA_in_parameterModifiers974); 
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:608:11: ( WS )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==WS) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:608:12: WS
            	    	    {
            	    	    match(input,WS,FOLLOW_WS_in_parameterModifiers977); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);

            	    pushFollow(FOLLOW_parameterModifier_in_parameterModifiers981);
            	    parameterModifier();
            	    _fsp--;

            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:608:35: ( WS )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==WS) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:608:36: WS
            	    	    {
            	    	    match(input,WS,FOLLOW_WS_in_parameterModifiers984); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop25;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_parameterModifiers996); 

            }

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
        return ;
    }
    // $ANTLR end parameterModifiers


    // $ANTLR start parameterModifier
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:621:1: parameterModifier : ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' ) ;
    public final void parameterModifier() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:622:3: ( ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:623:3: ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:623:3: ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' )
            int alt27=5;
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
                    new NoViableAltException("623:3: ( 'ordered' | 'unique' | 'nonunique' | 'exception' | 'stream' )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:624:5: 'ordered'
                    {
                    match(input,60,FOLLOW_60_in_parameterModifier1036); 
                     isOrdered = true; modifiersUsed.put("ordered", true); 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:625:5: 'unique'
                    {
                    match(input,61,FOLLOW_61_in_parameterModifier1046); 
                     isUnique  = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:626:5: 'nonunique'
                    {
                    match(input,62,FOLLOW_62_in_parameterModifier1057); 
                     isUnique  = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:627:5: 'exception'
                    {
                    match(input,63,FOLLOW_63_in_parameterModifier1065); 
                     isException = true; modifiersUsed.put("exception", true);

                    }
                    break;
                case 5 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:628:5: 'stream'
                    {
                    match(input,64,FOLLOW_64_in_parameterModifier1073); 
                     isStream  = true; modifiersUsed.put("stream", true);

                    }
                    break;

            }


            }

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
        return ;
    }
    // $ANTLR end parameterModifier


 

    public static final BitSet FOLLOW_WS_in_label46 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_visibility_in_label53 = new BitSet(new long[]{0x0000000000007C10L});
    public static final BitSet FOLLOW_WS_in_label56 = new BitSet(new long[]{0x0000000000007C10L});
    public static final BitSet FOLLOW_direction_in_label69 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_WS_in_label72 = new BitSet(new long[]{0x0000000000004010L});
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
    public static final BitSet FOLLOW_LCURLY_in_parameterModifiers939 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers942 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameterModifier_in_parameterModifiers952 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers955 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_COMMA_in_parameterModifiers974 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers977 = new BitSet(new long[]{0xF000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameterModifier_in_parameterModifiers981 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_WS_in_parameterModifiers984 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_RCURLY_in_parameterModifiers996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_parameterModifier1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_parameterModifier1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_parameterModifier1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_parameterModifier1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_parameterModifier1073 = new BitSet(new long[]{0x0000000000000002L});

}