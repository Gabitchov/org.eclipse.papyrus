/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.jet.util;

import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppPrimitiveTypeDefinition
{
  protected static String nl;
  public static synchronized CppPrimitiveTypeDefinition create(String lineSeparator)
  {
    nl = lineSeparator;
    CppPrimitiveTypeDefinition result = new CppPrimitiveTypeDefinition();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the type passed as argument
	PrimitiveType currentPType	= (PrimitiveType) argument;
	String currentPTypeName		= currentPType.getName();
	String definition			= "";
	
	// Doc
	String typeDoc		= "";
	
	// Retrieve enum doc
	CppElementDoc jDoc		= new CppElementDoc();
	
	/**
	 * Support two different kinds of primitive types
	 * (1) those that are native types of the programming language such as long
	 *     For these, no additional definition has to be done and they should be referenced
	 *     with their name only
	 * (2) those that correspond to a typedef (e.g. typedef long ErrorType). These require
	 *     a typedef definition within the package and need to be referenced with their
	 *     fully qualified name (e.g. MyPackage::ErrorType)
	 */
	// Retrieve type definition
	CppType cppType = GenUtils.getApplication(currentPType, CppType.class);
	if (cppType != null) {
		typeDoc				= jDoc.generate(currentPType);	
		definition			= "typedef " + cppType.getDefinition();

		// If definition string contains "typeName" it should be replaced with type name...
		if (definition.indexOf("typeName") != -1) {
			definition			= definition.replaceAll("typeName", currentPTypeName);
		} else {
			definition			= definition + " " + currentPTypeName;
		}
		definition = definition + ";";
	}
	else {
		definition = GenUtils.getStdtypes(currentPType);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( typeDoc );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( definition );
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}