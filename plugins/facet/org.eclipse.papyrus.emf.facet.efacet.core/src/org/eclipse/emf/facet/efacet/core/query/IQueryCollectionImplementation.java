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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;

/**
 * This interface can be implemented by EMF Facet query implementations that want to handle multiple evaluation
 * themselves, presumably to improve the performance of the evaluation.
 * <p>
 * If only {@link IQueryImplementation} is implemented, then the framework will perform multiple-evaluation by calling
 * the single evaluation multiple times, which may be slow in the case of high-latency implementations.
 * 
 * @since 0.2
 */
public interface IQueryCollectionImplementation extends IQueryImplementation {

	/**
	 * This method must be implemented by each sub-class to evaluate a query on a collection of elements. The query
	 * should be evaluated on each of the elements in the given collection.
	 * <p>
	 * This method should throw a {@link DerivedTypedElementException} only if the eTypedElement is an incorrect
	 * {@link DerivedTypedElement}. But it must not throw an exception if the evaluation of one element fails. Instead,
	 * it must set the exception on the corresponding result ({@link ETypedElementResult#setException(Throwable)}).
	 * 
	 * @param query
	 *            The query to evaluate
	 * @param eTypedElement
	 *            The feature or operation to get on the sources
	 * @param sources
	 *            The model elements on which the feature or operation is evaluated using the query
	 * @param arguments
	 *            The parameter values for the eTypedElement (in the case of a {@link FacetOperation}); can be
	 *            <code>null</code>
	 * @return the result :
	 *         <ul>
	 *         <li> a list of {@link ETypedElementPrimitiveTypeResult} if the eTypedElement is single-valued and returns
	 *         a primitive type <li> a list of {@link ETypedElementPrimitiveTypeListResult} if the eTypedElement is
	 *         multi-valued and returns a primitive type <li> a list of {@link ETypedElementEObjectResult} if the
	 *         eTypedElement is single-valued and returns a model element <li> a list of
	 *         {@link ETypedElementEObjectListResult} if the eTypedElement is multi-valued and returns model elements
	 *         </ul>
	 * @throws DerivedTypedElementException
	 *             if the given derivedTypedElement is incorrect
	 */
	List<? extends ETypedElementResult> getValues(Query query, ETypedElement eTypedElement, Collection<? extends EObject> sources,
			List<ParameterValue> arguments)
			throws DerivedTypedElementException;

	/**
	 * This method must be implemented by each sub-class to set the values of a collection of elements. The query should
	 * be used to set the value of each of the elements in the given collection.
	 * 
	 * @param query
	 *            The query to evaluate
	 * @param feature
	 *            The derived typed element to set
	 * @param sources
	 *            The model elements on which the query is evaluated
	 * @param arguments
	 *            The parameter values for the derived typed element (in the case of a {@link FacetOperation}); can be
	 *            <code>null</code>
	 * @param newValues
	 *            the new values for the sources; the size of this list must match the size of the list of sources
	 * @throws DerivedTypedElementException
	 *             if the given derivedTypedElement is incorrect
	 * @throws DerivedTypedElementEvaluationException
	 *             if the query could not be evaluated correctly
	 * @throws IllegalArgumentException
	 *             if the given list of values does not match the list of sources
	 */
	void setValues(Query query, DerivedTypedElement feature, Collection<? extends EObject> sources, List<ParameterValue> arguments,
			List<? extends Object> newValues)
			throws DerivedTypedElementException;
}
