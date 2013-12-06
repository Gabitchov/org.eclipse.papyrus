/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.extensions;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

/**
 * Handles the extension point org.eclipse.papyrus.views.properties.context
 * Registers the given Context models to the Property View framework
 * 
 * @author Camille Letavernier
 */
public class ContextExtensionPoint {

	private final String EXTENSION_ID = "org.eclipse.papyrus.views.properties.context"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public ContextExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			try {
				final String contextResource = e.getAttribute("contextModel"); //$NON-NLS-1$

				final boolean isCustomizable;
				if(Arrays.asList(e.getAttributeNames()).contains("isCustomizable")) {
					isCustomizable = Boolean.parseBoolean(e.getAttribute("isCustomizable")); //$NON-NLS-1$
				} else {
					isCustomizable = true; //Default value
				}
				URI uri = URI.createURI("ppe:/context/" + e.getContributor().getName() + "/" + contextResource); //$NON-NLS-1$ //$NON-NLS-2$
				//URI uri = URI.createPlatformPluginURI(e.getContributor().getName() + "/" + contextResource, true); //$NON-NLS-1$

				ConfigurationManager.getInstance().addContext(uri, isCustomizable);
			} catch (IOException ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}
}
