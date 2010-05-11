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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;


/**
 * state for Fragment descriptor
 */
public class FragmentDescriptorState {

	/** descriptor managed by this state */
	protected FragmentDescriptor descriptor;

	/** list of container descriptors state children of this state */
	protected List<ContainerDescriptorState> containerDescriptorStates = new ArrayList<ContainerDescriptorState>();

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
			containerDescriptorStates.add(new ContainerDescriptorState(containerDescriptor));
		}
	}

	public FragmentDescriptor getFragmentDescriptor() {
		return descriptor;
	}
}
