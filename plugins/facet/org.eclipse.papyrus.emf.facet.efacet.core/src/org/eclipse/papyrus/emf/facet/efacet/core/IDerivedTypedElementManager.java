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
 *  Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *  Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *  Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *  Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.emf.facet.efacet.core;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.internal.DerivedTypedElementManager;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;

/**
 * Used to evaluate derived typed elements through their queries.
 * 
 * @since 0.2
 */
public interface IDerivedTypedElementManager {
	IDerivedTypedElementManager INSTANCE = new DerivedTypedElementManager();

	/**
	 * Evaluates a derived typed element on a model element.
	 * <p>
	 * <b>Note:</b> this method does not return a typed result, and it does not
	 * check the result type. Use
	 * {@link IDerivedTypedElementManager#evaluateSingleValued(DerivedTypedElement, EObject, List, Class)
	 * evaluateSingleValued} or
	 * {@link IDerivedTypedElementManager#evaluateMultiValued(DerivedTypedElement, EObject, List, Class)
	 * evaluateMultiValued} instead if you want a typed and type-checked result.
	 * 
	 * @param derivedTE
	 *            the derived typed element to evaluate
	 * @param source
	 *            the model element on which the derived typed element must be
	 *            evaluated
	 * @param parameterValues
	 *            the arguments of the derived typed element (in the case of a
	 *            {@link FacetOperation}; can be <code>null</code> if there are
	 *            no parameters)
	 * @return the derived typed element result: a single Object in the case of
	 *         a single-valued derived typed element, or a List in the case of a
	 *         multi-valued derived typed element.
	 * @throws DerivedTypedElementException
	 *             <ul>
	 *             <li>in case of error in the derived typed element</li> <li>in
	 *             case of error when evaluating the derived typed element</li>
	 *             </ul>
	 */
	Object evaluate(DerivedTypedElement derivedTE, EObject source,
			List<ParameterValue> parameterValues, IFacetManager facetManager)
			throws DerivedTypedElementException;

	/**
	 * Evaluates a query on a model element. Calling this method is discouraged. You should evaluate a
	 * {@link DerivedTypedElement}s (which contains a query) instead of trying to evaluate a {@link Query} directly.
	 * Since the source type, return type and multiplicity of a query are carried by the {@link DerivedTypedElement}
	 * that normally contains it, this method doesn't check the source type, return type or multiplicity.
	 * 
	 * @param query
	 *            the query to evaluate
	 * @param source
	 *            the model element on which the query must be evaluated
	 * @param parameterValues
	 *            the arguments of the query (in the case of a query for a {@link FacetOperation}; can be
	 *            <code>null</code> if there are no parameters)
	 * @return the query result: may be a single Object or a List.
	 * @throws DerivedTypedElementException
	 *             if the evaluation failed
	 */
	Object evaluate(Query query, EObject source, List<ParameterValue> parameterValues, IFacetManager facetManager)
			throws DerivedTypedElementException;

	/**
	 * Evaluates a single valued derived typed element on a model element.
	 * 
	 * @param derivedTE
	 *            the derived typed element to evaluate
	 * @param source
	 *            the model element on which the derived typed element is
	 *            evaluated
	 * @param parameterValues
	 *            the arguments of the derived typed element (in the case of a
	 *            {@link FacetOperation}; can be <code>null</code> if there are
	 *            no parameters)
	 * @param resultType
	 *            the type that the returned value must have
	 * @return the result of the evaluation
	 * @throws DerivedTypedElementException
	 *             <ul>
	 *             <li>in case of error in the derived typed element</li>
	 *             <li>in case of error when evaluating the derived typed
	 *             element</li>
	 *             <li>
	 *             if the effective return type does not match the expected type
	 *             </li>
	 *             </ul>
	 */
	<T> T evaluateSingleValued(DerivedTypedElement derivedTE, EObject source,
			List<ParameterValue> parameterValues, Class<T> resultType,
			IFacetManager facetManager) throws DerivedTypedElementException;

	/**
	 * Evaluates a multi-valued derived typed element on a model element.
	 * 
	 * @param derivedTypedElement
	 *            the derived typed element to evaluate
	 * @param source
	 *            the model element on which the derived typed element must be
	 *            evaluated
	 * @param parameterValues
	 *            the arguments of the derived typed element (in the case of a
	 *            {@link FacetOperation}; can be <code>null</code> if there are
	 *            no parameters)
	 * @param resultType
	 *            the type that the returned value must have
	 * @return the result of the evaluation
	 * @throws DerivedTypedElementException
	 *             <ul>
	 *             <li>in case of error in the derived typed element</li>
	 *             <li>in case of error when evaluating the derived typed
	 *             element</li>
	 *             <li>if the effective return type does not match the expected
	 *             type</li>
	 *             </ul>
	 */
	<T> List<T> evaluateMultiValued(DerivedTypedElement derivedTE,
			EObject source, List<ParameterValue> parameterValues,
			Class<T> resultType, IFacetManager facetManager)
			throws DerivedTypedElementException;

	/**
	 * Evaluates a derived typed element on a list of model elements in a single
	 * call.
	 * 
	 * @param derivedTE
	 *            the derived typed element to evaluate
	 * @param sources
	 *            the model elements on which the derived typed element must be
	 *            evaluated
	 * @param parameterValues
	 *            the arguments of the derived typed element (in the case of a
	 *            {@link FacetOperation}; can be <code>null</code> if there are
	 *            no parameters)
	 * @param resultType
	 *            the expected type of the returned list:
	 *            <ul>
	 *            <li> {@link DerivedTypedElementEObjectResult} if the
	 *            {@link DerivedTypedElement} is a single-valued
	 *            {@link EReference} or {@link EOperation} that returns EObjects
	 *            <li>{@link DerivedTypedElementEObjectListResult} if the
	 *            {@link DerivedTypedElement} is a multi-valued
	 *            {@link EReference} or {@link EOperation} that returns EObjects
	 *            <li>{@link DerivedTypedElementPrimitiveTypeResult} if the
	 *            {@link DerivedTypedElement} is a single-valued
	 *            {@link EAttribute} or {@link EOperation} that returns a
	 *            primitive type value
	 *            <li>{@link DerivedTypedElementPrimitiveTypeListResult} if the
	 *            {@link DerivedTypedElement} is a multi-valued
	 *            {@link EAttribute} or {@link EOperation} that returns a list
	 *            of primitive type values
	 *            </ul>
	 * @return one derived typed element result for each source element that was
	 *         evaluated
	 * @throws DerivedTypedElementException
	 *             <ul>
	 *             <li>in case of error in the derived typed element.
	 *             <b>Note</b>: an error that happens when evaluating the
	 *             derived typed element on any of the given sources is not
	 *             thrown but stored in the corresponding element result.</li>
	 *             <li>if the effective return type does not match the expected
	 *             type</li>
	 *             </ul>
	 */
	<T extends ETypedElementResult> List<T> batchEvaluate(
			DerivedTypedElement derivedTE,
			Collection<? extends EObject> sources,
			List<ParameterValue> parameterValues, Class<T> resultType,
			IFacetManager facetManager) throws DerivedTypedElementException;
}
