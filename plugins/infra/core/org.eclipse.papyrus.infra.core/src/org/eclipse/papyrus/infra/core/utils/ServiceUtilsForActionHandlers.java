/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.utils;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Set of utility methods for accessing core Services. This class provide
 * methods to access the Papyrus well known services. This class is designed to
 * be used from ui Action Handlers or from any code relying on the Eclipse
 * Active Editor. <br>
 * All methods from this class rely on the Eclipse Active Editor, which should
 * be an instance of {@link IMultiDiagramEditor}. If this is not the case,
 * methods throw an exception {@link ServiceException}.
 * 
 * @author cedric dumoulin
 * 
 * @deprecated 0.10: Use org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers instead
 */
@Deprecated
public class ServiceUtilsForActionHandlers {

	private ServiceUtilsForActionHandlers() {
		//Singleton
	}

	private final static ServiceUtilsForActionHandlers instance = new ServiceUtilsForActionHandlers();

	/**
	 * Get the singleton instance of the class.
	 * 
	 * @return
	 */
	public static final ServiceUtilsForActionHandlers getInstance() {
		return instance;
	}

	/**
	 * Get the service registry from the specified parameter.
	 * 
	 * @param from
	 * @return
	 */
	public ServicesRegistry getServiceRegistry() throws ServiceException {

		IEditorPart editor;
		try {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			ServicesRegistry serviceRegistry = (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
			if(serviceRegistry != null) {
				return serviceRegistry;
			}
		} catch (NullPointerException e) {
			// Can't get the active editor
			throw new ServiceNotFoundException("Can't get the current Eclipse Active Editor. No ServiceRegistry found.");
		}


		// Not found
		throw new ServiceNotFoundException("Can't get the ServiceRegistry from current Eclipse Active Editor");

	}

	/**
	 * Gets the {@link TransactionalEditingDomain} registered in the {@link ServicesRegistry}.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() throws ServiceException {
		return getServiceRegistry().getService(TransactionalEditingDomain.class);
	}

	/**
	 * Gets the {@link IPageMngr} registered in the {@link ServicesRegistry}.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 * 
	 * @deprecated Use {@link #getIPageManager} instead
	 */
	@Deprecated
	public IPageMngr getIPageMngr() throws ServiceException {
		return getServiceRegistry().getService(IPageMngr.class);
	}

	/**
	 * Gets the {@link IPageManager} registered in the {@link ServicesRegistry}.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 */
	public IPageManager getIPageManager() throws ServiceException {
		return getServiceRegistry().getService(IPageManager.class);
	}

	/**
	 * Gets the {@link IPageMngr} registered in the {@link ServicesRegistry}.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 */
	public ModelSet getModelSet() throws ServiceException {
		return getServiceRegistry().getService(ModelSet.class);
	}

	/**
	 * Gets the {@link ILifeCycleEventsProvider} registered in the {@link ServicesRegistry}.
	 * 
	 * @param from
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 */
	public ILifeCycleEventsProvider getILifeCycleEventsProvider() throws ServiceException {
		return getServiceRegistry().getService(ILifeCycleEventsProvider.class);
	}

	/**
	 * Gets the {@link ISashWindowsContainer} registered in the {@link ServicesRegistry}.
	 * 
	 * @param from
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 */
	public ISashWindowsContainer getISashWindowsContainer() throws ServiceException {
		return getServiceRegistry().getService(ISashWindowsContainer.class);
	}

	/**
	 * Gets the {@link IEditorPart} of the currently nested active editor.
	 * 
	 * @param from
	 * @return
	 * @throws ServiceException
	 *         If an error occurs while getting the requested service.
	 */
	public IEditorPart getNestedActiveIEditorPart() throws ServiceException {
		return getISashWindowsContainer().getActiveEditor();
	}
}
