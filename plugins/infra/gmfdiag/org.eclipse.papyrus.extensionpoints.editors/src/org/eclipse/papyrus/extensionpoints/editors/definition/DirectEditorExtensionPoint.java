/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.definition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.constraints.constraints.JavaQuery;
import org.eclipse.swt.graphics.Image;

public class DirectEditorExtensionPoint {

	/** Array that stores registered transformations */
	private static DirectEditorExtensionPoint[] configurations;

	private static DirectEditorRegistry directEditorProvider;

	/** value of the language attribute */
	private String language;

	/** value of the object to edit attribute */
	private String objectToEdit;

	/** value of the editor configuration attribute */
	private IDirectEditorConfiguration directEditorConfiguration;

	private Class objectClassToEdit;

	/** the current priority of the direct editor, can be null **/
	private Integer priority;




	/**
	 * Returns the set of transformations registered in the platform
	 * 
	 * @return the set of transformations registered in the platform
	 */
	public static DirectEditorExtensionPoint[] getDirectEditorConfigurations() {

		// Computed only once
		if(configurations != null) {
			return configurations;
		}

		// It was not already computed,
		// returns the new Collection of DirectEditorExtensionPoint
		List<DirectEditorExtensionPoint> directEditorExtensionPoints = new ArrayList<DirectEditorExtensionPoint>();

		// Reading data from plug-ins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(IDirectEditorConfigurationIds.DIRECT_EDITOR_CONFIGURATION_EXTENSION_ID);

		// Read configuration elements for the current extension
		for(IConfigurationElement configElement : configElements) {
			DirectEditorExtensionPoint proxy = parseDirectEditorConfiguration(configElement);

			if(proxy != null) {
				directEditorExtensionPoints.add(proxy);
			}
		} // end of configElements loop

		configurations = directEditorExtensionPoints.toArray(new DirectEditorExtensionPoint[directEditorExtensionPoints.size()]);
		directEditorProvider = new DirectEditorRegistry();
		directEditorProvider.init(configurations);

		return configurations;
	}

	public static DirectEditorRegistry getDirectEditorProvider() {
		if(directEditorProvider != null) {
			return directEditorProvider;
		} else {
			directEditorProvider = new DirectEditorRegistry();
			directEditorProvider.init(getDirectEditorConfigurations());
			return directEditorProvider;
		}
	}

	/**
	 * Retrieves the preferred editor configuration for the specified type
	 * 
	 * @param class_
	 *        the type of element to edit
	 * @return the preferred editor configuration for the specified type or <code>null</code>
	 */
	public static DirectEditorExtensionPoint getDefautDirectEditorConfiguration(Class class_) {
		// retrieves preference for this element
		String language = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + class_.getCanonicalName());
		if(language == null || IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(language)) {
			return null;
		}

		Collection<DirectEditorExtensionPoint> configs = getDirectEditorConfigurations(class_);
		for(DirectEditorExtensionPoint configuration : configs) {
			if(language.equals(configuration.getLanguage())) {
				return configuration;
			}
		}

