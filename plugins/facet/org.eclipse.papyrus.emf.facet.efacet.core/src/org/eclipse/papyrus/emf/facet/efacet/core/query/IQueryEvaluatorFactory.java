/**
 * Copyright (c) 2011, 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Gregoire Dupe (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 *  Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.papyrus.emf.facet.efacet.core.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.QueryException;
import org.osgi.framework.Bundle;

/**
 * This factory allows the user to create a {@link IQueryEvaluator} conforming to the EMF Facet
 * framework.
 * 
 * @deprecated use {@link IQueryImplementationFactory} with the new eFacet2 metamodel (https://bugs.eclipse.org/bugs/show_bug.cgi?id=381229)
 */
@Deprecated
public interface IQueryEvaluatorFactory {
	// Copy of org.eclipse.papyrus.emf.facet.infra.query.core.IModelQueryFactory

	/**
	 * Create a query evaluator.
	 */
	public IQueryEvaluator create(Query query, Bundle bundle) throws QueryException;

	/**
	 * Return the type of query this evaluator can evaluate.
	 * 
	 * @return the type of query this evaluator can evaluate.
	 */
	public EClass getManagedQueryType();
}
