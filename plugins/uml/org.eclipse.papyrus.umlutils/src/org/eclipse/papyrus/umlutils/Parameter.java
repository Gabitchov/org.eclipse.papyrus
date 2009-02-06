/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * 
 * 
 * 
 * This class encapsulates an uml2 Parameter
 */
public class Parameter extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Parameter uml2Parameter;

	/**
	 * 
	 * 
	 * @param uml2Parameter
	 */
	public Parameter(org.eclipse.uml2.uml.Parameter uml2Parameter) {
		super(uml2Parameter);
		this.uml2Parameter = uml2Parameter;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Parameter.
	 */
	public org.eclipse.uml2.uml.Parameter getUml2Parameter() {
		return uml2Parameter;
	}

	/**
	 * Gives the type of the parameter or null for void.
	 * 
	 * @return
	 */
	public Type getType() {
		Type result = null;
		if (uml2Parameter.getType() != null) {
			result = new Type(uml2Parameter.getType());
		}
		return result;
	}

	/**
	 * Tells if the parameter is a return parameter.
	 * 
	 * @return
	 */
	public boolean isReturn() {
		return uml2Parameter.getDirection().getValue() == ParameterDirectionKind.RETURN;
	}

	/**
	 * Tells if the parameter is a C pointer.
	 * 
	 * @return
	 */
	public boolean isPointer() {
		return hasStereotype("pointer");
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getDirectionAsString() {
		String direction = "";

		switch (this.uml2Parameter.getDirection().getValue()) {
		case ParameterDirectionKind.IN:
			direction = "in";
			break;
		case ParameterDirectionKind.OUT:
			direction = "out";
			break;
		case ParameterDirectionKind.INOUT:
			direction = "inout";
			break;
		case ParameterDirectionKind.RETURN:
			direction = "return";
			break;
		default:
			break;
		}
		return direction;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getTypeAsString() {
		return (this.getType() != null) ? this.getType().getName() : "<Undefined>";
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getMultiplicityAsString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");

		// special case for [1] and [*]
		int lower = uml2Parameter.getLower();
		int upper = uml2Parameter.getUpper();

		if (lower == upper) {
			buffer.append(lower);
		} else if ((lower == 0) && (upper == -1)) {
			buffer.append("*");
		} else if (upper == -1) {
			buffer.append(lower);
			buffer.append("..*");
		} else {
			buffer.append(lower);
			buffer.append("..");
			buffer.append(upper);
		}

		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getPropertiesAsString() {
		StringBuffer buffer = new StringBuffer();

		// default : unique and not ordered
		if (uml2Parameter.isUnique()) {
			if (uml2Parameter.isOrdered()) {
				buffer.append("ordered");
			} else {
				buffer.append("");
			}
		} else {
			if (uml2Parameter.isOrdered()) {
				buffer.append("ordered, nonunique");
			} else {
				buffer.append("nonunique");
			}
		}
		return buffer.toString();
	}

	/**
	 * generate the label for the Parameter, corresponding to the UML2 notation.
	 * 
	 * @return the label of the parameter
	 */
	public String getLabel() {
		StringBuffer buffer = new StringBuffer();

		// direction
		buffer.append(this.getDirectionAsString());

		// name
		buffer.append(" ");
		buffer.append(this.getName());

		// type
		buffer.append(": ");
		buffer.append(this.getTypeAsString());

		// multiplicity
		buffer.append(" ");
		buffer.append(this.getMultiplicityAsString());

		// default value
		if ((uml2Parameter.getDefault() != null) && !uml2Parameter.getDefault().equals("")) {
			buffer.append("= ");
			buffer.append(uml2Parameter.getDefault());
		}

		// param property
		String properties = this.getPropertiesAsString();
		if (!properties.equals("")) {
			buffer.append("{");
			buffer.append(properties);
			buffer.append("}");
		}

		return buffer.toString();
	}

	/**
	 * Returns the label for this parameter, customized by the given style
	 * 
	 * @param style
	 *            the style of the label
	 * @return the customized label for this parameter
	 * @see ICustomAppearence
	 */
	public String getCustomLabel(int style) {
		final StringBuffer label = new StringBuffer();

		// direction
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_DIRECTION)) {
			label.append(getDirectionAsString());
			label.append(" ");
		}

		// name
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_NAME)) {
			label.append(getName());
		}

		// type
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_TYPE)) {
			label.append(getTypeAsString());
		}

		// multiplicity
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_MULTIPLICITY)) {
			label.append(getMultiplicityAsString());
		}

		// default
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_DEFAULT)) {
			label.append(getDefaultAsString(true));
		}

		// modifier
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_MODIFIERS)) {
			label.append(getPropertiesAsString());
		}

		return label.toString();
	}

	/**
	 * generate the label for the Parameter, corresponding to the UML2 notation.
	 * 
	 * @return the label of the parameter
	 */
	public String getShortLabel() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(this.getName());

		// type
		buffer.append(": ");
		buffer.append(this.getTypeAsString());

		// multiplicity
		buffer.append(" ");
		buffer.append(this.getMultiplicityAsString());

		// default value
		if ((uml2Parameter.getDefault() != null) && !uml2Parameter.getDefault().equals("")) {
			buffer.append("= ");
			buffer.append(uml2Parameter.getDefault());
		}

		return buffer.toString();
	}

	/**
	 * generate the signature label for the Parameter, i.e. only type ands multiplicity.
	 * 
	 * @return the signature label of the parameter
	 */
	public String getSignatureLabel() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(this.getTypeAsString());

		// multiplicity
		String multiplicity = this.getMultiplicityAsString();
		if (!multiplicity.equals("[1]")) {
			buffer.append(" ");
			buffer.append(multiplicity);
		}

		return buffer.toString();
	}

	/**
	 * Returns the default value as a String
	 * 
	 * @param equalSign
	 *            boolean set to <code>true</code> if the label must have the <code>=</code> sign before the default value
	 * @return the default value as a String
	 */
	public String getDefaultAsString(boolean equalSign) {
		String defaultString = "";
		// default value
		if ((uml2Parameter.getDefault() != null) && !uml2Parameter.getDefault().equals("")) {
			if (equalSign) {
				defaultString += "= ";
			}
			defaultString += uml2Parameter.getDefault();
		}
		return "";
	}

	/**
	 * Returns <code>true</code> if the given style has the given mask
	 * 
	 * @param style
	 *            the style to check
	 * @param mask
	 *            the mask to check
	 * @return <code>true</code> if the style has the bit mask
	 */
	boolean hasStyle(int style, int mask) {
		return ((style & mask) != 0);
	}
}
