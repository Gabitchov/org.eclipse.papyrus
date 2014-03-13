/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Olivier Remaud (Soft-Maint)  - Bug 373087 - [Improvement] Adaptable behavior on error
 *     Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal.query;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.DerivedTypedElementEvaluationException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery;

public class NavigationQueryImplementation implements IQueryImplementation {

	// This class is a modified copy of :
	// org.eclipse.papyrus.emf.facet.infra.query.core.java.internal.JavaModelQueryAdapter

	private boolean checkResultType = false;

	public Object getValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		final NavigationQuery navigationQuery = (NavigationQuery) query;
		Object current = source;
		for (final ETypedElement typedElement : navigationQuery.getPath()) {
			if (current instanceof EObject) {
				final EObject currentEObject = (EObject) current;
				if (typedElement instanceof EOperation) {
					final EOperation operation = (EOperation) typedElement;
					try {
						current = currentEObject.eInvoke(operation, null);
					} catch (final InvocationTargetException e) {
						throw new DerivedTypedElementEvaluationException("Invocation of " + operation.getName() + " failed.", e); //$NON-NLS-1$//$NON-NLS-2$
					}
				} else if (typedElement instanceof EStructuralFeature) {
					final EStructuralFeature structuralFeature = (EStructuralFeature) typedElement;
					current = currentEObject.eGet(structuralFeature);
				} else {
					throw new DerivedTypedElementEvaluationException("The " + typedElement.eClass().getName() + " is not supported."); //$NON-NLS-1$//$NON-NLS-2$
				}
			} else {
				if (current != null || navigationQuery.isFailOnError()) {
					throw new DerivedTypedElementEvaluationException("Invalid path"); //$NON-NLS-1$
				}
			}
		}
		return current;
	}

	public void setValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues, final Object newValue)
			throws DerivedTypedElementException {
		throw new DerivedTypedElementEvaluationException("Not implemented"); //$NON-NLS-1$
	}

	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}

	public boolean isCheckResultType() {
		return this.checkResultType;
	}
}
