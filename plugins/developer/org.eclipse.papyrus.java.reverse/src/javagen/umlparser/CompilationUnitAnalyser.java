/**
 * 
 */
package javagen.umlparser;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.Node;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.JavadocComment;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.QualifiedNameExpr;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.VoidType;
import japa.parser.ast.type.WildcardType;
import japa.parser.ast.visitor.GenericVisitorAdapter;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javagen.umlparser.TypeAnalyser.TypeData;
import javagen.umlparser.TypeAnalyserAndTranslator.TranslatedTypeData;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * A visitor filling the provided UML model
 * @author dumoulin
 *
 */
public class CompilationUnitAnalyser  {


    public static String DEFAULT_GENERATION_PACKAGE_NAME = "generated";
    public static String DEFAULT_ROOT_PACKAGE_NAME = "model";
	private List<String> generationPackageQualifiedName;
	
    /** Root package of the generation. All generated elements wiil be added to this package, or one of
     * its subpackages
     */
    private org.eclipse.uml2.uml.Package defaultGenerationPackage;
    /**
     * Catalog used to get the package needed for a creation.
     */
    private CreationPackageCatalog creationPackageCatalog;

    /** */
    private ClassifierCatalog classifierCatalog;
    private ImportedTypeCatalog importedTypes;

	/**
	 * The Package containing the current compilation unit.
	 * Initialized at the beginning of exploreCompilationUnit()
	 */
	private Package currentCompilationUnitPackage;

	/**
	 * Visitor used to parse qualified names.
	 */
	private QualifiedNameParser qualifiedNameParser = new QualifiedNameParser();
	
	private TypeAnalyserAndTranslator typeAnalyser;
	/** Model where all element are created */
	
	/**
	 * Constructor.
	 */
	public CompilationUnitAnalyser(Resource model) {
		
        this(model, DEFAULT_ROOT_PACKAGE_NAME, DEFAULT_GENERATION_PACKAGE_NAME, null);
	}

	/**
	 * 
	 * Constructor.
	 */
	public CompilationUnitAnalyser(Resource model, String generatePackageName, List<String> searchPaths) {

		this(model, DEFAULT_ROOT_PACKAGE_NAME, generatePackageName, searchPaths);
	}

	/**
	 * 
	 * Constructor.
	 */
	public CompilationUnitAnalyser(Resource model, String modelRootPackageName, String generatePackageName, List<String> searchPaths) {

	    Package modelRootPackage = UmlUtils.getPackage(model, dirToQualifiedName(modelRootPackageName));
        initCompilationUnitAnalyser(modelRootPackage, generatePackageName, searchPaths);
	}

    /**
     * 
     * Constructor.
     * All provided paths and searchpaths are relative to the specified modelRootPackage.
     */
    public CompilationUnitAnalyser(Package modelRootPackage, String generatePackageName, List<String> searchPaths) {

//        this.model = model;

        initCompilationUnitAnalyser(modelRootPackage, generatePackageName, searchPaths);
    }

    /**
     * Initialize the class. Called by constructors.
     * @param modelRootPackage
     * @param generatePackageName
     * @param searchPaths
     */
    private void initCompilationUnitAnalyser(Package modelRootPackage, String generatePackageName, List<String> searchPaths) {
        if(generatePackageName==null)
        {
            generatePackageName = DEFAULT_GENERATION_PACKAGE_NAME;
        }
        
        this.generationPackageQualifiedName = dirToQualifiedName(generatePackageName);


        // Copy searchpath in order to be able to change it.
        if(searchPaths != null)
            searchPaths = new ArrayList<String>(searchPaths);
        else
            searchPaths = new ArrayList<String>();

        // Add generation package in search paths
        if(!searchPaths.contains(generatePackageName))
            searchPaths.add(generatePackageName);

        System.out.println(this.getClass().getSimpleName() + ".CT("+generationPackageQualifiedName+ ", sarchpaths="+searchPaths+")");


        createDefaultGenerationPackage(modelRootPackage);
        
        classifierCatalog = new ClassifierCatalog( modelRootPackage, searchPaths);
        importedTypes = new ImportedTypeCatalog();
        creationPackageCatalog = new CreationPackageCatalog(modelRootPackage, defaultGenerationPackage, null);

        typeAnalyser = new TypeAnalyserAndTranslator(importedTypes);
    }


	
	/**
	 * Get the qualified name from a directory like name.
	 * Name is splitted arround '/'
	 * @param name
	 * @return
	 */
	private List<String> dirToQualifiedName(String qname)
	{
	  String[] splittedName = qname.split("/");	
	  return Arrays.asList(splittedName);
	}

