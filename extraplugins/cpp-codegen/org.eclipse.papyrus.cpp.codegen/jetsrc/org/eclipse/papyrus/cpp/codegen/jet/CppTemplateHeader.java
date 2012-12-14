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

import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.*;
import org.eclipse.papyrus.cpp.codegen.jet.util.*;
import Cpp.CppInclude;
import Cpp.CppNoCodeGen;
import Cpp.CppInline;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import java.util.*;

public class CppTemplateHeader
{
  protected static String nl;
  public static synchronized CppTemplateHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    CppTemplateHeader result = new CppTemplateHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = "_H" + NL + "#define ";
  protected final String TEXT_3 = "_H" + NL + "" + NL + "/************************************************************";
  protected final String TEXT_4 = NL + "              ";
  protected final String TEXT_5 = " template class header" + NL + " ************************************************************/" + NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "/************************************************************/" + NL + "template <";
  protected final String TEXT_14 = "> class ";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = "{";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "/* Public declarations                                      */" + NL + "public:";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + NL + "/* Protected declarations                                   */" + NL + "protected:";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL + NL + "/* Private declarations                                     */" + NL + "private:";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + NL + "};" + NL + "" + NL + "/************************************************************/" + NL + "/* Template functions                                       */";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "/* Inline functions                                         */";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + NL + "/************************************************************" + NL + "              End of ";
  protected final String TEXT_36 = " template class header" + NL + " ************************************************************/" + NL + "" + NL + "#endif";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the class
	Classifier currentClass = (Classifier) argument;

	// Get the package name
	String className = currentClass.getName();
	String classFullName = GenUtils.getFullName(currentClass);
	String classFULLNAME = classFullName.toUpperCase();
	String openNS			= GenUtils.openNS (currentClass); 
	String closeNS			= GenUtils.closeNS (currentClass); 

	// Include declaration "CppInclude"
	String headerDecl = "";
	CppInclude cppInclude =  GenUtils.getApplication(currentClass, CppInclude.class);
	if (cppInclude != null) {
		headerDecl =  "// Include from CppInclude declaration" + NL + cppInclude.getHeader() + NL;
	}

	// Prepare owner package header include
	Package ownerPackage = currentClass.getPackage();
	String ownerInclude = "";
	if (ownerPackage != null) {
		// Create an util template to prepare the declaration
		CppOwnerPackageIncludeDeclaration jetOwnerInclude = new CppOwnerPackageIncludeDeclaration();
		// Execute the util template
		ownerInclude = jetOwnerInclude.generate(ownerPackage);
	}

	// Prepare owned type and enum declaration
	String typeEnumDefPackage = "";
	String typeEnumDef = "";

	CppClassTypeAndEnum jetTE = new CppClassTypeAndEnum();
	typeEnumDef = jetTE.generate(currentClass);

	CppClassTypeAndEnumPackage jetTEp = new CppClassTypeAndEnumPackage();
	typeEnumDefPackage = jetTEp.generate(currentClass);

	// Prepare template parameter declaration
	Iterator<org.eclipse.uml2.uml.TemplateParameter> tparam =
		GenUtils.getTemplateParameters(currentClass).iterator();

	String tParamDecl = "";
	String tDecl = "";

	while (tparam.hasNext()) {
		CppTemplateParameter jetTParam = new CppTemplateParameter();
		tParamDecl = tParamDecl + jetTParam.generate(tparam.next());

		if (tparam.hasNext()) {
			tParamDecl = tParamDecl + ", ";
		}
	}

	tDecl = "template <" + tParamDecl + ">" + NL;

	// Prepare dependency includes
	CppClassAllIncludesDeclaration jetClassIncludes = new CppClassAllIncludesDeclaration();
	String classIncludes = jetClassIncludes.generate(argument);
	if (!classIncludes.equals("")) {
		classIncludes = "/* Structural includes (inheritance, dependencies...       */"
			+ NL + classIncludes;
	}

