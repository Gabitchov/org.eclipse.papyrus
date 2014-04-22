/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.providers;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.CustomizedTreeContentProvider;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;

/**
 * The customization editor's content provider. Based on the EMF Facet
 * customizable content provider,
 *
 * @author Camille Letavernier
 */
public class ContextContentProvider extends CustomizedTreeContentProvider {

	/**
	 * Constructor.
	 */
	public ContextContentProvider() {
		super(org.eclipse.papyrus.infra.emf.Activator.getDefault().getCustomizationManager());
	}

	/**
	 * @param inputElement
	 *        : A ResourceSet
	 * @return The root EObjects from the input ResourceSet
	 */
	@Override
	public EObject[] getRootElements(Object inputElement) {
		if(inputElement instanceof ResourceSet) {
			ResourceSet resourceSet = (ResourceSet)inputElement;

			if(resourceSet.getResources().isEmpty()) {
				return null;
			}

			Set<EObject> elements = new LinkedHashSet<EObject>();

			elements.addAll(resourceSet.getResources().get(0).getContents());
			Set<Context> allContexts = new LinkedHashSet<Context>();
			for(EObject element : elements) {
				if(element instanceof Context) {
					allContexts.addAll(PropertiesUtil.getDependencies((Context)element));
				}
			}
			elements.addAll(allContexts);
			return elements.toArray(new EObject[elements.size()]);
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
