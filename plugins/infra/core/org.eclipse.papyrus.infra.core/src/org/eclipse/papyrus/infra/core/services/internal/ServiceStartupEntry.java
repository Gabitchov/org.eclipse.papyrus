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

import java.util.Collection;
import java.util.List;

import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceState;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Base class for the different types of service startups (lazy, synchronized).
 * 
 * @author cedric dumoulin
 * 
 */
public abstract class ServiceStartupEntry {

	/**
	 * The ServiceEntry, according to its type.
	 */
	protected ServiceTypeEntry serviceEntry;

	/**
	 * Entries of Services required by this service.
	 */
	protected List<ServiceStartupEntry> requiredServices;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 */
	public ServiceStartupEntry(ServiceTypeEntry serviceEntry) {
		this.serviceEntry = serviceEntry;
	}

	/**
	 * Create the associated service if not a Lazy Service.
	 * 
	 * @throws ServiceException
	 */
	abstract public void createService() throws ServiceException;

	/**
	 * Init the associated service if not a Lazy Service.
	 * 
	 * @param servicesRegistry
	 *        The servicesRegistry containing this service.
	 * 
	 * @throws ServiceException
	 */
	abstract public void initService(ServicesRegistry servicesRegistry) throws ServiceException;

	/**
	 * Start the associated service if not a Lazy Service.
	 * 
	 * @throws ServiceException
	 */
	abstract public void startService() throws ServiceException;

	/**
	 * Get the service instance.
	 * 
	 * @return
	 * @throws ServiceException
	 */
	abstract public Object getServiceInstance() throws ServiceException;

	/**
	 * Dispose associated service.
	 */
	abstract public void disposeService() throws ServiceException;

	/**
	 * Return the list of the {@link ServiceStartupEntry} required by this
	 * service.
	 * 
	 * @return
	 */
	public Collection<ServiceStartupEntry> getRequiredServices() {

		throw new UnsupportedOperationException("Not yet implemented"); //$NON-NLS-1$
		// return requiredServices;
	}

	/**
	 * Get {@link ServiceDescriptor} associated to this entry.
	 * 
	 * @return
	 */
	public ServiceDescriptor getDescriptor() {
		return serviceEntry.getDescriptor();
	}

	/**
	 * @return the state of the service
	 */
	public ServiceState getState() {
		return serviceEntry.getState();
	}

	/**
	 * Return true if the service is started. Return false otherwise.
	 * 
	 * @return
	 */
	public boolean isStarted() {
		return serviceEntry.isStarted();
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return super.toString() + ": key=" + getDescriptor().getKey(); //$NON-NLS-1$
	}

}
