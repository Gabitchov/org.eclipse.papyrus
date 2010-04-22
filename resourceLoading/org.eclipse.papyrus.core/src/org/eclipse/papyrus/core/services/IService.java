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
	 * Start the service. This method is called when the service is started.
	 */
	public void startService();

	/**
	 * Dispose the service.
	 */
	public void disposeService();
}
