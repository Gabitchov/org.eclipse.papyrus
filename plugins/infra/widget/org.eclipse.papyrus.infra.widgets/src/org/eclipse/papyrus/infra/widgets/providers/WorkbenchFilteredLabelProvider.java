/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;


/**
 * A LabelProvider contribution to handle Workspace elements
 * 
 * @author Camille Letavernier
 */
public class WorkbenchFilteredLabelProvider extends LabelProvider implements IFilteredLabelProvider {

	private final ILabelProvider workbenchLabelProvider;

	public WorkbenchFilteredLabelProvider() {
		workbenchLabelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
	}

	@Override
	public String getText(Object element) {
		return workbenchLabelProvider.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		return workbenchLabelProvider.getImage(element);
	}

	public boolean accept(Object element) {
		return element instanceof IResource;
	}

}
