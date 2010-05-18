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

import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;

/**
 * State for tab descriptors
 */
public class TabDescriptorState {

	/** tab descriptor managed by this state */
	protected ITabDescriptor tabDescriptor;

	/**
	 * Creates a new TabDescriptorState.
	 * 
	 * @param tabDescriptor
	 *        tab descriptor managed by this state
	 */
	public TabDescriptorState(ITabDescriptor tabDescriptor) {
		this.tabDescriptor = tabDescriptor;
	}


	/**
	 * Returns the tabDescriptor managed by this state
	 * 
	 * @return the tabDescriptor managed by this state
	 */
	public ITabDescriptor getTabDescriptor() {
		return tabDescriptor;
	}
}
