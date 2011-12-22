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
package org.eclipse.papyrus.views.properties.runtime.modelhandler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.w3c.dom.Node;



/**
 * Service to retrieve model handlers
 */
public class ModelHandlerService {

	/** identifier for the model handler extension point */
	public static final String EXTENSION_POINT_ID = "org.eclipse.papyrus.views.properties.runtime.propertyModelHandler";

	/** list of registered model handlers factories descriptors */
	protected final List<ModelHandlerFactoryDescriptor> modelHandlerFactoryDescriptors;

	/** singleton instance of the service */
	protected static ModelHandlerService instance;

	/**
	 * Creates a new ModelHandlerService.
	 * 
	 * @param modelHandlerFactoryDescriptors
	 *        list of model handler factory descriptors proposed by this service
	 */
	protected ModelHandlerService(List<ModelHandlerFactoryDescriptor> modelHandlerFactoryDescriptors) {
		this.modelHandlerFactoryDescriptors = modelHandlerFactoryDescriptors;
	}

	/**
	 * returns the singleton instance of this class
	 * 
	 * @return the singleton instance of this class
	 */
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
		// read extension points and initialize the factories
		// Reading data from plugins
		List<ModelHandlerFactoryDescriptor> modelHandlers = new ArrayList<ModelHandlerFactoryDescriptor>();

		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		for(IConfigurationElement element : configElements) {
			ModelHandlerFactoryDescriptor descriptor = new ModelHandlerFactoryDescriptor(element);
			modelHandlers.add(descriptor);
		}
		return new ModelHandlerService(modelHandlers);
	}

	/**
	 * Creates and return a model handler, given the configuration node
	 * 
	 * @param id
	 *        the id of the handler to create
	 * @param featureNode
	 *        the node configuring the model handler
	 * @return the create model handler
	 */
	public Object createModelHandler(String id, Node featureNode) {
		// retrieve the model handler factory that has the correct id
		for(ModelHandlerFactoryDescriptor descriptor : modelHandlerFactoryDescriptors) {
			if(id.equals(descriptor.getId())) {
				IPropertyModelHandlerFactory factory = descriptor.getModelHandlerFactory();
				if(factory != null) {
					return factory.createModelHandler(featureNode);
				} else {
					// descriptor already send a message, no need to send there one more.
				}
			}
		}

		return null;
	}
}
