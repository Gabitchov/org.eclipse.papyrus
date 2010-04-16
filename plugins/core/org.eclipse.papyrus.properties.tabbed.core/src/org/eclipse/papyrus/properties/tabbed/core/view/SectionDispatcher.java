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

/**
 * This class chooses which section should be visible or not, given the current selection
 */
public class SectionDispatcher {

	/** instance of this class */
	protected static SectionDispatcher instance;

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

		/*
		 * List<DynamicSectionDescriptor> availableSectionDescriptors = new ArrayList<DynamicSectionDescriptor>();
		 * List<DynamicSectionDescriptor> filteredDescriptors = new ArrayList<DynamicSectionDescriptor>();
		 * 
		 * // retrieve the tab descriptors for the given description.
		 * // for all section descriptors in the tab descriptor, check if the section should be displayed or not.
		 * // then, remove from the visible list the elements which are filtered by other sections
		 * for(List<ITabDescriptor> tabDescriptors : PropertyViewService.getInstance().getTabDescriptors()) {
		 * for(ITabDescriptor tabDescriptor : tabDescriptors) {
		 * for(Object descriptor : tabDescriptor.getSectionDescriptors()) {
		 * ISectionDescriptor sectionDescriptor = (ISectionDescriptor)descriptor;
		 * if(sectionDescriptor instanceof DynamicSectionDescriptor) {
		 * IEnhancedFilter filter = ((DynamicSectionDescriptor)sectionDescriptor).getFilter();
		 * boolean enable = filter.selectWithoutVisibility(objectToTest);
		 * if(enable) {
		 * availableSectionDescriptors.add((DynamicSectionDescriptor)sectionDescriptor);
		 * }
		 * }
		 * }
		 * }
		 * }
		 * 
		 * // the list of available descriptors is now available, now remove from the list the section descriptors which are erased by others
		 * for(DynamicSectionDescriptor currentDescriptor : availableSectionDescriptors) {
		 * boolean isRemoved = false;
		 * String currentId = currentDescriptor.getId();
		 * // is this descriptor removed by another one ?
		 * for(DynamicSectionDescriptor descriptor : availableSectionDescriptors) {
		 * if(descriptor.getReplacedSectionIds().contains(currentId)) {
		 * isRemoved = true;
		 * }
		 * }
		 * 
		 * if(!isRemoved) {
		 * filteredDescriptors.add(currentDescriptor);
		 * }
		 * }
		 * 
		 * // now, compare the current descriptor. Is it in the list of filtered descriptors ?
		 * return filteredDescriptors.contains(dynamicSectionDescriptor);
		 */}
}
