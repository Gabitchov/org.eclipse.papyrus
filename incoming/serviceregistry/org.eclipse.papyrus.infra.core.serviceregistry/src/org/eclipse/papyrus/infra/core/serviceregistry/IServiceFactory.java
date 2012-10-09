/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry;

/**
 * A factory creating a Service that can be registered in the {@link ServicesRegistry}.
 * 
 * A service is a singleton available throw the registry. A service can be
 * shared across editors. The service lifecycle events (init, start and dispose)
 * are sent to the factory. The factory is responsible to forward them to the
 * real service.
 * 
 * @author dumoulin
 * 
 */
public interface IServiceFactory extends IService {

	/**
	 * Create the instance of the service that will be returned by {@link ServicesRegistry#getService(Class)}.
	 * 
	 * @return The instance of the service.
	 * @throws ServiceException
	 *         If an error occurs during the operation.
	 */
	public Object createServiceInstance() throws ServiceException;

}
