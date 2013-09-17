/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime.service;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.layers.runtime.LayerStackApplicationSynchronizer;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * @author cedric dumoulin
 *
 */
public class LayersApplicationService implements IService {

	public static final String SERVICEID = "org.eclipse.papyrus.layers.runtime.service.LayersApplicationService";
	/**
	 * ModelSet to retrieve models
	 */
	protected ModelSet modelSet;
	
	/**
	 * The synchronizer used to listen on events and to synchronize layers and notation.
	 */
	protected LayerStackApplicationSynchronizer layersSynchronizer;
	/**
	 * Papyrus editor instance
	 */
	private IMultiDiagramEditor multiDiagramEditor;
	/**
	 * associated layerModel.
	 */
	private LayersModel layersModel;
	
	/**
	 * The {@link NotationModel}
	 */
	private NotationModel notationModel;
	/**
	 * Constructor.
	 *
	 */
	public LayersApplicationService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// Retrieve required services.
		modelSet = servicesRegistry.getService(ModelSet.class);
		multiDiagramEditor = servicesRegistry.getService(IMultiDiagramEditor.class);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {
		
		// Try to get the associated model
		try {
			layersModel = (LayersModel)modelSet.getModelChecked(LayersModel.MODEL_ID);
			notationModel = (NotationModel)modelSet.getModelChecked(NotationModel.MODEL_ID);
		} catch (NotFoundException e) {
			throw new ServiceException("Can't get layer model", e);
		} catch (ClassCastException e) {
			throw new ServiceException("layersModel should be of type LayersModel", e);
		}
		
		// Check model
		LayersStackApplication application = layersModel.getModelRoot();
		boolean isAlreadyExist = (application !=null);
		if( isAlreadyExist) {
			System.out.println("LayerApplication already exist in modelSet");
		}
		else {
			System.out.println("LayerApplication do not exist in modelSet");			
		}
		
		// Start synchronizer
		layersSynchronizer = new LayerStackApplicationSynchronizer(layersModel, notationModel);
		
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		
		layersSynchronizer.dispose();
		layersSynchronizer = null;
		layersModel = null;
		modelSet = null;
		multiDiagramEditor = null;

	}

}
