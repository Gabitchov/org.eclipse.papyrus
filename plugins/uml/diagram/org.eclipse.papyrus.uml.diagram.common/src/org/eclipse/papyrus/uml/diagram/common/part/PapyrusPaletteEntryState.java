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

package org.eclipse.papyrus.uml.diagram.common.part;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteEntryState;
import org.eclipse.ui.IMemento;

/**
 * Extended palette state, that also manages parent modification, etc.
 */
public class PapyrusPaletteEntryState extends PaletteEntryState {

	/** key for the parent field */
	public static final String PARENT_ID_KEY = "parent";

	/** value of the parent ID field */
	protected String parentID;

	/**
	 * Creates a new PapyrusPaletteEntryState.
	 * 
	 * @param entry
	 *        the palette entry to manage
	 */
	public PapyrusPaletteEntryState(PaletteEntry entry) {
		super(entry);
	}

	public void applyChangesFromMemento(IMemento entryMemento) {
		super.applyChangesFromMemento(entryMemento);
		PaletteEntry entry = getPaletteEntry();

		String sValue = entryMemento.getString(PARENT_ID_KEY);
		if(sValue != null) {
			if(!entry.getParent().getId().equals(sValue)) {
				// adds to the new container, but does nto remove from old one,
				// because of
				// iterator...
				PaletteContainer container = PaletteUtil.getContainerByID(entry, sValue);
				container.add(entry);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void rollback() {
		super.rollback();
		PaletteEntry entry = getPaletteEntry();
		entry.setParent(PaletteUtil.getContainerByID(entry, parentID));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void storeChangesInMemento(IMemento memento) {
		super.storeChangesInMemento(memento);

		PaletteEntry entry = getPaletteEntry();

		// stores the parent id name
		if(parentID != null && !parentID.equals(entry.getParent().getId()) || (parentID == null && entry.getParent() != null)) {
			memento.putString(PARENT_ID_KEY, entry.getParent().getId());
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void storeState() {
		super.storeState();
		PaletteEntry entry = getPaletteEntry();
		parentID = entry.getParent().getId();
	}

}
