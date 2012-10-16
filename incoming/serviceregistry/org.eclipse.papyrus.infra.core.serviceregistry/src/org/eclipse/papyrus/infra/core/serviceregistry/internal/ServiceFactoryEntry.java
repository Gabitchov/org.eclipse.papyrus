/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry.internal;

import org.eclipse.papyrus.infra.core.serviceregistry.BadStateException;
import org.eclipse.papyrus.infra.core.serviceregistry.IServiceFactory;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceException;
import org.eclipse.papyrus.infra.core.serviceregistry.ServiceState;
import org.eclipse.papyrus.infra.core.serviceregistry.ServicesRegistry;

/**
 * Entry of a Service implementing {@link IServiceFactory}. This class provide
 * methods to manage the Service life cycle.
 * 
 * @author cedric dumoulin
 * 
 */
public class ServiceFactoryEntry extends ServiceTypeEntry {

	/** Instance of the service, if started. */
	private Object serviceInstance;

	/** Instance of the factory, if created. */
	private IServiceFactory factoryInstance;

	/**
	 * Constructor.
	 * 
	 * @param serviceDescriptor
	 * @param registry
	 */
	public ServiceFactoryEntry(ServiceDescriptor serviceDescriptor) {
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
	public ServiceFactoryEntry(ServiceDescriptor descriptor, IServiceFactory factoryInstance) {
		super(descriptor);
		this.factoryInstance = factoryInstance;
		setState(ServiceState.registered);
	}

	/**
	 * Get the service instance, even if it is not started. The service should
	 * be created.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If service can't be started.
	 */
	@Override
	public Object getServiceInstance() throws ServiceException {

		if(factoryInstance == null) {
			throw new BadStateException("Service is not available (state=" + state.toString() + "). ", state, serviceDescriptor);

		}
		// Get the service instance if needed.
		if(serviceInstance == null) {
			serviceInstance = factoryInstance.createServiceInstance();
			if(serviceInstance == null) {
				throw new ServiceException("Service Factory '" + getDescriptor().getKey() + " return a null service. It should return a valid service.");
			}
		}

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
	@Override
	public void createService() throws ServiceException {
		checkState(ServiceState.registered);
		// Exit if already created.
		if(factoryInstance != null) {
			setState(ServiceState.created);
			return;
		}

		// Create it
		try {
			// Create the instance
			factoryInstance = (IServiceFactory)instanciateService();
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
	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		checkState(ServiceState.created);
		try {
			factoryInstance.init(servicesRegistry);
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
	@Override
	public void startService() throws ServiceException {

		checkState(ServiceState.initialized);
		setState(ServiceState.starting);

		try {
			factoryInstance.startService();
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
	@Override
	public void disposeService() throws ServiceException {
		if(factoryInstance == null) {
			return;
		}

		factoryInstance.disposeService();
		factoryInstance = null;
		serviceInstance = null;
		setState(ServiceState.disposed);
	}

}
