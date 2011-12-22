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

import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IProvider;

/**
 * Operation to retrieve all available fragment descriptors
 */
public class GetAllFragmentDescriptorsOperation implements IPropertyViewOperation {


	/**
	 * Creates a new GetAllFragmentDescriptorsOperation.
	 */
	public GetAllFragmentDescriptorsOperation() {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, FragmentDescriptor> execute(IProvider provider) {
		if(provider instanceof IPropertyViewProvider) {
			return ((IPropertyViewProvider)provider).getAllFragmentDescriptors();
		}
		return null;
	}


}
