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

import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;


/**
 * State for controller descriptors
 */
public class ControllerDescriptorState extends AbstractState {

	/** identifier for the controller descriptor editor dialog */
	private static final String CONTROLLER_DESCRIPTOR_EDITOR_DLG = "ControllerDescriptorEditorDialog";

	/** descriptor managed by this state */
	protected IPropertyEditorControllerDescriptor descriptor;


	/**
	 * Creates a new ControllerDescriptorState.
	 * 
	 */
	public ControllerDescriptorState(IPropertyEditorControllerDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	/**
	 * Returns the descriptor managed by this state
	 * 
	 * @return the descriptor managed by this state
	 */
	public IPropertyEditorControllerDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return CONTROLLER_DESCRIPTOR_EDITOR_DLG;
	}

}
