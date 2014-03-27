/*******************************************************************************
 * Copyright (c) 2013 Soft-Maint.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Fabien Treguer (Soft-Maint) - Bug 418565 - [Unit Test Failure] Missing dependencies during tests, target platform creation and load
 ******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.pde.core.internal.exported.exception;

public class PdeCoreUtilsException extends Exception {

	private static final long serialVersionUID = -7462304304846835284L;

	public PdeCoreUtilsException() {
		super();
	}

	public PdeCoreUtilsException(final String message) {
		super(message);
	}

	public PdeCoreUtilsException(final Throwable cause) {
		super(cause);
	}

	public PdeCoreUtilsException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
