/**
 * 
 */
package org.eclipse.papyrus.core.services;



/**
 * A service that register itself to its associated {@link ComposedService}.
 * 
 * @param T The main ComposedService
 * 
 * @author cedric dumoulin
 * @param T The type of the ComposedService to which this part will be registered.
 *
 */
@SuppressWarnings("rawtypes")
public abstract class ComposedServicePart <T extends ComposedService> implements IService {

	/**
	 * 
	 */
	protected ServicesRegistry servicesRegistry;
	
	/**
	 * Class of the parent ComposedService
	 */
	private Class<T> composedServiceKey;
	
	/**
	 * ComposedService that will own this part.
	 */
	T parentService;
	
	
	public ComposedServicePart( Class< T> composedServiceKey) {
		this.composedServiceKey = composedServiceKey;
	}
	
	/**
	 * Initialize the service. Attach itself to the ComposedService
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException 
	 */
	@SuppressWarnings("unchecked")
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry;
		parentService = servicesRegistry.getService(composedServiceKey);
		parentService.addServicePart(this);
	}

	/**
	 * Start the service. 
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 *
	 */
	public void startService() throws ServiceException {
		
	
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 *
	 */
	@SuppressWarnings("unchecked")
	public void disposeService() {
		parentService.removeServicePart(this);
	}

	
}
