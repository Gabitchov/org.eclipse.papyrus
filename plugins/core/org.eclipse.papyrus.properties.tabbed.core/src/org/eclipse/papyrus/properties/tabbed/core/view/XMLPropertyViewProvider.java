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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Provider for property views, using an xml view definition
 */
public class XMLPropertyViewProvider extends AbstractProvider {

	/** attribute name for tab identifier */
	protected static final String TAB_ID = "tabId";

	/** attribute name for adapter identifier */
	protected static final String ADAPTER_ID = "adapterId";

	/** node name for sections */
	protected static final String SECTION_NODE_NAME = "section";

	/** node name for tab */
	protected static final String NODE_NAME_TAB = "tab";

	/** node name for view */
	protected static final String NODE_NAME_VIEW = "view";

	/** node name for id */
	protected static final String NODE_NAME_ID = "id";

	/** key for the value: path to the xml file */
	protected static final String XML_PATH = "path";

	/** key for the value: property view conribution */
	protected static final String PROPERTY_VIEW_CONTRIBUTION = "PropertyViewContribution";

	/** key for the value: icon path */
	protected static final String ICON = "icon";

	/** key for the value: description */
	protected static final String DESCRIPTION = "description";

	/** key for the value: name */
	protected static final String NAME = "name";

	/** key for the id attribute */
	protected static final String ID = "id";

	/** key for the category attribute */
	protected static final String CATEGORY = "category";

	/** key for the label attribute */
	protected static final String LABEL = "label";

	/** list of view descriptors. These descriptors contain configuration element, but not already parsed */
	@Deprecated
	List<ViewDescriptor> descriptors = new ArrayList<ViewDescriptor>();

	/** tab descriptors */
	List<ITabDescriptor> tabDescriptors = new ArrayList<ITabDescriptor>();

	/** name of the contribution */
	private String name;

	/** icon of the contribution */
	private ImageDescriptor iconDescriptor = null;

	/** description of the contribution */
	private String description;

	/**
	 * @{inheritDoc
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreatePropertyViewCompositeOperation) {
			return true;
		} /*
		 * else if(operation instanceof CanContributeToViewOperation) {
		 * return true;
		 * }
		 */else if(operation instanceof GetTabDescriptorsFromConfiguration) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the name of the contribution
	 * 
	 * @return the name of the contribution
	 */
	public String getContributionName() {
		return name;
	}

	/**
	 * Returns the icon descriptor of the contribution
	 * 
	 * @return the icon descriptor of the contribution
	 */
	public ImageDescriptor getIconDescriptor() {
		return iconDescriptor;
	}

	/**
	 * Returns the description of the contribution
	 * 
	 * @return the description of the contribution
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Configures this provider, retrieving the xml file and parsing it.
	 * 
	 * @param element
	 *        the configuration element for this provider
	 */
	public void configure(IConfigurationElement element) {
		// 1. retrieve path of the xml file
		IConfigurationElement[] children = element.getChildren();
		for(IConfigurationElement child : children) {
			if(PROPERTY_VIEW_CONTRIBUTION.equals(child.getName())) {
				// this is one of the configuration, parses the config itself, i.e. retrieve the xml file
				name = child.getAttribute(NAME);
				description = child.getAttribute(DESCRIPTION);
				String iconPath = child.getAttribute(ICON);
				if(iconPath != null) {
					iconDescriptor = Activator.imageDescriptorFromPlugin(element.getContributor().getName(), iconPath);
				}
				readXMLConfiguration(child);

			}
		}
	}

