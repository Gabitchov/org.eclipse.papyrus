/**
 * 
 */
package org.eclipse.papyrus.core.editor;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.ModelSet;


/**
 * A service starting the ModelSet
 * @author cedric dumoulin
 *
 */
public class ModelSetServiceFactory implements IServiceFactory{

	/** The ModelSet */
	private ModelSet service;
	
	/**
	 * 
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
		if( service != null)
			service.unload();
	}

	/**
	 * Create the service served by this factory.
	 */
	public Object createServiceInstance() {
		// Return a DiResourceSet for backward compatibility
		// TODO return a ModelSet once DiResourceSet is removed
		service = new DiResourceSet();
		return service;
	}

}
