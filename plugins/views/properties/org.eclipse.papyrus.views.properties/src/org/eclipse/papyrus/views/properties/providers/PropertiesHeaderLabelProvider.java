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
package org.eclipse.papyrus.views.properties.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.swt.graphics.Image;

/**
 * An extensible LabelProvider for the Properties View header. It is based
 * on the papyrus {@link LabelProviderService}
 * 
 * @author Camille Letavernier
 */
public class PropertiesHeaderLabelProvider extends LabelProvider {


	private final ILabelProvider delegate;

	/**
	 * The {@link LabelProviderService} Context
	 */
	public final static String PROPERTIES_HEADER_CONTEXT = "org.eclipse.papyrus.views.properties.header.labelProvider.context";

	public PropertiesHeaderLabelProvider() {
		LabelProviderService labelProviderService = new LabelProviderServiceImpl();
		delegate = labelProviderService.getLabelProvider(PROPERTIES_HEADER_CONTEXT);
	}

	@Override
	public String getText(Object element) {
		return delegate.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		return delegate.getImage(element);
	}

	@Override
	public void dispose() {
		delegate.dispose();
	}
}
