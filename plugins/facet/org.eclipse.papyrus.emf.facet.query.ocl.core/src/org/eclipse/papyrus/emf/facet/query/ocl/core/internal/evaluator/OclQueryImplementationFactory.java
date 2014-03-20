/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.ocl.core.internal.evaluator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.query.ocl.core.internal.Activator;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.osgi.framework.Bundle;

/**
 * Concrete implementation of {@link IQueryImplementationFactory} for the OCL
 * query.
 */
public class OclQueryImplementationFactory implements
		IQueryImplementationFactory {

	public IQueryImplementation create(final Query query, final Bundle queryBundle,
			final IDerivedTypedElementManager manager)
			throws DerivedTypedElementException {
		if (!(query instanceof OclQuery)) {
			throw new IllegalArgumentException(
					"The given DerivedTypedElement does not have a OclQuery"); //$NON-NLS-1$
		}
		final OclQuery oclQuery = (OclQuery) query;

		if (queryBundle == null) {
			throw new DerivedTypedElementException(
					"Ocl query implementation class '" //$NON-NLS-1$
							+ oclQuery.getClass().getName()
							+ "' should be created within a bundle."); //$NON-NLS-1$
		}
		OclQueryImplementation oclQueryEvaluator = null;
		try {
			oclQueryEvaluator = new OclQueryImplementation();
		} catch (final Exception e) {
			final DerivedTypedElementException queryException = new DerivedTypedElementException(
					"The bundle " + queryBundle.getSymbolicName() + " failed to load the ocl query: " //$NON-NLS-1$ //$NON-NLS-2$
							+ oclQuery.getClass().getSimpleName(), e);
			Logger.logError(queryException, Activator.getDefault());
			throw queryException;
		}
		return oclQueryEvaluator;
	}

	public EClass getManagedQueryType() {
		return OclQueryPackage.eINSTANCE.getOclQuery();
	}

}
