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

import org.antlr.runtime.RecognitionException;

/**
 * Exception to manage bad name exception
 */
public class NameException extends RecognitionException {

	/** Serial ID */
	private static final long serialVersionUID = -8831007802595595763L;

	/**
	 * Creates a new MultiplicityException.
	 * 
	 * @param message
	 *        the message of the exception
	 */
	public NameException() {
		super();
	}
}
