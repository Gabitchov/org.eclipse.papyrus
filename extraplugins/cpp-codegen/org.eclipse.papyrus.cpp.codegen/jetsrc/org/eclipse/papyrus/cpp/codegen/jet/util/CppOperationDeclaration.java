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
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.StdStereo;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppOperationDeclaration
{
  protected static String nl;
  public static synchronized CppOperationDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppOperationDeclaration result = new CppOperationDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ")";

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
	String pVirtualSuffix		= "";
	String prefix				= "";
	String constOp				= "";

	
	String opDoc = "";
	
	// Doc for the template
	CppOperationDoc jDoc		= new CppOperationDoc();
	opDoc						= GenUtils.indent (jDoc.generate(currentOperation), "\t");
	
	// Prepare return type
	CppOperationReturnType jetRT = new CppOperationReturnType();
	returnTypeName	= jetRT.generate(currentOperation);	
	if (!returnTypeName.equals ("")) {
		returnTypeName += " ";
	}
	
	boolean isInterface = currentOperation.getOwner () instanceof Interface;
		
	// Static attribute
	if (currentOperation.isStatic()) {
		prefix				= prefix+"static"+" ";
	}
	
	// Inline attribute
	if (GenUtils.hasStereotype(currentOperation, CppInline.class)) {
		prefix				= prefix+"inline"+" ";
	}		
		
	// Creator / Destructor: use function within StdStereo
	if (StdStereo.isApplied(currentOperation, StdStereo.create)) {
		returnTypeName		= "";
	}
	if (StdStereo.isApplied(currentOperation, StdStereo.destroy)) {
		returnTypeName		= "";
		operationName		= "~"+operationName;
	}
	
	// Const attribute on operation
	if (GenUtils.hasStereotype(currentOperation, CppConst.class)) {
		constOp				= " const";
	}	
	
	// Virtual attribute on operation
	if (GenUtils.hasStereotype(currentOperation, CppVirtual.class)) {
		prefix				= "virtual "+prefix;
	}	
	
	// Pure Virtual attribute on operation
	if (isInterface || currentOperation.isAbstract ()) {
		prefix				= "virtual "+prefix;
		pVirtualSuffix		= " = 0";
	}
	
	// Friend attribute on operation
	if (GenUtils.hasStereotype(currentOperation, CppFriend.class)) {
		prefix				= "friend "+prefix;
	}	
	
	// Prepare parameters
	CppOperationParameters	jetParams	= new CppOperationParameters();
	opParameters						= jetParams.generate(currentOperation);	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template only if current operation is not main
//	else nothing is return...
//////////////////////////////////////////////////////////////////////////////////////////

if (!operationName.equals("main")) { 

//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( opDoc );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( prefix );
    stringBuffer.append( returnTypeName );
    stringBuffer.append( operationName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( opParameters );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( constOp );
    stringBuffer.append( pVirtualSuffix );
    //////////////////////////////////////////////////////////////////////////////////////////
} // else nothing done
//////////////////////////////////////////////////////////////////////////////////////////
    return stringBuffer.toString();
  }
}