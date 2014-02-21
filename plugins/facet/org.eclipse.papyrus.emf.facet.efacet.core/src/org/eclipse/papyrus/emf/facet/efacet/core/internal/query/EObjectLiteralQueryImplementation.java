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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.DerivedTypedElementEvaluationException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;

public class EObjectLiteralQueryImplementation implements IQueryImplementation {

	private boolean checkResultType = false;

	public Object getValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		return ((EObjectLiteralQuery) query).getElement();
	}

	public void setValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues,
			final Object newValue)
			throws DerivedTypedElementException {
		throw new DerivedTypedElementEvaluationException("Not implemented"); //$NON-NLS-1$
	}

	public boolean isCheckResultType() {
		return this.checkResultType;
	}

	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}
}
