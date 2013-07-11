/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry.internal;

import org.eclipse.papyrus.infra.core.serviceregistry.BadStateException;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceException;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceState;
import org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry;

/**
 * A service entry used for faulty services. In this implementation, methods do
 * nothings or throw an error.
 * 
 * 
 * @author cedric dumoulin
 * 
 */
public class ErrorServiceTypeEntry extends ServiceTypeEntry {

	/**
	 * The original service descriptor.
	 */
	private ServiceDescriptor descriptor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param descriptor
	 */
	public ErrorServiceTypeEntry(ServiceDescriptor descriptor) {
		super(descriptor);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceTypeEntry#getServiceInstance()
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Object getServiceInstance() throws ServiceException {
		throw new BadStateException("Service has not started.", ServiceState.error, descriptor);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceTypeEntry#createService()
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void createService() throws ServiceException {
		// do nothing

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceTypeEntry#initService(ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		// do nothing

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceTypeEntry#startService()
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {
		// do nothing

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.internal.ServiceTypeEntry#disposeService()
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		// do nothing

	}

}
