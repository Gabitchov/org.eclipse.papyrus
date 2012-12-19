/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IWorkbenchPage;

/**
 * A ServiceUtils implementation for manipulating the Papyrus services from an IWorkbenchPage
 * 
 * @author Camille Letavernier
 * 
 */
public class ServiceUtilsForWorkbenchPage extends AbstractServiceUtils<IWorkbenchPage> {

	@Override
	public ServicesRegistry getServiceRegistry(IWorkbenchPage from) throws ServiceException {
		if(from instanceof IAdaptable) {
			ServicesRegistry registry = (ServicesRegistry)((IAdaptable)from).getAdapter(ServicesRegistry.class);
			if(registry != null) {
				return registry;
			}
		}

		throw new ServiceException("Cannot resolve the ServiceRegistry from the IWorkbenchPage. Page: " + from);
	}

	public static ServiceUtilsForWorkbenchPage getInstance() {
		return instance;
	}

	private static ServiceUtilsForWorkbenchPage instance = new ServiceUtilsForWorkbenchPage();

	private ServiceUtilsForWorkbenchPage() {
		//Singleton
	}

}
