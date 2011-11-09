/**
 * 
 */
package org.eclipse.papyrus.infra.core.editor;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * A service factory to create the {@link ModelSet} service. This provide a
 * nickname for {@link ModelSet} service. This serviceFactory depends on {@link ModelSet} service.
 * 
 * @author cedric dumoulin
 * 
 */
public class DiResourceSetServiceFactory implements IServiceFactory {

	/**
	 * The sashModelMangr.
	 */
	private ModelSet modelSet;

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// Get required services
		modelSet = servicesRegistry.getService(ModelSet.class);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IServiceFactory#createServiceInstance()
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Object createServiceInstance() throws ServiceException {
		return modelSet;
	}

}
