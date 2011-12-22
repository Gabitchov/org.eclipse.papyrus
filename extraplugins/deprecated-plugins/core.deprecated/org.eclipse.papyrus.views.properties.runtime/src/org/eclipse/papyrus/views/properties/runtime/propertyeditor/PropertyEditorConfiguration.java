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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptorFactory;

/**
 * Class that contains the information about a specific editor
 */
public class PropertyEditorConfiguration {

	/** description of the editor */
	protected String description;

	/** Image descriptor of the editor */
	protected ImageDescriptor descriptor;

	/** boolean that indicates if the editor accepts multi-valued properties */
	protected boolean allowMultiValue;

	/** validator for accepted edited types */
	protected IPropertyEditorTypeValidator validator;

	/** identifier of this extension point */
	protected String id;

	/** configuration element that manages this editor */
	protected IConfigurationElement element;

	/** factory used to create property editor descriptors */
	protected IPropertyEditorDescriptorFactory factory;

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
	 * Returns <code>true</code> if the editor can support multi-valued property edition
	 * 
	 * @return <code>true</code> if the editor can support multi-valued property edition
	 */
	public boolean isAllowMultiValue() {
		return allowMultiValue;
	}



	/**
	 * Tells if the editor accepts multi valued properties or not
	 * 
	 * @param allowMultiValue
	 *        the allowMultiValue to set
	 */
	public void setAllowMultiValue(boolean allowMultiValue) {
		this.allowMultiValue = allowMultiValue;
	}

	/**
	 * Returns the validator for types supported by this editor
	 * 
	 * @return the validator for types supported by this editor
	 */
	public IPropertyEditorTypeValidator getValidator() {
		return validator;
	}

	/**
	 * Sets the validator for types supported by this editor
	 * 
	 * @param validator
	 *        the validator for types supported by this editor
	 */
	public void setValidator(IPropertyEditorTypeValidator validator) {
		this.validator = validator;
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

	public static PropertyEditorConfiguration parse(IConfigurationElement element) throws CoreException {
		PropertyEditorConfiguration configuration = new PropertyEditorConfiguration();

		// init the id
		configuration.setId(element.getAttribute("id"));

		// description
		configuration.setDescription(element.getAttribute("description"));

		// multi value
		configuration.setAllowMultiValue(Boolean.getBoolean(element.getAttribute("allowMultiValue")));

		// type validator
		configuration.setValidator((IPropertyEditorTypeValidator)element.createExecutableExtension("typeValidator"));

		// sets the configuration that configures this editor 
		configuration.setElement(element);

		// sets the descriptor factory
		configuration.setDescriptorFactory((IPropertyEditorDescriptorFactory)element.createExecutableExtension("factory"));


		// check everything is valid
		assert configuration.getId() != null : "impossible to get the identifier for the provider " + element.getName();
		assert configuration.getValidator() != null : "impossible to get the validor for the provider " + element.getName();

		return configuration;
	}

	/**
	 * Sets the descriptor factory for this configuration
	 * 
	 * @param factory
	 *        the descriptor factory to set
	 */
	protected void setDescriptorFactory(IPropertyEditorDescriptorFactory factory) {
		this.factory = factory;
	}


	/**
	 * Returns the descriptor factory for this property editor configuration
	 * 
	 * @return the descriptor factory for this property editor configuration
	 */
	public IPropertyEditorDescriptorFactory getDescriptorFactory() {
		return factory;
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
	 * Instanciates the editor. It is not configured at this time, it should not be used as is.
	 * 
	 * @return the editor instanciated
	 * @throws CoreException
	 *         exception thrown when the executable extension could not be created
	 */
	public AbstractPropertyEditor instanciateEditor() throws CoreException {
		return (AbstractPropertyEditor)getElement().createExecutableExtension("class");
	}
}
