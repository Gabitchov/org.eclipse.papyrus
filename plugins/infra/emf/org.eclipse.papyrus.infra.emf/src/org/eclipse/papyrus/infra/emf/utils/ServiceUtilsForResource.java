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

package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;

/**
 * @author cedric dumoulin
 * 
 */
public class ServiceUtilsForResource extends AbstractServiceUtils<Resource> {

	private final static ServiceUtilsForResource instance = new ServiceUtilsForResource();

	/**
	 * Get the singleton instance of the class.
	 * 
	 * @return
	 */
	public static final ServiceUtilsForResource getInstance() {
		return instance;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils#getServiceRegistry(java.lang.Object)
	 * 
	 * @param from
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public ServicesRegistry getServiceRegistry(Resource from) throws ServiceException {
		
		// An AdapterFactory referencing the ServiceRegistry is attache to the REsourceSet.
		// Try to get it.
		ServiceRegistryAdapterFactory factory = (ServiceRegistryAdapterFactory)EcoreUtil.getAdapterFactory(from.getResourceSet().getAdapterFactories(), ServiceRegistryAdapterFactory.TYPE_ID);
		if( factory == null) {
			throw new ServiceNotFoundException("Can't find the ServiceRegistry. No Adapter is attached to the ResourceSet. Check if the proper service is ");
		}
		return factory.getServicesRegistry();
	}

}
