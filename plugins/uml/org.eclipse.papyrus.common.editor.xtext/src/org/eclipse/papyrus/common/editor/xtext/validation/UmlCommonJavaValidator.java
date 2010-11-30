/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.common.editor.xtext.validation;

import org.eclipse.papyrus.common.editor.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.xtext.validation.Check;

/**
 * 
 * This validator provides :
 * <ul>
 * <li>a method to validate the fields</li>
 * <li>others methods to manipulate easily the edited element in the XText Editor</li>
 * </ul>
 * 
 */
public class UmlCommonJavaValidator extends AbstractUmlCommonJavaValidator {

	/** instance of the validator */
	private static UmlCommonJavaValidator instance = null;

	/** the model */
	private Namespace model;

	/** the context element */
	private Element contextElement;

	/** the possible type for the edited element (used when the element is a TypedElement */
	private Class<?> wantedType;

	/** boolean to know if the multiplicity is correct or not! */
	protected boolean valid_MultiplicityRule = true;

	/**
	 * Constructor
	 * XText Framework needs to have a validator without parameter?!
	 */
	public UmlCommonJavaValidator() {
		instance = this;
	}

	/**
	 * Inits the fields of this class
	 * 
	 * @param _contextElement
	 *        the context element
	 */
	public void init(Element _contextElement) {
		contextElement = _contextElement;
		if(contextElement != null) {
			Element elem = contextElement.getOwner();
			while(elem.getOwner() != null) {
				elem = elem.getOwner();
			}
			model = (Namespace)elem;
		}
	}

	/**
	 * Inits the fields of this class
	 * 
	 * @param _contextElement
	 *        the context element
	 * @param wantedType
	 *        init the wanted Type (used only when the edited element is a Typed Element
	 */
	public void init(Element _contextElement, Class<?> wantedType) {
		this.init(_contextElement);
		setWantedType(wantedType);
	}

	/**
	 * Getter for {@link #model}
	 * 
	 * @return
	 *         {@link #model}
	 */
	public Namespace getModel() {
		return model;
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the validation is OK
	 */
	public boolean validate() {
		return true;
	}

	/**
	 * Getter for {@link #contextElement}
	 * 
	 * @return
	 *         {@link #contextElement}
	 */
	public Element getContextElement() {
		return contextElement;
	}

	/**
	 * 
	 * @return
	 *         the instance of the current validator
	 */
	public static UmlCommonJavaValidator getInstance() {
		return instance;
	}


	/**
	 * This method shall be overridden in inherited classes
	 * 
	 * Test if the element has the correct type
	 * 
	 * @param obj
	 *        an object to test
	 * @return
	 *         <code>true</code> if the object has the correct type
	 * 
	 */
	public boolean isWantedType(Element el) {
		if(this.wantedType == null) {
			return false;
		}
		return this.wantedType.isInstance(el);
	}

	/**
	 * Setter for the field {@link #wantedType}
	 * 
	 * @param wantedType
	 *        the wantedType
	 */
	protected void setWantedType(Class<?> wantedType) {
		this.wantedType = wantedType;
	}


	/**
	 * Custom validation for multiplicities. Raises an error in the case where the lower bound is upper than the upper bound.
	 * 
	 */
	@Check
	public void checkMultiplicityRule(org.eclipse.papyrus.common.editor.xtext.umlCommon.MultiplicityRule rule) {
		int lowerValue = 0;
		int upperValue = 0;
		String errorMessage = "The upper bound of a multiplicity cannot be lower than the lower bound.";
		try {
			if(rule.getBounds().size() == 2) {
				lowerValue = rule.getBounds().get(0).getValue().equals("*") ? -1 : Integer.valueOf(rule.getBounds().get(0).getValue());
				upperValue = rule.getBounds().get(1).getValue().equals("*") ? -1 : Integer.valueOf(rule.getBounds().get(1).getValue());
				if((lowerValue == -1 && upperValue != -1) || (lowerValue > upperValue && upperValue != -1)) {
					error(errorMessage, rule, UmlCommonPackage.BOUND_SPECIFICATION__VALUE);
					valid_MultiplicityRule = false;
				} else {
					valid_MultiplicityRule = true;
				}
			}
		} catch (Exception e) {
			// An exception may be raised only in the case where the syntax for multiplicities is not respected.
			// No error needs to be generated (the syntax error is automatically handled by XText)
		}
	}
}
