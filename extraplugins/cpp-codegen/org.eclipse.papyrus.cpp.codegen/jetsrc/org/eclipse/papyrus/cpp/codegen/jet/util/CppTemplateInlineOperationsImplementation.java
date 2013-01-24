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

import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import java.util.Iterator;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppTemplateInlineOperationsImplementation
{
  protected static String nl;
  public static synchronized CppTemplateInlineOperationsImplementation create(String lineSeparator)
  {
    nl = lineSeparator;
    CppTemplateInlineOperationsImplementation result = new CppTemplateInlineOperationsImplementation();
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

		// Retrieve the class
		Class currentClass	= (Class) argument;
		String opDecl	= "";
		String tDecl	= "";
		
		// Retrieve template declaration
		CppTemplateDeclaration jetTDecl = new CppTemplateDeclaration();
		// tDecl should contain something like "template <class x, class y>"
		tDecl = jetTDecl.generate(currentClass) + " "; 

		// Retrieve operations
		Iterator<Operation> operations = currentClass.getOwnedOperations().iterator();
		while (operations.hasNext()) {
			Operation currentOperation = operations.next();

			if (GenUtils.hasStereotype (currentOperation, CppInline.class) &&
				!GenUtils.hasStereotype (currentOperation, CppNoCodeGen.class)) {
				String opDoc = "";

				// Doc for the template	
				CppOperationDoc jDoc = new CppOperationDoc();
				opDoc = jDoc.generate(currentOperation);

				CppOperationTemplateImplementation jetOpImpl = new CppOperationTemplateImplementation();
				opDecl = opDecl+opDoc+NL+tDecl+jetOpImpl.generate(currentOperation)+NL;
			}
		}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append( opDecl );
    return stringBuffer.toString();
  }
}