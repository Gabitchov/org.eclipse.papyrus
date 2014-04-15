/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.part.IPaletteDescription;
import org.eclipse.ui.IEditorPart;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Provider for Palette that uses a XML file for palette definition.
 */
public class LocalPaletteProvider extends AbstractProvider implements IPaletteProvider, IPapyrusPaletteConstant, IProfileDependantPaletteProvider {

	/**
	 * The list of palette provider XML contributions
	 */
	protected NodeList contributions = null;
	
	/** list of required applied profile */
	protected Collection<String> requiredProfiles;

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> getRequiredProfiles() {
		if(contributions==null) {
			return Collections.emptyList();
		}
		if(requiredProfiles == null) {
			requiredProfiles = new HashSet<String>();

			try {
				// parse the content of the file to discover the required
				// profiles
				// using safe computation
				XMLPaletteDefinitionProfileInspector inspector = new XMLPaletteDefinitionProfileInspector();
				XMLPaletteDefinitionWalker walker = new XMLPaletteDefinitionWalker(inspector);
				for(int i = 0; i < contributions.getLength(); i++) {
					Node node = contributions.item(i);
					if(PALETTE_DEFINITION.equals(node.getNodeName())) {
						walker.walk(node);
						requiredProfiles.addAll(inspector.getRequiredProfiles());
					}
				}
			} catch (Throwable e) {
				Activator.log.error(e);
			}
		}
		return requiredProfiles;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {
		if(contributions ==null) {
			return;
		}
		XMLPaletteDefinitionWalker walker = new XMLPaletteDefinitionWalker(new XMLPaletteApplicator(((DiagramEditor) editor).getDiagram(), root, predefinedEntries));
		
		for(int i = 0; i < contributions.getLength(); i++) {
			Node node = contributions.item(i);
			if(PALETTE_DEFINITION.equals(node.getNodeName())) {
				walker.walk(node);
			}
		}
	}

	/**
	 * Adds the configuration elements to the list of palette provider XML
	 * contributions
	 * 
	 * @param configElement
	 *        the configuration element from which information are retrieved
	 */
	public void setContributions(IConfigurationElement configElement) {
		// tries to read the XML configuration file
		readXMLDocument(configElement.getAttribute(PATH));
	}

	/**
	 * locally defines palette
	 * 
	 * @param description
	 *        the description of the palette to build
	 */
	public void setContributions(IPaletteDescription description) {
		readXMLDocument(description.getContributions());
	}

	/**
	 * Reads the XML configuration for the specified element
	 * 
	 * @param contribution
	 *        the path for the xml file
	 */
	protected void readXMLDocument(Object contribution) {
		if(contribution instanceof String) {
			readXMLDocument((String)contribution);
		}
	}

	/**
	 * Reads the XML configuration for the specified element
	 * 
	 * @param iConfigurationElement
	 *        the path for the xml file
	 */
	protected void readXMLDocument(String path) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			InputStream inputStream = getXmlFile(path);
			// the file should never be null in this implementation, but
			// sub-classes could return null
			if(inputStream == null) {
				contributions = new EmptyNodeList();
				Activator.log.debug("Impossible to load file: " + path);
			} else {
				Document document = documentBuilder.parse(inputStream);
				contributions = document.getChildNodes();
				if(contributions == null) {
					contributions = new EmptyNodeList();
				}
			}
		} catch (ParserConfigurationException e) {
			Activator.log.error(e);
			contributions = new EmptyNodeList();
		} catch (IOException e) {
			Activator.log.error(e);
			contributions = new EmptyNodeList();
		} catch (SAXException e) {
			Activator.log.error(e);
			contributions = new EmptyNodeList();
		}
	}

	/**
	 * Returns the file using the specified path in the plugin state location
	 * 
	 * @param path
	 *        the path to the file
	 * @return the file using the specified path in the plugin state location,
	 *         even if it does not exists. In the latter case, the method {@link File#exists()} returns <code>false</code>.
	 */
	public InputStream getXmlFile(String path) throws IOException {
		return new FileInputStream(Activator.getDefault().getStateLocation().append(path).toFile());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		return false;
	}

	/**
	 * empty node list implementation
	 */
	public class EmptyNodeList implements NodeList {

		/**
		 * {@inheritDoc}
		 */
		public int getLength() {
			return 0;
		}

		/**
		 * {@inheritDoc}
		 */
		public Node item(int index) {
			return null;
		}

	}

}
