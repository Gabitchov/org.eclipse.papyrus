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

package org.eclipse.papyrus.infra.core.serviceregistry.internal;

import org.eclipse.papyrus.infra.core.serviceregistry.DeclarationException;


/**
 * @author cedric dumoulin
 *
 */
public class BadDeclarationException extends DeclarationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public BadDeclarationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public BadDeclarationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public BadDeclarationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public BadDeclarationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
