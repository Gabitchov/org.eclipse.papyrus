/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (pre-requisite refactoring of ModelSet service start-up)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;


public class ServiceUtilsForResourceSet extends AbstractServiceUtils<ResourceSet> {

	private ServiceUtilsForResourceSet() {
		//Singleton
	}

	private static ServiceUtilsForResourceSet instance = new ServiceUtilsForResourceSet();

	public static ServiceUtilsForResourceSet getInstance() {
		return instance;
	}

	@Override
	public ServicesRegistry getServiceRegistry(ResourceSet from) throws ServiceException {
		if(from == null) {
			throw new ServiceNotFoundException("Can't find the ResourceSet needed retrieve the ServiceRegistry."); //$NON-NLS-1$
		}

		ServicesRegistry result = ModelSetServiceFactory.getServiceRegistry(from);
		if(result == null) {
			throw new ServiceNotFoundException("The resource set was not initialized as a service."); //$NON-NLS-1$
		}
		return result;
	}

}
