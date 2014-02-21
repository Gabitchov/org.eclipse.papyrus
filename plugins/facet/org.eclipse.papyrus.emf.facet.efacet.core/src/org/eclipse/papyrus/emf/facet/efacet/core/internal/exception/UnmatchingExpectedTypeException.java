/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal.exception;

import org.eclipse.papyrus.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.papyrus.emf.facet.util.core.internal.ErrorHandlingUtils;

/**
 * This exception is raised when a value's type does not match with the expected type
 *
 * @since 0.2
 */
public class UnmatchingExpectedTypeException extends FacetManagerException {

	private static final long serialVersionUID = 1456802297756942271L;

	public UnmatchingExpectedTypeException() {
		super();
	}

	public UnmatchingExpectedTypeException(final String message) {
		super(message);
	}

	public UnmatchingExpectedTypeException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UnmatchingExpectedTypeException(final Throwable cause) {
		super(cause);
	}

	public UnmatchingExpectedTypeException(final String message, final Class<?> expectedType, final Object resultElement) {
		super(ErrorHandlingUtils.buildWrongTypeMessage(message, expectedType, resultElement));
	}
}
