/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * This is the CDOAwareModelSetServiceFactory type. Enjoy.
 */
public class CDOAwareModelSetServiceFactory
		implements IServiceFactory {

	private IPapyrusRepositoryManager repositoryManager;

	private CDOAwareModelSet modelSet;

	public void init(ServicesRegistry servicesRegistry)
			throws ServiceException {

		repositoryManager = servicesRegistry
			.getService(IPapyrusRepositoryManager.class);
	}

	public void startService()
			throws ServiceException {

		// pass
	}

	public void disposeService()
			throws ServiceException {

		if (modelSet != null) {
			try {
				modelSet.unload();
			} catch (Exception e) {
				throw new ServiceException(Messages.CDOAwareModelSetServiceFactory_0, e);
			}
		}
	}

	public Object createServiceInstance() {
		modelSet = new CDOAwareModelSet(repositoryManager);
		return modelSet;
	}

}
