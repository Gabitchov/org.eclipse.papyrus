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
 * Exception thrown when an extension does not declare a correct class name, when an attributes
 * refers to a java class.
 * 
 * @author dumoulin
 * @author Remi Schnekenburger
 */
public class BadClassNameException extends ExtensionException {

	/**
	 * Serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = -8984760583764726337L;

	/**
	 * Creates a new BadClassNameException.
	 * 
	 * @param element
	 *            the configuration element being parsed
	 * @param attributeName
	 *            the name of the attribute which contains the class name
	 * @param e
	 *            the exception thrown by eclipse framework when parsing the extension point
	 */
	public BadClassNameException(IConfigurationElement element, String attributeName, ClassNotFoundException e) {
		super(declaringExtensionToString(element) + " - " + attributeName + "=" + element.getAttribute(attributeName),
				e);
	}

}
