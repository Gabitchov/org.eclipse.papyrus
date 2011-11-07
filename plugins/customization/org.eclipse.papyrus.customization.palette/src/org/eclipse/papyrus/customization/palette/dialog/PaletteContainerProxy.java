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
package org.eclipse.papyrus.customization.palette.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.papyrus.customization.palette.dialog.LocalPaletteContentPage.EntryType;

/**
 * Proxy class for container entries
 */
public class PaletteContainerProxy extends PaletteEntryProxy {

	/** list of children for this container */
	protected List<PaletteEntryProxy> children = new ArrayList<PaletteEntryProxy>();

	/**
	 * Creates a new PaletteContainer
	 * 
	 * @param drawer
	 *        the drawer to cache
	 */
	public PaletteContainerProxy(PaletteContainer drawer) {
		super(drawer);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public String getDescription() {
		return getEntry().getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteContainer getEntry() {
		return (PaletteContainer)super.getEntry();
	}

	/**
	 * Method to add a child proxy to this proxy
	 * 
	 * @param entry
	 *        the entry to add
	 */
	@Override
	public void addChild(PaletteEntryProxy entry) {
		children.add(entry);
		entry.setParent(this);
		super.addChild(entry);
	}

	/**
	 * Method to add a child proxy to this proxy, before the given element
	 * 
	 * @param entry
	 *        the entry to add
	 * @param nextElement
	 *        the element that should be just after the entry
	 */
	@Override
	public void addChild(PaletteEntryProxy entry, PaletteEntryProxy nextElement) {
		children.add(children.indexOf(nextElement), entry);
		entry.setParent(this);
		super.addChild(entry, nextElement);
	}

	/**
	 * Remove the specified children from its parent
	 * 
	 * @param proxy
	 *        the proxy to remove
	 */
	@Override
	public void removeChild(PaletteEntryProxy proxy) {
		children.remove(proxy);
		proxy.setParent(null);
		super.removeChild(proxy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntryType getType() {
		return EntryType.DRAWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PaletteEntryProxy> getChildren() {
		return children;
	}
}
