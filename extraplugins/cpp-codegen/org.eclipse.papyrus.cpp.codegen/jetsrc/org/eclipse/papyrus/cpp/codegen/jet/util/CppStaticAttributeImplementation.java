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

import org.eclipse.uml2.uml.*;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.*;

public class CppStaticAttributeImplementation
{
  protected static String nl;
  public static synchronized CppStaticAttributeImplementation create(String lineSeparator)
  {
    nl = lineSeparator;
    CppStaticAttributeImplementation result = new CppStaticAttributeImplementation();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "::";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the property
	Property currentAttribute			= (Property) argument;
	
	String attributeName	= currentAttribute.getName();
	String className		= GenUtils.qualifiedName (currentAttribute.getClass_());
	String typeName			= "";
	String suffix			= "";
	String multiple			= "";
	String isAgg			= ""; // attribute is an aggregation or association
	
	
	if (currentAttribute.getType() == null) {
		typeName	= "undefined"+" ";
	} else {
		typeName	= GenUtils.qualifiedName (currentAttribute.getType()) + " ";
	}
	
	// Multiple
	// if (currentAttribute.isMultiple()) {
		// multiple	= "*";
	// }
	
	// If attribute is aggregation then generate a pointer
	if (GenUtils.isAggregation(currentAttribute)) {
		// attributeName	= "(*"+attributeName+")"; // this produce a pointer on a tab
		isAgg	= "*";      // this produce a tab of pointers
	}
	
	Modifier modifier = new Modifier(currentAttribute);
	
	// Initial value
	if (currentAttribute.getDefaultValue() != null) {
		// via UML
		suffix = " = " + currentAttribute.getDefaultValue().stringValue();
	}
	else {
		CppDefault cppDefault = GenUtils.getApplication(currentAttribute, CppDefault.class);
		if (cppDefault != null) {
			suffix = " = " + cppDefault.getValue();
		}
	}
			
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( typeName );
    stringBuffer.append( multiple );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( isAgg );
    stringBuffer.append( modifier.ref );
    stringBuffer.append( className );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attributeName );
    stringBuffer.append( modifier.array );
    stringBuffer.append( suffix );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}