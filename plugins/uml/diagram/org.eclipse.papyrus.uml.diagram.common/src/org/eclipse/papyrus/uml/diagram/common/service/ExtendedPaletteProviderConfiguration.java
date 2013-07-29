/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * A provider configuration for the PapyrusPaletteService.
 */
public class ExtendedPaletteProviderConfiguration extends XMLPaletteProviderConfiguration {

	/** name of this contribution */
	private final String bundleID;

	/** ID of this palette contribution */
	private final String path;

	/**
	 * Creates a new <code>ProviderContributionDescriptor</code> instance given
	 * a provider configuration element
	 * 
	 * @param configElement
	 *        The provider XML configuration element
	 */
	protected ExtendedPaletteProviderConfiguration(IConfigurationElement configElement) {
		super(configElement);
		bundleID = configElement.getContributor().getName();
		path = configElement.getAttribute(IPapyrusPaletteConstant.PATH);

		// check that the two variables are not null
		if(bundleID == null) {
			Activator.log.error("Impossible to find the bundle unique identifier for element: " + configElement, null);
		}

		if(path == null) {
			Activator.log.error("Impossible to find thepath to configuration file for element: " + configElement, null);
		}
	}

	/**
	 * Builds a new provider contribution descriptor by parsing its
	 * configuration element
	 * 
	 * @param configElement
	 *        A provider configuration element
	 * @return A provider XML contribution descriptor
	 */
	public static ExtendedPaletteProviderConfiguration parse(IConfigurationElement configElement) {
		Assert.isNotNull(configElement, "null provider configuration element"); //$NON-NLS-1$
		return new ExtendedPaletteProviderConfiguration(configElement);
	}

	/**
	 * Returns the unique identifier of the bundle that contains the
	 * configuration file
	 * 
	 * @return the unique identifier of the bundle that contains the
	 *         configuration file
	 */
	public String getBundleID() {
		return bundleID;
	}

	/**
	 * Returns the path to the file in the bundle
	 * 
	 * @return the path to the file in the bundle
	 */
	public String getPath() {
		return path;
	}

}
