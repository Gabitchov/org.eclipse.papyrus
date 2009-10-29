/**
 * 
 */
package org.eclipse.papyrus.core.services;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Abstract ServiceEntry. A ServiceEntry make the link between the Service instance, its descriptor,
 * the registry.
 * 
 * @author cedric dumoulin
 */
public abstract class AbstractServiceEntry {

	protected ServicesRegistry registry;

	/**
	 * Descriptor of the service associated to this entry.
	 */
	protected ServiceDescriptor serviceDescriptor;

	/**
	 * Startup the services. This method is called by the registry at the beginning in order to
	 * start services marked as "STARTUP".
	 * 
	 * @throws ServiceException
	 *             If service can't be started.
	 */
	public void startup() throws ServiceException {
		// Start service if needed
		if (serviceDescriptor.isStartAtStartup())
			startService();
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
	 * Create the service.
	 * 
	 * @return the created service.
	 * @throws ServiceException
	 */
	protected IService createService() throws ServiceException {

		Object service = instanciateService();
		// if(! (service instanceof IService) )
		// {
		// // Service is not of the right type. Provide a wrapper.
		// return new ServiceWrapper(service);
		// }

		// Service is of the right type
		return (IService) service;
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
		try {
			Constructor<?> constructor = classname.getConstructor(ServicesRegistry.class);
			return constructor.newInstance(registry);
		} catch (SecurityException e) {
			// Do nothing, try next constructor
		} catch (NoSuchMethodException e) {
			// Do nothing, try next constructor
		} catch (IllegalArgumentException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with args ServicesRegistry.", e);
		} catch (InstantiationException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with args ServicesRegistry.", e);
		} catch (IllegalAccessException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with args ServicesRegistry.", e);
		} catch (InvocationTargetException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with args ServicesRegistry.", e);
		}

		// Try with zero arg constructor.
		try {
			return classname.newInstance();
		} catch (SecurityException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e);
		} catch (IllegalArgumentException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e);
		} catch (InstantiationException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e);
		} catch (IllegalAccessException e) {
			throw new ServiceException("Can't instanciate '" + serviceClassname + "' with zero args.", e);
		}
	}

	/**
	 * Load the Class object. Try from current ClassLoader, then try using the plugin referenced in
	 * the serviceDescriptor.PluginId
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
				throw new ServiceException("Can't find class for the name '" + serviceClassname + "'.", e2);
			}
		}

		return serviceClass;
	}

	/**
	 * Dispose associated service
	 */
	public void disposeService() throws ServiceException {
	}

	abstract public Object getServiceInstance() throws ServiceException;

	abstract public boolean isStarted();

	public void startService() throws ServiceException {
	}

}