	// Prepare attributes and Methods declarations
	String publicAttributes = "";
	String protectedAttributes = "";
	String privateAttributes = "";
	String publicOperations = "", publicOperationsImpl = "";
	String protectedOperations = "", protectedOperationsImpl = "";
	String privateOperations = "", privateOperationsImpl = "";

	// Attributes
	CppClassAttributesDeclaration jetClassPAttr = new CppClassAttributesDeclaration();
	publicAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PUBLIC_LITERAL);
	protectedAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PROTECTED_LITERAL);
	privateAttributes			= jetClassPAttr.generate(currentClass, VisibilityKind.PRIVATE_LITERAL);
		
	// Methods implementation
	String inlineFuncImpl = "";
	// String inlineFuncDecl = "";

	// Implementation
	CppOperationTemplateImplementation jetOpImpl = new CppOperationTemplateImplementation();
	// Declaration
	CppOperationDeclaration jetOpDecl = new CppOperationDeclaration();

	// Retrieve operations
	Iterator<Operation> operations = currentClass.getOperations().iterator();
	while (operations.hasNext()) {
		Operation currentOperation = operations.next();

		if (GenUtils.hasStereotype(currentOperation, CppNoCodeGen.class) ||
			currentOperation.isAbstract()) {
			continue;
		}
		if (GenUtils.hasStereotype(currentOperation, CppInline.class)) {
				String opDoc = "";
				// Doc for the template
			CppOperationDoc jDoc = new CppOperationDoc();
			opDoc = jDoc.generate(currentOperation);
				// Inline declaration
			if (currentOperation.getVisibility() == VisibilityKind.PUBLIC_LITERAL) {
				publicOperations = publicOperations
					+ jetOpDecl.generate(currentOperation) + ";";
			} else if (currentOperation.getVisibility() == VisibilityKind.PRIVATE_LITERAL) {
				privateOperations = privateOperations
					+ jetOpDecl.generate(currentOperation) + ";";
			} else if (currentOperation.getVisibility() == VisibilityKind.PROTECTED_LITERAL) {
				protectedOperations = protectedOperations
					+ jetOpDecl.generate(currentOperation) + ";";
			} // else nothing
			// Inline implementation
			inlineFuncImpl = inlineFuncImpl + opDoc + NL + tDecl
				+ jetOpImpl.generate(currentOperation) + NL;
		} else {
			if (currentOperation.getVisibility() == VisibilityKind.PUBLIC_LITERAL) {
				publicOperationsImpl = publicOperationsImpl + tDecl
					+ jetOpImpl.generate(currentOperation);
				publicOperations = publicOperations
					+ jetOpDecl.generate(currentOperation) + ";";
			} else if (currentOperation.getVisibility() == VisibilityKind.PRIVATE_LITERAL) {
				privateOperationsImpl = privateOperationsImpl + tDecl
					+ jetOpImpl.generate(currentOperation);
				privateOperations = privateOperations
					+ jetOpDecl.generate(currentOperation) + ";";
			} else if (currentOperation.getVisibility() == VisibilityKind.PROTECTED_LITERAL) {
				protectedOperationsImpl = protectedOperationsImpl + tDecl
					+ jetOpImpl.generate(currentOperation);
				protectedOperations = protectedOperations
					+ jetOpDecl.generate(currentOperation) + ";";
			} // else nothing
		}
	}

	// Prepare inherited classes or implemented interfaces
	String inheritedDeclarations = "";
	CppClassInheritedDeclarations jetInherited = new CppClassInheritedDeclarations();
		inheritedDeclarations = jetInherited.generate(currentClass);

	
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
    stringBuffer.append( typeEnumDefPackage );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( tParamDecl );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( inheritedDeclarations );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( typeEnumDef );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( publicAttributes );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( publicOperations );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( protectedAttributes );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( protectedOperations );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( privateAttributes );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( privateOperations );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( publicOperationsImpl );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( protectedOperationsImpl );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( privateOperationsImpl );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append( inlineFuncImpl );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append( closeNS );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}