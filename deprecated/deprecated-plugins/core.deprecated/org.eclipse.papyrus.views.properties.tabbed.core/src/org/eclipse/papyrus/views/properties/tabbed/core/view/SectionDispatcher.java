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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;

/**
 * This class chooses which section should be visible or not, given the current selection
 */
public class SectionDispatcher {

	/** instance of this class */
	protected static SectionDispatcher instance;

	/** current selection */
	protected ISelection selection;

	/** cache list of valid descriptors */
	protected List<DynamicSectionDescriptor> validSectionDescriptors;

	/**
	 * Creates a new SectionDispatcher. This constructor is not visible, using singleton pattern.
	 */
	protected SectionDispatcher() {
	}

	/**
	 * Returns the singleton instance of this dispatcher.
	 * 
	 * @return the singleton instance of this dispatcher
	 */
	public synchronized static SectionDispatcher getInstance() {
		if(instance == null) {
			instance = new SectionDispatcher();
		}
		return instance;
	}

	/**
	 * Returns <code>true</code> if the given section should be displayed for the current object
	 * 
	 * @param dynamicSectionDescriptor
	 *        the descriptor of the section to test
	 * @param objectToTest
	 *        the object to test
	 * @return <code>true</code> if the section should be displayed.
	 */
	public boolean isSectionDisplayed(DynamicSectionDescriptor dynamicSectionDescriptor, Object objectToTest) {
		IEnhancedFilter filter = dynamicSectionDescriptor.getFilter();
		boolean enable = filter.selectWithoutVisibility(objectToTest);
		return enable;
	}

	/**
	 * Returns the set of available sections for a given selection. Used to make perfomance improvement
	 * 
	 * @param part
	 *        the current workbench part.
	 * @param selection
	 *        the selection
	 * @return the list of valid descriptors for the current selection
	 */
	public List<DynamicSectionDescriptor> getDisplayedSections(IWorkbenchPart part, ISelection selection) {
		if(selection == null) {
			validSectionDescriptors = new ArrayList<DynamicSectionDescriptor>();
		} else {
			// check selection is equivalent to the computed one
			if(!selection.equals(this.selection)) {
				this.selection = selection;
				validSectionDescriptors = new ArrayList<DynamicSectionDescriptor>();
				// compute the list for this selection
				List<DynamicSectionDescriptor> availableSectionDescriptors = new ArrayList<DynamicSectionDescriptor>();

				// retrieve the tab descriptors for the given description.
				// for all section descriptors in the tab descriptor, check if the section should be displayed or not.
				// then, remove from the visible list the elements which are filtered by other sections
				for(List<ITabDescriptor> tabDescriptors : PropertyServiceUtil.getTabDescriptors()) {
					for(ITabDescriptor tabDescriptor : tabDescriptors) {
						for(Object descriptor : tabDescriptor.getSectionDescriptors()) {
							ISectionDescriptor sectionDescriptor = (ISectionDescriptor)descriptor;
							if(sectionDescriptor instanceof DynamicSectionDescriptor) {
								boolean enable = ((DynamicSectionDescriptor)sectionDescriptor).appliesToWithoutSectionInheritance(part, selection);;
								if(enable) {
									availableSectionDescriptors.add((DynamicSectionDescriptor)sectionDescriptor);
								}
							}
						}
					}
				}

				// the list of available descriptors is now available, now remove from the list the section descriptors which are erased by others
				for(DynamicSectionDescriptor currentDescriptor : availableSectionDescriptors) {
					boolean isRemoved = false;
					String currentId = currentDescriptor.getId();
					// is this descriptor removed by another one ?
					for(DynamicSectionDescriptor descriptor : availableSectionDescriptors) {
						if(descriptor.getReplacedSectionIds().contains(currentId)) {
							isRemoved = true;
						}
					}

					if(!isRemoved) {
						validSectionDescriptors.add(currentDescriptor);
					}
				}
			}
		}

		// returns the list set in cache
		return validSectionDescriptors;
	}
}
