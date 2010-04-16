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
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;


/**
 * Service to provide property views providers.
 */
public class PropertyViewService extends Service {

	/** instance of this service */
	protected static PropertyViewService instance;

	/**
	 * Creates a new PropertyViewService. This constructor is not visible, using singleton pattern.
	 */
	protected PropertyViewService() {
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
	public synchronized static PropertyViewService getInstance() {
		if(instance == null) {
			instance = new PropertyViewService();
			instance.configureProviders(Activator.ID, "propertyViewProvider"); //$NON-NLS-1$
		}
		return instance;
	}

	/**
	 * Creates a new Property editor controller given its configuration
	 * 
	 * @param objectsToEdit
	 *        the list of objects to display
	 * @param parent
	 *        the composite parent for the property view
	 * @param controllerDescriptor
	 *        the descriptor of the property editor controller
	 * @return the created controller for the property editor
	 */
	public PropertyEditorController createPropertyEditorController(List<Object> objectsToEdit, Composite parent, IPropertyEditorControllerDescriptor controllerDescriptor) {
		PropertyEditorController result = (PropertyEditorController)executeUnique(ExecutionStrategy.REVERSE, new CreatePropertyViewCompositeOperation(objectsToEdit, parent, controllerDescriptor));
		return result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * Returns the list of tab descriptors for property view
	 * 
	 * @return the list of tab descriptors for property view
	 */
	@SuppressWarnings("unchecked")
	public List<List<ITabDescriptor>> getTabDescriptors() {
		return (List<List<ITabDescriptor>>)execute(ExecutionStrategy.REVERSE, new GetTabDescriptorsFromConfiguration());
	}

	/**
	 * A descriptor for property views providers defined by a configuration element.
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
			if(operation instanceof CreatePropertyViewCompositeOperation /* || operation instanceof CanContributeToViewOperation */) {
				// test if the configuration corresponds to the feature or the id of the operation
				return getProvider().provides(operation);
			}

			if(operation instanceof GetTabDescriptorsFromConfiguration) {
				return getProvider().provides(operation);
			}

			return false;
		}

		/**
		 * @see org.eclipse.ogmf.runtime.common.core.service.Service.ProviderDescriptor#getProvider()
		 */
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof XMLPropertyViewProvider) {
					((XMLPropertyViewProvider)newProvider).configure(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}
}
