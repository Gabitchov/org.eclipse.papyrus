/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.extension;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.gmfdiag.properties.Activator;
import org.eclipse.papyrus.infra.gmfdiag.properties.modelelement.StyleHandlerProvider;


public class StyleHandlerManager {

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".stylehandler";

	private final List<StyleHandlerProvider> providers;

	private StyleHandlerManager() {
		Map<Integer, StyleHandlerProvider> providersMap = new TreeMap<Integer, StyleHandlerProvider>();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			try {
				StyleHandlerProvider provider = (StyleHandlerProvider)e.createExecutableExtension("provider"); //$NON-NLS-1$
				String priorityString = e.getAttribute("priority");
				int priority = Integer.parseInt(priorityString);
				providersMap.put(priority, provider);
			} catch (NumberFormatException ex) {
				Activator.log.error("The plugin " + e.getContributor() + " provided an invalid extension for " + EXTENSION_ID, ex);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		providers = new LinkedList<StyleHandlerProvider>(providersMap.values());
	}

	public List<StyleHandlerProvider> getStyleHandlerProviders() {
		return providers;
	}

	public static StyleHandlerManager instance = new StyleHandlerManager();
}
