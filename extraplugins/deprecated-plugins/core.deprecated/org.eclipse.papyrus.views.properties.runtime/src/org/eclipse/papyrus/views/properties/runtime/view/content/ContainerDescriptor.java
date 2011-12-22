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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.PredefinedPropertyControllerProvider;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * simple container descriptor
 */
public class ContainerDescriptor extends AbstractContainerDescriptor {

	/** composite managed by this descriptor */
	protected Composite describedComposite;

	/** List of controllers managed in this composite */
	protected List<PropertyEditorController> controllers = new ArrayList<PropertyEditorController>();

	/** list of objects to edit */
	protected List<Object> objectsToEdit;

	/** boolean set to <code>true</code> when the content of the node has been parsed */
	protected boolean unparsedContent = true;

	/** boolean that indicates if the parsing of the content has already failed */
	protected boolean parseFailed;

	/** list of uncached Property editor controller descriptors */
	protected List<IPropertyEditorControllerDescriptor> uncachedDescriptors;

	/**
	 * Creates a new ContainerDescriptor.
	 * 
	 * @param layoutDescriptor
	 *        the layout of the composite described by this element
	 * @param containerNode
	 *        the xml configuration node for this container
	 * 
	 */
	public ContainerDescriptor(LayoutDescriptor layoutDescriptor, Node containerNode) {
		super(layoutDescriptor, containerNode);
	}

	/**
	 * Creates a new ContainerDescriptor.
	 * 
	 * @param layoutDescriptor
	 *        the layoutDescriptor of the composite described by this element
	 * @param descriptors
	 *        list of controller descriptors owned by this container
	 */
	public ContainerDescriptor(LayoutDescriptor layoutDescriptor, List<IPropertyEditorControllerDescriptor> descriptors) {
		super(layoutDescriptor, null);
		// force the list of descriptors, not using cache
		uncachedDescriptors = descriptors;
		unparsedContent = false;
	}

	/**
	 * Returns the describedComposite
	 * 
	 * @return the describedComposite
	 */
	public Composite getDescribedComposite() {
		return describedComposite;
	}

	/**
	 * Sets the describedComposite
	 * 
	 * @param describedComposite
	 *        the describedComposite to set
	 */
	public void setDescribedComposite(Composite describedComposite) {
		this.describedComposite = describedComposite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PropertyEditorController> createContent(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, List<Object> objectsToEdit) {
		this.objectsToEdit = objectsToEdit;
		if(getDescribedComposite() == null || getDescribedComposite().isDisposed()) {
			setDescribedComposite(widgetFactory.createComposite(parent));
			// creates the layout
			getDescribedComposite().setLayout(getLayoutDescriptor().createLayout());
			getDescribedComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
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
		return getDescribedComposite();
	}

	/**
	 * Update controllers managed by this descriptor
	 * 
	 * @param widgetFactory
	 *        widget factory used to create content of the editors
	 * 
	 * @return the list of update controllers
	 */
	protected List<PropertyEditorController> updateControllers(TabbedPropertySheetWidgetFactory widgetFactory) {
		// clear and re-create the list of controllers
		for(PropertyEditorController controller : controllers) {
			controller.dispose();
		}
		controllers.clear();

		// parses the property editor controller descriptors from the configuration node if required
		if(unparsedContent) {
			uncachedDescriptors = new ArrayList<IPropertyEditorControllerDescriptor>();
			parseContent();
		}

		if(!parseFailed) {
			// creates the content for the controllers
			for(IPropertyEditorControllerDescriptor descriptor : getControllerDescriptors()) {
				controllers.add(PropertyViewService.getInstance().createPropertyEditorController(objectsToEdit, getPropertyEditorContainer(), descriptor, widgetFactory));
			}
		}

		return controllers;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		for(PropertyEditorController controller : controllers) {
			if(controller != null) {
				controller.dispose();
			}
		}
		controllers.clear();
		if(getDescribedComposite() != null && !getDescribedComposite().isDisposed()) {
			getDescribedComposite().dispose();
		}
	}

	/**
	 * parses the content of the container.
	 */
	protected void parseContent() {
		NodeList children = containerNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("controller".equals(child.getNodeName())) {
				parseControllerNode(child);
			}
		}
	}

	/**
	 * parses the controller node
	 * 
	 * @param controllerNode
	 *        the node to parse
	 * 
	 * @param child
	 *        the controller node
	 */
	protected void parseControllerNode(Node controllerNode) {
		if(!controllerNode.hasAttributes()) {
			Activator.log.error("impossible to find attributes for node " + controllerNode, null);
			return;
		}
		IPropertyEditorControllerDescriptor controllerDescriptor = null;
		// should check here if this is a predefined controller node or a locally defined one
		Node predefinedIDNode = controllerNode.getAttributes().getNamedItem(PredefinedPropertyControllerProvider.PREDEFINED_ID);
		if(predefinedIDNode != null) {
			controllerDescriptor = PropertyEditorControllerService.getInstance().createPredefinedControllerDescriptor(predefinedIDNode.getNodeValue());
		} else {
			String controllerId = controllerNode.getAttributes().getNamedItem("id").getNodeValue();
			controllerDescriptor = PropertyEditorControllerService.getInstance().createPropertyEditorControllerDescriptor(controllerId, controllerNode, null);
		}

		if(controllerDescriptor != null) {
			uncachedDescriptors.add(controllerDescriptor);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPropertyEditorControllerDescriptor> getControllerDescriptors() {
		return uncachedDescriptors;
	}

	/**
	 * non optimized method to have access to all controller descriptors. It forces the parse of the content of the controller descriptors
	 * 
	 * @return the parsed list of the content descriptors
	 */
	public List<IPropertyEditorControllerDescriptor> getUnparsedControllerDescriptors() {
		if(unparsedContent) {
			uncachedDescriptors = new ArrayList<IPropertyEditorControllerDescriptor>();
			parseContent();
		}
		return getControllerDescriptors();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "SimpleContainerDescriptor";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/Container.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public ContainerDescriptorState createState(boolean readOnly) {
		return new ContainerDescriptorState(this, readOnly);
	}
}
