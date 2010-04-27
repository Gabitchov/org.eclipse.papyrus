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
package org.eclipse.papyrus.properties.runtime.controller;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.w3c.dom.Node;


/**
 * Operation that creates and configure the descriptor of a property editor controller provider
 */
public class CreatePropertyEditorControllerDescriptorOperation implements IOperation {

	/** id of the controller to configure */
	private final String controllerID;

	/** node that configures the controller */
	private final Node controllerNode;

	/**
	 * Creates a new CreatePropertyEditorControllerDescriptorOperation.
	 * 
	 * @param controllerId
	 *        the id of the configured controller
	 * @param controllerNode
	 *        the node that configures the controller
	 */
	public CreatePropertyEditorControllerDescriptorOperation(String controllerId, Node controllerNode) {
		this.controllerID = controllerId;
		this.controllerNode = controllerNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorControllerDescriptor execute(IProvider provider) {
		IPropertyEditorControllerDescriptor descriptor = null;

		if(provider instanceof PropertyEditorControllerProvider) {
			descriptor = ((PropertyEditorControllerProvider)provider).generateDescriptor(controllerID, controllerNode);
		}

		return descriptor;
	}

	/**
	 * Returns the controller unique identifier
	 * 
	 * @return the controller unique identifier
	 */
	public String getControllerID() {
		return controllerID;
	}

}
