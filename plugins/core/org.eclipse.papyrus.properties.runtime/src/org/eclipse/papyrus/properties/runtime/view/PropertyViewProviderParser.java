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
package org.eclipse.papyrus.properties.runtime.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ExpandableContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.GroupContainerDescriptor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Layout;
import org.osgi.framework.Bundle;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Parser for the xml content of the property view provider
 */
public class PropertyViewProviderParser {

	/** node name for tab */
	protected static final String NODE_NAME_TAB = "tab";

	/** node name for view */
	protected static final String NODE_NAME_VIEW = "view";

	/** node name for id */
	protected static final String NODE_NAME_ID = "id";

	/** key for the value: path to the xml file */
	protected static final String XML_PATH = "path";

	/** reference to the map containing predefined Views */
	protected Map<String, ViewDescriptor> predefinedViews;

	/** stores the reference to the bundle, so the bundle class loader can be used to load classes */
	protected Bundle bundle;

	/**
	 * Parses the view node
	 * 
	 * @param viewNode
	 *        the node corresponding to the view
	 * @throws XMLParseException
	 *         parsing failed
	 */
	protected ViewDescriptor parseView(Node viewNode) throws XMLParseException {
		// the view node is divided into 2 parts: 
		// the first one describes the context for the view to be displayed,
		// the second one describes the content of the view itself

		// retrieve ID of the view (to be reused as a predefined view)
		NamedNodeMap attributes = viewNode.getAttributes();
		String id;
		if(attributes != null) {
			Node idNode = attributes.getNamedItem("id");
			if(idNode != null) {
				id = idNode.getNodeValue();
			} else {
				throw new XMLParseException("Impossible to find ID for view " + viewNode);
			}
		} else {
			throw new XMLParseException("Impossible to find ID for view " + viewNode);
		}

		NodeList children = viewNode.getChildNodes();
		Node contextNode = null;
		Node contentNode = null;

		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			final String childNodeName = child.getNodeName();
			if("context".equals(childNodeName)) {
				// this is the context of the view
				// store this node.
				contextNode = child;
			} else if("content".equals(childNodeName)) {
				contentNode = child;
			}
		}

		// 2 nodes should have been found
		if(contextNode == null || contentNode == null) {
			Activator.log.error("Impossible to parse configuration for " + viewNode, null);
			return null;
		}

		// parses constraints that will be given to each section
		List<IConstraintDescriptor> constraints = parseConstraints(contextNode);

