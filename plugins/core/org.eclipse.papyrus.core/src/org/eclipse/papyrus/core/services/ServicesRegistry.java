/**
 * 
 */
package org.eclipse.papyrus.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * <br>
 * In this implementation, services should be added to the registry before the call to createServices(). 
 * If a service is added after the call, it will not be started (except if it is a lazy service).
 * 
 * @author cedric dumoulin
 * 
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
		AbstractServiceEntry serviceEntry;
		if(serviceDescriptor.isStartAtStartup()) {
			serviceEntry = new ServiceEntry(serviceDescriptor, this);
		} else {
			serviceEntry = new LazyServiceEntry(serviceDescriptor, this);
		}
		services.put(serviceDescriptor.getKey(), serviceEntry);
	}

	/**
	 * Add a service.
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
		add(key, priority, serviceInstance, ServiceStartKind.STARTUP);
	}

	/**
	 * Add a service.
	 * The descriptor will be created.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(Object key, int priority, IService serviceInstance, ServiceStartKind startKind) {
		// Check if the service already exist.
		AbstractServiceEntry service = services.get(key);
		if(service != null) {
			if(service.getDescriptor().getPriority() > priority)
				return;
			else if(service.getDescriptor().getPriority() == priority)
				log.warning("Two services with same priority are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Create descriptor and add service.
		ServiceDescriptor descriptor = new ServiceDescriptor(key, serviceInstance.getClass().getName(), startKind, priority);

		if( startKind == ServiceStartKind.STARTUP)
			services.put(key, new ServiceEntry(descriptor, serviceInstance));
		else
			services.put(key, new LazyServiceEntry(descriptor, serviceInstance));
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
		add(key, priority, serviceInstance, ServiceStartKind.STARTUP);
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
	 * @param startKind
	 * 
	 */
	public void add(Object key, int priority, Object serviceInstance, ServiceStartKind startKind) {
		// Check if the service already exist.
		AbstractServiceEntry service = services.get(key);
		if(service != null) {
			if(service.getDescriptor().getPriority() > priority)
				return;
			else if(service.getDescriptor().getPriority() == priority)
				log.warning("Two services with same priority are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Create descriptor and add service.
		ServiceDescriptor descriptor = new ServiceDescriptor(key, serviceInstance.getClass().getName(), startKind, priority);

		if(startKind == ServiceStartKind.STARTUP)
			services.put(key, new PojoServiceEntry(descriptor, serviceInstance));
		else
			services.put(key, new LazyPojoServiceEntry(descriptor, serviceInstance));
			
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
	 * Get the requested service by its class (the service has to be registered by its class object).
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
	 * Return the state of the specified service.
	 * 
	 * @return
	 */
	public ServiceState serviceState(Object key) throws ServiceNotFoundException {
		AbstractServiceEntry service = services.get(key);
		if(service == null) {
			throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return service.getState();
	}

	/**
	 * Start the registry.
	 * Start all services marked as start = STARTUP are started.
	 * All services are first created, then initialized and finally started.
	 * If an error occur on a service during one of this step, the service is removed from
	 * the registry and and the error is logged.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	public void startRegistry() {

		createServices();
		initServices();
		startServices();
	}

	/**
	 * Dispose all services.
	 */
	public void disposeRegistry() {

		disposeServices();
	}

	/**
	 * Create all services marked as start = STARTUP.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void createServices() {
		// List of keys of service in error. 
		List<Object> errors = null;

		// Loop on all services
		for(Map.Entry<Object, AbstractServiceEntry> mapEntry : services.entrySet()) {
			AbstractServiceEntry serviceEntry = mapEntry.getValue();
			try {

				serviceEntry.createService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't create service '" + serviceEntry + "'", e);
				if(errors == null)
					errors = new ArrayList<Object>();
				errors.add(mapEntry.getKey());
			}
		}

		// Remove faulty services
		if(errors != null) {
			for(Object key : errors) {
				services.remove(key);
			}
		}

	}

	/**
	 * Init all services marked as start = STARTUP.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void initServices() {

		// List of keys of service in error. 
		List<Object> errors = null;

		// Loop on all services
		for(Map.Entry<Object, AbstractServiceEntry> mapEntry : services.entrySet()) {
			AbstractServiceEntry serviceEntry = mapEntry.getValue();
			try {

				serviceEntry.initService(this);
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't init service '" + serviceEntry + "'", e);
				if(errors == null)
					errors = new ArrayList<Object>();
				errors.add(mapEntry.getKey());
			}
		}

		// Remove faulty services
		if(errors != null) {
			for(Object key : errors) {
				services.remove(key);
			}
		}

	}

	/**
	 * Start all services marked as start = STARTUP.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void startServices() {
		// List of keys of service in error. 
		List<Object> errors = null;

		// Loop on all services
		for(Map.Entry<Object, AbstractServiceEntry> mapEntry : services.entrySet()) {
			AbstractServiceEntry serviceEntry = mapEntry.getValue();
			try {

				serviceEntry.startService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't start service '" + serviceEntry + "'", e);
				if(errors == null)
					errors = new ArrayList<Object>();
				errors.add(mapEntry.getKey());
			}
		}

		// Remove faulty services
		if(errors != null) {
			for(Object key : errors) {
				services.remove(key);
			}
		}

	}

	/**
	 * Dispose all started services.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void disposeServices() {
		// List of keys of service in error. 
		List<Object> errors = null;

		// Loop on all services
		for(Map.Entry<Object, AbstractServiceEntry> mapEntry : services.entrySet()) {
			AbstractServiceEntry serviceEntry = mapEntry.getValue();
			try {

				serviceEntry.disposeService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't dispose service '" + serviceEntry + "'", e);
				if(errors == null)
					errors = new ArrayList<Object>();
				errors.add(mapEntry.getKey());
			}
		}

		// Remove faulty services
		if(errors != null) {
			for(Object key : errors) {
				services.remove(key);
			}
		}

	}


}
