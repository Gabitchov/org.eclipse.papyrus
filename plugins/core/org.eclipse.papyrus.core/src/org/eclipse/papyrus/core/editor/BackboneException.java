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
package org.eclipse.papyrus.core.editor;

/**
 * Root of Backbone Exception
 * 
 * @author dumoulin
 * 
 */
public class BackboneException extends Exception {

	/**
	 * serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = 4859634627616979417L;

	/**
	 * Creates a new BackboneException.
	 */
	public BackboneException() {
		super();
	}

	/**
	 * Creates a new BackboneException with the specified message.
	 * 
	 * @param message
	 *        the message of the exception
	 */
	public BackboneException(String message) {
		super(message);
	}

	/**
	 * Creates a new BackboneException with the specified cause.
	 * 
	 * @param cause
	 *        the cause of the exception
	 */
	public BackboneException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a new BackboneException with a specified message and the specified cause.
	 * 
	 * @param message
	 *        the message of the exception
	 * @param cause
	 *        the cause of the exception
	 */
	public BackboneException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
