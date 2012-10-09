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
 * Root exception of exceptions thrown while reading descriptor declarations.
 * 
 * @author cedric dumoulin
 *
 */
public class DeclarationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public DeclarationException() {
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public DeclarationException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public DeclarationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public DeclarationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DeclarationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
