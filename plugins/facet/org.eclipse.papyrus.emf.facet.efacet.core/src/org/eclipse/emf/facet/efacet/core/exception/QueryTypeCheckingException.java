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
package org.eclipse.emf.facet.efacet.core.exception;

import org.eclipse.emf.facet.efacet.core.internal.exception.DerivedTypedElementTypeCheckingException;

/**
 * This exception occurs when the type of a query result is not the one expected
 *
 * @deprecated replaced by {@link DerivedTypedElementTypeCheckingException}
 */
@Deprecated
public class QueryTypeCheckingException extends QueryException {

	private static final long serialVersionUID = -9064274334817642819L;

	public QueryTypeCheckingException(final String message) {
		super(message);
	}

	public QueryTypeCheckingException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public QueryTypeCheckingException(final Throwable cause) {
		super(cause);
	}
}
