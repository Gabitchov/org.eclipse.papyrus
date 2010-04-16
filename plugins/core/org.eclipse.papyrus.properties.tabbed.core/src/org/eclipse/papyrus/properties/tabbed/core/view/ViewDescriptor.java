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
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.controller.predefined.PredefinedPropertyControllerProvider;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Descriptor of a view for a view
 */
public class ViewDescriptor {

	/** element class on which this view is based */
	private final Class<?> elementClass;

	/** view given for multi-selection of elements or only one element */
	private final boolean isMultiSelectionView;

	/** list of constraints on this element. This could be OCL, java constraints for example */
	private final List<Object> constraints;

	/** unparsed content node */
	private Node contentNode;

	/** uncached descriptors */
	private List<IPropertyEditorControllerDescriptor> uncachedDescriptors = null;

	/**
	 * Creates a new ViewDescriptor.
	 * 
	 */
	public ViewDescriptor(Class<?> elementClass, boolean isMultiSelectionView, List<Object> constraints) {
		this.elementClass = elementClass;
		this.isMultiSelectionView = isMultiSelectionView;
		this.constraints = constraints;
	}

	/**
	 * parses a configuration element and returns the descriptor corresponding to this view
	 * 
	 * @param element
	 *        the xml configuration element
	 * @return the new descriptor
	 */
	public static ViewDescriptor parse(Node contextNode) {
		// retrieve information in attributes 
		// (isMulti => view for multi-selected elements or only single element selection)
		NamedNodeMap contextAttributes = contextNode.getAttributes();
		Node isMultiNode = contextAttributes.getNamedItem("isMulti");
		String isMultiValue = isMultiNode.getNodeValue();
		boolean isMulti = Boolean.parseBoolean(isMultiValue);

		// retrieve meta class for which the view is valid
		// and additional constraints (applied profiles, applied stereotypes, ocl constraints, etc)
		NodeList children2 = contextNode.getChildNodes();
		Class<?> elementClass = null;
		for(int j = 0; j < children2.getLength(); j++) {
			Node child2 = children2.item(j);
			// check child 2 is an element class definition
			if("elementClass".equals(child2.getNodeName())) {
				if(child2.getAttributes() != null && child2.getAttributes().getNamedItem("name") != null) {
					String elementClassName = child2.getAttributes().getNamedItem("name").getNodeValue();
					// should retrieve java class corresponding to this class
					try {
						elementClass = Class.forName(elementClassName);

					} catch (ClassNotFoundException e) {
						Activator.log.error(e);
					}
				}

			}
		}
		if(elementClass == null) {
			return null;
		}
		return new ViewDescriptor(elementClass, isMulti, Collections.emptyList());
	}

	/**
	 * Returns the element class
	 * 
	 * @return the element class
	 */
	public Class<?> getElementClass() {
		return elementClass;
	}

	/**
	 * Returns <code>true</code> if the view is provided for multi-selection, otherwise, it returns <code>false</code>
	 * 
	 * @return <code>true</code> if the view is provided for multi-selection, otherwise, it returns <code>false</code>
	 */
	public boolean isMultiSelectionView() {
		return isMultiSelectionView;
	}

	/**
	 * Returns the constraints used to select different views that occurs on same metaclass
	 * 
	 * @return the constraints used to select different views that occurs on same metaclass
	 */
	public List<Object> getConstraints() {
		return constraints;
	}


	/**
	 * Returns the unparsed contentNode
	 * 
	 * @return the unparsed contentNode
	 */
	public Node getContentNode() {
		return contentNode;
	}

	/**
	 * Adds the {@link Node} which describes the view configuration
	 * 
	 * @param contentNode
	 *        the node which describes the view configuration
	 */
	public void setUnparsedConfiguration(Node contentNode) {
		this.contentNode = contentNode;
	}

	/**
	 * Returns the uncached descriptors for the controllers
	 * 
	 * @return the uncached descriptors for the controllers
	 */
	public List<IPropertyEditorControllerDescriptor> getUnchachedDescriptors() {
		if(uncachedDescriptors == null) {
			uncachedDescriptors = new ArrayList<IPropertyEditorControllerDescriptor>();

			// compute using the content node
			NodeList children = contentNode.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if("controller".equals(child.getNodeName())) {
					parseControllerNode(child);
				} else if("layout".equals(child.getNodeName())) {
					parseLayoutNode(child);
				}
			}
		}
		return uncachedDescriptors;
	}

	/**
	 * Parses the layout node
	 * 
	 * @param layoutNode
	 *        the layout node
	 */
	protected void parseLayoutNode(Node layoutNode) {
		NodeList children = layoutNode.getChildNodes();
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
			controllerDescriptor = PropertyEditorControllerService.getInstance().createPropertyEditorControllerDescriptor(controllerId, controllerNode);
		}

		if(controllerDescriptor != null) {
			uncachedDescriptors.add(controllerDescriptor);
		}
	}
}
