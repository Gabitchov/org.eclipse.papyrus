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
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;

/**
 * A ServiceUtils instance for manipulating Papyrus services on an EObject
 * 
 * @author Camille Letavernier
 * 
 */
public class ServiceUtilsForEObject extends AbstractServiceUtils<EObject> {

	private static ServiceUtilsForEObject instance = new ServiceUtilsForEObject();

	public static ServiceUtilsForEObject getInstance() {
		return instance;
	}

	private ServiceUtilsForEObject() {
		//Singleton
	}

	@Override
	public ServicesRegistry getServiceRegistry(EObject from) throws ServiceException {
		if(from == null) {
			throw new ServiceException("The selected EObject must not be null");
		}

		return ServiceUtilsForResource.getInstance().getServiceRegistry(from.eResource());
	}
}
