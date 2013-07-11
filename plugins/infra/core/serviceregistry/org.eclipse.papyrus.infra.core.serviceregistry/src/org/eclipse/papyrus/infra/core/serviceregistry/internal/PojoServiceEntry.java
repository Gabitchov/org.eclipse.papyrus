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
 * Entry for a service provided as POJO.
 * 
 * 
 * @author cedric dumoulin
 */
public class PojoServiceEntry extends ServiceTypeEntry {

	/** Instance of the service, if started. */
	private Object serviceInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 */
	public PojoServiceEntry(ServiceDescriptor serviceDescriptor) {
		super(serviceDescriptor);
		setState(ServiceState.registered);
	}

	/**
	 * Create an entry for an already created service. Constructor.
	 * 
	 * @param descriptor
	 *        Descriptor of the service. Key and priority should be set.
	 * @param serviceInstance
	 *        The service Instance
	 */
	public PojoServiceEntry(ServiceDescriptor descriptor, Object serviceInstance) {
		super(descriptor);
		this.serviceInstance = serviceInstance;
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

		if(serviceInstance == null) {
			throw new BadStateException("Service is not created.", state, serviceDescriptor);
		}

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
		// Exit if already created.
		if(serviceInstance != null) {
			setState(ServiceState.created);
			return;
		}

		// Create it
		try {
			// Create the instance
			serviceInstance = instanciateService();
		} catch (Exception e) {
			setState(ServiceState.error);
			throw new ServiceException(e);
		}
		setState(ServiceState.created);
	}

	/**
	 * Pojo : can't initialize the service. Do nothing.
	 * 
	 * @param servicesRegistry
	 *        The servicesRegistry containing this service.
	 * 
	 * @throws ServiceException
	 */
	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
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
	 * Do nothing.
	 */
	@Override
	public void disposeService() throws ServiceException {
		if(serviceInstance == null) {
			return;
		}

		serviceInstance = null;
		setState(ServiceState.disposed);
	}

}
