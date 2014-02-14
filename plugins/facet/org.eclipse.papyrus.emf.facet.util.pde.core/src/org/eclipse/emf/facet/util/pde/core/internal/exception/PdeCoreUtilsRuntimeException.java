/*******************************************************************************
 * Copyright (c) 2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 408344 - [Releng] Deep folders cause build break
 *******************************************************************************/
package org.eclipse.emf.facet.util.pde.core.internal.exception;

public class PdeCoreUtilsRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7462304304846835284L;

	public PdeCoreUtilsRuntimeException() {
		super();
	}

	public PdeCoreUtilsRuntimeException(final String message) {
		super(message);
	}

	public PdeCoreUtilsRuntimeException(final Throwable cause) {
		super(cause);
	}

	public PdeCoreUtilsRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
