/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry.internal;

import org.eclipse.papyrus.infra.core.serviceregistry.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceException;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceState;
import org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry;

/**
 * An alias can be used to access a service using another name.
 * 
 * @author cedric dumoulin
 */
public class AliasServiceEntry extends ServiceTypeEntry {

	/** The real service entry. */
	//	private ServiceTypeEntry referencedService;

	/** The instance of the real service. */
	private Object serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 */
	public AliasServiceEntry(ServiceDescriptor serviceDescriptor) {
		super(serviceDescriptor);
		setState(ServiceState.registered);
	}

	/**
	 * Get the service instance.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If service can't be started.
	 */
	@Override
	public Object getServiceInstance() throws ServiceException {

		checkState(ServiceState.started);

		return serviceInstance;
	}

	/**
	 * Already created : do nothing.
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void createService() throws ServiceException {
		checkState(ServiceState.registered);

		setState(ServiceState.created);
	}

	/**
	 * Try to get the instance of the referenced service.
	 * 
	 * @param servicesRegistry
	 *        The servicesRegistry containing this service.
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		checkState(ServiceState.created);
		try {
			String referencedServiceKey = getDescriptor().getRequiredServiceKeys().get(0);
			serviceInstance = servicesRegistry.getService(referencedServiceKey);
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
	 * Already started : do nothing.
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {
		setState(ServiceState.started);
	}

	/**
	 * Dispose the alias.
	 * The referenced service is not disposed
	 */
	@Override
	public void disposeService() throws ServiceException {

		serviceInstance = null;
		setState(ServiceState.disposed);
	}

}
