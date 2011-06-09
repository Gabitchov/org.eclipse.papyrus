/**
 * 
 */
package org.eclipse.papyrus.core.editor;

import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.PluggableEditorFactoryReader;
import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * Service Factory to register {@link IPageIconsRegistry}.
 * 
 * @author cedric dumoulin
 * 
 */
public class PageIconRegistryServiceFactory implements IServiceFactory {

	private PageIconsRegistry pageIconsRegistry;

	/**
	 * @see org.eclipse.papyrus.core.services.IService#init(org.eclipse.papyrus.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
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
	 * Create and populate a {@link PageIconsRegistry}. Return it as the service instance.
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
