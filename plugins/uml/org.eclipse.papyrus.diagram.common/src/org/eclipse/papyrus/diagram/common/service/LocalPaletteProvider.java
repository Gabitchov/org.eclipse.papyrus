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

package org.eclipse.papyrus.diagram.common.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.part.IPaletteDescription;
import org.eclipse.ui.IEditorPart;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Provider for Palette that uses a XML file for palette definition.
 */
public class LocalPaletteProvider extends AbstractProvider implements IPaletteProvider, IPapyrusPaletteConstant {

	/**
	 * The list of palette provider XML contributions
	 */
	private NodeList contributions = null;

	/**
	 * The pluginID of the XML contributions
	 */
	private String pluginID;

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {
		for (int i = 0; i < contributions.getLength(); i++) {
			Node node = contributions.item(i);
			if (PALETTE_DEFINITION.equals(node.getNodeName())) {
				parsePaletteDefinition(node, root, predefinedEntries);
			}
		}
	}

	/**
	 * Parse the given node, assuming its type is a palette definition
	 * 
	 * @param node
	 *            the node to parse
	 */
	protected void parsePaletteDefinition(Node paletteDefinitionNode, PaletteRoot root,
			Map<String, PaletteEntry> predefinedEntries) {
		NodeList nodes = paletteDefinitionNode.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (CONTENT.equals(node.getNodeName())) {
				parsePaletteContent(node, root, predefinedEntries, "/");
			}
		}
	}

	/**
	 * Parse the given node, assuming its type is a palette content
	 * 
	 * @param node
	 *            the node to parse
	 * @param root
	 *            the palette root to fill
	 */
	protected void parsePaletteContent(Node paletteContentNode, PaletteRoot root,
			Map<String, PaletteEntry> predefinedEntries, String path) {
		NodeList nodes = paletteContentNode.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			PaletteEntry entry = null;
			String name = node.getNodeName();
			if (DRAWER.equals(name)) {
				entry = parserDrawerNode(node, root, predefinedEntries, path);
			} else if (STACK.equals(name)) {
				entry = parserStackNode(node, root, predefinedEntries, path);
			} else if (TOOL.equals(name)) {
				entry = parseToolNode(node, root, predefinedEntries, path);
			} else if (SEPARATOR.equals(name)) {
				entry = parseSeparatorNode(node, root, predefinedEntries, path);
			}

		}
	}

	/**
	 * Parse the given node, assuming its type is a palette drawer
	 * 
	 * @param node
	 *            the node to parse
	 * @param root
	 *            the palette root to fill
	 */
	protected PaletteEntry parserDrawerNode(Node node, PaletteRoot root, Map<String, PaletteEntry> predefinedEntries,
			String path) {
		// retrieve the drawer in the predefined entries
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if (entry == null) {
			String name = node.getAttributes().getNamedItem(NAME).getNodeValue();
			String iconPath = node.getAttributes().getNamedItem(ICON_PATH).getNodeValue();
			entry = new PaletteDrawer(name);
			entry.setId(id);
			entry.setDescription("Drawer " + name);
			if (iconPath != null && !iconPath.equals("")) {
				entry.setSmallIcon(Activator.getImageDescriptor(iconPath));
				entry.setLargeIcon(Activator.getImageDescriptor(iconPath));
			}
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(root, predefinedEntries, path, entry);
		if (node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node, root, predefinedEntries, path + entry.getId());
		}
		return entry;
	}

	/**
	 * Parse the given node, assuming its type is a stack
	 * 
	 * @param node
	 *            the node to parse
	 * @param root
	 *            the palette root to fill
	 */
	protected PaletteEntry parserStackNode(Node node, PaletteRoot root, Map<String, PaletteEntry> predefinedEntries,
			String path) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		appendPaletteEntry(root, predefinedEntries, path, entry);

		if (node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node, root, predefinedEntries, entry.getId());
		}
		return entry;
	}

	/**
	 * Parse the given node, assuming its type is a node
	 * 
	 * @param node
	 *            the node to parse
	 * @param root
	 *            the palette root to fill
	 */
	protected PaletteEntry parseToolNode(Node node, PaletteRoot root, Map<String, PaletteEntry> predefinedEntries,
			String path) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		appendPaletteEntry(root, predefinedEntries, path, entry);

		if (node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node, root, predefinedEntries, entry.getId());
		}
		return entry;
	}

	/**
	 * Parse the given node, assuming its type is a separator
	 * 
	 * @param node
	 *            the node to parse
	 * @param root
	 *            the palette root to fill
	 */
	protected PaletteEntry parseSeparatorNode(Node node, PaletteRoot root, Map<String, PaletteEntry> predefinedEntries,
			String path) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if (entry == null) {
			entry = new PaletteSeparator(id);
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(root, predefinedEntries, path, entry);

		if (node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node, root, predefinedEntries, entry.getId());
		}
		return entry;
	}

	/**
	 * Finds a palette entry starting from the given container and using the given path
	 * 
	 * @param root
	 * @param path
	 * @return the entry or <code>null</code> if not found
	 */
	private static PaletteEntry findChildPaletteEntry(PaletteContainer container, String childId) {
		Iterator entries = container.getChildren().iterator();
		while (entries.hasNext()) {
			PaletteEntry entry = (PaletteEntry) entries.next();
			if (entry.getId().equals(childId))
				return entry;
		}
		return null;
	}

	/**
	 * Appends the given palette entry to the appropriate location in either a predefined palette
	 * entry or the palette root.
	 * 
	 * @param root
	 * @param predefinedEntries
	 *            map of predefined palette entries where the key is the palette entry id and the
	 *            value is the palette entry
	 * @param path
	 * @param paletteEntry
	 */
	private static void appendPaletteEntry(PaletteRoot root, Map predefinedEntries, String path,
			PaletteEntry paletteEntry) {
		PaletteEntry fEntry = findPaletteEntry(root, path);
		if (fEntry == null) {
			fEntry = findPredefinedEntry(predefinedEntries, path);
		}
		if (fEntry == null)
			Log.info(Activator.getDefault(), IStatus.ERROR, "Invalid palette entry path"); //$NON-NLS-1$                
		else if (fEntry instanceof PaletteContainer) {
			// remove if it already exists
			if (!((PaletteContainer) fEntry).getChildren().contains(paletteEntry)) {
				((PaletteContainer) fEntry).add(paletteEntry);
			}
		} else if (fEntry instanceof PaletteSeparator)
			appendTo((PaletteSeparator) fEntry, paletteEntry);
		else
			fEntry.getParent().add(fEntry.getParent().getChildren().indexOf(fEntry) + 1, paletteEntry);
	}

	/**
	 * Finds a palette container starting from the given root and using the given path
	 * 
	 * @param root
	 * @param aPath
	 * @return the container or <code>null</code> if not found
	 */
	private static PaletteEntry findPaletteEntry(PaletteEntry root, String aPath) {
		StringTokenizer tokens = new StringTokenizer(aPath, "/"); //$NON-NLS-1$
		while (tokens.hasMoreElements()) {
			if (root instanceof PaletteContainer)
				root = findChildPaletteEntry((PaletteContainer) root, tokens.nextToken());
			else
				return null;
		}
		return root;
	}

	/**
	 * Searches the predefined entries for a palette entry given the full path as it was predefined.
	 * 
	 * @param predefinedEntries
	 *            map of predefined palette entries where the key is the palette entry id and the
	 *            value is the palette entry
	 * @param path
	 *            the path to the palette entry starting as it was predefined
	 * @return the palette entry if one exists; null otherwise.
	 */
	private static PaletteEntry findPredefinedEntry(Map predefinedEntries, String path) {
		StringTokenizer tokens = new StringTokenizer(path, "/"); //$NON-NLS-1$

		PaletteEntry root = (PaletteEntry) predefinedEntries.get(tokens.nextToken());

		while (tokens.hasMoreElements()) {
			if (root instanceof PaletteContainer)
				root = findChildPaletteEntry((PaletteContainer) root, tokens.nextToken());
			else
				return null;
		}
		return root;
	}

	/**
	 * Appends the given entry to the end of the group of the given separator.
	 * 
	 * @param separator
	 * @param entry
	 */
	private static void appendTo(PaletteSeparator separator, PaletteEntry entry) {
		List children = separator.getParent().getChildren();
		int index = children.indexOf(separator);
		for (index++; index < children.size(); index++) {
			if (children.get(index) instanceof PaletteSeparator)
				break;
		}
		separator.getParent().add(index, entry);
	}

	/**
	 * Adds the configuration elements to the list of palette provider XML contributions
	 * 
	 * @param configElement
	 *            the configuration element from which information are retrieved
	 */
	public void setContributions(IConfigurationElement configElement) {
		pluginID = configElement.getContributor().getName();

		// tries to read the XML configuration file
		readXMLDocument(configElement.getAttribute(PATH));
	}

	/**
	 * locally defines palette
	 * 
	 * @param description
	 *            the description of the palette to build
	 */
	public void setContributions(IPaletteDescription description) {
		readXMLDocument(description.getContributions());
	}

	/**
	 * Reads the XML configuration for the specified element
	 * 
	 * @param contribution
	 *            the path for the xml file
	 */
	protected void readXMLDocument(Object contribution) {
		if (contribution instanceof String) {
			readXMLDocument((String) contribution);

		}

	}

	/**
	 * Reads the XML configuration for the specified element
	 * 
	 * @param iConfigurationElement
	 *            the path for the xml file
	 */
	protected void readXMLDocument(String path) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Bundle bundle = Platform.getBundle(pluginID);
			// URL url = bundle.getEntry(path);

			File file = Activator.getDefault().getStateLocation().append(path).toFile();
			if (!file.exists()) {
				Activator.getDefault().logError("Impossible to load file: " + file);
			} else {
				Document document = documentBuilder.parse(file);
				contributions = document.getChildNodes();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		return false;
	}

}
