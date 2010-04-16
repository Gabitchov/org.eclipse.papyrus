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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;

/**
 * Basic configuration for property editor controllers
 */
public class EMFTPropertyEditorControllerDescriptor implements IPropertyEditorControllerDescriptor {

	/** Structural feature to edit */
	private EStructuralFeature featureToEdit = null;

	/** id of the handler used by this controller */
	private String handlerID;

	/** boolean that indicates if the controller accepts multi selection */
	private boolean multiSelection;

	/** controller unique identifier */
	private String controllerID;

	/** name of the feature to edit */
	private String featureNameToEdit;

	/** editor descriptor */
	private IPropertyEditorDescriptor editorDescriptor;

	/**
	 * 
	 * @{inheritDoc
	 */
	public boolean acceptMultiSelection() {
		return multiSelection;
	}

	/**
	 * Returns the feature to edit for the controller configured by this descriptor
	 * 
	 * @return the feature to edit for the controller configured by this descriptor
	 */
	public EStructuralFeature getFeatureToEdit() {
		return featureToEdit;
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
	public String getHandlerID() {
		return handlerID;
	}

	/**
	 * Creates a new PropertyEditorDescriptor.
	 * 
	 * @param featureToEdit
	 *        the feature to edit for the controller configured by this descriptor
	 * @param handlerID
	 *        the handler id for the controller
	 */
	public EMFTPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, EStructuralFeature featureToEdit, String handlerID, IPropertyEditorDescriptor editorDescriptor) {
		this.controllerID = controllerID;
		this.multiSelection = multiSelection;
		this.featureToEdit = featureToEdit;
		this.handlerID = handlerID;
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * Creates a new PropertyEditorDescriptor.
	 * 
	 * @param featureNameToEdit
	 *        the name of feature to edit for the controller configured by this descriptor
	 * @param handlerID
	 *        the handler id for the controller
	 */
	public EMFTPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, String featureNameToEdit, String handlerID, IPropertyEditorDescriptor editorDescriptor) {
		this.controllerID = controllerID;
		this.multiSelection = multiSelection;
		this.featureNameToEdit = featureNameToEdit;
		this.handlerID = handlerID;
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * @{inheritDoc
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

}
