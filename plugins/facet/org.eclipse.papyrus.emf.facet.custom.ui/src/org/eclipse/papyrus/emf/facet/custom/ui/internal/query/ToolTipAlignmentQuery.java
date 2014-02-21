/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *
 *****************************************************************************/

package org.eclipse.emf.facet.custom.ui.internal.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;

/**
 * 
 * This query is used to get the default alignment for the tooltip texts
 *
 */
public class ToolTipAlignmentQuery implements IJavaQuery2<EObject, Alignment> {

	public Alignment evaluate(final EObject source,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		return Alignment.LEFT;
	}
}
