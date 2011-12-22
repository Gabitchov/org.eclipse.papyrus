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

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Node;


/**
 * Operation that creates and configure the descriptor of a property editor controller provider
 */
public class CreatePropertyEditorControllerDescriptorOperation implements IOperation {

	/** id of the controller to configure */
	private final String controllerID;

	/** node that configures the controller */
	private final Node controllerNode;

	/** bundle used to load classes for the controllers */
	private final Bundle bundle;

	/**
	 * Creates a new CreatePropertyEditorControllerDescriptorOperation.
	 * 
	 * @param controllerId
	 *        the id of the configured controller
	 * @param controllerNode
	 *        the node that configures the controller
	 * @param bundle
	 *        bundle used to load classes
	 */
	public CreatePropertyEditorControllerDescriptorOperation(String controllerId, Node controllerNode, Bundle bundle) {
		this.controllerID = controllerId;
		this.controllerNode = controllerNode;
		this.bundle = bundle;
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

	/**
	 * Returns the bundle
	 * 
	 * @return the bundle
	 */
	public Bundle getBundle() {
		return bundle;
	}

}
