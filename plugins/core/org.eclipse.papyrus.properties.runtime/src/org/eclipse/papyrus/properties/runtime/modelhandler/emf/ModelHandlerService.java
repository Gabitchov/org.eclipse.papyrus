/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;



/**
 * Service to retrieve model handlers
 */
public class ModelHandlerService {

	/** list of registered model handlers */
	protected final static Map<String, Class<?>> modelHandlers = new HashMap<String, Class<?>>();

	/** singleton instance of the service */
	protected static ModelHandlerService instance;

	/**
	 * Creates a new ModelHandlerService.
	 */
	protected ModelHandlerService() {
	}

	public static synchronized ModelHandlerService getInstance() {
		if(instance == null) {
			instance = createService();
		}
		return instance;
	}


	/**
	 * Creates the singleton instance of the service
	 * 
	 * @return the singleton instance of the service
	 */
	protected static ModelHandlerService createService() {
		return new ModelHandlerService();
	}


	static {
		// initialize the list of model handlers
		modelHandlers.put(StringEMFModelHandler.ID, StringEMFModelHandler.class);
		modelHandlers.put(EnumerationEMFModelHandler.ID, EnumerationEMFModelHandler.class);
		modelHandlers.put(BooleanEMFModelHandler.ID, BooleanEMFModelHandler.class);
		modelHandlers.put(ReferenceEMFModelHandler.ID, ReferenceEMFModelHandler.class);
		// model handler for stereotype properties
		modelHandlers.put(StringStereotypeModelHandler.ID, StringStereotypeModelHandler.class);
		modelHandlers.put(EnumerationStereotypeModelHandler.ID, EnumerationStereotypeModelHandler.class);
		modelHandlers.put(BooleanStereotypeModelHandler.ID, BooleanStereotypeModelHandler.class);
		modelHandlers.put(ReferenceStereotypeModelHandler.ID, ReferenceStereotypeModelHandler.class);
	}

	/**
	 * Creates and return a model handler, given the configuration node
	 * 
	 * @param id
	 *        the id of the handler to create
	 * @return the create model handler
	 */
	public IEMFModelHandler createModelHandler(String id, Node featureNode) {
		return null;
	}

}
