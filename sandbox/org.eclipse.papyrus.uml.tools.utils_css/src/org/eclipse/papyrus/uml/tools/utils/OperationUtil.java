/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Iterator;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Operation</code><BR>
 */
public class OperationUtil {

	/**
	 * return the custom label of the operation, given UML2 specification and a custom style.
	 * 
	 * @param style
	 *        the integer representing the style of the label
	 * 
	 * @return the string corresponding to the label of the operation
	 */
	public static String getCustomLabel(Operation operation, int style) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" "); // adds " " first for correct display considerations

		// visibility
		if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(operation));
		}

		// name
		if((style & ICustomAppearence.DISP_NAME) != 0) {
			buffer.append(" ");
			buffer.append(operation.getName());
		}

		// 
		// parameters : '(' parameter-list ')'
		buffer.append("(");
		buffer.append(OperationUtil.getParametersAsString(operation, style));
		buffer.append(")");

		// return type
		if((style & ICustomAppearence.DISP_RT_TYPE) != 0) {
			buffer.append(OperationUtil.getReturnTypeAsString(operation, style));
		}

		// modifiers
		if((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
			String modifiers = OperationUtil.getModifiersAsString(operation);
			if(!modifiers.equals("")) {
				buffer.append("{");
				buffer.append(modifiers);
				buffer.append("}");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns return parameter label as a string, string parametrized with a style mask.
	 * 
	 * @param style
	 *        the mask that indicates which element to display
	 * @return a string containing the return parameter type
	 */
	private static String getReturnTypeAsString(Operation operation, int style) {
		boolean displayType = ((style & ICustomAppearence.DISP_RT_TYPE) != 0);
		boolean displayMultiplicity = ((style & ICustomAppearence.DISP_RT_MULTIPLICITY) != 0);
		StringBuffer label = new StringBuffer("");

		// Retrieve the return parameter (assume to be unique if defined)
		Parameter returnParameter = OperationUtil.getReturnParameter(operation);
		// Create the string for the return type
		if(returnParameter == null) {
			// no-operation: label = ""

		} else if(!displayType && !displayMultiplicity) {
			// no-operation: label = ""

		} else {
			label.append(": ");
			if(displayType) {
				label.append(TypedElementUtil.getTypeAsString(returnParameter));
			}

			if(displayMultiplicity) {
				label.append(MultiplicityElementUtil.getMultiplicityAsString(returnParameter));
			}
		}
		return label.toString();
	}

	/**
	 * Returns operation parameters as a string, the label is customized using a bit mask
	 * 
	 * @return a string containing all parameters separated by commas
	 */
	private static String getParametersAsString(Operation operation, int style) {
		StringBuffer paramString = new StringBuffer();
		Iterator<Parameter> paramIterator = operation.getOwnedParameters().iterator();
		boolean firstParameter = true;
		while(paramIterator.hasNext()) {
			Parameter parameter = paramIterator.next();
			// Do not include return parameters
			if(!parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {



				// get the label for this parameter
				String parameterString = ParameterUtil.getCustomLabel(parameter, style);
				if (!parameterString.trim().equals("")) {
					if (!firstParameter) {
						paramString.append(", ");
					}
					paramString.append(parameterString);
					firstParameter = false;
				}
			}
		}
		return paramString.toString();
	}

	/**
	 * Returns operation modifiers as string, separated with comma.
	 * 
	 * @return a string containing the modifiers
	 */
	private static String getModifiersAsString(Operation operation) {
		StringBuffer buffer = new StringBuffer();
		boolean needsComma = false;

		// Return parameter modifiers
		Parameter returnParameter = OperationUtil.getReturnParameter(operation);
		if(returnParameter != null) {
			// non unique parameter
			if(!returnParameter.isUnique()) {
				buffer.append("nonunique");
				needsComma = true;
			}

			// return parameter has ordered values
			if(returnParameter.isOrdered()) {
				if(needsComma) {
					buffer.append(", ");
				}
				buffer.append("ordered");
				needsComma = true;
			}
		}

		// is the operation a query ?
		if(operation.isQuery()) {
			if(needsComma) {
				buffer.append(", ");
			}
			buffer.append("query");
			needsComma = true;
		}

		// is the operation redefining another operation ?
		Iterator<Operation> it = operation.getRedefinedOperations().iterator();
		while(it.hasNext()) {
			Operation currentOperation = it.next();
			if(needsComma) {
				buffer.append(", ");
			}
			buffer.append("redefines ");
			buffer.append(currentOperation.getName());
			needsComma = true;
		}

		// has the operation a constraint ?
		Iterator<Constraint> it2 = operation.getOwnedRules().iterator();
		while(it2.hasNext()) {
			Constraint constraint = it2.next();
			if(needsComma) {
				buffer.append(", ");
			}
			if(constraint.getSpecification() != null) {
				buffer.append(constraint.getSpecification().stringValue());
			}
			needsComma = true;
		}

		return buffer.toString();
	}

	/**
	 * Gives the return parameter for this operation, or <code>null</code> if none exists.
	 * 
	 * @return the return parameter of the operation or <code>null</code>
	 */
	private static Parameter getReturnParameter(Operation operation) {
		// Retrieve the return parameter (assume to be unique if defined)
		Parameter returnParameter = null;

		Iterator<Parameter> it = operation.getOwnedParameters().iterator();
		while((returnParameter == null) && (it.hasNext())) {
			Parameter parameter = it.next();
			if(parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
				returnParameter = parameter;
			}
		}
		return returnParameter;
	}
}
