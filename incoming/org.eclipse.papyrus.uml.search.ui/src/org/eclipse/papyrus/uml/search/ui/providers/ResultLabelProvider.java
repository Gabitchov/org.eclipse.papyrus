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
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.swt.graphics.Image;

public class ResultLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if(element instanceof AbstractResultEntry) {
			Object elementValue = ((AbstractResultEntry)element).getElement();
			if(elementValue instanceof ScopeEntry) {
				ScopeEntry scopeEntry = (ScopeEntry)elementValue;
				try {
					LabelProviderService service = scopeEntry.getServicesRegistry().getService(LabelProviderService.class);

					return service.getLabelProvider().getImage(((AbstractResultEntry)element).elementToDisplay());

				} catch (ServiceException e) {
					Activator.log.warn(Messages.ResultLabelProvider_0 + element);
				}

			}
		}

		return null;
	}

	@Override
	public String getText(Object element) {
		if(element instanceof AbstractResultEntry) {
			Object elementValue = ((AbstractResultEntry)element).getElement();
			if(elementValue instanceof ScopeEntry) {
				ScopeEntry scopeEntry = (ScopeEntry)elementValue;
				try {
					LabelProviderService service = scopeEntry.getServicesRegistry().getService(LabelProviderService.class);

					return service.getLabelProvider().getText(((AbstractResultEntry)element).elementToDisplay());

				} catch (ServiceException e) {
					Activator.log.warn(Messages.ResultLabelProvider_1 + element);
				}

			}
		}

		return ""; //$NON-NLS-1$
	}

}
