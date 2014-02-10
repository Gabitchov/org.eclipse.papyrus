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

package org.eclipse.emf.facet.custom.ui.internal.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.custom.metamodel.v0_3_0.query.QueryPackage;
import org.eclipse.emf.facet.custom.ui.internal.querytype.URIImageQueryEvaluator;
import org.eclipse.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.emf.facet.efacet.core.query.IQueryImplementationFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.osgi.framework.Bundle;

public class URIImageQueryImplementationFactory implements
		IQueryImplementationFactory {

	public IQueryImplementation create(final Query query,
			final Bundle queryBundle, final IDerivedTypedElementManager manager)
			throws DerivedTypedElementException {
		return new URIImageQueryEvaluator();
	}

	public EClass getManagedQueryType() {
		return QueryPackage.eINSTANCE.getURIImageQuery();
	}

}
