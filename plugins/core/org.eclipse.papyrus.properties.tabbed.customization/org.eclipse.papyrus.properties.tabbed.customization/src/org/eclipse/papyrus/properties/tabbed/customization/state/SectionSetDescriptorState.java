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

import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionSetDescriptor;


/**
 * State for section set descriptors
 */
public class SectionSetDescriptorState {

	/** list of sections for this section set */
	protected final List<SectionDescriptorState> sectionDescriptorStates = new ArrayList<SectionDescriptorState>();

	/** descriptor for section sets */
	protected final SectionSetDescriptor sectionSetDescriptor;

	/**
	 * Creates a new SectionSetDescriptorState.
	 * 
	 * @param sectionSetDescriptor
	 *        descriptor for section sets
	 */
	public SectionSetDescriptorState(SectionSetDescriptor sectionSetDescriptor) {
		this.sectionSetDescriptor = sectionSetDescriptor;

		// retrieve and build the states for the children sections
		for(DynamicSectionDescriptor abstractSectionDescriptor : sectionSetDescriptor.getSectionDescriptors()) {
			SectionDescriptorState sectionState = new SectionDescriptorState(abstractSectionDescriptor);
			sectionDescriptorStates.add(sectionState);
		}
	}

	/**
	 * Returns the sectionSet Descriptor managed by this state
	 * 
	 * @return the sectionSet Descriptor managed by this state
	 */
	public SectionSetDescriptor getSectionSetDescriptor() {
		return sectionSetDescriptor;
	}

}
