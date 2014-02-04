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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.constraints.runtime.ConstraintsManager;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

/**
 * Handles the extension point org.eclipse.papyrus.views.properties.environment
 * Registers the given Environment models to the Property View framework
 * 
 * @author Camille Letavernier
 */
public class EnvironmentExtensionPoint {

	private final String EXTENSION_ID = "org.eclipse.papyrus.views.properties.environment"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public EnvironmentExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			final String environmentResource = e.getAttribute("environmentModel"); //$NON-NLS-1$
			URI uri = URI.createURI("ppe:/environment/" + e.getContributor().getName() + "/" + environmentResource); //$NON-NLS-1$ //$NON-NLS-2$
			//URI uri = URI.createPlatformPluginURI(e.getContributor().getName() + "/" + environmentResource, true); //$NON-NLS-1$
			try {
				ConfigurationManager.getInstance().addEnvironment(uri);
				ConstraintsManager.instance.addEnvironment(uri); //We also add it to the constraints extension point, which we "extend"
			} catch (IOException ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid " + "extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
			}
		}
	}
}
