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
package org.eclipse.papyrus.views.properties.runtime.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.dialogs.EMFFeatureBindingLabelProviderDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ExpandableContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.GroupContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.LayoutDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.LayoutParser;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Parser for the xml content of the property view provider
 */
public class PropertyViewProviderParser {

	/** node name for dialogs */
	protected static final String DIALOGS_NODE_NAME = "dialogs";

	/** node name for fragments */
	protected static final String NODE_NAME_FRAGMENTS = "fragments";

	/** node name for tab */
	protected static final String NODE_NAME_TAB = "tab";

	/** node name for fragment */
	protected static final String NODE_NAME_FRAGMENT = "fragment";

	/** node name for id */
	protected static final String NODE_NAME_ID = "id";

	/** key for the value: path to the xml file */
	protected static final String XML_PATH = "path";

	/** node name for dialog */
	protected static final String NODE_NAME_DIALOG = "dialog";

	/** ATTRIBUTE_PREDEFINED_ID */
	protected static final String ATTRIBUTE_PREDEFINED_ID = "predefinedId";

	/** reference to the map containing predefined fragments */
	protected Map<String, FragmentDescriptor> predefinedFragments;

	/** stores the reference to the bundle, so the bundle class loader can be used to load classes */
	protected Bundle bundle;

	/** reference to the map containing predefined dialogs */
	protected Map<String, DialogDescriptor> predefinedDialogs;

	/**
	 * Parses the fragment node
	 * 
	 * @param fragmentNode
	 *        the node corresponding to the fragment
	 * @return the fragment result of the parsing
	 * @throws XMLParseException
	 *         parsing failed
	 */
	protected FragmentDescriptor parseFragment(Node fragmentNode) throws XMLParseException {
		// the fragment node is divided into 2 parts: 
		// the first one describes the context for the fragment to be displayed,
		// the second one describes the content of the fragment itself

		// retrieve ID of the fragment (to be reused as a predefined fragment)
		NamedNodeMap attributes = fragmentNode.getAttributes();
		String id;
		if(attributes != null) {
			Node idNode = attributes.getNamedItem("id");
			if(idNode != null) {
				id = idNode.getNodeValue();
			} else {
				throw new XMLParseException("Impossible to find ID for fragment " + fragmentNode);
			}
		} else {
			throw new XMLParseException("Impossible to find ID for fragment " + fragmentNode);
		}

		NodeList children = fragmentNode.getChildNodes();
		Node contextNode = null;
		Node contentNode = null;

		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			final String childNodeName = child.getNodeName();
			if("context".equals(childNodeName)) {
				// this is the context of the fragment
				// store this node.
				contextNode = child;
			} else if("content".equals(childNodeName)) {
				contentNode = child;
			}
		}

		// 2 nodes should have been found
		if(contextNode == null || contentNode == null) {
			Activator.log.error("Impossible to parse configuration for " + fragmentNode, null);
			return null;
		}

		// parses constraints that will be given to each section
		List<IConstraintDescriptor> constraints = parseConstraints(contextNode);

		// retrieve selection size
		int selectionSize = parseSelectionSize(contextNode);

