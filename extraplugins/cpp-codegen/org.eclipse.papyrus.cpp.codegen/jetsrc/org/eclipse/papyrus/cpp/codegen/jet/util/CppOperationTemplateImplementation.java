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
import org.eclipse.uml2.uml.Class;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.StdStereo;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppOperationTemplateImplementation
{
  protected static String nl;
  public static synchronized CppOperationTemplateImplementation create(String lineSeparator)
  {
    nl = lineSeparator;
    CppOperationTemplateImplementation result = new CppOperationTemplateImplementation();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "(";
  protected final String TEXT_2 = ")";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "}";
  protected final String TEXT_6 = "<";
  protected final String TEXT_7 = ">::";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = " {";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

		// Retrieve the Operation
		Operation currentOperation	= (Operation) argument;

		String operationName		= currentOperation.getName();
		String opParameters			= "";
		String returnTypeName		= "void";
		String isConst				= "";
		String isInline				= "";

		// Retrieve class & class name
		Class currentClass = currentOperation.getClass_ ();
		String className 		= currentClass.getName();
		
		// Retrieve body content
		String body = GenUtils.getBody (currentOperation, "C/C++");

		// Prepare return type
		CppOperationReturnType jetRT = new CppOperationReturnType();
		returnTypeName	= jetRT.generate(currentOperation);	
		if (! "".equals(returnTypeName)) {
			returnTypeName = returnTypeName + " ";
		}

		// Creator / Destructor: use function within StdStereo
		if (StdStereo.isApplied(currentOperation, StdStereo.create)) {
			returnTypeName		= "";
		}
		if (StdStereo.isApplied(currentOperation, StdStereo.destroy)) {
			returnTypeName		= "";
			operationName		= "~"+operationName;
		}
	
		// If inline operation
		if (GenUtils.hasStereotype(currentOperation, CppInline.class)) {
			isInline = "inline ";
		}
	
		// Const op
		if (GenUtils.hasStereotype(currentOperation, CppConst.class)) {
			isConst	= " const";
		}

		// Prepare parameters
		CppOperationParametersWithoutDefaultValue jetParams	
			= new CppOperationParametersWithoutDefaultValue();
		opParameters = jetParams.generate(currentOperation);


		// Prepare template parameter declaration without type
		String tparamWoType	= "";

		if (currentClass != null) {
			tparamWoType = GenUtils.getTemplateParametersWoType(currentClass);
		}
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
// Package visibility 
	if (currentOperation.getVisibility() == VisibilityKind.PACKAGE_LITERAL) {
	
//////////////////////////////////////////////////////////////////////////////////////////


    stringBuffer.append( isInline );
    stringBuffer.append( returnTypeName );
    stringBuffer.append( operationName );
    stringBuffer.append(TEXT_1);
    stringBuffer.append( opParameters );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( isConst );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( body );
    stringBuffer.append(TEXT_5);
    

//////////////////////////////////////////////////////////////////////////////////////////
	
	} else { // Default case

//////////////////////////////////////////////////////////////////////////////////////////	


    stringBuffer.append( isInline );
    stringBuffer.append( returnTypeName );
    stringBuffer.append( className );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tparamWoType );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( operationName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( opParameters );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( isConst );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( body );
    stringBuffer.append(TEXT_12);
    

//////////////////////////////////////////////////////////////////////////////////////////
	}
//////////////////////////////////////////////////////////////////////////////////////////
    return stringBuffer.toString();
  }
}