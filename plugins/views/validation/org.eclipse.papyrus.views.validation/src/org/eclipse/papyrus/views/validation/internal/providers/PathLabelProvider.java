/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.IQualifierLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.swt.graphics.Image;

/**
 * This is the PathLabelProvider type. Enjoy.
 */
public class PathLabelProvider
		extends ProblemLabelProvider {

	private LabelProviderService service;

	public PathLabelProvider(LabelProviderService service) {
		super();

		this.service = service;
	}

	@Override
	public String getText(Object element) {
		String result = null;

		if (element instanceof IPapyrusMarker) {
			element = ((IPapyrusMarker) element).getEObject();
			ILabelProvider provider = service.getLabelProvider(element);
			if (provider instanceof IQualifierLabelProvider) {
				result = ((IQualifierLabelProvider) provider)
					.getQualifierText(element);
			}
		}

		return result;
	}

	@Override
	public Image getImage(Object element) {
		Image result = null;

		if (element instanceof IPapyrusMarker) {
			element = ((IPapyrusMarker) element).getEObject();
			ILabelProvider provider = service.getLabelProvider(element);
			if (provider instanceof IQualifierLabelProvider) {
				result = ((IQualifierLabelProvider) provider)
					.getQualifierImage(element);
			}
		}

		return result;
	}
}
