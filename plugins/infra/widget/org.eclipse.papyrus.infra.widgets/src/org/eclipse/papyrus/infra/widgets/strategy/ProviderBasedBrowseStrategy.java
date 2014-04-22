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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
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
	public Object[] getElements() {
		return getValidElements(super.getElements());
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getValidElements(super.getElements(inputElement));
	}

	/**
	 * Filters the valid root elements, ie. the root elements containing
	 * at least one valid child (Or being valid themselves)
	 *
	 * @param roots
	 * @return
	 */
	protected Object[] getValidElements(Object[] roots) {
		if(filterElements) {
			List<Object> rootsList = ListHelper.asList(roots);
			Iterator<?> iterator = rootsList.iterator();
			while(iterator.hasNext()) {
				if(!isValid(iterator.next(), new HashSet<Object>())) {
					iterator.remove();
				}
			}
			return rootsList.toArray();
		}

		return roots;
	}

	@Override
	public Object[] getChildren(Object parent) {
		if(provider == null) {
			Activator.log.warn("The provider has not been initialized");
			return new Object[0];
		}

		return getValidElements(super.getChildren(parent));
	}

	@Override
	public boolean hasChildren(Object parent) {
		//May be expensive
		return getChildren(parent).length > 0;
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
			if(visitedElements.add(getAdaptedValue(element))) {
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

	@Override
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

	/**
	 * {@inheritDoc}
	 *
	 * The basic implementation is a naive tree search
	 *
	 * @param elementToReveal
	 */
	@Override
	public void revealSemanticElement(List<?> elementsToReveal) {
		if(viewer != null) {
			//FIXME: TreeViewers cannot do this search when the items have not yet be expanded.
			//We need to search on the ContentProvider and pass a TreeSelection to the viewer
			viewer.setSelection(new StructuredSelection(elementsToReveal), true);
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		this.viewer = viewer;
	}

	protected Viewer viewer;
}
