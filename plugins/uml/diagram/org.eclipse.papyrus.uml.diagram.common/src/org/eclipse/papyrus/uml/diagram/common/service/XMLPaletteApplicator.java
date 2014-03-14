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
 *  Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Refactoring
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.w3c.dom.Node;

/**
 * Standard implementation of the palette factory. This one should be use to
 * provide palette content
 */
public class XMLPaletteApplicator implements XMLPaletteDefinitionVisitor, IPapyrusPaletteConstant {

	/**
	 * The diagram owning which palette is to be filled
	 */
	private Diagram diagram;
	
	/**
	 * Target palette to be filled
	 */
	private PaletteRoot target;
	
	/**
	 * Map of predefined entries
	 */
	private Map<String, PaletteEntry> predefinedEntries;
	
	/**
	 * Creates a new XMLDefinitionPaletteFactory
	 * 
	 * @param diagram The diagram to provide for
	 * @param target The root of the palette to provide for
	 * @param predefinedEntries existing predefined entries
	 */
	public XMLPaletteApplicator(Diagram diagram, PaletteRoot target, Map<String, PaletteEntry> predefinedEntries) {
		this.diagram = diagram;
		this.target = target;
		this.predefinedEntries = predefinedEntries;
	}

	/**
	 * {@inheritDoc}
	 */
	public void onContent(Node node) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void onDrawer(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if(entry == null) {
			String name = node.getAttributes().getNamedItem(NAME).getNodeValue();
			String iconPath = node.getAttributes().getNamedItem(ICON_PATH).getNodeValue();
			entry = new PaletteDrawer(name);
			entry.setId(id);
			entry.setDescription("Drawer " + name);
			if(iconPath != null && !iconPath.equals("")) {
				entry.setSmallIcon(Activator.getImageDescriptor(iconPath));
				entry.setLargeIcon(Activator.getImageDescriptor(iconPath));
			}
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(computePath(node), entry);
	}

	/**
	 * returns the path for the given
	 * 
	 * @param node
	 *        the node for which the path is computed
	 * @return the path to this element
	 */
	protected String computePath(Node node) {
		String path = "/";
		Node parentNode = node;
		while(parentNode.getParentNode() != null && !parentNode.getParentNode().getNodeName().equals(CONTENT)) {
			parentNode = parentNode.getParentNode();
			path = "/" + parentNode.getAttributes().getNamedItem(ID).getNodeValue() + path;
		}
		return path;
	}

	/**
	 * {@inheritDoc}
	 */
	public void onSeparator(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if(entry == null) {
			entry = new PaletteSeparator(id);
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(computePath(node), entry);

	}

	/**
	 * {@inheritDoc}
	 */
	public void onStack(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if(entry == null) {
			// everything can be null for the constructor
			entry = new PaletteStack(null, null, null);
			entry.setId(id);
			predefinedEntries.put(id, entry);
		}
		appendPaletteEntry(computePath(node), entry);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onToolEntry(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		if (PolicyChecker.getCurrent().isInPalette(diagram, id))
			appendPaletteEntry(computePath(node), entry);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onAspectToolEntry(Node node) {
		final String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		final String refToolID = node.getAttributes().getNamedItem(REF_TOOL_ID).getNodeValue();

		Node nameNode = node.getAttributes().getNamedItem(NAME);
		Node descNode = node.getAttributes().getNamedItem(DESCRIPTION);
		Node iconPathNode = node.getAttributes().getNamedItem(ICON_PATH);

		final Map<Object, Object> properties = new HashMap<Object, Object>();
		if(node.getChildNodes().getLength() > 0) {
			properties.put(ASPECT_ACTION_KEY, node.getChildNodes());
		}

		final CombinedTemplateCreationEntry entry = (CombinedTemplateCreationEntry)predefinedEntries.get(refToolID);
		if(entry == null) {
			Activator.log.error("could not find entry " + refToolID, null);
			return;
		}

		ImageDescriptor iconDesc = null;
		String name = null;
		String desc = null;

		if(iconPathNode != null) {
			iconDesc = Activator.getImageDescriptor(iconPathNode.getNodeValue());
		} else {
			iconDesc = entry.getSmallIcon();
		}
		if(nameNode != null) {
			name = nameNode.getNodeValue();
		} else {
			name = entry.getLabel();
		}
		if(descNode != null) {
			desc = descNode.getNodeValue();
		} else {
			desc = entry.getDescription();
		}

		CombinedTemplateCreationEntry realEntry = new AspectCreationEntry(name, desc, id, iconDesc, entry, properties);

		predefinedEntries.put(id, realEntry);
		if (PolicyChecker.getCurrent().isInPalette(diagram, id))
			appendPaletteEntry(computePath(node), realEntry);
	}

	/**
	 * Appends the given palette entry to the appropriate location in either a
	 * predefined palette entry or the palette root.
	 * 
	 * @param path
	 * @param paletteEntry
	 */
	private void appendPaletteEntry(String path, PaletteEntry paletteEntry) {
		PaletteEntry fEntry = findPaletteEntry(path);
		if(fEntry == null) {
			fEntry = findPredefinedEntry(path);
		}
		if(fEntry == null) {
			Activator.log.error("Invalid palette entry path: " + path, null);
		} else if(fEntry instanceof PaletteContainer) {
			// remove if it already exists
			if(!((PaletteContainer)fEntry).getChildren().contains(paletteEntry)) {
				((PaletteContainer)fEntry).add(paletteEntry);
			}
		} else if(fEntry instanceof PaletteSeparator) {
			appendTo((PaletteSeparator)fEntry, paletteEntry);
		} else
			fEntry.getParent().add(fEntry.getParent().getChildren().indexOf(fEntry) + 1, paletteEntry);
	}

	/**
	 * Finds a palette container using the given path
	 * 
	 * @param path
	 * @return the container or <code>null</code> if not found
	 */
	private PaletteEntry findPaletteEntry(String path) {
		PaletteEntry current = target;
		StringTokenizer tokens = new StringTokenizer(path, "/"); //$NON-NLS-1$
		while(tokens.hasMoreElements()) {
			if(current instanceof PaletteContainer)
				current = findChildPaletteEntry((PaletteContainer)current, tokens.nextToken());
			else
				return null;
		}
		return current;
	}

	/**
	 * Finds a palette entry starting from the given container and using the
	 * given path
	 * 
	 * @param container
	 * @param childId
	 * @return the entry or <code>null</code> if not found
	 */
	private PaletteEntry findChildPaletteEntry(PaletteContainer container, String childId) {
		Iterator entries = container.getChildren().iterator();
		while(entries.hasNext()) {
			PaletteEntry entry = (PaletteEntry)entries.next();
			if(entry.getId().equals(childId))
				return entry;
		}
		return null;
	}

	/**
	 * Searches the predefined entries for a palette entry given the full path
	 * as it was predefined.
	 * 
	 * @param path
	 *        the path to the palette entry starting as it was predefined
	 * @return the palette entry if one exists; null otherwise.
	 */
	private PaletteEntry findPredefinedEntry(String path) {
		StringTokenizer tokens = new StringTokenizer(path, "/"); //$NON-NLS-1$

		PaletteEntry root = (PaletteEntry)predefinedEntries.get(tokens.nextToken());

		while(tokens.hasMoreElements()) {
			if(root instanceof PaletteContainer)
				root = findChildPaletteEntry((PaletteContainer)root, tokens.nextToken());
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
	private void appendTo(PaletteSeparator separator, PaletteEntry entry) {
		List children = separator.getParent().getChildren();
		int index = children.indexOf(separator);
		for(index++; index < children.size(); index++) {
			if(children.get(index) instanceof PaletteSeparator)
				break;
		}
		separator.getParent().add(index, entry);
	}

}
