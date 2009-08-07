// $ANTLR 3.0.1 D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g 2009-08-07 11:33:37

package org.eclipse.papyrus.parsers.antlr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.eclipse.papyrus.parsers.texteditor.propertylabel.IContext;
import org.eclipse.papyrus.parsers.util.IErrorReporter;
import org.eclipse.papyrus.parsers.util.MultiplicityException;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.papyrus.umlutils.TemplateSignatureUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PropertyLabelParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "DIV", "IDENTIFIER", "WS", "LSQUARE", "RANGE_VALUE", "INTEGER", "RSQUARE", "STAR", "EQ", "LCURLY", "COMMA", "RCURLY", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "DOUBLE_LCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "RANGE", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "ALPHA", "UNDERSCORE", "REAL", "INTEGER_OR_REAL_OR_RANGE", "'<Undefined>'", "'readOnly'", "'union'", "'ordered'", "'unique'", "'nonunique'", "'subsets'", "'redefines'"
    };
    public static final int LT=42;
    public static final int STAR=16;
    public static final int ISNE=41;
    public static final int LSQUARE=12;
    public static final int POINT=34;
    public static final int DOUBLE_QUOTE=24;
    public static final int FOUR_POINTS=37;
    public static final int DOUBLE_LCURLY=28;
    public static final int DOUBLE_LT=43;
    public static final int CALLOPERATION=50;
    public static final int EOF=-1;
    public static final int LOGICAL_AND=30;
    public static final int LPAREN=26;
    public static final int RULE_ASSIGN=38;
    public static final int DOUBLE_PIPE=33;
    public static final int RANGE_VALUE=13;
    public static final int LNOT=23;
    public static final int SINGLE_QUOTE=25;
    public static final int RPAREN=27;
    public static final int INCR=48;
    public static final int COMMA=19;
    public static final int IDENTIFIER=10;
    public static final int INTEGER_OR_REAL_OR_RANGE=54;
    public static final int TILDE=8;
    public static final int QUESTION_MARK=22;
    public static final int DOUBLE_GT=46;
    public static final int PLUS=5;
    public static final int PIPE=32;
    public static final int NL=21;
    public static final int EQ=17;
    public static final int INTEGER=14;
    public static final int GE=47;
    public static final int SHARP=7;
    public static final int DOUBLE_RCURLY=29;
    public static final int RANGE=35;
    public static final int UNDERSCORE=52;
    public static final int LCURLY=18;
    public static final int RSQUARE=15;
    public static final int MINUS=6;
    public static final int SEMI=36;
    public static final int ALPHA=51;
    public static final int COLON=4;
    public static final int REAL=53;
    public static final int WS=11;
    public static final int DOUBLE_LOGICAL_AND=31;
    public static final int RCURLY=20;
    public static final int DECR=49;
    public static final int GT=45;
    public static final int ARROW=39;
    public static final int DIV=9;
    public static final int LE=44;
    public static final int ISEQ=40;

        public PropertyLabelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g"; }

    
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
        Iterator<Property> it = PropertyUtil.getSubsettablesProperties(property).iterator();
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
        
        public void emitErrorMessage(String msg) {
            errorReporter.reportError(msg);
    }



    // $ANTLR start label
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:348:1: label : ( visibility )? ( isDerived )? name COLON property_type ( fullMultiplicity )? ( defaultValue )? ( propertyModifiers )? ;
    public final void label() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:348:7: ( ( visibility )? ( isDerived )? name COLON property_type ( fullMultiplicity )? ( defaultValue )? ( propertyModifiers )? )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:349:3: ( visibility )? ( isDerived )? name COLON property_type ( fullMultiplicity )? ( defaultValue )? ( propertyModifiers )?
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:349:3: ( visibility )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=PLUS && LA1_0<=TILDE)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:349:4: visibility
                    {
                    pushFollow(FOLLOW_visibility_in_label46);
                    visibility();
                    _fsp--;

                    context = IContext.VISIBILITY; 

                    }
                    break;

            }

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:350:3: ( isDerived )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DIV) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:350:4: isDerived
                    {
                    pushFollow(FOLLOW_isDerived_in_label56);
                    isDerived();
                    _fsp--;

                     context = IContext.IS_DERIVED; 

                    }
                    break;

            }

            pushFollow(FOLLOW_name_in_label65);
            name();
            _fsp--;

            match(input,COLON,FOLLOW_COLON_in_label70); 
            
                context = IContext.AFTER_COLON;
              
            pushFollow(FOLLOW_property_type_in_label79);
            property_type();
            _fsp--;

             context = IContext.MULTIPLICITY; 
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:357:3: ( fullMultiplicity )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LSQUARE) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:357:4: fullMultiplicity
                    {
                    pushFollow(FOLLOW_fullMultiplicity_in_label87);
                    fullMultiplicity();
                    _fsp--;

                     context = IContext.AFTER_MULTIPLICITY; 

                    }
                    break;

            }

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:358:3: ( defaultValue )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==EQ) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:358:4: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_label96);
                    defaultValue();
                    _fsp--;

                     context = IContext.DEFAULT_VALUE; 

                    }
                    break;

            }

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:359:3: ( propertyModifiers )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LCURLY) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:359:4: propertyModifiers
                    {
                    pushFollow(FOLLOW_propertyModifiers_in_label106);
                    propertyModifiers();
                    _fsp--;

                     context = IContext.PROPERTY_MODIFIERS; 

                    }
                    break;

            }

            
                applyValues();
              

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
    // $ANTLR end label


    // $ANTLR start visibility
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:365:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final void visibility() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:366:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:367:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:367:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt6=1;
                }
                break;
            case MINUS:
                {
                alt6=2;
                }
                break;
            case SHARP:
                {
                alt6=3;
                }
                break;
            case TILDE:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("367:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:368:5: ( PLUS )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:368:5: ( PLUS )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:368:9: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_visibility142); 
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:369:5: ( MINUS )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:369:5: ( MINUS )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:369:9: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_visibility157); 
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:370:5: ( SHARP )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:370:5: ( SHARP )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:370:9: SHARP
                    {
                    match(input,SHARP,FOLLOW_SHARP_in_visibility171); 
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:371:5: ( TILDE )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:371:5: ( TILDE )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:371:9: TILDE
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_visibility185); 
                     visibility = VisibilityKind.PACKAGE_LITERAL;

                    }


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
        return ;
    }
    // $ANTLR end visibility


    // $ANTLR start isDerived
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:376:1: isDerived : DIV ;
    public final void isDerived() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:377:3: ( DIV )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:378:3: DIV
            {
            match(input,DIV,FOLLOW_DIV_in_isDerived209); 
             isDerived = true; 

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
    // $ANTLR end isDerived


    // $ANTLR start name
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:381:1: name : id= IDENTIFIER ;
    public final void name() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:382:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:383:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name230); 
             
                name = id.getText();
                context = IContext.NAME;
              

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
    // $ANTLR end name


    // $ANTLR start property_type
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:390:1: property_type : ( WS )* ( type | '<Undefined>' ) ;
    public final void property_type() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:391:3: ( ( WS )* ( type | '<Undefined>' ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:392:3: ( WS )* ( type | '<Undefined>' )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:392:3: ( WS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==WS) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:392:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_property_type252); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:393:3: ( type | '<Undefined>' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENTIFIER) ) {
                alt8=1;
            }
            else if ( (LA8_0==55) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("393:3: ( type | '<Undefined>' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:393:5: type
                    {
                    pushFollow(FOLLOW_type_in_property_type260);
                    type();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:394:5: '<Undefined>'
                    {
                    match(input,55,FOLLOW_55_in_property_type268); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            
               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        return ;
    }
    // $ANTLR end property_type


    // $ANTLR start type
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:403:1: type : id= IDENTIFIER ;
    public final void type() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:404:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:405:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type303); 
            
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end type


    // $ANTLR start fullMultiplicity
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:445:1: fullMultiplicity : LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE ;
    public final void fullMultiplicity() throws RecognitionException {
        Token ra=null;
        Token up=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:446:3: ( LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:447:3: LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE
            {
            match(input,LSQUARE,FOLLOW_LSQUARE_in_fullMultiplicity324); 
             context = IContext.IN_MULTIPLICITY; 
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:464:3: (ra= RANGE_VALUE | up= INTEGER )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RANGE_VALUE) ) {
                alt9=1;
            }
            else if ( (LA9_0==INTEGER) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("464:3: (ra= RANGE_VALUE | up= INTEGER )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:465:5: ra= RANGE_VALUE
                    {
                    ra=(Token)input.LT(1);
                    match(input,RANGE_VALUE,FOLLOW_RANGE_VALUE_in_fullMultiplicity344); 
                     
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
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:477:5: up= INTEGER
                    {
                    up=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_fullMultiplicity354); 
                    
                            upperMultiplicity = Integer.parseInt(up.getText());
                            lowerMultiplicity = upperMultiplicity;
                      

                    }
                    break;

            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_fullMultiplicity364); 

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
    // $ANTLR end fullMultiplicity


    // $ANTLR start lowerMultiplicity
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:485:1: lowerMultiplicity : in= INTEGER ;
    public final void lowerMultiplicity() throws RecognitionException {
        Token in=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:486:3: (in= INTEGER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:487:3: in= INTEGER
            {
            in=(Token)input.LT(1);
            match(input,INTEGER,FOLLOW_INTEGER_in_lowerMultiplicity383); 
            
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:493:1: upperMultiplicity : um= unlimitedNatural ;
    public final void upperMultiplicity() throws RecognitionException {
        int um = 0;


        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:494:3: (um= unlimitedNatural )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:495:3: um= unlimitedNatural
            {
            pushFollow(FOLLOW_unlimitedNatural_in_upperMultiplicity404);
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:501:1: unlimitedNatural returns [int value = 0 ] : ( STAR | in= INTEGER ) ;
    public final int unlimitedNatural() throws RecognitionException {
        int value =  0;

        Token in=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:502:3: ( ( STAR | in= INTEGER ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:503:3: ( STAR | in= INTEGER )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:503:3: ( STAR | in= INTEGER )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==STAR) ) {
                alt10=1;
            }
            else if ( (LA10_0==INTEGER) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("503:3: ( STAR | in= INTEGER )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:503:5: STAR
                    {
                    match(input,STAR,FOLLOW_STAR_in_unlimitedNatural432); 
                     value = -1; 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:504:5: in= INTEGER
                    {
                    in=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_unlimitedNatural447); 
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:508:1: defaultValue : EQ dv= expression ;
    public final void defaultValue() throws RecognitionException {
        String dv = null;


        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:509:3: ( EQ dv= expression )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:510:3: EQ dv= expression
            {
            match(input,EQ,FOLLOW_EQ_in_defaultValue473); 
            pushFollow(FOLLOW_expression_in_defaultValue479);
            dv=expression();
            _fsp--;

            
                // remove spaces at the begining 
                defaultValue = dv.trim();
              

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
    // $ANTLR end defaultValue


    // $ANTLR start expression
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:517:1: expression returns [String value = \"\"] : ( options {greedy=false; } : id=~ ( LCURLY ) )+ ;
    public final String expression() throws RecognitionException {
        String value =  "";

        Token id=null;

        
            StringBuffer buffer = new StringBuffer();
           
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:521:3: ( ( options {greedy=false; } : id=~ ( LCURLY ) )+ )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:522:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:522:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==EOF||LA11_0==LCURLY) ) {
                    alt11=2;
                }
                else if ( ((LA11_0>=COLON && LA11_0<=EQ)||(LA11_0>=COMMA && LA11_0<=62)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:526:8: id=~ ( LCURLY )
            	    {
            	    id=(Token)input.LT(1);
            	    if ( (input.LA(1)>=COLON && input.LA(1)<=EQ)||(input.LA(1)>=COMMA && input.LA(1)<=62) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_expression551);    throw mse;
            	    }

            	    
            	          buffer.append(id.getText());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            
                value = buffer.toString();
              

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
    // $ANTLR end expression


    // $ANTLR start propertyModifiers
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:536:1: propertyModifiers : LCURLY propertyModifier ( COMMA propertyModifier )* RCURLY ;
    public final void propertyModifiers() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:537:3: ( LCURLY propertyModifier ( COMMA propertyModifier )* RCURLY )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:538:3: LCURLY propertyModifier ( COMMA propertyModifier )* RCURLY
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_propertyModifiers586); 
             context = IContext.PROPERTY_MODIFIER; 
            pushFollow(FOLLOW_propertyModifier_in_propertyModifiers595);
            propertyModifier();
            _fsp--;

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:541:3: ( COMMA propertyModifier )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:542:5: COMMA propertyModifier
            	    {
            	     context = IContext.PROPERTY_MODIFIER; 
            	    match(input,COMMA,FOLLOW_COMMA_in_propertyModifiers612); 
            	    pushFollow(FOLLOW_propertyModifier_in_propertyModifiers614);
            	    propertyModifier();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_propertyModifiers624); 

            }

        }
        catch (RecognitionException re) {
            
               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        return ;
    }
    // $ANTLR end propertyModifiers


    // $ANTLR start propertyModifier
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:552:1: propertyModifier : ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty ) ;
    public final void propertyModifier() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:553:3: ( ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:554:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:554:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )
            int alt13=7;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt13=1;
                }
                break;
            case 57:
                {
                alt13=2;
                }
                break;
            case 58:
                {
                alt13=3;
                }
                break;
            case 59:
                {
                alt13=4;
                }
                break;
            case 60:
                {
                alt13=5;
                }
                break;
            case 61:
                {
                alt13=6;
                }
                break;
            case 62:
                {
                alt13=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("554:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:555:5: 'readOnly'
                    {
                    match(input,56,FOLLOW_56_in_propertyModifier656); 
                     isReadOnly = true; modifiersUsed.put("readOnly", true);

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:556:5: 'union'
                    {
                    match(input,57,FOLLOW_57_in_propertyModifier665); 
                     isDerivedUnion = true; modifiersUsed.put("union", true);  

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:557:5: 'ordered'
                    {
                    match(input,58,FOLLOW_58_in_propertyModifier675); 
                     isOrdered = true; modifiersUsed.put("ordered", true); 

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:558:5: 'unique'
                    {
                    match(input,59,FOLLOW_59_in_propertyModifier683); 
                     isUnique = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 5 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:559:5: 'nonunique'
                    {
                    match(input,60,FOLLOW_60_in_propertyModifier692); 
                     isUnique = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 6 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:560:5: 'subsets' subsetsProperty
                    {
                    match(input,61,FOLLOW_61_in_propertyModifier700); 
                     context = IContext.SUBSET_PROPERTY ; 
                    pushFollow(FOLLOW_subsetsProperty_in_propertyModifier704);
                    subsetsProperty();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:561:5: redefinesProperty
                    {
                    pushFollow(FOLLOW_redefinesProperty_in_propertyModifier712);
                    redefinesProperty();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            
               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        return ;
    }
    // $ANTLR end propertyModifier


    // $ANTLR start subsetsProperty
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:569:1: subsetsProperty : id= IDENTIFIER ;
    public final void subsetsProperty() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:570:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:571:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_subsetsProperty850); 
            
                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findSubsettedPropertyByName(propertyName, property); 
                subsettedProperties.add(tmpProperty); 
              

            }

        }
        catch (RecognitionException re) {
            
               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        return ;
    }
    // $ANTLR end subsetsProperty


    // $ANTLR start redefinesProperty
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:584:1: redefinesProperty : 'redefines' id= IDENTIFIER ;
    public final void redefinesProperty() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:585:3: ( 'redefines' id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:586:3: 'redefines' id= IDENTIFIER
            {
             context = IContext.REDEFINE_PROPERTY ; 
            match(input,62,FOLLOW_62_in_redefinesProperty881); 
             context = IContext.REDEFINE_PROPERTY ; 
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_redefinesProperty887); 
            
                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findRedefinedPropertyByName(propertyName, property); 
                redefinedProperties.add(tmpProperty); 
              

            }

        }
        catch (RecognitionException re) {
            
               reportError(re); 
               throw(re);
               
        }
        finally {
        }
        return ;
    }
    // $ANTLR end redefinesProperty


 

    public static final BitSet FOLLOW_visibility_in_label46 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_isDerived_in_label56 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_label65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_label70 = new BitSet(new long[]{0x0080000000000C00L});
    public static final BitSet FOLLOW_property_type_in_label79 = new BitSet(new long[]{0x0000000000061002L});
    public static final BitSet FOLLOW_fullMultiplicity_in_label87 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_defaultValue_in_label96 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_propertyModifiers_in_label106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_visibility142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_visibility157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_visibility171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_visibility185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_isDerived209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_name230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_property_type252 = new BitSet(new long[]{0x0080000000000C00L});
    public static final BitSet FOLLOW_type_in_property_type260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_property_type268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_fullMultiplicity324 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RANGE_VALUE_in_fullMultiplicity344 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_fullMultiplicity354 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RSQUARE_in_fullMultiplicity364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_lowerMultiplicity383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unlimitedNatural_in_upperMultiplicity404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_unlimitedNatural432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_unlimitedNatural447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_defaultValue473 = new BitSet(new long[]{0x7FFFFFFFFFFBFFF0L});
    public static final BitSet FOLLOW_expression_in_defaultValue479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression551 = new BitSet(new long[]{0x7FFFFFFFFFFBFFF2L});
    public static final BitSet FOLLOW_LCURLY_in_propertyModifiers586 = new BitSet(new long[]{0x7F00000000000000L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers595 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_COMMA_in_propertyModifiers612 = new BitSet(new long[]{0x7F00000000000000L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers614 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_RCURLY_in_propertyModifiers624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_propertyModifier656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_propertyModifier665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_propertyModifier675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_propertyModifier683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_propertyModifier692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_propertyModifier700 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_subsetsProperty_in_propertyModifier704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_redefinesProperty_in_propertyModifier712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_subsetsProperty850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_redefinesProperty881 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDENTIFIER_in_redefinesProperty887 = new BitSet(new long[]{0x0000000000000002L});

}