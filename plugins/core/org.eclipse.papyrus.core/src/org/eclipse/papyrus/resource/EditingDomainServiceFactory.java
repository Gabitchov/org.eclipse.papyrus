/**
 * 
 */
package org.eclipse.papyrus.resource;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * A service factory starting the EditingDomain service.
 * @author cedric dumoulin
 *
 */
public class EditingDomainServiceFactory implements IServiceFactory {
	
	/**
	 * The associated ModelSet.
	 * This service depends on the ModelSet service. So, we can get it in the init.
	 */
	private ModelSet modelSet;
	
	/**
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		modelSet = servicesRegistry.getService(ModelSet.class);
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IServiceFactory#createServiceInstance()
	 *
	 * @return
	 */
	public Object createServiceInstance() {
		return modelSet.getTransactionalEditingDomain();
	}

}
