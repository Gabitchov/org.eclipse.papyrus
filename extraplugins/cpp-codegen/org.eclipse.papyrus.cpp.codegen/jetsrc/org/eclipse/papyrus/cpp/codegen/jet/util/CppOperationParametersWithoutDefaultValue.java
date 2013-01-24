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
import java.util.*;

public class CppOperationParametersWithoutDefaultValue
{
  protected static String nl;
  public static synchronized CppOperationParametersWithoutDefaultValue create(String lineSeparator)
  {
    nl = lineSeparator;
    CppOperationParametersWithoutDefaultValue result = new CppOperationParametersWithoutDefaultValue();
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

	// Retrieve the Operation
	Operation currentOperation	= (Operation) argument;
	Parameter currentParameter;
		
	String paramDecl = "";
	
	Iterator<Parameter> parameters = currentOperation.getOwnedParameters().iterator();
	while(parameters.hasNext()) {
		currentParameter = parameters.next();	
		if (currentParameter.getDirection () != ParameterDirectionKind.RETURN_LITERAL) {
			// Prepare parameters
			CppParameterWithoutDefaultValue jetParam = new CppParameterWithoutDefaultValue();
			if (!paramDecl.equals("")) {
				paramDecl += ", ";
			}
			paramDecl = paramDecl+jetParam.generate(currentParameter);	
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append( paramDecl );
    return stringBuffer.toString();
  }
}