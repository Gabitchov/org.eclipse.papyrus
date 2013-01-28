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

import org.eclipse.papyrus.cpp.codegen.Constants;
import org.eclipse.papyrus.cpp.codegen.utils.*;
import org.eclipse.emf.common.util.EList;
import Cpp.CppInclude;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.papyrus.cpp.codegen.jet.util.*;
import org.eclipse.papyrus.cpp.codegen.Activator;

public class CppClassBody
{
  protected static String nl;
  public static synchronized CppClassBody create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassBody result = new CppClassBody();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#define ";
  protected final String TEXT_2 = "_BODY" + NL + "" + NL + "/************************************************************";
  protected final String TEXT_3 = NL + "              ";
  protected final String TEXT_4 = " class body" + NL + " ************************************************************/" + NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "#include <";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ">" + NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + NL + "/************************************************************" + NL + "              End of ";
  protected final String TEXT_23 = " class body" + NL + " ************************************************************/";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the class
	Classifier currentClass	= (Classifier) argument;
	
	// Get the package name
	String className	= currentClass.getName();
	String classFullName= GenUtils.getFullName (currentClass);
	String classFULLNAME= classFullName.toUpperCase(); 
	
	// Retrieve header file suffix
	String headerFileSuffix = Activator.getDefault().getPluginPreferences().getString("headSuffix");
	
	// TODO - Prepare static attribute
	String staticAttributes = "";

	// Retrieve owner Package
	Package owner		= currentClass.getPackage();
	String  fullPath	= "";
	
	if (owner != null) {
		fullPath		= GenUtils.getFullPath(owner) + "/";
	} // else fullPath == ""
	
	// Prepare attributes and Methods declarations
	String allOperations	= "";
	
	// Methods
	CppClassOperationsImplementation jetClassOp
							= new CppClassOperationsImplementation();
	allOperations			= jetClassOp.generate(currentClass);
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( classFULLNAME );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( Constants.cppIncPreBodyStart );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ClassUtils.getCppIncludePreBody(currentClass)
);
    stringBuffer.append( Constants.cppIncPreBodyEnd );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( Constants.includeHFile );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( fullPath );
    stringBuffer.append( className );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( headerFileSuffix );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( Constants.cppIncBodyStart );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( ClassUtils.getCppIncludeBody(currentClass)
);
    stringBuffer.append( Constants.cppIncBodyEnd );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( Constants.derivedIncludes );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( ClassUtils.createIncludeDecl(currentClass) );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( GenUtils.openNS(currentClass) );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( ClassUtils.getStaticAttributes(currentClass) );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( allOperations );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( GenUtils.closeNS(currentClass) );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}