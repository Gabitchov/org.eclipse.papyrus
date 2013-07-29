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

import java.util.List;

/**
 * Interface that should be implemented by all aspect tool factory providers
 */
public interface IAspectToolProviderService {

	/**
	 * Returns the factory, given the id of the factory to return
	 * 
	 * @param id
	 *        the id of the factory to retrieve
	 * @return the found factory or <code>null</code>
	 */
	public IAspectActionProvider getProvider(String id);

	/**
	 * Returns the list of factories present in the workbench
	 * 
	 * @return the list of available factories
	 */
	public List<IAspectActionProvider> getProviders();
}
