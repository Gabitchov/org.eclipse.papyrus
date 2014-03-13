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

/**
 * This exception is raised when something is wrong with a query, and there is not a more specific
 * sub-class to describe the error (e.g. {@link QueryExecutionException} )
 *
 * @deprecated replaced by {@link DerivedTypedElementException}
 */
@Deprecated
public class QueryException extends Exception {

	// This class is a copy of :
	// org.eclipse.papyrus.emf.facet.infra.query.core.exception.ModelQueryException

	private static final long serialVersionUID = -3203874059325745157L;

	public QueryException(final String message) {
		super(message);
	}

	public QueryException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public QueryException(final Throwable cause) {
		super(cause);
	}

}
