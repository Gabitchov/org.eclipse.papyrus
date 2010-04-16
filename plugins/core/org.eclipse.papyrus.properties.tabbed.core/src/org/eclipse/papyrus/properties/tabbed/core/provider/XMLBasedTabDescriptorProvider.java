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
package org.eclipse.papyrus.properties.tabbed.core.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.properties.tabbed.core.view.PropertyViewService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;


/**
 * Provider for {@link ITabDescriptor} published in the xml file for properties view.
 */
public class XMLBasedTabDescriptorProvider implements ITabDescriptorProvider {

	/** list of available tab descriptors */
	protected ITabDescriptor[] descriptors = null;

	/**
	 * {@inheritDoc}
	 */
	public ITabDescriptor[] getTabDescriptors(IWorkbenchPart part, ISelection selection) {
		if(descriptors == null) {
			List<ITabDescriptor> descriptors = new ArrayList<ITabDescriptor>();

			List<List<ITabDescriptor>> list = (List<List<ITabDescriptor>>)PropertyViewService.getInstance().getTabDescriptors();
			for(List<ITabDescriptor> sub : list) {
				descriptors.addAll((List<ITabDescriptor>)sub);
			}
			this.descriptors = descriptors.toArray(new ITabDescriptor[descriptors.size()]);
		}
		return descriptors;
	}
}
