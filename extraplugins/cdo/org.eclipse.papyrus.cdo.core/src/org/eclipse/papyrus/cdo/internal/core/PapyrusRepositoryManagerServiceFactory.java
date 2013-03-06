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
package org.eclipse.papyrus.cdo.internal.core;

import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


/**
 * Service factory for {@link IPapyrusRepositoryManager}s.
 */
public class PapyrusRepositoryManagerServiceFactory
		implements IServiceFactory {

	private IPapyrusRepositoryManager service;
	
	public PapyrusRepositoryManagerServiceFactory() {
		super();
	}

	public void init(ServicesRegistry servicesRegistry)
			throws ServiceException {
		
		// pass
	}

	public void startService()
			throws ServiceException {
		
		// pass
	}

	public void disposeService()
			throws ServiceException {
		
		// nothing to dispose (the repository manager is a shared instance)
	}

	public Object createServiceInstance()
			throws ServiceException {
		
		service = PapyrusRepositoryManager.INSTANCE;
		return service;
	}

}
