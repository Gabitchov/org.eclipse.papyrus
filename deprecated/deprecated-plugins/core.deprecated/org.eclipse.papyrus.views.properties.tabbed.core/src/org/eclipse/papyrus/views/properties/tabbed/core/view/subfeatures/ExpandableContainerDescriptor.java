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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Creates an expandable container
 */
public class ExpandableContainerDescriptor extends SubFeatureContainerDescriptor {

	/** constant for serialization of the type of container */
	public static final String EXPANDABLE_CONTAINER_TYPE = "expandableContainer";

	/** label of the bar */
	protected final String label;

	/** main composite described by this descriptor */
	protected Section section;

	/**
	 * Creates a new ExpandableContainerDescriptor.
	 * 
	 * @param label
	 *        label of the expandable composite
	 */
	public ExpandableContainerDescriptor(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContainer(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		section = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Composite expandableContainer = widgetFactory.createComposite(section);
		section.setText(label);

		widgetFactory.paintBordersFor(expandableContainer);
		section.setClient(expandableContainer);

		return expandableContainer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disposeContainer() {
		if(section != null && !section.isDisposed()) {
			section.dispose();
			section = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "SubFeature Expandable Container: " + label;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/SubFeatureExpandableContainer.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public ExpandableContainerDescriptorState createState(boolean readOnly) {
		return new ExpandableContainerDescriptorState(this, readOnly);
	}

	/**
	 * Returns the label of the container
	 * 
	 * @return the label of the container
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * state for {@link ExpandableContainerDescriptor}
	 */
	public class ExpandableContainerDescriptorState extends SubFeatureContainerDescriptorState {

		/** label cached by this state */
		private String label;

		/** change support */
		private PropertyChangeSupport changeSupport;

		/**
		 * Creates a new ExpandableContainerDescriptorState.
		 * 
		 * @param descriptor
		 *        the descriptor managed by this state
		 * @param readOnly
		 *        the read only mode
		 */
		public ExpandableContainerDescriptorState(ExpandableContainerDescriptor descriptor, boolean readOnly) {
			super(descriptor, readOnly);

			label = descriptor.getLabel();
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getEditionDialogId() {
			return "SubFeatureExpandableContainerDescriptorStateDialog";
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
		 * {@inheritDoc}
		 */
		public String getText() {
			return "SubFeature Expandable Container: " + label;
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
		@Override
		protected void generateAttributes(Element node, Document document) {
			node.setAttribute("label", label);
			node.setAttribute("type", EXPANDABLE_CONTAINER_TYPE);
		}
	}
}
