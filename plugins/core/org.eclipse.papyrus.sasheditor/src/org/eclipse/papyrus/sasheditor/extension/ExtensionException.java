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
package org.eclipse.papyrus.sasheditor.extension;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Base class for extension exceptions.
 * 
 * @author dumoulin
 * 
 */
public class ExtensionException extends Exception {

	/**
	 * Serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = 3600741749544665873L;

	/**
	 * Creates a new BadNameExtensionException.
	 */
	public ExtensionException() {
	}

	/**
	 * Creates a new BadNameExtensionException.
	 * 
	 * @param message
	 *            the message associated to this exception
	 */
	public ExtensionException(String message) {
		super(message);
	}

	/**
	 * Creates a new BadNameExtensionException.
	 * 
	 * @param cause
	 *            the cause of this exception
	 */
	public ExtensionException(Throwable cause) {
		super(cause);

	}

	/**
	 * Creates a new BadNameExtensionException.
	 * 
	 * @param message
	 *            the message associated to this exception
	 * @param cause
	 *            the cause of this exception
	 */
	public ExtensionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Returns the name of the plugin and extension declaring the extension.
	 * 
	 * @param element
	 *            the configuration element being parsed
	 * @return a formatted string that displays information about the configuration element
	 */
	protected static String declaringExtensionToString(IConfigurationElement element) {
		return "plugin:" + element.getContributor().getName() + " extension:" + element.getName();
	}

}
