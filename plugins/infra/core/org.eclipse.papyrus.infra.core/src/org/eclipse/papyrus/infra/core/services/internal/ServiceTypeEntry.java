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

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.services.BadStateException;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceState;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.osgi.framework.Bundle;

/**
 * Base class for the different types of service entries (PoJo, Service,
 * ServiceFactory, ...).
 * 
 * @author cedric dumoulin
 */
public abstract class ServiceTypeEntry {

	/**
	 * Current state of the service.
	 */
	protected ServiceState state = ServiceState.registered;

	/**
	 * Descriptor of the service associated to this entry.
	 */
	protected ServiceDescriptor serviceDescriptor;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ServiceTypeEntry(ServiceDescriptor serviceDescriptor) {
		this.serviceDescriptor = serviceDescriptor;
	}

	/**
	 * Change the state of the service.
	 * 
	 * @param newState
	 */
	protected void setState(ServiceState newState) {
		state = newState;
	}

	/**
	 * @return the state
	 */
	public ServiceState getState() {
		return state;
	}

	/**
	 * Check if the current state is the proposed state. Throws an exception if
	 * the state is different.
	 * 
	 * @param expectedState
	 * @throws BadStateException
	 */
	protected void checkState(ServiceState expectedState) throws BadStateException {
		if(expectedState != state) {
			throw new BadStateException(expectedState, state, serviceDescriptor);
		}
	}

	/**
	 * Get the descriptor of the service associated to this entry.
	 * 
	 * @return
	 */
	public ServiceDescriptor getDescriptor() {
		return serviceDescriptor;
	}

	/**
	 * Instanciate the service as specified in serviceClassname.
	 * 
	 * @return the created service.
	 * @throws ServiceException
	 */
	protected Object instanciateService() throws ServiceException {

		// Load the Class of the service
		String serviceClassname = serviceDescriptor.getServiceClassname();
		Class<?> classname = loadClass();

		// Try to get the one arg constructor.
		// This require the ServiceRegistry. Old stuff, not more used.
		// try {
		// Constructor<?> constructor =
		// classname.getConstructor(ServicesRegistry.class);
		// return constructor.newInstance(registry);
		// } catch (SecurityException e) {
		// // Do nothing, try next constructor
		// } catch (NoSuchMethodException e) {
		// // Do nothing, try next constructor
		// } catch (IllegalArgumentException e) {
		// throw new ServiceException("Can't instanciate '" + serviceClassname +
		// "' with args ServicesRegistry.", e);
		// } catch (InstantiationException e) {
		// throw new ServiceException("Can't instanciate '" + serviceClassname +
		// "' with args ServicesRegistry.", e);
		// } catch (IllegalAccessException e) {
		// throw new ServiceException("Can't instanciate '" + serviceClassname +
		// "' with args ServicesRegistry.", e);
		// } catch (InvocationTargetException e) {
		// throw new ServiceException("Can't instanciate '" + serviceClassname +
		// "' with args ServicesRegistry.", e);
		// }

		// Try with zero arg constructor.
		try {
			return classname.newInstance();
		} catch (SecurityException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (IllegalArgumentException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (InstantiationException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (IllegalAccessException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Load the Class object. Try from current ClassLoader, then try using the
	 * plugin referenced in the serviceDescriptor.PluginId
	 * 
	 * @return
	 * @throws ServiceException
	 */
	private Class<?> loadClass() throws ServiceException {
		String serviceClassname = serviceDescriptor.getServiceClassname();
		Class<?> serviceClass;
		try {
			serviceClass = Class.forName(serviceClassname);
		} catch (ClassNotFoundException e1) {
			// Try using bundle
			try {
				String bundleID = serviceDescriptor.getClassBundleID();
				Bundle bundle = Platform.getBundle(bundleID);
				serviceClass = bundle.loadClass(serviceClassname);
			} catch (ClassNotFoundException e2) {
				throw new ServiceException("Can't find class for the name '" + serviceClassname + "'.", e2); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return serviceClass;
	}

	/**
	 * Return true if the service is started. Return false otherwise.
	 * 
	 * @return
	 */
	public boolean isStarted() {
		return state == ServiceState.started;
	}

	/**
	 * Get the service instance.
	 * 
	 * @return
	 * @throws ServiceException
	 */
	abstract public Object getServiceInstance() throws ServiceException;

	/**
	 * Create the associated service if not a Lazy Service.
	 * 
	 * @throws ServiceException
	 */
	abstract public void createService() throws ServiceException;

	/**
	 * Start the associated service if not a Lazy Service.
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
	 * Dispose associated service.
	 */
	abstract public void disposeService() throws ServiceException;

}
