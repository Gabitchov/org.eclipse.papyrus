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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.AbstractContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;


/**
 * State for the container descriptors. this is used to do some customization on elements
 */
public class ContainerDescriptorState extends AbstractState {

	/** descriptor managed by this state */
	protected AbstractContainerDescriptor descriptor;

	/** list of controllers managed by this state */
	protected final List<ControllerDescriptorState> controllerDescriptorStates = new ArrayList<ControllerDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;


	/**
	 * Creates a new ContainerDescriptorState.
	 * 
	 * @param descriptor
	 *        the descriptor managed by this state
	 */
	public ContainerDescriptorState(ContainerDescriptor descriptor) {
		this.descriptor = descriptor;

		// read the current list of controller descriptor managed by this state
		List<IPropertyEditorControllerDescriptor> controllerDescriptors = descriptor.getUnparsedControllerDescriptors();
		for(IPropertyEditorControllerDescriptor controllerDescriptor : controllerDescriptors) {
			controllerDescriptorStates.add(new ControllerDescriptorState(controllerDescriptor));
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the descriptor described by this state
	 * 
	 * @return the descriptor described by this state
	 */
	public AbstractContainerDescriptor getDescriptor() {
		return descriptor;
	}


	/**
	 * Returns the controllerDescriptor States for this descriptor
	 * 
	 * @return the controllerDescriptor States for this descriptor
	 */
	public List<ControllerDescriptorState> getControllerDescriptorStates() {
		return controllerDescriptorStates;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "ContainerDescriptorStateDialog";
	}

	/**
	 * Adds a property change listener to this class
	 * 
	 * @param listener
	 *        the listener to add
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a property change listener from this class
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ControllerDescriptorState> getChildren() {
		return getControllerDescriptorStates();
	}

}
