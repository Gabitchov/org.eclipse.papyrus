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
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

/**
 * <code>AssertionFailedException</code> is a runtime exception thrown by some of the methods in <code>Assert</code>.
 * 
 * @see Assert
 */
public class AssertionFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 347721942271940453L;

	/**
	 * Constructs a new exception with the given message.
	 * 
	 * @param detail
	 *            the message
	 */
	public AssertionFailedException(String detail) {
		super(detail);
	}
}
