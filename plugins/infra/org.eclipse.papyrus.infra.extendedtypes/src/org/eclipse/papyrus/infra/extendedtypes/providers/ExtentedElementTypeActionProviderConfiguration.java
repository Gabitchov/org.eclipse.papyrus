/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.providers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProviderConfiguration;

/**
 * Provider configuration for the aspect tool factory extension point.
 */
public class ExtentedElementTypeActionProviderConfiguration extends AbstractProviderConfiguration {

	/** field for provider class name */
	protected static final String CLASS = "class";

	/** field for configuration class name */
	private static final String CONFIGURATION_CLASS = "configurationClass";

	/** class name of the provider */
	protected final String className;

	/** class name of the configuration */
	private final String configurationClassName;

	/**
	 * Creates and builds a new provider contribution descriptor by parsing its configuration element.
	 * 
	 * @param configElement
	 *        A provider XML configuration element
	 * @return A provider XML contribution descriptor
	 */
	public static ExtentedElementTypeActionProviderConfiguration parse(IConfigurationElement configElement) {
		Assert.isNotNull(configElement, "null provider configuration element"); //$NON-NLS-1$
		return new ExtentedElementTypeActionProviderConfiguration(configElement);
	}

	/**
	 * Creates a new <code>ProviderContributionDescriptor</code> instance
	 * by parsing its configuration element.
	 * 
	 * @param configElement
	 *        The provider XML configuration element
	 */
	protected ExtentedElementTypeActionProviderConfiguration(IConfigurationElement configElement) {
		// retrieve only ID, to test if the factory is the right one before creating whole element
		className = configElement.getAttribute(CLASS);
		Assert.isNotNull(className, "impossible to get the class name for the provider");

		configurationClassName = configElement.getAttribute(CONFIGURATION_CLASS);
		Assert.isNotNull(className, "impossible to get the class name for the provider");
	}


	/**
	 * Returns the class name of the provider configured by this configuration
	 * 
	 * @return the id of the factory
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Name of the configuration class
	 * 
	 * @return the configuration Class Name
	 */
	public String getConfigurationClassName() {
		return configurationClassName;
	}

}
