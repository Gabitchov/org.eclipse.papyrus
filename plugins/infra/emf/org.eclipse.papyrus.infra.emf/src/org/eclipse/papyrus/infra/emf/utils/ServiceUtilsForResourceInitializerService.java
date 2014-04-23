/*****************************************************************************
 * Copyright (c) 2012, 2014 Cedric Dumoulin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (pre-requisite refactoring of ModelSet service start-up)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
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
 * @deprecated Since 1.0, the {@link ModelSetServiceFactory} class associates the model-set with its service registry
 *             and an injected {@link ModelSet} has an external service lifecycle adapter provided for it.
 */
@Deprecated
public class ServiceUtilsForResourceInitializerService implements IService {

	ServicesRegistry servicesRegistry;
	
	/**
	 * Associate the service registry with the resource set if the resource set wasn't created by the registry.
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		
		this.servicesRegistry = servicesRegistry;
		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);
		
		ModelSetServiceFactory.setServiceRegistry(modelSet, servicesRegistry);
	}

	public void startService() throws ServiceException {
		// Do nothing
	}

	/**
	 * Ensure that the service registry is dissociated from the resource set.
	 */
	public void disposeService() throws ServiceException {
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(servicesRegistry);
			
			ModelSetServiceFactory.setServiceRegistry(modelSet, null);
		} catch (BadStateException e) {
			// ModelSet is already disposed. Do nothing
		}
	}
		
}