    /**
     * Create the root element in which all element will be created.
     */
    private void createDefaultGenerationPackage(Resource model ) {
        
        Package p = UmlUtils.getPackage(model, generationPackageQualifiedName );
        defaultGenerationPackage = p;
    }

    /**
     * Create the root element in which all element will be created.
     */
    private void createDefaultGenerationPackage(Package rootModelElement ) {
        
        Package p = UmlUtils.getPackage(rootModelElement, generationPackageQualifiedName );
        defaultGenerationPackage = p;
    }

	/**
     * Explore the CU and create the declared types
     * 
     * @param cu
     */
    public void processCompilationUnit(CompilationUnit cu) {

        // First, find the parent Package
        Package cuPackage = getCuPackage(cu.getPakage());
        currentCompilationUnitPackage = cuPackage;
        classifierCatalog.setCurrentCompilationUnitPackage(currentCompilationUnitPackage);
 
        // Add imports
        importedTypes.clear();
        if (cu.getImports() != null)
            addImports(importedTypes, cu.getImports());

        // Now, explore each type declared type in the cu
        if (cu.getTypes() != null) {
            // for (Iterator<TypeDeclaration> i = cu.getTypes().iterator();
            // i.hasNext();)
            for (TypeDeclaration typeDecl : cu.getTypes()) {
                // Process each kind of type
                processTypedeclaration(cuPackage, typeDecl);
            } // end loop
        } // end if

    }

	/**
	 * Process Typedeclaration 2 Classifier.
	 * Process common parts : modifiers, members, ...
	 * 
	 * @param parentPackage
	 * @param typeDecl
	 */
	private void processTypedeclaration(final Package parentPackage, TypeDeclaration typeDecl) {
		Classifier classifier;
		
		// Process right type
		// Create the corresponding type.
		classifier = new GenericSwitchVisitor<Classifier, Package>(){
			
			@Override
			public Classifier visit(ClassOrInterfaceDeclaration n, Package parentPackage) {
				return processClassOrInterfaceDeclaration(n, parentPackage);
			}
			
			// TODO Other kind of types
		}.doSwitch(typeDecl, parentPackage);
		
		// Set Visibility
		createModifiers(classifier, typeDecl.getModifiers());

		// Template parameters
		// TODO
		
		// Explore members
		if (typeDecl.getMembers() != null) {
			for(BodyDeclaration member : typeDecl.getMembers() )
			{
				new SwitchVisitor<Type>(){

					@Override
					public void visit(FieldDeclaration n, Type classifier) 
					{
						createAttributes(n, classifier);
					}
					
					@Override
					public void visit(MethodDeclaration n, Type classifier) {
					    processMethod(n, (Classifier)classifier);
					}
					/**
					 * Inner classes ?
					 * @param n
					 * @param arg
					 */
					@Override
					public void visit(ClassOrInterfaceDeclaration n, Type arg) {
					    System.out.println("Found nested class (ClassOrInterface)'" + n.getName() + "'");
					    // TODO Create nested classes in the parent Class.
					    processTypedeclaration(parentPackage, n);
//					    processClassOrInterfaceDeclaration(n, parent)
					    super.visit(n, arg);
					}
                    // TODO Other kind of members
				}.doSwitch(member, classifier);
			}

		}
	}

    /**
	 * Add all the imports to the manager.
	 * @param importedTypes2
	 * @param imports
	 */
	private void addImports(ImportedTypeCatalog importedTypes, List<ImportDeclaration> imports) {


		for(ImportDeclaration decl : imports)
		{
			List<String> qualifiedName = qualifiedNameParser.getImportQualifiedName(decl);
			if(decl.isAsterisk())
				qualifiedName.add("*");
			importedTypes.addImport(qualifiedName);
		}
		
	}

