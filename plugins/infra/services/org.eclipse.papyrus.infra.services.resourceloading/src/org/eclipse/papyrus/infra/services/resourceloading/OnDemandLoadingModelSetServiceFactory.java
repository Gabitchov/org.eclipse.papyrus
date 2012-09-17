/**
 * 
 */
package org.eclipse.papyrus.infra.services.resourceloading;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


/**
 * A service starting the ModelSet
 * 
 * @author cedric dumoulin
 * 
 */
public class OnDemandLoadingModelSetServiceFactory implements IServiceFactory {

	/** The ModelSet */
	private ModelSet service;

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
		if(service != null)
			service.unload();
	}

	/**
	 * Create the service served by this factory.
	 */
	public Object createServiceInstance() {
		// Create the appropriate service.
		service = new OnDemandLoadingModelSet();
		return service;
	}

}
