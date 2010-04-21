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
package org.eclipse.papyrus.properties.runtime.view;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.IProvider;


/**
 * Interface for Property view providers
 */
public interface IPropertyViewProvider extends IProvider {

	/**
	 * Configures this provider, retrieving the xml file and parsing it.
	 * 
	 * @param element
	 *        the configuration element for this provider
	 */
	public void configure(IConfigurationElement element);

	/**
	 * Returns the view descriptor, given its ID
	 * 
	 * @param descriptorID
	 *        the id of the descriptor to retrieve
	 * @return the found view descriptor or <code>null</code>
	 */
	public ViewDescriptor getViewDescriptor(String descriptorID);


	/**
	 * returns <code>true</code> if this provider can handle the view descriptor specified by its identifier
	 * 
	 * @param descriptorId
	 *        the id of the descriptor
	 * @return <code>true</code> if the provider can handle this view provider
	 */
	public boolean managesViewDescriptor(String descriptorId);

}
