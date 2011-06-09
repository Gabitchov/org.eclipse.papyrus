// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g 2011-03-15 16:41:29

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

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class PropertyLabelParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "COLON", "PLUS", "MINUS", "SHARP", "TILDE", "DIV", "IDENTIFIER", "LSQUARE", "RANGE_VALUE", "INTEGER", "RSQUARE", "STAR", "EQ", "LCURLY", "COMMA", "RCURLY", "NL", "QUESTION_MARK", "LNOT", "DOUBLE_QUOTE", "SINGLE_QUOTE", "LPAREN", "RPAREN", "DOUBLE_LCURLY", "DOUBLE_RCURLY", "LOGICAL_AND", "DOUBLE_LOGICAL_AND", "PIPE", "DOUBLE_PIPE", "POINT", "RANGE", "SEMI", "FOUR_POINTS", "RULE_ASSIGN", "ARROW", "ISEQ", "ISNE", "LT", "DOUBLE_LT", "LE", "GT", "DOUBLE_GT", "GE", "INCR", "DECR", "CALLOPERATION", "ALPHA", "UNDERSCORE", "REAL", "INTEGER_OR_REAL_OR_RANGE", "'<Undefined>'", "'readOnly'", "'union'", "'ordered'", "'unique'", "'nonunique'", "'subsets'", "'redefines'"
    };
    public static final int DOUBLE_LT=43;
    public static final int COMMA=19;
    public static final int ISEQ=40;
    public static final int MINUS=7;
    public static final int INCR=48;
    public static final int SHARP=8;
    public static final int T__57=57;
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
    public static final int T__62=62;
    public static final int LE=44;
    public static final int RPAREN=27;
    public static final int T__61=61;
    public static final int LPAREN=26;
    public static final int T__59=59;
    public static final int PLUS=6;
    public static final int SINGLE_QUOTE=25;
    public static final int REAL=53;
    public static final int T__56=56;
    public static final int LSQUARE=12;
    public static final int RANGE=35;
    public static final int FOUR_POINTS=37;
    public static final int DOUBLE_LCURLY=28;
    public static final int POINT=34;
    public static final int WS=4;
    public static final int ALPHA=51;
    public static final int T__58=58;
    public static final int EQ=17;
    public static final int LT=42;
    public static final int GT=45;
    public static final int DOUBLE_QUOTE=24;
    public static final int RSQUARE=15;
    public static final int DOUBLE_LOGICAL_AND=31;
    public static final int RANGE_VALUE=13;
    public static final int T__55=55;
    public static final int SEMI=36;
    public static final int GE=47;
    public static final int LNOT=23;
    public static final int ISNE=41;
    public static final int LOGICAL_AND=30;
    public static final int EOF=-1;
    public static final int COLON=5;
    public static final int INTEGER_OR_REAL_OR_RANGE=54;
    public static final int DIV=10;
    public static final int IDENTIFIER=11;
    public static final int STAR=16;
    public static final int T__60=60;
    public static final int UNDERSCORE=52;
    public static final int CALLOPERATION=50;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "property_type", "type", "expression", "subsetsProperty", 
        "isDerived", "defaultValue", "upperMultiplicity", "unlimitedNatural", 
        "fullMultiplicity", "redefinesProperty", "lowerMultiplicity", "label", 
        "propertyModifiers", "visibility", "propertyModifier", "name"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public PropertyLabelParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public PropertyLabelParser(TokenStream input, int port, RecognizerSharedState state) {
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
    public PropertyLabelParser(TokenStream input, DebugEventListener dbg) {
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


    public String[] getTokenNames() { return PropertyLabelParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g"; }


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
      public void recover(IntStream arg0, RecognitionException arg1) {
      throw new RuntimeException("no recover", arg1);
        // do nothing
      }




    public static class label_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:377:1: label : ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( WS )* COLON property_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers ( WS )* )? ;
    public final PropertyLabelParser.label_return label() throws RecognitionException {
        PropertyLabelParser.label_return retval = new PropertyLabelParser.label_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS1=null;
        Token WS3=null;
        Token WS5=null;
        Token WS7=null;
        Token COLON8=null;
        Token WS11=null;
        Token WS14=null;
        PropertyLabelParser.visibility_return visibility2 = null;

        PropertyLabelParser.isDerived_return isDerived4 = null;

        PropertyLabelParser.name_return name6 = null;

        PropertyLabelParser.property_type_return property_type9 = null;

        PropertyLabelParser.fullMultiplicity_return fullMultiplicity10 = null;

        PropertyLabelParser.defaultValue_return defaultValue12 = null;

        PropertyLabelParser.propertyModifiers_return propertyModifiers13 = null;


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
        dbg.location(377, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:377:7: ( ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( WS )* COLON property_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers ( WS )* )? )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:378:3: ( WS )* ( visibility ( WS )* )? ( isDerived ( WS )* )? name ( WS )* COLON property_type ( fullMultiplicity ( WS )* )? ( defaultValue )? ( propertyModifiers ( WS )* )?
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(378,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:378:3: ( WS )*
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

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:378:4: WS
            	    {
            	    dbg.location(378,4);
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

            dbg.location(379,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:379:3: ( visibility ( WS )* )?
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:379:4: visibility ( WS )*
                    {
                    dbg.location(379,4);
                    pushFollow(FOLLOW_visibility_in_label53);
                    visibility2=visibility();

                    state._fsp--;

                    adaptor.addChild(root_0, visibility2.getTree());
                    dbg.location(379,15);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:379:15: ( WS )*
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

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:379:16: WS
                    	    {
                    	    dbg.location(379,16);
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

                    dbg.location(379,20);
                    context = IContext.VISIBILITY; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(380,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:380:3: ( isDerived ( WS )* )?
            int alt5=2;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5);

            int LA5_0 = input.LA(1);

            if ( (LA5_0==DIV) ) {
                alt5=1;
            }
            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:380:4: isDerived ( WS )*
                    {
                    dbg.location(380,4);
                    pushFollow(FOLLOW_isDerived_in_label68);
                    isDerived4=isDerived();

                    state._fsp--;

                    adaptor.addChild(root_0, isDerived4.getTree());
                    dbg.location(380,14);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:380:14: ( WS )*
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

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:380:15: WS
                    	    {
                    	    dbg.location(380,15);
                    	    WS5=(Token)match(input,WS,FOLLOW_WS_in_label71); 
                    	    WS5_tree = (Object)adaptor.create(WS5);
                    	    adaptor.addChild(root_0, WS5_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(4);}

                    dbg.location(380,20);
                     context = IContext.IS_DERIVED; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}

            dbg.location(381,3);
            pushFollow(FOLLOW_name_in_label83);
            name6=name();

            state._fsp--;

            adaptor.addChild(root_0, name6.getTree());
            dbg.location(381,8);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:381:8: ( WS )*
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

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:381:9: WS
            	    {
            	    dbg.location(381,9);
            	    WS7=(Token)match(input,WS,FOLLOW_WS_in_label86); 
            	    WS7_tree = (Object)adaptor.create(WS7);
            	    adaptor.addChild(root_0, WS7_tree);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}

            dbg.location(382,3);
            COLON8=(Token)match(input,COLON,FOLLOW_COLON_in_label92); 
            COLON8_tree = (Object)adaptor.create(COLON8);
            adaptor.addChild(root_0, COLON8_tree);

            dbg.location(383,3);

                context = IContext.AFTER_COLON;
              
            dbg.location(386,3);
            pushFollow(FOLLOW_property_type_in_label102);
            property_type9=property_type();

            state._fsp--;

            adaptor.addChild(root_0, property_type9.getTree());
            dbg.location(386,18);
             context = IContext.MULTIPLICITY; 
            dbg.location(387,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:387:3: ( fullMultiplicity ( WS )* )?
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:387:4: fullMultiplicity ( WS )*
                    {
                    dbg.location(387,4);
                    pushFollow(FOLLOW_fullMultiplicity_in_label110);
                    fullMultiplicity10=fullMultiplicity();

                    state._fsp--;

                    adaptor.addChild(root_0, fullMultiplicity10.getTree());
                    dbg.location(387,21);
                     context = IContext.AFTER_MULTIPLICITY; 
                    dbg.location(387,64);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:387:64: ( WS )*
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

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:387:65: WS
                    	    {
                    	    dbg.location(387,65);
                    	    WS11=(Token)match(input,WS,FOLLOW_WS_in_label115); 
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

            dbg.location(388,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:388:3: ( defaultValue )?
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:388:4: defaultValue
                    {
                    dbg.location(388,4);
                    pushFollow(FOLLOW_defaultValue_in_label124);
                    defaultValue12=defaultValue();

                    state._fsp--;

                    adaptor.addChild(root_0, defaultValue12.getTree());
                    dbg.location(388,17);
                     context = IContext.DEFAULT_VALUE; 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}

            dbg.location(389,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:389:3: ( propertyModifiers ( WS )* )?
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:389:4: propertyModifiers ( WS )*
                    {
                    dbg.location(389,4);
                    pushFollow(FOLLOW_propertyModifiers_in_label134);
                    propertyModifiers13=propertyModifiers();

                    state._fsp--;

                    adaptor.addChild(root_0, propertyModifiers13.getTree());
                    dbg.location(389,22);
                     context = IContext.PROPERTY_MODIFIERS; 
                    dbg.location(389,65);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:389:65: ( WS )*
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

                    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:389:66: WS
                    	    {
                    	    dbg.location(389,66);
                    	    WS14=(Token)match(input,WS,FOLLOW_WS_in_label139); 
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

            dbg.location(390,3);

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
        dbg.location(393, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:419:1: visibility : ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) ;
    public final PropertyLabelParser.visibility_return visibility() throws RecognitionException {
        PropertyLabelParser.visibility_return retval = new PropertyLabelParser.visibility_return();
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
        dbg.location(419, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:420:3: ( ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:421:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(421,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:421:3: ( ( PLUS ) | ( MINUS ) | ( SHARP ) | ( TILDE ) )
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:422:5: ( PLUS )
                    {
                    dbg.location(422,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:422:5: ( PLUS )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:422:9: PLUS
                    {
                    dbg.location(422,9);
                    PLUS15=(Token)match(input,PLUS,FOLLOW_PLUS_in_visibility203); 
                    PLUS15_tree = (Object)adaptor.create(PLUS15);
                    adaptor.addChild(root_0, PLUS15_tree);

                    dbg.location(422,15);
                     visibility = VisibilityKind.PUBLIC_LITERAL; 

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:423:5: ( MINUS )
                    {
                    dbg.location(423,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:423:5: ( MINUS )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:423:9: MINUS
                    {
                    dbg.location(423,9);
                    MINUS16=(Token)match(input,MINUS,FOLLOW_MINUS_in_visibility218); 
                    MINUS16_tree = (Object)adaptor.create(MINUS16);
                    adaptor.addChild(root_0, MINUS16_tree);

                    dbg.location(423,15);
                     visibility = VisibilityKind.PRIVATE_LITERAL;

                    }


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:424:5: ( SHARP )
                    {
                    dbg.location(424,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:424:5: ( SHARP )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:424:9: SHARP
                    {
                    dbg.location(424,9);
                    SHARP17=(Token)match(input,SHARP,FOLLOW_SHARP_in_visibility232); 
                    SHARP17_tree = (Object)adaptor.create(SHARP17);
                    adaptor.addChild(root_0, SHARP17_tree);

                    dbg.location(424,15);
                     visibility = VisibilityKind.PROTECTED_LITERAL;

                    }


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:425:5: ( TILDE )
                    {
                    dbg.location(425,5);
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:425:5: ( TILDE )
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:425:9: TILDE
                    {
                    dbg.location(425,9);
                    TILDE18=(Token)match(input,TILDE,FOLLOW_TILDE_in_visibility246); 
                    TILDE18_tree = (Object)adaptor.create(TILDE18);
                    adaptor.addChild(root_0, TILDE18_tree);

                    dbg.location(425,15);
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
        dbg.location(427, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "visibility");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "visibility"

    public static class isDerived_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isDerived"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:445:1: isDerived : DIV ;
    public final PropertyLabelParser.isDerived_return isDerived() throws RecognitionException {
        PropertyLabelParser.isDerived_return retval = new PropertyLabelParser.isDerived_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DIV19=null;

        Object DIV19_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "isDerived");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(445, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:446:3: ( DIV )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:447:3: DIV
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(447,3);
            DIV19=(Token)match(input,DIV,FOLLOW_DIV_in_isDerived287); 
            DIV19_tree = (Object)adaptor.create(DIV19);
            adaptor.addChild(root_0, DIV19_tree);

            dbg.location(447,9);
             isDerived = true; 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
        dbg.location(448, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "isDerived");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "isDerived"

    public static class name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "name"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:465:1: name : id= IDENTIFIER ;
    public final PropertyLabelParser.name_return name() throws RecognitionException {
        PropertyLabelParser.name_return retval = new PropertyLabelParser.name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "name");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(465, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:466:3: (id= IDENTIFIER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:467:3: id= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(467,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_name326); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(468,3);
             
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
        dbg.location(472, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "name");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "name"

    public static class property_type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "property_type"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:492:1: property_type : ( WS )* ( type | '<Undefined>' ) ;
    public final PropertyLabelParser.property_type_return property_type() throws RecognitionException {
        PropertyLabelParser.property_type_return retval = new PropertyLabelParser.property_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS20=null;
        Token string_literal22=null;
        PropertyLabelParser.type_return type21 = null;


        Object WS20_tree=null;
        Object string_literal22_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "property_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(492, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:493:3: ( ( WS )* ( type | '<Undefined>' ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:494:3: ( WS )* ( type | '<Undefined>' )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(494,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:494:3: ( WS )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==WS) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:494:4: WS
            	    {
            	    dbg.location(494,4);
            	    WS20=(Token)match(input,WS,FOLLOW_WS_in_property_type375); 
            	    WS20_tree = (Object)adaptor.create(WS20);
            	    adaptor.addChild(root_0, WS20_tree);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}

            dbg.location(495,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:495:3: ( type | '<Undefined>' )
            int alt14=2;
            try { dbg.enterSubRule(14);
            try { dbg.enterDecision(14);

            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                alt14=1;
            }
            else if ( (LA14_0==55) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:495:5: type
                    {
                    dbg.location(495,5);
                    pushFollow(FOLLOW_type_in_property_type383);
                    type21=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type21.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:496:5: '<Undefined>'
                    {
                    dbg.location(496,5);
                    string_literal22=(Token)match(input,55,FOLLOW_55_in_property_type391); 
                    string_literal22_tree = (Object)adaptor.create(string_literal22);
                    adaptor.addChild(root_0, string_literal22_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(14);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
        dbg.location(498, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "property_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "property_type"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:513:1: type : id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* ;
    public final PropertyLabelParser.type_return type() throws RecognitionException {
        PropertyLabelParser.type_return retval = new PropertyLabelParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token id1=null;
        Token WS23=null;
        Token WS24=null;

        Object id_tree=null;
        Object id1_tree=null;
        Object WS23_tree=null;
        Object WS24_tree=null;


            StringBuffer buffer = new StringBuffer();
           
        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(513, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:517:3: (id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )* )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:518:3: id= IDENTIFIER ( WS )* (id1= IDENTIFIER ( WS )* )*
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(518,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type451); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(518,17);
            buffer.append(id.getText());
            dbg.location(519,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:519:3: ( WS )*
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==WS) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:519:4: WS
            	    {
            	    dbg.location(519,4);
            	    WS23=(Token)match(input,WS,FOLLOW_WS_in_type458); 
            	    WS23_tree = (Object)adaptor.create(WS23);
            	    adaptor.addChild(root_0, WS23_tree);

            	    dbg.location(519,7);
            	    //System.err.println("space added"); 
            	      buffer.append(" ");

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);
            } finally {dbg.exitSubRule(15);}

            dbg.location(521,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:521:3: (id1= IDENTIFIER ( WS )* )*
            try { dbg.enterSubRule(17);

            loop17:
            do {
                int alt17=2;
                try { dbg.enterDecision(17);

                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENTIFIER) ) {
                    alt17=1;
                }


                } finally {dbg.exitDecision(17);}

                switch (alt17) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:522:5: id1= IDENTIFIER ( WS )*
            	    {
            	    dbg.location(522,8);
            	    id1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type475); 
            	    id1_tree = (Object)adaptor.create(id1);
            	    adaptor.addChild(root_0, id1_tree);

            	    dbg.location(522,20);
            	    buffer.append(id1.getText());
            	    dbg.location(523,5);
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:523:5: ( WS )*
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

            	    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:523:6: WS
            	    	    {
            	    	    dbg.location(523,6);
            	    	    WS24=(Token)match(input,WS,FOLLOW_WS_in_type484); 
            	    	    WS24_tree = (Object)adaptor.create(WS24);
            	    	    adaptor.addChild(root_0, WS24_tree);

            	    	    dbg.location(523,9);
            	    	    //System.err.println("space added"); 
            	    	        buffer.append(" ");

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(16);}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);
            } finally {dbg.exitSubRule(17);}

            dbg.location(526,3);

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
        dbg.location(564, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:575:1: fullMultiplicity : LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE ;
    public final PropertyLabelParser.fullMultiplicity_return fullMultiplicity() throws RecognitionException {
        PropertyLabelParser.fullMultiplicity_return retval = new PropertyLabelParser.fullMultiplicity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ra=null;
        Token up=null;
        Token LSQUARE25=null;
        Token RSQUARE26=null;

        Object ra_tree=null;
        Object up_tree=null;
        Object LSQUARE25_tree=null;
        Object RSQUARE26_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "fullMultiplicity");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(575, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:576:3: ( LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:577:3: LSQUARE (ra= RANGE_VALUE | up= INTEGER ) RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(577,3);
            LSQUARE25=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_fullMultiplicity537); 
            LSQUARE25_tree = (Object)adaptor.create(LSQUARE25);
            adaptor.addChild(root_0, LSQUARE25_tree);

            dbg.location(578,3);
             context = IContext.IN_MULTIPLICITY; 
            dbg.location(594,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:594:3: (ra= RANGE_VALUE | up= INTEGER )
            int alt18=2;
            try { dbg.enterSubRule(18);
            try { dbg.enterDecision(18);

            int LA18_0 = input.LA(1);

            if ( (LA18_0==RANGE_VALUE) ) {
                alt18=1;
            }
            else if ( (LA18_0==INTEGER) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(18);}

            switch (alt18) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:595:5: ra= RANGE_VALUE
                    {
                    dbg.location(595,7);
                    ra=(Token)match(input,RANGE_VALUE,FOLLOW_RANGE_VALUE_in_fullMultiplicity557); 
                    ra_tree = (Object)adaptor.create(ra);
                    adaptor.addChild(root_0, ra_tree);

                    dbg.location(595,20);
                     
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:607:5: up= INTEGER
                    {
                    dbg.location(607,7);
                    up=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_fullMultiplicity567); 
                    up_tree = (Object)adaptor.create(up);
                    adaptor.addChild(root_0, up_tree);

                    dbg.location(607,16);

                            upperMultiplicity = Integer.parseInt((up!=null?up.getText():null));
                            lowerMultiplicity = upperMultiplicity;
                      

                    }
                    break;

            }
            } finally {dbg.exitSubRule(18);}

            dbg.location(612,3);
            RSQUARE26=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_fullMultiplicity577); 
            RSQUARE26_tree = (Object)adaptor.create(RSQUARE26);
            adaptor.addChild(root_0, RSQUARE26_tree);


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
        dbg.location(613, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:635:1: lowerMultiplicity : in= INTEGER ;
    public final PropertyLabelParser.lowerMultiplicity_return lowerMultiplicity() throws RecognitionException {
        PropertyLabelParser.lowerMultiplicity_return retval = new PropertyLabelParser.lowerMultiplicity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token in=null;

        Object in_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "lowerMultiplicity");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(635, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:636:3: (in= INTEGER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:637:3: in= INTEGER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(637,5);
            in=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_lowerMultiplicity629); 
            in_tree = (Object)adaptor.create(in);
            adaptor.addChild(root_0, in_tree);

            dbg.location(638,3);

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
        dbg.location(641, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:643:1: upperMultiplicity : um= unlimitedNatural ;
    public final PropertyLabelParser.upperMultiplicity_return upperMultiplicity() throws RecognitionException {
        PropertyLabelParser.upperMultiplicity_return retval = new PropertyLabelParser.upperMultiplicity_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        PropertyLabelParser.unlimitedNatural_return um = null;



        try { dbg.enterRule(getGrammarFileName(), "upperMultiplicity");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(643, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:644:3: (um= unlimitedNatural )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:645:3: um= unlimitedNatural
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(645,5);
            pushFollow(FOLLOW_unlimitedNatural_in_upperMultiplicity650);
            um=unlimitedNatural();

            state._fsp--;

            adaptor.addChild(root_0, um.getTree());
            dbg.location(646,3);

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
        dbg.location(649, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:651:1: unlimitedNatural returns [int value = 0 ] : ( STAR | in= INTEGER ) ;
    public final PropertyLabelParser.unlimitedNatural_return unlimitedNatural() throws RecognitionException {
        PropertyLabelParser.unlimitedNatural_return retval = new PropertyLabelParser.unlimitedNatural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token in=null;
        Token STAR27=null;

        Object in_tree=null;
        Object STAR27_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "unlimitedNatural");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(651, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:652:3: ( ( STAR | in= INTEGER ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:653:3: ( STAR | in= INTEGER )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(653,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:653:3: ( STAR | in= INTEGER )
            int alt19=2;
            try { dbg.enterSubRule(19);
            try { dbg.enterDecision(19);

            int LA19_0 = input.LA(1);

            if ( (LA19_0==STAR) ) {
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

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:653:5: STAR
                    {
                    dbg.location(653,5);
                    STAR27=(Token)match(input,STAR,FOLLOW_STAR_in_unlimitedNatural678); 
                    STAR27_tree = (Object)adaptor.create(STAR27);
                    adaptor.addChild(root_0, STAR27_tree);

                    dbg.location(653,15);
                     retval.value = -1; 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:654:5: in= INTEGER
                    {
                    dbg.location(654,7);
                    in=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_unlimitedNatural693); 
                    in_tree = (Object)adaptor.create(in);
                    adaptor.addChild(root_0, in_tree);

                    dbg.location(654,19);
                     retval.value = Integer.parseInt(in.getText()); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(19);}


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
        dbg.location(656, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:658:1: defaultValue : EQ dv= expression ;
    public final PropertyLabelParser.defaultValue_return defaultValue() throws RecognitionException {
        PropertyLabelParser.defaultValue_return retval = new PropertyLabelParser.defaultValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQ28=null;
        PropertyLabelParser.expression_return dv = null;


        Object EQ28_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "defaultValue");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(658, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:659:3: ( EQ dv= expression )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:660:3: EQ dv= expression
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(660,3);
            EQ28=(Token)match(input,EQ,FOLLOW_EQ_in_defaultValue719); 
            EQ28_tree = (Object)adaptor.create(EQ28);
            adaptor.addChild(root_0, EQ28_tree);

            dbg.location(660,9);
            pushFollow(FOLLOW_expression_in_defaultValue725);
            dv=expression();

            state._fsp--;

            adaptor.addChild(root_0, dv.getTree());
            dbg.location(661,3);

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
        dbg.location(665, 3);

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
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:676:1: expression returns [String value = \"\"] : ( options {greedy=false; } : id=~ ( LCURLY ) )+ ;
    public final PropertyLabelParser.expression_return expression() throws RecognitionException {
        PropertyLabelParser.expression_return retval = new PropertyLabelParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;


            StringBuffer buffer = new StringBuffer();
           
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(676, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:680:3: ( ( options {greedy=false; } : id=~ ( LCURLY ) )+ )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:681:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(681,4);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:681:4: ( options {greedy=false; } : id=~ ( LCURLY ) )+
            int cnt20=0;
            try { dbg.enterSubRule(20);

            loop20:
            do {
                int alt20=2;
                try { dbg.enterDecision(20);

                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=WS && LA20_0<=EQ)||(LA20_0>=COMMA && LA20_0<=62)) ) {
                    alt20=1;
                }
                else if ( (LA20_0==EOF||LA20_0==LCURLY) ) {
                    alt20=2;
                }


                } finally {dbg.exitDecision(20);}

                switch (alt20) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:685:8: id=~ ( LCURLY )
            	    {
            	    dbg.location(685,10);
            	    id=(Token)input.LT(1);
            	    if ( (input.LA(1)>=WS && input.LA(1)<=EQ)||(input.LA(1)>=COMMA && input.LA(1)<=62) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(id));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(686,5);

            	          buffer.append(id.getText());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt20++;
            } while (true);
            } finally {dbg.exitSubRule(20);}

            dbg.location(690,3);

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
        dbg.location(693, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expression"

    public static class propertyModifiers_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyModifiers"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:700:1: propertyModifiers : LCURLY ( WS )* propertyModifier ( WS )* ( COMMA ( WS )* propertyModifier ( WS )* )* RCURLY ;
    public final PropertyLabelParser.propertyModifiers_return propertyModifiers() throws RecognitionException {
        PropertyLabelParser.propertyModifiers_return retval = new PropertyLabelParser.propertyModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LCURLY29=null;
        Token WS30=null;
        Token WS32=null;
        Token COMMA33=null;
        Token WS34=null;
        Token WS36=null;
        Token RCURLY37=null;
        PropertyLabelParser.propertyModifier_return propertyModifier31 = null;

        PropertyLabelParser.propertyModifier_return propertyModifier35 = null;


        Object LCURLY29_tree=null;
        Object WS30_tree=null;
        Object WS32_tree=null;
        Object COMMA33_tree=null;
        Object WS34_tree=null;
        Object WS36_tree=null;
        Object RCURLY37_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "propertyModifiers");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(700, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:701:3: ( LCURLY ( WS )* propertyModifier ( WS )* ( COMMA ( WS )* propertyModifier ( WS )* )* RCURLY )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:702:3: LCURLY ( WS )* propertyModifier ( WS )* ( COMMA ( WS )* propertyModifier ( WS )* )* RCURLY
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(702,3);
            LCURLY29=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_propertyModifiers868); 
            LCURLY29_tree = (Object)adaptor.create(LCURLY29);
            adaptor.addChild(root_0, LCURLY29_tree);

            dbg.location(702,10);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:702:10: ( WS )*
            try { dbg.enterSubRule(21);

            loop21:
            do {
                int alt21=2;
                try { dbg.enterDecision(21);

                int LA21_0 = input.LA(1);

                if ( (LA21_0==WS) ) {
                    alt21=1;
                }


                } finally {dbg.exitDecision(21);}

                switch (alt21) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:702:11: WS
            	    {
            	    dbg.location(702,11);
            	    WS30=(Token)match(input,WS,FOLLOW_WS_in_propertyModifiers871); 
            	    WS30_tree = (Object)adaptor.create(WS30);
            	    adaptor.addChild(root_0, WS30_tree);


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);
            } finally {dbg.exitSubRule(21);}

            dbg.location(703,3);
             context = IContext.PROPERTY_MODIFIER; 
            dbg.location(704,3);
            pushFollow(FOLLOW_propertyModifier_in_propertyModifiers881);
            propertyModifier31=propertyModifier();

            state._fsp--;

            adaptor.addChild(root_0, propertyModifier31.getTree());
            dbg.location(704,20);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:704:20: ( WS )*
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

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:704:21: WS
            	    {
            	    dbg.location(704,21);
            	    WS32=(Token)match(input,WS,FOLLOW_WS_in_propertyModifiers884); 
            	    WS32_tree = (Object)adaptor.create(WS32);
            	    adaptor.addChild(root_0, WS32_tree);


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);
            } finally {dbg.exitSubRule(22);}

            dbg.location(705,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:705:3: ( COMMA ( WS )* propertyModifier ( WS )* )*
            try { dbg.enterSubRule(25);

            loop25:
            do {
                int alt25=2;
                try { dbg.enterDecision(25);

                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                } finally {dbg.exitDecision(25);}

                switch (alt25) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:706:5: COMMA ( WS )* propertyModifier ( WS )*
            	    {
            	    dbg.location(706,5);
            	     context = IContext.PROPERTY_MODIFIER; 
            	    dbg.location(707,5);
            	    COMMA33=(Token)match(input,COMMA,FOLLOW_COMMA_in_propertyModifiers903); 
            	    COMMA33_tree = (Object)adaptor.create(COMMA33);
            	    adaptor.addChild(root_0, COMMA33_tree);

            	    dbg.location(707,11);
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:707:11: ( WS )*
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

            	    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:707:12: WS
            	    	    {
            	    	    dbg.location(707,12);
            	    	    WS34=(Token)match(input,WS,FOLLOW_WS_in_propertyModifiers906); 
            	    	    WS34_tree = (Object)adaptor.create(WS34);
            	    	    adaptor.addChild(root_0, WS34_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(23);}

            	    dbg.location(707,17);
            	    pushFollow(FOLLOW_propertyModifier_in_propertyModifiers910);
            	    propertyModifier35=propertyModifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, propertyModifier35.getTree());
            	    dbg.location(707,34);
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:707:34: ( WS )*
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

            	    	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:707:35: WS
            	    	    {
            	    	    dbg.location(707,35);
            	    	    WS36=(Token)match(input,WS,FOLLOW_WS_in_propertyModifiers913); 
            	    	    WS36_tree = (Object)adaptor.create(WS36);
            	    	    adaptor.addChild(root_0, WS36_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(24);}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);
            } finally {dbg.exitSubRule(25);}

            dbg.location(709,3);
            RCURLY37=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_propertyModifiers925); 
            RCURLY37_tree = (Object)adaptor.create(RCURLY37);
            adaptor.addChild(root_0, RCURLY37_tree);


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
        dbg.location(710, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "propertyModifiers");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "propertyModifiers"

    public static class propertyModifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyModifier"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:720:1: propertyModifier : ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty ) ;
    public final PropertyLabelParser.propertyModifier_return propertyModifier() throws RecognitionException {
        PropertyLabelParser.propertyModifier_return retval = new PropertyLabelParser.propertyModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal38=null;
        Token string_literal39=null;
        Token string_literal40=null;
        Token string_literal41=null;
        Token string_literal42=null;
        Token string_literal43=null;
        PropertyLabelParser.subsetsProperty_return subsetsProperty44 = null;

        PropertyLabelParser.redefinesProperty_return redefinesProperty45 = null;


        Object string_literal38_tree=null;
        Object string_literal39_tree=null;
        Object string_literal40_tree=null;
        Object string_literal41_tree=null;
        Object string_literal42_tree=null;
        Object string_literal43_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "propertyModifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(720, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:721:3: ( ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty ) )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:722:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(722,3);
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:722:3: ( 'readOnly' | 'union' | 'ordered' | 'unique' | 'nonunique' | 'subsets' subsetsProperty | redefinesProperty )
            int alt26=7;
            try { dbg.enterSubRule(26);
            try { dbg.enterDecision(26);

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
                    new NoViableAltException("", 26, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(26);}

            switch (alt26) {
                case 1 :
                    dbg.enterAlt(1);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:723:5: 'readOnly'
                    {
                    dbg.location(723,5);
                    string_literal38=(Token)match(input,56,FOLLOW_56_in_propertyModifier965); 
                    string_literal38_tree = (Object)adaptor.create(string_literal38);
                    adaptor.addChild(root_0, string_literal38_tree);

                    dbg.location(723,17);
                     isReadOnly = true; modifiersUsed.put("readOnly", true);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:724:5: 'union'
                    {
                    dbg.location(724,5);
                    string_literal39=(Token)match(input,57,FOLLOW_57_in_propertyModifier974); 
                    string_literal39_tree = (Object)adaptor.create(string_literal39);
                    adaptor.addChild(root_0, string_literal39_tree);

                    dbg.location(724,15);
                     isDerivedUnion = true; modifiersUsed.put("union", true);  

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:725:5: 'ordered'
                    {
                    dbg.location(725,5);
                    string_literal40=(Token)match(input,58,FOLLOW_58_in_propertyModifier984); 
                    string_literal40_tree = (Object)adaptor.create(string_literal40);
                    adaptor.addChild(root_0, string_literal40_tree);

                    dbg.location(725,15);
                     isOrdered = true; modifiersUsed.put("ordered", true); 

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:726:5: 'unique'
                    {
                    dbg.location(726,5);
                    string_literal41=(Token)match(input,59,FOLLOW_59_in_propertyModifier992); 
                    string_literal41_tree = (Object)adaptor.create(string_literal41);
                    adaptor.addChild(root_0, string_literal41_tree);

                    dbg.location(726,15);
                     isUnique = true; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:727:5: 'nonunique'
                    {
                    dbg.location(727,5);
                    string_literal42=(Token)match(input,60,FOLLOW_60_in_propertyModifier1001); 
                    string_literal42_tree = (Object)adaptor.create(string_literal42);
                    adaptor.addChild(root_0, string_literal42_tree);

                    dbg.location(727,17);
                     isUnique = false; modifiersUsed.put("unique", true); modifiersUsed.put("nonunique", true);

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:728:5: 'subsets' subsetsProperty
                    {
                    dbg.location(728,5);
                    string_literal43=(Token)match(input,61,FOLLOW_61_in_propertyModifier1009); 
                    string_literal43_tree = (Object)adaptor.create(string_literal43);
                    adaptor.addChild(root_0, string_literal43_tree);

                    dbg.location(728,15);
                     context = IContext.SUBSET_PROPERTY ; 
                    dbg.location(728,56);
                    pushFollow(FOLLOW_subsetsProperty_in_propertyModifier1013);
                    subsetsProperty44=subsetsProperty();

                    state._fsp--;

                    adaptor.addChild(root_0, subsetsProperty44.getTree());

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:729:5: redefinesProperty
                    {
                    dbg.location(729,5);
                    pushFollow(FOLLOW_redefinesProperty_in_propertyModifier1021);
                    redefinesProperty45=redefinesProperty();

                    state._fsp--;

                    adaptor.addChild(root_0, redefinesProperty45.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(26);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
        dbg.location(731, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "propertyModifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "propertyModifier"

    public static class subsetsProperty_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subsetsProperty"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:742:1: subsetsProperty : id= IDENTIFIER ;
    public final PropertyLabelParser.subsetsProperty_return subsetsProperty() throws RecognitionException {
        PropertyLabelParser.subsetsProperty_return retval = new PropertyLabelParser.subsetsProperty_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;

        Object id_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "subsetsProperty");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(742, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:743:3: (id= IDENTIFIER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:744:3: id= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(744,5);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_subsetsProperty1173); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(745,3);

                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findSubsettedPropertyByName(propertyName, property); 
                subsettedProperties.add(tmpProperty); 
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
        dbg.location(751, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "subsetsProperty");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "subsetsProperty"

    public static class redefinesProperty_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "redefinesProperty"
    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:761:1: redefinesProperty : 'redefines' id= IDENTIFIER ;
    public final PropertyLabelParser.redefinesProperty_return redefinesProperty() throws RecognitionException {
        PropertyLabelParser.redefinesProperty_return retval = new PropertyLabelParser.redefinesProperty_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token string_literal46=null;

        Object id_tree=null;
        Object string_literal46_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "redefinesProperty");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(761, 1);

        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:762:3: ( 'redefines' id= IDENTIFIER )
            dbg.enterAlt(1);

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:763:3: 'redefines' id= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(763,3);
             context = IContext.REDEFINE_PROPERTY ; 
            dbg.location(763,46);
            string_literal46=(Token)match(input,62,FOLLOW_62_in_redefinesProperty1212); 
            string_literal46_tree = (Object)adaptor.create(string_literal46);
            adaptor.addChild(root_0, string_literal46_tree);

            dbg.location(763,58);
             context = IContext.REDEFINE_PROPERTY ; 
            dbg.location(763,103);
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_redefinesProperty1218); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            dbg.location(764,3);

                // find property by name
                String propertyName = id.getText();
                Property tmpProperty = findRedefinedPropertyByName(propertyName, property); 
                redefinedProperties.add(tmpProperty); 
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
        dbg.location(770, 3);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "redefinesProperty");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "redefinesProperty"

    // Delegated rules


 

    public static final BitSet FOLLOW_WS_in_label46 = new BitSet(new long[]{0x0000000000000FD0L});
    public static final BitSet FOLLOW_visibility_in_label53 = new BitSet(new long[]{0x0000000000000FD0L});
    public static final BitSet FOLLOW_WS_in_label56 = new BitSet(new long[]{0x0000000000000FD0L});
    public static final BitSet FOLLOW_isDerived_in_label68 = new BitSet(new long[]{0x0000000000000FD0L});
    public static final BitSet FOLLOW_WS_in_label71 = new BitSet(new long[]{0x0000000000000FD0L});
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
    public static final BitSet FOLLOW_LCURLY_in_propertyModifiers868 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers871 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers881 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers884 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_COMMA_in_propertyModifiers903 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers906 = new BitSet(new long[]{0x7F00000000000010L});
    public static final BitSet FOLLOW_propertyModifier_in_propertyModifiers910 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_WS_in_propertyModifiers913 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_RCURLY_in_propertyModifiers925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_propertyModifier965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_propertyModifier974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_propertyModifier984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_propertyModifier992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_propertyModifier1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_propertyModifier1009 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_subsetsProperty_in_propertyModifier1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_redefinesProperty_in_propertyModifier1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_subsetsProperty1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_redefinesProperty1212 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENTIFIER_in_redefinesProperty1218 = new BitSet(new long[]{0x0000000000000002L});

}