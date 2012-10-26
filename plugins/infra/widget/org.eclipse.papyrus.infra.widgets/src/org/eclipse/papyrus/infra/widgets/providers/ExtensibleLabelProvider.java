/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
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
public class ExtensibleLabelProvider implements ILabelProvider, ILabelProviderListener {

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

	public Image getImage(Object element) {
		return getProvider(element).getImage(element);
	}

	public String getText(Object element) {
		return getProvider(element).getText(element);
	}

	protected final ILabelProvider getProvider(Object element) {
		for(List<IFilteredLabelProvider> filteredProviders : providers.values()) {
			for(IFilteredLabelProvider provider : filteredProviders) {
				if(provider.accept(element)) {
					System.out.println("Using provider " + provider.getClass().getName());
					return provider;
				}
			}
		}

		return defaultProvider;
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
