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
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.efacet.EFacetFactory;
import org.eclipse.papyrus.emf.facet.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.QueryContext;
import org.eclipse.papyrus.emf.facet.efacet.QueryResult;
import org.eclipse.papyrus.emf.facet.efacet.core.IEFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.QueryException;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.QueryTypeCheckingException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.query.QueryEvaluatorFactoryRegistry;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryEvaluator;

/** @deprecated replaced by {@link DerivedTypedElementManager} */
@Deprecated
public final class EFacetManager implements IEFacetManager {

	/**
	 * This method looks for a valid evaluator for the query and calls it to perform its
	 * basicEvaluate
	 */
	public Object basicEvaluate(final Query query, final EObject eObject,
			final List<ParameterValue> parameterValues) throws QueryException {
		IQueryEvaluator evaluator = QueryEvaluatorFactoryRegistry.INSTANCE.getEvaluatorFor(query);
		evaluator.startEvaluate();
		Object result = evaluateAndCheck(query, eObject, parameterValues, evaluator);
		evaluator.endEvaluate();
		return result;
	}

	private Object evaluateAndCheck(final Query query, final EObject eObject,
			final List<ParameterValue> parameterValues, final IQueryEvaluator evaluator)
			throws QueryException {

		if (!query.getScope().isInstance(eObject)) {
			StringBuffer message = new StringBuffer();
			message.append("Wrong context type (for query " + toString() + "): "); //$NON-NLS-1$ //$NON-NLS-2$
			message.append(eObject.eClass().getName());
			message.append(" found; expected scopes are {"); //$NON-NLS-1$
			message.append(query.getScope().getName());
			message.append("}"); //$NON-NLS-1$
			QueryTypeCheckingException e = new QueryTypeCheckingException(message.toString());
			throw e;
		}
		Object result = evaluator.basicEvaluate(query, eObject, parameterValues);
		checkResult(query, result, evaluator.getCheckResultType());
		return result;
	}

	/**
	 * This method is equivalent to {@link EFacetManager#basicEvaluate(Query, EObject, List)} with
	 * no query parameters.
	 */
	public final Object basicEvaluate(final Query query, final EObject eObject)
			throws QueryException {
		return basicEvaluate(query, eObject, null);
	}

	/**
	 * This method is used to evaluate the given {@link Query} on the given {@link EObject} taking
	 * into consideration some {@link ParameterValue}s
	 */
	public final QueryResult evaluate(final Query query, final EObject context,
			final List<ParameterValue> parameterValues) {
		QueryResult queryResult = EFacetFactory.eINSTANCE.createQueryResult();
		try {
			queryResult.setSource(context);
			queryResult.setResult(basicEvaluate(query, context, parameterValues));
		} catch (Exception e) {
			queryResult.setException(e);
		}
		return queryResult;
	}

	/**
	 * Evaluate the query on a set of models and model elements described by the context parameter.
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
	public final synchronized List<QueryResult> evaluate(final Query query,
			final QueryContext queryContext, final List<ParameterValue> parameterValues)
			throws QueryException {
		List<QueryResult> resultList = new ArrayList<QueryResult>();
		IQueryEvaluator evaluator = QueryEvaluatorFactoryRegistry.INSTANCE.getEvaluatorFor(query);
		try {
			evaluator.startEvaluate();
			for (EObject eObject : queryContext.getSelectedModelElements()) {
				QueryResult queryResult = executeQuery(query, parameterValues, eObject, evaluator);
				resultList.add(queryResult);
			}
			for (Resource resource : queryContext.getSelectedModels()) {
				TreeIterator<EObject> treeIterator = resource.getAllContents();
				while (treeIterator.hasNext()) {
					EObject eObject = treeIterator.next();
					QueryResult queryResult = executeQuery(query, parameterValues, eObject,
							evaluator);
					resultList.add(queryResult);
				}
			}
		} finally {
			evaluator.endEvaluate();
		}
		return resultList;
	}

	/**
	 * This method is used to evaluate the given {@link Query} on the given {@link EObject}
	 */
	public final QueryResult evaluate(final Query query, final EObject eObject) {
		QueryResult queryResult = evaluate(query, eObject, null);
		return queryResult;
	}

	private final QueryResult executeQuery(final Query query,
			final List<ParameterValue> parameterValues, final EObject eObject,
			final IQueryEvaluator evaluator) {
		QueryResult queryResult = EFacetFactory.eINSTANCE.createQueryResult();
		queryResult.setSource(eObject);
		try {
			Object result = evaluateAndCheck(query, eObject, parameterValues, evaluator);
			queryResult.setResult(result);
		} catch (QueryException e) {
			queryResult.setException(e);
		}
		return queryResult;
	}

	private final void checkResult(final Query query, final Object object,
			final boolean checkResultType) throws QueryTypeCheckingException {
		if (query.getUpperBound() > 1 || query.getUpperBound() == -1) {
			if (!(object instanceof Collection<?>)) {
				throw new QueryTypeCheckingException(
						"A collection is expected as result. The result is: " //$NON-NLS-1$
								+ object + " (on " + toString() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			for (Object collectionElement : (Collection<?>) object) {
				if (checkResultType) {
					if (!(query.getEType().isInstance(collectionElement))) {
						QueryTypeCheckingException e = new QueryTypeCheckingException(
								"Wrong result collection element type (" //$NON-NLS-1$
										+ query.getEType().getName() + " is expected): " //$NON-NLS-1$
										+ collectionElement + " (on " //$NON-NLS-1$
										+ toString() + ")"); //$NON-NLS-1$
						throw e;
					}
				}
			}
		} else {
			if (object instanceof Collection<?>) {
				throw new QueryTypeCheckingException("A " //$NON-NLS-1$
						+ query.getEType().getName()
						+ " instance is expected as result. The result is: " //$NON-NLS-1$
						+ object + " (on " + toString() + ")"); //$NON-NLS-1$//$NON-NLS-2$
			}
			if (checkResultType) {
				if (!(query.getEType().isInstance(object))) {
					if (object != null) {
						throw new QueryTypeCheckingException("Wrong result type: " //$NON-NLS-1$
								+ object.getClass().getName()
								+ " is returned while " //$NON-NLS-1$
								+ query.getEType().getInstanceClassName()
								+ " is expected." + " (on " + toString() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					}

				}
			}
		}
	}

}