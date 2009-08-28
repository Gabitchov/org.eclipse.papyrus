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

package org.eclipse.papyrus.diagram.common.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.ui.IMemento;

/**
 * Utility class for palette.
 */
public class PaletteUtil {

	/**
	 * Returns the parent container by its ID
	 * 
	 * @param entry
	 *            the palette container for which parent container is looked
	 * @param parentID
	 *            the id of the parent container
	 * @return the parent
	 */
	@SuppressWarnings("unchecked")
	public static PaletteContainer getContainerByID(PaletteContainer container, String parentID) {
		// check this element is the searched parent;
		if (parentID.equals(container.getId())) {
			return container;
		}

		// element is not the parent. Look its children
		Iterator<PaletteContainer> it = getDirectChildContainers(container).iterator();
		while (it.hasNext()) {
			PaletteContainer tmp = getContainerByID(it.next(), parentID);
			if (tmp != null) {
				return tmp;
			}
		}
		return null;
	}

	/**
	 * Returns the parent container by its ID
	 * 
	 * @param entry
	 *            the palette entry for which parent container is looked
	 * @param parentID
	 *            the id of the parent container
	 * @return the parent
	 */
	@SuppressWarnings("unchecked")
	public static PaletteContainer getContainerByID(PaletteEntry entry, String parentID) {
		// retrieve the root
		PaletteContainer root = getRoot(entry);
		return getContainerByID(root, parentID);
	}

	public static List<PaletteContainer> getDirectChildContainers(PaletteContainer container) {
		List<PaletteContainer> containers = new ArrayList<PaletteContainer>();
		Iterator<PaletteEntry> it = container.getChildren().iterator();
		while (it.hasNext()) {
			PaletteEntry entry = it.next();
			if (entry instanceof PaletteContainer) {
				containers.add((PaletteContainer) entry);
			}
		}
		return containers;
	}

	/**
	 * Retrieves the root element for the given container
	 * 
	 * @param container
	 *            the container for which the root is searched
	 * @return the root of the container
	 */
	public static PaletteContainer getRoot(PaletteContainer container) {
		// if container has a parent, returns it.
		if (container.getParent() != null) {
			return getRoot(container.getParent());
		}
		// else, root element is the container itself.
		return container;
	}

	/**
	 * Retrieves the root element for the given palette entry
	 * 
	 * @param container
	 *            the container for which the root is searched
	 * @return the root of the container
	 */
	public static PaletteContainer getRoot(PaletteEntry entry) {
		return getRoot(entry.getParent());
	}

	/**
	 * Default constructor. Should never be used, as method are static in this class.
	 */
	private PaletteUtil() {

	}

	/**
	 * return tool entries for the given {@link PaletteContainer} and its sub-containers
	 * 
	 * @param container
	 *            the container that contains the ToolEntries
	 * @return the list of tool entries or an empty list
	 */
	public static List<ToolEntry> getAllToolEntries(PaletteContainer container) {
		final List<ToolEntry> entries = new ArrayList<ToolEntry>();
		Iterator<PaletteEntry> it = container.getChildren().iterator();
		while (it.hasNext()) {
			PaletteEntry entry = it.next();
			if (entry instanceof ToolEntry) {
				entries.add((ToolEntry) entry);
			}
			if (entry instanceof PaletteContainer) {
				entries.addAll(getAllToolEntries((PaletteContainer) entry));
			}
		}
		return entries;
	}

	/**
	 * Looks for the memento with the correct id from the root momento
	 * 
	 * @param rootMemento
	 *            the root memento from which the memento is searched
	 * @param id
	 *            the id of the memento to search
	 * @return the memento with the given ID or <code>null</code> if no memento was found
	 */
	public static IMemento getMemento(IMemento rootMemento, String id) {
		IMemento memento = null;
		memento = rootMemento.getChild(id);
		return memento;
	}
}
