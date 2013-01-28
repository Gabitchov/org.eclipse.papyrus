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

import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import java.util.Iterator;

public class CppOperationDoc
{
  protected static String nl;
  public static synchronized CppOperationDoc create(String lineSeparator)
  {
    nl = lineSeparator;
    CppOperationDoc result = new CppOperationDoc();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/**" + NL + " * ";
  protected final String TEXT_2 = NL + " * ";
  protected final String TEXT_3 = NL + " */";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the element
	Operation currentOperation		= (Operation) argument;
	Parameter currentParameter;
	
	String 	opDoc				= "";
	String  opParams			= "";
//	String  opReturn			= "";
// TODO: return not handled? (or treated as any other parameter?)
	
	// Doc for the element
	opDoc	= GenUtils.getComments(currentOperation);
	opDoc	= opDoc.replaceAll(NL, NL+" * ");
	
	// Treat params
	Iterator<Parameter> parameters	= currentOperation.getOwnedParameters().iterator();
	while(parameters.hasNext()) {
		currentParameter		= (Parameter) parameters.next();	
		
		// Prepare parameters
		CppParamDoc	jetParam	= new CppParamDoc();
		opParams				= opParams+jetParam.generate(currentParameter);	
		
		if (parameters.hasNext()){
			opParams				= opParams+NL+" * ";
		}
	}
	
	// Treat return
		
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( opDoc );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( opParams );
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}