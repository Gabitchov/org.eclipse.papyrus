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
import java.util.Iterator;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.*;

public class CppClassInlineOperationsImplementation
{
  protected static String nl;
  public static synchronized CppClassInlineOperationsImplementation create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassInlineOperationsImplementation result = new CppClassInlineOperationsImplementation();
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
	Classifier currentClass = (Classifier) argument;
	String opDecl = "";
	
	// Retrieve operations
	Iterator<Operation> operations	= currentClass.getOperations().iterator();
	while (operations.hasNext()) {
		Operation currentOp = operations.next();
		if (GenUtils.hasStereotype (currentOp, CppInline.class) &&
			!GenUtils.hasStereotype (currentOp, CppNoCodeGen.class)) {
		
			CppOperationImplementation jetOpImpl = new CppOperationImplementation();
			opDecl = opDecl+jetOpImpl.generate(currentOp);
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