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
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;

/**
 * Operation to find a shape provider, given its unique identifier
 */
public class GetShapeProviderByIdentifierOperation implements IOperation, IShapeProviderOperation {

	/** id of the action to retrieve */
	private final String identifier;

	/**
	 * Creates a new GetShapeProviderOperation.
	 * 
	 * @param identifier
	 *        the identifier of the operation to retrieve
	 */
	protected GetShapeProviderByIdentifierOperation(String identifier) {
		assert null != identifier : "GetAspectToolOperation constructor received NULL as argument"; //$NON-NLS-1$

		this.identifier = identifier;
	}

	/**
	 * @{inheritDoc
	 */
	public IProvider execute(IProvider provider) {
		String id = ((IShapeProvider)provider).getId();
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
