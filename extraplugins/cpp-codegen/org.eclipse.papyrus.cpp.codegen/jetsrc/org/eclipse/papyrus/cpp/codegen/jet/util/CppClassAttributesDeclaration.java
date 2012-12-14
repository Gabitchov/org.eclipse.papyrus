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

public class CppClassAttributesDeclaration
{
  protected static String nl;
  public static synchronized CppClassAttributesDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassAttributesDeclaration result = new CppClassAttributesDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument1, Object argument2)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the class
	Classifier currentClass = (Classifier) argument1;
	String attrDecl	= "";
	
	// Retrieve public attributes
	Iterator<Property> attributes = currentClass.getAttributes().iterator();
	while (attributes.hasNext()) {
		Property attribute = attributes.next();
		if (attribute.getVisibility() == argument2) {
			CppAttributeDeclaration jetAttDecl = new CppAttributeDeclaration();
			attrDecl = attrDecl+jetAttDecl.generate(attribute);
		}
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attrDecl );
    return stringBuffer.toString();
  }
}