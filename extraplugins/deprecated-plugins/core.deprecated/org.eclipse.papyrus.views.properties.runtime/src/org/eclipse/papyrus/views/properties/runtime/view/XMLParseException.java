/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.view;


/**
 * Exception thrown when the XML parsing of the property view definition did not work correctly
 */
public class XMLParseException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -8807648762667856170L;

	/**
	 * Creates a new XMLParseException.
	 * 
	 * @param message
	 *        the message of the exception
	 */
	public XMLParseException(String message) {
		super(message);
	}
}
