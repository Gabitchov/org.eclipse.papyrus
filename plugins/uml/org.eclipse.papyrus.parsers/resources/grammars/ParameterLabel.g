grammar ParameterLabel;

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

import org.eclipse.papyrus.parsers.texteditor.parameterlabel.IContext;
}

@members{
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
}

label :
  (WS)*
  (visibility (WS)* {context = IContext.VISIBILITY; } )? 
  (direction (WS)* {context = IContext.DIRECTION; } )? 
  name (WS)*
  COLON {context = IContext.AFTER_COLON;} 
  parameter_type  { context = IContext.MULTIPLICITY; }
  (fullMultiplicity { context = IContext.AFTER_MULTIPLICITY; } (WS)*)?
  (defaultValue { context = IContext.DEFAULT_VALUE; })? 
  (parameterModifiers { context = IContext.PARAMETER_MODIFIERS; } (WS)*)?
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
    }  
    catch [NoViableAltException noViableAltException] {
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
   catch [NoViableAltException noViableAltException] {
     reportError(noViableAltException);
     String index = Integer.toString(noViableAltException.index);
     String description = noViableAltException.grammarDecisionDescription.substring(
          noViableAltException.grammarDecisionDescription.indexOf('('),
          noViableAltException.grammarDecisionDescription.length());
      String tokenText = noViableAltException.token.getText();
      String text = Messages.bind(Messages.NoViableAltException, new String[] { index, description, tokenText });
      throw new RuntimeException(text);

    }


direction
  :
  ( 
    (   IN     { direction = ParameterDirectionKind.IN_LITERAL; } )
  | (   OUT    { direction = ParameterDirectionKind.OUT_LITERAL;} )
  | (   INOUT  { direction = ParameterDirectionKind.INOUT_LITERAL;} )
  | (   RETURN { direction = ParameterDirectionKind.RETURN_LITERAL;} )
  )
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("Direction"));
   }
   catch [NoViableAltException noViableAltException] {
     reportError(noViableAltException);
     String index = Integer.toString(noViableAltException.index);
     String description = noViableAltException.grammarDecisionDescription.substring(
          noViableAltException.grammarDecisionDescription.indexOf('('),
          noViableAltException.grammarDecisionDescription.length());
      String tokenText = noViableAltException.token.getText();
      String text = Messages.bind(Messages.NoViableAltException, new String[] { index, description, tokenText });
      throw new RuntimeException(text);

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
   catch [NoViableAltException noViableAltException] {
     reportError(noViableAltException);
     String index = Integer.toString(noViableAltException.index);
     String description = noViableAltException.grammarDecisionDescription.substring(
          noViableAltException.grammarDecisionDescription.indexOf('('),
          noViableAltException.grammarDecisionDescription.length());
      String tokenText = noViableAltException.token.getText();
      String text = Messages.bind(Messages.NoViableAltException, new String[] { index, description, tokenText });
      throw new RuntimeException(text);
    }
    catch [RecognitionException re] {
      reportError(re); 
      throw(re);
   }

parameter_type
  : 
  (WS)*
  ( type |
    '<Undefined>'
  )
  ;
   catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("ParameterTypeRule"));
   }
   catch [NoViableAltException noViableAltException] {
      reportError(noViableAltException);
      throw new RuntimeException("Waiting for a valid type or <Undefined>");
    } 
   catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
  
type
  @init{
    StringBuffer buffer = new StringBuffer();
   }
  :
  id=IDENTIFIER {buffer.append(id.getText());}
  (WS {System.err.println("space added"); buffer.append(" ");})*
  ( 
    id1=IDENTIFIER {buffer.append(id1.getText());}
    (WS {System.err.println("space added"); buffer.append(" ");})*
   )*
  {
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
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("TypeRule"));
   }
     catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
  
