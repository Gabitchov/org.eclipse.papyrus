/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.core.extension;

/**
 * Exception thrown when something is not found when parsing a configuration element.
 * 
 * @author dumoulin
 * @author schnekenburger
 */
public class NotFoundException extends ExtensionException {

	/**
	 * serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = -130754574538610199L;

	/**
	 * Creates a simple NotFoundException.
	 */
	public NotFoundException() {
	}

	/**
	 * Creates a NotFoundException with a specific message.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Creates a NotFoundException with a specific cause.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a NotFoundException with a specific cause and a specific message.
	 * 
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
