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
package org.eclipse.papyrus.properties.tabbed.core.view.subfeatures;

import java.util.List;

import org.eclipse.papyrus.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.SubFeatureDescriptor.SubFeatureDescriptorState;
import org.eclipse.ui.views.properties.tabbed.ISection;


/**
 * Descriptor for sections using controllers.
 */
public class DynamicSubFeatureSectionDescriptor extends DynamicSectionDescriptor {

	/** maximal number of columns in the display */
	protected final int maxColumn;

	/** descriptor to give access to the sub-elements */
	protected final SubFeatureDescriptor subFeatureDescriptor;

	/** descriptor for container */
	protected final SubFeatureContainerDescriptor subFeatureContainerDescriptor;

	/**
	 * Creates a new DynamicSectionDescriptor.
	 * 
	 * @param fragmentsId
	 *        id of the views to display in the section
	 * 
	 */
	public DynamicSubFeatureSectionDescriptor(String id, String tabId, List<IConstraintDescriptor> constraints, int selectionSize, String adapterID, List<String> replacedSectionIds, List<IFragmentDescriptor> fragmentDescriptors, SubFeatureDescriptor subFeatureDescriptor, int maxColumn, SubFeatureContainerDescriptor containerDescriptor) {
		super(id, tabId, constraints, selectionSize, adapterID, replacedSectionIds, fragmentDescriptors);
		this.maxColumn = maxColumn;
		this.subFeatureDescriptor = subFeatureDescriptor;
		this.subFeatureContainerDescriptor = containerDescriptor;
	}

	/**
	 * Returns the subFeatureDescriptor for this descriptor
	 * 
	 * @return the subFeatureDescriptor for this descriptor
	 */
	public SubFeatureDescriptor getSubFeatureDescriptor() {
		return subFeatureDescriptor;
	}

	/**
	 * Returns the subFeatureContainerDescriptor for this descriptor
	 * 
	 * @return the subFeatureContainerDescriptor for this descriptor
	 */
	public SubFeatureContainerDescriptor getSubFeatureContainerDescriptor() {
		return subFeatureContainerDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ISection getSectionClass() {
		return new DynamicSubFeatureSection(fragmentDescriptors, subFeatureDescriptor, maxColumn, subFeatureContainerDescriptor);
	}

	/**
	 * Returns the maximum column number for the layout
	 * 
	 * @return the maximum column number for the layout
	 */
	public int getMaxColumn() {
		return maxColumn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SubFeatureSectionDescriptorState createState() {
		return new SubFeatureSectionDescriptorState(this);
	}

	/**
	 * State for {@link SubFeatureContainerDescriptor}
	 */
	public class SubFeatureSectionDescriptorState extends SectionDescriptorState {

		private SubFeatureDescriptorState subFeatureDescriptorState;

		/**
		 * Creates a new SubFeatureSectionDescriptorState.
		 * 
		 * @param sectionDescriptor
		 */
		public SubFeatureSectionDescriptorState(DynamicSubFeatureSectionDescriptor sectionDescriptor) {
			super(sectionDescriptor);

			subFeatureDescriptorState = sectionDescriptor.getSubFeatureDescriptor().createState();
		}


		/**
		 * Returns the subFeatureDescriptorState for this state
		 * 
		 * @return the subFeatureDescriptorState for this state
		 */
		public SubFeatureDescriptorState getSubFeatureDescriptorState() {
			return subFeatureDescriptorState;
		}

	}

}
