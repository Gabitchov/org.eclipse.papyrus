/**
 * 
 */
package org.eclipse.papyrus.core.services;


/**
 * A factory creating a Service that can be registered in the {@link ServicesRegistry}.
 * 
 * A service is a singleton available throw the registry. A service can be shared across editors.
 * The service lifecycle events (init, start and dispose) are sent to the factory. The factory is 
 * responsible to forward them to the real service.
 * 
 * @author dumoulin
 * 
 */
public interface IServiceFactory extends IService {

	/**
	 * Creates the service that should be registered in the registry.
	 * 
	 * @return The service to register in the registry.
	 */
	public Object createService();
	
}
