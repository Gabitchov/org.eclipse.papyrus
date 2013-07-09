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
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;

/**
 * Get the {@link ServicesRegistry} from a {@link EObject} or a {@link Resource}.
 * This class allow to retrieve the {@link ServicesRegistry} associated to the {@link ResourceSet} owning the {@link Resource} owning the EObject.
 * 
 * <br>
 * To work properly, the EObject should be associated to a {@link Resource}, itself
 * registered in a {@link ResourceSet}.
 * Also, the ServicesRegistry should be associated to the ResourceSet with the help of the {@link ServiceRegistryAdapterFactory}. <br>
 * Normally, this is automatically done thanks to the {@link ServiceUtilsForResourceInitializerService} service. <br>
 * If you access this class from a service, you can ensure that the previous service is started by letting your service
 * depends on the <b>org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceInitializerService</b>.
 * 
 * 
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
	 * Get the {@link ServicesRegistry} from a {@link Resource}.
	 * 
	 * @param from
	 *        The {@link Resource} from which we want the associated {@link ServicesRegistry}.
	 * @return
	 * @throws ServiceException
	 *         If there is no {@link ServicesRegistry} associated to the {@link ResourceSet} owning the {@link Resource}.
	 */
	@Override
	public ServicesRegistry getServiceRegistry(Resource from) throws ServiceException {
		if(from == null) {
			throw new ServiceNotFoundException("Can't find the ResourceSet needed retrieve the ServiceRegistry.");
		}
		return ServiceUtilsForResourceSet.getInstance().getServiceRegistry(from.getResourceSet());
	}

}
