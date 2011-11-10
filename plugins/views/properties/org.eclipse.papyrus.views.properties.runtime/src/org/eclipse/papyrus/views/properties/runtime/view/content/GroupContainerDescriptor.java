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
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Container descriptor for the groups
 */
public class GroupContainerDescriptor extends ContainerDescriptor {

	/** label for the folder */
	protected final String label;

	/**
	 * Creates a new ViewConfiguration.FolderContainerDescriptor.
	 * 
	 * @param layoutDescriptor
	 *        the layoutDescriptor applied to the container
	 * @param label
	 *        the label of the created composite
	 * @param containerNode
	 *        the unparsed xml configuration node for this container
	 */
	public GroupContainerDescriptor(LayoutDescriptor layoutDescriptor, String label, Node containerNode) {
		super(layoutDescriptor, containerNode);
		this.label = label;
	}

	/**
	 * Creates a new GroupContainerDescriptor
	 * 
	 * @param layoutDescriptor
	 *        the layoutDescriptor applied to the container
	 * @param label
	 *        the label of the created composite
	 * @param descriptors
	 *        the list of {@link IPropertyEditorControllerDescriptor} contained by this container
	 */
	public GroupContainerDescriptor(LayoutDescriptor layoutDescriptor, String label, List<IPropertyEditorControllerDescriptor> descriptors) {
		super(layoutDescriptor, descriptors);
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Group getDescribedComposite() {
		return (Group)super.getDescribedComposite();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PropertyEditorController> createContent(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, List<Object> objectsToEdit) {
		this.objectsToEdit = objectsToEdit;
		if(getDescribedComposite() == null || getDescribedComposite().isDisposed()) {
			setDescribedComposite(widgetFactory.createGroup(parent, label));
			getDescribedComposite().setText(label);
			// creates the layout
			getDescribedComposite().setLayout(getLayoutDescriptor().createLayout());
			getDescribedComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		}

		controllers = updateControllers(widgetFactory);

		return controllers;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "GroupContainerDescriptor";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/GroupContainer.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ContainerDescriptorState createState(boolean readOnly) {
		return new GroupContainerDescriptorState(this, readOnly);
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
	 * State for {@link GroupContainerDescriptor}
	 */
	public class GroupContainerDescriptorState extends ContainerDescriptorState {

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
		 *        read only mode of this state
		 */
		public GroupContainerDescriptorState(GroupContainerDescriptor descriptor, boolean readOnly) {
			super(descriptor, readOnly);

			this.name = descriptor.getLabel();
			// register change support
			changeSupport = new PropertyChangeSupport(this);
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
		 * Sets the name of the expandable composite
		 * 
		 * @param name
		 *        the name to set
		 */
		public void setName(String name) {
			String oldName = this.name;
			this.name = name;

			// fire change event
			changeSupport.firePropertyChange("label", oldName, this.name);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText() {
			return "Group \"" + getName() + "\"";
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
			Element node = document.createElement("groupContainer");
			node.setAttribute("label", getName());

			generateLayoutDescriptor(node, document);
			// generate for owned controllers
			generateControllers(node, document);

			return node;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getEditionDialogId() {
			return "GroupContainerDescriptorStateDialog";
		}

		/**
		 * {@inheritDoc}
		 */
		public Composite createPreview(Composite parent) {
			Group composite = new TabbedPropertySheetWidgetFactory().createGroup(parent, name);
			// add layout
			composite.setLayout(layoutDescriptorState.createLayout());
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

			// create the content for the controllers
			for(ControllerDescriptorState controllerDescriptorState : controllerDescriptorStates) {
				controllerDescriptorState.createPreview(composite);
			}
			return composite;
		}
	}
}
