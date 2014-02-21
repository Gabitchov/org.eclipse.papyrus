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
package org.eclipse.papyrus.emf.facet.efacet.core.internal.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.DerivedTypedElementEvaluationException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;

public class OperationCallQueryImplementation implements IQueryImplementation {

	private boolean checkResultType = false;
	private final IDerivedTypedElementManager derivedTEManager;

	public OperationCallQueryImplementation(final IDerivedTypedElementManager derivedTEManager) {
		this.derivedTEManager = derivedTEManager;
	}

	public Object getValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		Object result;
		final OperationCallQuery opQuery = (OperationCallQuery) query;
		final List<Object> operationArgs = new ArrayList<Object>();
		for (final Query queryArgument : opQuery.getArguments()) {
			operationArgs.add(this.derivedTEManager.evaluate(queryArgument, source, parameterValues, facetManager));
		}

		// FIXME: no EditingDomain is available here
		try {
			result = facetManager.invoke(source, opQuery.getOperation(), null, null, operationArgs.toArray());
		} catch (final FacetManagerException e) {
			throw new DerivedTypedElementEvaluationException("Operation call evaluation failed", e); //$NON-NLS-1$
		}
		return result;
	}

	public void setValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues, final Object newValue)
			throws DerivedTypedElementException {
		throw new DerivedTypedElementEvaluationException("A set operation cannot be performed through an operation call."); //$NON-NLS-1$

	}

	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}

	public boolean isCheckResultType() {
		return this.checkResultType;
	}
}
