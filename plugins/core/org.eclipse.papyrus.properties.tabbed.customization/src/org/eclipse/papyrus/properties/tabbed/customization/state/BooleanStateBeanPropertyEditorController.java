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
package org.eclipse.papyrus.properties.tabbed.customization.state;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;


/**
 * Controller for states for customization wizard with boolean values
 */
public class BooleanStateBeanPropertyEditorController extends StateBeanPropertyEditorController {

	/** identifier for this controller */
	public final static String ID = "booleanStateBeanPropertyEditorController";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueInModel(Object value) {
		if(value instanceof String) {
			super.setValueInModel(Boolean.parseBoolean((String)value));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus initPropertyEditor(IPropertyEditorDescriptor descriptor) {
		List<String> values = new ArrayList<String>();
		values.add("true");
		values.add("false");
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(values);
		} else {
			Activator.log.info("Warning: " + descriptor + "could not be completed.");
		}

		return super.initPropertyEditor(descriptor);
	}

}
