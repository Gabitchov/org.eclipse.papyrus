/*****************************************************************************
 * Copyright (c) 2014 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.resource;


/**
 * Exception thrown when an argument is invalid.
 * 
 * @author cedric dumoulin
 *
 */
public class BadArgumentExcetion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public BadArgumentExcetion() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public BadArgumentExcetion(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public BadArgumentExcetion(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public BadArgumentExcetion(String message, Throwable cause) {
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
	public BadArgumentExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
