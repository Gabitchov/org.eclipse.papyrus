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
import org.eclipse.uml2.uml.TemplateParameter;
import java.util.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppTemplateDeclaration
{
  protected static String nl;
  public static synchronized CppTemplateDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppTemplateDeclaration result = new CppTemplateDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "template <";
  protected final String TEXT_2 = ">";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the class
	Class currentClass		= (Class) argument;
	
	
	// Prepare template parameter declaration
	Iterator<TemplateParameter> tparam = GenUtils.getTemplateParameters(currentClass).iterator();
	String tParamDecl		= "";
	
	while(tparam.hasNext()) {
		TemplateParameter currentTParam	= tparam.next();
		
		CppTemplateParameter jetTParam = new CppTemplateParameter();
		tParamDecl = tParamDecl+jetTParam.generate(currentTParam);
		
		if (tparam.hasNext()) {
			tParamDecl = tParamDecl+", ";
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_1);
    stringBuffer.append( tParamDecl );
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}