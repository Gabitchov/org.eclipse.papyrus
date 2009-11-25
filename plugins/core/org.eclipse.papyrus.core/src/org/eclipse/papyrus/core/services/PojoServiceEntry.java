/**
 * 
 */
package org.eclipse.papyrus.core.services;


/**
 * @author cedric dumoulin
 */
public class PojoServiceEntry extends AbstractServiceEntry {

	/** Instance of the service, if started. */
	private Object serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public PojoServiceEntry(ServiceDescriptor serviceDescriptor, ServicesRegistry registry) {
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
	public PojoServiceEntry(ServiceDescriptor descriptor, Object serviceInstance) {
		this.serviceDescriptor = descriptor;
		this.serviceInstance = serviceInstance;
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
	 * Return true if the service is instantiated. Return false otherwise.
	 * 
	 * @return
	 */
	public boolean isStarted() {
		return serviceInstance != null;
	}


}