		return null;
	}

	/**
	 * Returns the set of transformations registered in the platform for the specified kind of
	 * element
	 * 
	 * @param the
	 *        type of element to be edited
	 * @return the set of transformations registered in the platform for the specified kind of
	 *         element
	 */
	public static Collection<DirectEditorExtensionPoint> getDirectEditorConfigurations(Class<?> elementClass) {
		// list of configuration to be returned. They correspond to
		// configuration to edit the
		// specified type
		final ArrayList<DirectEditorExtensionPoint> elementConfigurations = new ArrayList<DirectEditorExtensionPoint>();

		// check each configuration in the platform and select corresponding
		// ones.
		for(DirectEditorExtensionPoint configuration : getDirectEditorConfigurations()) {
			// both class are compatibles ?
			if(configuration.getObjectClassToEdit() != null) {
				if(configuration.objectClassToEdit.isAssignableFrom(elementClass)) {
					elementConfigurations.add(configuration);
				}
			}
		}
		return elementConfigurations;
	}

	/**
	 * Returns a configuration, given elements from the ConfigurationElement
	 * 
	 * @param configElt
	 *        the element that declares the extension
	 * @return a new configuration, given the information of the specified configElt
	 */
	public static DirectEditorExtensionPoint parseDirectEditorConfiguration(IConfigurationElement configElt) {

		// check that the ConfigElement is a transformation
		if(!IDirectEditorConfigurationIds.TAG_DIRECT_EDITOR_CONFIGURATION.equals(configElt.getName())) {
			return null;
		}
		// this is a transformation, tries to parse extension, and create the
		// java corresponding
		// class
		try {
			return new DirectEditorExtensionPoint(configElt);
		} catch (Exception e) {
			Activator.log(e);
			return null;
		}
	}

	/**
	 * Creates a new DirectEditorExtensionPoint, according to the ConfigurationElement
	 * 
	 * @param configElt
	 *        the configuration element corresponding to the configuration
	 */
	public DirectEditorExtensionPoint(IConfigurationElement configElt) {
		language = getAttribute(configElt, IDirectEditorConfigurationIds.ATT_LANGUAGE, "undefined", true); // should
		// already
		// be
		// a
		// string
		objectToEdit = getAttribute(configElt, IDirectEditorConfigurationIds.ATT_OBJECT_TO_EDIT, "java.lang.Object", true); // should already be a string
		directEditorConfiguration = getDirectEditorConfigurationClass(configElt);
		//the constraint maybe null!

		priority = getPriority(configElt);
		if(directEditorConfiguration == null) {
			directEditorConfiguration = getAdvancedDirectEditorConfigurationClass(configElt);
		}
		// Block added for the case of popup editors		
		if(directEditorConfiguration == null) {
			directEditorConfiguration = getPopupDirectEditorConfigurationClass(configElt);
		}
		directEditorConfiguration.setLanguage(language);


		// retrieve the bundle loader of the plugin that declares the extension
		try {
			String pluginID = configElt.getContributor().getName();
			objectClassToEdit = Platform.getBundle(pluginID).loadClass(objectToEdit);
		} catch (ClassNotFoundException e) {
			Activator.log(e);
		}

	}

	protected static IDirectEditorConfiguration getDirectEditorConfigurationClass(IConfigurationElement configElement) {
		IDirectEditorConfiguration configuration = null;
		try {
			if(configElement.getChildren(IDirectEditorConfigurationIds.TAG_SIMPLE_EDITOR).length > 0) {
				Object config = configElement.getChildren(IDirectEditorConfigurationIds.TAG_SIMPLE_EDITOR)[0].createExecutableExtension(IDirectEditorConfigurationIds.ATT_EDITOR_CONFIGURATION);
				if(config instanceof IDirectEditorConfiguration) {
					configuration = (IDirectEditorConfiguration)config;
				}
			}
		} catch (CoreException e) {
			Activator.log(e);
			configuration = new DefaultDirectEditorConfiguration();
		}
		return configuration;
	}



	/**
	 * Try to load a javaQuery defined in the extension point
	 * 
	 * @param configElement
	 *        the config element see {@link IConfigurationElement}
	 * @return the java query class see {@link JavaQuery}, can return null because this attribute is optional
	 */
	protected static JavaQuery getJavaQueryClass(IConfigurationElement configElement) {
		JavaQuery javaQuery = null;
		try {
			if(configElement.getAttribute(IDirectEditorConfigurationIds.ATT_CONSTRAINT) == null) {
				return null;
			}
			Object config = configElement.createExecutableExtension(IDirectEditorConfigurationIds.ATT_CONSTRAINT);
			if(config instanceof JavaQuery) {
				javaQuery = (JavaQuery)config;
			}
		} catch (CoreException e) {
			Activator.log(e);
		}
		return javaQuery;
	}


	protected static Integer getPriority(IConfigurationElement configElement) {
		IAdvancedEditorConfiguration configuration = null;
		try {
			for(IConfigurationElement childConfigElement : configElement.getChildren(IDirectEditorConfigurationIds.ATT_PRIORITY)) {

				String config = getAttribute(childConfigElement, IDirectEditorConfigurationIds.ATT_PRIORITY_NAME, null, true);
				if(config.equals(IDirectEditorConfigurationIds.PRIORITY_HIGHEST)) {
					return new Integer(0);
				}
				if(config.equals(IDirectEditorConfigurationIds.PRIORITY_HIGH)) {
					return new Integer(1);
				}
				if(config.equals(IDirectEditorConfigurationIds.PRIORITY_MEDIUM)) {
					return new Integer(2);
				}
				if(config.equals(IDirectEditorConfigurationIds.PRIORITY_LOW)) {
					return new Integer(3);
				}
				if(config.equals(IDirectEditorConfigurationIds.PRIORITY_LOWEST)) {
					return new Integer(4);
				}
				System.out.println(config);
			}

		} catch (Exception e) {
			Activator.log.error(e);
			configuration = null;
		}
		return new Integer(5);
	}


	protected static IAdvancedEditorConfiguration getAdvancedDirectEditorConfigurationClass(IConfigurationElement configElement) {
		IAdvancedEditorConfiguration configuration = null;
		try {
			for(IConfigurationElement childConfigElement : configElement.getChildren(IDirectEditorConfigurationIds.TAG_ADVANCED_EDITOR)) {
				for(String attname : childConfigElement.getAttributeNames()) {
					Activator.log.debug(attname);
				}

				Object config = childConfigElement.createExecutableExtension(IDirectEditorConfigurationIds.ATT_EDITOR_CONFIGURATION);
				if(config instanceof IAdvancedEditorConfiguration) {
					configuration = (IAdvancedEditorConfiguration)config;
				}
			}

		} catch (CoreException e) {
			Activator.log.error(e);
			configuration = null;
		}
		return configuration;
	}

	///////////////////////////////// TODO:(done) Method added for the case of popup editors
	protected static IPopupEditorConfiguration getPopupDirectEditorConfigurationClass(IConfigurationElement configElement) {
		IPopupEditorConfiguration configuration = null;
		try {
			for(IConfigurationElement childConfigElement : configElement.getChildren(IDirectEditorConfigurationIds.TAG_POPUP_EDITOR)) {
				for(String attname : childConfigElement.getAttributeNames()) {
					Activator.log.debug(attname);
				}

				Object config = childConfigElement.createExecutableExtension(IDirectEditorConfigurationIds.ATT_EDITOR_CONFIGURATION);
				if(config instanceof IPopupEditorConfiguration) {
					configuration = (IPopupEditorConfiguration)config;
				}
			}

		} catch (CoreException e) {
			Activator.log(e);
			configuration = null;
		}
		return configuration;
	}

	/////////////////////////////////////

	/**
	 * Returns the value of the attribute that has the given name, for the given configuration
	 * element.
	 * <p>
	 * if the attribute has no value, and if default value is not <code>null</code>, it returns defaultValue.
	 * <p>
	 * if it has no value, no default value, and if the attribute is required, it throws an exception.
	 * 
	 * @param defaultValue
	 *        the default value (if exists) of the attribute
	 * @param isRequired
	 *        boolean that indicates if this attribute is required
	 * @param configElt
	 *        configuration element that reflects the content of the extension
	 * @param name
	 *        the name of the attribute to read
	 * @return the attribute value
	 */
	protected static String getAttribute(IConfigurationElement configElt, String name, String defaultValue, boolean isRequired) {
		String value = configElt.getAttribute(name);

		if(value != null) {
			return value;
		} else if(defaultValue != null) {
			return defaultValue;
		}

		if(isRequired) {
			throw new IllegalArgumentException("Missing " + name + " attribute");
		}

		return null;
	}

	/**
	 * Icon getter
	 * 
	 * @return the icon which path is in extension
	 */
	// @unused
	protected Image getImage(String iconPath, IConfigurationElement configElement) {

		// no image associated to this plug-in
		if(iconPath == null) {
			return null;
		}
		IExtension extension = configElement.getDeclaringExtension();
		String extensionPluginId = extension.getContributor().getName();

		return Activator.getImage(extensionPluginId, iconPath);
	}

	/**
	 * Returns the language edited by this direct editor
	 * 
	 * @return the language edited by this direct editor
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language edited by this direct editor
	 * 
	 * @param language
	 *        the language edited by this direct editor
	 */
	// @unused
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Returns the type of object to edit
	 * 
	 * @return the type of object to edit
	 */
	public String getObjectToEdit() {
		return objectToEdit;
	}

	/**
	 * Returns the class of object to edit
	 * 
	 * @return the class of object to edit
	 */
	public Class getObjectClassToEdit() {
		return objectClassToEdit;
	}

	/**
	 * Sets the type of object to edit
	 * 
	 * @param objectToEdit
	 *        the type of object to edit
	 */
	// @unused
	public void setObjectToEdit(String objectToEdit) {
		this.objectToEdit = objectToEdit;
	}

	/**
	 * Returns the configuration for the dialog window
	 * 
	 * @return the configuration for the dialog window
	 */
	public IDirectEditorConfiguration getDirectEditorConfiguration() {
		return directEditorConfiguration;
	}

	/**
	 * Sets the configuration for the dialog window
	 * 
	 * @param directEditorConfiguration
	 *        the configuration for the dialog window
	 */
	// @unused
	public void setDirectEditorConfiguration(IDirectEditorConfiguration directEditorConfiguration) {
		this.directEditorConfiguration = directEditorConfiguration;
	}

	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}


	/**
	 * Sets the priority.
	 * 
	 * @param priority
	 *        the new priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}





}
