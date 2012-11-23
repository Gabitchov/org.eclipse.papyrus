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
package org.eclipse.papyrus.infra.services.semantic.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.semantic.Activator;
import org.eclipse.papyrus.infra.services.semantic.service.SemanticService;

/**
 * Default implementation of the SemanticService. The result is composed of the root elements
 * of each resource of the current model set
 * 
 * @author Camille Letavernier
 * 
 */
public class SemanticServiceImpl implements SemanticService {

	private ServicesRegistry registry;

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.registry = servicesRegistry;
	}

	public void startService() throws ServiceException {
		//Nothing
	}

	public void disposeService() throws ServiceException {
		registry = null;
	}

	/**
	 * The default implements returns all root EObjects
	 */
	public EObject[] getSemanticRoots() {
		try {
			List<EObject> rootElements = new LinkedList<EObject>();

			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(registry);
			for(Resource resource : modelSet.getResources()) {
				rootElements.addAll(resource.getContents());
			}

			return rootElements.toArray(new EObject[rootElements.size()]);

		} catch (Exception ex) {
			Activator.log.error(ex);
			return new EObject[0];
		}
	}

	/**
	 * TODO: Unsupported
	 */
	public IModel[] getSemanticIModels() {
		return new IModel[0]; //Currently, it is not possible to retrieve all registered IModels for a ModelSet
	}

}
