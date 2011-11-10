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
package org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Creates a group container
 */
public class GroupContainerDescriptor extends SubFeatureContainerDescriptor {

	/** constant for serialization of the type of container */
	public static final String GROUP_CONTAINER_TYPE = "groupContainer";

	/** label of the group */
	protected final String label;

	/** composite managed by this descripor */
	private Group composite;

	/**
	 * Creates a new GroupContainerDescriptor.
	 * 
	 * @param label
	 *        label of the group
	 */
	public GroupContainerDescriptor(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContainer(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		composite = widgetFactory.createGroup(parent, label);
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disposeContainer() {
		if(composite != null && !composite.isDisposed()) {
			composite.dispose();
			composite = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "SubFeature Group Container: " + label;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/SubFeatureGroupContainer.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public GroupContainerDescriptorState createState(boolean readOnly) {
		return new GroupContainerDescriptorState(this, readOnly);
	}


	/**
	 * Returns the label
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * state for {@link GroupContainerDescriptor}
	 */
	public class GroupContainerDescriptorState extends SubFeatureContainerDescriptorState {

		/** label cached by this state */
		private String label;

		/** change support */
		private PropertyChangeSupport changeSupport;

		/**
		 * Creates a new GroupContainerDescriptorState.
		 * 
		 * @param descriptor
		 *        the descriptor managed by this state
		 * @param readOnly
		 *        the read only mode
		 */
		public GroupContainerDescriptorState(GroupContainerDescriptor descriptor, boolean readOnly) {
			super(descriptor, readOnly);

			label = descriptor.getLabel();
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getEditionDialogId() {
			return "SubFeatureGroupContainerDescriptorStateDialog";
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void addPropertyChangeListener(PropertyChangeListener listener) {
			changeSupport.addPropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void removePropertyChangeListener(PropertyChangeListener listener) {
			changeSupport.removePropertyChangeListener(listener);
		}

		/**
		 * Returns the label of the descriptor managed by this state
		 * 
		 * @return the label of the descriptor managed by this state
		 */
		public String getLabel() {
			return label;
		}

		/**
		 * Sets the label of the descriptor managed by this state
		 * 
		 * @param label
		 *        the label to set
		 */
		public void setLabel(String label) {
			changeSupport.firePropertyChange("label", this.label, this.label = label);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText() {
			return "SubFeature Group Container: " + label;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void generateAttributes(Element node, Document document) {
			node.setAttribute("label", label);
			node.setAttribute("type", GROUP_CONTAINER_TYPE);
		}
	}
}
