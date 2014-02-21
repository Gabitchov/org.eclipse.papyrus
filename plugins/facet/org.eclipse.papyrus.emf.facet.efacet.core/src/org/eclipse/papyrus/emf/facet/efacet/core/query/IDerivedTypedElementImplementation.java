/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - initial API and implementation
 *     Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.papyrus.emf.facet.efacet.core.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;

/**
 * Interface implemented by all EMF Facet derived typed element evaluators.
 * <p>
 * A derived typed element evaluator may choose to implement
 * {@link IDerivedTypedElementCollectionImplementation} instead if it wants to improve the
 * performance of evaluation on collections of elements.
 *
 * @since 0.2
 * @deprecated replaced by {@link IQueryImplementation}. https://bugs.eclipse.org/bugs/show_bug.cgi?id=377058.
 */
@Deprecated
public interface IDerivedTypedElementImplementation {

	/**
	 * This method must be implemented by each sub class to evaluate a derived
	 * typed element
	 * 
	 * @param derivedTypedElement
	 *            The derived typed element to evaluate
	 * @param source
	 *            The model element on which the derived typed element is
	 *            evaluated
	 * @param parameterValues
	 *            The derived typed element's query parameter values (in the
	 *            case of a {@link FacetOperation}), can be <code>null</code>
	 * @return the result, which can be either a single object or a collection
	 *         of values depending on the multiplicity of the given derived
	 *         typed element
	 * @throws DerivedTypedElementException
	 *             if the query of the derived typed element could not be
	 *             evaluated correctly to get the value
	 */
	Object getValue(DerivedTypedElement derivedTypedElement, EObject source,
			List<ParameterValue> parameterValues, IFacetManager facetManager)
			throws DerivedTypedElementException;

	/**
	 * This method must be implemented by each sub class to set the value of a
	 * derived typed element
	 * 
	 * @param derivedTypedElement
	 *            The derived typed element to set
	 * @param source
	 *            The model element on which the derived typed element is set
	 * @param parameterValues
	 *            The derived typed element's query parameter values (in the
	 *            case of a {@link FacetOperation}), can be <code>null</code>
	 * @param newValue
	 *            the value to set on the derived typed element
	 * @throws DerivedTypedElementException
	 *             if the query of the derived typed element could not be
	 *             evaluated correctly to set the value
	 */
	void setValue(DerivedTypedElement derivedTypedElement, EObject source,
			List<ParameterValue> parameterValues, Object newValue)
			throws DerivedTypedElementException;

	/**
	 * Return whether to check the type of the derived typed element result after its evaluation
	 * <p>
	 * Normally, this is <code>true</code>, but the derived typed element evaluator can choose to
	 * skip the check, for example if the return type of the query can't be loaded.
	 *
	 * @return whether to check the type of the derived typed element result after its evaluation
	 */
	boolean getCheckResultType();

}
