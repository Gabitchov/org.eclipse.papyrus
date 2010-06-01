/**
 * 
 */
package org.eclipse.papyrus.core.resourceloading;

import org.eclipse.papyrus.controlmode.history.HistoryModel;
import org.eclipse.papyrus.controlmode.history.utils.HistoryUtils;
import org.eclipse.papyrus.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.controlmode.mm.history.historyFactory;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * An example of a service loading the HistoryModel.
 * @author cedric dumoulin
 *
 */
public class ExampleService implements IService {

	protected ServicesRegistry servicesRegistry;
	
	/**
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry;

	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
		// Example of code to retrieve the History Model:
		HistoryModel historyModel = HistoryUtils.getHistoryModel(servicesRegistry);
		ControledResource root = historyFactory.eINSTANCE.createControledResource();
		historyModel.addModelRoot(root);
		
	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
		// TODO Auto-generated method stub

	}

}
