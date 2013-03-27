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

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import java.util.Iterator;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.*;

public class CppEnumerationDefinition
{
  protected static String nl;
  public static synchronized CppEnumerationDefinition create(String lineSeparator)
  {
    nl = lineSeparator;
    CppEnumerationDefinition result = new CppEnumerationDefinition();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "enum ";
  protected final String TEXT_3 = " {" + NL + "\t";
  protected final String TEXT_4 = NL + "};" + NL;
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// This is an util template to prepare Enumeration definition
	/////////////////////////////////////////////////////////////


	// Retrieve the enumeration
	Enumeration currentEnumeration = (Enumeration) argument;
	
	// Get the package name
	String enumName			= currentEnumeration.getName();
	
	// Doc
	String enumDoc			= "";
	String enumLitDoc		= "";
	
	// Retrieve enum doc
	CppElementDoc jDoc		= new CppElementDoc();
	enumDoc					= jDoc.generate(currentEnumeration);
	
	// Retrieve literals
	String enumLiterals	= "";
	
	Iterator<EnumerationLiteral> literalsIt = currentEnumeration.getOwnedLiterals().iterator();
	
	while (literalsIt.hasNext()) {
		
		// retrieve current 
		EnumerationLiteral currentLiteral = literalsIt.next();
		
		enumLiterals = enumLiterals+currentLiteral.getName();
		
		// if current literal is initialised
		CppInit cppInit = GenUtils.getApplication(currentLiteral, CppInit.class);
		if (cppInit != null) {
			// Add the initialisation value
			int initValue = cppInit.getValue();
			enumLiterals = enumLiterals + " = " + initValue;
		}
		
		// Retrieve doc
		if (!GenUtils.getComments(currentLiteral).equals("")) {
			enumLitDoc = " //< "+GenUtils.getComments(currentLiteral);
		} else {
			enumLitDoc = "";
		}
			
		// if more literal left prepare new line for next literal
		if (literalsIt.hasNext()) {
			enumLiterals	= enumLiterals+" ,"+enumLitDoc+NL+"\t";
		} else {
			enumLiterals	= enumLiterals+enumLitDoc;
		}
	}
	
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( enumDoc );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( enumName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( enumLiterals );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}