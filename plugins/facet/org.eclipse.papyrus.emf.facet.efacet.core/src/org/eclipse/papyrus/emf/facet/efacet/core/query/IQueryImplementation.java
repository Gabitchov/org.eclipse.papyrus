/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * Interface implemented by all EMF Facet query evaluators.
 * <p>
 * A query evaluator may choose to implement {@link IQueryCollectionImplementation} instead if it wants to improve the
 * performance of evaluation on collections of elements.
 * 
 * @since 0.2
 */
public interface IQueryImplementation {

	/**
	 * This method must be implemented by each sub class to evaluate a query
	 * 
	 * @param query
	 *            The query to evaluate
	 * @param feature
	 *            The feature or operation to get on the source
	 * @param source
	 *            The model element on which the query is evaluated
	 * @param parameterValues
	 *            The derived typed element's query parameter values (in the case of a {@link FacetOperation}); can be
	 *            <code>null</code>
	 * @return the result, which can be either a single object or a collection of values depending on the multiplicity
	 *         of the given derived typed element
	 * @throws DerivedTypedElementException
	 *             if the query could not be evaluated correctly to get the value
	 */
	Object getValue(Query query, DerivedTypedElement feature, EObject source,
			List<ParameterValue> parameterValues, IFacetManager facetManager)
			throws DerivedTypedElementException;

	/**
	 * This method must be implemented by each sub class that allows to set the value of a derivedTypedElement using a
	 * query
	 * 
	 * @param query
	 *            The query that sets the value
	 * @param feature
	 *            The derived typed element to set
	 * @param source
	 *            The model element on which the derived typed element must be set
	 * @param parameterValues
	 *            The query parameter values (in the case of a {@link FacetOperation}); can be <code>null</code>
	 * @param newValue
	 *            the value to set on the derived typed element
	 * @throws DerivedTypedElementException
	 *             if the query could not be evaluated correctly to set the value
	 */
	void setValue(Query query, DerivedTypedElement feature, EObject source,
			List<ParameterValue> parameterValues, Object newValue)
			throws DerivedTypedElementException;

	/**
	 * Return whether to check the type of the query result after its evaluation
	 * <p>
	 * Normally, this is <code>true</code>, but the query evaluator can choose to skip the check, for example if the
	 * return type of the query can't be loaded.
	 * 
	 * @return whether to check the type of the query result after its evaluation
	 */
	boolean isCheckResultType();

}
