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

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * descriptor for predefined fragments
 */
public class PredefinedFragmentDescriptor implements IFragmentDescriptor {

	/** id of the predefined descriptor */
	private String predefinedId;

	/** parsing failed */
	private boolean parseFailed = false;

	/** descriptor referenced by this predefined descriptor */
	private IFragmentDescriptor descriptor = null;

	/**
	 * Creates a new PredefinedFragmentDescriptor.
	 * 
	 * @param predefinedId
	 *        the id of the predefined descriptor
	 */
	public PredefinedFragmentDescriptor(String predefinedId) {
		this.predefinedId = predefinedId;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "PredefinedFragment: " + predefinedId;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/PredefinedFragment.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public IFragmentDescriptorState createState(boolean readOnly) {
		return new PredefinedFragmentDescriptorState(this, readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContainerDescriptor> getContainerDescriptors() {
		if(descriptor == null && !parseFailed) {
			// resolve the fragment descriptor if it exists
			descriptor = PropertyViewService.getInstance().getFragmentDescriptor(predefinedId);
			if(descriptor == null) {
				parseFailed = true;
			}
		}

		if(descriptor != null) {
			return descriptor.getContainerDescriptors();
		}
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return predefinedId;
	}

}
