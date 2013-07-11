/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.papyrus.infra.core.serviceregistry.ServiceDescriptor.ServiceTypeKind;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.AliasServiceEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.LazyStartupEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.PojoServiceEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceFactoryEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceStartupEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceTypeEntry;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.StartStartupEntry;

/**
 * A registry of services. This registry allows to get a service by its
 * identifier. The identifier is generally the classname of the service.
 * Services can be added using the Eclipse extension mechanism (if you use {@link ExtensionServicesRegistry}). <br>
 * A Service is a class providing operations. The ServiceRegistry is used to
 * share objects (i.e. services) between nested editors and also the core main
 * editor.
 * 
 * <br>
 * In this implementation, services should be added to the registry before the
 * call to createServices(). If a service is added after the call, it will not
 * be started (except if it is a lazy service). <br>
 * A typical usage is:
 * 
 * <pre>
 * <code>
 *   ServicesRegistry serviceRegistry = new ServiceRegistry();
 *   // Add your services
 *   serviceRegistry.add( ...);
 *   serviceRegistry.add( ...);
 *   
 *   // start the services
 *   serviceRegistry.startRegistry();
 *   
 *   // Retrieve a service
 *   myService = serviceRegistry.getService( serviceKey );
 * </code>
 * </pre>
 * 
 * It is possible to register new services after the serviceRegistry has been
 * started. In this case, you need to start them explicitly if they are of type
 * ServiceStartKind.STARTUP.
 * 
 * <pre>
 * <code>
 *   // Add your new services
 *   serviceRegistry.add( key1, ...);
 *   serviceRegistry.add( key2, ...);
 *   
 *   // start the new services
 *   serviceRegistry.startRegistry(key1, key2);
 * </code>
 * </pre>
 * 
 * <ul>
 * <li></li>
 * <li></li>
 * </ul>
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
	// private Map<Object, AbstractServiceEntry> services;

	/**
	 * A Map of services added to the register (thow the addXxx() methods), but
	 * not yet registered. They will be registered after a call to startXxx().
	 */
	private Map<String, ServiceStartupEntry> addedServices = new HashMap<String, ServiceStartupEntry>();

	/**
	 * Map of services registered with a name.
	 */
	private Map<String, ServiceStartupEntry> namedServices = new HashMap<String, ServiceStartupEntry>();

	/**
	 * Map of services registered without a name (anonymous). Such services
	 * can't be retrieved.
	 */
	private List<ServiceStartupEntry> anonymousServices = new ArrayList<ServiceStartupEntry>();

	/**
	 * List of parents used as fallback if the service is not found in this registry.
	 */
	private List<ServicesRegistry> parents = new ArrayList<ServicesRegistry>();
	
	/**
	 * Constructor.
	 */
	public ServicesRegistry() {
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
		ServiceStartupEntry service = addedServices.get(serviceDescriptor.getKey());
		if(service != null) {
			if(service.getDescriptor().getPriority() > serviceDescriptor.getPriority())
				return;
			else if(service.getDescriptor().getPriority() == serviceDescriptor.getPriority()) {
				log.warning("Two services with same priority (" + serviceDescriptor.getPriority() + ") are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only. (bundles: " + service.getDescriptor().getClassBundleID() + ", " + serviceDescriptor.getClassBundleID() + ")");
			}
		}

		// Compute the service type entry
		ServiceTypeEntry serviceTypeEntry;
		ServiceTypeKind typeKind = serviceDescriptor.getServiceTypeKind();
		switch( typeKind) {
		case service:
			serviceTypeEntry = new ServiceEntry(serviceDescriptor);
			break;
		case serviceFactory:
			serviceTypeEntry = new ServiceFactoryEntry(serviceDescriptor);
			break;
		case pojo:
			serviceTypeEntry = new PojoServiceEntry(serviceDescriptor);
			break;
		case alias:
			serviceTypeEntry = new AliasServiceEntry(serviceDescriptor);
			break;			
		default:
			// Add as pojo
			// Should better throw an exception. (MalformedDescriptor ?)
			serviceTypeEntry = new PojoServiceEntry(serviceDescriptor);
		}

		// Create the entry
		ServiceStartupEntry serviceEntry;
		switch(serviceDescriptor.getServiceStartKind()) {
		case STARTUP:
			serviceEntry = new StartStartupEntry(serviceTypeEntry);
			break;
		case LAZY:
			serviceEntry = new LazyStartupEntry(serviceTypeEntry, this);
			break;
		default:
			// Add as LAZY
			// Should better throw an exception. (MalformedDescriptor ?)
			serviceEntry = new LazyStartupEntry(serviceTypeEntry, this);
		}

		// Add the entry
		addedServices.put(serviceDescriptor.getKey(), serviceEntry);
	}

	/**
	 * Add a service. The descriptor will be created.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(String key, int priority, IService serviceInstance) {
		add(key, priority, serviceInstance, ServiceStartKind.STARTUP);
	}

	/**
	 * Add a service. The descriptor will be created.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(Class<?> key, int priority, IService serviceInstance) {
		add(key.getName(), priority, serviceInstance, ServiceStartKind.STARTUP);
	}

	/**
	 * Add a service. The descriptor will be created.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(String key, int priority, IService serviceInstance, ServiceStartKind startKind) {
		// Check if the service already exist.
		ServiceStartupEntry service = addedServices.get(key);
		if(service != null) {
			if(service.getDescriptor().getPriority() > priority)
				return;
			else if(service.getDescriptor().getPriority() == priority)
				log.warning("Two services with same priority (" + priority + ") are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Create descriptor and add service.
		ServiceDescriptor descriptor = new ServiceDescriptor(key, serviceInstance.getClass().getName(), startKind, priority);

		if(startKind == ServiceStartKind.STARTUP)
			addedServices.put(key, new StartStartupEntry(new ServiceEntry(descriptor, serviceInstance)));
		else
			addedServices.put(key, new LazyStartupEntry(new ServiceEntry(descriptor, serviceInstance), this));
	}

	/**
	 * Add a service. The descriptor will be created.
	 * 
	 * @param key
	 *        Service key Class used as key. The classname is used as key.
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(Class<?> key, int priority, IService serviceInstance, ServiceStartKind startKind) {

		add(key.getName(), priority, serviceInstance, startKind);
	}

	/**
	 * Add an already instanciated pojo (Plain Old Java Object) as Service. The
	 * descriptor will be created. No life cycle methods are called on the
	 * service.
	 * 
	 * @param key
	 *        Service key
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 */
	public void add(Class<?> key, int priority, Object serviceInstance) {
		add(key, priority, serviceInstance, ServiceStartKind.STARTUP);
	}

	/**
	 * Add an already instanciated pojo (Plain Old Java Object) as Service. The
	 * descriptor will be created. No life cycle methods are called on the
	 * service.
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
	public void add(String key, int priority, Object serviceInstance, ServiceStartKind startKind) {
		// Check if the service already exist.
		ServiceStartupEntry service = addedServices.get(key);
		if(service != null) {
			if(service.getDescriptor().getPriority() > priority)
				return;
			else if(service.getDescriptor().getPriority() == priority)
				log.warning("Two services with same priority (" + priority + ") are declared under key '" + service.getDescriptor().getKey() + "'. Keep the first encountered only.");
		}

		// Create descriptor and add service.
		ServiceDescriptor descriptor = new ServiceDescriptor(key, serviceInstance.getClass().getName(), startKind, priority);

		if(startKind == ServiceStartKind.STARTUP)
			addedServices.put(key, new StartStartupEntry(new PojoServiceEntry(descriptor, serviceInstance)));
		else
			addedServices.put(key, new LazyStartupEntry(new PojoServiceEntry(descriptor, serviceInstance), this));

	}

	/**
	 * Add an already instanciated pojo (Plain Old Java Object) as Service. The
	 * descriptor will be created. No life cycle methods are called on the
	 * service.
	 * 
	 * @param key
	 *        Service key Class used as key. The classname is used as key.
	 * @param priority
	 *        service priority
	 * @param serviceInstance
	 *        The instance of the service
	 * @param startKind
	 * 
	 */
	public void add(Class<?> key, int priority, Object serviceInstance, ServiceStartKind startKind) {

		add(key.getName(), priority, serviceInstance, startKind);
	}

	/**
	 * Remove the specified Registry as parent of this registry.
	 * . 
	 * @param parentRegistry
	 */
	public void addParentRegistry(ServicesRegistry parentRegistry) {
		
		if( parentRegistry == null) {
			return;
		}
		parents.add(parentRegistry);
	}
	
	/**
	 * 
	 * @param parentRegistry
	 */
	public void removeParentRegistry(ServicesRegistry parentRegistry) {
		
		if( parentRegistry == null) {
			return;
		}
		parents.remove(parentRegistry);
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
		ServiceStartupEntry service = namedServices.remove(key);
		if(service == null) {
			return;
		}

		// Stop the service
		service.disposeService();
	}

	/**
	 * Get the requested service by its key. The key is usually the classname of
	 * the service.
	 * 
	 * @param serviceClass
	 * @return
	 * @throws ServiceException
	 *         If servive can't be started
	 */
	public Object getService(Object key) throws ServiceException {
		ServiceStartupEntry serviceEntry = namedServices.get(key);
		if(serviceEntry == null) {
			// Check if we can find it in parents
			Object service = getServiceFromParents(key);
			if(service != null) {
				// Found in parent, return it
				return service;
			}

			// Not found in parents. Throw an exception
			// throw an appropriate exception (If added, say it).
			serviceEntry = addedServices.get(key);
			if(serviceEntry != null)
				throw new BadStateException("Registry should be started before.", serviceEntry.getState(), serviceEntry.getDescriptor());
			else
				throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return serviceEntry.getServiceInstance();
	}

	/**
	 * Get the requested service by its class (the service has to be registered
	 * by its class object).
	 * 
	 * @param key
	 *        The service class.
	 * @return The service.
	 * @throws ServiceException
	 *         If service can't be started
	 */
	@SuppressWarnings("unchecked")
	public <S> S getService(Class<S> key) throws ServiceException {

		String realKey = key.getName();
		ServiceStartupEntry serviceEntry = namedServices.get(realKey);

		// Lookup in parents if not found
		if( serviceEntry == null) {
			
			// Check if we can find it in parents
			S service = (S)getServiceFromParents(realKey);
			if(service != null) {
				// Found in parent, return it
				return service;
			}

			// Not found in parents. Throw an exception
			// throw an appropriate exception (If added, say it).
			serviceEntry = addedServices.get(realKey);
			if(serviceEntry != null)
				throw new BadStateException("Registry should be started before.", serviceEntry.getState(), serviceEntry.getDescriptor());
			else
				throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		// Service found, return it.
		return (S)serviceEntry.getServiceInstance();
	}

	/**
	 * Get the requested service by its class (the service has to be registered
	 * by its class object).
	 * 
	 * @param key
	 *        The service class.
	 * @return The service.
	 * @throws ServiceException
	 *         If service can't be started
	 */
	private Object getServiceFromParents(Object key) throws ServiceException {
	
		Object foundService;
		
		for( ServicesRegistry parent : parents) {
			foundService = parent.getServiceUnchecked(key);
			// Check if we have found the service
			if( foundService != null) {
				// Found, return it
				return foundService;
			}
		}
		// Not found
		return null;
	}
	
	/**
	 * Get the requested service by its key. The key is usually the classname of
	 * the service.
	 * Return the service, or null if not found.
	 * This is for internal use.
	 * 
	 * @param serviceClass
	 * @return The service, or null if not found.
	 * @throws ServiceException
	 *         If servive can't be started
	 */
	protected Object getServiceUnchecked(Object key) throws ServiceException {
		ServiceStartupEntry service = namedServices.get(key);
		if(service == null) {
			return null;
		}

		return service.getServiceInstance();
	}

	/**
	 * Try to get the {@link ServiceStartupEntry} of the specified service.
	 * Search in local namedServices.
	 * Also lookup in parents. Return null if not found.
	 * The returned entry should not be modified by caller.
	 * 
	 * @param key
	 * @return The requested entry, or null if not found.
	 */
	protected ServiceStartupEntry getServiceStartupEntry( Object key ) {
		
		return getServiceStartupEntry(key, true);
	}
	
	/**
	 * Try to get the {@link ServiceStartupEntry} of the specified service.
	 * Search in local namedServices.
	 * Also lookup in parents. Return null if not found.
	 * The returned entry should not be modified by caller.
	 * 
	 * @param key
	 * @param searchInParent True if we should search in parent, false if search take place in this registry only.
	 * @return The requested entry, or null if not found.
	 */
	protected ServiceStartupEntry getServiceStartupEntry( Object key, boolean searchInParent ) {
		
		ServiceStartupEntry service = namedServices.get(key);
		if( service != null) {
			return service;
		}

		// Check in new services
		service = addedServices.get(key);
		if( service != null) {
			return service;
		}
		
		if( searchInParent ) {
			// Lookup in parents
			for(ServicesRegistry registry : parents) {
				service = registry.getServiceStartupEntry(key);
				if( service != null) {
					return service;
				}	
			}	
		}

		// Not found
		return null;
	}
	
	/**
	 * Return true if the service is instantiated. Return false otherwise.
	 * 
	 * @return
	 */
	public boolean isStarted(Object key) throws ServiceNotFoundException {
		return isStarted(key, true);
	}

	/**
	 * Return true if the service is instantiated. Return false otherwise.
	 * 
	 * @return
	 */
	public boolean isStarted(Object key, boolean searchInParents) throws ServiceNotFoundException {
		ServiceStartupEntry service = getServiceStartupEntry(key, searchInParents);
		if(service == null) {
			throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return service.isStarted();
	}

	/**
	 * Return true if the service is instantiated. Return false otherwise.
	 * The service type is converted to its name, then the method is performed.
	 * @see #isStarted(Class)
	 * 
	 * @return
	 */
	public boolean isStarted(Class<?> serviceType) throws ServiceNotFoundException {
		return isStarted(serviceType.getName(), true);
	}

	/**
	 * Return true if the service is instantiated. Return false otherwise.
	 * The service type is converted to its name, then the method is performed.
	 * @see #isStarted(Class)
	 * 
	 * @return
	 */
	public boolean isStarted(Class<?> serviceType, boolean searchInParents) throws ServiceNotFoundException {
		return isStarted(serviceType.getName(), searchInParents);
	}

	/**
	 * Return the state of the specified service.
	 * 
	 * @return
	 */
	public ServiceState serviceState(Object key) throws ServiceNotFoundException {
		return serviceState(key, true);
	}

	/**
	 * Return the state of the specified service.
	 * @param key
	 * @param searchInParents
	 * @return
	 * @throws ServiceNotFoundException
	 */
	public ServiceState serviceState(Object key, boolean searchInParents ) throws ServiceNotFoundException {
		ServiceStartupEntry service = getServiceStartupEntry(key, searchInParents);
		if(service == null) {
			throw new ServiceNotFoundException("No service registered under '" + key + "'");
		}

		return service.getState();
	}

	/**
	 * Return the state of the specified service.
	 * 
	 * @return
	 */
	public ServiceState serviceState(Class<?> serviceType) throws ServiceNotFoundException {
		return serviceState(serviceType.getName(), true);
	}

	/**
	 * Return the state of the specified service.
	 * 
	 * @return
	 */
	public ServiceState serviceState(Class<?> serviceType, boolean searchInParents) throws ServiceNotFoundException {
		return serviceState(serviceType.getName(), searchInParents);
	}

	/**
	 * Start services newly added.
	 * Start all services marked as start = STARTUP. 
	 * All services are first created, then initialized and finally
	 * started. If an error occur on a service during one of this step, the
	 * service is removed from the registry and and the error is logged.

	 * @throws ServiceMultiException
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 * 
	 */
	public void startNewServices() throws ServiceMultiException {
		// Build the lookup maps
		LookupMap localSpace = new LookupMap(addedServices, namedServices);
		// search space including parents
		LookupMap fullSpace = new LookupMap(addedServices, namedServices, parents);

		// Check if all dependencies exist.
		checkDependencies(addedServices.values(), fullSpace);

		// Get all roots : LAZY and START
		Collection<ServiceStartupEntry> roots = getServiceRoots(addedServices.values(), localSpace);
		// showServices(" Roots:", roots);
		// Detect cycles
		checkCycle(roots, localSpace);
		
		// Order services in the order we should start them.
		// Lazy services are taken into account, as they can be in a chain of start.
		List<ServiceStartupEntry> toStart = buildTopologicalListOfServicesToStart(roots, localSpace);
		
		// Retain only services with startupkind == START
		// 
		roots = retainsToStartServices(roots);

		if(Activator.log.isDebugEnabled()) {
			showServices(" Services to start:", toStart);
		}

		// Create an object to collect errors if any.
		ServiceMultiException errors = new ServiceMultiException();

		createServices(toStart, errors);
		// Register all new services : lazy and start
		registerServices(addedServices.values());
		initServices(toStart, errors);
		startServices(toStart, errors);

		// Report errors if any
		if(errors.getExceptions().size() > 0)
			throw errors;

		
	}

	/**
	 * Start the registry. Start all services marked as start = STARTUP are
	 * started. All services are first created, then initialized and finally
	 * started. If an error occur on a service during one of this step, the
	 * service is removed from the registry and and the error is logged.
	 * 
	 * @throws ServiceMultiException
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 *         
	 * @deprecated Use {@link #startNewServices()}        
	 */
	protected void startRegistry() throws ServiceMultiException {

		startNewServices();
	}

	/**
	 * Start the specified services, and their required services. The specifies
	 * services should be in the addServices or already registered. Start all
	 * services marked as start = STARTUP . All eligible services are first
	 * created, then initialized and finally started. If an error occur on a
	 * service during one of this step, the service is removed from the registry
	 * and and the error is logged.
	 * 
	 * @param serviceKeys
	 *        Keys of services to start.
	 * @throws ServiceMultiException
	 * @throws ServiceNotFoundException
	 *         If a service can't be retrieved by its key.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	public void startServices(List<String> serviceKeys) throws ServiceMultiException, ServiceNotFoundException {

		// Build the lookup maps
		LookupMap map = new LookupMap(addedServices, namedServices);

		// Get the services
		List<ServiceStartupEntry> services = keysToServices(serviceKeys, map);

		// Start them
		startServices(services, map);
	}

	/**
	 * Same as {@link #startServices(List)}, but with an array as input.
	 * 
	 * @see #startServices(List)
	 * 
	 * @param serviceKeys
	 *        Keys of services to start.
	 * @throws ServiceMultiException
	 * @throws ServiceNotFoundException
	 *         If a service can't be retrieved by its key.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	public void startServices(String... serviceKeys) throws ServiceMultiException, ServiceNotFoundException {

		List<String> serviceKeysList = Arrays.asList(serviceKeys);
		startServices(serviceKeysList);
	}

	/**
	 * Start the specified services, and their required services. The specifies
	 * services should be in the addServices or already registered. Start all
	 * services marked as start = STARTUP . All eligible services are first
	 * created, then initialized and finally started. If an error occur on a
	 * service during one of this step, the service is removed from the registry
	 * and and the error is logged.
	 * 
	 * @param serviceKeys
	 *        Keys of services to start. Keys will be translated to the
	 *        classname.
	 * @throws ServiceMultiException
	 * @throws ServiceNotFoundException
	 *         If a service can't be retrieved by its key.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	public void startServicesByClassKeys(List<Class<?>> serviceKeys) throws ServiceMultiException, ServiceNotFoundException {

		// Build the lookup maps
		LookupMap map = new LookupMap(addedServices, namedServices);

		// Get the services
		List<ServiceStartupEntry> services = classKeysToServices(serviceKeys, map);

		// Start them
		startServices(services, map);
	}

	/**
	 * Same as {@link #startServicesByClassKeys(List)}, but with an array as
	 * input.
	 * 
	 * @see #startServices(List)
	 * 
	 * @param serviceKeys
	 *        Keys of services to start.
	 * @throws ServiceMultiException
	 * @throws ServiceNotFoundException
	 *         If a service can't be retrieved by its key.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	public void startServicesByClassKeys(Class<?>... serviceKeys) throws ServiceMultiException, ServiceNotFoundException {

		List<Class<?>> serviceKeysList = Arrays.asList(serviceKeys);
		startServicesByClassKeys(serviceKeysList);
	}

	/**
	 * Start the specified services, and their required services. The specifies
	 * services should be in the specified map. The map is also used to resolves
	 * dependencies. Start all services marked as start = STARTUP . All eligible
	 * services are first created, then initialized and finally started. If an
	 * error occur on a service during one of this step, the service is removed
	 * from the registry and and the error is logged.
	 * 
	 * @param services
	 *        Services to start
	 * @param map
	 *        a table of (key, service) used to get a service by its key.
	 * @throws ServiceMultiException
	 *         If a service can't be started.
	 */
	private void startServices(List<ServiceStartupEntry> services, LookupMap map) throws ServiceMultiException {
		// Check if all dependencies exist.
		checkDependencies(services, map);

		// Get all roots : LAZY and START
		Collection<ServiceStartupEntry> roots = getServiceRoots(services, map);
		if(Activator.log.isDebugEnabled()) {
			showServices(" Roots:", roots);
		}
		// Detect cycles
		checkCycle(roots, map);
		// Retain only services with startupkind == START and state ==
		// REGISTERED
		roots = retainsToStartServices(roots);
		//
		List<ServiceStartupEntry> toStart = buildTopologicalListOfServicesToStart(roots, map);

		// Remove already started services
		toStart = retainsToStartServices(toStart);

		// if( log.isLoggable(Level.FINE))
		// {
		showServices(" Services to start:", toStart);
		// }

		// Create an object to collect errors if any.
		ServiceMultiException errors = new ServiceMultiException();

		createServices(toStart, errors);
		// Register all started services
		registerServices(toStart);
		initServices(toStart, errors);
		startServices(toStart, errors);

		// Report errors if any
		if(errors.getExceptions().size() > 0)
			throw errors;
	}

	/**
	 * Return a list of services from a list of services keys.
	 * 
	 * @param serviceKeys
	 * @param map
	 * @return
	 * @throws ServiceNotFoundException
	 *         If a service can't be retrieved by its key.
	 */
	private List<ServiceStartupEntry> keysToServices(List<String> serviceKeys, LookupMap map) throws ServiceNotFoundException {

		List<ServiceStartupEntry> result = new ArrayList<ServiceStartupEntry>(serviceKeys.size());

		for(String key : serviceKeys) {
			result.add(map.getChecked(key));
		}
		return result;
	}

	/**
	 * Return a list of services from a list of services keys.
	 * 
	 * @param serviceKeys
	 * @param map
	 * @return
	 * @throws ServiceNotFoundException
	 *         If a service can't be retrieved by its key.
	 */
	private List<ServiceStartupEntry> classKeysToServices(List<Class<?>> serviceKeys, LookupMap map) throws ServiceNotFoundException {

		List<ServiceStartupEntry> result = new ArrayList<ServiceStartupEntry>(serviceKeys.size());

		for(Class<?> key : serviceKeys) {
			result.add(map.getChecked(key.getName()));
		}
		return result;
	}

	/**
	 * Print the services. For debug purpose
	 * 
	 * @param roots
	 */
	private void showServices(String message, Collection<ServiceStartupEntry> roots) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--------------------------\n");
		buffer.append(message);
		buffer.append("\n");
		for(ServiceStartupEntry service : roots) {
			buffer.append("  ");
			buffer.append(service.getDescriptor().toString());
			buffer.append("\n");
		}
		buffer.append("--------- done -----------\n");
		Activator.log.debug(buffer.toString());
	}

	/**
	 * Check if all dependencies exist. Throw an error if a declared dependency
	 * has no corresponding service.
	 * 
	 * @param services
	 *        Services to check
	 * @param map
	 *        Map of services by keys.
	 * @throws ServiceMultiException
	 */
	private void checkDependencies(Collection<ServiceStartupEntry> services, LookupMap map) throws ServiceMultiException {

		ServiceMultiException errors = new ServiceMultiException();

		// Walk each service and check if its required services exist.
		for(ServiceStartupEntry service : services) {
			ServiceDescriptor desc = service.getDescriptor();

			// Check each required service
			for(String key : desc.getRequiredServiceKeys()) {

				// Check if service can be found
				try {
					map.getChecked(key);
				} catch (ServiceNotFoundException e) {
					errors.addException(desc.getKey(), e);
				}
			}
		}

		// Throw errors if any
		if(errors.getExceptions().size() > 0)
			throw errors;
	}

	/**
	 * Retains only the services that should be started. Retains only services
	 * with startupkind = START and state == REGISTERED
	 * 
	 * @param services
	 *        Collection to filter
	 * @return a new Collection containing the services to start.
	 */
	private List<ServiceStartupEntry> retainsToStartServices(Collection<ServiceStartupEntry> services) {

		List<ServiceStartupEntry> result = new ArrayList<ServiceStartupEntry>();
		for(ServiceStartupEntry service : services) {
			ServiceDescriptor desc = service.getDescriptor();
			if(service.getState() == ServiceState.registered && desc.isStartAtStartup()) {
				result.add(service);
			}
		}

		return result;
	}

	/**
	 * Check for cycles. Throws an exception if a cycle is discovered. Each root
	 * is checked to see if it contains a cycle.
	 * 
	 * @param roots
	 * @param map
	 */
	private void checkCycle(Collection<ServiceStartupEntry> roots, LookupMap map) {
		// TODO Auto-generated method stub

	}

	/**
	 * Build a list of services to start, in the topological order (right
	 * order). The required services are placed before the dependent services in
	 * the list. Services already started are disguarded.
	 * 
	 * @param roots
	 * @param map
	 *        Map used to resolve the entry by their key.
	 * @return
	 */
	private List<ServiceStartupEntry> buildTopologicalListOfServicesToStart(Collection<ServiceStartupEntry> roots, LookupMap map) {

		List<ServiceStartupEntry> result = new ArrayList<ServiceStartupEntry>();

		// Each root represent a graph. Walk the root and its child in the list,
		// in the right order.
		for(ServiceStartupEntry root : roots) {
			walkGraphDepthFirst(result, root, map);
		}

		return result;
	}

	/**
	 * Add recursively the provided node, and then its direct children.
	 * 
	 * @param result
	 *        The list where the node are added
	 * @param node
	 *        The node to add
	 * @param map
	 */
	private void walkGraphDepthFirst(List<ServiceStartupEntry> result, ServiceStartupEntry node, LookupMap map) {

		// Do not add already added or started node.
		if(result.contains(node) || node.isStarted())
			return;

		// add direct child
		for(String serviceKey : node.getDescriptor().getRequiredServiceKeys()) {
			try {
				ServiceStartupEntry child = map.getChecked(serviceKey);
				walkGraphDepthFirst(result, child, map);
			} catch (ServiceNotFoundException e) {
				// Do nothing, we have already reported the problems with
				// checkServices;
			}
		}

		// Now add the node
		result.add(node);
	}

	/**
	 * Create a List of the root services. The roots are services that are not
	 * required by any service.
	 * 
	 * @param addedServices
	 *        A collection from which roots are required. The collection is
	 *        unmodified.
	 * @param map
	 * @return
	 */
	private Collection<ServiceStartupEntry> getServiceRoots(Collection<ServiceStartupEntry> addedServices, LookupMap keyServiceMap) {

		// Create a copy of the list of services
		Collection<ServiceStartupEntry> services = new ArrayList<ServiceStartupEntry>(addedServices);

		List<ServiceStartupEntry> allRequired = new ArrayList<ServiceStartupEntry>();

		// The roots are services that are not required by any service.
		// Build a list of the services required by all other services.
		for(ServiceStartupEntry service : services) {
			// Add each child to the list of required
			for(String serviceKey : service.getDescriptor().getRequiredServiceKeys()) {
				try {

					ServiceStartupEntry child = keyServiceMap.getChecked(serviceKey);
					allRequired.add(child);
				} catch (ServiceNotFoundException e) {
					// Do nothing, we have already reported the problems with
					// checkServices;
				}
			}

		}

		// Roots are those that are not required.
		// So it is the original list minus the required.
		services.removeAll(allRequired);

		return services;
	}

	/**
	 * Dispose all services for this registry and its parents.
	 * 
	 * @throws ServiceMultiException
	 */
	public void disposeRegistry() throws ServiceMultiException {

		disposeRegistry(true);
	}

	/**
	 * Dispose all services, and parent registries if any.
	 * 
	 * @throws ServiceMultiException
	 */
	public void disposeRegistry(boolean isRecursive) throws ServiceMultiException {

		// List of keys of service in error.
		ServiceMultiException errors = new ServiceMultiException();
		disposeRegistry(errors, isRecursive);
		// Report errors if any
		if(errors.getExceptions().size() > 0)
			throw errors;
	}

	/**
	 * Dispose all services, and parent registries if any.
	 * 
	 * @throws ServiceMultiException
	 */
	protected void disposeRegistry(ServiceMultiException errors, boolean isRecursive) throws ServiceMultiException {

		// List of keys of service in error.
		disposeServices(namedServices.values(), errors);
		disposeServices(anonymousServices, errors);

		// Clean up properties to help GC
		addedServices.clear();
		addedServices = null;
		anonymousServices.clear();
		anonymousServices = null;
		namedServices.clear();
		namedServices = null;
		
		// Do parents
		if( isRecursive ) {
			for( ServicesRegistry parent : parents) {
				parent.disposeRegistry( errors, true);
			}
		}
	}

	/**
	 * Create all services provided in the list
	 * 
	 * @param toStart
	 *        List of services to create.
	 * @param errors
	 *        Exception to collect errors.
	 * 
	 * @throws ServiceMultiException
	 *         If an error occure during the creation
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void createServices(List<ServiceStartupEntry> toStart, ServiceMultiException errors) throws ServiceMultiException {

		// Loop on all services
		for(ServiceStartupEntry serviceEntry : toStart) {
			try {

				serviceEntry.createService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't create service '" + serviceEntry + "'", e);

				errors.addException(serviceEntry.getDescriptor().getKey(), e);
			}
		}

	}

	/**
	 * Register all services provided in the list. After this operation,
	 * services are available thru {@link #getService(Class)}.
	 * 
	 * @param toStart
	 *        List of services to register.
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void registerServices(Collection<ServiceStartupEntry> toStart) {

		// Loop on all services
		for(ServiceStartupEntry serviceEntry : toStart) {
			ServiceDescriptor desc = serviceEntry.getDescriptor();
			if(desc.isAnonymous()) {
				anonymousServices.add(serviceEntry);
			} else {
				namedServices.put(desc.getKey(), serviceEntry);
			}
		}
	}

	/**
	 * Init all services provided in the list
	 * 
	 * @param toStart
	 *        List of services to init.
	 * @param errors
	 * 
	 * @throws ServiceMultiException
	 *         If an error occure during the process
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void initServices(List<ServiceStartupEntry> toStart, ServiceMultiException errors) throws ServiceMultiException {

		// Loop on all services
		for(ServiceStartupEntry serviceEntry : toStart) {
			try {

				serviceEntry.initService(this);
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't initialize service '" + serviceEntry + "'", e);
				errors.addException(serviceEntry.getDescriptor().getKey(), e);
			}
		}

	}

	/**
	 * Init all services provided in the list
	 * 
	 * @param toStart
	 *        List of services to init.
	 * @param errors
	 * 
	 * @throws ServiceMultiException
	 *         If an error occure during the process
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void startServices(List<ServiceStartupEntry> toStart, ServiceMultiException errors) throws ServiceMultiException {

		// Loop on all services
		for(ServiceStartupEntry serviceEntry : toStart) {
			try {

				serviceEntry.startService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't start service '" + serviceEntry + "'", e);

				errors.addException(serviceEntry.getDescriptor().getKey(), e);
			}
		}

	}

	/**
	 * Dispose all started services.
	 * Services are disposed in creation reverse order
	 * 
	 * @throws ServiceMultiException
	 * 
	 * @throws ServiceException
	 *         If a service can't be started.
	 */
	private void disposeServices(Collection<ServiceStartupEntry> services, ServiceMultiException errors) {

		// Dispose services
		for(ServiceStartupEntry serviceEntry : services) {
			try {
				serviceEntry.disposeService();
			} catch (ServiceException e) {
				log.log(Level.SEVERE, "Can't dispose service '" + serviceEntry.getDescriptor().getKey() + "'", e);
				errors.addException(serviceEntry.getDescriptor(), e);
			}
		}
	}

	/**
	 * This class represents a union of two maps of <String,
	 * ServiceStartupEntry>. It provide specific methods to retrieve a {@link ServiceStartupEntry} by its key.
	 * <br>
	 * This class is used to lookup {@link ServiceStartupEntry} in multiple namespaces (2 maps, and then registries).
	 * 
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	private class LookupMap {

		Map<String, ServiceStartupEntry> map1;

		Map<String, ServiceStartupEntry> map2;
		
		// additional service registries into which we should search
		List<ServicesRegistry> registries;

		/**
		 * 
		 * Constructor. Build a union of two maps.
		 * 
		 * @param map1
		 * @param map2
		 */
		public LookupMap(Map<String, ServiceStartupEntry> map1, Map<String, ServiceStartupEntry> map2) {
			this.map1 = map1;
			this.map2 = map2;
		}

		public LookupMap(Map<String, ServiceStartupEntry> space1, Map<String, ServiceStartupEntry> space2, List<ServicesRegistry> registries) {
			this( space1, space2);
			this.registries = registries;
		}

		/**
		 * 
		 * Constructor. Build a union of one map (sic).
		 * 
		 * @param map
		 */
		@SuppressWarnings("unused")
		public LookupMap(Map<String, ServiceStartupEntry> map) {
			this(map, null);
		}

		/**
		 * Get a service by its key.
		 * 
		 * @param key
		 * @return the service or null if not found.
		 */
		@SuppressWarnings("unused")
		public ServiceStartupEntry get(String key) {

			ServiceStartupEntry res = map1.get(key);
			if(res != null)
				return res;
			if(map2 != null) {
				res = map2.get(key);
			}
			if( res == null && registries != null) {
				// lookup in registries
				res = getFromRegistries(key);
			}

			return res;
		}

		/**
		 * Get a service by its key.
		 * 
		 * @param key
		 * @return The requested service.
		 * @throws ServiceNotFoundException
		 *         if the service can't be found.
		 */
		public ServiceStartupEntry getChecked(String key) throws ServiceNotFoundException {

			ServiceStartupEntry res = map1.get(key);
			if(res != null)
				return res;
			if(map2 != null)
				res = map2.get(key);
			if( res == null && registries != null) {
				// lookup in registries
				res = getFromRegistries(key);
			}
			if(res != null)
				return res;

			throw new ServiceNotFoundException("No service found under key '" + key.toString() + "'");
		}
		
		/**
		 * Try to get the entry from the registries.
		 * @param key
		 * @return
		 */
		private ServiceStartupEntry getFromRegistries(String key) {
			
			ServiceStartupEntry service;
			// Lookup in parents
			for(ServicesRegistry registry : registries) {
				service = registry.getServiceStartupEntry(key);
				if( service != null) {
					return service;
				}	
			}

			return null;
		}
	}

}
