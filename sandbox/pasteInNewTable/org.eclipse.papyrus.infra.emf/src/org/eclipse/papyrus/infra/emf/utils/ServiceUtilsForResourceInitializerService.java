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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.BadStateException;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;

/**
 * This service register inside the ResourceSet an AdapterFactory referencing the ServiceRegistry.
 * This will allows to get the ServicesRegistry from any EMF object (see {@link ServiceUtilsForResource}.
 * The AdapterFactory can't provide Adapters. It is only used to hold a reference on the ServiceRegistry.
 * 
 * This service depends on the ModelSet service.
 * 
 * 
 * @see ServiceRegistryAdapterFactory
 * @see ServiceUtilsForResource
 * 
 * @author cedric dumoulin
 * 
 */
public class ServiceUtilsForResourceInitializerService implements IService {

	ServicesRegistry servicesRegistry;
	
	/**
	 * Create a {@link ServiceRegistryAdapterFactory} and associate it to the ResourceSet.
	 * 
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		
		this.servicesRegistry = servicesRegistry;
		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);
		
		// Check if the Adapter Factory is already attached.
		if( lookupServiceRegistryAdapterFactory(modelSet) != null ) {
			return;
		}
		
		// Attach the adapter
		ServiceRegistryAdapterFactory factory = new ServiceRegistryAdapterFactory(servicesRegistry);
		modelSet.getAdapterFactories().add(factory);
		
	}

	/**
	 * Return the AdapterFactory, or null if none is found.
	 * @param resourceSet
	 * @return
	 */
	private ServiceRegistryAdapterFactory lookupServiceRegistryAdapterFactory(ResourceSet resourceSet) {
		ServiceRegistryAdapterFactory factory = (ServiceRegistryAdapterFactory)EcoreUtil.getAdapterFactory(resourceSet.getAdapterFactories(), ServiceRegistryAdapterFactory.TYPE_ID);

		return factory;
	}

	/**
	 * 
	 */
	public void startService() throws ServiceException {
		// Do nothing
		
	}

	/**
	 * Detach the Adapter from the resourceSet
	 */
	public void disposeService() throws ServiceException {
		
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);
			ServiceRegistryAdapterFactory factory = lookupServiceRegistryAdapterFactory(modelSet);

			modelSet.getAdapterFactories().remove(factory);
		} catch (BadStateException e) {
			// ModelSet is already disposed. Do nothing
		}
	}
		
}
