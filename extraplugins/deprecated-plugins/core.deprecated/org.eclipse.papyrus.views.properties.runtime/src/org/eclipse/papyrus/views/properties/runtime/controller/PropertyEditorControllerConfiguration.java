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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptorFactory;
import org.osgi.framework.Bundle;
import org.w3c.dom.Node;

/**
 * Class that contains the information about a specific controller
 */
public class PropertyEditorControllerConfiguration {

	/** description of the editor */
	protected String description;

	/** Image descriptor of the editor */
	protected ImageDescriptor descriptor;

	/** identifier of this extension point */
	protected String id;

	/** configuration element that manages this editor */
	protected IConfigurationElement element;

	/** factory used to create controller descriptors */
	private IPropertyEditorControllerDescriptorFactory factory;

	/**
	 * Sets the element that configures the editor
	 * 
	 * @param element
	 *        the element to set
	 */
	protected void setElement(IConfigurationElement element) {
		this.element = element;
	}

	/**
	 * Returns the element that configures the editor
	 * 
	 * @return the element that configures the editor
	 */
	protected IConfigurationElement getElement() {
		return element;
	}

	/**
	 * Returns the description of the editor
	 * 
	 * @return the description of the editor
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of this editor
	 * 
	 * @param description
	 *        the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the image descriptor of the preview of the editor
	 * 
	 * @return the image descriptor of the preview of the editor
	 */
	public ImageDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * Sets the image descriptor of the editor preview
	 * 
	 * @param descriptor
	 *        the descriptor to set
	 */
	public void setDescriptor(ImageDescriptor descriptor) {
		this.descriptor = descriptor;
	}


	/**
	 * parses the configuration element and returns an editor configuration
	 * 
	 * @param element
	 *        the configuration element to parse
	 * @return the created editor configuration
	 * @throws CoreException
	 *         the validator was not successfully initialized
	 */
	public static PropertyEditorControllerConfiguration parse(IConfigurationElement element) throws CoreException {
		PropertyEditorControllerConfiguration configuration = new PropertyEditorControllerConfiguration();

		// init the id
		configuration.setId(element.getAttribute("id"));

		// description
		configuration.setDescription(element.getAttribute("description"));

		// sets the configuration that configures this editor 
		configuration.setElement(element);

		configuration.setDescriptorFactory((IPropertyEditorControllerDescriptorFactory)element.createExecutableExtension("factory"));

		// check everything is valid
		assert configuration.getId() != null : "impossible to get the identifier for the provider " + element.getName();

		return configuration;
	}

	/**
	 * Sets the factory used to create descriptors
	 * 
	 * @param factory
	 *        the factory used to create descriptors
	 */
	public void setDescriptorFactory(IPropertyEditorControllerDescriptorFactory factory) {
		assert (factory != null) : "factory should not be null for configuration " + getId();
		this.factory = factory;
	}

	/**
	 * Sets the identifier for this configuration
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the id of this configuration
	 * 
	 * @return the id of this configuration
	 */
	public String getId() {
		return id;
	}

	/**
	 * Instantiates the controller.
	 * 
	 * @return the controller instantiated
	 * @throws CoreException
	 *         exception thrown when something went wrong during creation of the controller
	 */
	public PropertyEditorController instanciateController() throws CoreException {
		return (PropertyEditorController)getElement().createExecutableExtension("class");
	}

	/**
	 * Generates the descriptor for the given configuration node
	 * 
	 * @param controllerNode
	 *        the configuration node of the controller
	 * @param bundle
	 *        the bundle used to load classes
	 * @return the configured descriptor
	 */
	public IPropertyEditorControllerDescriptor createControllerDescriptor(Node controllerNode, Bundle bundle) {
		return factory.createDescriptor(controllerNode, bundle);
	}
}
