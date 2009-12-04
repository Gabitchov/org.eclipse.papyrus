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
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource.migration.controller.exceptions;

/**
 * This exception is thrown when the uri is not valid
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class URINotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public URINotValidException(String string) {
		super(string);
	}
}
