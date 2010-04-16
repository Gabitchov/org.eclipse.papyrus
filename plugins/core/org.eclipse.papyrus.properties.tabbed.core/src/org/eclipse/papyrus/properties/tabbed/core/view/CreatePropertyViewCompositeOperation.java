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
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.swt.widgets.Composite;

/**
 * Operation used to contribute to the property view
 */
public class CreatePropertyViewCompositeOperation implements IOperation {

	/** the list of objects to edit */
	private List<Object> objectsToEdit;

	/** the composite parent of created controls */
	private Composite parent;

	/** controller descriptor */
	private IPropertyEditorControllerDescriptor controllerDescriptor;

	/**
	 * Creates a new CreatePropertyViewOperation.
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @param parent
	 *        the composite parent of created controls
	 */
	public CreatePropertyViewCompositeOperation(List<Object> objectsToEdit, Composite parent, IPropertyEditorControllerDescriptor controllerDescriptor) {
		this.objectsToEdit = objectsToEdit;
		this.parent = parent;
		this.controllerDescriptor = controllerDescriptor;
	}

	/**
	 * @{inheritDoc
	 */
	public PropertyEditorController execute(IProvider provider) {
		// FIXME use an interface for the provider, instead of an implementation class
		if(provider instanceof XMLPropertyViewProvider) {
			return ((XMLPropertyViewProvider)provider).createControllerEditor(objectsToEdit, controllerDescriptor, parent);
		}
		return null;
	}

	/**
	 * Returns the list of objects to edit
	 * 
	 * @return the list of objects to edit
	 */
	public List<Object> getObjectsToEdit() {
		return objectsToEdit;
	}

	/**
	 * Returns the parent composite of all controls created in the property view
	 * 
	 * @return the parent composite of all controls created in the property view
	 */
	public Composite getParent() {
		return parent;
	}

}
