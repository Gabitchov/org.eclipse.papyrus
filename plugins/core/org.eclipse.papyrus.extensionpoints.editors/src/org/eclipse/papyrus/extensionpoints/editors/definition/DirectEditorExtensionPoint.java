/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.swt.graphics.Image;

public class DirectEditorExtensionPoint {

	/** Array that stores registered transformations */
	private static DirectEditorExtensionPoint[] configurations;

	/** value of the language attribute */
	private String language;

	/** value of the object to edit attribute */
	private String objectToEdit;

	/** value of the editor configuration attribute */
	private IDirectEditorConfiguration directEditorConfiguration;

	/**
	 * Returns the set of transformations registered in the platform
	 * 
	 * @return the set of transformations registered in the platform
	 */
	public static DirectEditorExtensionPoint[] getDirectEditorConfigurations() {

		// Computed only once
		if (configurations != null) {
			return configurations;
		}

		// It was not already computed,
		// returns the new Collection of DirectEditorExtensionPoint
		List<DirectEditorExtensionPoint> directEditorExtensionPoints = new ArrayList<DirectEditorExtensionPoint>();

		// Reading data from plug-ins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				IDirectEditorConfigurationIds.DIRECT_EDITOR_CONFIGURATION_EXTENSION_ID);

		// Read configuration elements for the current extension
		for (IConfigurationElement configElement : configElements) {
			DirectEditorExtensionPoint proxy = parseDirectEditorConfiguration(configElement);

			if (proxy != null) {
				directEditorExtensionPoints.add(proxy);
			}
		} // end of configElements loop

		configurations = directEditorExtensionPoints.toArray(new DirectEditorExtensionPoint[directEditorExtensionPoints
				.size()]);
		return configurations;
	}

	/**
	 * Retrieves the preferred editor configuration for the specified type
	 * 
	 * @param elementType
	 *            the element type to be edited
	 * @return the preferred editor configuration for the specified type or <code>null</code>
	 */
	public static DirectEditorExtensionPoint getDefautDirectEditorConfiguration(String elementType) {
		// retrieves preference for this element
		String language = Activator.getDefault().getPreferenceStore().getString(
				IDirectEditorsIds.EDITOR_FOR_ELEMENT + elementType);
		if (language == null || IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(language)) {
			return null;
		}
		try {
			Collection<DirectEditorExtensionPoint> configs = getDirectEditorConfigurations(Class.forName(elementType));
			for (DirectEditorExtensionPoint configuration : configs) {
				if (language.equals(configuration.getLanguage())) {
					return configuration;
				}
			}
		} catch (ClassNotFoundException e) {
			Activator.log(e);
		}
		return null;
	}

	/**
	 * Returns the set of transformations registered in the platform for the specified kind of
	 * element
	 * 
	 * @param the
	 *            type of element to be edited
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
		for (DirectEditorExtensionPoint configuration : getDirectEditorConfigurations()) {
			try {
				Class<?> configurationClass = Class.forName(configuration.getObjectToEdit());
				// both class are compatibles ?
				if (configurationClass.isAssignableFrom(elementClass)) {
					elementConfigurations.add(configuration);
				}
			} catch (ClassNotFoundException e) {
				Activator.log(e);
			}
		}
		return elementConfigurations;
	}

	/**
	 * Returns a configuration, given elements from the ConfigurationElement
	 * 
	 * @param configElt
	 *            the element that declares the extension
	 * @return a new configuration, given the information of the specified configElt
	 */
	public static DirectEditorExtensionPoint parseDirectEditorConfiguration(IConfigurationElement configElt) {

		// check that the ConfigElement is a transformation
		if (!IDirectEditorConfigurationIds.TAG_DIRECT_EDITOR_CONFIGURATION.equals(configElt.getName())) {
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
	 *            the configuration element corresponding to the configuration
	 */
	public DirectEditorExtensionPoint(IConfigurationElement configElt) {
		language = getAttribute(configElt, IDirectEditorConfigurationIds.ATT_LANGUAGE, "undefined", true); // should
		// already
		// be
		// a
		// string
		objectToEdit = getAttribute(configElt, IDirectEditorConfigurationIds.ATT_OBJECT_TO_EDIT, "java.lang.Object",
				true); // should already be a string
		directEditorConfiguration = getDirectEditorConfigurationClass(configElt);
		directEditorConfiguration.setLanguage(language);
	}

	protected static IDirectEditorConfiguration getDirectEditorConfigurationClass(IConfigurationElement configElement) {
		IDirectEditorConfiguration configuration = null;
		try {
			configuration = (IDirectEditorConfiguration) configElement
					.createExecutableExtension(IDirectEditorConfigurationIds.ATT_EDITOR_CONFIGURATION);
		} catch (CoreException e) {
			Activator.log(e);
			configuration = new DefaultDirectEditorConfiguration();
		}
		return configuration;
	}

	/**
	 * Returns the value of the attribute that has the given name, for the given configuration
	 * element.
	 * <p>
	 * if the attribute has no value, and if default value is not <code>null</code>, it returns
	 * defaultValue.
	 * <p>
	 * if it has no value, no default value, and if the attribute is required, it throws an
	 * exception.
	 * 
	 * @param defaultValue
	 *            the default value (if exists) of the attribute
	 * @param isRequired
	 *            boolean that indicates if this attribute is required
	 * @param configElt
	 *            configuration element that reflects the content of the extension
	 * @param name
	 *            the name of the attribute to read
	 * @return the attribute value
	 */
	protected static String getAttribute(IConfigurationElement configElt, String name, String defaultValue,
			boolean isRequired) {
		String value = configElt.getAttribute(name);

		if (value != null) {
			return value;
		} else if (defaultValue != null) {
			return defaultValue;
		}

		if (isRequired) {
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
		if (iconPath == null) {
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
	 *            the language edited by this direct editor
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
	 * Sets the type of object to edit
	 * 
	 * @param objectToEdit
	 *            the type of object to edit
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
	 *            the configuration for the dialog window
	 */
	// @unused
	public void setDirectEditorConfiguration(IDirectEditorConfiguration directEditorConfiguration) {
		this.directEditorConfiguration = directEditorConfiguration;
	}
}
