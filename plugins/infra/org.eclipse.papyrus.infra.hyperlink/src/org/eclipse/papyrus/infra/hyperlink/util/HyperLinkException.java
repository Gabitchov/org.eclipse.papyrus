/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.util;

/**
 * this is an exception that can be raised when hyperlinks are manipulated 
 *
 */
public class HyperLinkException extends Exception {

	/**
	 * a serial version
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * constructor
	 */
	public HyperLinkException() {
	}

	/**
	 * @param message
	 */
	public HyperLinkException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public HyperLinkException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HyperLinkException(String message, Throwable cause) {
		super(message, cause);
	}
}