	/**
	 * Get (lookup or create) the specified classifier.
	 * Translate the qualifiedName according to imports, and lookup in classifierCatalog .
	 * If nothing is found and provided name is not qualified, create/get in parent, otherwise create/get in root 
	 * using the qualified name.
	 * @param qualifiedName
	 * @param isInterface What should be created if nothing is found ? An interface or a Class ?
	 * @return
	 */
	private Classifier getUmlClassifier(List<String> qualifiedName, boolean isInterface) {
		// Get the corresponding type
	    // TODO specify requested type
		Classifier foundClass = classifierCatalog.getClassifier(qualifiedName);

		// If nothing found, create it
		if(foundClass == null )
		{// Not yet created.
			EClass expectedType;
			if(isInterface)
				expectedType = UMLPackage.eINSTANCE.getInterface();
			else
				expectedType = UMLPackage.eINSTANCE.getClass_();
				
			// Check where to create
			if( qualifiedName.size() == 1&& currentCompilationUnitPackage != null)
			{  // No scope in qname, create it in current namespace.
			    // TODO use current namespace instead of current package.
			    // TODO change to create (avoid second lookup)
				foundClass = UmlUtils.getClassifier(currentCompilationUnitPackage, qualifiedName, expectedType);
			}
			else
			{
			    //create with specified qname
			    // First get the package where to create it, according to its name
			    Package creationPackage = creationPackageCatalog.getCreationPackage(qualifiedName);
			    // Now, create it.
				foundClass = UmlUtils.getClassifier(creationPackage, qualifiedName, expectedType);
			}
		}
		return foundClass;
	}

	/**
	 * Get the type qualified name from its ast description
	 * @param astType
	 * @return
	 */
	private List<String> getQualifiedName(ClassOrInterfaceType astType) {
		QualifiedNameParser visitor = new QualifiedNameParser();
		
		List res = visitor.getClassOrInterfaceQualifiedName(astType);
		return res;
	}

	/**
	 * Create all attributes and add it to the parent.
	 * @param n
	 * @param parent
	 */
	protected void createAttributes(FieldDeclaration n, Type parent) {
 
		System.out.println("getAttributeType( from:" + n.getType().getClass().getName() + ")");
    	
		// Get data about the type
		TranslatedTypeData typeData = processType(n.getType());
    	Type umlType = getUmlType(typeData);
    	
    	// walk on variable declarations.
    	for( VariableDeclarator var : n.getVariables() )
    	{
    		if(parent instanceof Classifier)
    			createAttribute(n, var, (Classifier)parent, umlType, typeData);
     	}
 	}

    /**
     * @param n
     * @return
     */
    private TranslatedTypeData processType(japa.parser.ast.type.Type astType) {
        TranslatedTypeData data = typeAnalyser.getTranslatedTypeData(astType);
        
        return data;
    }
    
    /**
     * Get the uml type from the translated type.
     * @param data
     * @return
     */
    private Type getUmlType(TranslatedTypeData data)
    {
    	// Get the uml type
		Type umlType = null;
    	if(data.isPrimitive)
    	{
			umlType = classifierCatalog.getClassifier(data.qualifiedName);
			if(umlType == null)
			{
			    Package creationPackage = creationPackageCatalog.getCreationPackage(data.qualifiedName);
				umlType = UmlUtils.getPrimitive(creationPackage, data.qualifiedName);
			}
    	}
    	else if( data.isVoid || data.isWildcard)
    	{
    	    return null;
    	}
    	else
    	{
    		// Look for existing classifier of any type.
    		// 
    		  umlType =  getUmlClassifier(data.getTranslatedQualifiedName(), false);
    	}
        return umlType;
    }

