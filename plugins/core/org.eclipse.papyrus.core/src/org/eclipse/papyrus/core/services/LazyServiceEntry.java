/**
 * 
 */
package org.eclipse.papyrus.core.services;


/**
 * An ServiceEnry managing {@link IService} registered as lazy start.
 * 
 * @author cedric dumoulin
 *
 */
public class LazyServiceEntry extends AbstractServiceEntry {

	/** Instance of the service, if started. */
	private IService serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public LazyServiceEntry(ServiceDescriptor serviceDescriptor, ServicesRegistry registry) {
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
	public LazyServiceEntry(ServiceDescriptor descriptor, IService serviceInstance) {
		this.serviceDescriptor = descriptor;
		this.serviceInstance = serviceInstance;
		setState(ServiceState.registered);
	}

	/**
	 * @see org.eclipse.papyrus.core.services.AbstractServiceEntry#getServiceInstance()
	 *
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Object getServiceInstance() throws ServiceException {
		if( state == ServiceState.registered)
		{
			lazyStart();
		}
		
		return serviceInstance;
	}

	/**
	 * Lazily start the service. Do create, init and start
	 */
	protected void lazyStart() throws ServiceException {
		
		checkState(ServiceState.registered);

		try {
			// Create the instance
			if( serviceInstance == null) {
				serviceInstance = (IService)instanciateService();
			}
			// Initialize it
			serviceInstance.init(registry);
			// Start it
			setState(ServiceState.starting);
			serviceInstance.startService();
		} catch (Exception e) {
			setState(ServiceState.error);
			throw new ServiceException(e);
		}
		
		setState(ServiceState.started);
	}
	
	/**
	 * Do nothing
	 *
	 * @throws ServiceException
	 */
	@Override
	public void createService() throws ServiceException {
	}

	/**
	 * Do nothing
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
	}

	/**
	 * Do nothing.
	 *
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.core.services.AbstractServiceEntry#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		if(serviceInstance == null)
			return;

		serviceInstance.disposeService();
		serviceInstance = null;
		setState(ServiceState.disposed);
	}

}
