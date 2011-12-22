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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.w3c.dom.Node;

/**
 * Provider for property editors
 */
public class PropertyEditorProvider extends AbstractProvider {

	/** map that stores the mapping id -> editor class */
	private Map<String, PropertyEditorConfiguration> editors = new HashMap<String, PropertyEditorConfiguration>();

	/**
	 * Creates the property editor managed by this provider
	 * 
	 * @param editorIdentifier
	 *        the identifier of the editor to create
	 * @param controller
	 *        the controller that manages the created property editor
	 * 
	 * @return the property editor managed by this provider
	 */
	public AbstractPropertyEditor createPropertyEditor(String editorIdentifier, PropertyEditorController controller) {
		// retrieve property class managed by this provider
		try {
			PropertyEditorConfiguration configuration = editors.get(editorIdentifier);
			if(configuration == null) {
				Activator.log.error("impossible to find the configuration for editor " + editorIdentifier, null);
				return null;
			}
			Object editor = configuration.instanciateEditor();
			if(editor instanceof AbstractPropertyEditor) {
				((AbstractPropertyEditor)editor).setController(controller);
				return (AbstractPropertyEditor)editor;
			}
		} catch (CoreException e) {
			e.printStackTrace();
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Configures the provider given the extension point that declares it.
	 * 
	 * @param providerConfiguration
	 *        the configuration element that declares the provider
	 */
	public void configure(IConfigurationElement providerConfiguration) {
		try {
			// for each property editors defined in the provider, retrieves important information
			for(IConfigurationElement element : providerConfiguration.getChildren()) {
				// check this child is really configuring editors (not a Priority child...)
				if("PropertyEditor".equals(element.getName())) {
					// parse this editor configuration
					PropertyEditorConfiguration configuration = PropertyEditorConfiguration.parse(element);
					editors.put(configuration.getId(), configuration);
				}
			}
		} catch (CoreException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Creates the descriptor for the editor with the given id
	 * 
	 * @param editorID
	 *        the identifier of the editor
	 * @param editorNode
	 *        the configuration node
	 * @return the descriptor for the editor with the given id
	 */
	public IPropertyEditorDescriptor createPropertyEditorDescriptor(String editorID, Node editorNode) {
		PropertyEditorConfiguration configuration = editors.get(editorID);
		if(configuration != null) {
			return configuration.getDescriptorFactory().createEditorDescriptor(editorNode);
		}
		return null;
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreatePropertyEditorOperation) {
			CreatePropertyEditorOperation createPropertyEditorOperation = (CreatePropertyEditorOperation)operation;

			// test if the configuration corresponds to the feature or the id of the operation
			// first test the id (specific editor) 
			// then test the feature

			String operationIdentifier = createPropertyEditorOperation.getEditorIdentifier();
			return editors.containsKey(operationIdentifier);
		}

		if(operation instanceof CreatePropertyEditorDescriptorOperation) {
			CreatePropertyEditorDescriptorOperation editorDescriptorOperation = (CreatePropertyEditorDescriptorOperation)operation;
			return editors.containsKey(editorDescriptorOperation.getEditorId());
		}
		return false;
	}

}
