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

public class XWTSectionDescriptor extends AbstractSectionDescriptor {

	private Section section;

	private ISection displaySection;

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