		// do not parse currently the content node, will be done later, as the view is used
		return new ViewDescriptor(id, constraints, contentNode, this);
	}

	/**
	 * Parses the size the selection should be
	 * 
	 * @param contextNode
	 *        the node to parse
	 * @return the size the selection should be
	 */
	protected int parseSelectionSize(Node contextNode) {
		NamedNodeMap contextAttributes = contextNode.getAttributes();
		Node isMultiNode = contextAttributes.getNamedItem("enablesFor");
		String isMultiValue = isMultiNode.getNodeValue();
		return Integer.parseInt(isMultiValue);
	}

	/**
	 * Parses the list of constraints for this node
	 * 
	 * @param contextNode
	 *        the context node to parse
	 * @return the list of constraints for this node
	 */
	protected List<IConstraintDescriptor> parseConstraints(Node contextNode) {

		List<IConstraintDescriptor> constraintDescriptors = new ArrayList<IConstraintDescriptor>();
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
						// should use the bundle defining the property view and not this bundle to load the class
						// to remove dependencies
						elementClass = bundle.loadClass(elementClassName);
						constraintDescriptors.add(new ObjectTypeConstraintDescriptor(elementClass));
					} catch (ClassNotFoundException e) {
						Activator.log.error(e);
					}
				}
			} else if("appliedStereotypes".equals(child2.getNodeName())) {
				List<String> appliedStereotypeQNames = new ArrayList<String>();
				// each child node of this node is the stereotype with qualified names
				NodeList stereotypeNodes = child2.getChildNodes();
				for(int i = 0; i < stereotypeNodes.getLength(); i++) {
					Node stereotypeNode = stereotypeNodes.item(i);
					String stereotypeNodeName = stereotypeNode.getNodeName();
					if("appliedStereotype".equals(stereotypeNodeName)) {
						// retrieve attribute QN
						NamedNodeMap attributes = stereotypeNode.getAttributes();
						if(attributes != null) {
							Node qualifiedName = attributes.getNamedItem("qualifiedName");
							if(qualifiedName != null) {
								appliedStereotypeQNames.add(qualifiedName.getNodeValue());
							}
						}
					}
				}
				constraintDescriptors.add(new AppliedStereotypeConstraintDescriptor(appliedStereotypeQNames));
			}
		}
		return constraintDescriptors;
	}

	/**
	 * Parses the content of the xml file
	 * 
	 * @param views
	 * @param predefinedViews
	 * @throws XMLParseException
	 *         parsing failed
	 */
	public void parseXMLfile(NodeList views, Map<String, ViewDescriptor> predefinedViews, Bundle bundle) throws XMLParseException {
		this.predefinedViews = predefinedViews;
		this.bundle = bundle;
		for(int i = 0; i < views.getLength(); i++) {
			Node propertyViewNode = views.item(i);
			// check this is a "views" node, not a comment or a text format node.
			if("views".equals(propertyViewNode.getNodeName())) {
				parseViewsNode(propertyViewNode);
			}
		}
	}

	/**
	 * Parses the property view node and adds a view Descriptor to the list of view descriptor maintained by this provider
	 * 
	 * @param propertyViewNode
	 *        the configuration node of the property view
	 * @throws XMLParseException
	 *         parsing failed
	 */
	protected void parseViewsNode(Node propertyViewNode) throws XMLParseException {
		// retrieve each child node which is a view
		NodeList children = propertyViewNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a view node (not a comment or a formatting children)

			Node childNode = children.item(i);
			String childNodeName = childNode.getNodeName();
			if(NODE_NAME_VIEW.equals(childNodeName)) {
				ViewDescriptor viewDescriptor = parseView(childNode);
				predefinedViews.put(viewDescriptor.getId(), viewDescriptor);
			}
		}
	}

	/**
	 * Parses the xml content node to set the content of the section
	 * 
	 * @param unparsedContentNode
	 *        the node to parse
	 * @return the new configuration for the section
	 */
	protected List<ContainerDescriptor> parseContentNode(Node unparsedContentNode) throws XMLParseException {
		ArrayList<ContainerDescriptor> containerDescriptors = new ArrayList<ContainerDescriptor>();
		NodeList children = unparsedContentNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node containerNode = children.item(i);
			if("container".equals(containerNode.getNodeName())) {
				containerDescriptors.add(parseContainerNode(containerNode));
			} else if("expandableContainer".equals(containerNode.getNodeName())) {
				containerDescriptors.add(parseExpandableContainerNode(containerNode));
			} else if("groupContainer".equals(containerNode.getNodeName())) {
				containerDescriptors.add(parseGroupNode(containerNode));
			}
		}
		return containerDescriptors;

	}

	/**
	 * Parses the container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 */
	protected ContainerDescriptor parseContainerNode(Node containerNode) throws XMLParseException {
		Layout layout = parseLayout(containerNode);
		return new ContainerDescriptor(layout, containerNode);
	}

	/**
	 * Parses the group container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 */
	protected ContainerDescriptor parseGroupNode(Node containerNode) throws XMLParseException {
		Layout layout = parseLayout(containerNode);
		String label = parseLabel(containerNode);
		return new GroupContainerDescriptor(layout, label, containerNode);
	}

	/**
	 * Parses the expandable container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 */
	protected ContainerDescriptor parseExpandableContainerNode(Node containerNode) throws XMLParseException {
		Layout layout = parseLayout(containerNode);
		String label = parseLabel(containerNode);
		return new ExpandableContainerDescriptor(layout, label, containerNode);
	}

	/**
	 * Parses the label for the given container
	 * 
	 * @param containerNode
	 *        the container node to parse
	 * @return the label of the container
	 * @throws XMLParseException
	 *         exception thrown when XML file could not be parsed.
	 */
	protected String parseLabel(Node containerNode) throws XMLParseException {
		NamedNodeMap attributes = containerNode.getAttributes();
		if(attributes == null) {
			throw new XMLParseException("Impossible to find attributes for container node " + containerNode);
		}
		// retrieve the name
		Node nameNode = attributes.getNamedItem("label");
		String label = "";
		if(nameNode == null) {
			throw new XMLParseException("Impossible to find layout attribute for container node " + containerNode);
		} else {
			label = nameNode.getNodeValue();
		}
		return label;
	}

	/**
	 * Parses the layout for the container
	 * 
	 * @param containerNode
	 *        the container node which contains layout information
	 * @return the layout for the container
	 */
	protected Layout parseLayout(Node containerNode) throws XMLParseException {
		Layout layout = null;
		// this is a simple container. 
		// Retrieving the layout and generates the composite descriptor
		NamedNodeMap attributes = containerNode.getAttributes();
		if(attributes == null) {
			throw new XMLParseException("Impossible to find attributes for container node " + containerNode);
		}
		Node layoutNode = attributes.getNamedItem("layout");
		if(layoutNode == null) {
			throw new XMLParseException("Impossible to find layout attribute for container node " + containerNode);
		} else if("Grid".equals(layoutNode.getNodeValue())) {
			// retrieve number of columns 
			int columnNu = 1;
			boolean sameSize = false;

			Node columnNuNode = attributes.getNamedItem("columns");
			if(columnNuNode == null) {
				throw new XMLParseException("Impossible to find column number attribute for container node " + containerNode);
			} else {
				columnNu = Integer.parseInt(columnNuNode.getNodeValue());
			}
			Node columnSizeNode = attributes.getNamedItem("sameSize");
			if(columnSizeNode == null) {
				throw new XMLParseException("Impossible to find column size attribute for container node " + containerNode);
			} else {
				sameSize = Boolean.parseBoolean(columnSizeNode.getNodeValue());
			}
			layout = new GridLayout(columnNu, sameSize);
		}
		return layout;
	}
}
