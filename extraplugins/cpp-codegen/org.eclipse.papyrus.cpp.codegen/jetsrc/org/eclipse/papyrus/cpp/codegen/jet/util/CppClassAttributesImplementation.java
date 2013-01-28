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
import java.util.Iterator;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppClassAttributesImplementation
{
  protected static String nl;
  public static synchronized CppClassAttributesImplementation create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassAttributesImplementation result = new CppClassAttributesImplementation();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the class
	Classifier currentClass	= (Classifier) argument;
	String attrDecl			= "";
	String attrSDecl		= "";
		
	CppAttributeImplementation jetAttDecl = new CppAttributeImplementation();
	CppStaticAttributeImplementation jetSAttDecl = new CppStaticAttributeImplementation();
								
	Iterator<Property> attributesIt = currentClass.getAttributes().iterator();
	while (attributesIt.hasNext()) {
		Property attribute = (Property) attributesIt.next();
		
		// just check that this property is not a static const
		// in that case it declared and defined in the header file

		// Static
		if (attribute.isStatic()) {
			attrSDecl		= attrSDecl+jetSAttDecl.generate(attribute);
		} else {
			attrDecl		= attrDecl+jetAttDecl.generate(attribute);
		}
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attrSDecl );
    stringBuffer.append( attrDecl );
    return stringBuffer.toString();
  }
}