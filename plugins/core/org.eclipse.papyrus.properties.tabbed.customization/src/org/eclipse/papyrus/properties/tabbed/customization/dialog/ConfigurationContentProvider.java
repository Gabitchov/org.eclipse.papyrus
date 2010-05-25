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
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.state.ContainerDescriptorState;
import org.eclipse.papyrus.properties.tabbed.customization.state.FragmentDescriptorState;
import org.eclipse.papyrus.properties.tabbed.customization.state.SectionDescriptorState;
import org.eclipse.papyrus.properties.tabbed.customization.state.SectionSetDescriptorState;
import org.eclipse.swt.graphics.Image;


/**
 * Content provider for the configuration area of the content wizard page
 */
public class ConfigurationContentProvider implements ITreeContentProvider {

	/** current selected sectionsetdescriptorState */
	private SectionSetDescriptorState sectionSetDescriptorState;

	/**
	 * Creates a new ConfigurationContentProvider.
	 */
	public ConfigurationContentProvider() {
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof SectionSetDescriptorState) {
			return new Object[]{ new ConstraintHolder(), new ContentHolder() };
		}
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// nothing here
		if(newInput instanceof SectionSetDescriptorState) {
			sectionSetDescriptorState = (SectionSetDescriptorState)newInput;
		} else {
			sectionSetDescriptorState = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		// assert section set descriptor set is not null
		if(sectionSetDescriptorState == null) {
			return new Object[0];
		}
		if(parentElement instanceof ConstraintHolder) {
			return sectionSetDescriptorState.getConstraintDescriptorStates().toArray();
		} else if(parentElement instanceof ContentHolder) {
			return sectionSetDescriptorState.getSectionDescriptorStates().toArray();
		} else if(parentElement instanceof SectionDescriptorState) {
			return ((SectionDescriptorState)parentElement).getFragmentDescriptorStates().toArray();
		} else if(parentElement instanceof FragmentDescriptorState) {
			return ((FragmentDescriptorState)parentElement).getContainerDescriptorStates().toArray();
		} else if(parentElement instanceof ContainerDescriptorState) {
			return ((ContainerDescriptorState)parentElement).getControllerDescriptorStates().toArray();
		}
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	/**
	 * Object containing the constraints of the section set descriptor
	 */
	protected class ConstraintHolder extends LabelProvider {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage(Object element) {
			return Activator.getImage("/icons/Constraints.gif");
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			return "Constraints";
		}

	}

	/**
	 * Object containing the content of the section set descriptor
	 */
	protected class ContentHolder extends LabelProvider {

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
	}

}
