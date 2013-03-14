/**
 * 
 */
package org.eclipse.papyrus.infra.core.editor;

import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.PluggableEditorFactoryReader;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Service Factory to register {@link IPageIconsRegistry}.
 * 
 * @author cedric dumoulin
 * 
 */
public class PageIconRegistryServiceFactory implements IServiceFactory {

	private PageIconsRegistry pageIconsRegistry;

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
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
		if(pageIconsRegistry != null) {
			pageIconsRegistry.dispose();
		}
	}

	/**
	 * Create and populate a {@link PageIconsRegistry}. Return it as the service
	 * instance.
	 * 
	 * @return
	 */
	public Object createServiceInstance() {
		if(pageIconsRegistry == null) {
			pageIconsRegistry = new PageIconsRegistry();
			PluggableEditorFactoryReader editorReader = new PluggableEditorFactoryReader(Activator.PLUGIN_ID);
			editorReader.populate(pageIconsRegistry);
		}
		return pageIconsRegistry;
	}

}
