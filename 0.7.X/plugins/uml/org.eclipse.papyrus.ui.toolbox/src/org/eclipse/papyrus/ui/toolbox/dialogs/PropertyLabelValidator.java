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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.dialogs;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.parsers.modelgenerator.PropertyGenerator;
import org.eclipse.uml2.uml.Property;

/**
 * 
 * 
 * Validator for Property Labels
 * 
 * @see org.eclipse.jface.dialogs.InputDialog
 */
public class PropertyLabelValidator implements IInputValidator {

	/**
	 * 
	 */
	private Property property;

	/**
	 * 
	 * 
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * 
	 * 
	 * @param property
	 *        the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

	/**
	 * 
	 * 
	 * @param property
	 */
	public PropertyLabelValidator(Property property) {
		super();
		setProperty(property);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	/**
	 * 
	 * 
	 * @param newText
	 * 
	 * @return
	 */
	public String isValid(String newText) {
		PropertyGenerator generator = new PropertyGenerator(property);
		return generator.parseAndValidateProperty(newText);
	}

}
