// $ANTLR 3.0.1 D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g 2010-02-05 12:15:04

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PropertyLabelParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "DIV", "IDENTIFIER", "LSQUARE", "RANGE_VALUE", "INTEGER", "RSQUARE", "STAR", "EQ", "LCURLY", "COMMA", "RCURLY", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "DOUBLE_LCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "RANGE", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "ALPHA", "UNDERSCORE", "REAL", "INTEGER_OR_REAL_OR_RANGE", "'<Undefined>'", "'readOnly'", "'union'", "'ordered'", "'unique'", "'nonunique'", "'subsets'", "'redefines'"
    };
    public static final int COMMA=19;
    public static final int DOUBLE_LT=43;
    public static final int ISEQ=40;
    public static final int MINUS=7;
    public static final int INCR=48;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=29;
    public static final int DECR=49;
    public static final int ARROW=39;
    public static final int DOUBLE_GT=46;
    public static final int RULE_ASSIGN=38;
    public static final int TILDE=9;
    public static final int PIPE=32;
    public static final int DOUBLE_PIPE=33;
    public static final int INTEGER=14;
    public static final int RCURLY=20;
    public static final int QUESTION_MARK=22;
    public static final int NL=21;
    public static final int LCURLY=18;
    public static final int LE=44;
    public static final int RPAREN=27;
    public static final int LPAREN=26;
    public static final int PLUS=6;
    public static final int SINGLE_QUOTE=25;
    public static final int REAL=53;
    public static final int LSQUARE=12;
    public static final int RANGE=35;
    public static final int FOUR_POINTS=37;
    public static final int DOUBLE_LCURLY=28;
    public static final int POINT=34;
    public static final int WS=4;
    public static final int ALPHA=51;
    public static final int EQ=17;
    public static final int LT=42;
    public static final int GT=45;
    public static final int DOUBLE_QUOTE=24;
    public static final int RSQUARE=15;
    public static final int DOUBLE_LOGICAL_AND=31;
    public static final int RANGE_VALUE=13;
    public static final int SEMI=36;
    public static final int GE=47;
    public static final int LNOT=23;
    public static final int LOGICAL_AND=30;
    public static final int ISNE=41;
    public static final int EOF=-1;
    public static final int COLON=5;
    public static final int INTEGER_OR_REAL_OR_RANGE=54;
    public static final int DIV=10;
    public static final int STAR=16;
    public static final int IDENTIFIER=11;
    public static final int UNDERSCORE=52;
    public static final int CALLOPERATION=50;

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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:393:1: label : ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( WS )* COLON property_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers ( WS )* )? ;
    public final void label() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:393:7: ( ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( WS )* COLON property_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers ( WS )* )? )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:394:3: ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( WS )* COLON property_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers ( WS )* )?
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:394:3: ( WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:394:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_label46); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:395:3: ( visibility ( WS )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=PLUS && LA3_0<=TILDE)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:395:4: visibility ( WS )*
                    {
                    pushFollow(FOLLOW_visibility_in_label53);
                    visibility();
                    _fsp--;

                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:395:15: ( WS )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==WS) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:395:16: WS
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

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:396:3: ( isDerived ( WS )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==DIV) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:396:4: isDerived ( WS )*
                    {
                    pushFollow(FOLLOW_isDerived_in_label68);
                    isDerived();
                    _fsp--;

                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:396:14: ( WS )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==WS) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:396:15: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label71); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                     context = IContext.IS_DERIVED; 

                    }
                    break;

            }

            pushFollow(FOLLOW_name_in_label83);
            name();
            _fsp--;

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:397:8: ( WS )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==WS) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:397:9: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_label86); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,COLON,FOLLOW_COLON_in_label92); 
            
                context = IContext.AFTER_COLON;
              
            pushFollow(FOLLOW_property_type_in_label102);
            property_type();
            _fsp--;

             context = IContext.MULTIPLICITY; 
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:403:3: ( fullMultiplicity ( WS )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LSQUARE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:403:4: fullMultiplicity ( WS )*
                    {
                    pushFollow(FOLLOW_fullMultiplicity_in_label110);
                    fullMultiplicity();
                    _fsp--;

                     context = IContext.AFTER_MULTIPLICITY; 
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:403:64: ( WS )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==WS) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:403:65: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label115); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:404:3: ( defaultValue )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EQ) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:404:4: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_label124);
                    defaultValue();
                    _fsp--;

                     context = IContext.DEFAULT_VALUE; 

                    }
                    break;

            }

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:405:3: ( propertyModifiers ( WS )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LCURLY) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:405:4: propertyModifiers ( WS )*
                    {
                    pushFollow(FOLLOW_propertyModifiers_in_label134);
                    propertyModifiers();
                    _fsp--;

                     context = IContext.PROPERTY_MODIFIERS; 
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:405:65: ( WS )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==WS) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:405:66: WS
                    	    {
                    	    match(input,WS,FOLLOW_WS_in_label139); 

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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:435:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final void visibility() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:436:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:437:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:437:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
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
                    new NoViableAltException("437:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:438:5: ( PLUS )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:438:5: ( PLUS )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:438:9: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_visibility203); 
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:439:5: ( MINUS )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:439:5: ( MINUS )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:439:9: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_visibility218); 
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:440:5: ( SHARP )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:440:5: ( SHARP )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:440:9: SHARP
                    {
                    match(input,SHARP,FOLLOW_SHARP_in_visibility232); 
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:441:5: ( TILDE )
                    {
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:441:5: ( TILDE )
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:441:9: TILDE
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_visibility246); 
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


    // $ANTLR start isDerived
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:461:1: isDerived : DIV ;
    public final void isDerived() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:462:3: ( DIV )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:463:3: DIV
            {
            match(input,DIV,FOLLOW_DIV_in_isDerived287); 
             isDerived = true; 

            }

        }
        catch (MismatchedTokenException mte) {
            
                  reportError(mte);
                  throw (new RuntimeException("IsDerivedRule"));
               
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
    // $ANTLR end isDerived


    // $ANTLR start name
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:481:1: name : id= IDENTIFIER ;
    public final void name() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:482:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:483:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name326); 
             
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


    // $ANTLR start property_type
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:508:1: property_type : ( WS )* ( type | '<Undefined>' ) ;
    public final void property_type() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:509:3: ( ( WS )* ( type | '<Undefined>' ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:510:3: ( WS )* ( type | '<Undefined>' )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:510:3: ( WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:510:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_property_type375); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:511:3: ( type | '<Undefined>' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                alt14=1;
            }
            else if ( (LA14_0==55) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("511:3: ( type | '<Undefined>' )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:511:5: type
                    {
                    pushFollow(FOLLOW_type_in_property_type383);
                    type();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:512:5: '<Undefined>'
                    {
                    match(input,55,FOLLOW_55_in_property_type391); 

                    }
                    break;

            }


            }

        }
        catch (MismatchedTokenException mte) {
            
                  reportError(mte);
                  throw (new RuntimeException("PropertyTypeRule"));
               
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
    // $ANTLR end property_type


    // $ANTLR start type
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:529:1: type : id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* ;
    public final void type() throws RecognitionException {
        Token id=null;
        Token id1=null;

        
            StringBuffer buffer = new StringBuffer();
           
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:533:3: (id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:534:3: id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )*
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type451); 
            buffer.append(id.getText());
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:535:3: ( WS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==WS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:535:4: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_type458); 
            	    //System.err.println("space added"); buffer.append(" ");

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:536:3: (id1= IDENTIFIER ( WS )* )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENTIFIER) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:537:5: id1= IDENTIFIER ( WS )*
            	    {
            	    id1=(Token)input.LT(1);
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type475); 
            	    buffer.append(id1.getText());
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:538:5: ( WS )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==WS) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:538:6: WS
            	    	    {
            	    	    match(input,WS,FOLLOW_WS_in_type484); 
            	    	    //System.err.println("space added"); buffer.append(" ");

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            
                String typeName = buffer.toString().trim() ;
                //System.err.println("typeName: "+typeName); 
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:589:1: fullMultiplicity : LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE ;
    public final void fullMultiplicity() throws RecognitionException {
        Token ra=null;
        Token up=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:590:3: ( LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:591:3: LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE
            {
            match(input,LSQUARE,FOLLOW_LSQUARE_in_fullMultiplicity537); 
             context = IContext.IN_MULTIPLICITY; 
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:608:3: (ra= RANGE_VALUE | up= INTEGER )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RANGE_VALUE) ) {
                alt18=1;
            }
            else if ( (LA18_0==INTEGER) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("608:3: (ra= RANGE_VALUE | up= INTEGER )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:609:5: ra= RANGE_VALUE
                    {
                    ra=(Token)input.LT(1);
                    match(input,RANGE_VALUE,FOLLOW_RANGE_VALUE_in_fullMultiplicity557); 
                     
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
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:621:5: up= INTEGER
                    {
                    up=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_fullMultiplicity567); 
                    
                            upperMultiplicity = Integer.parseInt(up.getText());
                            lowerMultiplicity = upperMultiplicity;
                      

                    }
                    break;

            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_fullMultiplicity577); 

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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:649:1: lowerMultiplicity : in= INTEGER ;
    public final void lowerMultiplicity() throws RecognitionException {
        Token in=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:650:3: (in= INTEGER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:651:3: in= INTEGER
            {
            in=(Token)input.LT(1);
            match(input,INTEGER,FOLLOW_INTEGER_in_lowerMultiplicity629); 
            
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:657:1: upperMultiplicity : um= unlimitedNatural ;
    public final void upperMultiplicity() throws RecognitionException {
        int um = 0;


        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:658:3: (um= unlimitedNatural )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:659:3: um= unlimitedNatural
            {
            pushFollow(FOLLOW_unlimitedNatural_in_upperMultiplicity650);
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:665:1: unlimitedNatural returns [int value = 0 ] : ( STAR | in= INTEGER ) ;
    public final int unlimitedNatural() throws RecognitionException {
        int value =  0;

        Token in=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:666:3: ( ( STAR | in= INTEGER ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:667:3: ( STAR | in= INTEGER )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:667:3: ( STAR | in= INTEGER )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==STAR) ) {
                alt19=1;
            }
            else if ( (LA19_0==INTEGER) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("667:3: ( STAR | in= INTEGER )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:667:5: STAR
                    {
                    match(input,STAR,FOLLOW_STAR_in_unlimitedNatural678); 
                     value = -1; 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:668:5: in= INTEGER
                    {
                    in=(Token)input.LT(1);
                    match(input,INTEGER,FOLLOW_INTEGER_in_unlimitedNatural693); 
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:672:1: defaultValue : EQ dv= expression ;
    public final void defaultValue() throws RecognitionException {
        String dv = null;


        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:673:3: ( EQ dv= expression )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:674:3: EQ dv= expression
            {
            match(input,EQ,FOLLOW_EQ_in_defaultValue719); 
            pushFollow(FOLLOW_expression_in_defaultValue725);
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:690:1: expression returns [String value = \"\"] : ( options {greedy=false; } : id=~ ( LCURLY ) )+ ;
    public final String expression() throws RecognitionException {
        String value =  "";

        Token id=null;

        
            StringBuffer buffer = new StringBuffer();
           
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:694:3: ( ( options {greedy=false; } : id=~ ( LCURLY ) )+ )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:695:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:695:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==EOF||LA20_0==LCURLY) ) {
                    alt20=2;
                }
                else if ( ((LA20_0>=WS && LA20_0<=EQ)||(LA20_0>=COMMA && LA20_0<=62)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:699:8: id=~ ( LCURLY )
            	    {
            	    id=(Token)input.LT(1);
            	    if ( (input.LA(1)>=WS && input.LA(1)<=EQ)||(input.LA(1)>=COMMA && input.LA(1)<=62) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_expression819);    throw mse;
            	    }

            	    
            	          buffer.append(id.getText());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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


    // $ANTLR start propertyModifiers
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:718:1: propertyModifiers : LCURLY ( WS )* propertyModifier ( WS )* ( COMMA ( WS )* propertyModifier ( WS )* )* RCURLY ;
    public final void propertyModifiers() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:719:3: ( LCURLY ( WS )* propertyModifier ( WS )* ( COMMA ( WS )* propertyModifier ( WS )* )* RCURLY )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:720:3: LCURLY ( WS )* propertyModifier ( WS )* ( COMMA ( WS )* propertyModifier ( WS )* )* RCURLY
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_propertyModifiers876); 
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:720:10: ( WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:720:11: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_propertyModifiers879); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             context = IContext.PROPERTY_MODIFIER; 
            pushFollow(FOLLOW_propertyModifier_in_propertyModifiers889);
            propertyModifier();
            _fsp--;

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:722:20: ( WS )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==WS) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:722:21: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_propertyModifiers892); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:723:3: ( COMMA ( WS )* propertyModifier ( WS )* )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:724:5: COMMA ( WS )* propertyModifier ( WS )*
            	    {
            	     context = IContext.PROPERTY_MODIFIER; 
            	    match(input,COMMA,FOLLOW_COMMA_in_propertyModifiers911); 
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:725:11: ( WS )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==WS) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:725:12: WS
            	    	    {
            	    	    match(input,WS,FOLLOW_WS_in_propertyModifiers914); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);

            	    pushFollow(FOLLOW_propertyModifier_in_propertyModifiers918);
            	    propertyModifier();
            	    _fsp--;

            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:725:34: ( WS )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==WS) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:725:35: WS
            	    	    {
            	    	    match(input,WS,FOLLOW_WS_in_propertyModifiers921); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_propertyModifiers933); 

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
    // $ANTLR end propertyModifiers


    // $ANTLR start propertyModifier
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:738:1: propertyModifier : ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty ) ;
    public final void propertyModifier() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:739:3: ( ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:740:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:740:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )
            int alt26=7;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt26=1;
                }
                break;
            case 57:
                {
                alt26=2;
                }
                break;
            case 58:
                {
                alt26=3;
                }
                break;
            case 59:
                {
                alt26=4;
                }
                break;
            case 60:
                {
                alt26=5;
                }
                break;
            case 61:
                {
                alt26=6;
                }
                break;
            case 62:
                {
                alt26=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("740:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:741:5: 'readOnly'
                    {
                    match(input,56,FOLLOW_56_in_propertyModifier973); 
                     isReadOnly = true; modifiersUsed.put("readOnly", true);

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:742:5: 'union'
                    {
                    match(input,57,FOLLOW_57_in_propertyModifier982); 
                     isDerivedUnion = true; modifiersUsed.put("union", true);  

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:743:5: 'ordered'
                    {
                    match(input,58,FOLLOW_58_in_propertyModifier992); 
                     isOrdered = true; modifiersUsed.put("ordered", true); 

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:744:5: 'unique'
                    {
                    match(input,59,FOLLOW_59_in_propertyModifier1000); 
                     isUnique = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 5 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:745:5: 'nonunique'
                    {
                    match(input,60,FOLLOW_60_in_propertyModifier1009); 
                     isUnique = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 6 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:746:5: 'subsets' subsetsProperty
                    {
                    match(input,61,FOLLOW_61_in_propertyModifier1017); 
                     context = IContext.SUBSET_PROPERTY ; 
                    pushFollow(FOLLOW_subsetsProperty_in_propertyModifier1021);
                    subsetsProperty();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:747:5: redefinesProperty
                    {
                    pushFollow(FOLLOW_redefinesProperty_in_propertyModifier1029);
                    redefinesProperty();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (MismatchedTokenException mte) {
            
                  reportError(mte);
                  throw (new RuntimeException("PropertyModifierRule"));
               
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:760:1: subsetsProperty : id= IDENTIFIER ;
    public final void subsetsProperty() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:761:3: (id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:762:3: id= IDENTIFIER
            {
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_subsetsProperty1181); 
            
                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findSubsettedPropertyByName(propertyName, property); 
                subsettedProperties.add(tmpProperty); 
              

            }

        }
        catch (MismatchedTokenException mte) {
            
                  reportError(mte);
                  throw (new RuntimeException("subsetsPropertyRule"));
               
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
    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:779:1: redefinesProperty : 'redefines' id= IDENTIFIER ;
    public final void redefinesProperty() throws RecognitionException {
        Token id=null;

        try {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:780:3: ( 'redefines' id= IDENTIFIER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:781:3: 'redefines' id= IDENTIFIER
            {
             context = IContext.REDEFINE_PROPERTY ; 
            match(input,62,FOLLOW_62_in_redefinesProperty1220); 
             context = IContext.REDEFINE_PROPERTY ; 
            id=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_redefinesProperty1226); 
            
                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findRedefinedPropertyByName(propertyName, property); 
                redefinedProperties.add(tmpProperty); 
              

            }

        }
        catch (MismatchedTokenException mte) {
            
                  reportError(mte);
                  throw (new RuntimeException("redefinesPropertyRule"));
               
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


 

    public static final BitSet FOLLOW_WS_in_label46 = new BitSet(new long[]{0x0000000000000FD0L});
    public static final BitSet FOLLOW_visibility_in_label53 = new BitSet(new long[]{0x0000000000000C10L});
    public static final BitSet FOLLOW_WS_in_label56 = new BitSet(new long[]{0x0000000000000C10L});
    public static final BitSet FOLLOW_isDerived_in_label68 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_WS_in_label71 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_name_in_label83 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_WS_in_label86 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_COLON_in_label92 = new BitSet(new long[]{0x0080000000000810L});
    public static final BitSet FOLLOW_property_type_in_label102 = new BitSet(new long[]{0x0000000000061002L});
    public static final BitSet FOLLOW_fullMultiplicity_in_label110 = new BitSet(new long[]{0x0000000000060012L});
    public static final BitSet FOLLOW_WS_in_label115 = new BitSet(new long[]{0x0000000000060012L});
    public static final BitSet FOLLOW_defaultValue_in_label124 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_propertyModifiers_in_label134 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_label139 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_PLUS_in_visibility203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_visibility218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_visibility232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_visibility246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_isDerived287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_name326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_property_type375 = new BitSet(new long[]{0x0080000000000810L});
    public static final BitSet FOLLOW_type_in_property_type383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_property_type391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type451 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_WS_in_type458 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type475 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_WS_in_type484 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_LSQUARE_in_fullMultiplicity537 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RANGE_VALUE_in_fullMultiplicity557 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_fullMultiplicity567 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RSQUARE_in_fullMultiplicity577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_lowerMultiplicity629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unlimitedNatural_in_upperMultiplicity650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_unlimitedNatural678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_unlimitedNatural693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_defaultValue719 = new BitSet(new long[]{0x7FFFFFFFFFFBFFF0L});
    public static final BitSet FOLLOW_expression_in_defaultValue725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression819 = new BitSet(new long[]{0x7FFFFFFFFFFBFFF2L});
    public static final BitSet FOLLOW_LCURLY_in_propertyModifiers876 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers879 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers889 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers892 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_COMMA_in_propertyModifiers911 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers914 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers918 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers921 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_RCURLY_in_propertyModifiers933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_propertyModifier973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_propertyModifier982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_propertyModifier992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_propertyModifier1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_propertyModifier1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_propertyModifier1017 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_subsetsProperty_in_propertyModifier1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_redefinesProperty_in_propertyModifier1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_subsetsProperty1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_redefinesProperty1220 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENTIFIER_in_redefinesProperty1226 = new BitSet(new long[]{0x0000000000000002L});

}