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
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.*;

public class CppAttributeImplementation
{
  protected static String nl;
  public static synchronized CppAttributeImplementation create(String lineSeparator)
  {
    nl = lineSeparator;
    CppAttributeImplementation result = new CppAttributeImplementation();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the property
	Property currentAttribute			= (Property) argument;
	
	String attributeName	= currentAttribute.getName();
//	String className		= currentAttribute.getOwner().getName();
	String typeName			= "";
	String scopeName		= "";
//	String prefix			= "";
	String suffix			= "";
	String multiple			= "";
	
	// For property documentation
	String propDoc		= "";
	
	// Retrieve enum doc
	CppElementDoc jDoc		= new CppElementDoc();
	propDoc					= jDoc.generate(currentAttribute);	
	propDoc					= propDoc.replaceAll(NL, NL+"	");
	
	if (currentAttribute.getType() == null) {
		typeName	= "undefined";
	}
	else {	
		Type type = currentAttribute.getType();
		typeName	= GenUtils.qualifiedName (type);
		/*
		// If type is owned by a class add the scope
		if (type.getOwner() instanceof Class) {
			scopeName	= ((Class) type.getOwner()).getName();
			typeName	= scopeName+"::"+typeName;
		}
		*/
	}
	
	// Multiple
	// TODO? need to evaluate limitMultiplicity stereotype?
	int upper = currentAttribute.getUpper();
	if ((upper == -1) || (upper > 1)) {
		multiple	= "*";
	}
	
	Modifier modifier  = new Modifier(currentAttribute);
			
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( propDoc );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( typeName );
    stringBuffer.append( multiple );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( attributeName );
    stringBuffer.append( modifier.array );
    stringBuffer.append( suffix );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}