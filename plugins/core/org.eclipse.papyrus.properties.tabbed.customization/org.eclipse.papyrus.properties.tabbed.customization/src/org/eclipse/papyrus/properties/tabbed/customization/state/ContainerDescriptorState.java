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

import java.util.List;

import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;


/**
 * State for the container descriptors. this is used to do some customization on elements
 */
public class ContainerDescriptorState {

	/** descriptor managed by this state */
	protected ContainerDescriptor descriptor;

	/** list of controllers managed by this state */
	protected List<ControllerDescriptorState> controllerDescriptorStates;

	/**
	 * Creates a new ContainerDescriptorState.
	 * 
	 * @param descriptor
	 *        the descriptor managed by this state
	 */
	public ContainerDescriptorState(ContainerDescriptor descriptor) {
		this.descriptor = descriptor;

		// read the current list of controller descriptor managed by this state
		List<IPropertyEditorControllerDescriptor> controllerDescriptors = descriptor.getControllerDescriptors();
		for(IPropertyEditorControllerDescriptor controllerDescriptor : controllerDescriptors) {
			controllerDescriptorStates.add(new ControllerDescriptorState(controllerDescriptor));
		}
	}

	/**
	 * Returns the descriptor described by this state
	 * 
	 * @return the descriptor described by this state
	 */
	public ContainerDescriptor getDescriptor() {
		return descriptor;
	}

}
