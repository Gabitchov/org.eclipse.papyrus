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
package org.eclipse.papyrus.views.properties.runtime.view.content;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.swt.widgets.Layout;


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
	 * @param readOnly
	 *        read only mode of this state
	 */
	public LayoutDescriptorState(LayoutDescriptor layoutDescriptor, boolean readOnly) {
		super(readOnly);
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

	/**
	 * Creates the layout for the preview
	 * 
	 * @return the layout for the preview
	 */
	public abstract Layout createLayout();

}
