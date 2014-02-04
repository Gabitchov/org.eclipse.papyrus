/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


/**
 * Service to register extended element types
 */
public class ExtendedTypeRegistryService implements IService {

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void startService() throws ServiceException {
		// register elements in element type registry
		ExtendedElementTypeSetRegistry.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeService() throws ServiceException {
		// extended element type set registry should unregister all added element types in the gmf registry
		ElementTypeSetUtils.resetRegistry();
		
	}
	
	public ExtendedElementTypeSetRegistry getExtendedElementTypeSetRegistry() {
		return ExtendedElementTypeSetRegistry.getInstance();
	}
	
}