	/**
	 * Get the Type from an ast.Type node.
	 * @param astType
	 * @return
	 */
	protected TypeData getAttributeType(japa.parser.ast.type.Type astType){
		
		TypeData res = new TypeData();
		
		new SwitchVisitor<TypeData>() {
			
			/**
			 * Get type from a class.
			 */
			@Override
			public void visit(ClassOrInterfaceType n, TypeData data) {
				List<String> qnameBefore = getQualifiedName(n);
				List<String> qname = importedTypes.getQualifiedName(qnameBefore);
								
				data.qualifiedName = qname;
				// Check for generic parameters
				if(n.getTypeArgs() != null)
				{
					data.genericData = new ArrayList<TypeData>();
					for(japa.parser.ast.type.Type arg : n.getTypeArgs())
					{
						TypeData argData = new TypeData();
						arg.accept(this, argData);
						data.genericData.add(argData);
					}
				}
			}
			
			@Override
			public void visit(ReferenceType n, TypeData data) {
				// skip the reference node and process the child.
			    // Should not appear in an type use (in Attribute or method)
				data.arrayCount = n.getArrayCount();
				n.getType().accept(this, data);
			}
			
			@Override
			public void visit(PrimitiveType n, TypeData data) {
				String qnameBefore = getPrimitiveName(n);
				List<String> qname = importedTypes.getQualifiedName(qnameBefore);
			
				data.qualifiedName = qname;
				data.isPrimitive = true;
			}
			@Override
			public void visit(WildcardType n, TypeData data) {
				data.isWildcard = true;
		        if (n.getExtends() != null) {
		            data.extends_ = new TypeData();
		            n.getExtends().accept(this, data.extends_);
		        }
		        if (n.getSuper() != null) {
		            data.super_ = new TypeData();
		            n.getSuper().accept(this, data.super_);
		        }

			}
			
			@Override
			public void visit(VoidType n, TypeData data) {
				// TODO Auto-generated method stub
				data.isVoid = true;
			}
				   			
		}.doSwitch(astType, res);
		
		return res;
	}
	
	/**
	 * Data structure to return data about a Declared type.
	 * @author dumoulin
	 *
	 */
	protected class TypeData {
		List<String> qualifiedName;
		/** template parameters */
		protected List<TypeData> genericData;		
		boolean isInterface=false;
		/** PrimitiveType */
		boolean isPrimitive=false;
		/** ReferenceType */ 
		protected int arrayCount;
		/** For Wildcard */
		protected boolean isWildcard=false;
		protected TypeData extends_;
		protected TypeData super_;
		/** VoidType */
		protected boolean isVoid = false;
	}
	
	/**
	 * Create the uml2.primitivetype denoted by the specified PrimitiveType
	 * @param n
	 * @return
	 */
	protected String getPrimitiveName(PrimitiveType n) {
		String typeName = null;
		
	     switch (n.getType()) {
         case Boolean:
        	 typeName = "Boolean";
             break;
         case Byte:
        	 typeName = "Byte";
             break;
         case Char:
        	 typeName = "Char";
             break;
         case Double:
        	 typeName = "Double";
             break;
         case Float:
        	 typeName = "Float";
             break;
         case Int:
        	 typeName = "Integer";
             break;
         case Long:
        	 typeName = "Long";
             break;
         case Short:
        	 typeName = "Short";
             break;
     }

	     return typeName;
	}

	/**
	 * Create an attribute and add it to the parent.
	 * 
	 * @param n node declaring type and modifiers
	 * @param var
	 * @param parent
	 * @param type
	 */
	protected void createAttribute(FieldDeclaration n, VariableDeclarator var, Classifier parent, Type type, TranslatedTypeData typeData) {
	    
		// get with no type, and then update type.
       Property property = UmlUtils.createProperty((Classifier)parent, null, var.getId().getName(), var.getId().getArrayCount());
       property.setType(type);
       processJavadoc(n.getJavaDoc(), property);
       processModifiers(n.getModifiers(), property);
       if( typeData.isCollection() )
       {
           property.setLower(typeData.getTranslatedLower());
           property.setUpper(typeData.getTranslatedUpper());
       }
	}

    /**
     * Process modifiers for Operation
     * 
     * @param modifiers
     * @param property
     */
    private void processModifiers(int modifiers, Operation property) {
        if (ModifierSet.isAbstract(modifiers)) {
            property.setIsAbstract(true);
        }
        processModifiers(modifiers, (Feature) property);
    }

