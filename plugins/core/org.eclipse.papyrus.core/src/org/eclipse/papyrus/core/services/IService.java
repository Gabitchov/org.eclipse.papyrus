/**
 * 
 */
package org.eclipse.papyrus.core.services;


/**
 * An Service that can be registered in the {@link ServicesRegistry}.
 * A service is a singleton available throw the registry. A service can be shared across editors.
 * 
 * @author dumoulin
 * 
 */
public interface IService {

	/**
	 * Init the service and set its associated Registry.
	 * The registry can be used to retrieve other services.
	 * 
	 * @param servicesRegistry
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException;

	/**
	 * Start the service. This method is called when the service is started.
	 */
	public void startService() throws ServiceException;

	/**
	 * Dispose the service.
	 */
	public void disposeService() throws ServiceException;

}
