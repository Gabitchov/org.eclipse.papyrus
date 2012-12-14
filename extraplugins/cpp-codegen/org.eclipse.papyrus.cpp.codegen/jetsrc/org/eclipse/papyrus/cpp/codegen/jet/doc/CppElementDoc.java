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

import org.eclipse.uml2.uml.Element;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppElementDoc
{
  protected static String nl;
  public static synchronized CppElementDoc create(String lineSeparator)
  {
    nl = lineSeparator;
    CppElementDoc result = new CppElementDoc();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/**" + NL + " * ";
  protected final String TEXT_2 = NL + " */";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the element
	Element currentElt		= (Element) argument;
	String eltDoc			= "";
	
	
	// Doc for the element
	eltDoc	= GenUtils.getComments(currentElt);
	eltDoc	= eltDoc.replaceAll(NL, NL+" * ");
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( eltDoc );
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}