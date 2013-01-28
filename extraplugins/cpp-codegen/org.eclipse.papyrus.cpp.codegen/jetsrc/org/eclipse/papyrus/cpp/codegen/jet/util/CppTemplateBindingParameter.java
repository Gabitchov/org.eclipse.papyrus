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

public class CppTemplateBindingParameter
{
  protected static String nl;
  public static synchronized CppTemplateBindingParameter create(String lineSeparator)
  {
    nl = lineSeparator;
    CppTemplateBindingParameter result = new CppTemplateBindingParameter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////


	// Retrieve the TemplateParameter
	// Retrieve the TemplateParameter
	TemplateParameterSubstitution currentTParam	= (TemplateParameterSubstitution) argument;
		
	String typeName			= "";

    if (currentTParam.getActual() == null) {
		typeName ="param undefined";
	}
	else {
		ParameterableElement actual = currentTParam.getActual();
	
    	if (actual instanceof LiteralInteger) {
    		typeName = "" + ((LiteralInteger) currentTParam.getActual()).getValue();
    	}
		else {
			typeName = ((NamedElement) currentTParam.getActual()).getName();
		} 	// value = currentTParam.getFormal().getParameteredElement().getName();
	}

//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append( typeName );
    return stringBuffer.toString();
  }
}