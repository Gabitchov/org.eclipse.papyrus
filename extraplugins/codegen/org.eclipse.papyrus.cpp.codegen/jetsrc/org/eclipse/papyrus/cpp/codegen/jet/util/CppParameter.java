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

import org.eclipse.uml2.uml.Parameter;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.Modifier;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppParameter
{
  protected static String nl;
  public static synchronized CppParameter create(String lineSeparator)
  {
    nl = lineSeparator;
    CppParameter result = new CppParameter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the Parameter
	Parameter currentParameter	= (Parameter) argument;
		
	String parameterName		= currentParameter.getName();

	String typeName			= "";
	String suffix			= "";
	Modifier modifier = new Modifier(currentParameter);
	
	if (currentParameter.getType() == null) {
		typeName	= "undefined";
	} else {
		typeName	= GenUtils.qualifiedName (currentParameter.getType());
	}

	// Initial value
	CppDefault cppDefault = GenUtils.getApplication(currentParameter, CppDefault.class);
	if (cppDefault != null) {
		suffix = " = " + cppDefault.getValue();
	}


//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append( modifier.isConst );
    stringBuffer.append( typeName );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    stringBuffer.append(TEXT_1);
    stringBuffer.append( parameterName );
    stringBuffer.append( modifier.array );
    stringBuffer.append( suffix );
    return stringBuffer.toString();
  }
}