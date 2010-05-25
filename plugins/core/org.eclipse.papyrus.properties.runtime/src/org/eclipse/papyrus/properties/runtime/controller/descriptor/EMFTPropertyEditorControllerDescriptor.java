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
package org.eclipse.papyrus.properties.runtime.controller.descriptor;

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * Basic configuration for property editor controllers
 */
public class EMFTPropertyEditorControllerDescriptor implements IPropertyEditorControllerDescriptor {

	/** handler used by this controller */
	protected final IEMFModelHandler handler;

	/** boolean that indicates if the controller accepts multi selection */
	protected boolean multiSelection;

	/** controller unique identifier */
	protected String controllerID;

	/** name of the feature to edit */
	protected String featureNameToEdit;

	/** editor descriptor */
	protected IPropertyEditorDescriptor editorDescriptor;

	/**
	 * {@inheritDoc}
	 */
	public boolean acceptMultiSelection() {
		return multiSelection;
	}

	/**
	 * Returns the name of the feature to edit
	 * 
	 * @return the name of the feature to edit
	 */
	public String getFeatureNameToEdit() {
		return featureNameToEdit;
	}

	/**
	 * Returns the handler id for the controller
	 * 
	 * @return the handler id for the controller
	 */
	public IEMFModelHandler getHandler() {
		return handler;
	}

	/**
	 * Creates a new PropertyEditorDescriptor.
	 * 
	 * @param controllerID
	 *        id of the controller described by this element
	 * @param multiSelection
	 *        boolean that indicates if the controller described accepts multi-selection
	 * @param featureNameToEdit
	 *        the name of feature to edit for the controller configured by this descriptor
	 * @param handler
	 *        the handler id for the controller
	 * @param editorDescriptor
	 *        descriptor of the editor managed by this controller
	 */
	public EMFTPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, String featureNameToEdit, IEMFModelHandler handler, IPropertyEditorDescriptor editorDescriptor) {
		this.controllerID = controllerID;
		this.multiSelection = multiSelection;
		this.featureNameToEdit = featureNameToEdit;
		this.handler = handler;
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getControllerID() {
		return controllerID;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor getEditorDescriptor() {
		return editorDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/EMFTController.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "EMFTController for: " + getFeatureNameToEdit();
	}

}
