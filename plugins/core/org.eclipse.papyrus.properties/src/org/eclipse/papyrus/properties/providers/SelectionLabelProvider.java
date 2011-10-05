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
package org.eclipse.papyrus.properties.providers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * A class for providing labels for a selected element.
 * This label provider dispatchs the calls to the label providers
 * registered through an extension point, according to the given selection
 * 
 * @author Camille Letavernier
 * 
 */
public class SelectionLabelProvider extends LabelProvider {

	public static final String EXTENSION_ID = "org.eclipse.papyrus.properties.labelprovider"; //$NON-NLS-1$

	public static final String LABEL_PROVIDER_PROPERTY = "labelProvider"; //$NON-NLS-1$

	public static final String PRIORITY_PROPERTY = "priority"; //$NON-NLS-1$

	protected final TreeMap<Integer, Collection<IFilteredLabelProvider>> labelProviders = new TreeMap<Integer, Collection<IFilteredLabelProvider>>();

	public SelectionLabelProvider() {
		readExtensionPoint();
	}

	protected void readExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			try {
				final IFilteredLabelProvider provider = (IFilteredLabelProvider)e.createExecutableExtension(LABEL_PROVIDER_PROPERTY);
				final int priority = Integer.parseInt(e.getAttribute(PRIORITY_PROPERTY));
				getLabelProviders(priority).add(provider);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	protected Collection<IFilteredLabelProvider> getLabelProviders(int priority) {
		if(!labelProviders.containsKey(priority)) {
			labelProviders.put(priority, new LinkedList<IFilteredLabelProvider>());
		}
		return labelProviders.get(priority);
	}

	@Override
	public String getText(Object element) {
		return getLabelProvider(element).getText(element);
	}

	@Override
	public Image getImage(Object element) {
		return getLabelProvider(element).getImage(element);
	}

	protected ILabelProvider getLabelProvider(Object element) {
		if(element instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)element;
			for(Collection<IFilteredLabelProvider> providers : labelProviders.values()) {
				for(IFilteredLabelProvider labelProvider : providers) {
					if(labelProvider.accept(selection)) {
						return labelProvider;
					}
				}
			}
		}

		return new LabelProvider(); //Default
	}
}
