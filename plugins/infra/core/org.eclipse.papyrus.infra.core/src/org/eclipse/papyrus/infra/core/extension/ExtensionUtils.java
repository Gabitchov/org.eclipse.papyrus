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
 *  Patrick Tessier (CEA LIST)  patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Utility methods for Eclipse extension reading. This class can be extended, or
 * access throw the unique instance.
 * 
 * @author cedric dumoulin
 * @author Patrick Tessier
 */
public abstract class ExtensionUtils {

	/**
	 * Unique instance that can be used directly.
	 */
	static public ExtensionUtils INSTANCE = new ExtensionUtils() {
	};

	/**
	 * used to verify if the name of the {@link IConfigurationElement} is the
	 * same as the given name
	 * 
	 * @param element
	 *        an {@link IConfigurationElement} see eclipse extension point
	 * @param tagName
	 *        the name of the {@link IConfigurationElement} that has to be
	 *        verified
	 * @throws InvalidRegistryObjectException
	 * @throws BadNameExtensionException
	 */
	protected void checkTagName(IConfigurationElement element, String tagName) throws BadNameExtensionException {
		String name = element.getName();
		if(!tagName.equals(name))
			throw new BadNameExtensionException("Expected '" + tagName + "', found '" + name + "'.");
	}

	/**
	 * Retrieves the value of a specific attribute in a configuration element
	 * 
	 * @param element
	 *        the configuration element to parse
	 * @param attributeName
	 *        the name of the attribute to read
	 * @param extensionPointName
	 *        Name of the extension point. Used in exception msg. TODO:
	 *        remove ?
	 * 
	 * @return the class, result of the parsing
	 * @throws InvalidRegistryObjectException
	 * @throws BadClassNameException
	 */
	protected Class<?> parseClass(IConfigurationElement element, String attributeName, String extensionPointName) throws BadClassNameException {
		String className = element.getAttribute(attributeName);

		element.getContributor().getName();
		if(className == null || className.length() == 0) {
			throw new BadClassNameException(attributeName + "=null ", extensionPointName, attributeName);
		}
		Class<?> factoryClass;
		try {
			factoryClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// try another way
			try {
				String declaringID = element.getContributor().getName();
				Bundle bundle = Platform.getBundle(declaringID);
				factoryClass = bundle.loadClass(className);
			} catch (ClassNotFoundException e1) {
				throw new BadClassNameException(className + " can not be loaded ", extensionPointName, attributeName, e1);
			}
		}
		return factoryClass;
	}

}
