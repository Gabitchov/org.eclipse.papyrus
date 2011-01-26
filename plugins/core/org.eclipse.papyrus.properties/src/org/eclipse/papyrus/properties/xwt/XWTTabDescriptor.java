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

import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.DisplayEngine;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;

public class XWTTabDescriptor extends AbstractTabDescriptor {

	private Tab tab;

	public XWTTabDescriptor(Tab tab) {
		this.tab = tab;
	}

	@SuppressWarnings("unchecked")
	public void addSection(Section section, View view, DisplayEngine display) {
		super.getSectionDescriptors().add(new XWTSectionDescriptor(section, view, display));
	}

	public String getCategory() {
		return tab.getCategory();
	}

	public String getId() {
		return tab.getId();
	}

	public String getLabel() {
		return tab.getLabel();
	}

	@Override
	public Image getImage() {
		if(tab.getImage() == null || tab.getImage().equals("")) //$NON-NLS-1$
			return null;

		return new Image(Display.getDefault(), tab.getImage());
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

}
