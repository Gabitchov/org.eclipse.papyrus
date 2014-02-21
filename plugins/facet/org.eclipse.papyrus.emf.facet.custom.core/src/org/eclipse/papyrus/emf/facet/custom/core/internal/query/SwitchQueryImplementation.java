/**
 * Copyright (c) 2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 418885 - ETypedElementSwitchQuery implemented using a deprecated query evaluator extension point
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;

public class SwitchQueryImplementation implements IQueryImplementation {

	private static final String PARAM_NAME = "eStructuralFeature"; //$NON-NLS-1$
	private final ETypedElementSwitchQuery query;
	private boolean checkResultType = false;

	/**
	 * @param query
	 * @param query
	 *            the javaQuery to be evaluated
	 */
	public SwitchQueryImplementation(final ETypedElementSwitchQuery query) {
		this.query = query;
	}

	public Object getValue(final Query query2,
			final DerivedTypedElement feature, final EObject source,
			final List<ParameterValue> parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		Object result = null;
		EStructuralFeature sfParam = null;
		for (final ParameterValue parameterValue : parameterValues) {
			if (parameterValue.getParameter().getName().equals(PARAM_NAME)) {
				sfParam = (EStructuralFeature) parameterValue.getValue();
			}
		}
		for (ETypedElementCase eTECase : this.query.getCases()) {
			if (eTECase.getCase() == sfParam) {
				final Query subquery = eTECase.getValue();
				if (subquery != null) {
					result = IDerivedTypedElementManager.INSTANCE.evaluate(
							subquery, source, parameterValues, facetManager);
				}
				break;
			}
		}
		return result;
	}

	public void setValue(final Query query2, final DerivedTypedElement feature,
			final EObject source, final List<ParameterValue> parameterValues,
			final Object newValue) throws DerivedTypedElementException {
		throw new UnsupportedOperationException("Not implemented yet"); //$NON-NLS-1$
	}

	public boolean isCheckResultType() {
		return this.checkResultType;
	}

	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}

}
