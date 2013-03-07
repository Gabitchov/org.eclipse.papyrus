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

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Stereotype;

import com.swtdesigner.ResourceManager;

/**
 * 
 * Label provider used by the filter dialog to list available types in a search result
 * 
 */
public class FilterTypeLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object object) {
		if(object instanceof ENamedElement) {
			String imagePath = "/icons/full/obj16/" + ((ENamedElement)object).getName() + ".gif"; //$NON-NLS-1$ //$NON-NLS-2$
			return ResourceManager.getPluginImage("org.eclipse.uml2.uml.edit", imagePath); //$NON-NLS-1$
		} else if(object instanceof Stereotype) {
			LabelProviderService service = new LabelProviderServiceImpl();
			try {
				service.startService();
				return service.getLabelProvider().getImage(object);
			} catch (ServiceException e) {
				Activator.log.warn(Messages.FilterTypeLabelProvider_0 + object);
				return null;
			}
		} else {
			return null;
		}

	}

	@Override
	public String getText(Object object) {
		if(object instanceof ENamedElement) {
			return ((ENamedElement)object).getName();
		} else if(object instanceof Stereotype) {
			return ((Stereotype)object).getName();
		} else {
			return ""; //$NON-NLS-1$
		}
	}
}
