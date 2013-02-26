/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;


public class ServiceUtilsForResourceSet extends AbstractServiceUtils<ResourceSet> {

	private ServiceUtilsForResourceSet() {
		//Singleton
	}

	private static ServiceUtilsForResourceSet instance = new ServiceUtilsForResourceSet();

	public static ServiceUtilsForResourceSet getInstance() {
		return instance;
	}

	@Override
	public ServicesRegistry getServiceRegistry(ResourceSet from) throws ServiceException {
		if(from == null) {
			throw new ServiceNotFoundException("Can't find the ResourceSet needed retrieve the ServiceRegistry.");
		}

		// An AdapterFactory referencing the ServiceRegistry is attache to the REsourceSet.
		// Try to get it.
		ServiceRegistryAdapterFactory factory = (ServiceRegistryAdapterFactory)EcoreUtil.getAdapterFactory(from.getAdapterFactories(), ServiceRegistryAdapterFactory.TYPE_ID);
		if(factory == null) {
			throw new ServiceNotFoundException("Can't find the ServiceRegistry. No Adapter is attached to the ResourceSet. Check if the proper service is ");
		}
		return factory.getServicesRegistry();
	}

}
