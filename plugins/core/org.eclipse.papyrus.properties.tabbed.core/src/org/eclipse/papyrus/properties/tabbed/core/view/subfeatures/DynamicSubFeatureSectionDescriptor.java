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

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
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
	public DynamicSubFeatureSectionDescriptor(String id, String tabId, List<IConstraintDescriptor> constraints, int selectionSize, String adapterID, List<String> replacedSectionIds, List<String> viewsId, SubFeatureDescriptor subFeatureDescriptor, int maxColumn, SubFeatureContainerDescriptor containerDescriptor) {
		super(id, tabId, constraints, selectionSize, adapterID, replacedSectionIds, viewsId);
		this.maxColumn = maxColumn;
		this.subFeatureDescriptor = subFeatureDescriptor;
		this.subFeatureContainerDescriptor = containerDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ISection getSectionClass() {
		// parses the configuration if required
		if(unparsed) {
			for(String id : fragmentsId) {
				FragmentDescriptor descriptor = PropertyViewService.getInstance().getFragmentDescriptor(id);
				if(descriptor != null) {
					fragmentDescriptors.add(descriptor);
				} else {
					Activator.log.error("impossible to find the view descriptor with id: " + id, null);
					parseSectionFailed = true;
				}
			}
			unparsed = false;
		}
		if(!parseSectionFailed) {
			return new DynamicSubFeatureSection(fragmentDescriptors, subFeatureDescriptor, maxColumn, subFeatureContainerDescriptor);
		}

		return null;
	}

	/**
	 * Returns the maximum column number for the layout
	 * 
	 * @return the maximum column number for the layout
	 */
	public int getMaxColumn() {
		return maxColumn;
	}

}
