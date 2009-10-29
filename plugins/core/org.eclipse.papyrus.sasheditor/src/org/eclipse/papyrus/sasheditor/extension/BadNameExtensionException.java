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
package org.eclipse.papyrus.sasheditor.extension;

/**
 * Exception thrown when a bad name is encountered in extension processing.
 * 
 * @author dumoulin
 * @author Remi Schnekenburger
 */
public class BadNameExtensionException extends ExtensionException {

	/**
	 * Serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = -6393318424326486145L;

	/**
	 * Creates a new simple BadNameExtensionException
	 */
	// @unused
	public BadNameExtensionException() {
	}

	/**
	 * Creates a new BadNameExtensionException.
	 * 
	 * @param message
	 *            the message associated to this exception
	 */
	public BadNameExtensionException(String message) {
		super(message);
	}

	/**
	 * Creates a new BadNameExtensionException.
	 * 
	 * @param cause
	 *            the cause of this exception
	 */
	// @unused
	public BadNameExtensionException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a new BadNameExtensionException.
	 * 
	 * @param message
	 *            the message associated to this exception
	 * @param cause
	 *            the cause of this exception
	 */
	// @unused
	public BadNameExtensionException(String message, Throwable cause) {
		super(message, cause);
	}

}
