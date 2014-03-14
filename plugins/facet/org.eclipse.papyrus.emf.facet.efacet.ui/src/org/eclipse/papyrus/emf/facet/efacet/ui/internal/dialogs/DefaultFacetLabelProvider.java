/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *     Nicolas Bros(Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.dialogs;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.utils.ImageUtils;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class DefaultFacetLabelProvider extends LabelProvider {
	@Override
	public String getText(final Object element) {
		String label;
		if (element instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet) element;
			label = facetSet.getName();
		} else if (element instanceof Facet) {
			final Facet facet = (Facet) element;
			label = facet.getName();
		} else if (element instanceof ENamedElement) {
			final ENamedElement namedElement = (ENamedElement) element;
			label = namedElement.getName();
		} else if (element == null) {
			label = "null"; //$NON-NLS-1$
		} else {
			label = element.getClass().getName();
		}
		return label;
	}

	@Override
	public Image getImage(final Object element) {
		return ImageUtils.getImage(element);
	}
}
