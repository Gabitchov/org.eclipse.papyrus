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
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.CreatePredefinedPropertyControllerProviderOperation;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.GetAllPredefinedPropertyEditorControllersOperation;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.PredefinedControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.PredefinedPropertyControllerProvider;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.Bundle;
import org.w3c.dom.Node;


/**
 * Service to provide property editor controllers.
 */
public class PropertyEditorControllerService extends Service {

	/** instance of this service */
	protected static PropertyEditorControllerService instance;

	/**
	 * Creates a new PropertyEditorControllerService. This constructor is not visible, using singleton pattern.
	 */
	protected PropertyEditorControllerService() {
		super();
	}

	/**
	 * Returns the singleton instance of this service.
	 * 
	 * @return the singleton instance of this service
	 */
	/**
	 * Returns the singleton instance of this service
	 * 
	 * @return the singleton instance of this service
	 */
	public synchronized static PropertyEditorControllerService getInstance() {
		if(instance == null) {
			instance = new PropertyEditorControllerService();
			instance.configureProviders(Activator.ID, "propertyEditorControllerProvider"); //$NON-NLS-1$
		}
		return instance;
	}

	/**
	 * Creates the descriptor that will parse the content of the xml file
	 * 
	 * @param controllerId
	 *        the id of the configured controller
	 * @param controllerNode
	 *        the content node
	 * @param bundle
	 *        the bundle used to load classes for the controller
	 * @return the created descriptor
	 */
	public IPropertyEditorControllerDescriptor createPropertyEditorControllerDescriptor(String controllerId, Node controllerNode, Bundle bundle) {
		return (IPropertyEditorControllerDescriptor)executeUnique(ExecutionStrategy.REVERSE, new CreatePropertyEditorControllerDescriptorOperation(controllerId, controllerNode, bundle));
	}

	/**
	 * Creates the descriptor for a predefined controller
	 * 
	 * @param predefinedID
	 *        the id of the predefined controller
	 * @return the created descriptor
	 */
	public IPropertyEditorControllerDescriptor createPredefinedControllerDescriptor(String predefinedID) {
		return (IPropertyEditorControllerDescriptor)executeUnique(ExecutionStrategy.REVERSE, new CreatePredefinedPropertyControllerProviderOperation(predefinedID));
	}

	/**
	 * Returns the flatten collection of all available predefined controllers
	 * 
	 * @return the flatten collection of all available predefined controllers
	 */
	@SuppressWarnings("unchecked")
	public Map<String, PredefinedControllerDescriptor> getAllPredefinedControllers() {
		List<Map<String, PredefinedControllerDescriptor>> predefinedControllers = (List<Map<String, PredefinedControllerDescriptor>>)execute(ExecutionStrategy.REVERSE, new GetAllPredefinedPropertyEditorControllersOperation());
		Map<String, PredefinedControllerDescriptor> flattenMap = new HashMap<String, PredefinedControllerDescriptor>();
		for(Map<String, PredefinedControllerDescriptor> subList : predefinedControllers) {
			flattenMap.putAll(subList);
		}
		return flattenMap;
	}

	/**
	 * Creates the property editor controller
	 * 
	 * @param objectsToEdit
	 *        list of objects to edit
	 * @param parent
	 *        parent of all controls created by the editor
	 * @param descriptor
	 *        the controller descriptor that manages the editor
	 * @return the created property editor controller
	 */
	public PropertyEditorController createPropertyEditorController(List<Object> objectsToEdit, Composite parent, IPropertyEditorControllerDescriptor descriptor) {

		Object result = executeUnique(ExecutionStrategy.REVERSE, new CreatePropertyEditorControllerOperation(descriptor.getControllerID(), objectsToEdit, parent, descriptor));
		return (PropertyEditorController)result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * A descriptor for property editor controller providers defined by a configuration element.
	 */
	protected static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for
		 * the specified configuration element.
		 * 
		 * @param element
		 *        The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
		 */
		public boolean provides(IOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}
			if(operation instanceof CreatePropertyEditorControllerOperation) {
				// test if the configuration corresponds to the feature or the id of the operation
				return getProvider().provides(operation);
			}

			if(operation instanceof CreatePredefinedPropertyControllerProviderOperation) {
				// test if the configuration corresponds to the feature or the id of the operation
				return getProvider().provides(operation);
			}

			if(operation instanceof CreatePropertyEditorControllerDescriptorOperation) {
				return getProvider().provides(operation);
			}

			if(operation instanceof GetAllPredefinedPropertyEditorControllersOperation) {
				return getProvider().provides(operation);
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof PropertyEditorControllerProvider) {
					PropertyEditorControllerProvider defaultProvider = (PropertyEditorControllerProvider)newProvider;
					defaultProvider.configure(getElement());
				} else if(provider instanceof PredefinedPropertyControllerProvider) {
					PredefinedPropertyControllerProvider defaultProvider = (PredefinedPropertyControllerProvider)newProvider;
					defaultProvider.configure(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

}
