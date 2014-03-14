/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.navigation;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.graphics.Image;


public class DiagramNavigableElement implements NavigableElement {

	protected Diagram targetDiagram;

	public DiagramNavigableElement(Diagram target) {
		this.targetDiagram = target;
	}

	public String getLabel() {
		return "Navigate to diagram " + targetDiagram.getName();
	}

	public String getDescription() {
		return String.format("Navigates to the %s %s", targetDiagram.getType(), targetDiagram.getName());
	}

	public boolean navigate(NavigationTarget navigationContext) {
		try {
			final IPageManager pageManager = ServiceUtilsForEObject.getInstance().getIPageManager(targetDiagram);
			if(pageManager.isOpen(targetDiagram)) {
				pageManager.selectPage(targetDiagram);
			} else {
				pageManager.openPage(targetDiagram);
			}

			return true;
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}

		return false;
	}

	@Deprecated
	public void navigate(IRevealSemanticElement revealSemanticElement) {
	}

	public Image getImage() {
		if(targetDiagram != null) {
			try {
				ILabelProvider labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, targetDiagram).getLabelProvider();
				return labelProvider.getImage(targetDiagram);
			} catch (ServiceException ex) {
				return null;
			}
		}
		return null;
	}

	public boolean isEnabled() {
		return targetDiagram != null;
	}

}
