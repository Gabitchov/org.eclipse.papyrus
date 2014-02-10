/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Gregoire Dupe (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 *   Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.emf.facet.efacet.core.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.QueryResult;
import org.eclipse.emf.facet.efacet.core.exception.QueryException;
import org.eclipse.emf.facet.efacet.core.exception.QueryExecutionException;

/**
 * This interface is the EMF Facet QueryEvaluator for query evaluation
 * 
 * @deprecated use {@link IQueryImplementation} with the new eFacet2 metamodel (https://bugs.eclipse.org/bugs/show_bug.cgi?id=381227)
 */
@Deprecated
public interface IQueryEvaluator {

	/**
	 * This method must be implemented by each sub class to evaluate a query
	 * 
	 * @param query
	 *            The query to evaluate
	 * @param context
	 *            The model element on which the query is evaluated 
	 * @param parameterValues
	 *            The query parameter values, can be <code>null</code>
	 * @return A list of {@link QueryResult}s (one per evaluation)
	 * @throws QueryExecutionException
	 */
	public Object basicEvaluate(final Query query, EObject context,
			final List<ParameterValue> parameterValues) throws QueryException;

	/**
	 * Return whether to check the query result after its evaluation
	 * 
	 * @return whether to check the query result after its evaluation
	 */
	public abstract boolean getCheckResultType();
	
	/**
	 * Called when starting the evaluation of a query on one or several context
	 * elements (when
	 * {@link AbstractQueryEvaluator#evaluate(ModelQueryContext, List)} is
	 * called).
	 * <p>
	 * A subclass will receive in order:<br>
	 * 
	 * <pre>
	 * startEvaluate()
	 * basicEvaluate(context1, parameters)
	 * basicEvaluate(context2, parameters)
	 * ...
	 * basicEvaluate(contextn, parameters)
	 * endEvaluate()
	 * </pre>
	 * 
	 * </p>
	 * 
	 * When evaluating a query on several context elements, basicEvaluate is
	 * called repeatedly with each context element. For some implementations
	 * that make use of a system with which you must establish a connection (e.g.
	 * a database) for each call, this is costly.
	 * 
	 * The methods startEvaluate and endEvaluate satisfy this requirement
	 * 
	 * @see {@link AbstractQueryEvaluator#endEvaluate()}
	 */
	public void startEvaluate();

	/**
	 * Called when ending the evaluation of a query on one or several context
	 * elements.
	 * <p>
	 * A subclass will receive in order:<br>
	 * 
	 * <pre>
	 * startEvaluate()
	 * basicEvaluate(context1, parameters)
	 * basicEvaluate(context2, parameters)
	 * ...
	 * basicEvaluate(contextn, parameters)
	 * endEvaluate()
	 * </pre>
	 * 
	 * </p>
	 * When evaluating a query on several context elements, basicEvaluate is
	 * called repeatedly with each context element. For some implementations
	 * that make use of a system with which you must establish a connection
	 * (e.g. a database) for each call, this is costly.
	 * 
	 * The methods startEvaluate and endEvaluate satisfy this requirement
	 * 
	 * @see {@link AbstractQueryEvaluator#startEvaluate()}
	 */
	public void endEvaluate();

}
