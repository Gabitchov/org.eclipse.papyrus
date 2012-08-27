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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Node;


/**
 * Service to provide property editors.
 */
public class PropertyEditorService extends Service {

	/** instance of this service */
	protected static PropertyEditorService instance;

	/**
	 * Creates a new PropertyEditorService. This constructor is not visible, using singleton pattern.
	 */
	protected PropertyEditorService() {
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
	public synchronized static PropertyEditorService getInstance() {
		if(instance == null) {
			instance = new PropertyEditorService();
			instance.configureProviders(Activator.ID, "propertyEditorProvider"); //$NON-NLS-1$
		}
		return instance;
	}

	/**
	 * Creates the property editor
	 * 
	 * @param controller
	 *        the controller that manages this editors
	 * @param id
	 *        the identifier of the editor to create
	 * @param widgetFactory
	 *        widget factory used to create the content of the editor
	 * @return the created property editor
	 */
	public AbstractPropertyEditor createPropertyEditor(PropertyEditorController controller, String id, TabbedPropertySheetWidgetFactory widgetFactory) {
		List<Object> results = (List<Object>)execute(ExecutionStrategy.FORWARD, new CreatePropertyEditorOperation(controller, id));
		if(results == null || results.size()==0) {
			Activator.log.error("impossible to create the editor using id " + id, null);
			return null;
		}
		Object result = results.get(0);
		if(result instanceof AbstractPropertyEditor) {
			((AbstractPropertyEditor)result).setWidgetFactory(widgetFactory);
			return (AbstractPropertyEditor)result;
		}
		Activator.log.error("impossible to create the editor using id " + id, null);
		return null;
	}

	/**
	 * Creates the property editor descriptor
	 * 
	 * @param editorID
	 *        id of the editor described by this element
	 * @param editorNode
	 *        the configuration node of the editor
	 * @return the configuration descriptor for the property editor
	 */
	public IPropertyEditorDescriptor createPropertyEditorDescriptor(String editorID, Node editorNode) {
		List<IPropertyEditorDescriptor> results = (List<IPropertyEditorDescriptor>)execute(ExecutionStrategy.FORWARD, new CreatePropertyEditorDescriptorOperation(editorID, editorNode));
		if(results == null || results.size()==0) {
			throw new RuntimeException("Impossible to create this property editor: "+editorID);
		} else {
			IPropertyEditorDescriptor descriptor = results.get(0);
			return results.get(0);
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * A descriptor for property editor providers defined by a configuration element.
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
			if(operation instanceof CreatePropertyEditorOperation || operation instanceof CreatePropertyEditorDescriptorOperation) {
				// test if the configuration corresponds to the feature or the id of the operation
				return getProvider().provides(operation);
			}
			return false;
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor#getProvider()
		 */
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof PropertyEditorProvider) {
					PropertyEditorProvider defaultProvider = (PropertyEditorProvider)newProvider;
					defaultProvider.configure(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

}
