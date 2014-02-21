/**
 * Copyright (c) 2012, 2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Nicolas Bros (Mia-Software) - Bug 378271 - [Table] Select Columns To Hide is broken
 *     Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *     Gregoire Dupé (Mia-Software) - Bug 418885 - ETypedElementSwitchQuery implemented using a deprecated query evaluator extension point
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IDerivedTypedElementImplementation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;

/**
 * @deprecated replaced by {@link SwitchQueryImplementation}
 */
@Deprecated
public class ETypedElementSwitchQueryImplementation implements IDerivedTypedElementImplementation {

	private static final String PARAM_NAME = "eStructuralFeature"; //$NON-NLS-1$
	private boolean checkResultType = false;
	private final ETypedElementSwitchQuery query;
	private final IDerivedTypedElementManager derivedTEMgr;

	public ETypedElementSwitchQueryImplementation(
			final ETypedElementSwitchQuery query,
			final IDerivedTypedElementManager derivedTEMgr) {
		this.query = query;
		this.derivedTEMgr = derivedTEMgr;
	}

	public Object getValue(final DerivedTypedElement derivedTypedElt,
			final EObject source, final List<ParameterValue> parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		Object result = null;
		EStructuralFeature sfParam = null;
		for (final ParameterValue parameterValue : parameterValues) {
			if (parameterValue.getParameter().getName()
					.equals(PARAM_NAME)) {
				sfParam = (EStructuralFeature) parameterValue.getValue();
			}

		}
		// note: sfParam is null when there is no case query (i.e: case is always true)
		for (final ETypedElementCase eTECase : this.query.getCases()) {
			if (eTECase.getCase() == sfParam) {
				result = this.derivedTEMgr.evaluate(eTECase.getValue(), source,
						parameterValues, facetManager);
			}
		}
		return result;
	}

	public void setValue(final DerivedTypedElement derivedTypedElt,
			final EObject source, final List<ParameterValue> parameterValues,
			final Object newValue) throws DerivedTypedElementException {
		throw new DerivedTypedElementException("Not implemented"); //$NON-NLS-1$
	}

	public boolean getCheckResultType() {
		return this.checkResultType;
	}

	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}
}
