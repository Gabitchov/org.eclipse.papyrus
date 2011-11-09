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

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;


/**
 * Operation that returns the first provider with given id
 */
public class GetExtendedElementTypeActionProviderOperation implements IOperation {

	/** action configuration for the provider to find */
	private final ActionConfiguration actionConfiguration;

	/**
	 * Creates a new {@link GetExtendedElementTypeActionProviderOperation}.
	 * 
	 * @param actionConfiguration
	 *        action configuration for the provider to find
	 */
	public GetExtendedElementTypeActionProviderOperation(ActionConfiguration actionConfiguration) {
		this.actionConfiguration = actionConfiguration;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(IProvider provider) {
		return provider;
	}

	/**
	 * Returns the action configuration for this operation
	 * 
	 * @return the action configuration for this operation
	 */
	public ActionConfiguration getActionConfiguration() {
		return actionConfiguration;
	}

}
