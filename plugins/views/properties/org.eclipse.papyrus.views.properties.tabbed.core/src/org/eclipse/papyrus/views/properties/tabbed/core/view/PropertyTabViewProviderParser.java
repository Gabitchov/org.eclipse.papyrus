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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.PredefinedFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewProviderParser;
import org.eclipse.papyrus.views.properties.runtime.view.XMLParseException;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.DynamicSubFeatureSectionDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.EMFSimpleSubFeatureDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.ExpandableContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.GroupContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.SimpleContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.SubFeatureContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.SubFeatureDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.w3c.dom.Document;
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

	/** node name for id */
	protected static final String NODE_NAME_ID = "id";

	/** attribute for name */
	protected static final String ATTRIBUTE_NAME = "name";

	/** node name for sub feature sections */
	protected static final String NODE_NAME_SECTION_SUBFEATURE = "subFeatureSection";

	/** name of the attribute: after section */
	protected static final String AFTER_SECTION_ID = "afterSection";

	/** link to the list of all available tab descriptors */
	protected List<ITabDescriptor> tabDescriptors;

	/** list of all tab descriptors provided specifically by this provider */
	protected List<ITabDescriptor> providedTabDescriptors = new ArrayList<ITabDescriptor>();

	/** list of provided section sets by the provider using this parser */
	private List<SectionSetDescriptor> providedSectionSets = new ArrayList<SectionSetDescriptor>();

	/**
	 * Creates a new PropertyTabViewProviderParser.
	 * 
	 * @param tabDescriptors
	 *        list of already available tab descriptors
	 */
	public PropertyTabViewProviderParser(List<ITabDescriptor> tabDescriptors) {
		this.tabDescriptors = tabDescriptors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void parseXMLfile(Document document, Map<String, FragmentDescriptor> predefinedFragments, Map<String, DialogDescriptor> predefinedDialogs) throws XMLParseException {
		this.predefinedFragments = predefinedFragments;
		this.predefinedDialogs = predefinedDialogs;
		NodeList views = document.getChildNodes();
		for(int i = 0; i < views.getLength(); i++) {
			Node propertyViewNode = views.item(i);
			// check this is a "propertyTabView" node, not a comment or a text format node.
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

		// retrieve plugin id for this contribution, to get the bundle class loader
		String pluginId = getPluginIdFromTopNode(propertyViewNode);
		bundle = Platform.getBundle(pluginId);

		// retrieve each child node which is a view
		NodeList children = propertyViewNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a view node (not a comment or a formatting children)

			Node childNode = children.item(i);
			String childNodeName = childNode.getNodeName();
			if(NODE_NAME_SECTION_SET.equals(childNodeName)) {
				getProvidedSectionSets().add(parseSectionSetNode(childNode));
			} else if(NODE_NAME_TAB.equals(childNodeName)) {
				DynamicTabDescriptor tabDescriptor = parseTab(childNode);
				providedTabDescriptors.add(tabDescriptor);
				// make contribution to tab descriptors
				tabDescriptors.add(tabDescriptor);
			}
		}
	}

	/**
	 * Parses the tab node configured by the specified node
	 * 
	 * @param node
	 *        the configuration node for the tab
	 * @return descriptor created by the parser
	 */
	protected DynamicTabDescriptor parseTab(Node node) {
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
			DynamicTabDescriptor tabDescriptor = new DynamicTabDescriptor(category, id, label);
			return tabDescriptor;
		}
		return null;
	}

	/**
	 * Parses the section node set and add the found sections in their corresponding tab descriptors
	 * 
	 * @param sectionSetNode
	 *        the section set node to parse
	 * @return section set descriptor returned by the parser
	 */
	protected SectionSetDescriptor parseSectionSetNode(Node sectionSetNode) {

		List<DynamicSectionDescriptor> sectionDescriptors = new ArrayList<DynamicSectionDescriptor>();
		List<IConstraintDescriptor> constraintDescriptors = new ArrayList<IConstraintDescriptor>();
		int selectionSize = 0;

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
			return null;
		}

		// parses constraints that will be given to each section
		List<IConstraintDescriptor> constraintDescriptors2 = parseConstraints(contextNode);
		assert (constraintDescriptors2 != null && !constraintDescriptors2.isEmpty()) : "constraints should not be null...";
		constraintDescriptors.addAll(constraintDescriptors2);

		// parse size
		selectionSize = parseSelectionSize(contextNode);

		for(Node sectionNode : sectionNodes) {
			DynamicSectionDescriptor sectionDescriptor = parseSectionNode(sectionNode, constraintDescriptors, selectionSize);
			sectionDescriptors.add(sectionDescriptor);
		}

		return new SectionSetDescriptor(name, sectionDescriptors, constraintDescriptors, selectionSize);
	}

	/**
	 * Parses the given section node
	 * 
	 * @param sectionNode
	 *        the section to parse
	 * @param constraints
	 *        the list of constraints applied to the descriptor
	 * @param selectionSize
	 *        size of the selection
	 * @return the created descriptor
	 */
	@SuppressWarnings("unchecked")
	protected DynamicSectionDescriptor parseSectionNode(Node sectionNode, List<IConstraintDescriptor> constraints, int selectionSize) {

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
		String afterSection = null;
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

			node = attributes.getNamedItem(AFTER_SECTION_ID);
			if(node != null) {
				afterSection = node.getNodeValue();
			}
		}

		List<String> replacedSectionsId = new ArrayList<String>();
		List<IFragmentDescriptor> fragmentDescriptors = new ArrayList<IFragmentDescriptor>();
		try {
			NodeList children = sectionNode.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				if("replacedSections".equals(childNode.getNodeName())) {
					replacedSectionsId = parseReplacedSectionIds(childNode);
				} else if(NODE_NAME_FRAGMENT.equals(childNode.getNodeName())) {
					IFragmentDescriptor fragmentDescriptor = parseFragmentOrPredefinedFragment(childNode);
					if(fragmentDescriptor != null) {
						fragmentDescriptors.add(fragmentDescriptor);
					}
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
			DynamicSectionDescriptor descriptor = new DynamicSubFeatureSectionDescriptor(id, tabId, constraints, selectionSize, adapterId, replacedSectionsId, afterSection, fragmentDescriptors, subFeatureDescriptor, maxColumn, subFeatureContainerDescriptor);
			descriptor.setUnparsedContent(sectionNode);
			// retrieve the tab to add section to it.
			// this means that the descriptor for the tab should already exist.
			for(ITabDescriptor tabDescriptor : tabDescriptors) {
				if(tabDescriptor.getId().equals(tabId)) {
					tabDescriptor.getSectionDescriptors().add(descriptor);
					return descriptor;
				}
			}
		} else {
			DynamicSectionDescriptor descriptor = new DynamicSectionDescriptor(id, tabId, constraints, selectionSize, adapterId, replacedSectionsId, afterSection, fragmentDescriptors);
			descriptor.setUnparsedContent(sectionNode);
			// retrieve the tab to add section to it.
			// this means that the descriptor for the tab should already exist.
			for(ITabDescriptor tabDescriptor : tabDescriptors) {
				if(tabDescriptor.getId().equals(tabId)) {
					// should check if the tab descriptor already contains this section descriptor
					boolean contains = false;
					for(ISectionDescriptor dynamicSectionDescriptor : (List<ISectionDescriptor>)tabDescriptor.getSectionDescriptors()) {
						String sectionId = dynamicSectionDescriptor.getId();
						if(id.equals(sectionId)) {
							contains = true;
							//Activator.log.error("Trying to add a section which already exists", null);
						}
					}
					if(!contains) {
						tabDescriptor.getSectionDescriptors().add(descriptor);
					}
					return descriptor;
				}
			}
		}
		// should never happen
		return null;
	}

	/**
	 * Parses the sub feature container descriptor node
	 * 
	 * @param descriptorNode
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
		} else if(GroupContainerDescriptor.GROUP_CONTAINER_TYPE.equals(type)) {
			String label = "";
			// attributes are not null, otherwise, the method would have already returned new simpleContainer
			Node labelNode = attributes.getNamedItem("label");
			if(labelNode != null) {
				label = labelNode.getNodeValue();
			}
			return new GroupContainerDescriptor(label);
		} else if(ExpandableContainerDescriptor.EXPANDABLE_CONTAINER_TYPE.equals(type)) {
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
	 * Parses a fragment node, either a predefined node or a locally defined node
	 * 
	 * @param fragmentNode
	 *        the node to parse
	 */
	protected IFragmentDescriptor parseFragmentOrPredefinedFragment(Node fragmentNode) {
		NamedNodeMap attributes = fragmentNode.getAttributes();
		if(attributes != null) {
			Node attribute = attributes.getNamedItem(ATTRIBUTE_PREDEFINED_ID);
			if(attribute != null) {
				return new PredefinedFragmentDescriptor(attribute.getNodeValue());
			}
		}

		// this is a locally defined fragment.
		// parse it as it was a predefinition of fragment
		FragmentDescriptor fragmentDescriptor;
		try {
			fragmentDescriptor = parseFragment(fragmentNode);
			if(fragmentDescriptor != null) {
				predefinedFragments.put(fragmentDescriptor.getId(), fragmentDescriptor);
			}
			return fragmentDescriptor;
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

	/**
	 * Returns the provided section sets by this provider
	 * 
	 * @return the provided section sets by this provider
	 */
	public List<SectionSetDescriptor> getProvidedSectionSets() {
		return providedSectionSets;
	}

	/**
	 * Returns the provided TabDescriptors by this provider
	 * 
	 * @return the provided TabDescriptors by this provider
	 */
	public List<ITabDescriptor> getProvidedTabDescriptors() {
		return providedTabDescriptors;
	}
}
