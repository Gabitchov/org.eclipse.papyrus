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
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceState;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Entry of a Service implementing {@link IService}. This class provide methods
 * to manage the Service life cycle.
 * 
 * @author cedric dumoulin
 * 
 */
public class ServiceEntry extends ServiceTypeEntry {

	/** Instance of the service, if started. */
	private IService serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public ServiceEntry(ServiceDescriptor serviceDescriptor) {
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
	public ServiceEntry(ServiceDescriptor descriptor, IService serviceInstance) {
		super(descriptor);
		this.serviceInstance = serviceInstance;
		setState(ServiceState.registered);
	}

	/**
	 * Get the service instance, even if it is not started. The service should
	 * be created.
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
	 * @see java.lang.Object#toString()
	 * @return
	 * 
	 */
	@Override
	public String toString() {
		return "ServiceEntry [serviceDescriptor=" + serviceDescriptor.toString() + ", serviceInstance=" + serviceInstance + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Create the associated service if not a Lazy Service.
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
			serviceInstance = (IService)instanciateService();
		} catch (Exception e) {
			setState(ServiceState.error);
			throw new ServiceException(e);
		}
		setState(ServiceState.created);
	}

	/**
	 * Start the associated service if not a Lazy Service.
	 * 
	 * @param servicesRegistry
	 *        The servicesRegistry containing this service.
	 * 
	 * @throws ServiceException
	 */
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		checkState(ServiceState.created);
		try {
			serviceInstance.init(servicesRegistry);
		} catch (ServiceException e) {
			setState(ServiceState.error);
			throw e;
		} catch (Exception e) {
			setState(ServiceState.error);
			throw new ServiceException(e);
		}

		setState(ServiceState.initialized);
	}

	/**
	 * Start the associated service if not a Lazy Service.
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {

		checkState(ServiceState.initialized);
		setState(ServiceState.starting);

		try {
			serviceInstance.startService();
		} catch (ServiceException e) {
			setState(ServiceState.error);
			throw e;
		} catch (Exception e) {
			setState(ServiceState.error);
			throw new ServiceException(e);
		}

		setState(ServiceState.started);
	}

	/**
	 * Dispose the service.
	 */
	public void disposeService() throws ServiceException {
		if(serviceInstance == null)
			return;

		serviceInstance.disposeService();
		serviceInstance = null;
		setState(ServiceState.disposed);
	}

}
