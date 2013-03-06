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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.swt.graphics.Image;

/**
 * This is the ElementLabelProvider type. Enjoy.
 */
public class ElementLabelProvider
		extends ProblemLabelProvider {

	private AdapterFactory factory;

	private ExtendedImageRegistry images = ExtendedImageRegistry.getInstance();

	public ElementLabelProvider(ModelSet modelSet) {
		super();

		this.factory = ((AdapterFactoryEditingDomain) modelSet
			.getTransactionalEditingDomain()).getAdapterFactory();
	}

	public String getText(Object element) {
		String result = null;

		if (element instanceof IPapyrusMarker) {
			IPapyrusMarker marker = (IPapyrusMarker) element;
			EObject object = marker.getEObject();
			if (object != null) {
				IItemLabelProvider provider = (IItemLabelProvider) factory
					.adapt(object, IItemLabelProvider.class);
				if (provider != null) {
					result = provider.getText(object);
				}
			}
		}

		return result;
	}

	@Override
	public Image getImage(Object element) {
		Image result = null;

		if (element instanceof IPapyrusMarker) {
			IPapyrusMarker marker = (IPapyrusMarker) element;
			EObject object = marker.getEObject();
			if (object != null) {
				IItemLabelProvider provider = (IItemLabelProvider) factory
					.adapt(object, IItemLabelProvider.class);
				if (provider != null) {
					result = images.getImage(provider.getImage(object));
				}
			}
		}

		return result;
	}
}
