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

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

//FIXME : Adapt this code to TreeBrowseStrategy
public class TreeToFlatContentProvider extends AbstractStaticContentProvider {

	private ITreeContentProvider contentProvider;

	private StructuredViewer viewer;

	public TreeToFlatContentProvider(ITreeContentProvider provider) {
		if(!(provider instanceof IStaticContentProvider)) {
			throw new IllegalArgumentException();
		}
		this.contentProvider = provider;
	}

	@Override
	public void dispose() {
		contentProvider.dispose();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(viewer instanceof StructuredViewer) {
			this.viewer = (StructuredViewer)viewer;
		}

		contentProvider.inputChanged(viewer, oldInput, newInput);
	}

	public Object[] getElements() {
		return getElementsList().toArray();
	}

	/**
	 * Returns the concrete value from the given Object
	 * For example, if the content provider is an IAdaptableContentProvider,
	 * returns the adapted value.
	 * 
	 * @param value
	 * @return
	 */
	protected Object getValue(Object value) {
		if(contentProvider instanceof IAdaptableContentProvider) {
			return ((IAdaptableContentProvider)contentProvider).getAdaptedValue(value);
		} else {
			return value;
		}
	}

	protected boolean exploreBranch(Object parentElement, Object element) {
		if(viewer == null) {
			return true;
		}

		for(ViewerFilter filter : viewer.getFilters()) {
			if(!filter.select(viewer, parentElement, element)) {
				return false;
			}
		}

		return true;
	}

	protected Collection<Object> getElementsList() {
		Collection<Object> result = new LinkedHashSet<Object>();
		Set<Object> browsedElements = new HashSet<Object>();

		for(Object root : ((IStaticContentProvider)contentProvider).getElements()) {
			if(exploreBranch(null, root)) {
				result.add(root);
				getElementsList(root, result, browsedElements);
			}
		}

		return result;
	}

	protected void getElementsList(Object parent, Collection<Object> result, Set<Object> browsedElements) {
		for(Object child : contentProvider.getChildren(parent)) {
			Object childValue = getValue(child);
			if(!result.contains(childValue)) { //Avoid infinite recursion
				result.add(childValue);
				if(exploreBranch(parent, child)) {
					getElementsList(child, result, browsedElements);
				}
			}
		}
	}
}
