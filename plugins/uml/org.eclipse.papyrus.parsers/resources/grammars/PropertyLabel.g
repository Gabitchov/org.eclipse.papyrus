grammar PropertyLabel;

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

import org.eclipse.papyrus.parsers.texteditor.propertylabel.IContext;
import org.eclipse.papyrus.parsers.util.IErrorReporter;
import org.eclipse.papyrus.parsers.util.NameException;
import org.eclipse.papyrus.parsers.util.MultiplicityException;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;
import org.eclipse.papyrus.parsers.util.Messages;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.papyrus.umlutils.TemplateSignatureUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
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

import org.eclipse.papyrus.parsers.texteditor.propertylabel.IContext;
}

@members{
  public PropertyLabelParser(TokenStream lexer, Property property, IErrorReporter reporter) {
    this(lexer);
    setProperty(property);
    setErrorReporter(reporter);
    this.modifiersUsed = new HashMap<String, Boolean>();
    modifiersUsed.put("readOnly", false);
    modifiersUsed.put("union", false);  
    modifiersUsed.put("ordered", false);  
    modifiersUsed.put("unique", false); 
    modifiersUsed.put("nonunique", false);
    modifiersUsed.put("subsets ", false);
    modifiersUsed.put("redefines ", false);
    
  }
  
  /**
   * Validation state (true = validation : does not modify the property
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
   * @param isValidation the isValidation to set (true -> do not modify the property)
   */
  public void setValidation(boolean isValidation) {
    this.isValidation = isValidation;
  }
  
  private Package nearestPackage;
  
  /**
   * Modified Property 
   */
  private Property property;
  
  /**
   * @return the property
   */
  public Property getProperty() {
    return property;
  }

  /**
   * @param property the property to set
   */
  public void setProperty(Property property) {
    this.property = property;
    this.nearestPackage = property.getNearestPackage();
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
    
    // all possible modified elements on property (with default values : necessary ?!)
    String name;
    VisibilityKind visibility = VisibilityKind.PUBLIC_LITERAL;
    boolean isDerived = false;
    Type type=null;
    int lowerMultiplicity = 1;  // default multiplicity = [1..1]
    int upperMultiplicity = 1;  // default multiplicity = [1..1]
    String defaultValue=null;
    // property modifiers
    boolean isReadOnly = false; // default value = false
    boolean isUnique = false; // default value = true but easier to use default = nonunique
    boolean isOrdered = false;  // default value = false
    boolean isDerivedUnion = false; // default value = false
    Collection subsettedProperties = new Vector();
    Collection redefinedProperties = new Vector();
    

  /**
   * Apply values to the property. <BR> 
   * Modifications can not be applied directly. The parser must wait the end, 
   * until it reaches the end of the label. If the end is reached without any error,
   * new values can be applied to the target property.
   */
  private void applyValues() {
    if(!isValidation){
      debug("\nvalues applied :");
      debug("+  name: "+name);
      debug("+  visibility: "+visibility);
      debug("+  isDerived: "+isDerived);
      debug("+  type: "+type);
      debug("+  lower Multiplicity: "+lowerMultiplicity);
      debug("+  upper Multiplicity: "+upperMultiplicity);
      debug("+  default Value: "+defaultValue);
      debug("+  Property modifiers");
      debug("+    isReadOnly: "+isReadOnly);
      debug("+    isUnique: "+isUnique);
      debug("+    isOrdered: "+isOrdered);
      debug("+    isDerivedUnion: "+isDerivedUnion);
      debug("+  SubsettedProperties: "+subsettedProperties);
      debug("+  RedefinedProperties: "+redefinedProperties);
      
      property.setName(name);
      property.setVisibility(visibility);
      property.setIsDerived(isDerived);
      property.setType(type);
      property.setLower(lowerMultiplicity);
      property.setUpper(upperMultiplicity);
      property.setDefault(defaultValue);
      property.setIsReadOnly(isReadOnly);
      property.setIsUnique(isUnique);
      property.setIsOrdered(isOrdered);
      property.setIsDerivedUnion(isDerivedUnion);
      property.getSubsettedProperties().clear();
      property.getSubsettedProperties().addAll(subsettedProperties);
      property.getRedefinedProperties().clear();
      property.getRedefinedProperties().addAll(redefinedProperties);
    } 
  }
  
  /**
   * Find a type given its name and a context to find it.
   * @param name the name of the type
   * @return the type found or <code>null</code> if the element was not found.
   */
   /*
  private Type findTypeByName(String name, org.eclipse.uml2.uml.Element context) throws RecognitionException {
    Type type = null;
    int numTypes = 0;
    org.eclipse.uml2.uml.Package contextPackage = context.getNearestPackage();
    
    // seek the package in which the element should be found...
    Iterator it = contextPackage.getMembers().iterator();
    while( it.hasNext() ) {
      Object tmp = it.next();
      if( tmp instanceof Type ) {
        Type element = ( Type )tmp;
        if(  element.getName().equals(name)  ) {
          numTypes++;
          type = element;
        }
      }
    }
    if(type == null) {// type not found in default package. search in imports.
      it = contextPackage.getImportedMembers().iterator();
      while( it.hasNext() ) {
        Object tmp = it.next();
        if( tmp instanceof Type ) {
          Type element = ( Type )tmp;
          if(  element.getName().equals(name)  ) {
            type = element;
            numTypes++;
          }
        }
      }
    }
    
    if(numTypes == 0) {
      throw new RecognitionException("Type "+name+" not found for property "+property.getName());
    } else if(numTypes > 1) {
      debug("There are "+numTypes+" types with the same name....");
    }
    
    return type;
  }
  */
  
  /**
   * Find a subsetted property given its name and a context to find it.
   * @param name the name of the property
   * @return the property found or <code>null</code> if the element was not found.
   */
  private Property findSubsettedPropertyByName(String propertyName, Property property) throws TypeRecognitionException {
    Property subsettedProperty = null;
    Iterator<Property> it = PropertyUtil.getSubsettablesProperties(property, true).iterator();
    while (it.hasNext()) {
      Property tmpProperty = it.next();
      if(propertyName.equals(tmpProperty.getName())) {
        subsettedProperty = tmpProperty;
      }
    }
    
    if(subsettedProperty == null) {
      throw new TypeRecognitionException("Property "+propertyName+" has not been found or can not be subset", property.getName());
    } else {
      // a property has been found. check multiplicity  
      checkProperty(property, subsettedProperty);
    }
    return subsettedProperty; 
  }
  
  private void checkProperty(Property property, Property subsettedProperty) throws RuntimeException {
    int propertyLowerBound = lowerMultiplicity; // check the new one!!
    int subsettedPropertyLowerBound = subsettedProperty.getLower();
    int propertyUpperBound = upperMultiplicity; // check the new one!!
    int subsettedPropertyUpperBound = subsettedProperty.getUpper();
    
    Type propertyType = property.getType();
    Type subsettedPropertyType = subsettedProperty.getType(); 
    
    String propertyName = property.getName();
    
    /*
     * rule : property multiplicity is a subset of subsetted property multiplicity
     * 1. property Lower Bound must be greater (or equal) than subsetted property Lower Bound
     * 2. property Upper Bound must be lower (or equal) than subsetted property Upper Bound (if subsetted property Upper Bound is not '*')
     */
    if( propertyLowerBound < subsettedPropertyLowerBound) {
      throw new MultiplicityException(propertyName+" Lower Bound ("+lowerMultiplicity+") can not be lower than subsetted property Lower Bound ("+subsettedPropertyLowerBound+")");
    } else if(subsettedPropertyUpperBound != -1 && propertyUpperBound > subsettedPropertyUpperBound) {
      throw new MultiplicityException(propertyName+" Upper Bound ("+upperMultiplicity+") can not be greater than subsetted property Upper Bound ("+subsettedPropertyUpperBound+")");
    } 
    if(!propertyType.conformsTo(subsettedPropertyType)) {
      throw new TypeRecognitionException(propertyName+" Type ("+propertyType.getName()+") does not conform to subsetted property type", subsettedPropertyType.getName());
    }
  }
  
  /**
   * Find a redefined property given its name and a context to find it.
   * @param name the name of the property
   * @return the property found or <code>null</code> if the element was not found.
   */
  private Property findRedefinedPropertyByName(String propertyName, Property property) throws TypeRecognitionException {
    Property redefinedProperty = PropertyUtil.findRedefinedPropertyByName(propertyName, property);
    if(redefinedProperty == null) {
      throw new TypeRecognitionException("Property "+propertyName+" has not been found or can not be redefined", property.getName());
    } 
    return redefinedProperty;
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
  (isDerived { context = IContext.IS_DERIVED; })? 
  name 
  COLON
  {
    context = IContext.AFTER_COLON;
  } 
  property_type  { context = IContext.MULTIPLICITY; }
  (fullMultiplicity { context = IContext.AFTER_MULTIPLICITY; })?
  (defaultValue { context = IContext.DEFAULT_VALUE; })? 
  (propertyModifiers { context = IContext.PROPERTY_MODIFIERS; })?
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


isDerived
  :
  DIV   { isDerived = true; }
  ; 
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("IsDerivedRule"));
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
   

property_type
  : 
  (WS)*
  ( type |
    '<Undefined>'
  )
  ;
   catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("PropertyTypeRule"));
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
  :
  id=IDENTIFIER
  {
    String typeName = id.getText() ;
    Type utilType = PackageUtil.findTypeByName(nearestPackage, typeName);
    // type = findTypeByName(typeName, property);
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
      if (property.getOwner() instanceof TemplateableElement) {
        TemplateableElement template = (TemplateableElement)property.getOwner() ;
        if (template.isTemplate()) {
          utilType = TemplateSignatureUtil.findTypeByName(template.getOwnedTemplateSignature(), typeName) ;
        }
      }
      if (utilType == null) // the type actually does not exist
        throw new TypeRecognitionException("Type "+typeName+" not found for property "+property.getName(),typeName);
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
  
  
propertyModifiers
  :
  LCURLY 
  { context = IContext.PROPERTY_MODIFIER; }
  propertyModifier
  ( 
    { context = IContext.PROPERTY_MODIFIER; }
    COMMA propertyModifier 
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
  
propertyModifier 
  :
  (
    'readOnly'  { isReadOnly = true; modifiersUsed.put("readOnly", true);}
  | 'union'   { isDerivedUnion = true; modifiersUsed.put("union", true);  }
  | 'ordered' { isOrdered = true; modifiersUsed.put("ordered", true); }
  | 'unique'  { isUnique = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);}
  | 'nonunique' { isUnique = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);}
  | 'subsets' { context = IContext.SUBSET_PROPERTY ; } subsetsProperty  
  | redefinesProperty                                                                                                           
  )
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("PropertyModifierRule"));
   }
     catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
  
subsetsProperty
  :
  id=IDENTIFIER
  {
    // find property by name
    String propertyName = id.getText();
    Property tmpProperty = findSubsettedPropertyByName(propertyName, property); 
    subsettedProperties.add(tmpProperty); 
  }
  ;
  catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("subsetsPropertyRule"));
   }
  catch [RecognitionException re] {
   reportError(re); 
   throw(re);
   }
  
redefinesProperty
  :
  { context = IContext.REDEFINE_PROPERTY ; } 'redefines' { context = IContext.REDEFINE_PROPERTY ; } id=IDENTIFIER
  {
    // find property by name
    String propertyName = id.getText();
    Property tmpProperty = findRedefinedPropertyByName(propertyName, property); 
    redefinedProperties.add(tmpProperty); 
  }
  ;
   catch [MismatchedTokenException mte] {
      reportError(mte);
      throw (new RuntimeException("redefinesPropertyRule"));
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
