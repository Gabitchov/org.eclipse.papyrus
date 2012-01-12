/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.providers;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ViewerFilter;

@Deprecated
public class EncapsulatedComboViewer extends ComboViewer {

	public EncapsulatedComboViewer(ComboViewer viewer) {
		super(viewer.getCCombo());
		if(viewer.getContentProvider() != null) {
			super.setContentProvider(viewer.getContentProvider());
		}
		if(viewer.getInput() != null) {
			super.setInput(viewer.getInput());
		}
		if(viewer.getLabelProvider() != null) {
			super.setLabelProvider(viewer.getLabelProvider());
		}
		if(viewer.getFilters() != null) {
			super.setFilters(viewer.getFilters());
		}
	}

	@Override
	public void setFilters(ViewerFilter[] filters) {
		for(ViewerFilter filter : filters) {
			addFilter(filter);
		}
	}

	@Override
	public void addFilter(ViewerFilter filter) {
		super.addFilter(new EncapsulatedViewerFilter(filter));
	}
}
