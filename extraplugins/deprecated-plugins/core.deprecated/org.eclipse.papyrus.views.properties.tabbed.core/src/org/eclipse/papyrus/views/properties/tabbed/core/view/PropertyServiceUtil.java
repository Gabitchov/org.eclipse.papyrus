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

import java.util.List;

import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;


/**
 * Util class for {@link PropertyViewService}
 */
public class PropertyServiceUtil {

	/**
	 * Returns the tab descriptors for the property view service
	 * 
	 * @return the tab descriptors for the property view service
	 */
	@SuppressWarnings("unchecked")
	public static List<List<ITabDescriptor>> getTabDescriptors() {
		return ExecutionStrategy.REVERSE.execute(PropertyViewService.getInstance(), new GetTabDescriptorsFromConfiguration());
	}

}
