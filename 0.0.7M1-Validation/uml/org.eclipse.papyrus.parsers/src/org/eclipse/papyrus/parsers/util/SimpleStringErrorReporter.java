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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.util;

/**
 * Simple implementation of the error reporter for lexer/parser generated from ANTLR grammar
 */
public class SimpleStringErrorReporter implements IErrorReporter {

	/** stored message */
	private String message = null;

	/**
	 * {@inheritDoc}
	 */
	public void reportError(String error) {
		setMessage(error);
	}

	/**
	 * Sets the error message
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the error message
	 * 
	 * @return the message to return
	 */
	public String getMessage() {
		return message;
	}

}
