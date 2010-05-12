/**
 * 
 */
package org.eclipse.papyrus.core.services;




/**
 * Entry of a Service in the ServiceRegistry.
 * This class provide methods to manage the Service life cycle.
 * 
 * @author cedric dumoulin
 * 
 */
public class ServiceEntry extends AbstractServiceEntry {

	/** Instance of the service, if started. */
	private IService serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public ServiceEntry(ServiceDescriptor serviceDescriptor, ServicesRegistry registry) {
		this.serviceDescriptor = serviceDescriptor;
		this.registry = registry;
		setState(ServiceState.registered);

	}


	/**
	 * Create an entry for an already created service.
	 * Constructor.
	 * 
	 * @param descriptor
	 *        Descriptor of the service. Key and priority should be set.
	 * @param serviceInstance
	 *        The service Instance
	 */
	public ServiceEntry(ServiceDescriptor descriptor, IService serviceInstance) {
		this.serviceDescriptor = descriptor;
		this.serviceInstance = serviceInstance;
		setState(ServiceState.registered);
	}

	/**
	 * Get the service instance, even if it is not started.
	 * The service should be created.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If service can't be started.
	 */
	public Object getServiceInstance() throws ServiceException {
		
		if( serviceInstance == null)
			throw new BadStateException("Service is not created.", state, serviceDescriptor);
		
		return serviceInstance;
			
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
	 * Create the associated service if not a Lazy Service.
	 * 
	 * @throws ServiceException
	 */
	public void createService() throws ServiceException {
		checkState(ServiceState.registered);
		// Exit if already  created.
		if( serviceInstance != null)
		{
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
