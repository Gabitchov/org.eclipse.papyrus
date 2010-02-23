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
	}

	/**
	 * Start the service manually.
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
		// Create the instance if needed
		if(serviceInstance == null) {
			serviceInstance = createService();
		}
		serviceInstance.startService();
	}

	/**
	 * Get the service instance.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If service can't be started.
	 */
	public Object getServiceInstance() throws ServiceException {
		if(serviceInstance == null) {
			startService();
		}

		return serviceInstance;
	}


	/**
	 * Dispose the service manually.
	 */
	public void disposeService() throws ServiceException {
		if(serviceInstance == null)
			return;

		serviceInstance.disposeService();
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
	 * 
	 * @return
	 */
	public boolean isStarted() {
		return serviceInstance != null;
	}


}
