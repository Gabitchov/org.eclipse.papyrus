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
package org.eclipse.papyrus.views.properties.runtime.view;

import org.eclipse.gmf.runtime.common.core.service.IProvider;


/**
 * Operation to retrieve a fragment descriptor using its ID
 */
public class GetFragmentDescriptorOperation implements IPropertyViewOperation {

	/** id of the view descriptor to retrieve */
	protected final String descriptorID;

	/**
	 * Creates a new GetFragmentDescriptorOperation.
	 * 
	 * @param descriptorID
	 *        the identifier of the fragment descriptor to create
	 */
	public GetFragmentDescriptorOperation(String descriptorID) {
		this.descriptorID = descriptorID;
	}

	/**
	 * Returns the descriptor id for this operation
	 * 
	 * @return the descriptor id for this operation
	 */
	public String getDescriptorID() {
		return descriptorID;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(IProvider provider) {
		if(provider instanceof IPropertyViewProvider) {
			return ((IPropertyViewProvider)provider).getFragmentDescriptor(descriptorID);
		}
		return null;
	}

}
