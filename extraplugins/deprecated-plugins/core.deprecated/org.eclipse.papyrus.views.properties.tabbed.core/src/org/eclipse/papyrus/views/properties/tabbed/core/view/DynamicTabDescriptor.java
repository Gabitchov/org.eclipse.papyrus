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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;


/**
 * Descriptor for tabs used in tabbed properties.
 */
public class DynamicTabDescriptor extends AbstractTabDescriptor {

	/** category of the tab */
	private final String category;

	/** id of the tab */
	private final String id;

	/** label of the tab */
	private final String label;

	/**
	 * Creates a new DynamicTabDescriptor.
	 * 
	 * @param category
	 *        the category of the tab
	 * @param id
	 *        the unique identifier for the tab
	 * @param label
	 *        the label of the tab
	 */
	public DynamicTabDescriptor(String category, String id, String label) {
		this.category = category;
		this.id = id;
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return label;
	}

}
