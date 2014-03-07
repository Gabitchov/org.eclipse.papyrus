/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.editor;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.editorsfactory.PageModelFactoryRegistry;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.PluggableEditorFactoryReader;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelManager;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Service Factory to create the {@link DiSashModelManager} service.
 *
 * @author cedric dumoulin
 *
 */
public class DiSashModelManagerServiceFactory implements IServiceFactory {

	private TransactionalEditingDomain transactionalEditingDomain;

	private SashModel sashModel;

	private DiSashModelManager sashModelMngr;

	private ServicesRegistry servicesRegistry;

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

		this.servicesRegistry = servicesRegistry;
		// Get required service
		transactionalEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);

		// Get the model holding the contentProvider
		sashModel = SashModelUtils.getSashModelChecked(servicesRegistry);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {

		// Read declared editors
		PageModelFactoryRegistry pageModelRegistry = new PageModelFactoryRegistry();
		PluggableEditorFactoryReader editorReader = new PluggableEditorFactoryReader(Activator.PLUGIN_ID);
		editorReader.populate(pageModelRegistry, servicesRegistry);

		if(sashModel.getResource() == null) {
			throw new ServiceException("Can't start " + this.getClass().getSimpleName() + "'. Required model (SashModel) should be loaded prior starting the service.");
		}

		// create the service
		sashModelMngr = new DiSashModelManager(pageModelRegistry, sashModel.getResource(), transactionalEditingDomain);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IServiceFactory#createServiceInstance()
	 *
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Object createServiceInstance() throws ServiceException {

		// Start locally the service if needed.
		// Question: Can createServiceInstance() method be called before
		// startService() is called ?
		if(sashModelMngr == null) {
			startService();
		}

		return sashModelMngr;
	}

}
