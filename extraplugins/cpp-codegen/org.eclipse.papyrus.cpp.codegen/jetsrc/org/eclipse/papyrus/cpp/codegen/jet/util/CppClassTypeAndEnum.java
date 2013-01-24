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

import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import org.eclipse.uml2.uml.*;

public class CppClassTypeAndEnum
{
  protected static String nl;
  public static synchronized CppClassTypeAndEnum create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassTypeAndEnum result = new CppClassTypeAndEnum();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
		// Retrieve the class
		Classifier currentClass	= (Classifier) argument;

		// Prepare owned type and enum declaration
		String publicTypeDef		= "";
		String privateTypeDef		= "";
		String protectedTypeDef		= "";
		String publicEnumDef		= "";
		String privateEnumDef		= "";
		String protectedEnumDef		= "";
		String publicKeyword		= "public:";
		String protectedKeyword		= "protected:";
		String privateKeyword		= "private:";

		for (Element currentElt : currentClass.getOwnedElements()) {
			if (!GenUtils.hasStereotype(currentElt, Cpp.CppNoCodeGen.class)) {
				if (currentElt instanceof PrimitiveType) {

					org.eclipse.uml2.uml.PrimitiveType currentType	= (org.eclipse.uml2.uml.PrimitiveType) currentElt;
					CppPrimitiveTypeDefinition jetPrimitiveType	= new CppPrimitiveTypeDefinition();
					// Execute the util template
					if (currentType.getVisibility() == VisibilityKind.PUBLIC_LITERAL) {
						publicTypeDef = publicTypeDef+jetPrimitiveType.generate(currentType);
					} else if (currentType.getVisibility() == VisibilityKind.PROTECTED_LITERAL) {
						protectedTypeDef = protectedTypeDef+jetPrimitiveType.generate(currentType);
					} else if (currentType.getVisibility() == VisibilityKind.PRIVATE_LITERAL) {
						privateTypeDef = privateTypeDef+jetPrimitiveType.generate(currentType);
					}
				}
				else if (currentElt instanceof Enumeration) {

					Enumeration currentEnum	= (Enumeration) currentElt;
					CppEnumerationDefinition jetEnum = new CppEnumerationDefinition();
					// Execute the util template
					if (currentEnum.getVisibility() == VisibilityKind.PUBLIC_LITERAL) {
						publicEnumDef = publicEnumDef+jetEnum.generate(currentEnum);
					} else if (currentEnum.getVisibility() == VisibilityKind.PROTECTED_LITERAL) {
						protectedEnumDef = protectedEnumDef+jetEnum.generate(currentEnum);
					} else if (currentEnum.getVisibility() == VisibilityKind.PRIVATE_LITERAL) {
						privateEnumDef = privateEnumDef+jetEnum.generate(currentEnum);
					}
				}
			}
		}

		// If not "" add a comment before declarations
		if (publicTypeDef.equals("") && publicEnumDef.equals("")) {
			publicKeyword = "";
		} else {
			if (!publicTypeDef.equals("")) {
				publicTypeDef		= "/* Public type definitions                                  */"+NL+publicTypeDef+NL;
			}
			if (!publicEnumDef.equals("")) {
				publicEnumDef		= "/* Public enumeration definitions                           */"+NL+publicEnumDef+NL;
			}
		}

		if (protectedTypeDef.equals("") && protectedEnumDef.equals("")) {
			protectedKeyword = "";
		} else {
			if (!protectedTypeDef.equals("")) {
				protectedTypeDef	= "/* Protected type definitions                               */"+NL+protectedTypeDef+NL;
			}
			if (!protectedEnumDef.equals("")) {
				protectedEnumDef	= "/* Protected enumeration definitions                        */"+NL+protectedEnumDef+NL;
			}
		}

		if (privateTypeDef.equals("") && privateEnumDef.equals("")) {
			privateKeyword = "";
		} else {
			if (!privateTypeDef.equals("")) {
				privateTypeDef		= "/* Private type definitions                                 */"+NL+privateTypeDef+NL;
			}
			if (!privateEnumDef.equals("")) {
				privateEnumDef		= "/* Private enumeration definitions                          */"+NL+privateEnumDef+NL;
			}
		}
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( publicKeyword );
    stringBuffer.append( publicTypeDef );
    stringBuffer.append( publicEnumDef );
    stringBuffer.append( protectedKeyword );
    stringBuffer.append( protectedTypeDef );
    stringBuffer.append( protectedEnumDef );
    stringBuffer.append( privateKeyword );
    stringBuffer.append( privateTypeDef );
    stringBuffer.append( privateEnumDef );
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}