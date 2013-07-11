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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.search.ui.text.AbstractTextSearchResult;

/**
 * 
 * Interface of the ResultContentProvider extension point that contributors must implement
 * 
 */
public interface IResultContentProvider {

	/**
	 * Based on inputElement, add content to the resultHierarchy. Contributors must read the results to identify the elements they can process and add
	 * the corresponding content to the hierarchy
	 * 
	 * @param inputElement
	 *        the results
	 * 
	 * @param resultHierarchy
	 *        the hierarchy to contribute to
	 */
	public void getHierarchy(AbstractTextSearchResult inputElement, Set<AbstractResultEntry> resultHierarchy);

	public void initialize(AbstractTextSearchResult inputElement, Map<Object, Set<Object>> fChildrenMap, ITreeContentProvider treeContentProvider, AbstractTreeViewer viewer);

	public void elementsChanged(Object[] updatedElements, AbstractTextSearchResult inputElement, Map<Object, Set<Object>> fChildrenMap, ITreeContentProvider treeContentProvider, AbstractTreeViewer viewer);

}
