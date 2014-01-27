/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.util.List;
import java.util.Vector;

import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;

/**
 * This class stores the states: sectionSets and tabs
 * It provides corresponding retrieve and store methods
 */
public class StatesStore {

	/** available tab states for this wizard page */
	protected static Vector<TabDescriptorState> tabDescriptorStates;

	/** available section states for this wizard page */
	protected static List<SectionSetDescriptorState> sectionSetDescriptorStates;

	/**
	 * Get the tab descriptor states.
	 * 
	 * @return the list of descriptor states
	 */
	public static List<TabDescriptorState> getTabDescriptorStates() {
		return tabDescriptorStates;
	}

	/**
	 * Set the tab descriptor states.
	 * 
	 * @param tabDescriptorStates2
	 *        the list to set
	 */
	public static void setTabDescriptorStates(List<TabDescriptorState> tabDescriptorStates2) {
		tabDescriptorStates = new Vector<TabDescriptorState>(tabDescriptorStates2);
	}

	/**
	 * Get the sectionSet descriptor states.
	 * 
	 * @return the list of section descriptor states
	 */
	public static List<SectionSetDescriptorState> getSectionSetDescriptorStates() {
		return sectionSetDescriptorStates;
	}

	/**
	 * Set the tab sectionSet states.
	 * 
	 * @param sectionSeDescriptorStates2
	 *        the list to set
	 */
	public static void setSectionSetDescriptorStates(List<SectionSetDescriptorState> sectionSeDescriptorStates2) {
		sectionSetDescriptorStates = new Vector<SectionSetDescriptorState>(sectionSeDescriptorStates2);
	}

	/**
	 * Get the text for the tab mentioned TargetTab of a section.
	 * 
	 * @param id
	 *        the id of the tab to get the text from
	 * @return the text corresponding to the tab
	 */
	public static String getTextSectionDescriptorStateTargetTab(String id) {
		for(TabDescriptorState tabDescriptorState : tabDescriptorStates) {
			if(tabDescriptorState.getId().compareTo(id) == 0) {
				return tabDescriptorState.getText();
			}

		}
		return null;
	}

	/**
	 * Get the text for the section mentioned in AfterSection of a section.
	 * 
	 * @param id
	 *        the id of the section to get the text from
	 * @return the text corresponding to the section
	 */
	public static String getTextSectionDescriptorStateAfterSection(String id) {

		if(id.equals(ISectionDescriptor.TOP)) {
			return id;
		}

		for(SectionSetDescriptorState sectionSetDescriptorState : sectionSetDescriptorStates) {
			for(SectionDescriptorState sectionDescriptorState : sectionSetDescriptorState.getSectionDescriptorStates()) {
				if(sectionDescriptorState.getId().compareTo(id) == 0) {
					return sectionDescriptorState.getText();
				}
			}
		}
		return null;
	}

	/**
	 * Get the text for the section mentioned in id of a replacedSection.
	 * 
	 * @param id
	 *        the id of the section to get the text from
	 * @return the text corresponding to the section
	 */
	public static String getTextReplacedSectionStateId(String id) {
		for(SectionSetDescriptorState sectionSetDescriptorState : sectionSetDescriptorStates) {
			for(SectionDescriptorState sectionDescriptorState : sectionSetDescriptorState.getSectionDescriptorStates()) {
				if(sectionDescriptorState.getId().compareTo(id) == 0) {
					return sectionDescriptorState.getText();
				}
			}
		}
		return null;
	}

	/**
	 * Get the image for the tab (corresponding to TargetTab of a section).
	 * 
	 * @return the image for a tab
	 */
	public static Image getImageSectionDescriptorStateTargetTab() {
		return Activator.getImage("/icons/Tab.gif");
	}

	/**
	 * Get the image for the section (corresponding to AfterSection of a section).
	 * 
	 * @return the image for a section
	 */
	public static Image getImageSectionDescriptorStateAfterSection() {
		return Activator.getImage("/icons/Section.gif");
	}

	/**
	 * Get the image for the section (corresponding to Id of a replacedSection).
	 * 
	 * @return the image for a section
	 */
	public static Image getImageReplacedSectionStateId() {
		return Activator.getImage("/icons/Section.gif");
	}

}
