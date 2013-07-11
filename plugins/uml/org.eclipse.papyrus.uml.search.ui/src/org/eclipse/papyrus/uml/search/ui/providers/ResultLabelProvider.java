/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.swt.graphics.Image;

public class ResultLabelProvider extends LabelProvider {

	private LabelProviderService labelProviderService;

	public ResultLabelProvider() {
		labelProviderService = new LabelProviderServiceImpl();
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof AbstractResultEntry) {
			return labelProviderService.getLabelProvider().getImage(((AbstractResultEntry)element).elementToDisplay());
		}

		return null;
	}

	@Override
	public String getText(Object element) {
		if(element instanceof AbstractResultEntry) {
			return labelProviderService.getLabelProvider().getText(((AbstractResultEntry)element).elementToDisplay());
		}

		return ""; //$NON-NLS-1$
	}

	@Override
	public void dispose() {
		super.dispose();
		try {
			labelProviderService.disposeService();
		} catch (ServiceException ex) {
			//Ignore
		}
	}

}
