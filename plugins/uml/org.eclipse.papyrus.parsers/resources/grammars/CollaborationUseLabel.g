grammar CollaborationUseLabel;

options {
	language = Java;
}

@header {
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
}

@lexer::header {
package org.eclipse.papyrus.parsers.antlr;

import org.eclipse.uml2.uml.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;

import org.eclipse.papyrus.parsers.texteditor.collaborationuselabel.IContext;
}

@members{
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
}

label :
  (visibility {context = IContext.VISIBILITY; })? 
  name 
  COLON
  {
    context = IContext.AFTER_COLON;
  } 
  collaboration_use_type  { context = IContext.COLLABORATION_USE_TYPE; }
  {
    applyValues();
  }
  ;
 catch [MismatchedTokenException mte] {
     reportError(mte);
      String index = Integer.toString(mte.index);
      String description = mte.getLocalizedMessage().substring(mte.getLocalizedMessage().indexOf('('),
          mte.getLocalizedMessage().length());
      String tokenText = mte.token.getText();
      String text = Messages.bind(Messages.MismatchedToken, new String[] { index, description, tokenText });
      throw new RuntimeException(text);
    } catch [NoViableAltException noViableAltException] {
   reportError(noViableAltException);
      String index = Integer.toString(noViableAltException.index);
     String description = noViableAltException.grammarDecisionDescription.substring(
          noViableAltException.grammarDecisionDescription.indexOf('('),
          noViableAltException.grammarDecisionDescription.length());
      String tokenText = noViableAltException.token.getText();
      String text = Messages.bind(Messages.NoViableAltException, new String[] { index, description, tokenText });
      throw new RuntimeException(text);

    } catch [RecognitionException re] {

      reportError(re);
      throw (re);

    } 
  
  
visibility
  :
  ( 
    (   PLUS  { visibility = VisibilityKind.PUBLIC_LITERAL; } )
  | (   MINUS { visibility = VisibilityKind.PRIVATE_LITERAL;} )
  | (   SHARP { visibility = VisibilityKind.PROTECTED_LITERAL;} )
  | (   TILDE { visibility = VisibilityKind.PACKAGE_LITERAL;} )
  )
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("VisibilityRule"));
   }


name
  :
  id=IDENTIFIER 
  { 
    name = id.getText();
    context = IContext.NAME;
  }
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException(Messages.NameMissing));
   }
    catch [RecognitionException re] {
      reportError(re); 
      throw(re);
   }
   

collaboration_use_type
  : 
  (WS)*
  ( type |
    '<Undefined>'
  )
  ;
   catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("CollaborationUseTypeRule"));
   }
   catch [NoViableAltException noViableAltException] {
      reportError(noViableAltException);
      throw new RuntimeException("Waiting for a valid type (Collaboration) or <Undefined>");
    } 
   catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
  
type
  :
  id=IDENTIFIER
  {
    String typeName = id.getText() ;
    Collaboration utilType = PackageUtil.findCollaborationByName(nearestPackage, typeName);

    if (utilType != null) {
        type = utilType;
    } else {
      // the type actually does not exist
      throw new TypeRecognitionException("Collaboration "+typeName+" not found for CollaborationUse "+element.getName(),typeName);
    } 
  }
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("TypeRule"));
   }
     catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  

NL 
  : ( '\r' '\n' 
    | '\n' '\r'  //Improbable
    | '\r'
    | '\n'
    )
  { $channel=HIDDEN;}
  ;


WS 
  :  (' ' | '\t' | '\f')+ {$channel=HIDDEN;}
  ;
  
QUESTION_MARK
  : '?'
  ;
  
LNOT
  : '!'
  ;
    
DOUBLE_QUOTE
  : '\"'
  ;

SINGLE_QUOTE  
  : '\''
  ;

LPAREN
  : '('
  ;

RPAREN
  : ')'
  ;

LSQUARE
  : '['
  ;

RSQUARE
  : ']'
  ;

LCURLY
  : '{'
  ;

DOUBLE_LCURLY
  : '{{' ;

RCURLY
  : '}'
  ;
  
DOUBLE_RCURLY
  : '}}'
  ;
  
LOGICAL_AND
  : '&'
  ;

DOUBLE_LOGICAL_AND
  : '&&'
  ;

PIPE
  : '|'
  ;

DOUBLE_PIPE
  : '||'
  ;

POINT
  : '.'
  ;

RANGE
  : '..'
  ;

COMMA
  : ','
  ;

SEMI
  : ';'
  ;

SHARP
  : '#'
  ;

TILDE
  : '~'
  ;

COLON
  : ':'
  ;

FOUR_POINTS
  : '::'
  ;

RULE_ASSIGN
  : '::=' ;

ARROW
  : '->'
  ;

STAR
  : '*'
  ;

DIV
  : '/'
  ;

PLUS
  : '+'
  ;

MINUS
  : '-'
  ;

EQ
  : '='
  ;


ISEQ
  : '=='
  ;

ISNE
  : '!='
  ;

LT : '<';

DOUBLE_LT
  : '<<'
  ;

LE
  : '<='
  ;

GT
  : '>'
  ;

DOUBLE_GT
  : '>>'
  ;

GE
  : '>='
  ;


INCR
  : '++'
  ;

DECR
  : '--'
  ;

CALLOPERATION
  : ':='
  ;

fragment
ALPHA
  : 'a'..'z' 
  | 'A'..'Z'
  ;


UNDERSCORE
  : '_'
  ;
  
RANGE_VALUE
  : c1=INTEGER {setText("");} '..'
  ( c2=INTEGER  { setText($c2.text);}
   |  c2=STAR { setText("-1");})
   { 
      setText($text + ","+ $c1.text); 
   }
  ;
 
REAL
  : INTEGER '.' INTEGER
  ; 
  
fragment
INTEGER_OR_REAL_OR_RANGE !
  :
   (INTEGER RANGE) => RANGE_VALUE
   | (INTEGER POINT) => REAL
   | (INTEGER) => INTEGER
   ;

INTEGER
  : '0'..'9'+;
    
IDENTIFIER
  : (ALPHA|'0'..'9'|UNDERSCORE)+
  ;
