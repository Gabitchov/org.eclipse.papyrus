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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Descriptor for the folder containers
 */
public class ExpandableContainerDescriptor extends ContainerDescriptor {

	/** label for the folder */
	private final String label;

	/** composite content of the expandable container */
	protected Composite expandableContainer;

	/**
	 * Creates a new ExpandableContainerDescriptor
	 * 
	 * @param layoutDescriptor
	 *        the layoutDescriptor applied to the container
	 * @param label
	 *        the label of the created composite
	 * @param containerNode
	 *        the unparsed xml configuration node for this container
	 */
	public ExpandableContainerDescriptor(LayoutDescriptor layoutDescriptor, String label, Node containerNode) {
		super(layoutDescriptor, containerNode);
		this.label = label;
	}

	/**
	 * Creates a new ExpandableContainerDescriptor
	 * 
	 * @param layoutDescriptor
	 *        the layoutDescriptor applied to the container
	 * @param label
	 *        the label of the created composite
	 * @param descriptors
	 *        the list of {@link IPropertyEditorControllerDescriptor} contained by this container
	 */
	public ExpandableContainerDescriptor(LayoutDescriptor layoutDescriptor, String label, List<IPropertyEditorControllerDescriptor> descriptors) {
		super(layoutDescriptor, descriptors);
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpandableComposite getDescribedComposite() {
		return (ExpandableComposite)super.getDescribedComposite();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PropertyEditorController> createContent(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, List<Object> objectsToEdit) {
		this.objectsToEdit = objectsToEdit;
		if(getDescribedComposite() == null || getDescribedComposite().isDisposed()) {
			setDescribedComposite(widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED));
			getDescribedComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

			expandableContainer = widgetFactory.createComposite(getDescribedComposite());
			expandableContainer.setLayout(getLayoutDescriptor().createLayout());
			getDescribedComposite().setText(getLabel());

			widgetFactory.paintBordersFor(expandableContainer);
			getDescribedComposite().setClient(expandableContainer);
		}

		controllers = updateControllers(widgetFactory);

		return controllers;
	}

	/**
	 * Returns the Composite containing the property editors.
	 * 
	 * @return the Composite containing the property editors.
	 */
	protected Composite getPropertyEditorContainer() {
		return expandableContainer;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "ExpandableContainerDescriptor";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/ExpandableContainer.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ContainerDescriptorState createState(boolean readOnly) {
		return new ExpandableContainerDescriptorState(this, readOnly);
	}

	/**
	 * Returns the label of the expandable composite
	 * 
	 * @return the label of the expandable composite
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * State for {@link ExpandableContainerDescriptor}
	 */
	public class ExpandableContainerDescriptorState extends ContainerDescriptorState {

		/** name of the container */
		private String name;

		/** change support for this bean */
		private PropertyChangeSupport changeSupport;

		/**
		 * Creates a new ExpandableContainerDescriptorState.
		 * 
		 * @param descriptor
		 *        the descriptor managed by the state
		 * @param readOnly
		 *        the read only mode for this state
		 */
		public ExpandableContainerDescriptorState(ExpandableContainerDescriptor descriptor, boolean readOnly) {
			super(descriptor, readOnly);

			this.name = descriptor.getLabel();
			// register change support
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * Sets the name of the expandable composite
		 * 
		 * @param name
		 *        the name to set
		 */
		public void setName(String name) {
			String oldName = this.name;
			this.name = name;

			// fire change event
			changeSupport.firePropertyChange("name", oldName, this.name);
		}

		/**
		 * Returns the name of the expandable composite
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * {@inheritDoc}
		 */
		public Node generateNode(Document document) {
			Element node = document.createElement("expandableContainer");
			node.setAttribute("label", getName());

			generateLayoutDescriptor(node, document);
			// generate for owned controllers
			generateControllers(node, document);

			return node;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
			super.addPropertyChangeListener(listener);
			changeSupport.addPropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
			super.removePropertyChangeListener(listener);
			changeSupport.removePropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getEditionDialogId() {
			return "ExpandableContainerDescriptorStateDialog";
		}

		/**
		 * {@inheritDoc}
		 */
		public Composite createPreview(Composite parent) {
			Group composite = new TabbedPropertySheetWidgetFactory().createGroup(parent, "Expandable > " + name);
			// add layout
			composite.setLayout(layoutDescriptorState.createLayout());
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

			// create the content for the controllers
			for(ControllerDescriptorState controllerDescriptorState : controllerDescriptorStates) {
				controllerDescriptorState.createPreview(composite);
			}
			return composite;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText() {
			return "Expandable \"" + getName() + "\"";
		}
	}
}
