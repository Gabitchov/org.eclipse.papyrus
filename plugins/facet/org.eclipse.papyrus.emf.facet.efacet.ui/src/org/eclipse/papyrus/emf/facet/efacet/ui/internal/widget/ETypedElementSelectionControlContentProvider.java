/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.IFilter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ETypedElementSelectionControlContentProvider implements ITreeContentProvider {

	private final IFilter<EObject> childrenFilter;

	public ETypedElementSelectionControlContentProvider(final IFilter<EObject> childrenFilter) {
		this.childrenFilter = childrenFilter;
	}

	private Object input;

	public Object[] getElements(final Object inputElement) {
		// @SuppressWarnings("unchecked") : this is the type setInput accepts
		@SuppressWarnings("unchecked")
		final Collection<? extends EObject> containers = (Collection<? extends EObject>) inputElement;
		return containers.toArray();
	}

	public Object[] getChildren(final Object parentElement) {
		Object[] children;
		if (parentElement instanceof EObject) {
			final EObject container = (EObject) parentElement;
			final List<EObject> filteredChildren = computeFilteredChildren(container);
			children = filteredChildren.toArray();
		} else {
			children = new Object[0];
		}
		return children;
	}

	public Object getParent(final Object element) {
		Object parent = null;
		if (element instanceof EObject) {
			parent = ((EObject) element).eContainer();
		}
		return parent;
	}

	// @SuppressWarnings("unchecked") : the input type is checked by setInput
	@SuppressWarnings("unchecked")
	public boolean hasChildren(final Object element) {
		boolean result;
		final Collection<? extends EObject> rootElements = (Collection<? extends EObject>) this.input;
		if (rootElements.contains(element)) {
			// avoid computing all the children of all the top-level elements
			// since this could be very expensive
			result = true;
		} else if (element instanceof EObject) {
			result = getChildren(element).length > 0;
		} else {
			result = false;
		}
		return result;
	}

	public void inputChanged(final Viewer viewer, final Object oldInput,
			final Object newInput) {
		this.input = newInput;
	}

	public void dispose() {
		// nothing
	}

	protected List<EObject> computeFilteredChildren(final EObject parentEObject) {
		final List<EObject> children = new ArrayList<EObject>();
		final EList<EObject> eContents = parentEObject.eContents();
		children.addAll(eContents);
		final List<EObject> filteredChildren = new ArrayList<EObject>();
		for (final EObject eObject : children) {
			if (this.childrenFilter.filter(eObject)) {
				filteredChildren.add(eObject);
			}
		}
		return filteredChildren;
	}
}