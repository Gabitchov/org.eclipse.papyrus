/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.papyrus.emf.facet.efacet.core.query;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.DerivedTypedElementEvaluationException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;

/**
 * This interface can be implemented by EMF Facet derived typed element implementations that want to
 * handle multiple evaluation themselves, presumably to improve the performance of the evaluation.
 * <p>
 * If only {@link IDerivedTypedElementImplementation} is implemented, then the framework will
 * perform multiple-evaluation by calling the single evaluation multiple times, which may be slow in
 * the case of high-latency implementations.
 *
 * @since 0.2
 * @deprecated replaced by {@link IQueryCollectionImplementation}. https://bugs.eclipse.org/bugs/show_bug.cgi?id=377057.
 */
@Deprecated
public interface IDerivedTypedElementCollectionImplementation extends IDerivedTypedElementImplementation {

	/**
	 * This method must be implemented by each sub-class to evaluate the query of a derived typed element on a
	 * collection of elements. The query should be evaluated on each of the elements in the given collection.
	 * <p>
	 * This method should throw a {@link DerivedTypedElementException} only if the {@link DerivedTypedElement} is
	 * incorrect. But it must not throw an exception if the evaluation of one element fails. Instead, it must set the
	 * exception on the corresponding result ({@link AbstractDerivedTypedElementResult#setException(Throwable)}).
	 * 
	 * @param derivedTypedElement
	 *            The derived typed element for which to get the values
	 * @param sources
	 *            The model elements on which the derived typed element is evaluated
	 * @param arguments
	 *            The parameter values for the derived typed element (in the case of a {@link FacetOperation}); can be <code>null</code>
	 * @return the result :
	 *         <ul>
	 *         <li> a list of {@link DerivedTypedElementPrimitiveTypeResult} if the derived typed element is
	 *         single-valued and returns a primitive type <li> a list of
	 *         {@link DerivedTypedElementPrimitiveTypeListResult} if the derived typed element is multi-valued and
	 *         returns a primitive type <li> a list of {@link DerivedTypedElementEObjectResult} if the derived typed
	 *         element is single-valued and returns a model element <li> a list of
	 *         {@link DerivedTypedElementEObjectListResult} if the derived typed element is multi-valued and returns
	 *         model elements
	 *         </ul>
	 * @throws DerivedTypedElementException
	 *             if the given derivedTypedElement is incorrect
	 */
	List<? extends ETypedElementResult> getValues(DerivedTypedElement derivedTypedElement, Collection<? extends EObject> sources, List<ParameterValue> arguments)
			throws DerivedTypedElementException;

	/**
	 * This method must be implemented by each sub-class to set the values of a collection of elements. The derived
	 * typed element's query should be used to set the value of each of the elements in the given collection.
	 * 
	 * @param query
	 *            The query to evaluate
	 * @param source
	 *            The model elements on which the query is evaluated
	 * @param arguments
	 *            The parameter values for the derived typed element (in the case of a {@link FacetOperation}); can be
	 *            <code>null</code>
	 * @param newValues
	 *            the new values for the sources; the size of this list must match the size of the list of sources 
	 * @throws DerivedTypedElementException
	 *             if the given derivedTypedElement is incorrect
	 * @throws DerivedTypedElementEvaluationException
	 *             if the query of the derived typed element could not be evaluated correctly
	 * @throws IllegalArgumentException
	 *             if the given list of values does not match the list of sources
	 */
	void setValues(DerivedTypedElement derivedTypedElement, Collection<? extends EObject> sources, List<ParameterValue> arguments, List<? extends Object> newValues)
			throws DerivedTypedElementException;
}
