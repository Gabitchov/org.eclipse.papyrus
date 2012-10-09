/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry;


/**
 * @author cedric dumoulin
 *
 */
public class DeclarationNotFoundException extends DeclarationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public DeclarationNotFoundException() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DeclarationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public DeclarationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public DeclarationNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public DeclarationNotFoundException(Throwable cause) {
		super(cause);
	}

}
