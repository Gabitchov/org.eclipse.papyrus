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

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import java.util.Iterator;
import Cpp.*;

public class CppClassTypeAndEnumPackage
{
  protected static String nl;
  public static synchronized CppClassTypeAndEnumPackage create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassTypeAndEnumPackage result = new CppClassTypeAndEnumPackage();
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
	
	// Retrieve the class
	Classifier currentClass = (Classifier) argument;
	

	// Prepare owned type and enum declaration
	String packageTypeDef = "";
	String packageEnumDef = "";
			
	Iterator<Element> typeIt = currentClass.getOwnedElements().iterator();
	while (typeIt.hasNext()) {
		Element currentElt = typeIt.next();
		if (!GenUtils.hasStereotype(currentElt, CppNoCodeGen.class)) {
			if (currentElt instanceof PrimitiveType) {

				PrimitiveType currentType = (PrimitiveType) currentElt;
				CppPrimitiveTypeDefinition jetPrimitiveType	= new CppPrimitiveTypeDefinition();
				// Execute the util template
				if (currentType.getVisibility() == VisibilityKind.PACKAGE_LITERAL) {
					packageTypeDef = packageTypeDef+jetPrimitiveType.generate(currentType);
				}


			} else if (currentElt instanceof Enumeration) {

				Enumeration currentEnum	= (Enumeration) currentElt;
				CppEnumerationDefinition jetEnum = new CppEnumerationDefinition();
				// Execute the util template
				if (currentEnum.getVisibility() == VisibilityKind.PACKAGE_LITERAL) {
					packageEnumDef = packageEnumDef+jetEnum.generate(currentEnum);
				} 

			}
		}
	}
	
	// If not "" add a comment before declarations
	if (!packageEnumDef.equals("")) {
		packageEnumDef	= "/* Package enumeration definitions                        */"+NL+packageEnumDef;
	}
	if (!packageTypeDef.equals("")) {
		packageTypeDef	= "/* Package type definitions                               */"+NL+packageTypeDef;
	}

	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( packageTypeDef );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageEnumDef );
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}