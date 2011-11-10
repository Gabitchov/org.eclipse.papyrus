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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.graphics.Image;


/**
 * Content provider for the configuration area of the content wizard page
 */
public class ConfigurationContentProvider implements ITreeContentProvider, PropertyChangeListener {

	/** current selected sectionsetdescriptorState */
	private SectionSetDescriptorState sectionSetDescriptorState;

	/** current viewer */
	private TreeViewer fViewer;

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
			return new Object[]{ new ConstraintHolder(sectionSetDescriptorState), new ContentHolder(sectionSetDescriptorState) };
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
		fViewer = (TreeViewer)viewer;
		if(newInput instanceof SectionSetDescriptorState) {
			// remove old listeners
			if(sectionSetDescriptorState != null) {
				traverseModel(sectionSetDescriptorState, false);
			}
			// set the new input
			sectionSetDescriptorState = (SectionSetDescriptorState)newInput;

			// add new listeners
			traverseModel(sectionSetDescriptorState, true);
		} else {
			// should remove all listeners
			if(sectionSetDescriptorState != null) {
				traverseModel(sectionSetDescriptorState, false);
			}
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
		} else if(parentElement instanceof ITraversableModelElement) {
			return ((ITraversableModelElement)parentElement).getChildren().toArray();
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
	 * traverse the model to add or remove listeners, given the value of the hook parameter
	 */
	protected void traverseModel(ITraversableModelElement objectToTraverse, boolean isHook) {
		if(objectToTraverse != null) {
			if(isHook) {
				objectToTraverse.removePropertyChangeListener(this);
				objectToTraverse.addPropertyChangeListener(this);
			} else {
				objectToTraverse.removePropertyChangeListener(this);
			}
		}

		if(objectToTraverse.getChildren() != null && !objectToTraverse.getChildren().isEmpty()) {
			for(ITraversableModelElement child : objectToTraverse.getChildren()) {
				traverseModel(child, isHook);
			}
		}
	}

	/**
	 * Object containing the constraints of the section set descriptor
	 */
	protected class ConstraintHolder extends LabelProvider implements ITraversableModelElement {

		/** current section set state descriptor edited */
		private final SectionSetDescriptorState sectionSetDescriptorState;

		/**
		 * Creates a new ConstraintHolder.
		 * 
		 * @param sectionSetDescriptorState
		 */
		public ConstraintHolder(SectionSetDescriptorState sectionSetDescriptorState) {
			this.sectionSetDescriptorState = sectionSetDescriptorState;
		}

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

		/**
		 * {@inheritDoc}
		 */
		public List<? extends ITraversableModelElement> getChildren() {
			return sectionSetDescriptorState.getConstraintDescriptorStates();
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
	}



	/**
	 * {@inheritDoc}
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if(AbstractState.PROPERTY_ADD_CHILD.equals(evt.getPropertyName())) {
			((TreeViewer)fViewer).refresh(evt.getSource(), true);
			traverseModel((ITraversableModelElement)evt.getSource(), true);
			// try to keep a valid expand level
			((TreeViewer)fViewer).expandToLevel(evt.getSource(), 2);
		} else if(AbstractState.PROPERTY_REMOVE_CHILD.equals(evt.getPropertyName())) {
			((TreeViewer)fViewer).refresh(evt.getSource(), true);
			traverseModel((ITraversableModelElement)evt.getSource(), true);
			((TreeViewer)fViewer).expandAll();
		} else {
			((TreeViewer)fViewer).refresh(evt.getSource(), true);
		}

	}
}
