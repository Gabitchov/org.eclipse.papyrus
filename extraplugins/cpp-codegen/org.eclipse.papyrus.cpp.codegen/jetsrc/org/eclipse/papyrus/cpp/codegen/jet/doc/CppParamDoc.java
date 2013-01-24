/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.jet.doc;

import org.eclipse.uml2.uml.Parameter;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppParamDoc
{
  protected static String nl;
  public static synchronized CppParamDoc create(String lineSeparator)
  {
    nl = lineSeparator;
    CppParamDoc result = new CppParamDoc();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "@param ";
  protected final String TEXT_2 = " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the element
	Parameter currentElt		= (Parameter) argument;

	String paramName = currentElt.getName();
	String paramDoc  = GenUtils.getComments(currentElt);
	
	paramDoc	= paramDoc.replaceAll(NL, NL+" *	");
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( paramDoc );
    return stringBuffer.toString();
  }
}