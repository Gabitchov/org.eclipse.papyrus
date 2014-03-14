/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration;


/**
 * Represents a Papyrus viewpoints configuration associated to a priority
 * 
 * @author Laurent Wouters
 */
public class WeightedConfiguration {
	/**
	 * ID of the extension point defining the configurations
	 */
	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.viewpoints.policy.custom";

	private String uri;
	private int priority;
	private PapyrusConfiguration config;

	/**
	 * Gets the URI of the is configuration
	 * 
	 * @return The configuration's URI
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * Gets the Papyrus configuration represented by this object
	 * 
	 * @return A Papyrus Configuration
	 */
	public PapyrusConfiguration getConfiguration() {
		if (this.config == null)
			this.config = PolicyChecker.loadConfigurationFrom(uri);
		return this.config;
	}

	/**
	 * Initializes the configuration from the given configuration element
	 * 
	 * @param config
	 *            The extension point configuration element
	 */
	private WeightedConfiguration(String plugin, IConfigurationElement config) {
		this.uri = config.getAttribute("file");
		if (!this.uri.startsWith(PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE))
			this.uri = PreferenceConstants.P_CONF_PATH_SCHEME_PLUGIN_VALUE + plugin + "/" + this.uri;
		try {
			this.priority = Integer.parseInt(config.getAttribute("priority"));
		} catch (NumberFormatException ex) {
		}
	}


	/**
	 * Represents a comparator for weighted configurations
	 * 
	 * @author Laurent Wouters
	 */
	private static class Comparator implements java.util.Comparator<WeightedConfiguration>, Serializable {
		/**
		 * Serial version
		 */
		private static final long serialVersionUID = 9025582514350440832L;

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(WeightedConfiguration o1, WeightedConfiguration o2) {
			return (o2.priority - o1.priority);
		}
	}

	/**
	 * Gets the configuration with the top priority
	 * 
	 * @return The appropriate configuration, or <code>null</code> if none was found
	 */
	public static WeightedConfiguration getTopConfiguration() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EXTENSION_ID);
		IExtension[] extensions = point.getExtensions();

		List<WeightedConfiguration> configs = new ArrayList<WeightedConfiguration>();
		for (int i = 0; i != extensions.length; i++) {
			String plugin = extensions[i].getContributor().getName();
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j != elements.length; j++)
				if (elements[j].getName().equals("configuration"))
					configs.add(new WeightedConfiguration(plugin, elements[j]));
		}
		Collections.sort(configs, new Comparator());
		if (configs.size() == 0)
			return null;
		return configs.get(0);
	}
}
