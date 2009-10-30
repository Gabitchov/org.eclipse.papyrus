/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sashwindows.di.exception;


/**
 * Exception for the Sash editor system
 * @author eperico
 */
public class SashEditorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new sash editor exception.
	 */
	public SashEditorException() {
	}

	/**
	 * @param message
	 */
	public SashEditorException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SashEditorException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SashEditorException(String message, Throwable cause) {
		super(message, cause);
	}

}
