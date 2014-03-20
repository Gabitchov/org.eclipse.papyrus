/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.query.java.core.internal.evaluator;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.QueryException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryEvaluator;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueListFactory;

/**
 * This class is the EMF Facet Java Query Evaluator
 * 
 * @author Gregoire Dupe (Mia-Software)
 */
// deprecated but still maintained
@SuppressWarnings("deprecation")
public class JavaQueryEvaluator implements IQueryEvaluator {

	// This class is modified copy of :
	// org.eclipse.papyrus.emf.facet.infra.query.core.java.internal.JavaModelQueryAdapter
	private final IJavaQuery<EObject, ?> javaQuery;
	private boolean checkResultType = false;

	/**
	 * @param query
	 * @param javaQuery
	 *            the javaQuery to be evaluated
	 */
	public JavaQueryEvaluator(final Query query,
			final IJavaQuery<EObject, ?> javaQuery) {
		this.javaQuery = javaQuery;
	}

	public Object basicEvaluate(final Query query, final EObject context,
			final List<ParameterValue> parameterValues) throws QueryException {

		IParameterValueList plist = IParameterValueListFactory.INSTANCE
				.createParameterValueList();

		if (parameterValues != null) {
			plist.addAll(parameterValues);
		}
		return this.javaQuery.evaluate(context, plist);

	}

	public boolean getCheckResultType() {
		return this.checkResultType;
	}

	public void setCheckResultType(final boolean checkResultType) {
		this.checkResultType = checkResultType;
	}

	public void startEvaluate() {
		// Nothing to do
	}

	public void endEvaluate() {
		// Nothing to do
	}
}
