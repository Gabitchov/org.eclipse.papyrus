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
package org.eclipse.papyrus.views.properties.runtime.controller.predefined;

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
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * Provider for property controllers that are configured using an xml file
 */
public class PredefinedPropertyControllerProvider extends AbstractProvider {

	/** PREDEFINED_ID */
	public static final String PREDEFINED_ID = "predefinedId";

	/** key for the value: path to the xml file */
	protected static final String XML_PATH = "path";

	/** predefined controllers identified by their unique predefined identifier (faster search) */
	private Map<String, PredefinedControllerDescriptor> predefinedControllers = new HashMap<String, PredefinedControllerDescriptor>();

	/** bundle that declares this provider */
	private Bundle bundle = null;

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreatePredefinedPropertyControllerProviderOperation) {
			return predefinedControllers.containsKey(((CreatePredefinedPropertyControllerProviderOperation)operation).getPredefinedID());
		} else if(operation instanceof GetAllPredefinedPropertyEditorControllersOperation) {
			return true;
		}
		return false;
	}

	/**
	 * Configures this provider, given the configuration element
	 * 
	 * @param providerConfiguration
	 *        the configuration element
	 */
	public void configure(IConfigurationElement providerConfiguration) {
		// for each property editors defined in the provider, retrieves important information
		for(IConfigurationElement element : providerConfiguration.getChildren()) {
			// check this child is really configuring editors (not a Priority child...)
			if("PredefinedControllers".equals(element.getName())) {
				// parse this editor configuration
				// there should be an xml path
				bundle = Platform.getBundle(providerConfiguration.getContributor().getName());
				assert (bundle != null) : "bundle should not be null when loading predefined controllers";

				readXMLConfiguration(element);
				//controllers.put(configuration.getId(), configuration);
			}
		}
	}

	/**
	 * Reads the xml configuration file and constructs the descriptors
	 * 
	 * @param element
	 *        the configuration element to read
	 */
	protected void readXMLConfiguration(IConfigurationElement element) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// retrieve xml file from path
			String pluginID = element.getContributor().getName();
			Bundle bundle = Platform.getBundle(pluginID);
			if(bundle != null) {
				URL xmlURL = bundle.getEntry(element.getAttribute(XML_PATH));
				Document document = documentBuilder.parse(new InputSource(xmlURL.toString()));
				NodeList views = document.getChildNodes();
				for(int i = 0; i < views.getLength(); i++) {
					Node predefinedControllerNode = views.item(i);
					// check this is a property view, not a comment or a text format node.
					if("predefinedControllers".equals(predefinedControllerNode.getNodeName())) {
						parsePredefinedControllersNode(predefinedControllerNode);
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
	 * Creates, configures and returns the controller.
	 * 
	 * @param predefinedID
	 *        the id of the controller to create
	 * 
	 * @return the created controller
	 */
	public IPropertyEditorControllerDescriptor retrievePropertyEditorControllerDescriptor(String predefinedID) {
		return predefinedControllers.get(predefinedID);
	}

	/**
	 * Returns the list of all predefined controllers proposed by this provider
	 * 
	 * @return the list of all predefined controllers proposed by this provider
	 */
	public Map<String, PredefinedControllerDescriptor> getAllPredefinedProviders() {
		return predefinedControllers;
	}

	/**
	 * Retrieves the xml file configuring the property view
	 * 
	 * @param element
	 *        the configuration element to read
	 * @param path
	 *        the path for the file to retrieve
	 * @return the file that configures the controllers
	 * @throws IOException
	 *         exception thrown when the file could not be read
	 */
	public File getXmlFile(IConfigurationElement element, String path) throws IOException {
		// try to read it in a plugin...
		Bundle bundle = Platform.getBundle(element.getContributor().getName());
		Activator.log.debug((bundle != null) ? bundle.toString() : "not a bundle");

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
	 * Parses the predefined Controllers node
	 * 
	 * @param predefinedControllerNode
	 *        the configuration node of the predefined Controllers
	 */
	protected void parsePredefinedControllersNode(Node predefinedControllerNode) {
		// retrieve each child node which is a view
		NodeList children = predefinedControllerNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			// check this is a view node (not a comment or a formatting children)

			Node childNode = children.item(i);
			if("predefinedController".equals(childNode.getNodeName())) {
				parsePredefinedController(childNode);
			}
		}

	}

	/**
	 * Parses the predefined controller node
	 * 
	 * @param childNode
	 *        the node to parse
	 */
	protected void parsePredefinedController(Node childNode) {
		if(childNode.hasAttributes()) {
			Node controllerIDNode = childNode.getAttributes().getNamedItem("id");
			Node predefinedIDNode = childNode.getAttributes().getNamedItem(PREDEFINED_ID);

			if(controllerIDNode != null && predefinedIDNode != null) {
				String controllerID = controllerIDNode.getNodeValue();
				String predefinedID = predefinedIDNode.getNodeValue();

				// retrieve other informations using the specific descriptors of each controller
				IPropertyEditorControllerDescriptor descriptor = PropertyEditorControllerService.getInstance().createPropertyEditorControllerDescriptor(controllerID, childNode, bundle);
				predefinedControllers.put(predefinedID, new PredefinedControllerDescriptor(predefinedID, descriptor));
			}
		} else {
			Activator.log.error("Impossible to find attributes for predefined controller node", null);
		}
	}
}