	/**
	 * Reads the xml configuration file and constructs the ViewDescriptors
	 */
	protected void readXMLConfiguration(IConfigurationElement child) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// retrieve xml file from path
			String path = child.getAttribute(XML_PATH);
			File file = getXmlFile(child, path);
			// the file should never be null in this implementation, but sub-classes could return null
			if(file == null) {
				throw new IOException("Impossible to load file: " + path);
			} else if(!file.exists()) {
				throw new IOException("Impossible to load file: " + file);
			} else {
				Document document = documentBuilder.parse(file);
				NodeList views = document.getChildNodes();
				for(int i = 0; i < views.getLength(); i++) {
					Node propertyViewNode = views.item(i);
					// check this is a property view, not a comment or a text format node.
					if("propertyView".equals(propertyViewNode.getNodeName())) {
						parsePropertyViewNode(propertyViewNode);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		} catch (SAXException e) {
			Activator.log.error(e);
		}

	}

	/**
	 * Parses the property view node and adds a view Descriptor to the list of view descriptor maintained by this provider
	 * 
	 * @param propertyViewNode
	 *        the configuration node of the property view
	 */
	protected void parsePropertyViewNode(Node propertyViewNode) {
		// retrieve each child node which is a view
		NodeList children = propertyViewNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a view node (not a comment or a formatting children)

			Node childNode = children.item(i);
			String childNodeName = childNode.getNodeName();
			if(NODE_NAME_VIEW.equals(childNodeName)) {
				parseView(childNode);
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
	 * Parses the view node
	 * 
	 * @param viewNode
	 *        the node corresponding to the view
	 */
	protected void parseView(Node viewNode) {

		// the child is divided into 2 parts: 
		// the first one describes the context for the view to be displayed,
		// the second one describes the content of the view itself

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
			return;
		}

		// parses constraints that will be given to each section
		List<IConstraintDescriptor> constraints = parseConstraints(contextNode);

		// parse size
		int selectionSize = parseSelectionSize(contextNode);


		// creates DynamicSectionDescriptors from model
		// DynamicSectionDescriptor sectionDescriptor = new DynamicSectionDescriptor(id, tabId)
		NodeList sectionNodes = contentNode.getChildNodes();
		for(int i = 0; i < sectionNodes.getLength(); i++) {
			Node child = sectionNodes.item(i);
			final String childNodeName = child.getNodeName();
			if(SECTION_NODE_NAME.equals(childNodeName)) {
				// 2 cases, only one taken into account for now: predefined sections and local sections.
				parseSectionNode(child, constraints, selectionSize);
			}
		}
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
						elementClass = Class.forName(elementClassName);
						constraintDescriptors.add(new ObjectTypeConstraintDescriptor(elementClass));
					} catch (ClassNotFoundException e) {
						Activator.log.error(e);
					}
				}
			}
		}
		return constraintDescriptors;
	}

	/**
	 * Parses the section node and add the found sections in their corresponding tab descriptors
	 * 
	 * @param sectionNode
	 *        the section node to parse
	 */
	@SuppressWarnings("unchecked")
	protected void parseSectionNode(Node sectionNode, List<IConstraintDescriptor> constraints, int selectionSize) {
		// retrieve ID and tab ID
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
		try {
			NodeList children = sectionNode.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node replacedSectionsNode = children.item(i);
				if("replacedSections".equals(replacedSectionsNode.getNodeName())) {
					replacedSectionsId = parseReplacedSectionIds(replacedSectionsNode);
				}
			}
		} catch (XMLParseException e) {
			Activator.log.error("Problem during parsing of replaced sections for node " + sectionNode, e);
		}

		DynamicSectionDescriptor descriptor = new DynamicSectionDescriptor(id, tabId, constraints, selectionSize, adapterId, replacedSectionsId);
		descriptor.setUnparsedContent(sectionNode);

		// retrieve the tab to add section to it.
		// this means that the descriptor for the tab should already exist.
		for(ITabDescriptor tabDescriptor : tabDescriptors) {
			if(tabDescriptor.getId().equals(tabId)) {
				tabDescriptor.getSectionDescriptors().add(descriptor);
			}
		}

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
	 * Indicates if this provider is able to contribute to the property view
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return <code>true</code> if this provider is able to contribute to the property view
	 */
	@Deprecated
	public boolean canContributeToPropertyView(List<Object> objectsToEdit) {
		List<ViewDescriptor> descriptors = retrieveViewDescriptor(objectsToEdit);
		return descriptors.size() > 0;
	}

	/**
	 * Contributes to the property view
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 */
	@Deprecated
	public List<PropertyEditorController> contributeToPropertyView(List<Object> objectsToEdit, Composite parent) {
		// retrieve the correct descriptor that manages the list of objects 
		List<ViewDescriptor> descriptors = retrieveViewDescriptor(objectsToEdit);

		ArrayList<PropertyEditorController> controllers = new ArrayList<PropertyEditorController>();
		// check that at least one descriptor was found
		if(descriptors == null) {
			// returns the list, which is empty
			return controllers;
		}

		// makes the contribution for each descriptor
		for(ViewDescriptor descriptor : descriptors) {

			List<IPropertyEditorControllerDescriptor> configurations = descriptor.getUnchachedDescriptors();

			for(IPropertyEditorControllerDescriptor controllerDescriptor : configurations) {
				PropertyEditorController controller = PropertyEditorControllerService.getInstance().createPropertyEditorController(objectsToEdit, parent, controllerDescriptor);

				if(controller != null) {
					controllers.add((PropertyEditorController)controller);
					controller.createPropertyEditor(controllerDescriptor.getEditorDescriptor());
				}
			}
		}

		return controllers;
	}

	/**
	 * Creates the property editor controller and the controlled editor
	 * 
	 * @param objectsToEdit
	 * 
	 * @return the created controller
	 */
	public PropertyEditorController createControllerEditor(List<Object> objectsToEdit, IPropertyEditorControllerDescriptor controllerDescriptor, Composite parent) {
		PropertyEditorController controller = PropertyEditorControllerService.getInstance().createPropertyEditorController(objectsToEdit, parent, controllerDescriptor);

		if(controller != null) {
			controller.createPropertyEditor(controllerDescriptor.getEditorDescriptor());
		}
		return controller;
	}


	/**
	 * Look in the list of available descriptors and returns the good one or <code>null</code> if none was found
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return the correct {@link ViewDescriptor} or <code>null</code>
	 */
	@Deprecated
	protected List<ViewDescriptor> retrieveViewDescriptor(List<Object> objectsToEdit) {
		// retrieve multi or single selection
		boolean isMultiSelection = objectsToEdit.size() > 1;

		Class<?> objectClass = null;

		if(isMultiSelection) {
			// retrieve common ancestor for the selection
			objectClass = retrieveCommonAncestor(objectsToEdit);
		} else {
			// only one selected element, it should be ok for the class 
			objectClass = objectsToEdit.get(0).getClass();
		}

		// retrieve the list of valid descriptors
		List<ViewDescriptor> validDescriptors = new ArrayList<ViewDescriptor>();
		for(ViewDescriptor descriptor : descriptors) {
			// check for the single selection descriptor
			Class<?> descriptorClass = descriptor.getElementClass();

			// FIXME: check additional constraints (applied profiles, stereotypes, etc)

			boolean isValid = true;
			if(!descriptorClass.isAssignableFrom(objectClass)) {
				isValid = false;
			}
			if(!descriptor.isMultiSelectionView() && isMultiSelection) {
				isValid = false;
			}

			if(isValid) {
				validDescriptors.add(descriptor);
			}
		}

		// if the list contains only one object, it should be ok to return the view descriptor
		if(validDescriptors.size() == 0) {
			if(Activator.log.isDebugEnabled()) {
				Activator.log.debug("impossible to find a descriptor for class " + objectClass);
			}
			return Collections.emptyList();
		} else if(validDescriptors.size() == 1) {
			return validDescriptors;
		} else {
			return findBestDescriptor(validDescriptors, objectClass);
		}
	}

	/**
	 * Returns the last selection of View descriptor used in the preferences
	 * 
	 * @param validDescriptors
	 *        the list of valid descriptors
	 * @param objectClass
	 *        the class to be edited
	 * @return the last selection of View descriptor used in the preferences
	 */
	@Deprecated
	protected List<ViewDescriptor> findBestDescriptor(List<ViewDescriptor> validDescriptors, Class<?> objectClass) {
		// FIXME check preferences to get the last selected descriptors
		return validDescriptors.subList(0, 1);
	}

	/**
	 * Returns the common class between each selected object
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return the common class for each element
	 */
	protected Class<?> retrieveCommonAncestor(List<Object> objectsToEdit) {
		// FIXME return the common class, not only the first one...
		return objectsToEdit.get(0).getClass();
	}

	/**
	 * Retrieves the xml file configuring the property view
	 */
	public File getXmlFile(IConfigurationElement element, String path) throws IOException {
		// try to read it in a plugin...
		Bundle bundle = Platform.getBundle(element.getContributor().getName());
		if(bundle != null) {
			URL urlFile = bundle.getEntry(path);
			urlFile = FileLocator.resolve(urlFile);
			urlFile = FileLocator.toFileURL(urlFile);
			if("file".equals(urlFile.getProtocol())) { //$NON-NLS-1$
				return new File(urlFile.getFile());
			}
		}
		return null;
	}

	/**
	 * Returns the list of tab descriptors for tab described in the configuration file
	 * 
	 * @return the list of tab descriptors for tab described in the configuration file or an empty list
	 */
	public List<ITabDescriptor> getTabDescriptors() {
		return tabDescriptors;
	}

}
