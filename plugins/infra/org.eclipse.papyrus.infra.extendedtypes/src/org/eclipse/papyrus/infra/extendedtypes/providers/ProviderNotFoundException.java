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

import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;


/**
 * Exception thrown when a provider was not found
 */
public class ProviderNotFoundException extends Exception {

	/** serial UID */
	private static final long serialVersionUID = 8919294410894098831L;

	/**
	 * Constructor.
	 * 
	 * @param configuration
	 *        the configuration for which a provider was searched
	 * 
	 */
	public ProviderNotFoundException(ActionConfiguration configuration) {
		super();
	}

}
