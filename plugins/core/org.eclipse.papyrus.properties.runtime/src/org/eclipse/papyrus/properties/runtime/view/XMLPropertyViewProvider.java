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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
import org.eclipse.papyrus.properties.runtime.dialogs.GetDialogDescriptorOperation;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Provider for property views, using an xml view definition
 */
public class XMLPropertyViewProvider extends AbstractProvider implements IPropertyViewProvider {

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

	/** name of the contribution */
	protected String name;

	/** icon of the contribution */
	protected ImageDescriptor iconDescriptor = null;

	/** description of the contribution */
	protected String description;

	/** parser for the configuration file */
	protected PropertyViewProviderParser parser = null;

	/** list of predefined views */
	protected final Map<String, ViewDescriptor> predefinedViews = new HashMap<String, ViewDescriptor>();

	/** list of predefined dialogs */
	protected final Map<String, DialogDescriptor> predefinedDialogs = new HashMap<String, DialogDescriptor>();

	/**
	 * Returns the parser for the xml configuration file
	 * 
	 * @return the parser for the xml configuration file
	 */
	public PropertyViewProviderParser getParser() {
		if(parser == null) {
			parser = createParser();
		}
		return parser;
	}

	/**
	 * Creates the parser for the configuration file
	 * 
	 * @return the parser for the configuration file
	 */
	protected PropertyViewProviderParser createParser() {
		return new PropertyViewProviderParser();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetPropertyViewDescriptorOperation) {
			return managesViewDescriptor(((GetPropertyViewDescriptorOperation)operation).getDescriptorID());
		} else if(operation instanceof GetDialogDescriptorOperation) {
			return managesDialogDescriptor(((GetDialogDescriptorOperation)operation).getDescriptorID());
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
		Bundle bundle = Platform.getBundle(element.getContributor().getName());
		if(bundle == null) {
			Activator.log.warn("Ignoring extension " + element + ". Impossible to find bundle " + bundle);
			return;
		}
		for(IConfigurationElement child : children) {
			if(PROPERTY_VIEW_CONTRIBUTION.equals(child.getName())) {
				// this is one of the configuration, parses the config itself, i.e. retrieve the xml file
				name = child.getAttribute(NAME);
				description = child.getAttribute(DESCRIPTION);
				String iconPath = child.getAttribute(ICON);
				if(iconPath != null) {
					iconDescriptor = Activator.imageDescriptorFromPlugin(element.getContributor().getName(), iconPath);
				}
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				documentBuilderFactory.setNamespaceAware(true);
				try {
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

					// retrieve xml file from path
					String path = child.getAttribute(XML_PATH);
					File file = getXmlFile(child, path, bundle);
					// the file should never be null in this implementation, but sub-classes could return null
					if(file == null) {
						throw new IOException("Impossible to load file: " + path);
					} else if(!file.exists()) {
						throw new IOException("Impossible to load file: " + file);
					} else {
						Document document = documentBuilder.parse(file);
						NodeList viewNodes = document.getChildNodes();
						getParser().parseXMLfile(viewNodes, this.predefinedViews, this.predefinedDialogs, bundle);
					}
				} catch (ParserConfigurationException e) {
					Activator.log.error(e);
				} catch (IOException e) {
					Activator.log.error(e);
				} catch (SAXException e) {
					Activator.log.error(e);
				} catch (XMLParseException e) {
					Activator.log.error(e);
				}
			}
		}
	}

	/**
	 * Retrieves the xml file configuring the property view
	 */
	public File getXmlFile(IConfigurationElement element, String path, Bundle bundle) throws IOException {
		// try to read it in a plugin...
		URL urlFile = bundle.getEntry(path);
		urlFile = FileLocator.resolve(urlFile);
		urlFile = FileLocator.toFileURL(urlFile);
		if("file".equals(urlFile.getProtocol())) { //$NON-NLS-1$
			return new File(urlFile.getFile());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ViewDescriptor getViewDescriptor(String descriptorID) {
		return predefinedViews.get(descriptorID);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean managesViewDescriptor(String descriptorId) {
		return predefinedViews.containsKey(descriptorId);
	}

	/**
	 * {@inheritDoc}
	 */
	public DialogDescriptor getDialogDescriptor(String descriptorID) {
		return predefinedDialogs.get(descriptorID);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean managesDialogDescriptor(String descriptorId) {
		return predefinedDialogs.containsKey(descriptorId);
	}

}
