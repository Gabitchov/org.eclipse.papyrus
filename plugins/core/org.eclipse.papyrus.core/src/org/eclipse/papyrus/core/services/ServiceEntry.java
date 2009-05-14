/**
 * 
 */
package org.eclipse.papyrus.core.services;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;


/**
 * Entry of a Service in the ServiceRegistry.
 * This class provide methods to manage the Service life cycle.
 *  
 * @author dumoulin
 *
 */
public class ServiceEntry {

	/** Instance of the service, if started. */
	private IService serviceInstance;
	
	private ServicesRegistry registry;

	/**
	 * Descriptor of the service associated to this entry.
	 */
	private ServiceDescriptor serviceDescriptor;
	
	/**
	 * Constructor.
	 * @param serviceDescriptor
	 * @param registry
	 */
	public ServiceEntry(ServiceDescriptor serviceDescriptor, ServicesRegistry registry)  {
		this.serviceDescriptor = serviceDescriptor;
		this.registry = registry;
		
	}


	/**
	 * Create an entry for an already created service.
	 * Constructor.
	 * @param descriptor Descriptor of the service. Key and priority should be set.
	 * @param serviceInstance The service Instance
	 */
	public ServiceEntry(ServiceDescriptor descriptor, IService serviceInstance) {
		this.serviceDescriptor = descriptor;
		this.serviceInstance = serviceInstance;
	}
	
	/**
	 * This method is called by the registry at the beginning in order to start
	 * services marked as "STARTUP".
	 * @throws ServiceException If service can't be started.
	 */
	public void startup() throws ServiceException
	{
		// Start service if needed
		if(serviceDescriptor.isStartAtStartup())
			startService();		
	}
	
	/**
	 * Start the service manually.
	 * @throws ServiceException 
	 */
	protected void startService() throws ServiceException
	{
		// Create the instance if needed
		if(serviceInstance == null)
		{
		  serviceInstance = createService();
		}
		serviceInstance.startService();
	}
	
	/**
	 * Get the service instance.
	 * @return
	 * @throws ServiceException If service can't be started.
	 */
	public Object getServiceInstance() throws ServiceException {
		if(serviceInstance == null)
		{
			startService();
		}
		
       return serviceInstance;
	}


	/**
	 * Stop the service manually.
	 */
	public void stopService() {
		if(serviceInstance == null)
			return;
		
		serviceInstance.stopService();
	}

	/**
	 * Get the descriptor of the service associated to this entry.
	 * @return
	 */
	public ServiceDescriptor getDescriptor()
	{
		return serviceDescriptor;
	}
	
	/**
	 * Create the service.
	 * @return the created service.
	 * @throws ServiceException 
	 */
	private IService createService() throws ServiceException {
		
		Object service = instanciateService();
//		if(! (service instanceof IService) )
//		{
//			// Service is not of the right type. Provide a wrapper.
//			return new ServiceWrapper(service);
//		}
		
		// Service is of the right type
		return (IService)service;
	}
		
		/**
		 * Instanciate the service as specified in serviceClassname.
		 * 
		 * @return the created service.
		 * @throws ServiceException 
		 */
	private Object instanciateService() throws ServiceException {

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
	 * Load the Class object. Try from current ClassLoader, then try using the plugin referenced in the 
	 * serviceDescriptor.PluginId 
	 * @return
	 * @throws ServiceException 
	 */
	private Class<?> loadClass() throws ServiceException
	{
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
		 * @see java.lang.Object#toString()
		 * @return
		 * 
		 */
		@Override
		public String toString() {
			return "ServiceEntry [serviceDescriptor=" + serviceDescriptor.toString() + ", serviceInstance=" + serviceInstance + "]";
		}


		/**
		 * Return true if the service is instantiated. Return false otherwise.
		 * @return
		 */
		public boolean isStarted() {
			return serviceInstance != null;
		}


}
