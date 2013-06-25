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

import org.eclipse.papyrus.C_Cpp.Array;
import org.eclipse.papyrus.C_Cpp.Const;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.C_Cpp.Ref;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;


/**
 * Utility functions managing the "modifier" of an element, i.e. additional information whether a passed
 * parameter or an attribute is a pointer, a reference, an array or constant.
 * 
 * @author ansgar
 * 
 */
public class Modifier {

	public static String ptr;

	public static String ref;

	public static String array;

	public static String isConst;

	public static String modPtr(Element propertyOrParameter) {
		update(propertyOrParameter);
		return ptr;
	}

	public static String modRef(Element propertyOrParameter) {
		update(propertyOrParameter);
		return ref;
	}

	public static String modArray(Element propertyOrParameter) {
		update(propertyOrParameter);
		return array;
	}

	public static String modConst(Element propertyOrParameter) {
		update(propertyOrParameter);
		return isConst;
	}

	/**
	 * Create instance and initialize the ptr/ref/array/isConst attributes.
	 * 
	 * @param propertyOperationOrParameter
	 */
	public static void update(Element propertyOperationOrParameter) {

		// Pointer
		Ptr cppPtr = GenUtils.getApplication(propertyOperationOrParameter, Ptr.class);
		if(cppPtr != null) {
			ptr = (cppPtr.getDeclaration() != null) ? cppPtr.getDeclaration() : "*"; //$NON-NLS-1$
		} else {
			ptr = ""; //$NON-NLS-1$
		}
		if (propertyOperationOrParameter instanceof Property) {
			if (((Property) propertyOperationOrParameter).getAggregation() == AggregationKind.SHARED_LITERAL) {
				ptr += "*"; //$NON-NLS-1$
			}
		}
		// Ref
		ref = GenUtils.hasStereotype(propertyOperationOrParameter, Ref.class) ? "&" : ""; //$NON-NLS-1$ //$NON-NLS-2$
		boolean ptrOrRef = GenUtils.hasStereotype(propertyOperationOrParameter, Ref.class) ||
			GenUtils.hasStereotype(propertyOperationOrParameter, Ptr.class);

		// Array
		Array cppArray = GenUtils.getApplication(propertyOperationOrParameter, Array.class);
		if(cppArray != null) {
			// explicit array definition
			array = (cppArray.getDefinition() != null) ? cppArray.getDefinition() : "[]"; //$NON-NLS-1$
		} else {
			// calculate array from multiplicity definition
			int multiplicity = 1;
			if(propertyOperationOrParameter instanceof MultiplicityElement) {
				multiplicity = ((MultiplicityElement)propertyOperationOrParameter).getUpper();
			}
			array = ""; //$NON-NLS-1$
			if(multiplicity == -1) {
				ptr += "*"; //$NON-NLS-1$
			} else if(multiplicity > 1) {
				array = "[" + multiplicity + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		// out an inout parameter are realized by means of a pointer 
		if(propertyOperationOrParameter instanceof Parameter) {
			ParameterDirectionKind directionKind = ((Parameter)propertyOperationOrParameter).getDirection();
			if(directionKind == ParameterDirectionKind.IN_LITERAL) {
				ptr += " /*in*/"; //$NON-NLS-1$
			}
			else if(directionKind == ParameterDirectionKind.OUT_LITERAL) {
				ptr += " /*out*/"; //$NON-NLS-1$
				if(!ptrOrRef) {
					ptr += CppCodeGenUtils.getOutInoutOp();
				}
			}
			else if(directionKind == ParameterDirectionKind.INOUT_LITERAL) {
				ptr += " /*inout*/"; //$NON-NLS-1$
				if(!ptrOrRef) {
					ptr += CppCodeGenUtils.getOutInoutOp();
				}
			}
		}
		// Const
		if (GenUtils.hasStereotype(propertyOperationOrParameter, Const.class)) {
			isConst = (propertyOperationOrParameter instanceof Operation) ?
				" const" :	// added at the end of operation, prefix with " " //$NON-NLS-1$
				"const ";	// before operation or parameter, postfix with " " //$NON-NLS-1$
		}
		else {
			isConst = ""; //$NON-NLS-1$
		}
	}
}
