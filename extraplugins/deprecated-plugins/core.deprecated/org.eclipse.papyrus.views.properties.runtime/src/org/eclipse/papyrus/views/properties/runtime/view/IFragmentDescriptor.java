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

import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;


/**
 * Interface for all fragment descriptors
 */
public interface IFragmentDescriptor extends IConfigurableDescriptor {

	/**
	 * Returns the list of containers descriptors
	 * 
	 * @return the list of containers descriptors
	 */
	public List<ContainerDescriptor> getContainerDescriptors();

	/**
	 * {@inheritDoc}
	 */
	public IFragmentDescriptorState createState(boolean readOnly);

	/**
	 * Returns the id of the fragment described by the descriptor
	 * 
	 * @return the id of the fragment described by the descriptor
	 */
	public String getId();
}
