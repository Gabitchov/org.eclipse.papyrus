/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 */
package org.eclipse.emf.facet.query.java.core.internal.evaluator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.core.exception.QueryException;
import org.eclipse.emf.facet.efacet.core.exception.QueryExecutionException;
import org.eclipse.emf.facet.efacet.core.query.IQueryEvaluator;
import org.eclipse.emf.facet.efacet.core.query.IQueryEvaluatorFactory;
import org.eclipse.emf.facet.query.java.core.IJavaQuery;
import org.eclipse.emf.facet.query.java.core.internal.plugin.Activator;
import org.eclipse.emf.facet.query.java.javaquery.JavaQuery;
import org.eclipse.emf.facet.query.java.javaquery.JavaqueryPackage;
import org.eclipse.emf.facet.util.core.Logger;
import org.osgi.framework.Bundle;


@Deprecated
public class JavaQueryEvaluatorFactory implements IQueryEvaluatorFactory {
	public IQueryEvaluator create(final Query query, final Bundle bundle)
			throws QueryException {
		if (!(query instanceof JavaQuery)) {
			throw new QueryException("Wrong kind of Query: " //$NON-NLS-1$
					+ query.getClass().getSimpleName() + " found, " //$NON-NLS-1$
					+ JavaQuery.class.getSimpleName() + " expected."); //$NON-NLS-1$
		}
		if (bundle == null) {
			throw new QueryException("Query: " //$NON-NLS-1$
					+ query.getClass().getSimpleName()
					+ " should be create with a bundle."); //$NON-NLS-1$
		}
		JavaQueryEvaluator javaQueryEvaluator = null;
		try {
			JavaQuery javaQuery = (JavaQuery) query;
			String className = javaQuery.getImplementationClassName();
			if (className == null || className.length() == 0) {
				throw new QueryExecutionException(
						"implementationClassName is empty"); //$NON-NLS-1$
			}
			Class<?> javaQueryClass = bundle.loadClass(className);
			if (!IJavaQuery.class.isAssignableFrom(javaQueryClass)) {
				throw new Exception(className + " does not implement " //$NON-NLS-1$
						+ IJavaQuery.class.getSimpleName() + "."); //$NON-NLS-1$
			}
			javaQueryEvaluator = createJavaQueryImpl(javaQuery,
					javaQueryClass);
			// Initially a null test was perform on bundle to determine whether
			// to check the result type. Now we need a bundle so
			// checkResultType=true
			javaQueryEvaluator.setCheckResultType(true);
		} catch (Exception e) {
			QueryException queryException = new QueryException(
					"Failed to load the java query:" //$NON-NLS-1$
							+ query.getName(), e);
			Logger.logError(queryException, Activator.getDefault());
			throw queryException;
		}
		return javaQueryEvaluator;
	}

	/** This methods is dedicated to isolate the "Unchecked cast" warning. */
	@SuppressWarnings("unchecked")
	private static JavaQueryEvaluator createJavaQueryImpl(
			final JavaQuery javaQuery, final Class<?> javaQueryClass)
			throws InstantiationException, IllegalAccessException {
		IJavaQuery<EObject, ?> javaQueryInst;
		javaQueryInst = (IJavaQuery<EObject, ?>) javaQueryClass
				.newInstance();
		JavaQueryEvaluator javaQueryEvaluator = new JavaQueryEvaluator(javaQuery,
				javaQueryInst);
		return javaQueryEvaluator;
	}

	public EClass getManagedQueryType() {
		return JavaqueryPackage.eINSTANCE.getJavaQuery();
	}

}
