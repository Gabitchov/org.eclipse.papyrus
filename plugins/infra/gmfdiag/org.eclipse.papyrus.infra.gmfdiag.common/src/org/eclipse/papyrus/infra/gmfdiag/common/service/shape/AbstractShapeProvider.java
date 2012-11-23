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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;

/**
 * Abstract implementation of the shape provider interface.
 */
public abstract class AbstractShapeProvider extends AbstractProvider implements IShapeProvider {

	/** field for name */
	protected static final String NAME = "name";

	/** field for identifier */
	protected static final String ID = "id";

	/** field for description */
	protected static final String DESCRIPTION = "description";

	/** field for Activator ID */
	protected String bundleId;

	/** name for the factory */
	protected String name;

	/** identifier for the factory */
	protected String id;

	/** description of the factory */
	protected String description;


	/**
	 * Returns the bundle identifier for this provider
	 * 
	 * @return the bundle identifier for this provider
	 */
	public String getBundleId() {
		return bundleId;
	}


	/**
	 * Returns the name of this provider
	 * 
	 * @return the name of this provider
	 */
	public String getName() {
		return name;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return id;
	}


	/**
	 * Returns the description of this provider
	 * 
	 * @return the description of this provider
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @{inheritDoc
	 */
	public boolean provides(IOperation operation) {
		return (operation instanceof GetAllShapeProvidersOperation || operation instanceof GetShapeProviderByIdentifierOperation);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setConfiguration(IConfigurationElement element) {
		name = element.getAttribute(NAME);
		id = element.getAttribute(ID);
		description = element.getAttribute(DESCRIPTION);
		bundleId = element.getContributor().getName();
	}
	
}
