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
package org.eclipse.papyrus.properties.runtime.view.content;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;


/**
 * State for {@link LayoutDescriptor}
 */
public abstract class LayoutDescriptorState extends AbstractState {

	/** descriptor managed by this state */
	private final LayoutDescriptor layoutDescriptor;

	/**
	 * Creates a new LayoutDescriptorState.
	 * 
	 * @param layoutDescriptor
	 *        managed descriptor
	 */
	public LayoutDescriptorState(LayoutDescriptor layoutDescriptor) {
		this.layoutDescriptor = layoutDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public LayoutDescriptor getDescriptor() {
		return layoutDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

}
