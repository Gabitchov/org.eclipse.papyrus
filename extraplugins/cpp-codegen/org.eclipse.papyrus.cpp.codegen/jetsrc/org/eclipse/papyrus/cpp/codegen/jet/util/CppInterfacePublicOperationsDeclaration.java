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

import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.VisibilityKind;
import java.util.*;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppInterfacePublicOperationsDeclaration
{
  protected static String nl;
  public static synchronized CppInterfacePublicOperationsDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppInterfacePublicOperationsDeclaration result = new CppInterfacePublicOperationsDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the class
	Interface currentInterface = (Interface) argument;
	String opDecl	= "";
	
	// Retrieve operations
	Iterator<Operation> operations = currentInterface.getOwnedOperations().iterator();
	while (operations.hasNext()) {
		Operation currentOperation = operations.next();
		if ((currentOperation.getVisibility() == VisibilityKind.PUBLIC_LITERAL) &&
			!GenUtils.hasStereotype (currentOperation, CppNoCodeGen.class)) {
			CppOperationDeclaration jetOpDecl = new CppOperationDeclaration();
			String cOpDecl = jetOpDecl.generate(currentOperation);
		
			// if main cOpDecl = "";
			if (!cOpDecl.equals("")) {
				opDecl = opDecl+"\t"+cOpDecl+";";		
			}
		}
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( opDecl );
    return stringBuffer.toString();
  }
}