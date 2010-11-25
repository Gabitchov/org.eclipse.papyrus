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


public class UmlCommonJavaValidator extends AbstractUmlCommonJavaValidator {

	/** instance of the validator */
	private static UmlCommonJavaValidator instance = null;

	/** the model */
	private Namespace model;

	/** the context element */
	private Element contextElement;

	/**
	 * Constructor
	 * XText Framework needs to have a validator without parameter?!
	 */
	public UmlCommonJavaValidator() {
		instance = this;
	}

	/**
	 * Inits the fields of this static class
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
		System.out.println(instance);
		return instance;
	}

}
