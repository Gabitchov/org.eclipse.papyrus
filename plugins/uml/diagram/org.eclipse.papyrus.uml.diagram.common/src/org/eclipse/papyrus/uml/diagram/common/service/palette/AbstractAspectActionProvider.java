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
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Abstract class for the aspect action providers
 */
public abstract class AbstractAspectActionProvider extends AbstractProvider implements IAspectActionProvider {

	/** field for name */
	protected static final String NAME = "name";

	/** field for icon path */
	protected static final String ICON = "icon";

	/** field for identifier */
	protected static final String ID = "id";
	
	/** field for description */
	protected static final String DESCRIPTION = "description";

	/** field for Activator ID */
	protected String bundleId ;

	/** name for the factory */
	protected String name;

	/** identifier for the factory */
	protected String id;

	/** description of the factory */
	protected String description;

	/** icon of the factory */
	protected String iconPath;

	/**
	 * @{inheritDoc
	 */
	public boolean provides(IOperation operation) {
		return (operation instanceof GetAllAspectToolProvidersOperation || operation instanceof GetAspectToolProviderOperation);
	}

	/**
	 * @{inheritDoc
	 */
	public String getFactoryId() {
		return id;
	}

	/**
	 * @{inheritDoc
	 */
	public Image getImage() {
		return Activator.getPluginIconImage(bundleId, iconPath);
	}

	/**
	 * @{inheritDoc
	 */
	public String getName() {
		return name;
	}

	/**
	 * @{inheritDoc
	 */
	public void setConfiguration(IConfigurationElement configElement) {
		// retrieve name
		name = configElement.getAttribute(NAME);
		id = configElement.getAttribute(ID);
		iconPath = configElement.getAttribute(ICON);
		description = configElement.getAttribute(DESCRIPTION);
		bundleId = configElement.getContributor().getName();
	}
}
