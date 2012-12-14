/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.utils;

import org.eclipse.uml2.uml.Element;

import Cpp.CppArray;
import Cpp.CppConst;
import Cpp.CppPtr;
import Cpp.CppRef;

/**
 * Utility functions managing the "modifier" of an element, i.e. additional information whether a passed
 * parameter or an attribute is a pointer, a reference, an array or constant.
 * 
 * @author ansgar
 * 
 */
public class Modifier {

	public String ptr;

	public String ref;

	public String array;

	public String isConst;

	public Modifier() {
		ptr = "";
		ref = "";
		array = "";
		isConst = "";
	}

	/**
	 * Create instance and initialize the ptr/ref/array/isConst attributes.
	 * 
	 * @param currentParameter
	 */
	public Modifier(Element currentParameter) {

		// Pointer
		CppPtr cppPtr = GenUtils.getApplication(currentParameter, CppPtr.class);
		if(cppPtr != null) {
			ptr = (cppPtr.getDeclaration() != null) ?
				cppPtr.getDeclaration() :
				"*";
		}
		else {
			ptr = "";
		}

		// Ref
		ref = GenUtils.hasStereotype(currentParameter, CppRef.class) ?
			"&" :
			"";

		// Array
		CppArray cppArray = GenUtils.getApplication(currentParameter, CppArray.class);
		if(cppArray != null) {
			array = (cppArray.getDefinition() != null) ?
				cppArray.getDefinition() :
				"[]";
		}
		else {
			array = "";
		}

		// Const
		isConst = GenUtils.hasStereotype(currentParameter, CppConst.class) ?
			"const " :
			"";
	}
}
