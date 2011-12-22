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
package org.eclipse.papyrus.views.properties.runtime.state;

import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;


/**
 * state for {@link IFragmentDescriptor}
 */
public interface IFragmentDescriptorState extends IState, ITraversableModelElement {

	/**
	 * {@inheritDoc}
	 */
	public IFragmentDescriptor getDescriptor();

	/**
	 * returns the list of container descriptor states for this fragment
	 * 
	 * @return the list of container descriptor states for this fragment
	 */
	public List<ContainerDescriptorState> getContainerDescriptorStates();

}
