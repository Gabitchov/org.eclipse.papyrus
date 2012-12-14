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

import org.eclipse.uml2.uml.Property;
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.*;

public class CppAttributeDeclaration
{
  protected static String nl;
  public static synchronized CppAttributeDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppAttributeDeclaration result = new CppAttributeDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the property
	Property currentAttribute			= (Property) argument;
	
	String attributeName	= currentAttribute.getName();
	String typeName			= "";
	String prefix			= "";
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
	} else {
		typeName	= GenUtils.qualifiedName (currentAttribute.getType());
	}
	
	// Static attribute
	if (currentAttribute.isStatic()) {
		prefix		= "static"+" ";
	}
	
	Modifier modifier = new Modifier(currentAttribute);
	
	// Treat multiplicity for association attributes
	int multiplicity = currentAttribute.getUpper();
	if (multiplicity == 1) {
		multiple = "";
	} else if (multiplicity == -1) {
		multiple = "*";
	} else {
		multiple = "";
		modifier.array = "[" + multiplicity + "]";
	}
	
	// If attribute is aggregation
	if (GenUtils.isAggregation(currentAttribute)) {
		// attributeName	= "(*"+attributeName+")"; // this produce a pointer on a tab
		attributeName = "*"+attributeName;      // this produce a tab of pointers
	}
	
	
	if (GenUtils.hasStereotype(currentAttribute, CppConst.class) && currentAttribute.isStatic()) {
		// const & static attributes may be initialized within class declaration
		// check if initial value UML or profile
		if (currentAttribute.getDefaultValue() != null) {
			suffix = " = " + currentAttribute.getDefaultValue().stringValue();
		}
		else {
			CppDefault cppDefault = GenUtils.getApplication(currentAttribute, CppDefault.class);
			if (cppDefault != null) {
				suffix = " = " + cppDefault.getValue();
			}
		}
	}
			
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( propDoc );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( prefix );
    stringBuffer.append( modifier.isConst );
    stringBuffer.append( typeName );
    stringBuffer.append( multiple );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( attributeName );
    stringBuffer.append( modifier.array );
    stringBuffer.append( suffix );
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}