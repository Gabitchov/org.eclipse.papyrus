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
 * Exception to manage ill-formed multiplicity
 */
public class MultiplicityException extends RuntimeException {

	/** Serial ID */
	private static final long serialVersionUID = -6675171028982908999L;

	/**
	 * Creates a new MultiplicityException.
	 * 
	 * @param message
	 *        the message of the exception
	 */
	public MultiplicityException(String message) {
		super(message);
	}
}
