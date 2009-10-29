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
package org.eclipse.papyrus.core.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.papyrus.core.editor.BackboneException;

/**
 * Base class for extension exceptions
 * 
 * @author dumoulin
 * @author schnekenburger
 */
public class ExtensionException extends BackboneException {

	/**
	 * serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = -9144153309491137046L;

	/**
	 * Creates a simple ExtensionException.
	 */
	public ExtensionException() {
	}

	/**
	 * Creates a ExtensionException with a specific message.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public ExtensionException(String message) {
		super(message);
	}

	/**
	 * Creates a ExtensionException with a specific cause.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */
	public ExtensionException(Throwable cause) {
		super(cause);

	}

	/**
	 * Creates a ExtensionException with a specific cause and a specific message.
	 * 
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public ExtensionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Return the name of the plugin and extension declaring the extension.
	 * 
	 * @param element
	 *            the configuration element corresponding to the extension
	 * @return a string containing the name of the plugin and the name of the extension
	 */
	// @unused
	protected static String declaringExtensionToString(IConfigurationElement element) {
		return "plugin:" + element.getContributor().getName() + " extension:" + element.getName();
	}

}
