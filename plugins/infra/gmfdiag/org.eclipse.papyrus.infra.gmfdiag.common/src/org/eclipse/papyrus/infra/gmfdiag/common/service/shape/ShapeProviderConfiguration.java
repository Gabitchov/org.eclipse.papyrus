/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProviderConfiguration;

/**
 * Provider configuration for the shape provider extension point.
 */
public class ShapeProviderConfiguration extends AbstractProviderConfiguration {

	/** field for identifier */
	protected static final String ID = "id";

	/** identifier of the factory */
	protected final String id;

	/**
	 * Creates and builds a new provider contribution descriptor ( <code>ShapeProviderConfiguration</code>) by parsing its configuration
	 * element.
	 * 
	 * @param configElement
	 *        A provider XML configuration element
	 * @return A provider XML contribution descriptor
	 */
	public static ShapeProviderConfiguration parse(IConfigurationElement configElement) {
		Assert.isNotNull(configElement, "null provider configuration element"); //$NON-NLS-1$
		return new ShapeProviderConfiguration(configElement);
	}

	/**
	 * Creates a new <code>ProviderContributionDescriptor</code> instance by
	 * parsing its configuration element.
	 * 
	 * @param configElement
	 *        The provider XML configuration element
	 */
	protected ShapeProviderConfiguration(IConfigurationElement configElement) {
		// retrieve only ID, to test if the factory is the right one before
		// creating whole element
		id = configElement.getAttribute(ID);
		Assert.isNotNull(id, "impossible to get the identifier for the factory");
	}

	/**
	 * Returns the ID of the factory configured by this configuration
	 * 
	 * @return the id of the factory
	 */
	public String getId() {
		return id;
	}

}
