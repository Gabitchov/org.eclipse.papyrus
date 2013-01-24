/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.jet;

import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.CppInclude;
import Cpp.Union;
import org.eclipse.papyrus.cpp.codegen.StdStereo;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import org.eclipse.papyrus.cpp.codegen.jet.util.*;
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;

public class CppClassHeader
{
  protected static String nl;
  public static synchronized CppClassHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassHeader result = new CppClassHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = "_H" + NL + "#define ";
  protected final String TEXT_3 = "_H" + NL + "" + NL + "/************************************************************";
  protected final String TEXT_4 = NL + "              ";
  protected final String TEXT_5 = " class header" + NL + " ************************************************************/" + NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "/************************************************************/";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = " ";
  protected final String TEXT_18 = " {";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + NL + "  public:";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + NL + "  protected:";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL + NL + "  private:";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + NL + "};" + NL + "/************************************************************/" + NL + "/* External declarations (package visibility)               */";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "/************************************************************/" + NL + "/* Inline functions                                         */";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + NL + "/************************************************************" + NL + "              End of ";
  protected final String TEXT_33 = " class header" + NL + " ************************************************************/" + NL + "" + NL + "#endif";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	
	// Retrieve the class
	Classifier currentClass = (Classifier) argument;

	// Get the package name
	String className		= currentClass.getName();
	String classFULLNAME	= GenUtils.getFullName (currentClass).toUpperCase();
	String openNS			= GenUtils.openNS (currentClass); 
	String closeNS			= GenUtils.closeNS (currentClass); 
	String classDoc			= "";
	String classOrStruct    = GenUtils.hasStereotype(currentClass, Union.class) ? "union" :
								((currentClass instanceof DataType) ? "struct" : "class");
	
	// Doc for the class
	CppElementDoc jDoc		= new CppElementDoc();
	classDoc				= jDoc.generate(currentClass);

	String includeProtection;
		
	// Include declaration "CppInclude"
	String headerDecl		= "";
	CppInclude cppInclude =  GenUtils.getApplication(currentClass, CppInclude.class);
	if (cppInclude != null) {
		headerDecl = GenUtils.maskNull(cppInclude.getHeader());
		if (headerDecl.length() > 0) {
			headerDecl = "// Include from CppInclude declaration" + NL + headerDecl.replace("HFILENAME", classFULLNAME) + NL;
		}
	}
	
	// Prepare owner package header include
	Package ownerPackage	= currentClass.getPackage();
	String ownerInclude		= "";
	if (ownerPackage != null) {
		// Create an util template to prepare the declaration
		CppOwnerPackageIncludeDeclaration jetOwnerInclude		
							= new CppOwnerPackageIncludeDeclaration();
		// Execute the util template
		ownerInclude		= jetOwnerInclude.generate(ownerPackage);
	}
	
	
	// Prepare owned type and enum declaration
	String typeEnumDefPackage	= "";
	String typeEnumDef			= "";
			
	CppClassTypeAndEnum jetTE	= new CppClassTypeAndEnum();
	typeEnumDef					= jetTE.generate(currentClass);

	CppClassTypeAndEnumPackage jetTEp	
								= new CppClassTypeAndEnumPackage();
	typeEnumDefPackage			= jetTEp.generate(currentClass);	


	// Prepare dependency includes
	CppClassAllIncludesDeclaration jetClassIncludes
									= new CppClassAllIncludesDeclaration();
	String classIncludes			= jetClassIncludes.generate(argument);
	if (!classIncludes.equals("")) {
		classIncludes	= "/* Structural includes (inheritance, dependencies...       */"+NL+classIncludes;
	}

	// Prepare friend dependency includes
	CppClassIncludeFriendDeclaration jetClassFIncludes
									= new CppClassIncludeFriendDeclaration();
	String friendIncludes			= jetClassFIncludes.generate(argument);
	if (!friendIncludes.equals("")) {
		friendIncludes	= "/* Friend class declaration       */"+NL+friendIncludes;
	}
	
	// Prepare attributes and Methods declarations
	String publicAttributes		= "";
	String publicOperations		= "";
	String protectedAttributes	= "";
	String protectedOperations	= "";
	String privateAttributes	= "";
	String privateOperations	= "";
	String packageAttributes	= "";
	String packageOperations	= "";

	// Attributes
	CppClassAttributesDeclaration jetClassPAttr = new CppClassAttributesDeclaration();
	publicAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PUBLIC_LITERAL);
	protectedAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PROTECTED_LITERAL);
	privateAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PRIVATE_LITERAL);
	packageAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PACKAGE_LITERAL);
	
	// Methods
	CppClassOperationsDeclaration jetClassPOp = new CppClassOperationsDeclaration();
	publicOperations			= jetClassPOp.generate(currentClass, VisibilityKind.PUBLIC_LITERAL);
	protectedOperations			= jetClassPOp.generate(currentClass, VisibilityKind.PROTECTED_LITERAL);
	privateOperations			= jetClassPOp.generate(currentClass, VisibilityKind.PRIVATE_LITERAL);
	packageOperations			= jetClassPOp.generate(currentClass, VisibilityKind.PACKAGE_LITERAL);
	
	boolean hasConstructor = false;
	for (Operation operation : currentClass.getOperations ()) {
		if (GenUtils.hasStereotype(operation, StdStereo.create)) {
			hasConstructor = true;
			break;
		}
	}
	String defaultInitializer = "";
	for (Property attribute : currentClass.getAttributes ()) {
		if (attribute.isStatic()) {
			// static attributes are initialized differently
			continue;
		}
		ValueSpecification vs = attribute.getDefaultValue ();
		if ((vs != null) && (vs.stringValue() != null)) {
			if (!defaultInitializer.equals("")) {
				// not first attribute
				defaultInitializer += ", ";
			}
			defaultInitializer += attribute.getName () + "(" + vs.stringValue() + ")";
		}
	}
	// no constructor, add it, if some properties have default values
	if ((!hasConstructor) && (!defaultInitializer.equals (""))) {
		defaultInitializer = className + "() : " + defaultInitializer + " {}";  
	}
	else {
		defaultInitializer = "";
	}
	
	// Inline functions implementations
	String inlineFunctionsImplementation = "";
	CppClassInlineOperationsImplementation jetInlineClassPOp
									= new CppClassInlineOperationsImplementation();
	inlineFunctionsImplementation	= jetInlineClassPOp.generate(currentClass);
		
	// Prepare inherited classes or implemented interfaces
	String inheritedDeclarations = "";
	CppClassInheritedDeclarations jetInherited
									= new CppClassInheritedDeclarations();
	inheritedDeclarations			= jetInherited.generate(currentClass);
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( classFULLNAME );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( classFULLNAME );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ownerInclude );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classIncludes );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( headerDecl );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( openNS );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( typeEnumDefPackage );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( classDoc );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( classOrStruct );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( className );
    stringBuffer.append( inheritedDeclarations );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( friendIncludes );
    stringBuffer.append( typeEnumDef );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( defaultInitializer );
    stringBuffer.append( publicAttributes );
    stringBuffer.append( publicOperations );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( protectedAttributes );
    stringBuffer.append( protectedOperations );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( privateAttributes );
    stringBuffer.append( privateOperations );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( packageAttributes );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( packageOperations );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( inlineFunctionsImplementation );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( closeNS );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}