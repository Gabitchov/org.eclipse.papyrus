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
package org.eclipse.papyrus.emf.embeddededitor.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;


public class CustomizableContentProvider extends CustomizableModelContentProvider {

	public CustomizableContentProvider(CustomizationManager customizationManager) {
		super(customizationManager);
	}

	@Override
	public Object[] getRootElements(final Object inputElement) {
		if(inputElement instanceof IFile) {
			return super.getRootElements(inputElement);
		}

		if(inputElement instanceof ResourceSet) {
			return ((ResourceSet)inputElement).getResources().get(0).getContents().toArray();
		}

		return new Object[0];
	}

	@Override
	public boolean hasChildren(Object parentElement) {
		return getChildren(parentElement).length > 0;
	}

}
