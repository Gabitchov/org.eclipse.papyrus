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
package org.eclipse.papyrus.infra.widgets.providers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.widgets.strategy.IStrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.ProviderBasedBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;

/**
 * An abstract ViewerFilter for TreeViewers.
 * 
 * You should extend this class whenever you want to implement a filter
 * for a Tree. An element is visible :
 * - If the method isVisible() returns true
 * - If one of its children is visible
 * - Optionally, if one of its parents is visible ({@link #showIfHasVisibleParent})
 * 
 * This class can implements a cache, which should be cleaned each time
 * a parameter influencing the result of the {@link #isVisible(Viewer, Object, Object)} method is changed ({@link #clearCache()}).
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractTreeFilter extends ViewerFilter {

	/**
	 * If set to true, the results of the filter will be cached, to improve
	 * performance.
	 * 
	 * Implementers are responsible of cleaning the cache (by calling {@link #clearCache()} when the result of the filter on a given
	 * element might change.
	 * 
	 * For example, a string-pattern-based filter should clear the cache when
	 * the pattern changes. The viewer should also be refreshed.
	 */
	protected boolean useCache = true;

	/**
	 * Indicates if an element should be visible when one its parents is visible.
	 * This may be useful, for example, when you want to display all the contents
	 * of a given package, by entering a filter that will match this package.
	 */
	protected boolean showIfHasVisibleParent = false;

	/**
	 * Cache
	 */
	protected final Map<Object, Boolean> visibleElement = new HashMap<Object, Boolean>();

	/**
	 * Cache
	 */
	protected final Map<Object, Boolean> visibleParent = new HashMap<Object, Boolean>();

	/**
	 * Cache
	 */
	protected final Map<Object, Boolean> visibleChild = new HashMap<Object, Boolean>();

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		TreeBrowseStrategy strategy = null;

		if(viewer instanceof StructuredViewer) {
			IContentProvider baseContentProvider = ((StructuredViewer)viewer).getContentProvider();
			if(baseContentProvider instanceof IStrategyBasedContentProvider) {
				strategy = ((IStrategyBasedContentProvider)baseContentProvider).getRevealStrategy();
			}

			if(strategy == null && baseContentProvider instanceof ITreeContentProvider) {
				strategy = new ProviderBasedBrowseStrategy((ITreeContentProvider)baseContentProvider);
			}
		}

		if(strategy == null) { //The contentProvider is not a TreeContentProvider
			return isVisible(viewer, parentElement, element);
		}

		return select(viewer, parentElement, element, strategy);
	}

	protected boolean select(Viewer viewer, Object parentElement, Object element, TreeBrowseStrategy strategy) {
		Set<Object> visitedChildren = new HashSet<Object>();
		Set<Object> visitedParents = new HashSet<Object>();
		if(useCache && visibleElement.containsKey(element)) {
			return visibleElement.get(element);
		}

		boolean isVisible = isVisible(viewer, parentElement, element) || hasOneVisibleChild(viewer, element, strategy, visitedChildren);

		if(showIfHasVisibleParent) {
			isVisible = isVisible || hasOneVisibleParent(viewer, element, strategy, visitedParents);
		}

		if(useCache) {
			visibleElement.put(element, isVisible);
		}

		return isVisible;
	}

	protected boolean hasOneVisibleChild(Viewer viewer, Object element, TreeBrowseStrategy strategy, Set<Object> visitedElements) {
		//TODO : separate this method in -hasOneVisibleChild() and #doHasOneVisibleChild(), to handle the cache management in a private method,
		//while letting the opportunity to override the method
		if(useCache && visibleChild.containsKey(element)) {
			return visibleChild.get(element);
		}

		boolean result = false;
		if(!visitedElements.contains(element)) {
			visitedElements.add(element);

			for(Object childElement : strategy.getChildren(element)) {
				if(isVisible(viewer, element, childElement) || hasOneVisibleChild(viewer, childElement, strategy, visitedElements)) {
					result = true;
					break;
				}
			}
		}

		if(useCache) {
			visibleChild.put(element, result);
		}
		return result;
	}

	protected boolean hasOneVisibleParent(Viewer viewer, Object element, TreeBrowseStrategy strategy, Set<Object> visitedElements) {
		if(useCache && visibleParent.containsKey(element)) {
			return visibleParent.get(element);
		}

		boolean result = false;
		if(!visitedElements.contains(element)) {

			visitedElements.add(element);

			Object parentElement = strategy.getParent(element);
			if(parentElement == element || parentElement == null) {
				result = isVisible(viewer, parentElement, element);
			} else {
				result = isVisible(viewer, null, parentElement) || hasOneVisibleParent(viewer, parentElement, strategy, visitedElements);
			}
		}

		if(useCache) {
			visibleParent.put(element, result);
		}

		return result;
	}

	protected void clearCache() {
		visibleElement.clear();
		visibleParent.clear();
		visibleChild.clear();
	}

	public abstract boolean isVisible(Viewer viewer, Object parentElement, Object element);

	public void setShowIfHasVisibleParent(boolean showIfHasVisibleParent) {
		this.showIfHasVisibleParent = showIfHasVisibleParent;
	}
}
