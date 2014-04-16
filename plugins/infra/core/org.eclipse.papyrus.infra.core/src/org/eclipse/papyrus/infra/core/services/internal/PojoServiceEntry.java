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

import org.eclipse.papyrus.infra.core.services.BadStateException;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceState;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Entry for a service provided as POJO.
 * 
 * 
 * @author cedric dumoulin
 */
public class PojoServiceEntry extends ServiceTypeEntry {

	/** Instance of the service, if started. */
	private Object serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 */
	public PojoServiceEntry(ServiceDescriptor serviceDescriptor) {
		super(serviceDescriptor);
		setState(ServiceState.registered);
	}

	/**
	 * Create an entry for an already created service. Constructor.
	 * 
	 * @param descriptor
	 *        Descriptor of the service. Key and priority should be set.
	 * @param serviceInstance
	 *        The service Instance
	 */
	public PojoServiceEntry(ServiceDescriptor descriptor, Object serviceInstance) {
		super(descriptor);
		this.serviceInstance = serviceInstance;
		setState(ServiceState.registered);
	}

	/**
	 * Get the service instance.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If service can't be started.
	 */
	public Object getServiceInstance() throws ServiceException {

		if(serviceInstance == null)
			throw new BadStateException("Service is not created.", state, serviceDescriptor); //$NON-NLS-1$

		return serviceInstance;
	}

	/**
	 * Already created : do nothing.
	 * 
	 * @throws ServiceException
	 */
	public void createService() throws ServiceException {
		checkState(ServiceState.registered);
		// Exit if already created.
		if(serviceInstance != null) {
			setState(ServiceState.created);
			return;
		}

		// Create it
		try {
			// Create the instance
			serviceInstance = instanciateService();
		} catch (Exception e) {
			setState(ServiceState.error);
			throw new ServiceException(e);
		}
		setState(ServiceState.created);
	}

	/**
	 * Pojo : can't initialize the service. Do nothing.
	 * 
	 * @param servicesRegistry
	 *        The servicesRegistry containing this service.
	 * 
	 * @throws ServiceException
	 */
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		setState(ServiceState.initialized);
	}

	/**
	 * Already started : do nothing.
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
		setState(ServiceState.started);
	}

	/**
	 * Do nothing.
	 */
	public void disposeService() throws ServiceException {
		if(serviceInstance == null)
			return;

		serviceInstance = null;
		setState(ServiceState.disposed);
	}

}
