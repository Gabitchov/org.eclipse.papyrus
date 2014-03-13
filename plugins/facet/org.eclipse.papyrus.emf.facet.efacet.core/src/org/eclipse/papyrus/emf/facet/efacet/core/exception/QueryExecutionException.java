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
package org.eclipse.papyrus.emf.facet.efacet.core.exception;

import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.DerivedTypedElementEvaluationException;

/**
 * This exception occurs when something goes wrong during the execution of a
 * query.
 * 
 * @deprecated replaced by {@link DerivedTypedElementEvaluationException} cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=374678
 */
@Deprecated
public class QueryExecutionException extends QueryException {
	// This class is a copy of
	// org.eclipse.papyrus.emf.facet.infra.query.core.ModelQueryExecutionException

	private static final long serialVersionUID = -8464252257666617685L;

	public QueryExecutionException(final String message) {
		super(message);
	}

	public QueryExecutionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public QueryExecutionException(final Throwable cause) {
		super(cause);
	}

}
