/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.core.lifecycleevents;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.resource.ModelSet;


/**
 * A service factory to create the {@link ILifeCycleEventsProvider} service.
 * This provide a nickname for {@link SaveAndDirtyService} service.
 * This serviceFactory depends on {@link SaveAndDirtyService} service.
 * 
 * @author cedric dumoulin
 * 
 */
public class LifeCycleEventsProviderServiceFactory implements IServiceFactory {

	/**
	 * The sashModelMangr.
	 */
	private SaveAndDirtyService saveAndDirtyService;

	/**
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// Get required services
		// This rely on the real implementation.
		saveAndDirtyService = (SaveAndDirtyService)servicesRegistry.getService(ISaveAndDirtyService.class);

	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IServiceFactory#createServiceInstance()
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Object createServiceInstance() throws ServiceException {
		return saveAndDirtyService;
	}

}
