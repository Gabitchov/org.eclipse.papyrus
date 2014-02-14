/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exception;

public class SdkUiRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 6503448051517995525L;

	public SdkUiRuntimeException() {
		super();
	}

	public SdkUiRuntimeException(final String message) {
		super(message);
	}

	public SdkUiRuntimeException(final Throwable cause) {
		super(cause);
	}

	public SdkUiRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
