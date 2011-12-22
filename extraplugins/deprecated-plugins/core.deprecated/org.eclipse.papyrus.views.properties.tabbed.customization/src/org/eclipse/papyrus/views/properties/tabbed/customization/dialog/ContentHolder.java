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
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.graphics.Image;


/**
 * Object containing the content of the section set descriptor
 */
public class ContentHolder extends LabelProvider implements ITraversableModelElement {

	/** section set state for which this content holder describes content */
	private final SectionSetDescriptorState sectionSetDescriptorState;

	/**
	 * Creates a new ContentHolder.
	 * 
	 * @param sectionSetDescriptorState
	 *        the state of the {@link SectionSetDescriptor} displayed in the configuration area
	 */
	public ContentHolder(SectionSetDescriptorState sectionSetDescriptorState) {
		this.sectionSetDescriptorState = sectionSetDescriptorState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		return Activator.getImage("/icons/Content.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "Content";
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return sectionSetDescriptorState.getSectionDescriptorStates();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		sectionSetDescriptorState.addPropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		sectionSetDescriptorState.removePropertyChangeListener(listener);
	}


	/**
	 * Returns the sectionSetDescriptorState
	 * 
	 * @return the sectionSetDescriptorState
	 */
	public SectionSetDescriptorState getSectionSetDescriptorState() {
		return sectionSetDescriptorState;
	}
}
