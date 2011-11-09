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
package org.eclipse.papyrus.infra.extendedtypes.providers;

import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;


/**
 * Operation that returns all providers for the {@link ExtendedElementTypeActionService}.
 */
public class GetAllExtendedElementTypeActionProvidersOperation implements IOperation {

	/** list of providers to fill */
	private final List<IExtendedElementTypeActionProvider> providers;

	/**
	 * Creates a new GetAllExtendedElementTypeActionProvidersOperation.
	 * 
	 * @param providers
	 *        the list of providers to fill
	 */
	public GetAllExtendedElementTypeActionProvidersOperation(List<IExtendedElementTypeActionProvider> providers) {
		this.providers = providers;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(IProvider provider) {
		if(provider instanceof IExtendedElementTypeActionProvider) {
			providers.add((IExtendedElementTypeActionProvider)provider);
		}
		return providers;
	}

}
