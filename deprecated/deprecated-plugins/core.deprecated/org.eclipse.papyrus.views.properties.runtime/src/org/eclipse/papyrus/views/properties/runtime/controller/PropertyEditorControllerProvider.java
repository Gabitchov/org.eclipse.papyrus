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
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Node;

/**
 * Provider for property editors
 */
public class PropertyEditorControllerProvider extends AbstractProvider {

	/** map that stores the mapping id -> editor class */
	private Map<String, PropertyEditorControllerConfiguration> controllers = new HashMap<String, PropertyEditorControllerConfiguration>();

	private Bundle bundle;

	/**
	 * Creates the property editor managed by this provider
	 * 
	 * @param controllerIdentifier
	 *        identifier of the controller
	 * 
	 * @return the property editor managed by this provider
	 */
	public IPropertyEditorController createPropertyEditorController(String controllerIdentifier) {
		// retrieve property class managed by this provider
		try {
			PropertyEditorControllerConfiguration configuration = controllers.get(controllerIdentifier);
			if(configuration == null) {
				Activator.log.error("impossible to find the configuration for controller " + controllerIdentifier, null);
				return null;
			}
			Object controller = configuration.instanciateController();
			return (IPropertyEditorController)controller;
		} catch (CoreException e) {
			e.printStackTrace();
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Configures the provider, given the {@link IConfigurationElement}
	 * 
	 * @param providerConfiguration
	 *        the configuration element from the xml plugin file
	 */
	public void configure(IConfigurationElement providerConfiguration) {
		try {
			bundle = Platform.getBundle(providerConfiguration.getContributor().getName());

			// for each property editors defined in the provider, retrieves important information
			for(IConfigurationElement element : providerConfiguration.getChildren()) {
				// check this child is really configuring editors (not a Priority child...)
				if("PropertyEditorController".equals(element.getName())) {
					// parse this editor configuration
					PropertyEditorControllerConfiguration configuration = PropertyEditorControllerConfiguration.parse(element);
					controllers.put(configuration.getId(), configuration);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
			Activator.log.error(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreatePropertyEditorControllerOperation) {
			CreatePropertyEditorControllerOperation createPropertyEditorOperation = (CreatePropertyEditorControllerOperation)operation;

			// test if the configuration corresponds to the feature or the id of the operation
			// first test the id (specific editor) 
			// then test the feature

			String operationIdentifier = createPropertyEditorOperation.getControllerIdentifier();
			return controllers.containsKey(operationIdentifier);
		}
		if(operation instanceof CreatePropertyEditorControllerDescriptorOperation) {
			CreatePropertyEditorControllerDescriptorOperation controllerDescriptorOperation = (CreatePropertyEditorControllerDescriptorOperation)operation;
			return controllers.containsKey(controllerDescriptorOperation.getControllerID());
		}
		return false;
	}

	/**
	 * Generates the {@link IPropertyEditorControllerDescriptor} that configures the controller
	 * 
	 * @param controllerID
	 *        the id of the controller to configure
	 * @param contentNode
	 *        the content node that configures the controller
	 * @return the created {@link IPropertyEditorControllerDescriptor}
	 */
	public IPropertyEditorControllerDescriptor generateDescriptor(String controllerID, Node contentNode) {
		PropertyEditorControllerConfiguration configuration = controllers.get(controllerID);
		return configuration.createControllerDescriptor(contentNode, bundle);
	}

}
