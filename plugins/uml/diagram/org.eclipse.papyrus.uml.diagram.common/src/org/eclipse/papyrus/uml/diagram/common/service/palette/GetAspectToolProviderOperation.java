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

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;

/**
 * Operation to find an aspect tool provider, given its unique identifier
 */
public class GetAspectToolProviderOperation implements IOperation {

	/** id of the action to retrieve */
	private final String identifier;

	/**
	 * Creates a new GetAspectToolProviderOperation.
	 * 
	 * @param identifier
	 *        the identifier of the operation to retrieve
	 */
	protected GetAspectToolProviderOperation(String identifier) {
		assert null != identifier : "GetAspectToolOperation constructor received NULL as argument"; //$NON-NLS-1$

		this.identifier = identifier;
	}

	/**
	 * @{inheritDoc
	 */
	public Object execute(IProvider provider) {
		String id = ((IAspectActionProvider)provider).getFactoryId();
		return (identifier.equals(id) ? provider : null);
	}

	/**
	 * Returns the identifier of the provider this operation is looking for
	 * 
	 * @return the identifier of the provider this operation is looking for
	 */
	public String getIdentifier() {
		return identifier;
	}
}
