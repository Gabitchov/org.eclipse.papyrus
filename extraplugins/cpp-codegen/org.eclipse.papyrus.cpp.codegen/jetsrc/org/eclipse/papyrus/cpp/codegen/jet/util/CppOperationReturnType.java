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
import org.eclipse.papyrus.cpp.codegen.utils.*;

public class CppOperationReturnType
{
  protected static String nl;
  public static synchronized CppOperationReturnType create(String lineSeparator)
  {
    nl = lineSeparator;
    CppOperationReturnType result = new CppOperationReturnType();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "::";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the Operation
	Operation currentOperation	= (Operation) argument;
	
	String returnTypeName		= "void";
	String ownerName			= "";
	Modifier modifier           = new Modifier();
	
	// Return type	
	if (currentOperation.getType() == null) {
		returnTypeName	= "void";
	} else {
		if (currentOperation.getType() == null) {
			returnTypeName = "undefined";
		} else {
			// Treat the type if it is not "package visibility" and owned by a class
			Type currentType = currentOperation.getType();
			returnTypeName = GenUtils.qualifiedName (currentType);
			
			if (currentType.getVisibility() != VisibilityKind.PACKAGE_LITERAL) {
				if (currentType.getOwner() instanceof Class) {
					ownerName = ((Class) currentType.getOwner()).getName();
				}
			}
		}
		
		// Treat pointer or ref on return parameter (only one return parameter should exists)
			// retrieve return parameter
// RS: changed test: now getReturnResult returns only one param
//		if (currentOperation.getUml2Operation().getReturnResults().size() == 1) {
//			org.eclipse.uml2.uml.Parameter uml2Param 
//				= (org.eclipse.uml2.uml.Parameter) currentOperation.getUml2Operation().getReturnResults().get(0);
//			Parameter currentRParameter	
//				= new Parameter(uml2Param);
//			// case Pointer
//			if (currentRParameter.hasStereotype(xy, CppPtr.class)) {
//				isPointer = " "+currentRParameter.getTaggedValue(CppPtr.class, "declaration");
//			}
//			if (currentRParameter.hasStereotype(xy, CppRef.class)) {
//				isRef 	  = " "+currentRParameter.getTaggedValue(CppRef.class, "declaration");
//			}
//			if (currentRParameter.hasStereotype(xy, CppConst.class_)) {
//				isConst = "const ";
//			}
//		}
		if (currentOperation.getReturnResult() instanceof Parameter) {
			Parameter uml2Param = (Parameter) currentOperation.getReturnResult();
			modifier = new Modifier(uml2Param);
		}
	}
		
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template two cases : scope required or not
//////////////////////////////////////////////////////////////////////////////////////////

// No scope details 
	if (ownerName.equals("")) {	
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append( modifier.isConst );
    stringBuffer.append( returnTypeName );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    //////////////////////////////////////////////////////////////////////////////////////////
} else {
//////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append( modifier.isConst );
    stringBuffer.append( ownerName );
    stringBuffer.append(TEXT_1);
    stringBuffer.append( returnTypeName );
    stringBuffer.append( modifier.ptr );
    stringBuffer.append( modifier.ref );
    //////////////////////////////////////////////////////////////////////////////////////////
}
//////////////////////////////////////////////////////////////////////////////////////////
    return stringBuffer.toString();
  }
}