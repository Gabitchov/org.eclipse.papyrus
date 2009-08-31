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
 * Exception thrown when a required attribute is missing in an extension
 * 
 * @author dumoulin
 */
public class RequiredAttributeExtensionException extends ExtensionException {

	/**
	 * Serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = 1970633049487494800L;

	/**
	 * Creates a new RequiredAttributeExtensionException.
	 * 
	 * @param element
	 *            the configuration element being parsed
	 * @param attributeName
	 *            the name of the missing attribute
	 */
	public RequiredAttributeExtensionException(IConfigurationElement element, String attributeName) {
		super(declaringExtensionToString(element) + ". " + attributeName + " - Element is required.");
	}

}
