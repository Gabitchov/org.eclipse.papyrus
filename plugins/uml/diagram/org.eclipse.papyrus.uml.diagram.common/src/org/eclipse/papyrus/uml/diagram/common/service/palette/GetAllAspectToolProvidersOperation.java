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

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;

/**
 * Operation to find an aspect tool provider, given its unique identifier
 */
public class GetAllAspectToolProvidersOperation implements IOperation {

	protected List<IAspectActionProvider> providers;

	/**
	 * Creates a new GetAllAspectToolProvidersOperation.
	 */
	protected GetAllAspectToolProvidersOperation(List<IAspectActionProvider> providers) {
		this.providers = providers;
	}

	/**
	 * @{inheritDoc
	 */
	public Object execute(IProvider provider) {
		providers.add((IAspectActionProvider)provider);
		return providers;
	}
}
