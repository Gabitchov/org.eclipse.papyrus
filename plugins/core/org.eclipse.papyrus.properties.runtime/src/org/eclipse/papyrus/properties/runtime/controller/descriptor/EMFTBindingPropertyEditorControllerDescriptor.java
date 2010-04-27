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

import org.eclipse.papyrus.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;

/**
 * Basic configuration for property editor controllers
 */
public class EMFTBindingPropertyEditorControllerDescriptor extends EMFTPropertyEditorControllerDescriptor implements IBindingLabelProviderDescriptor {

	/** message to bind */
	private String message;

	/** name of the features to bind */
	private String[] featuresName;

	/**
	 * Creates a new EMFTBindingPropertyEditorControllerDescriptor.
	 * 
	 * @param controllerID
	 *        the id of the controller
	 * @param multiSelection
	 *        indicates if the controller accepts multi selection
	 * @param featureNameToEdit
	 *        name of the features to edit
	 * @param handlerID
	 *        id of the model handler
	 * @param editorDescriptor
	 *        descriptor of the editor
	 * @param message
	 *        message to bind
	 * @param featuresName
	 *        names of the features to bind
	 */
	public EMFTBindingPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, String featureNameToEdit, IEMFModelHandler handler, IPropertyEditorDescriptor editorDescriptor, String message, String[] featuresName) {
		super(controllerID, multiSelection, featureNameToEdit, handler, editorDescriptor);
		this.message = message;
		this.featuresName = featuresName;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getFeaturesNameToBind() {
		return featuresName;
	}
}
