/**
 *  Copyright (c) 2013 Soft-Maint.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 		David Couvrand (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 *  	Nicolas Rault (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 */
package org.eclipse.emf.facet.custom.ui.internal.querytype;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery;
import org.eclipse.emf.facet.custom.ui.internal.custompt.URIImage;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

public class URIImageQueryEvaluator implements IQueryImplementation {

	public void setValue(final Query query,
			final DerivedTypedElement feature, final EObject source,
			final List<ParameterValue> parameterValues,
			final Object newValue) throws DerivedTypedElementException {
		throw new DerivedTypedElementException("Not implemented method"); //$NON-NLS-1$
	}

	public boolean isCheckResultType() {
		return false;
	}

	public Object getValue(final Query query,
			final DerivedTypedElement feature, final EObject source,
			final List<ParameterValue> parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		// This cast is safe. The framework should only pass a query
		// instance of URIImageQuery, because it has been declared in
		// the method 'getManagedQueryType' that this query
		// implementation is dedicated to the URIImageQuery type.
		final String uri = ((URIImageQuery) query).getUri();
		return new URIImage(uri);
	}
	
}
