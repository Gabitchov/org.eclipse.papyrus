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
package org.eclipse.papyrus.uml.properties.runtime.propertyeditor;

import org.eclipse.papyrus.views.properties.runtime.propertyeditor.AbstractPropertyEditor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.IPropertyEditorTypeValidator;

/**
 * Validator for the simple reference property editors
 */
public class MultiplicityPropertyEditorValidator implements IPropertyEditorTypeValidator {

	/**
	 * Creates a new SimpleReferencePropertyEditorValidator.
	 */
	public MultiplicityPropertyEditorValidator() {

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isValidForValue(Object valueToEdit) {
		//FIXME additional checks to do here... multiplicity should be parseable!
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setPropertyEditor(AbstractPropertyEditor editor) {
	}

}
