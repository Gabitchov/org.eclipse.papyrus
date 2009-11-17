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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.w3c.dom.Node;

/**
 * Standard implementation of the palette factory. This one should be use to provide palette content
 */
public class XMLDefinitionPaletteFactory extends AbstractXMLDefinitionPaletteFactory implements IPapyrusPaletteConstant {

	/** palette root for the palette to be built */
	protected PaletteRoot root;

	/** map of predefined entries */
	protected Map<String, PaletteEntry> predefinedEntries;

	/**
	 * Creates a new XMLDefinitionPaletteFactory
	 * 
	 * @param root
	 *            the palette root to fill
	 * @param predefinedEntries
	 *            existing predefined entries
	 */
	public XMLDefinitionPaletteFactory(PaletteRoot root, Map<String, PaletteEntry> predefinedEntries) {
		this.root = root;
		this.predefinedEntries = predefinedEntries;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseContentNode(Node node) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseDrawerNode(Node node) {
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
		appendPaletteEntry(root, predefinedEntries, computePath(node), entry);
	}

	/**
	 * returns the path for the given
	 * 
	 * @param node
	 *            the node for which the path is computed
	 * @return the path to this element
	 */
	protected String computePath(Node node) {
		String path = "/";
		Node parentNode = node;
		while (parentNode.getParentNode() != null && !parentNode.getParentNode().getNodeName().equals(CONTENT)) {
			parentNode = parentNode.getParentNode();
			path = "/" + parentNode.getAttributes().getNamedItem(ID).getNodeValue() + path;
		}
		return path;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseSeparatorNode(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if (entry == null) {
			entry = new PaletteSeparator(id);
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(root, predefinedEntries, computePath(node), entry);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseStackNode(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if (entry == null) {
			// everything can be null for the constructor
			entry = new PaletteStack(null, null, null);
			entry.setId(id);
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(root, predefinedEntries, computePath(node), entry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseToolEntryNode(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		appendPaletteEntry(root, predefinedEntries, computePath(node), entry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseAspectToolEntryNode(Node node) {
		final String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		final String name = node.getAttributes().getNamedItem(NAME).getNodeValue();
		final String desc = node.getAttributes().getNamedItem(DESCRIPTION).getNodeValue();
		Node iconPathNode = node.getAttributes().getNamedItem(ICON_PATH);
		ImageDescriptor descriptor = null;
		if (iconPathNode != null) {
			final String iconPath = iconPathNode.getNodeValue();
			descriptor = Activator.getImageDescriptor(iconPath);
		}

		// 
		final String refToolID = node.getAttributes().getNamedItem(REF_TOOL_ID).getNodeValue();

		String stereotypesToApplyQN = null;

		// retrieve pre and post actions
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node childNode = node.getChildNodes().item(i);
			String childName = childNode.getNodeName();
			if (POST_ACTION.equals(childName)) {
				// node is a post action => retrieve what to do
				stereotypesToApplyQN = childNode.getAttributes().getNamedItem(STEREOTYPES_TO_APPLY).getNodeValue();
			} else if (PRE_ACTION.equals(childName)) {
				// no implementation yet
			}
		}

		final PaletteToolEntry entry = (PaletteToolEntry) predefinedEntries.get(refToolID);
		if (entry == null) {
			PapyrusTrace.log(IStatus.WARNING, "could not find entry " + refToolID);
			return;
		}
		final Map properties = new HashMap();

		if (stereotypesToApplyQN != null && !"".equals(stereotypesToApplyQN)) {
			List<String> stereotypesList = PaletteUtil.getStereotypeListFromString(stereotypesToApplyQN);
			properties.put(STEREOTYPES_TO_APPLY_KEY, stereotypesList);
		}

		if (descriptor == null && entry != null) {
			descriptor = entry.getSmallIcon();
		}
		CombinedTemplateCreationEntry realEntry = new AspectCreationEntry(name, desc, id, descriptor, entry, properties);
		predefinedEntries.put(id, realEntry);
		appendPaletteEntry(root, predefinedEntries, computePath(node), realEntry);
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
			PapyrusTrace.log(IStatus.ERROR, "Invalid palette entry path: " + path); //$NON-NLS-1$                
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

}
