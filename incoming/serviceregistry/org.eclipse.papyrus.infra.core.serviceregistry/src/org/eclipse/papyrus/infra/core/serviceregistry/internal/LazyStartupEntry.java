/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry.internal;

import org.eclipse.papyrus.infra.core.serviceregistry.ServiceException;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceState;
import org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry;

/**
 * An ServiceEntry managing {@link IService} registered as lazy start.
 * 
 * @author cedric dumoulin
 * 
 */
public class LazyStartupEntry extends ServiceStartupEntry {

	protected ServicesRegistry registry;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public LazyStartupEntry(ServiceTypeEntry serviceEntry, ServicesRegistry registry) {

		super(serviceEntry);
		this.registry = registry;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceStartupEntry#getServiceInstance()
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Object getServiceInstance() throws ServiceException {
		if(serviceEntry.getState() == ServiceState.registered) {
			// Start the service
			try {
				serviceEntry.createService();
				serviceEntry.initService(registry);
				serviceEntry.startService();
			} catch (Exception e) {
				// There was an error. The service is in error
				serviceEntry = new ErrorServiceTypeEntry(serviceEntry.getDescriptor());
			}
		}

		// Return the instance
		return serviceEntry.getServiceInstance();
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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.AbstractServiceEntry#disposeService()
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		serviceEntry.disposeService();
	}

}
