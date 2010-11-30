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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;

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
}
