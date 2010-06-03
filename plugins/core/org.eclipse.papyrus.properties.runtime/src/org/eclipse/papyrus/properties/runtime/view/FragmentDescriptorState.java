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
package org.eclipse.papyrus.properties.runtime.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptorState;


/**
 * state for Fragment descriptor
 */
public class FragmentDescriptorState extends AbstractState {

	/** descriptor managed by this state */
	protected FragmentDescriptor descriptor;

	/** list of container descriptors state children of this state */
	protected final List<ContainerDescriptorState> containerDescriptorStates = new ArrayList<ContainerDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/**
	 * Creates a new FragmentDescriptorState.
	 * 
	 * @param descriptor
	 *        the fragment descriptor managed by this state
	 */
	public FragmentDescriptorState(FragmentDescriptor descriptor) {
		this.descriptor = descriptor;

		// retrieve and build the states for the container children
		List<ContainerDescriptor> containerDescriptors = descriptor.getContainerDescriptors();
		for(ContainerDescriptor containerDescriptor : containerDescriptors) {
			containerDescriptorStates.add(containerDescriptor.createState());
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	public FragmentDescriptor getDescriptor() {
		return descriptor;
	}


	/**
	 * Returns the containerDescriptor States for this fragment
	 * 
	 * @return the containerDescriptor States for this fragment
	 */
	public List<ContainerDescriptorState> getContainerDescriptorStates() {
		return containerDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "FragmentDescriptorStateDialog";
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
	 * Adds the {@link ContainerDescriptorState} to the list of descriptor states belonging to this fragment
	 * 
	 * @param containerDescriptorState
	 *        the state to add
	 */
	public void addContainerDescriptorState(ContainerDescriptorState containerDescriptorState) {
		containerDescriptorStates.add(containerDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, containerDescriptorStates);
	}

	/**
	 * Removes the {@link ContainerDescriptorState} from the list of descriptor states belonging to this fragment
	 * 
	 * @param containerDescriptorState
	 *        the state to remove
	 */
	public void removeContainerDescriptorState(ContainerDescriptorState containerDescriptorState) {
		containerDescriptorStates.remove(containerDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, containerDescriptorStates);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContainerDescriptorState> getChildren() {
		return getContainerDescriptorStates();
	}
}
