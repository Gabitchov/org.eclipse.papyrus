/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;


/**
 * Validator for property editors. It checks if the given editor is able to edit a specific type of value
 */
public interface IPropertyEditorTypeValidator {

	/**
	 * returns <code>true</code> if the associated editor is able to edit the specified object
	 * 
	 * @param valueToEdit
	 *        the vlaue to edit
	 * @return <code>true</code> if the associated editor is able to edit the specified object
	 */
	public boolean isValidForValue(Object valueToEdit);

	/**
	 * Sets the validated editor
	 * 
	 * @param editor
	 *        the editor to valid
	 */
	public void setPropertyEditor(AbstractPropertyEditor editor);
}