    /**
     * Process modifiers
     * 
     * @param modifiers
     * @param property
     */
    private void processModifiers(int modifiers, Feature property) {
        // TODO Auto-generated method stub
        if (ModifierSet.isPrivate(modifiers)) {
            property.setVisibility(VisibilityKind.PRIVATE_LITERAL);
        }
        if (ModifierSet.isProtected(modifiers)) {
            property.setVisibility(VisibilityKind.PROTECTED_LITERAL);
        }
        if (ModifierSet.isPublic(modifiers)) {
            property.setVisibility(VisibilityKind.PUBLIC_LITERAL);
        }
        if (ModifierSet.isStatic(modifiers)) {
            property.setIsStatic(true);
        }
        if (ModifierSet.isFinal(modifiers)) {
            property.setIsLeaf(true);
        }
//         if (ModifierSet.isNative(modifiers)) {
//         printer.print("native ");
//         }
//         if (ModifierSet.isStrictfp(modifiers)) {
//         printer.print("strictfp ");
//         }
//         if (ModifierSet.isSynchronized(modifiers)) {
//         printer.print("synchronized ");
//         }
//        if (ModifierSet.isTransient(modifiers)) {
//            property.set(true);
//        }
        // if (ModifierSet.isVolatile(modifiers)) {
        // printer.print("volatile ");
        // }
    }

    /**
     * Process modifiers
     * 
     * @param modifiers
     * @param property
     */
    private void processModifiers(int modifiers, org.eclipse.uml2.uml.Parameter property) {
        // TODO Auto-generated method stub
        if (ModifierSet.isPrivate(modifiers)) {
            property.setVisibility(VisibilityKind.PRIVATE_LITERAL);
        }
        if (ModifierSet.isProtected(modifiers)) {
            property.setVisibility(VisibilityKind.PROTECTED_LITERAL);
        }
        if (ModifierSet.isPublic(modifiers)) {
            property.setVisibility(VisibilityKind.PUBLIC_LITERAL);
        }
        if (ModifierSet.isFinal(modifiers)) {
            property.setDirection(ParameterDirectionKind.IN_LITERAL);
        }
    }
    
    private class MethodParameterData {
        TranslatedTypeData dataType;
        Type umlType;
        Parameter astParameter;
    }
    
    /**
     * Process method to be added to the provided classifier.
     * @param n
     * @param classifier
     */
    protected void processMethod(MethodDeclaration n, Classifier classifier) {
        
        // Get parameters to have a signature
        // Parameters
        List<Type> signature = new ArrayList<Type>();
        
        if (n.getParameters() != null) {
            List<MethodParameterData> paramDatas = new ArrayList<MethodParameterData>();
            
            for (Parameter param : n.getParameters()) {
                MethodParameterData data = new MethodParameterData();
                data.dataType = processType(param.getType());
                data.umlType = getUmlType(data.dataType);
                data.astParameter = param;
                paramDatas.add(data);
                signature.add(data.umlType);
            }
        }
        
//        Operation method = UmlUtils.getOperation(classifier, n.getName());
        Operation method = getUmlOperation(classifier, n.getName(), signature);
        
        processJavadoc(n.getJavaDoc(), method);
        processAnnotation(n.getAnnotations(), method);
        processModifiers(n.getModifiers(), method);
        TranslatedTypeData typeData = processType(n.getType());
        Type methodType = getUmlType(typeData);

        if(methodType != null){
            method.setType(methodType);
            if( typeData.isCollection() )
            {
            method.setLower(typeData.getTranslatedLower());
            method.setUpper(typeData.getTranslatedUpper());
            }
        }
        
        // Parameters
        if (n.getParameters() != null) {
            for (Parameter param : n.getParameters()) {
                processMethodParameter(param, method);
            }
        }
}

    /**
     * Get an operation by its signature
     * @param classifier
     * @param name
     * @param signature
     * @return
     */
    private Operation getUmlOperation(Classifier classifier, String name, List<Type> signature) {
        List<Operation> list = classifier.getOperations();
        
        // walk all operations with the same name.
        // Check signature matching
        for(Operation oper : list)
        {
            
            if( isSameOperation(oper, name, signature) )
            {
                return oper;
            }
        }
        // Not found, create a new one (without signature)
        return UmlUtils.createOperation(classifier, name);
    }

