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

import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import Cpp.CppInclude;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import org.eclipse.papyrus.cpp.codegen.jet.util.*;
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;

public class CppInterfaceHeader
{
  protected static String nl;
  public static synchronized CppInterfaceHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    CppInterfaceHeader result = new CppInterfaceHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = "_H" + NL + "#define ";
  protected final String TEXT_3 = "_H" + NL + "" + NL + "/************************************************************";
  protected final String TEXT_4 = NL + "              ";
  protected final String TEXT_5 = " interface header" + NL + " ************************************************************/" + NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "/************************************************************/";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "class ";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = "{" + NL + "" + NL + "/* Public declarations                                      */" + NL + "public:";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + NL + "};" + NL + "" + NL + "/************************************************************" + NL + "              End of ";
  protected final String TEXT_19 = " interface header" + NL + " ************************************************************/";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + NL + "#endif";
  protected final String TEXT_22 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the class
	Interface currentInterface		= (Interface) argument;
	
	// Get the package name
	String interfaceName     = currentInterface.getName();
	String interfaceFULLNAME = GenUtils.getFullNameUC (currentInterface);
	
	// For interface documentation
	String iDoc		= "";
	
	// Retrieve enum doc
	CppElementDoc jDoc		= new CppElementDoc();
	iDoc					= jDoc.generate(currentInterface);
	
	// Include declaration "CppInclude"
	String headerDecl		= "";
	CppInclude cppInclude =  GenUtils.getApplication(currentInterface, CppInclude.class);
	if (cppInclude != null) {
		headerDecl =  "// Include from CppInclude declaration" + NL + cppInclude.getHeader() + NL;
	}

	// Prepare owner package header include
	Package ownerPackage	= currentInterface.getPackage();
	String ownerInclude		= "";
	if (ownerPackage != null) {
		// Create an util template to prepare the declaration
		CppOwnerPackageIncludeDeclaration jetOwnerInclude		
							= new CppOwnerPackageIncludeDeclaration();
		// Execute the util template
		ownerInclude		= jetOwnerInclude.generate(ownerPackage);
	}
	
		
	// Prepare dependency includes
	CppInterfaceAllIncludesDeclaration jetInterfaceIncludes
									= new CppInterfaceAllIncludesDeclaration();
	String interfaceIncludes			= jetInterfaceIncludes.generate(argument);
	if (!interfaceIncludes.equals("")) {
		interfaceIncludes	= "/* Structural includes (inheritance, dependencies, ... */"+NL+interfaceIncludes;
	}
	
	// Prepare Methods declarations
	String publicOperations		= "";
	
	// Methods
	CppInterfacePublicOperationsDeclaration jetPublicInterfacePOp
								= new CppInterfacePublicOperationsDeclaration();
	publicOperations			= jetPublicInterfacePOp.generate(currentInterface);
	
		
	// Prepare inherited interfaces
	String inheritedDeclarations = "";
	CppInterfaceInheritedDeclarations jetInherited
									= new CppInterfaceInheritedDeclarations();
	inheritedDeclarations			= jetInherited.generate(currentInterface);
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( interfaceFULLNAME );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( interfaceFULLNAME );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( interfaceName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ownerInclude );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( interfaceIncludes );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( headerDecl );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( GenUtils.openNS(currentInterface) );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( iDoc );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( interfaceName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( inheritedDeclarations );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( publicOperations );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( interfaceName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( GenUtils.closeNS(currentInterface) );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}