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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.views.properties.runtime.view.IPropertyViewOperation;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;


/**
 * Retrieves the list of tab descriptors for the papyrus property view
 */
public class GetTabDescriptorsFromConfiguration implements IPropertyViewOperation {

	/**
	 * {@inheritDoc}
	 */
	public List<ITabDescriptor> execute(IProvider provider) {
		if(provider instanceof IPropertyTabViewProvider) {
			return ((IPropertyTabViewProvider)provider).getTabDescriptors();
		}
		return Collections.emptyList();
	}
}
