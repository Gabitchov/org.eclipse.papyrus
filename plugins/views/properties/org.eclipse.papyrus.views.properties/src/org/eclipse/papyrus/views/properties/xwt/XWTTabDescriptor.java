/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.xwt;

import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.runtime.DisplayEngine;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;

/**
 * A Tab descriptor implementation for the TabbedPropertyView.
 * The property view is described by XWT files.
 * 
 * @author Camille Letavernier
 */
public class XWTTabDescriptor extends AbstractTabDescriptor {

	private Tab tab;

	/**
	 * Constructor.
	 * 
	 * @param tab
	 *        The Tab model object containing the Metadata for the tab
	 */
	public XWTTabDescriptor(Tab tab) {
		this.tab = tab;
	}

	/**
	 * Adds a section to this tab
	 * 
	 * @param section
	 *        The Section model object
	 * @param view
	 *        The View model object to which the section belongs
	 * @param display
	 *        The display engine that will be used to display the section
	 */
	@SuppressWarnings("unchecked")
	public void addSection(Section section, View view, DisplayEngine display) {
		super.getSectionDescriptors().add(new XWTSectionDescriptor(section, view, display));
	}

	public String getCategory() {
		String category = tab.getCategory();
		return category == null ? "" : category; //$NON-NLS-1$
	}

	public String getId() {
		return tab.getId();
	}

	public String getLabel() {
		return tab.getLabel();
	}

	@Override
	public Image getImage() {
		String imagePath = tab.getImage();

		if(imagePath == null || imagePath.trim().equals("")) { //$NON-NLS-1$
			return null;
		}

		return Activator.getDefault().getImageFromPlugin(imagePath);
	}

	@Override
	public boolean isIndented() {
		return tab.isIndented();
	}

	@Override
	public String getAfterTab() {
		if(tab.getAfterTab() != null) {
			return tab.getAfterTab().getId();
		}
		return super.getAfterTab();
	}

	@Override
	public String toString() {
		return "Tab " + getLabel() + " => " + getSectionDescriptors(); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @return this tab's priority. The tabs should be ordered by ascending
	 *         priority (i.e. the lower the priority int value, the higher
	 *         the actual priority)
	 */
	public int getPriority() {
		return tab.getPriority();
	}
}
