/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 *    Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *    Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *    Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *    Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.papyrus.emf.facet.query.java.core.internal.evaluator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.query.QueryUtils;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.internal.plugin.Activator;
import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQueryPackage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.osgi.framework.Bundle;

public class JavaQueryImplementationFactory implements IQueryImplementationFactory {

	public IQueryImplementation create(final Query query, final Bundle bundle, final IDerivedTypedElementManager manager) throws DerivedTypedElementException {
		if (!(query instanceof JavaQuery)) {
			throw new IllegalArgumentException("The given DerivedTypedElement does not have a JavaQuery"); //$NON-NLS-1$
		}
		JavaQuery javaQuery = (JavaQuery) query;

		if (bundle == null) {
			throw new DerivedTypedElementException("Java query implementation class '" //$NON-NLS-1$
					+ javaQuery.getClass().getName()
					+ "' should be created within a bundle."); //$NON-NLS-1$
		}
		JavaQueryImplementation javaQueryEvaluator = null;
		try {
			String className = javaQuery.getImplementationClassName();
			if (className == null || className.length() == 0) {
				throw new DerivedTypedElementException("The Java query's implementationClassName must not be empty"); //$NON-NLS-1$
			}
			Class<?> javaQueryClass = bundle.loadClass(className);
			if (!IJavaQuery2.class.isAssignableFrom(javaQueryClass)) {
				throw new Exception("Java query implementation class '" + className + "' does not implement " //$NON-NLS-1$ //$NON-NLS-2$
						+ IJavaQuery2.class.getSimpleName() + "."); //$NON-NLS-1$
			}
			javaQueryEvaluator = createJavaQueryImpl(javaQueryClass);
			// Initially a null test was performed on bundle to determine whether
			// to check the result type. Now we need a bundle so
			// checkResultType=true
			javaQueryEvaluator.setCheckResultType(true);
		} catch (Exception e) {
			DerivedTypedElementException queryException = new DerivedTypedElementException(
					"The bundle " + bundle.getSymbolicName() + " failed to load the java query: " //$NON-NLS-1$ //$NON-NLS-2$
							+ QueryUtils.getQueryDescription(javaQuery), e);
			Logger.logError(queryException, Activator.getDefault());
			throw queryException;
		}
		return javaQueryEvaluator;
	}

	/** This method is dedicated to isolate the "Unchecked cast" warning. */
	@SuppressWarnings("unchecked")
	private static JavaQueryImplementation createJavaQueryImpl(final Class<?> javaQueryClass)
			throws InstantiationException, IllegalAccessException {
		IJavaQuery2<EObject, ?> javaQueryInst;
		javaQueryInst = (IJavaQuery2<EObject, ?>) javaQueryClass.newInstance();
		JavaQueryImplementation javaQueryEvaluator = new JavaQueryImplementation(javaQueryInst);
		return javaQueryEvaluator;
	}

	public EClass getManagedQueryType() {
		return JavaQueryPackage.eINSTANCE.getJavaQuery();
	}
}
