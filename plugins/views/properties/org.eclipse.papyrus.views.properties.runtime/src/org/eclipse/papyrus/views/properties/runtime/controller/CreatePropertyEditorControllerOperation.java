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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Specific operation for emft-based controllers
 */
public class CreatePropertyEditorControllerOperation implements IOperation {

	/** the parent of all controls created by the editor */
	private Composite parent;

	/** List of EObjects to edit */
	private List<Object> objectsToEdit;

	/** configuration of the EMFTPropertyEditorController */
	private final IPropertyEditorControllerDescriptor descriptor;

	/** id of the controller to create */
	private String controllerID;


	/**
	 * Creates a new CreatePropertyEditorControllerOperation.
	 * 
	 * @param id
	 *        the identifier of the editor controller to create
	 * @param objectsToEdit
	 *        List of EObjects to edit
	 * @param descriptor
	 *        the configuration of the editor
	 * @param parent
	 *        parent of all controls created by the editor
	 */
	public CreatePropertyEditorControllerOperation(String id, List<Object> objectsToEdit, Composite parent, IPropertyEditorControllerDescriptor descriptor) {
		this.controllerID = id;
		this.descriptor = descriptor;
		this.objectsToEdit = objectsToEdit;
		this.parent = parent;
	}

	/**
	 * Returns the identifier of the specific controller to find
	 * 
	 * @return the identifier of the controller editor to find.
	 */
	public String getControllerIdentifier() {
		return controllerID;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorController execute(IProvider provider) {
		if(provider instanceof PropertyEditorControllerProvider) {
			if(checkMultiSelection()) {
				// this descriptor allows multi-selection edition. Create the given controller
				IPropertyEditorController controller = ((PropertyEditorControllerProvider)provider).createPropertyEditorController(getControllerIdentifier());
				IStatus status = controller.initController(parent, objectsToEdit, descriptor);
				if(status.getSeverity() != Status.ERROR) {
					return controller;
				} else {
					Activator.log.error("(" + status.getSeverity() + ") Error during creation of Property Editor Controller: " + status.getMessage(), null);
					return null;
				}

			}

			return null;
		} else {
			Activator.log.error("CreatePropertyEditorControllerOperation should execute on a PropertyEditorControllerProvider", null);
		}
		return null;
	}

	/**
	 * Checks if the current selection is supported by the controller
	 * 
	 * @param descriptor
	 *        the descriptor to check
	 * @param objectsToEdit
	 *        the selection of objects
	 * @return <code>true</code> if the selection is OK for the controller
	 */
	protected boolean checkMultiSelection() {
		int selectionSize = objectsToEdit.size();
		if(selectionSize > 1) {
			// multi selection. check if the controller accepts this condition
			return descriptor.acceptMultiSelection();
		}
		// selection has only one element => controller should be ok in every cases
		return true;
	}


}