    /**
     * @param oper
     * @param name
     * @param signature
     */
    private boolean isSameOperation(Operation oper, String name, List<Type> signature) {
 
    	// check name
    	if(!name.equals(oper.getName()))
        	return false;
        
     // Check parameters
            List<org.eclipse.uml2.uml.Parameter> umlParams = oper.getOwnedParameters();
            // Check signature
            if(signature == null )
            {
                return true;
            }
            else if(umlParams == null)
            {
            	if(signature.size()==0)
            		return true;
            	else
            		return false;
            }
            else if( /*signature!= null && */ umlParams != null )
            {
                int umlParamIndex=0;
                for(Type signatureType : signature)
                {
                    try {
                        // Compare type
                        org.eclipse.uml2.uml.Parameter param = umlParams.get(umlParamIndex++);
                        // skip return parameter
                        while(param.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
                        	param = umlParams.get(umlParamIndex++);

                        // Check types, skip if existing type is null
                        Type existingType = param.getType();
                        if(existingType != null && !(existingType.getName().equals( signatureType.getName() ) ) )
                        {
                            // umlParamIndex > umlParams.getSize()
                            return false;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        
                        return false;
                     }
                }
                // Check if there still some type in umlParams
                // if index is the last one: ok
                // otherwise, check if remaining arguments are only returns.
            	while(umlParamIndex < umlParams.size())
            	{
            		if(umlParams.get(umlParamIndex++).getDirection() != ParameterDirectionKind.RETURN_LITERAL )
            		{
            			return false;
            		}
            	}
                // same
                return true;
            }

        return false;
    }

    /**
     * Process a parameter.
     * @param param
     * @param method
     */
    private void processMethodParameter(Parameter param, Operation method) {
        
        TranslatedTypeData typeData = processType(param.getType());
        Type type = getUmlType(typeData);
        
        System.out.println("getOwnedParameter("+method.getName()+"= " +param.getId().getName()+", "+type+" )");
        org.eclipse.uml2.uml.Parameter umlParameter = method.getOwnedParameter(param.getId().getName(), type, true, true);

        if(typeData.isCollection())
        {
        umlParameter.setLower(typeData.getTranslatedLower());
        umlParameter.setUpper(typeData.getTranslatedUpper());
        }
        processModifiers(param.getModifiers(), umlParameter);
        processAnnotation(param.getAnnotations(), method);
        
    }

    /**
     * Process annotation.
     * @param annotations
     * @param method
     */
    private void processAnnotation(List<AnnotationExpr> annotations, Element method) {
        // TODO Auto-generated method stub
        // Set annotation as stereotype ?
    }

    /**
     * Process javadoc.
     * @param javaDoc
     * @param method
     */
	private void processJavadoc(JavadocComment javaDoc, Element umlElement) {
	    if(javaDoc==null)
	        return;
	    
	    Comment comment;
	    // Check if a comment already exists.
	    List<Comment> ownedComments = umlElement.getOwnedComments();
	    if(ownedComments != null && ownedComments.size()>0)
	    {
	    	comment = ownedComments.get(0);
	    }
	    else
	    { // Create a new comment
            comment = umlElement.createOwnedComment();
	    }
	    
	    // Set the body
        comment.setBody(javaDoc.getContent() );
    }

    /**
	 * Create an interface and return it.
	 * Only need to create the object and fill it with data available at this level.
	 * @param parent
	 * @param n
	 * @return
	 */
	protected Class createClass(Package parent, ClassOrInterfaceDeclaration n) {
    	System.out.println("getClass( " + n.getName() + " )");
        return UmlUtils.getClass(parent, n.getName());
	}

	/**
	 * Create an interface and return it.
	 * Only need to create the object and fill it with data available at this level.
	 * @param parent
	 * @param n
	 * @return
	 */
	protected Interface createInterface(Package parent, ClassOrInterfaceDeclaration n) {
    	System.out.println("getInterface( " + n.getName() + " )");
        return UmlUtils.getInterface(parent, n.getName());
	}

	/**
	 * get (lookup or create) the packages containing the CU.
	 * @param cu
	 * @return
	 */
	private Package getCuPackage(PackageDeclaration packageDecl) {
		
		// If null, return the generation root
        if (packageDecl == null) {
            return defaultGenerationPackage;
        }
        
        CreatePackage visitor = new CreatePackage();
        Package res = visitor.getPackage(packageDecl, defaultGenerationPackage);
        
        return res;
	}

	private void createModifiers(Classifier c, int modifiers) {
		// TODO Auto-generated method stub
        if (ModifierSet.isPrivate(modifiers)) {
            c.setVisibility(VisibilityKind.PRIVATE_LITERAL);
        }
        if (ModifierSet.isProtected(modifiers)) {
            c.setVisibility(VisibilityKind.PROTECTED_LITERAL);
        }
        if (ModifierSet.isPublic(modifiers)) {
            c.setVisibility(VisibilityKind.PUBLIC_LITERAL);
        }
        if (ModifierSet.isAbstract(modifiers)) {
            c.setIsAbstract(true);
        }
//        if (ModifierSet.isStatic(modifiers)) {
//            c.get
//        }
        if (ModifierSet.isFinal(modifiers)) {
            c.setIsLeaf(true);
        }
//        if (ModifierSet.isNative(modifiers)) {
//            printer.print("native ");
//        }
//        if (ModifierSet.isStrictfp(modifiers)) {
//            printer.print("strictfp ");
//        }
//        if (ModifierSet.isSynchronized(modifiers)) {
//            printer.print("synchronized ");
//        }
//        if (ModifierSet.isTransient(modifiers)) {
//            printer.print("transient ");
//        }
//        if (ModifierSet.isVolatile(modifiers)) {
//            printer.print("volatile ");
//        }

	}

	
	/**
	 * Process Class or Interface declaration
	 * @param n
	 * @param parent
	 * @return
	 */
	private Classifier processClassOrInterfaceDeclaration( ClassOrInterfaceDeclaration n, Package parent) {
		Classifier processedClass;
		if(n.isInterface())
		{
		  processedClass = createInterface(parent, n);
		}
		else
		{
		  processedClass = createClass(parent, n);
		}
		
		// Comments
		processJavadoc(n.getJavaDoc(), processedClass);
		
		// Extends parameters
		if (n.getExtends() != null) {
			for(ClassOrInterfaceType type : n.getExtends() )
			{ // Get the type
				List<String> qualifiedName = getQualifiedName(type);
				qualifiedName = importedTypes.getQualifiedName(qualifiedName);
				Classifier generalization = getUmlClassifier(qualifiedName, n.isInterface());
				// create the generalization
				UmlUtils.getGeneralization(processedClass, generalization);
			}
		}    
		
		// Extends parameters
		if (n.getImplements() != null) {
			for(ClassOrInterfaceType type : n.getImplements() )
			{
				List<String> qualifiedName = getQualifiedName(type);
				qualifiedName = importedTypes.getQualifiedName(qualifiedName);
				Classifier generalization = getUmlClassifier(qualifiedName, true);
				// create the generalization
				UmlUtils.getRealization(parent, processedClass, generalization);
			}
		}    
		
		
		return processedClass;
	}


	/**
	 * Visitor used to create Types
	 * @author dumoulin
	 *
	 */
	protected class CreateVisitor extends GenericVisitorAdapter<Type, Package> {
		
		/**
		 * Create the type corresponding to the provided declaration.
		 * Main entry point i
		 * @param parent
		 * @param typeDecl
		 * @return
		 */
		public Type createType(Package parent, TypeDeclaration typeDecl) {
			CreateVisitor visitor = new CreateVisitor();
			
			Type res = typeDecl.accept(visitor, parent);
			return res;
		}
		
		/**
		 * Create class or interface
		 */
		@Override
		public Type visit(ClassOrInterfaceDeclaration n, Package parent) {
			
			Classifier res;
			// Create the class
	        if (n.isInterface()) {
	        	System.out.println("getInterface( " + n.getName() + " )");
	             res = UmlUtils.getInterface(parent, n.getName());
	        } else {
	        	System.out.println("getClass( " + n.getName() + " )");
	             res = UmlUtils.getClass(parent, n.getName());
	        }
	        
	        // Set Visibility
	        createModifiers(res, n.getModifiers());
            return res;
		}

	}
	
	/**
	 * Visitor used to create Package from a qualified names
	 * Example : javagen.parser
	 * trace : 
	 *   - visitQualifiedName( parser )
	 *   - visitName( javagen )
	 * @author dumoulin
	 *
	 */
	protected class CreatePackage extends VoidVisitorAdapter<List<String>> {

		
		/**
		 * Create or find the packages corresponding to the qualified name.
		 * This is the main method to be called
		 * @param decl
		 * @param parent
		 * @return
		 */
		public Package getPackage(PackageDeclaration decl, Package parent)
		{
			List<String> names = new ArrayList<String>();
			
			// Create a list of names in proper order.
			decl.accept(this, names);
			
			Package p = parent;
			// iterate on names
			for(String packageName : names)
			{
				p = UmlUtils.getPackage(p, packageName);
			}
			return p;
		}
		
		/**
		 * Create the package part
		 */
		@Override
		public void visit(NameExpr n, List<String> names) {
//			System.out.println("visitName( " + n.getName() + " )");
			// Add in head, because elements are found in reverse order.
			names.add(0, n.getName());
			super.visit(n, names);
		}
		
		/**
		 * 
		 */
		@Override
		public void visit(QualifiedNameExpr n, List<String> names) {
//			System.out.println("visitQualifiedName( " + n.getName() + " )");
			// Add in head, because elements are found in reverse order.
			names.add(0, n.getName());
			super.visit(n, names);
		}
	}

	/**
	 * Visitor used to create a qualified name from ClassOrInterfaceType
	 * @author dumoulin
	 *
	 */
	protected class QualifiedNameParser extends VoidVisitorAdapter<List<String>> {

	/**
	 * Get the qualified name from the specified ast type
	 * @param n
	 * @return
	 */
	public List<String> getClassOrInterfaceQualifiedName(ClassOrInterfaceType n)
	{
		List<String> res = new ArrayList<String>();
		n.accept(this, res);
		return res;
	}
	
	/**
	 * Get the qualified name from the specified ast type
	 * @param n
	 * @return
	 */
	public List<String> getPackageQualifiedName(PackageDeclaration n)
	{
		List<String> res = new ArrayList<String>();
		n.accept(this, res);
		return res;
	}
	
	/**
	 * Get the qualified name from the specified ast type
	 * 
	 * @param n
	 * @return
	 */
	public List<String> getImportQualifiedName(ImportDeclaration n)
	{
		// Imports are ordered from rootPackage to Type.
		// So, names should be added in before visiting childs.
		return getQualifiedName(n);
	}
	
	/**
	 * Get the qualified name from the specified ast type
	 * @param n
	 * @return
	 */
	private List<String> getQualifiedName(Node n)
	{
		List<String> res = new ArrayList<String>();
		n.accept(this, res);
		return res;
	}
	
	/**
	 * Create the package part
	 */
	@Override
	public void visit(ClassOrInterfaceType n, List<String> names) {
//		System.out.println("visitName( " + n.getName() + " )");
		// Add in head, because elements are found in reverse order.
//		super.visit(n, names);
		names.add(0, n.getName());
		if(n.getScope() != null)
		  n.getScope().accept(this, names);
	}
	
	/**
	 * Create the package part
	 */
	@Override
	public void visit(NameExpr n, List<String> names) {
		// Add in head, because elements are found in reverse order.
//		System.out.println("addName( " + n.getName() + " )");
		names.add(0, n.getName());
//		super.visit(n, names);
	}
	
	/**
	 * 
	 */
	@Override
	public void visit(QualifiedNameExpr n, List<String> names) {
		// Add in head, because elements are found in reverse order.
//		System.out.println("addQualifiedName( " + n.getName() + " )");
		names.add(0, n.getName());
		if(n.getQualifier() != null)
  		  n.getQualifier().accept(this, names);
//		super.visit(n, names);
	}
}

}
