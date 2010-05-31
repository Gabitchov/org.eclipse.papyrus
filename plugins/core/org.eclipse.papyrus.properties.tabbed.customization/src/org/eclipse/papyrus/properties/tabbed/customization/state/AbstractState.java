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
package org.eclipse.papyrus.properties.tabbed.customization.state;

import org.eclipse.swt.graphics.Image;


/**
 * Abstract class for state used to configure the property view
 */
public abstract class AbstractState implements IState, ITraversableModelElement {

	/** key for the event: add an element to the list of children */
	public static final String PROPERTY_ADD_CHILD = "ADD_CHILD_EVENT";

	/** key for the event: remove an element to the list of children */
	public static final String PROPERTY_REMOVE_CHILD = "REMOVE_CHILD_EVENT";

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return getDescriptor().getText();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return getDescriptor().getImage();
	}

}
