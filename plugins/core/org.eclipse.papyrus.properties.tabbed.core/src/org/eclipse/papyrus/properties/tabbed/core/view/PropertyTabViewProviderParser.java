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
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewProviderParser;
import org.eclipse.papyrus.properties.runtime.view.ViewDescriptor;
import org.eclipse.papyrus.properties.runtime.view.XMLParseException;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.DynamicSubFeatureSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.EMFSimpleSubFeatureDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.ExpandableContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.GroupContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.SimpleContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.SubFeatureContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.subfeatures.SubFeatureDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Parser for the property tab view provider
 */
public class PropertyTabViewProviderParser extends PropertyViewProviderParser {

	/** name of the property tab node */
	protected static final Object NODE_NAME_PROPERTY_TAB_VIEW = "propertyTabView";

	/** key for the id attribute */
	protected static final String ID = "id";

	/** key for the category attribute */
	protected static final String CATEGORY = "category";

	/** key for the label attribute */
	protected static final String LABEL = "label";

	/** attribute name for tab identifier */
	protected static final String TAB_ID = "tabId";

	/** attribute name for adapter identifier */
	protected static final String ADAPTER_ID = "adapterId";

	/** node name for sections */
	protected static final String NODE_NAME_SECTION = "section";

	/** node name for section sets */
	protected static final String NODE_NAME_SECTION_SET = "sectionSet";

	/** node name for tab */
	protected static final String NODE_NAME_TAB = "tab";

	/** node name for view */
	protected static final String NODE_NAME_VIEW = "view";

	/** node name for id */
	protected static final String NODE_NAME_ID = "id";

	/** attribute for name */
	protected static final String ATTRIBUTE_NAME = "name";

	/** node name for sub feature sections */
	protected static final String NODE_NAME_SECTION_SUBFEATURE = "subFeatureSection";

	/** list of generated tab descriptors */
	protected List<ITabDescriptor> tabDescriptors;

