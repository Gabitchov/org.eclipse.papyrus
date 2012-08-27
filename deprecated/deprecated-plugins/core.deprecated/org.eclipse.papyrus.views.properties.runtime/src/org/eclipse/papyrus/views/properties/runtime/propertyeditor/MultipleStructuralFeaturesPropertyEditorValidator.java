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
 * Validator for Multiple structural features Property Editors
 */
public class MultipleStructuralFeaturesPropertyEditorValidator implements IPropertyEditorTypeValidator {

	/**
	 * Constructor.
	 */
	public MultipleStructuralFeaturesPropertyEditorValidator() {
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isValidForValue(Object valueToEdit) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setPropertyEditor(AbstractPropertyEditor editor) {
	}

}
