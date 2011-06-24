/**
 * 
 */
package org.eclipse.papyrus.core.editor;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.editorsfactory.PageModelFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.PluggableEditorFactoryReader;
import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.resource.sasheditor.SashModel;
import org.eclipse.papyrus.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.TransactionalDiSashModelMngr;


/**
 * Service Factory to create the {@link DiSashModelMngr} service.
 * 
 * @author cedric dumoulin
 * 
 */
public class DiSashModelMngrServiceFactory implements IServiceFactory {


	private TransactionalEditingDomain transactionalEditingDomain;

	private SashModel sashModel;

	private TransactionalDiSashModelMngr sashModelMngr;

	private ServicesRegistry servicesRegistry;



	/**
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

		this.servicesRegistry = servicesRegistry;
		// Get required service
		transactionalEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);

		// Get the model holding the contentProvider
		sashModel = SashModelUtils.getSashModelChecked(servicesRegistry);

	}

	/**
	 * @see org.eclipse.papyrus.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {

		// Read declared editors
		PageModelFactoryRegistry pageModelRegistry = new PageModelFactoryRegistry();
		PluggableEditorFactoryReader editorReader = new PluggableEditorFactoryReader(Activator.PLUGIN_ID);
		editorReader.populate(pageModelRegistry, servicesRegistry);

		if(sashModel.getResource() == null)
			throw new ServiceException("Can't start " + this.getClass().getSimpleName() + "'. Required model (SashModel) should be loaded prior starting the service.");

		// create the service
		sashModelMngr = new TransactionalDiSashModelMngr(pageModelRegistry, sashModel.getResource(), transactionalEditingDomain);


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
	 * @throws ServiceException
	 */
	public Object createServiceInstance() throws ServiceException {

		// Start locally the service if needed.
		// Question: Can createServiceInstance() method be called before startService() is called ?
		if(sashModelMngr == null) {
			startService();
		}

		return sashModelMngr;
	}

}
