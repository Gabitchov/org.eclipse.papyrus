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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.swt.graphics.Image;


/**
 * Descriptor for model handler factories
 */
public class ModelHandlerFactoryDescriptor {

	/** default description label */
	protected static final String DEFAULT_DESCRIPTION = "";

	/** name of the described model handler */
	protected final String name;

	/** id of the described model handler */
	protected final String id;

	/** description of the described model handler */
	protected final String description;

	/** plugin-relative path to the icon */
	protected final String iconPath;

	/** id of the plugin that contributes to this descriptor */
	protected final String pluginId;

	/** name of the class implementing the model handler factory */
	// protected final String className;

	/** configuration element */
	protected IConfigurationElement element;

	/** implementation class of the factory (lazy initialization) */
	protected IPropertyModelHandlerFactory factory;

	/** boolean that indicates that instantiating the factory crashed */
	private boolean parseFailed = false;

	/** attribute: name */
	public static String ATTRIBUTE_NAME = "name";

	/** attribute: description */
	public static String ATTRIBUTE_DESCRIPTION = "description";

	/** attribute: id */
	public static String ATTRIBUTE_ID = "id";

	/** attribute: icon */
	public static String ATTRIBUTE_ICON = "icon";

	/** attribute: class name */
	public static String ATTRIBUTE_CLASS_NAME = "class";

	/**
	 * Creates a new ModelHandlerFactoryDescriptor.
	 * 
	 * @param element
	 *        the configuration element that configures this descriptor
	 */
	public ModelHandlerFactoryDescriptor(IConfigurationElement element) {
		// create model handler factory descriptors from the extension points
		// retrieve information from the configuration element
		name = element.getAttribute(ATTRIBUTE_NAME);
		id = element.getAttribute(ATTRIBUTE_ID);
		// className = element.getAttribute(ATTRIBUTE_CLASS_NAME);
		String tmpDesc = element.getAttribute(ATTRIBUTE_DESCRIPTION);
		description = (tmpDesc != null) ? tmpDesc : DEFAULT_DESCRIPTION;
		iconPath = element.getAttribute(ATTRIBUTE_ICON);
		pluginId = element.getContributor().getName();
		this.element = element;
	}


	/**
	 * Returns the name of the model handler
	 * 
	 * @return the name of the model handler
	 */
	public String getName() {
		return name;
	}


	/**
	 * Returns the description of the model handler
	 * 
	 * @return the description of the model handler
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Returns the id of this model handler
	 * 
	 * @return the id of this model handler
	 */
	public String getId() {
		return id;
	}


	/**
	 * Returns the iconPath
	 * 
	 * @return the iconPath
	 */
	public Image getImage() {
		return Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(pluginId, iconPath));
	}

	/**
	 * Returns the factory described by this configuration element
	 * 
	 * @return the factory described by this configuration element
	 */
	public IPropertyModelHandlerFactory getModelHandlerFactory() {
		if(factory == null && !parseFailed) {
			try {
				factory = (IPropertyModelHandlerFactory)element.createExecutableExtension(ATTRIBUTE_CLASS_NAME);
			} catch (CoreException e) {
				Activator.log.error(e);
				parseFailed = true;
			}
		}
		return factory;
	}
}
