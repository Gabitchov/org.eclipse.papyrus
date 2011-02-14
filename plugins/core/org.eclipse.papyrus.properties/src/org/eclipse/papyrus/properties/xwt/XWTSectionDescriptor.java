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
package org.eclipse.papyrus.properties.xwt;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.DisplayEngine;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractSectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISection;

/**
 * An XWTSectionDescriptor contains Metadata for the XWTSection.
 * It is similar to the {@link Section} class, but in the TabbedPropertyView context.
 * 
 * @author Camille Letavernier
 */
public class XWTSectionDescriptor extends AbstractSectionDescriptor {

	private Section section;

	private ISection displaySection;

	/**
	 * 
	 * Constructs a new XWTSectionDescriptor from the given section and view.
	 * The XWTSections will be displayed in the given DisplayEngine.
	 * 
	 * @param section
	 *        The Section model object containing the section metadata
	 * @param view
	 *        The view the section belongs to
	 * @param display
	 *        The display engine that will be used to display the XWTSection
	 */
	public XWTSectionDescriptor(Section section, View view, DisplayEngine display) {
		this.section = section;
		displaySection = new XWTSection(section, view, display);
	}

	public String getId() {
		return section.getName();
	}

	public ISection getSectionClass() {
		return displaySection;
	}

	public String getTargetTab() {
		return section.getTab().getId();
	}

	@Override
	public String toString() {
		return "Section " + getId() + " => " + displaySection; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		return true;
	}


}
