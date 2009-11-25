/**
 * 
 */
package org.eclipse.papyrus.core.services;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A registry of services.
 * This registry allows to get a service by its identifier. The identifier is generally
 * the classname of the service.
 * Services can be added using the Eclipse extension mechanism.
 * A Service is a class providing operations. A service is shared across the editors.
 * 
 * @author dumoulin
 * 
 */
public class ServicesRegistry {

	/** Log object */
	protected Logger log = Logger.getLogger(getClass().getName());

	/**
	 * Map of existing services.
	 */
	private Map<Object, AbstractServiceEntry> services;


	/**
	 * Constructor.
	 */
	public ServicesRegistry() {
		services = new HashMap<Object, AbstractServiceEntry>();
	}

	/**
	 * Add a service by its ServiceDescriptor.
	 * 
	 * @param serviceDescriptor
	 *        Descriptor describing the service.
	 * @throws ServiceException
	 *         If an error occurs while initializing service.
	 */
	public void add(ServiceDescriptor serviceDescriptor) {
		// Check if the service already exist.
		AbstractServiceEntry service = services.get(serviceDescriptor.getKey());
		if(service != null) {
			if(service.getDescriptor().getPriority() > serviceDescriptor.getPriority())
				return;
			else if(service.getDescriptor().getPriority() == serviceDescriptor.getPriority())
				log.warning("Two services with same priority are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Add the service
		services.put(serviceDescriptor.getKey(), new ServiceEntry(serviceDescriptor, this));
	}

	/**
	 * Add a already instanciated service.
	 * The descriptor will be created.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(Object key, int priority, IService serviceInstance) {
		// Check if the service already exist.
		AbstractServiceEntry service = services.get(key);
		if(service != null) {
			if(service.getDescriptor().getPriority() > priority)
				return;
			else if(service.getDescriptor().getPriority() == priority)
				log.warning("Two services with same priority are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Create descriptor and add service.
		ServiceDescriptor descriptor = new ServiceDescriptor(key, serviceInstance.getClass().getName(), ServiceStartKind.STARTUP, priority);
		services.put(key, new ServiceEntry(descriptor, serviceInstance));

	}

	/**
	 * Add an already instanciated pojo (Plain Old Java Object) as Service.
	 * The descriptor will be created.
	 * No life cycle methods are called on the service.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(Object key, int priority, Object serviceInstance) {
		// Check if the service already exist.
		AbstractServiceEntry service = services.get(key);
		if(service != null) {
			if(service.getDescriptor().getPriority() > priority)
				return;
			else if(service.getDescriptor().getPriority() == priority)
				log.warning("Two services with same priority are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Create descriptor and add service.
		ServiceDescriptor descriptor = new ServiceDescriptor(key, serviceInstance.getClass().getName(), ServiceStartKind.STARTUP, priority);
		services.put(key, new PojoServiceEntry(descriptor, serviceInstance));

	}

	/**
	 * Remove the specified service from the registry.
	 * 
	 * @param key
	 */
	public void remove(ServiceDescriptor serviceDescriptor) throws ServiceException {
		remove(serviceDescriptor.getKey());
	}

	/**
	 * Remove the specified service from the registry.
	 * 
	 * @param key
	 */
	public void remove(Object key) throws ServiceException {
		AbstractServiceEntry service = services.remove(key);
		if(service == null) {
			return;
		}

		// Stop the service
		service.disposeService();
	}

	/**
	 * Get the requested service by its key.
	 * The key is usually the classname of the service.
	 * 
	 * @param serviceClass
	 * @return
	 * @throws ServiceException
	 *         If servive can't be started
	 */
	public Object getService(Object key) throws ServiceException {
		AbstractServiceEntry service = services.get(key);
		if(service == null) {
			throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return service.getServiceInstance();
	}

	/**
	 * Get the requested service by its class (the servce has to be registered by its class object).
	 * 
	 * @param key
	 *        The service class.
	 * @return The service.
	 * @throws ServiceException
	 *         If service can't be started
	 */
	@SuppressWarnings("unchecked")
	public <S> S getService(Class<S> key) throws ServiceException {
		AbstractServiceEntry service = services.get(key);
		if(service == null) {
			throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return (S)service.getServiceInstance();
	}

	/**
	 * Return true if the service is instantiated. Return false otherwise.
	 * 
	 * @return
	 */
	public boolean isStarted(Object key) throws ServiceNotFoundException {
		AbstractServiceEntry service = services.get(key);
		if(service == null) {
			throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return service.isStarted();
	}

	/**
	 * Start the registry.
	 * Start all services marked as start = STARTUP are started.
	 * Then, method start() is called on all IService.
	 * Start services marked as start = STARTUP.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	public void startRegistry() {
		for(AbstractServiceEntry serviceEntry : services.values()) {
			try {
				serviceEntry.startup();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't init service '" + serviceEntry + "'", e);
			}
		}
	}

	/**
	 * Start services marked as start = STARTUP.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void startServices() {
		for(AbstractServiceEntry serviceEntry : services.values()) {
			try {
				serviceEntry.startService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't start service '" + serviceEntry + "'", e);
			}
		}
	}

	/**
	 * Dispose all services.
	 */
	public void disposeService() {
		for(AbstractServiceEntry serviceDesc : services.values()) {
			try {
				serviceDesc.disposeService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't dispose service '" + serviceDesc + "'", e);
			}
		}
	}

}
