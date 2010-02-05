// $ANTLR 3.0.1 D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g 2010-02-04 20:32:17

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

public class CollaborationUseLabelParser extends Parser {
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
    public static final int DOUBLE_QUOTE=14;
    public static final int GT=43;
    public static final int RSQUARE=19;
    public static final int DOUBLE_LOGICAL_AND=25;
    public static final int RANGE_VALUE=52;
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

        public CollaborationUseLabelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g"; }

    
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
      public void recoverFromMismatchedToken(IntStream arg0, RecognitionException arg1, int arg2, BitSet arg3)
          throws RecognitionException {
        // do nothing
      }
    
      /**
       * {@inheritDoc}
       */
      @Override
      public void recover(IntStream arg0, RecognitionException arg1) {
        // do nothing
      }
    
      /**
       * {@inheritDoc}
       */
      @Override
      public void recoverFromMismatchedSet(IntStream arg0, RecognitionException arg1, BitSet arg2)
          throws RecognitionException {
        // do nothing
      }



    // $ANTLR start label
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:219:1: label : ( visibility )? name COLON collaboration_use_type ;
    public final void label() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:219:7: ( ( visibility )? name COLON collaboration_use_type )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:220:3: ( visibility )? name COLON collaboration_use_type
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:220:3: ( visibility )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=PLUS && LA1_0<=TILDE)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:220:4: visibility
                    {
                    pushFollow(FOLLOW_visibility_in_label46);
                    visibility();
                    _fsp--;

                    context = IContext.VISIBILITY; 

                    }
                    break;

            }

            pushFollow(FOLLOW_name_in_label55);
            name();
            _fsp--;

            match(input,COLON,FOLLOW_COLON_in_label60); 
            
                context = IContext.AFTER_COLON;
              
            pushFollow(FOLLOW_collaboration_use_type_in_label69);
            collaboration_use_type();
            _fsp--;

             context = IContext.COLLABORATION_USE_TYPE; 
            
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:257:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final void visibility() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:258:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:259:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:259:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            int alt2=4;
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
                    new NoViableAltException("259:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:260:5: ( PLUS )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:260:5: ( PLUS )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:260:9: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_visibility127); 
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:261:5: ( MINUS )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:261:5: ( MINUS )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:261:9: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_visibility142); 
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:262:5: ( SHARP )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:262:5: ( SHARP )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:262:9: SHARP
                    {
                    match(input,SHARP,FOLLOW_SHARP_in_visibility156); 
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:263:5: ( TILDE )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:263:5: ( TILDE )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:263:9: TILDE
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_visibility170); 
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
        finally {
        }
        return ;
    }
    // $ANTLR end visibility


    // $ANTLR start name
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:272:1: name : id= IDENTIFIER ;
    public final void name() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:273:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:274:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name204); 
             
                name = id.getText();
                context = IContext.NAME;
              

            }

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
        return ;
    }
    // $ANTLR end name


    // $ANTLR start collaboration_use_type
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:290:1: collaboration_use_type : ( WS )* ( type | '<Undefined>' ) ;
    public final void collaboration_use_type() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:291:3: ( ( WS )* ( type | '<Undefined>' ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:292:3: ( WS )* ( type | '<Undefined>' )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:292:3: ( WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:292:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_collaboration_use_type248); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:293:3: ( type | '<Undefined>' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            else if ( (LA4_0==55) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("293:3: ( type | '<Undefined>' )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:293:5: type
                    {
                    pushFollow(FOLLOW_type_in_collaboration_use_type256);
                    type();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:294:5: '<Undefined>'
                    {
                    match(input,55,FOLLOW_55_in_collaboration_use_type264); 

                    }
                    break;

            }


            }

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
        return ;
    }
    // $ANTLR end collaboration_use_type


    // $ANTLR start type
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:311:1: type : id= IDENTIFIER ;
    public final void type() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:312:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:313:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type318); 
            
                String typeName = id.getText() ;
                Collaboration utilType = PackageUtil.findCollaborationByName(nearestPackage, typeName);
            
                if (utilType != null) {
                    type = utilType;
                } else {
                  // the type actually does not exist
                  throw new TypeRecognitionException("Collaboration "+typeName+" not found for CollaborationUse "+element.getName(),typeName);
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