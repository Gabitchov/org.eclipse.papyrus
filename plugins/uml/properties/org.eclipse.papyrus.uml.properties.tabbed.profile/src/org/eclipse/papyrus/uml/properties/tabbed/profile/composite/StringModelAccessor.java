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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbed.profile.composite;

import org.eclipse.uml2.uml.Element;

/**
 * Accessor to model elements
 */
public abstract class StringModelAccessor {

	/**
	 * This method should restore the value of the text area for the specified element
	 * 
	 * @param element
	 *            the element to read
	 * @return the string corresponding to the value to edit
	 */
	public abstract String getTextFromModel(Element element);

	/**
	 * this method should take the text in the text area and modify the model using this information
	 * 
	 * @param element
	 *            the element to modify
	 * @param newValue
	 *            the text corresponding to the new value to edit
	 */
	public abstract void setModelFromText(Element element, String newValue);
}