	/**
	 * Creates a new PropertyTabViewProviderParser.
	 * 
	 * @param tabDescriptors2
	 */
	public PropertyTabViewProviderParser(List<ITabDescriptor> tabDescriptors) {
		this.tabDescriptors = tabDescriptors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void parseXMLfile(NodeList views, Map<String, ViewDescriptor> predefinedViews, Map<String, DialogDescriptor> predefinedDialogs, Bundle bundle) throws XMLParseException {
		this.predefinedViews = predefinedViews;
		this.predefinedDialogs = predefinedDialogs;
		this.bundle = bundle;
		for(int i = 0; i < views.getLength(); i++) {
			Node propertyViewNode = views.item(i);
			// check this is a "views" node, not a comment or a text format node.
			if(NODE_NAME_PROPERTY_TAB_VIEW.equals(propertyViewNode.getNodeName())) {
				parsePropertyTabViewNode(propertyViewNode);
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
	protected void parsePropertyTabViewNode(Node propertyViewNode) throws XMLParseException {
		// retrieve each child node which is a view
		NodeList children = propertyViewNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a view node (not a comment or a formatting children)

			Node childNode = children.item(i);
			String childNodeName = childNode.getNodeName();
			if(NODE_NAME_SECTION_SET.equals(childNodeName)) {
				parseSectionSetNode(childNode);
			} else if(NODE_NAME_TAB.equals(childNodeName)) {
				parseTab(childNode);
			}
		}
	}

	/**
	 * Parses the tab node configured by the specified node
	 * 
	 * @param node
	 *        the configuration node for the tab
	 */
	protected void parseTab(Node node) {
		NamedNodeMap attributes = node.getAttributes();
		String id = null;
		String label = null;
		String category = null;

		Node childNode = attributes.getNamedItem(ID);
		if(childNode != null) {
			id = childNode.getNodeValue();
		} else {
			Activator.log.error("impossible to parse id for the tab using " + node, null);
		}
		childNode = attributes.getNamedItem(CATEGORY);
		if(childNode != null) {
			category = childNode.getNodeValue();
		} else {
			Activator.log.error("impossible to parse category for the tab using " + node, null);
		}
		childNode = attributes.getNamedItem(LABEL);
		if(childNode != null) {
			label = childNode.getNodeValue();
		} else {
			Activator.log.error("impossible to parse label for the tab using " + node, null);
		}

		if(label != null && id != null && category != null) {
			tabDescriptors.add(new DynamicTabDescriptor(category, id, label));
		}
	}

	/**
	 * Parses the section node set and add the found sections in their corresponding tab descriptors
	 * 
	 * @param sectionSetNode
	 *        the section set node to parse
	 */
	protected void parseSectionSetNode(Node sectionSetNode) {
		// retrieve name
		NamedNodeMap attributes = sectionSetNode.getAttributes();
		String name = null;
		if(attributes != null) {
			Node node = attributes.getNamedItem(ATTRIBUTE_NAME);
			if(node != null) {
				name = node.getNodeValue();
			}
		}

		// parses the children of the section set : [1..1] context and [1..*] sections
		NodeList children = sectionSetNode.getChildNodes();

		Node contextNode = null;
		List<Node> sectionNodes = new ArrayList<Node>();

		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			String nodeName = child.getNodeName();
			if("context".equals(nodeName)) {
				contextNode = child;
			} else if(NODE_NAME_SECTION.equals(nodeName) || NODE_NAME_SECTION_SUBFEATURE.equals(nodeName)) {
				sectionNodes.add(child);
			}
		}

		// check both context node and list of sections
		if(contextNode == null || sectionNodes.isEmpty()) {
			Activator.log.error("impossible to find a context node or a list of sections for section set " + name, null);
			return;
		}

		// parses constraints that will be given to each section
		List<IConstraintDescriptor> constraints = parseConstraints(contextNode);

		// parse size
		int selectionSize = parseSelectionSize(contextNode);

		for(Node sectionNode : sectionNodes) {
			parseSectionNode(sectionNode, constraints, selectionSize);
		}

	}

	/**
	 * Parses the given section node
	 * 
	 * @param sectionNode
	 *        the section to parse
	 */
	@SuppressWarnings("unchecked")
	protected void parseSectionNode(Node sectionNode, List<IConstraintDescriptor> constraints, int selectionSize) {

		// Is this a subfeature section or a "standard one"
		String nodeName = sectionNode.getNodeName();
		boolean isSubFeatureSection = false;
		if(nodeName.equals(NODE_NAME_SECTION_SUBFEATURE)) {
			isSubFeatureSection = true;
		}

		// read attributes
		NamedNodeMap attributes = sectionNode.getAttributes();
		String id = null;
		String tabId = null;
		String adapterId = null;
		if(attributes != null) {
			Node node = attributes.getNamedItem(ID);
			if(node != null) {
				id = node.getNodeValue();
			}

			node = attributes.getNamedItem(TAB_ID);
			if(node != null) {
				tabId = node.getNodeValue();
			}

			node = attributes.getNamedItem(ADAPTER_ID);
			if(node != null) {
				adapterId = node.getNodeValue();
			}
		}

		List<String> replacedSectionsId = new ArrayList<String>();
		List<String> viewsId = new ArrayList<String>();
		try {
			NodeList children = sectionNode.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				if("replacedSections".equals(childNode.getNodeName())) {
					replacedSectionsId = parseReplacedSectionIds(childNode);
				} else if(NODE_NAME_VIEW.equals(childNode.getNodeName())) {
					String viewId = parseViewOrPredefinedView(childNode);
					viewsId.add(viewId);
				}
			}
		} catch (XMLParseException e) {
			Activator.log.error("Problem during parsing of replaced sections for node " + sectionNode, e);
		}

		if(isSubFeatureSection) {
			// parse additional information
			int maxColumn = 2;
			if(attributes != null) {
				Node node = attributes.getNamedItem("maxColumn");
				if(node != null) {
					maxColumn = Integer.parseInt(node.getNodeValue());
				}
			}

			// retrieve the subfeature descriptor
			NodeList children = sectionNode.getChildNodes();
			SubFeatureDescriptor subFeatureDescriptor = null;
			SubFeatureContainerDescriptor subFeatureContainerDescriptor = null;
			for(int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				if("subFeatureDescriptor".equals(childNode.getNodeName())) {
					// retrieve feature name
					String name = childNode.getAttributes().getNamedItem("featureName").getNodeValue();
					subFeatureDescriptor = new EMFSimpleSubFeatureDescriptor(name);
				} else if("subFeatureDescriptorContainer".equals(childNode.getNodeName())) {
					subFeatureContainerDescriptor = parseSubFeatureContainerDescriptorNode(childNode);
				}
			}

			DynamicSectionDescriptor descriptor = new DynamicSubFeatureSectionDescriptor(id, tabId, constraints, selectionSize, adapterId, replacedSectionsId, viewsId, subFeatureDescriptor, maxColumn, subFeatureContainerDescriptor);
			descriptor.setUnparsedContent(sectionNode);
			// retrieve the tab to add section to it.
			// this means that the descriptor for the tab should already exist.
			for(ITabDescriptor tabDescriptor : tabDescriptors) {
				if(tabDescriptor.getId().equals(tabId)) {
					tabDescriptor.getSectionDescriptors().add(descriptor);
				}
			}
		} else {
			DynamicSectionDescriptor descriptor = new DynamicSectionDescriptor(id, tabId, constraints, selectionSize, adapterId, replacedSectionsId, viewsId);
			descriptor.setUnparsedContent(sectionNode);
			// retrieve the tab to add section to it.
			// this means that the descriptor for the tab should already exist.
			for(ITabDescriptor tabDescriptor : tabDescriptors) {
				if(tabDescriptor.getId().equals(tabId)) {
					tabDescriptor.getSectionDescriptors().add(descriptor);
				}
			}
		}
	}

	/**
	 * Parses the sub feature container descriptor node
	 * 
	 * @param childNode
	 *        the node to parse
	 * @return the descriptor
	 */
	protected SubFeatureContainerDescriptor parseSubFeatureContainerDescriptorNode(Node descriptorNode) {
		String type = "simpleContainer";
		NamedNodeMap attributes = descriptorNode.getAttributes();
		if(attributes != null) {
			Node typeNode = attributes.getNamedItem("type");
			if(typeNode != null) {
				type = typeNode.getNodeValue();
			}
		} else {
			return new SimpleContainerDescriptor();
		}

		if("simpleContainer".equals(type)) {
			return new SimpleContainerDescriptor();
		} else if("groupContainer".equals(type)) {
			String label = "";
			// attributes are not null, otherwise, the method would have already returned new simpleContainer
			Node labelNode = attributes.getNamedItem("label");
			if(labelNode != null) {
				label = labelNode.getNodeValue();
			}
			return new GroupContainerDescriptor(label);
		} else if("expandableContainer".equals(type)) {
			String label = "";
			Node labelNode = attributes.getNamedItem("label");
			if(labelNode != null) {
				label = labelNode.getNodeValue();
			}
			return new ExpandableContainerDescriptor(label);
		}
		return new SimpleContainerDescriptor();
	}

	/**
	 * Parses a view node, either a predefined node or a locally defined node
	 * 
	 * @param viewNode
	 *        the node to parse
	 */
	protected String parseViewOrPredefinedView(Node viewNode) {
		NamedNodeMap attributes = viewNode.getAttributes();
		if(attributes != null) {
			Node attribute = attributes.getNamedItem(ATTRIBUTE_PREDEFINED_ID);
			if(attribute != null) {
				return attribute.getNodeValue();
			}
		}

		// this is a locally defined view.
		// parse it as it was a predefinition of view
		ViewDescriptor viewDescriptor;
		try {
			viewDescriptor = parseView(viewNode);
			predefinedViews.put(viewDescriptor.getId(), viewDescriptor);
			return viewDescriptor.getId();
		} catch (XMLParseException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Returns the list of replaced sections ids, given the configuration node
	 * 
	 * @param replacedSectionsNode
	 *        the node to parse
	 * @return the list of filtered ids.
	 * @throws XMLParseException
	 *         exception thrown when parsing goes wrong
	 */
	protected List<String> parseReplacedSectionIds(Node replacedSectionsNode) throws XMLParseException {
		List<String> list = new ArrayList<String>();
		NodeList children = replacedSectionsNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("replacedSection".equals(child.getNodeName())) {
				// retrieve attribute id
				NamedNodeMap attributes = child.getAttributes();
				if(attributes != null) {
					Node idNode = attributes.getNamedItem(NODE_NAME_ID);
					if(idNode != null) {
						list.add(idNode.getNodeValue());
					} else {
						throw new XMLParseException("impossible to fin the id attribute in the replacedSection node " + child);
					}
				} else {
					throw new XMLParseException("impossible to find attributes in the replacedSection node " + child);
				}
			}
		}
		return list;
	}

	/**
	 * Returns the result of the parsing
	 * 
	 * @return the result of the parsing
	 */
	protected List<ITabDescriptor> getResult() {
		return tabDescriptors;
	}
}
