/*****************************************************************************
 * Copyright (c) CEA LIST.
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
package org.eclipse.papyrus.infra.core.services.internal;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * An ServiceEntry managing {@link IService} that should be started when the
 * registry is started.
 * 
 * @author cedric dumoulin
 * 
 */
public class StartStartupEntry extends ServiceStartupEntry {

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public StartStartupEntry(ServiceTypeEntry serviceEntry) {

		super(serviceEntry);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.internal.ServiceStartupEntry#getServiceInstance()
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Object getServiceInstance() throws ServiceException {
		// Return the instance
		return serviceEntry.getServiceInstance();
	}

	/**
	 * Do nothing
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void createService() throws ServiceException {
		serviceEntry.createService();
	}

	/**
	 * Do nothing
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		serviceEntry.initService(servicesRegistry);
	}

	/**
	 * Do nothing.
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {
		serviceEntry.startService();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.AbstractServiceEntry#disposeService()
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		serviceEntry.disposeService();
	}

}
