/**
 * 
 */
package org.eclipse.papyrus.core.services.internal;

import org.eclipse.papyrus.core.services.ServiceDescriptor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * Base class for the different types of service startups (lazy, synchronized).
 * @author cedric dumoulin
 *
 */
public abstract class ServiceStartupEntry {

	
	/**
	 * Descriptor of the service associated to this entry.
	 */
	protected ServiceDescriptor serviceDescriptor;

	/**
	 * The ServiceEntry, according to its type.
	 */
	protected ServiceTypeEntry serviceEntry;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param serviceDescriptor
	 */
	public ServiceStartupEntry(ServiceTypeEntry serviceEntry, ServiceDescriptor serviceDescriptor) {
		this.serviceDescriptor = serviceDescriptor;
		// TODO : check where the entryType should be created
		this.serviceEntry = serviceEntry;
	}

	/**
	 * Create the associated service if not a Lazy Service.
	 * @throws ServiceException
	 */
	abstract public void createService() throws ServiceException;

	/**
	 * Init the associated service if not a Lazy Service.
	 * @param servicesRegistry The servicesRegistry containing this service.
	 * 
	 * @throws ServiceException
	 */
	abstract public void initService( ServicesRegistry servicesRegistry) throws ServiceException;

	/**
	 * Start the associated service if not a Lazy Service.
	 * @throws ServiceException
	 */
	abstract public void startService() throws ServiceException;

	/**
	 * Get the service instance.
	 * 
	 * @return
	 * @throws ServiceException
	 */
	abstract public Object getServiceInstance() throws ServiceException;

	/**
	 * Dispose associated service.
	 */
	abstract public void disposeService() throws ServiceException;


}
