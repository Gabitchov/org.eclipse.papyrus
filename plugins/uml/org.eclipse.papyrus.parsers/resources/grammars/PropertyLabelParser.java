// $ANTLR 3.0 D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g 2009-03-30 14:29:44

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "DIV", "IDENTIFIER", "LSQUARE", "POINT_POINT", "RSQUARE", "INTEGER", "STAR", "EQ", "LCURLY", "COMMA", "RCURLY", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "DOUBLE_LCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "DIGIT", "ALPHA", "UNDERSCORE", "REAL", "'<Undefined>'", "'readOnly'", "'union'", "'ordered'", "'unique'", "'nonunique'", "'subsets'", "'redefines'"
    };
    public static final int LT=41;
    public static final int STAR=16;
    public static final int ISNE=40;
    public static final int LSQUARE=12;
    public static final int POINT=34;
    public static final int DOUBLE_QUOTE=24;
    public static final int FOUR_POINTS=36;
    public static final int DOUBLE_LCURLY=28;
    public static final int DOUBLE_LT=42;
    public static final int CALLOPERATION=49;
    public static final int EOF=-1;
    public static final int LOGICAL_AND=30;
    public static final int LPAREN=26;
    public static final int RULE_ASSIGN=37;
    public static final int DOUBLE_PIPE=33;
    public static final int LNOT=23;
    public static final int SINGLE_QUOTE=25;
    public static final int RPAREN=27;
    public static final int INCR=47;
    public static final int COMMA=19;
    public static final int IDENTIFIER=11;
    public static final int TILDE=9;
    public static final int QUESTION_MARK=22;
    public static final int DOUBLE_GT=45;
    public static final int PLUS=6;
    public static final int PIPE=32;
    public static final int DIGIT=50;
    public static final int NL=21;
    public static final int EQ=17;
    public static final int INTEGER=15;
    public static final int GE=46;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=29;
    public static final int UNDERSCORE=52;
    public static final int LCURLY=18;
    public static final int RSQUARE=14;
    public static final int MINUS=7;
    public static final int SEMI=35;
    public static final int ALPHA=51;
    public static final int COLON=5;
    public static final int REAL=53;
    public static final int WS=4;
    public static final int POINT_POINT=13;
    public static final int DOUBLE_LOGICAL_AND=31;
    public static final int RCURLY=20;
    public static final int DECR=48;
    public static final int GT=44;
    public static final int ARROW=38;
    public static final int DIV=10;
    public static final int LE=43;
    public static final int ISEQ=39;

        public PropertyLabelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g"; }


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
          throw new TypeRecognitionException("Property "+propertyName+" has not been found or can not be redefined", property.getName());
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
          throw new MultiplicityException(propertyName+" Upper Bound ("+upperMultiplicity+") can not be gretater than subsetted property Upper Bound ("+subsettedPropertyUpperBound+")");
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
        Property redefinedProperty = null;
        Iterator it = property.getClass_().getInheritedMembers().iterator();
        while (it.hasNext()) {
          NamedElement namedElement = (NamedElement) it.next();
          if(namedElement instanceof Property) {
            Property tmpProperty = (Property)namedElement;
            if(propertyName.equals(tmpProperty.getName())) {
              redefinedProperty = tmpProperty;
            }
          }
        }
        
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:360:1: label : ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( ( ( WS )+ COLON ) | COLON ) property_type ( WS )* ( multiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers )? ;
    public final void label() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:361:3: ( ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( ( ( WS )+ COLON ) | COLON ) property_type ( WS )* ( multiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers )? )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:361:3: ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( ( ( WS )+ COLON ) | COLON ) property_type ( WS )* ( multiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers )?
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:361:3: ( WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:361:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_label47); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:362:3: ( visibility ( WS )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=PLUS && LA3_0<=TILDE)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:362:4: visibility ( WS )*
                    {
                    pushFollow(FOLLOW_visibility_in_label54);
                    visibility();
                    _fsp--;

                    context = IContext.VISIBILITY; 
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:362:49: ( WS )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==WS) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:362:50: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label59); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:363:3: ( isDerived ( WS )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==DIV) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:363:4: isDerived ( WS )*
                    {
                    pushFollow(FOLLOW_isDerived_in_label70);
                    isDerived();
                    _fsp--;

                     context = IContext.IS_DERIVED; 
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:363:48: ( WS )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==WS) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:363:49: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label74); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_name_in_label83);
            name();
            _fsp--;

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:365:3: ( ( ( WS )+ COLON ) | COLON )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WS) ) {
                alt7=1;
            }
            else if ( (LA7_0==COLON) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("365:3: ( ( ( WS )+ COLON ) | COLON )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:365:5: ( ( WS )+ COLON )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:365:5: ( ( WS )+ COLON )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:365:6: ( WS )+ COLON
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:365:6: ( WS )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==WS) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:365:7: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label92); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    match(input,COLON,FOLLOW_COLON_in_label96); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:366:7: COLON
                    {
                    match(input,COLON,FOLLOW_COLON_in_label105); 

                    }
                    break;

            }


                context = IContext.AFTER_COLON;
              
            pushFollow(FOLLOW_property_type_in_label119);
            property_type();
            _fsp--;

             context = IContext.PROPERTY_TYPE; 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:371:55: ( WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:371:56: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_label124); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:372:3: ( multiplicity ( WS )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LSQUARE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:372:4: multiplicity ( WS )*
                    {
                    pushFollow(FOLLOW_multiplicity_in_label133);
                    multiplicity();
                    _fsp--;

                     context = IContext.MULTIPLICITY; 
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:372:54: ( WS )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==WS) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:372:55: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label138); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:373:3: ( defaultValue )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==EQ) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:373:4: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_label148);
                    defaultValue();
                    _fsp--;

                     context = IContext.DEFAULT_VALUE; 

                    }
                    break;

            }

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:374:3: ( propertyModifiers )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LCURLY) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:374:4: propertyModifiers
                    {
                    pushFollow(FOLLOW_propertyModifiers_in_label158);
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:380:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final void visibility() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:382:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:382:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:382:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt13=1;
                }
                break;
            case MINUS:
                {
                alt13=2;
                }
                break;
            case SHARP:
                {
                alt13=3;
                }
                break;
            case TILDE:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("382:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:383:5: ( PLUS )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:383:5: ( PLUS )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:383:9: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_visibility194); 
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:384:5: ( MINUS )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:384:5: ( MINUS )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:384:9: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_visibility209); 
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:385:5: ( SHARP )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:385:5: ( SHARP )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:385:9: SHARP
                    {
                    match(input,SHARP,FOLLOW_SHARP_in_visibility223); 
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:386:5: ( TILDE )
                    {
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:386:5: ( TILDE )
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:386:9: TILDE
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_visibility237); 
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:391:1: isDerived : DIV ;
    public final void isDerived() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:393:3: ( DIV )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:393:3: DIV
            {
            match(input,DIV,FOLLOW_DIV_in_isDerived261); 
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:396:1: name : id= IDENTIFIER ;
    public final void name() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:398:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:398:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name282); 
             
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:405:1: property_type : ( WS )* ( type | '<Undefined>' ) ;
    public final void property_type() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:407:3: ( ( WS )* ( type | '<Undefined>' ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:407:3: ( WS )* ( type | '<Undefined>' )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:407:3: ( WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:407:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_property_type303); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:408:3: ( type | '<Undefined>' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==54) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("408:3: ( type | '<Undefined>' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:408:5: type
                    {
                    pushFollow(FOLLOW_type_in_property_type311);
                    type();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:409:5: '<Undefined>'
                    {
                    match(input,54,FOLLOW_54_in_property_type319); 

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
    // $ANTLR end property_type


    // $ANTLR start type
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:413:1: type : id= IDENTIFIER ;
    public final void type() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:415:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:415:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type342); 

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
                  else
                    type = utilType;
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


    // $ANTLR start multiplicity
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:454:1: multiplicity : LSQUARE ( lowerMultiplicity POINT_POINT upperMultiplicity | upperMultiplicity ) RSQUARE ;
    public final void multiplicity() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:456:3: ( LSQUARE ( lowerMultiplicity POINT_POINT upperMultiplicity | upperMultiplicity ) RSQUARE )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:456:3: LSQUARE ( lowerMultiplicity POINT_POINT upperMultiplicity | upperMultiplicity ) RSQUARE
            {
            match(input,LSQUARE,FOLLOW_LSQUARE_in_multiplicity363); 
             context = IContext.IN_MULTIPLICITY; 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:458:3: ( lowerMultiplicity POINT_POINT upperMultiplicity | upperMultiplicity )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==INTEGER) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==RSQUARE) ) {
                    alt16=2;
                }
                else if ( (LA16_1==POINT_POINT) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("458:3: ( lowerMultiplicity POINT_POINT upperMultiplicity | upperMultiplicity )", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA16_0==STAR) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("458:3: ( lowerMultiplicity POINT_POINT upperMultiplicity | upperMultiplicity )", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:459:5: lowerMultiplicity POINT_POINT upperMultiplicity
                    {
                    pushFollow(FOLLOW_lowerMultiplicity_in_multiplicity377);
                    lowerMultiplicity();
                    _fsp--;

                    match(input,POINT_POINT,FOLLOW_POINT_POINT_in_multiplicity379); 
                    pushFollow(FOLLOW_upperMultiplicity_in_multiplicity381);
                    upperMultiplicity();
                    _fsp--;


                          if(lowerMultiplicity > upperMultiplicity && upperMultiplicity != -1) {
                            throw new MultiplicityException("Lower bound ("+lowerMultiplicity+") is greater than upper bound ("+upperMultiplicity+")");
                          }
                        

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:464:5: upperMultiplicity
                    {
                    pushFollow(FOLLOW_upperMultiplicity_in_multiplicity389);
                    upperMultiplicity();
                    _fsp--;


                          if(upperMultiplicity == -1) {
                            lowerMultiplicity = 0;
                          } else {
                            lowerMultiplicity = upperMultiplicity;
                          }
                        

                    }
                    break;

            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_multiplicity399); 

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
    // $ANTLR end multiplicity


    // $ANTLR start lowerMultiplicity
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:475:1: lowerMultiplicity : in= INTEGER ;
    public final void lowerMultiplicity() throws RecognitionException {
        Token in=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:477:3: (in= INTEGER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:477:3: in= INTEGER
            {
            in=(Token)input.LT(1);
            match(input,INTEGER,FOLLOW_INTEGER_in_lowerMultiplicity418); 

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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:483:1: upperMultiplicity : um= unlimitedNatural ;
    public final void upperMultiplicity() throws RecognitionException {
        int um = 0;


        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:485:3: (um= unlimitedNatural )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:485:3: um= unlimitedNatural
            {
            pushFollow(FOLLOW_unlimitedNatural_in_upperMultiplicity439);
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:491:1: unlimitedNatural returns [int value = 0 ] : ( STAR | in= INTEGER ) ;
    public final int unlimitedNatural() throws RecognitionException {
        int value =  0;

        Token in=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:493:3: ( ( STAR | in= INTEGER ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:493:3: ( STAR | in= INTEGER )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:493:3: ( STAR | in= INTEGER )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==STAR) ) {
                alt17=1;
            }
            else if ( (LA17_0==INTEGER) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("493:3: ( STAR | in= INTEGER )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:493:5: STAR
                    {
                    match(input,STAR,FOLLOW_STAR_in_unlimitedNatural467); 
                     value = -1; 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:494:5: in= INTEGER
                    {
                    in=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_unlimitedNatural482); 
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:498:1: defaultValue : EQ dv= expression ;
    public final void defaultValue() throws RecognitionException {
        String dv = null;


        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:500:3: ( EQ dv= expression )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:500:3: EQ dv= expression
            {
            match(input,EQ,FOLLOW_EQ_in_defaultValue508); 
            pushFollow(FOLLOW_expression_in_defaultValue514);
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:507:1: expression returns [String value = \"\"] : ( options {greedy=false; } : id=~ ( LCURLY ) )+ ;
    public final String expression() throws RecognitionException {
        String value =  "";

        Token id=null;


            StringBuffer buffer = new StringBuffer();
           
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:512:4: ( ( options {greedy=false; } : id=~ ( LCURLY ) )+ )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:512:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:512:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==EOF||LA18_0==LCURLY) ) {
                    alt18=2;
                }
                else if ( ((LA18_0>=WS && LA18_0<=EQ)||(LA18_0>=COMMA && LA18_0<=61)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:516:8: id=~ ( LCURLY )
            	    {
            	    id=(Token)input.LT(1);
            	    if ( (input.LA(1)>=WS && input.LA(1)<=EQ)||(input.LA(1)>=COMMA && input.LA(1)<=61) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_expression586);    throw mse;
            	    }


            	          buffer.append(id.getText());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:526:1: propertyModifiers : LCURLY propertyModifier ( COMMA propertyModifier )* RCURLY ;
    public final void propertyModifiers() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:528:3: ( LCURLY propertyModifier ( COMMA propertyModifier )* RCURLY )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:528:3: LCURLY propertyModifier ( COMMA propertyModifier )* RCURLY
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_propertyModifiers621); 
             context = IContext.PROPERTY_MODIFIER; 
            pushFollow(FOLLOW_propertyModifier_in_propertyModifiers630);
            propertyModifier();
            _fsp--;

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:531:3: ( COMMA propertyModifier )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:532:5: COMMA propertyModifier
            	    {
            	     context = IContext.PROPERTY_MODIFIER; 
            	    match(input,COMMA,FOLLOW_COMMA_in_propertyModifiers647); 
            	    pushFollow(FOLLOW_propertyModifier_in_propertyModifiers649);
            	    propertyModifier();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_propertyModifiers659); 

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
    // $ANTLR end propertyModifiers


    // $ANTLR start propertyModifier
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:538:1: propertyModifier : ( WS )* ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | subsetsProperty | redefinesProperty ) ;
    public final void propertyModifier() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:540:3: ( ( WS )* ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | subsetsProperty | redefinesProperty ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:540:3: ( WS )* ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | subsetsProperty | redefinesProperty )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:540:3: ( WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:540:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_propertyModifier678); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:541:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | subsetsProperty | redefinesProperty )
            int alt21=7;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt21=1;
                }
                break;
            case 56:
                {
                alt21=2;
                }
                break;
            case 57:
                {
                alt21=3;
                }
                break;
            case 58:
                {
                alt21=4;
                }
                break;
            case 59:
                {
                alt21=5;
                }
                break;
            case 60:
                {
                alt21=6;
                }
                break;
            case 61:
                {
                alt21=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("541:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | subsetsProperty | redefinesProperty )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:542:5: 'readOnly'
                    {
                    match(input,55,FOLLOW_55_in_propertyModifier690); 
                     isReadOnly = true; modifiersUsed.put("readOnly", true);

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:543:5: 'union'
                    {
                    match(input,56,FOLLOW_56_in_propertyModifier699); 
                     isDerivedUnion = true; modifiersUsed.put("union", true);  

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:544:5: 'ordered'
                    {
                    match(input,57,FOLLOW_57_in_propertyModifier709); 
                     isOrdered = true; modifiersUsed.put("ordered", true); 

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:545:5: 'unique'
                    {
                    match(input,58,FOLLOW_58_in_propertyModifier717); 
                     isUnique = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 5 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:546:5: 'nonunique'
                    {
                    match(input,59,FOLLOW_59_in_propertyModifier726); 
                     isUnique = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 6 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:547:5: subsetsProperty
                    {
                    pushFollow(FOLLOW_subsetsProperty_in_propertyModifier734);
                    subsetsProperty();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:548:5: redefinesProperty
                    {
                    pushFollow(FOLLOW_redefinesProperty_in_propertyModifier742);
                    redefinesProperty();
                    _fsp--;


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
    // $ANTLR end propertyModifier


    // $ANTLR start subsetsProperty
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:552:1: subsetsProperty : 'subsets' ( WS )+ id= IDENTIFIER ;
    public final void subsetsProperty() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:554:3: ( 'subsets' ( WS )+ id= IDENTIFIER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:554:3: 'subsets' ( WS )+ id= IDENTIFIER
            {
            match(input,60,FOLLOW_60_in_subsetsProperty870); 
             context = IContext.SUBSET_PROPERTY ; 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:554:54: ( WS )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:554:55: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_subsetsProperty875); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_subsetsProperty881); 

                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findSubsettedPropertyByName(propertyName, property); 
                subsettedProperties.add(tmpProperty); 
              

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
    // $ANTLR end subsetsProperty


    // $ANTLR start redefinesProperty
    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:563:1: redefinesProperty : 'redefines' ( WS )* id= IDENTIFIER ;
    public final void redefinesProperty() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:565:3: ( 'redefines' ( WS )* id= IDENTIFIER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:565:3: 'redefines' ( WS )* id= IDENTIFIER
            {
            match(input,61,FOLLOW_61_in_redefinesProperty902); 
             context = IContext.REDEFINE_PROPERTY ; 
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:565:58: ( WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:565:59: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_redefinesProperty907); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_redefinesProperty913); 

                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findRedefinedPropertyByName(propertyName, property); 
                redefinedProperties.add(tmpProperty); 
              

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
    // $ANTLR end redefinesProperty


 

    public static final BitSet FOLLOW_WS_in_label47 = new BitSet(new long[]{0x0000000000000FD0L});
    public static final BitSet FOLLOW_visibility_in_label54 = new BitSet(new long[]{0x0000000000000C10L});
    public static final BitSet FOLLOW_WS_in_label59 = new BitSet(new long[]{0x0000000000000C10L});
    public static final BitSet FOLLOW_isDerived_in_label70 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_WS_in_label74 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_name_in_label83 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_WS_in_label92 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_COLON_in_label96 = new BitSet(new long[]{0x0040000000000810L});
    public static final BitSet FOLLOW_COLON_in_label105 = new BitSet(new long[]{0x0040000000000810L});
    public static final BitSet FOLLOW_property_type_in_label119 = new BitSet(new long[]{0x0000000000061012L});
    public static final BitSet FOLLOW_WS_in_label124 = new BitSet(new long[]{0x0000000000061012L});
    public static final BitSet FOLLOW_multiplicity_in_label133 = new BitSet(new long[]{0x0000000000060012L});
    public static final BitSet FOLLOW_WS_in_label138 = new BitSet(new long[]{0x0000000000060012L});
    public static final BitSet FOLLOW_defaultValue_in_label148 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_propertyModifiers_in_label158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_visibility194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_visibility209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_visibility223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_visibility237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_isDerived261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_name282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_property_type303 = new BitSet(new long[]{0x0040000000000810L});
    public static final BitSet FOLLOW_type_in_property_type311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_property_type319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_multiplicity363 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_lowerMultiplicity_in_multiplicity377 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_POINT_POINT_in_multiplicity379 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_upperMultiplicity_in_multiplicity381 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_upperMultiplicity_in_multiplicity389 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RSQUARE_in_multiplicity399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_lowerMultiplicity418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unlimitedNatural_in_upperMultiplicity439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_unlimitedNatural467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_unlimitedNatural482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_defaultValue508 = new BitSet(new long[]{0x3FFFFFFFFFFBFFF0L});
    public static final BitSet FOLLOW_expression_in_defaultValue514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression586 = new BitSet(new long[]{0x3FFFFFFFFFFBFFF2L});
    public static final BitSet FOLLOW_LCURLY_in_propertyModifiers621 = new BitSet(new long[]{0x3F80000000000010L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers630 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_COMMA_in_propertyModifiers647 = new BitSet(new long[]{0x3F80000000000010L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers649 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_RCURLY_in_propertyModifiers659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_propertyModifier678 = new BitSet(new long[]{0x3F80000000000010L});
    public static final BitSet FOLLOW_55_in_propertyModifier690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_propertyModifier699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_propertyModifier709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_propertyModifier717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_propertyModifier726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subsetsProperty_in_propertyModifier734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_redefinesProperty_in_propertyModifier742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_subsetsProperty870 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_subsetsProperty875 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_IDENTIFIER_in_subsetsProperty881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_redefinesProperty902 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_WS_in_redefinesProperty907 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_IDENTIFIER_in_redefinesProperty913 = new BitSet(new long[]{0x0000000000000002L});

}