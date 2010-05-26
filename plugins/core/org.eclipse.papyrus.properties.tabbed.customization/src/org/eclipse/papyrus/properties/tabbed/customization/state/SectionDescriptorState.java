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

import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;


/**
 * State for section descriptors
 */
public class SectionDescriptorState extends AbstractState {

	/** section descriptor managed by this state */
	protected DynamicSectionDescriptor sectionDescriptor;

	/** list of fragment descriptor states */
	private List<FragmentDescriptorState> fragmentDescriptorStates = new ArrayList<FragmentDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/**
	 * Creates a new SectionDescriptorState.
	 * 
	 * @param sectionDescriptor
	 *        the section descriptor managed by this state
	 */
	public SectionDescriptorState(DynamicSectionDescriptor sectionDescriptor) {
		this.sectionDescriptor = sectionDescriptor;

		List<String> fragmentIds = sectionDescriptor.getFragmentsId();
		for(String id : fragmentIds) {
			/// retrieve the descriptor and creates a state on it
			FragmentDescriptor fragmentDescriptor = PropertyViewService.getInstance().getFragmentDescriptor(id);
			if(fragmentDescriptor != null) {
				getFragmentDescriptorStates().add(new FragmentDescriptorState(fragmentDescriptor));
			}
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the section Descriptor managed by this state
	 * 
	 * @return the section Descriptor managed by this state
	 */
	public DynamicSectionDescriptor getDescriptor() {
		return sectionDescriptor;
	}

	/**
	 * Returns the fragmentDescriptor States for the section descriptor
	 * 
	 * @return the fragmentDescriptorStates for the section descriptor
	 */
	public List<FragmentDescriptorState> getFragmentDescriptorStates() {
		return fragmentDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "SectionDescriptorStateDialog";
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
}
