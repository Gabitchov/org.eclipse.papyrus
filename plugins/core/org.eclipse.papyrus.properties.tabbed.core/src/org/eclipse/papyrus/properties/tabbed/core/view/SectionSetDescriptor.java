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
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.List;

import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;


/**
 * Descriptor for section set (used mostly for configuration purpose)
 */
public class SectionSetDescriptor {

	/** list of section descriptors own by this section set */
	private final List<DynamicSectionDescriptor> sectionDescriptors;

	/** list of constraint descriptors placed on this section set */
	private final List<IConstraintDescriptor> constraintDescriptors;

	/** size of the selection */
	private final int selectionSize;


	/**
	 * Creates a new SectionSetDescriptor.
	 * 
	 */
	public SectionSetDescriptor(List<DynamicSectionDescriptor> sectionDescriptors, List<IConstraintDescriptor> constraintDescriptors, int selectionSize) {
		this.sectionDescriptors = sectionDescriptors;
		this.constraintDescriptors = constraintDescriptors;
		this.selectionSize = selectionSize;
	}


	/**
	 * Returns the sectionDescriptors owned by the described section set
	 * 
	 * @return the sectionDescriptors owned by the described section set
	 */
	public List<DynamicSectionDescriptor> getSectionDescriptors() {
		return sectionDescriptors;
	}


	/**
	 * Returns the constraintDescriptors placed on the described section set
	 * 
	 * @return the constraintDescriptors placed on the described section set
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return constraintDescriptors;
	}


	/**
	 * Returns the size of the selection for this described section set
	 * 
	 * @return the size of the selection for this described section set
	 */
	public int getSelectionSize() {
		return selectionSize;
	}



}
