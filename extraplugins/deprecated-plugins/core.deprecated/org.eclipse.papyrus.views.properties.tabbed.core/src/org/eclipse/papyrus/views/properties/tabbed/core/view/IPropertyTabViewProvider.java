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

import java.util.List;

import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;


/**
 * Interface for Tabbed property view providers
 */
public interface IPropertyTabViewProvider {

	/**
	 * Returns the list of tab descriptors for tab described in the configuration file
	 * 
	 * @return the list of tab descriptors for tab described in the configuration file or an empty list
	 */
	public List<ITabDescriptor> getTabDescriptors();
}
