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
package org.eclipse.papyrus.infra.widgets.strategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;


public class ProviderBasedBrowseStrategy extends EncapsulatedContentProvider implements TreeBrowseStrategy {

	protected ITreeContentProvider provider;

	protected boolean filterElements = false;

	protected final Map<Object, Boolean> cache = new HashMap<Object, Boolean>();

	protected final Map<Object, Boolean> visibleChildCache = new HashMap<Object, Boolean>();

	public ProviderBasedBrowseStrategy(ITreeContentProvider provider) {
		setProvider(provider);
	}

	public ProviderBasedBrowseStrategy() {

	}

	public void setProvider(ITreeContentProvider provider) {
		encapsulated = provider;
		this.provider = provider;
		filterElements = provider instanceof IHierarchicContentProvider;
		clearCache();
	}

	@Override
	public Object[] getChildren(Object parent) {
		if(provider == null) {
			Activator.log.warn("The provider has not been initialized");
			return new Object[0];
		}

		return filterElements ? getValidChildren(parent, new HashSet<Object>()) : super.getChildren(parent);
	}

	@Override
	public boolean hasChildren(Object parent) {
		//May be expensive
		return getChildren(parent).length > 0;
	}

	protected Object[] getValidChildren(Object parent, Set<Object> visitedElements) {
		List<?> children = ListHelper.asList(super.getChildren(parent));
		Iterator<?> childrenIterator = children.iterator();
		while(childrenIterator.hasNext()) {
			Object child = childrenIterator.next();
			if(!isValid(child, visitedElements)) {
				childrenIterator.remove();
			}
		}

		return children.toArray();
	}

	protected boolean isValid(Object containerElement, Set<Object> visitedElements) {
		if(!cache.containsKey(containerElement)) {
			boolean isVisible;

			if(browseElement(containerElement)) {
				isVisible = isValidValue(containerElement) || hasOneVisibleChild(containerElement, visitedElements);
			} else {
				isVisible = false;
			}

			cache.put(containerElement, isVisible);
		}
		return cache.get(containerElement);
	}

	protected boolean browseElement(Object containerElement) {
		return true;
	}

	protected boolean hasOneVisibleChild(Object element, Set<Object> visitedElements) {
		if(!visibleChildCache.containsKey(element)) {
			boolean result = false;
			if(visitedElements.add(element)) {
				for(Object child : super.getChildren(element)) {
					if(isValid(child, visitedElements)) {
						result = true;
						break;
					}
				}
			}

			visibleChildCache.put(element, result);
		}
		return visibleChildCache.get(element);
	}

	public TreePath findPath(Object semanticElement, Object[] rootElements) {
		return TreePath.EMPTY; //TODO : Naive search
	}

	protected void clearCache() {
		cache.clear();
		visibleChildCache.clear();
	}

	@Override
	public void dispose() {
		super.dispose();
		clearCache();
	}
}
