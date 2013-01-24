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
import org.eclipse.uml2.uml.Classifier;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.Modifier;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppParameterWithoutDefaultValue
{
  protected static String nl;
  public static synchronized CppParameterWithoutDefaultValue create(String lineSeparator)
  {
    nl = lineSeparator;
    CppParameterWithoutDefaultValue result = new CppParameterWithoutDefaultValue();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<";
  protected final String TEXT_2 = ">";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = " ";

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
	Modifier modifier = new Modifier(currentParameter);
	
	// Prepare template parameter declaration without type
	String tparamWoType		= "";
	
	if (currentParameter.getType() == null) {
		typeName = "undefined";
	}
	else if (currentParameter.getType() instanceof Classifier) {
		Classifier classifier  = (Classifier) currentParameter.getType();
		tparamWoType = GenUtils.getTemplateParametersWoType(classifier);

		typeName = GenUtils.qualifiedName (currentParameter.getType());
	}
	else {
		typeName = GenUtils.qualifiedName (currentParameter.getType());
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
// Package visibility 
	if (!"".equals(tparamWoType)) {
	
//////////////////////////////////////////////////////////////////////////////////////////


    stringBuffer.append( modifier.isConst );
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_1);
    stringBuffer.append( tparamWoType );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( parameterName );
    stringBuffer.append( modifier.array );
    

//////////////////////////////////////////////////////////////////////////////////////////
	
	} else { // Default case

//////////////////////////////////////////////////////////////////////////////////////////


    stringBuffer.append( modifier.isConst );
    stringBuffer.append( typeName );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( parameterName );
    stringBuffer.append( modifier.array );
    


//////////////////////////////////////////////////////////////////////////////////////////
	}
//////////////////////////////////////////////////////////////////////////////////////////
    return stringBuffer.toString();
  }
}