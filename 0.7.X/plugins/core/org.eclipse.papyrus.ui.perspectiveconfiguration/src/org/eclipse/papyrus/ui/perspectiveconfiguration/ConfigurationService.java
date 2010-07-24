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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.ui.perspectiveconfiguration;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Take information form the extension point in order to configure Papyrus.
 */
public class ConfigurationService {

	public static String PERSPECTIVE_CONFIGURATION_EXTENSION_POINT_ID = "org.eclipse.papyrus.ui.perspectiveconfiguration";

	public static String PERPSECTIVE_ID = "perspectiveID";

	public static String ACTION_SET = "actionSet";

	public static String ACTION_SET_ID = "actionSetID";

	public static String MENU = "menu";

	public static String MENU_ID = "menuID";

	public static String TOOLBAR = "toolbar";

	public static String TOOLBAR_ID = "toolbarID";

	public static String PREFERENCEPAGE = "preferencePage";

	public static String PREFERENCEPAGEID = "preferencepageID";

	public static String CATEGORY = "category";

	public static String CATEGORYID = "categoryID";

	public static String COMMAND = "command";

	public static String COMMANDID = "commandID";


	protected HashMap<String, Configuration> configurationMap = new HashMap<String, Configuration>();

	public ConfigurationService() {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(PERSPECTIVE_CONFIGURATION_EXTENSION_POINT_ID);
		for(int i = 0; i < configElements.length; i++) {
			constructAConfiguation(configElements[i]);
		}
	}

	protected void constructAConfiguation(IConfigurationElement iConfigurationElement) {
		try {
			String configName = (String)iConfigurationElement.getAttribute(PERPSECTIVE_ID);
			Configuration configuration = new Configuration(configName);
			IConfigurationElement[] actionSetList = iConfigurationElement.getChildren();
			IConfigurationElement[] element = iConfigurationElement.getChildren(ACTION_SET);
			for(int i = 0; i < element.length; i++) {
				configuration.addActionSet(element[i].getAttribute(ACTION_SET_ID));
			}
			element = iConfigurationElement.getChildren(MENU);
			for(int i = 0; i < element.length; i++) {
				configuration.addMenu(element[i].getAttribute(MENU_ID));
			}
			element = iConfigurationElement.getChildren(TOOLBAR);
			for(int i = 0; i < element.length; i++) {
				configuration.addtoolBar(element[i].getAttribute(TOOLBAR_ID));
			}
			element = iConfigurationElement.getChildren(PREFERENCEPAGE);
			for(int i = 0; i < element.length; i++) {
				configuration.addPreference(element[i].getAttribute(PREFERENCEPAGEID));
			}
			element = iConfigurationElement.getChildren(CATEGORY);
			for(int i = 0; i < element.length; i++) {
				configuration.addCategory(element[i].getAttribute(CATEGORYID));
			}

			element = iConfigurationElement.getChildren(COMMAND);
			for(int i = 0; i < element.length; i++) {
				configuration.addCommandID(element[i].getAttribute(COMMANDID));
			}
			configurationMap.put(configName, configuration);
		} catch (Exception e) {
			Activator.log.error("- " + iConfigurationElement + " can not be loaded ", e);
		}
	}

	/**
	 * 
	 * @return a set of perspective id that has a configuration
	 */
	protected Set<String> getPerspectiveList() {
		return configurationMap.keySet();
	}

	/**
	 * get a configuration from a perspective ID
	 * 
	 * @param perspectiveID
	 * @return a configuration or null if a configuration is not defined for the given perspective ID
	 */
	protected Configuration getConfiguration(String perspectiveID) {
		return configurationMap.get(perspectiveID);
	}
}
