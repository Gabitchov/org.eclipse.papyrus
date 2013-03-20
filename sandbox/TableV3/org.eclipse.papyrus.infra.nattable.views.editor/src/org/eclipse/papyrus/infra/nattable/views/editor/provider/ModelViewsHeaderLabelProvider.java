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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.views.editor.provider;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.emf.nattable.registry.EStructuralFeatureImageRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.views.editor.utils.Utils;
import org.eclipse.swt.graphics.Image;


public class ModelViewsHeaderLabelProvider extends EMFFeatureHeaderLabelProvider {


	public ModelViewsHeaderLabelProvider() {
		int i = 0;
		i++;
	}

	@Override
	public boolean accept(final Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final Object object = ((ILabelProviderContextElement)element).getObject();
			String id = "";
			if(object instanceof IdAxis) {
				id = ((IdAxis)object).getElement();
			}
			if(object instanceof String) {
				id = (String)object;
			}
			return id.startsWith(Utils.NATTABLE_EDITOR_PAGE_ID);
		}
		return false;
	}

	@Override
	public String getText(final Object element) {
		final Object object = ((ILabelProviderContextElement)element).getObject();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		String id = "";
		if(object instanceof IdAxis) {
			id = ((IdAxis)object).getElement();
		}
		if(object instanceof String) {
			id = (String)object;
		}
		final String name = id.replaceFirst(Utils.NATTABLE_EDITOR_PAGE_ID, "");
		Object type = null;
		boolean isDerived = false;
		int lowerBounds = 1;
		int upperBounds = 1;
		if(Utils.VIEW_NAME.equals(name)) {
			lowerBounds = 0;
			type = EcorePackage.eINSTANCE.getEString();
		} else if(Utils.VIEW_IS_OPEN.equals(name)) {
			isDerived = true;
			type = EcorePackage.eINSTANCE.getEBoolean();
		} else if(Utils.VIEW_CONTEXT.equals(name)) {
			type = EcorePackage.eINSTANCE.getEObject();
		}
		return getText(configRegistry, name, type, isDerived, lowerBounds, upperBounds);
	}

	@Override
	public Image getImage(final Object element) {
		final Object object = ((ILabelProviderContextElement)element).getObject();
		String id = "";
		if(object instanceof IdAxis) {
			id = ((IdAxis)object).getElement();
		}
		if(object instanceof String) {
			id = (String)object;
		}
		final String columnName = id.replaceFirst(Utils.NATTABLE_EDITOR_PAGE_ID, "");
		if(Utils.VIEW_NAME.equals(columnName) || Utils.VIEW_IS_OPEN.equals(columnName)) {
			return EStructuralFeatureImageRegistry.getAttributeIcon();
		} else if(Utils.VIEW_CONTEXT.equals("context")) {
			return EStructuralFeatureImageRegistry.getLinkIcon();
		}
		return null;
	}
}
