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

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.*;

public class CppClassIncludeClassDeclaration
{
  protected static String nl;
  public static synchronized CppClassIncludeClassDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassIncludeClassDeclaration result = new CppClassIncludeClassDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "class ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the class
	NamedElement currentNE		= (NamedElement) argument;
	String cClassName 			= currentNE.getName();	
	String isTemplate			= "";
	String openNS				= GenUtils.openNS (currentNE); 
	String closeNS				= GenUtils.closeNS (currentNE); 
	
	if (GenUtils.hasStereotype(currentNE, CppTemplate.class)) {
		isTemplate = "template ";
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( openNS );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( isTemplate );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( cClassName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( closeNS );
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}