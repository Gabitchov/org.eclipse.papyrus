/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Gregoire Dupe (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.papyrus.emf.facet.efacet.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.QueryContext;
import org.eclipse.papyrus.emf.facet.efacet.QueryResult;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.QueryException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.EFacetManager;

/**
 * This interface allows the user to use the EMF Facet API for Query and Facet.
 *
 * @deprecated use {@link IDerivedTypedElementManager} with the new eFacet2 metamodel (https://bugs.eclipse.org/bugs/show_bug.cgi?id=381225)
 */
@Deprecated
public interface IEFacetManager {
	IEFacetManager INSTANCE = new EFacetManager();

	/**
	 * This method is used to evaluate the given {@link Query} on the given {@link EObject} taking
	 * into consideration some {@link ParameterValue}
	 */
	QueryResult evaluate(final Query query, final EObject eObject,
			final List<ParameterValue> parameterValues);

	/**
	 * This method is used to evaluate the given {@link Query} on the given {@link EObject}
	 */
	QueryResult evaluate(final Query query, final EObject eObject);

	/**
	 * This method is equivalent to {@link IEFacetManager#evaluate(Query, EObject, List)} but rather
	 * than return the errors into a {@link QueryResult} instance, it throws an exception.
	 *
	 * @param eObject
	 *            The query evaluation context
	 * @return The query result.
	 * @throws QueryException
	 */
	Object basicEvaluate(final Query query, final EObject eObject,
			final List<ParameterValue> parameterValues) throws QueryException;

	/**
	 * This method is equivalent to {@link IEFacetManager#evaluate(Query, EObject)} but rather than
	 * return the errors into a {@link QueryResult} instance, it throws an exception.
	 *
	 * @param eObject
	 *            The query evaluation context
	 * @return The query result.
	 * @throws QueryException
	 */
	Object basicEvaluate(final Query query, final EObject eObject)
			throws QueryException;

	/**
	 * Evaluate the query on a set of models and model elements described by the
	 * <code>queryContext</code> parameter.
	 *
	 * The query is evaluated on each contextually referred model element and on each element of a
	 * contextually referred model.
	 *
	 * @param queryContext
	 *            The query evaluation context described by a QueryContext instance.
	 * @param parameterValues
	 *            The query parameter values.
	 * @return A list of QueryResult (one per evaluation)
	 * @throws QueryException
	 */
	List<QueryResult> evaluate(final Query query,
			final QueryContext queryContext,
			final List<ParameterValue> parameterValues) throws QueryException;
}
