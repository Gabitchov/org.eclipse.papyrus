/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - initial API and implementation
 *     Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *     Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.papyrus.emf.facet.query.java.core.internal.evaluator;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueListFactory2;

public class JavaQueryImplementation implements IQueryImplementation {

	// This class is a modified copy of :
	// org.eclipse.papyrus.emf.facet.infra.query.core.java.internal.JavaModelQueryAdapter

	private final IJavaQuery2<EObject, ?> javaQuery;
	private boolean checkResultType = false;

	/**
	 * @param query
	 * @param javaQuery
	 *            the javaQuery to be evaluated
	 */
	public JavaQueryImplementation(final IJavaQuery2<EObject, ?> javaQuery) {
		this.javaQuery = javaQuery;
	}

	public Object getValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		final IParameterValueList2 plist = IParameterValueListFactory2.INSTANCE
				.createParameterValueList();

		if (parameterValues != null) {
			plist.addAll(parameterValues);
		}
		return this.javaQuery.evaluate(source, plist, facetManager);
	}

	public void setValue(final Query query, final DerivedTypedElement feature, final EObject source, final List<ParameterValue> parameterValues, final Object newValue)
			throws DerivedTypedElementException {
		throw new UnsupportedOperationException("not implemented yet"); //$NON-NLS-1$
	}

	public boolean isCheckResultType() {
		return this.checkResultType;
	}
	
	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}
}
