/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class ModelOrientedLabelProvider implements ICommonLabelProvider {

	private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider;

	public void init(ICommonContentExtensionSite aConfig) {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(factories));
	}

	public Image getImage(Object element) {
		if (element instanceof Diagram) {
			return myAdapterFactoryLabelProvider.getImage(element);
		}

		return myAdapterFactoryLabelProvider.getImage(element);
	}

	public String getText(Object element) {
		if (element instanceof AdditionalResources) {
			return "Additional Resources";
		}

		if (element instanceof Diagram) {
			String name = ((Diagram) element).getName();
			String diagramTypeName = "Diagram";
			return name == null || name.length() == 0 ? diagramTypeName : diagramTypeName + " " + name; //$NON-NLS-1$
		}

		return myAdapterFactoryLabelProvider.getText(element);
	}

	/**
	 * @generated
	 */
	public void addListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.addListener(listener);
	}

	public void dispose() {
		myAdapterFactoryLabelProvider.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	public void removeListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.removeListener(listener);
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

	public String getDescription(Object anElement) {
		return null;
	}

}