		// do not parse currently the content node, will be done later, as the fragment is used
		return new FragmentDescriptor(id, constraints, contentNode, selectionSize, this);
	}

	/**
	 * Parses the specified node and returns the list of replaced dialogs
	 * 
	 * @param contextNode
	 *        the node to parse
	 * @return the list of replaced ids or an empty list if none
	 */
	protected List<String> parseReplacedDialogs(Node contextNode) {
		List<String> replacedDialogIds = new ArrayList<String>();
		// retrieve "replacedDialogs" node

		NodeList childrenNodes = contextNode.getChildNodes();
		for(int i = 0; i < childrenNodes.getLength(); i++) {
			Node childNode = childrenNodes.item(i);
			String childNodeName = childNode.getNodeName();
			if("replacedDialogs".equals(childNodeName)) {
				NodeList replacedDialogNodes = childNode.getChildNodes();
				for(int j = 0; j < replacedDialogNodes.getLength(); j++) {
					Node replacedDialogNode = replacedDialogNodes.item(j);
					if("replacedDialog".equals(replacedDialogNode.getNodeName())) {
						// this is a replaced dialog node, try to find attribute id
						NamedNodeMap attributes = replacedDialogNode.getAttributes();
						if(attributes != null) {
							Node idNode = attributes.getNamedItem(NODE_NAME_ID);
							if(idNode != null) {
								replacedDialogIds.add(idNode.getNodeValue());
							}
						}
					}
				}
			}
		}
		return replacedDialogIds;
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
		// retrieve meta class for which the fragment is valid
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
	 * @param document
	 *        the document to parse
	 * @param predefinedFragments
	 *        the list of predefined views, which will be completed during this parsing
	 * @param predefinedDialogs
	 *        list of predefined dialogs
	 * @throws XMLParseException
	 *         parsing failed
	 */
	public void parseXMLfile(Document document, Map<String, FragmentDescriptor> predefinedFragments, Map<String, DialogDescriptor> predefinedDialogs) throws XMLParseException {
		this.predefinedFragments = predefinedFragments;
		this.predefinedDialogs = predefinedDialogs;
		// this.bundle = bundle;
		NodeList roots = document.getChildNodes();
		for(int i = 0; i < roots.getLength(); i++) {
			Node fragmentsOrDialogsNode = roots.item(i);
			// check this is a "fragments" or "dialogs" node, not a comment or a text format node.
			final String topNodeName = fragmentsOrDialogsNode.getNodeName();
			if(NODE_NAME_FRAGMENTS.equals(topNodeName)) {
				parseFragmentsNode(fragmentsOrDialogsNode);
			} else if(DIALOGS_NODE_NAME.equals(topNodeName)) {
				parseDialogsNode(fragmentsOrDialogsNode);
			}
		}
	}

	/**
	 * Parses the dialogs node and adds a dialog Descriptor to the list of dialog descriptors maintained by this provider
	 * 
	 * @param dialogNode
	 *        the node to parse
	 * @throws XMLParseException
	 *         exception thrown when the file could not be parsed correctly
	 */
	protected void parseDialogsNode(Node dialogNode) throws XMLParseException {
		String pluginId = getPluginIdFromTopNode(dialogNode);
		bundle = Platform.getBundle(pluginId);

		// retrieve each child node which is a dialog
		NodeList children = dialogNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a dialog node (not a comment or a formatting children)

			Node childNode = children.item(i);
			String childNodeName = childNode.getNodeName();
			if(NODE_NAME_DIALOG.equals(childNodeName)) {
				DialogDescriptor dialogDescriptor = parseDialogNode(childNode);
				if(dialogDescriptor != null) {
					predefinedDialogs.put(dialogDescriptor.getId(), dialogDescriptor);
				}
			}
		}
	}

	/**
	 * Parses the dialog node and returns a dialog descriptor from this configuration
	 * 
	 * @param dialogNode
	 *        the node corresponding to the dialog
	 * @return the new {@link DialogDescriptor}
	 * @throws XMLParseException
	 *         parsing failed
	 */
	protected DialogDescriptor parseDialogNode(Node dialogNode) throws XMLParseException {
		// retrieve ID of the dialog (to be reused as a predefined dialog)
		NamedNodeMap attributes = dialogNode.getAttributes();
		String id;
		if(attributes != null) {
			Node idNode = attributes.getNamedItem("id");
			if(idNode != null) {
				id = idNode.getNodeValue();
			} else {
				throw new XMLParseException("Impossible to find ID for dialog " + dialogNode);
			}
		} else {
			throw new XMLParseException("Impossible to find ID for dialog " + dialogNode);
		}

		NodeList children = dialogNode.getChildNodes();
		Node contextNode = null;
		Node contentNode = null;
		Node titleNode = null;
		Node messageNode = null;

		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			final String childNodeName = child.getNodeName();
			if("context".equals(childNodeName)) {
				// this is the context of the dialog
				// store this node.
				contextNode = child;
			} else if("content".equals(childNodeName)) {
				contentNode = child;
			} else if("title".equals(childNodeName)) {
				titleNode = child;
			} else if("message".equals(childNodeName)) {
				messageNode = child;
			}
		}

		// 2 nodes should have been found
		if(contextNode == null || contentNode == null || titleNode == null || messageNode == null) {
			Activator.log.error("Impossible to parse configuration for " + dialogNode, null);
			return null;
		}

		// parses constraints that will be given to each section
		List<IConstraintDescriptor> constraints = parseConstraints(contextNode);
		int selectionSize = parseSelectionSize(contextNode);

		// parses the list of replaced dialogs
		List<String> replacedDialogIds = parseReplacedDialogs(contextNode);

		Object message = parseStringNode(messageNode);

		Object title = parseStringNode(titleNode);

		// do not parse currently the content node, will be done later, as the dialog is used
		return new DialogDescriptor(id, constraints, contentNode, selectionSize, replacedDialogIds, title, message, this);
	}

	/**
	 * Parses the title node
	 * 
	 * @param titleNode
	 *        the node to parse
	 * @return the result of the parsing
	 */
	protected Object parseStringNode(Node titleNode) {
		// two possibilities currently: only a simple string, a second one usgin a message binding
		NodeList children = titleNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			String childNodeName = child.getNodeName();
			if("string".equals(childNodeName)) {
				// there should be a value attribute
				NamedNodeMap attributes = child.getAttributes();
				if(attributes != null) {
					Node valueNode = attributes.getNamedItem("value");
					return (valueNode != null) ? valueNode.getNodeValue() : "";
				} else {
					Activator.log.warn("no attribute for title Node: " + titleNode);
				}
			} else if("emfMessageBinding".equals(childNodeName)) {
				return parseEMFBindingNode(child);
			}
		}
		return null;
	}

	/**
	 * Parses the message binding node
	 * 
	 * @param messageBindingNode
	 *        the node to parse
	 * @return the result of the parsing
	 */
	protected Object parseEMFBindingNode(Node messageBindingNode) {
		String message = null;
		List<String> featureNames = new ArrayList<String>();

		// retrieve attribute message 
		NamedNodeMap attributes = messageBindingNode.getAttributes();
		if(attributes != null) {
			Node valueNode = attributes.getNamedItem("message");
			if(valueNode != null) {
				message = valueNode.getNodeValue();
			} else {
				Activator.log.warn("ParseBindingNode: No value for message node : " + messageBindingNode);
				return null;
			}
		} else {
			Activator.log.warn("ParseBindingNode: No attributes for node: " + messageBindingNode);
			return null;
		}

		NodeList childNodes = messageBindingNode.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			Node child = childNodes.item(i);
			String childNodeName = child.getNodeName();

			if("feature".equals(childNodeName)) {
				attributes = child.getAttributes();
				if(attributes != null) {
					Node valueNode = attributes.getNamedItem("name");
					if(valueNode != null) {
						featureNames.add(valueNode.getNodeValue());
					}
				} else {
					Activator.log.warn("ParseBindingNode: No attributes for feature node: " + child);
				}
			}
		}
		// FIXME here, we should not know that we work using  EMF features...
		return new EMFFeatureBindingLabelProviderDescriptor(message, featureNames.toArray(new String[]{}));

	}

	/**
	 * Parses the fragment node and adds a fragment Descriptor to the list of fragment descriptor maintained by this provider
	 * 
	 * @param fragmentNode
	 *        the configuration node of the fragment
	 * @throws XMLParseException
	 *         parsing failed
	 */
	protected void parseFragmentsNode(Node fragmentNode) throws XMLParseException {
		String pluginId = getPluginIdFromTopNode(fragmentNode);
		bundle = Platform.getBundle(pluginId);

		// retrieve each child node which is a fragment
		NodeList children = fragmentNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a fragment node (not a comment or a formatting children)

			Node childNode = children.item(i);
			String childNodeName = childNode.getNodeName();
			if(NODE_NAME_FRAGMENT.equals(childNodeName)) {
				FragmentDescriptor fragmentDescriptor = parseFragment(childNode);
				if(fragmentDescriptor != null) {
					predefinedFragments.put(fragmentDescriptor.getId(), fragmentDescriptor);
				}
			}
		}
	}

	/**
	 * Retrieves the value of the attribute pluginId
	 * 
	 * @param topNode
	 *        the node to parse
	 * @return the id of the plugin from which class loader is used
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	protected String getPluginIdFromTopNode(Node topNode) throws XMLParseException {
		NamedNodeMap attributes = topNode.getAttributes();
		if(attributes != null) {
			Node pluginIdNode = attributes.getNamedItem("pluginId");
			if(pluginIdNode != null) {
				return pluginIdNode.getNodeValue();
			}
		}
		throw new XMLParseException("impossible to find plugin id for top node: " + topNode);
	}

	/**
	 * Parses the xml content node to set the content of the section
	 * 
	 * @param unparsedContentNode
	 *        the node to parse
	 * @return the new configuration for the section
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	public List<ContainerDescriptor> parseFragmentContentNode(Node unparsedContentNode) throws XMLParseException {
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
	 * @return the result of the parsing
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	protected ContainerDescriptor parseContainerNode(Node containerNode) throws XMLParseException {
		// retrieve layout node
		Node layoutNode = getLayoutNode(containerNode);
		LayoutDescriptor layoutDescriptor = parseLayoutNode(layoutNode);
		return new ContainerDescriptor(layoutDescriptor, containerNode);
	}

	/**
	 * Finds and return the layout node for the specified container node
	 * 
	 * @param containerNode
	 *        the node which contains the layout node
	 * @return the
	 */
	protected Node getLayoutNode(Node containerNode) {
		NodeList children = containerNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// get the name of the children,; which should equals "layout"
			Node child = children.item(i);
			if("layout".equals(child.getNodeName())) {
				return child;
			}
		}
		return null;
	}

	/**
	 * Parses the group container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 * @return the result of the parsing
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	protected ContainerDescriptor parseGroupNode(Node containerNode) throws XMLParseException {
		// retrieve layout node
		Node layoutNode = getLayoutNode(containerNode);
		LayoutDescriptor layoutDescriptor = parseLayoutNode(layoutNode);
		String label = parseLabel(containerNode);
		return new GroupContainerDescriptor(layoutDescriptor, label, containerNode);
	}

	/**
	 * Parses the expandable container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 * @return the result of the parsing
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	protected ContainerDescriptor parseExpandableContainerNode(Node containerNode) throws XMLParseException {
		// retrieve layout node
		Node layoutNode = getLayoutNode(containerNode);
		LayoutDescriptor layoutDescriptor = parseLayoutNode(layoutNode);
		String label = parseLabel(containerNode);
		return new ExpandableContainerDescriptor(layoutDescriptor, label, containerNode);
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
	 * @param layoutNode
	 *        the node to parse
	 * 
	 * @param containerNode
	 *        the container node which contains layout information
	 * @return the layout for the container
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	protected LayoutDescriptor parseLayoutNode(Node layoutNode) throws XMLParseException {
		return LayoutParser.parseLayoutNode(layoutNode);
	}

	/**
	 * Parses the node of the content for a dialog configuration
	 * 
	 * @param contentNode
	 *        the content node to parse
	 * @return the list of identifier of fragment descriptors referenced by this content node
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	public List<IFragmentDescriptor> parseDialogContentNode(Node contentNode) throws XMLParseException {
		List<IFragmentDescriptor> fragmentDescriptors = new ArrayList<IFragmentDescriptor>();
		try {
			NodeList children = contentNode.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				if(NODE_NAME_FRAGMENT.equals(childNode.getNodeName())) {
					IFragmentDescriptor descriptor = parseFragmentOrPredefinedFragment(childNode);
					fragmentDescriptors.add(descriptor);
				}
			}
		} catch (XMLParseException e) {
			Activator.log.error("Problem during parsing of replaced sections for node " + contentNode, e);
		}
		return fragmentDescriptors;
	}

	/**
	 * Parses a fragment node, either a predefined fragment or a locally defined fragment
	 * 
	 * @param fragmentNode
	 *        the node to parse
	 * @return the parsed fragment
	 * @throws XMLParseException
	 *         exception thrown when the content of the file could not be read correctly
	 */
	protected IFragmentDescriptor parseFragmentOrPredefinedFragment(Node fragmentNode) throws XMLParseException {
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

		fragmentDescriptor = parseFragment(fragmentNode);
		predefinedFragments.put(fragmentDescriptor.getId(), fragmentDescriptor);
		return fragmentDescriptor;
	}
}
