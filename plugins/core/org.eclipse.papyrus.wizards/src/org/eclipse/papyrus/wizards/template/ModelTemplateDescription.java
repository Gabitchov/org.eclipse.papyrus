/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.template;

/**
 * The Class ModelTemplateDescription.
 */
public class ModelTemplateDescription {

	/** The name. */
	private String name;

	// private String metamodelURI;
	/** The path. */
	private String path;

	/** The plugin id. */
	private String pluginId;

	/** The language. */
	private String language;

	/**
	 * Instantiates a new model template description.
	 *
	 * @param name the name
	 * @param pluginId the plugin id
	 * @param path the path
	 */
	public ModelTemplateDescription(String name, String pluginId, String path) {
		super();
		this.name = name;
		// this.e = metamodelURI;
		this.path = path;
		this.pluginId = pluginId;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	// /**
	// * @return the metamodelURI
	// */
	// public String getMetamodelURI() {
	// return metamodelURI;
	// }

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		String[] pathParts = path.split("/");
		return pathParts[pathParts.length - 1];
	}

	/**
	 * Gets the plugin id.
	 *
	 * @return the plugin id
	 */
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

}