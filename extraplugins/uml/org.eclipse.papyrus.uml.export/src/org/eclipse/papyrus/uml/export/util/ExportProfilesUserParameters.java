/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;


// TODO: Auto-generated Javadoc
/**
 * The Class ExportProfilesUserParameters.
 */
public class ExportProfilesUserParameters {

	/** The plugin name. */
	private String pluginName;

	/** The plugin provider. */
	private String pluginProvider;

	/** The plugin version. */
	private String pluginVersion;

	/** The plugin exec environment. */
	private String pluginExecEnvironment;

	/**
	 * Instantiates a new export profiles user parameters.
	 * 
	 * @param pluginName
	 *        the plugin name
	 * @param pluginProvider
	 *        the plugin provider
	 * @param pluginVersion
	 *        the plugin version
	 * @param execEnvironment
	 *        the exec environment
	 */
	public ExportProfilesUserParameters(String pluginName, String pluginProvider, String pluginVersion, String execEnvironment) {
		this.pluginName = pluginName;
		this.pluginProvider = pluginProvider;
		this.pluginVersion = pluginVersion;
		this.pluginExecEnvironment = execEnvironment;

	}


	/**
	 * Gets the plugin name.
	 * 
	 * @return the plugin name
	 */
	public String getPluginName() {
		return pluginName;
	}

	/**
	 * Sets the plugin name.
	 * 
	 * @param pluginName
	 *        the new plugin name
	 */
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	/**
	 * Gets the plugin provider.
	 * 
	 * @return the plugin provider
	 */
	public String getPluginProvider() {
		return pluginProvider;
	}

	/**
	 * Sets the plugin provider.
	 * 
	 * @param pluginProvider
	 *        the new plugin provider
	 */
	public void setPluginProvider(String pluginProvider) {
		this.pluginProvider = pluginProvider;
	}

	/**
	 * Gets the plugin version.
	 * 
	 * @return the plugin version
	 */
	public String getPluginVersion() {
		return pluginVersion;
	}

	/**
	 * Sets the plugin version.
	 * 
	 * @param pluginVersion
	 *        the new plugin version
	 */
	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	/**
	 * Gets the plugin exec environment.
	 * 
	 * @return the plugin exec environment
	 */
	public String getPluginExecEnvironment() {
		return pluginExecEnvironment;
	}

	/**
	 * Sets the plugin exec environment.
	 * 
	 * @param pluginExecEnvironment
	 *        the new plugin exec environment
	 */
	public void setPluginExecEnvironment(String pluginExecEnvironment) {
		this.pluginExecEnvironment = pluginExecEnvironment;
	}




}
