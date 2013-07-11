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

package org.eclipse.papyrus.infra.core.serviceregistry;

import org.eclipse.core.runtime.IExtensionRegistry;


/**
 * @author dumoulin
 *
 */
public class ExtensionServiceDescriptorsWithIdProviderFromFile extends ExtensionServiceDescriptorsWithIdProvider {

	protected IExtensionRegistry extensionRegistry;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param extensionRegistry
	 * @throws ServiceException
	 */
	public ExtensionServiceDescriptorsWithIdProviderFromFile(IExtensionRegistry extensionRegistry) throws ServiceException {
		super();
		this.extensionRegistry = extensionRegistry;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	protected IExtensionRegistry getExtensionRegistry() {
		return extensionRegistry;
	}
}
