/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *     Nicolas Bros (Mia-Software) - Bug 371367 - Hierarchical FacetSets
 *     Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *     Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FacetSetTreeContentProvider implements ITreeContentProvider {

	private final boolean bFacets;
	private final boolean bContainedFS;
	private final boolean bSubpackages;

	public FacetSetTreeContentProvider(final boolean facets, final boolean containedFSs, final boolean subpackages) {
		this.bFacets = facets;
		this.bContainedFS = containedFSs;
		this.bSubpackages = subpackages;
	}

	public FacetSetTreeContentProvider() {
		this(true, true, true);
	}

	public Object[] getElements(final Object inputElement) {
		if (inputElement == null) {
			throw new IllegalArgumentException("inputElement must not be null"); //$NON-NLS-1$
		}
		if (!(inputElement instanceof Object[])) {
			throw new IllegalArgumentException("inputElement must be an array"); //$NON-NLS-1$
		}
		return (Object[]) inputElement;
	}

	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		// Nothing to do
	}

	public Object[] getChildren(final Object parentElement) {
		final List<Object> children = new ArrayList<Object>();
		if (parentElement instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet) parentElement;
			if (this.bContainedFS) {
				children.addAll(facetSet.getFacetSets());
			}
			if (this.bFacets) {
				children.addAll(FacetUtils.getFacets(facetSet));
			}
			if (this.bSubpackages) {
				children.addAll(facetSet.getESubpackages());
			}
		}
		return children.toArray();
	}

	public Object getParent(final Object element) {
		Object parent = null;
		if (element instanceof Facet) {
			final Facet facet = (Facet) element;
			parent = FacetUtils.getFacetSet(facet);
		} else if (element instanceof EPackage) {
			final EPackage ePackage = (EPackage) element;
			parent = ePackage.getESuperPackage();
		}
		return parent;
	}

	public boolean hasChildren(final Object element) {
		return getChildren(element).length > 0;
	}

	public void dispose() {
		// Nothing to do
	}

}
