/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Workspace-independent model validation view (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.labelprovider.service;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * An ExtensibleLabelProvider encapsulates a set of LabelProviders. Each LabelProvider handles only a few kind of elements.
 * The ExtensibleLabelProvider retrieves the most appropriate LabelProvider for each object.
 * 
 * When more than one LabelProvider match an element, the one with the smaller priority is used.
 * 
 * @author Camille Letavernier
 * 
 */
public class ExtensibleLabelProvider implements ILabelProvider, IQualifierLabelProvider, ILabelProviderListener, IColorProvider {

	private final Set<ILabelProviderListener> listeners;

	private final SortedMap<Integer, List<IFilteredLabelProvider>> providers;

	private final ILabelProvider defaultProvider;

	public ExtensibleLabelProvider() {
		listeners = new LinkedHashSet<ILabelProviderListener>();
		providers = new TreeMap<Integer, List<IFilteredLabelProvider>>();

		defaultProvider = new LabelProvider();
	}

	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	public void dispose() {
		listeners.clear();
		for(List<IFilteredLabelProvider> filteredProviders : providers.values()) {
			for(IFilteredLabelProvider provider : filteredProviders) {
				provider.dispose();
			}
		}
		providers.clear();
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	public void registerProvider(int priority, IFilteredLabelProvider provider) {
		getProviders(priority).add(provider);
		provider.addListener(this);
	}

	public Color getForeground(Object element) {
		IColorProvider provider = getProvider(element, IColorProvider.class);
		if(provider != null) {
			return provider.getForeground(element);
		}
		return null;
	}

	public Color getBackground(Object element) {
		IColorProvider provider = getProvider(element, IColorProvider.class);
		if(provider != null) {
			return provider.getBackground(element);
		}
		return null;
	}

	public Image getImage(Object element) {
		return getProvider(element).getImage(element);
	}

	public String getText(Object element) {
		return getProvider(element).getText(element);
	}

	public Image getQualifierImage(Object element) {
		Image result = null;

		IQualifierLabelProvider provider = getProvider(element, IQualifierLabelProvider.class);
		if(provider != null) {
			result = provider.getQualifierImage(element);
		}

		return result;
	}

	public String getQualifierText(Object element) {
		String result = null;

		IQualifierLabelProvider provider = getProvider(element, IQualifierLabelProvider.class);
		if(provider != null) {
			result = provider.getQualifierText(element);
		}

		return result;
	}

	protected final ILabelProvider getProvider(Object element) {
		for(List<IFilteredLabelProvider> filteredProviders : providers.values()) {
			for(IFilteredLabelProvider provider : filteredProviders) {
				if(provider.accept(element)) {
					return provider;
				}
			}
		}

		return defaultProvider;
	}

	protected final <T> T getProvider(Object element, Class<T> type) {
		for(List<IFilteredLabelProvider> filteredProviders : providers.values()) {
			for(IFilteredLabelProvider provider : filteredProviders) {
				if((type.isInstance(provider)) && provider.accept(element)) {
					return type.cast(provider);
				}
			}
		}

		return type.isInstance(defaultProvider) ? type.cast(defaultProvider) : null;
	}

	protected final List<IFilteredLabelProvider> getProviders(int priority) {
		if(!providers.containsKey(priority)) {
			providers.put(priority, new LinkedList<IFilteredLabelProvider>());
		}

		return providers.get(priority);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Forwards the event to each listener
	 */
	public void labelProviderChanged(LabelProviderChangedEvent event) {
		for(ILabelProviderListener listener : listeners) {
			listener.labelProviderChanged(event);
		}
	}
}
