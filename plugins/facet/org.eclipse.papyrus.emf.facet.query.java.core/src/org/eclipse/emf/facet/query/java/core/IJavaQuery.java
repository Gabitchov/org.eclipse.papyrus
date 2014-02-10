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
package org.eclipse.emf.facet.query.java.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.exception.QueryExecutionException;

/**
 * This is the EMF Facet Java Query interface. A java query is a query written
 * in Java.
 * 
 * This interface has to be used to declare a Java query.
 * 
 * @author Gregoire Dupe (Mia-Software)
 * @param <T>
 *            the context type (i.e., the type of the elements on which the
 *            query can be evaluated)
 * @param <R>
 *            the return type
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374678
 */
@Deprecated
public interface IJavaQuery<T extends EObject, R> {

	// This interface is a copy of
	// org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery<T, R>

	/**
	 * This method must be implemented by each sub class to implement query
	 * evaluation.
	 * 
	 * @param context
	 *            The query evaluation context (i.e., the element on which the
	 *            query will be evaluated)
	 * @param parameterValues
	 *            The query parameter values
	 * @return the result of the query
	 * @throws QueryExecutionException
	 */
	public R evaluate(final T context, final IParameterValueList parameterValues)
			throws QueryExecutionException;

}