fullMultiplicity
  :
  LSQUARE
  { context = IContext.IN_MULTIPLICITY; }
  /*(
    ( lowerMultiplicity POINT_POINT upperMultiplicity {
      if(lowerMultiplicity > upperMultiplicity && upperMultiplicity != -1) {
        throw new MultiplicityException("Lower bound ("+lowerMultiplicity+") is greater than upper bound ("+upperMultiplicity+")");
      }
    }
  )
  | upperMultiplicity {
      if(upperMultiplicity == -1) {
        lowerMultiplicity = 0;
      } else {
        lowerMultiplicity = upperMultiplicity;
      }
    }
  )*/
  (
    ra=RANGE_VALUE { 
        // retrieving values. text = upper ',' lower
        String value = $ra.text;
        upperMultiplicity = Integer.parseInt(value.substring(0, value.lastIndexOf(',')));
        lowerMultiplicity = Integer.parseInt(value.substring(value.lastIndexOf(',') + 1, value.length()));

        if (lowerMultiplicity > upperMultiplicity && upperMultiplicity != -1) {
          throw new MultiplicityException("Lower bound (" + lowerMultiplicity
              + ") is greater than upper bound (" + upperMultiplicity + ")");
        }
    
  }
  | up=INTEGER {
        upperMultiplicity = Integer.parseInt($up.text);
        lowerMultiplicity = upperMultiplicity;
  }
  )
  RSQUARE
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("FullMultiplicityRule"));
   }
   catch [NoViableAltException noViableAltException] {
     reportError(noViableAltException);
     String index = Integer.toString(noViableAltException.index);
     String description = noViableAltException.grammarDecisionDescription.substring(
          noViableAltException.grammarDecisionDescription.indexOf('('),
          noViableAltException.grammarDecisionDescription.length());
      String tokenText = noViableAltException.token.getText();
      String text = Messages.bind(Messages.NoViableAltException, new String[] { index, description, tokenText });
      throw new RuntimeException(text);
    }
   catch [RecognitionException re] {
     reportError(re); 
     throw(re);
   }
   
  
  
lowerMultiplicity
  :
  in=INTEGER
  {
    lowerMultiplicity = Integer.parseInt(in.getText());
  }
  ;

upperMultiplicity
  :
  um=unlimitedNatural 
  {
    upperMultiplicity = um;
  }
  ;
  
unlimitedNatural returns [int value = 0 ]
  :
  ( STAR      { value = -1; }
  | in=INTEGER    { value = Integer.parseInt(in.getText()); }
  )
  ;
  
defaultValue
  :
  EQ dv = expression
  {
    // remove spaces at the begining 
    defaultValue = dv.trim();
  }
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("DefaultValueRule"));
   }
     catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
  
expression returns [String value  = ""]
  @init{
    StringBuffer buffer = new StringBuffer();
   }
  : 
   (
        options { greedy=false;  }
    :
   
       id=~(LCURLY)
    {
      buffer.append(id.getText());
    }
  )+
  {
    value = buffer.toString();
  }
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("ExpressionRule"));
   }
     catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
  
parameterModifiers
  :
  LCURLY (WS)*
  { context = IContext.PARAMETER_MODIFIER; }
  parameterModifier (WS)*
  ( 
    { context = IContext.PARAMETER_MODIFIER; }
    COMMA (WS)* parameterModifier (WS)* 
  )*
  RCURLY
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("DefaultValueRule"));
   }
  catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
parameterModifier 
  :
  (
    'ordered'   { isOrdered = true; modifiersUsed.put("ordered", true); }
  | 'unique'    { isUnique  = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);}
  | 'nonunique' { isUnique  = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);}
  | 'exception' { isException = true; modifiersUsed.put("exception", true);}
  | 'stream'    { isStream  = true; modifiersUsed.put("stream", true);}                                                                                                  
  )
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("ParameterModifierRule"));
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
  :  (' ' | '\t' | '\f')+ // {$channel=HIDDEN;}
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

IN
  : 'in'
  ;
  
OUT
  : 'out'
  ;

INOUT
  : 'inout'
  ;
  
RETURN
  : 'return'
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
  
