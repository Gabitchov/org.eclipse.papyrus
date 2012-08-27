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
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.BeanPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;



/**
 * Controller for property editors based on java.beans property
 */
public abstract class BeanPropertyEditorController extends PropertyEditorController implements PropertyChangeListener {

	/** descriptor that configures this controller */
	private BeanPropertyEditorControllerDescriptor descriptor;

	/** identifier for this controller */
	public final static String ID = "beanPropertyEditorController";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus initPropertyEditor(IPropertyEditorDescriptor descriptor) {
		return getPropertyEditor().init(descriptor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus initController(Composite parent, List<Object> objectsToEdit, IPropertyEditorControllerDescriptor descriptor) {
		setParent(parent);
		setObjectsToEdit(objectsToEdit);

		if(descriptor instanceof BeanPropertyEditorControllerDescriptor) {
			this.descriptor = (BeanPropertyEditorControllerDescriptor)descriptor;
		} else {
			return new Status(IStatus.ERROR, Activator.ID, "impossible to adapt descriptor to an EMFTPropertyEditorControllerDescriptor");
		}

		return Status.OK_STATUS;
	}

	/**
	 * Returns the descriptor configuring this controller
	 * 
	 * @return the descriptor configuring this controller
	 */
	public BeanPropertyEditorControllerDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateModel() {
		setValueInModel(getEditorValue());
	}
}
