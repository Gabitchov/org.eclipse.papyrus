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

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.customize.DefaultEntryPage;
import org.eclipse.gef.ui.palette.customize.DrawerEntryPage;
import org.eclipse.gef.ui.palette.customize.EntryPage;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.IPaletteState;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteCustomizerEx;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteDrawerState;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

/**
 * Customizer for the palette viewer
 */
public class PapyrusPaletteCustomizer extends PaletteCustomizerEx {

	/** maps that stores the modification of parents */
	protected Map<PaletteEntry, PaletteContainer> changedParents = new HashMap<PaletteEntry, PaletteContainer>();

	/**
	 * Creates a new PapyrusPaletteCustomizer.
	 * 
	 * @param preferenceStore
	 *        the preference store associated to this palette customizer
	 */
	public PapyrusPaletteCustomizer(IPreferenceStore preferenceStore) {
		super(preferenceStore);
		this.preferences = preferenceStore;
	}

	/**
	 * Returns the change parents
	 * 
	 * @return the change parents
	 */
	public Map<PaletteEntry, PaletteContainer> getChangedParents() {
		return changedParents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyCustomizationsToPalette(PaletteRoot paletteRoot) {
		XMLMemento rootMemento = getExistingCustomizations();
		if(rootMemento != null) {
			applyCustomizations(rootMemento, paletteRoot, rootMemento);
		}

		// must now clean the palette, as the element whose parent container is
		// changed is not
		// removed from its old container...
		// 1. ContainerA -< PaletteA, ContainerB
		// 2. apply customization => ContainerA -< PaletteA, ContainerB -<
		// PaletteA (setParent =
		// ContainerB)
		// 3. clean => remove PaletteA from ContainerA.
		// issue => cannot modify the list of children of containerA in
		// applyCustomization because
		// of the iterator system (concurrent modification)
		// so, clean palette using a specific method
		// 4. goal: ContainerA, ContainerB -< PaletteA

		// FIXME made by a new palette definition now
		// cleanPalette(paletteRoot);
	}

	/**
	 * Cleans the given palette root from its entries
	 * 
	 * @param paletteRoot
	 */
	protected void cleanPalette(PaletteContainer paletteContainer) {
		// copy children list, then iterate, so the original children list can
		// be modified...
		List<PaletteEntry> children = new ArrayList<PaletteEntry>(paletteContainer.getChildren().size());
		for(Object o : paletteContainer.getChildren()) {
			children.add((PaletteEntry)o);
		}

		for(PaletteEntry entry : children) {
			// if parent is not the correct one, delete this child from the
			// children list
			if(entry.getParent() != paletteContainer) {
				paletteContainer.getChildren().remove(entry);
			}
			// call for sub-containers
			if(entry instanceof PaletteContainer) {
				cleanPalette((PaletteContainer)entry);
			}
		}
	}

	/**
	 * Creation factory method for the <code>IPaletteState</code>. Clients may
	 * override to provide custom <code>IPaletteStates</code>.
	 * 
	 * @param entry
	 *        the palette entry
	 * @return a new <code>IPaletteState</code> instance.
	 */
	protected IPaletteState createPaletteState(PaletteEntry entry) {
		if(entry instanceof PaletteDrawer) {
			return new PaletteDrawerState((PaletteDrawer)entry);
		} else {
			// specific papyrus entry state. It manages at least the parent
			// customization
			return new PapyrusPaletteEntryState(entry);
		}
	}

	/**
	 * id used in the workspace preference store for palette customizations
	 */
	private static final String PALETTE_CUSTOMIZATIONS_ID = "org.eclipse.gmf.runtime.diagram.ui.paletteCustomizations"; //$NON-NLS-1$

	/**
	 * Matches each palette entry with a palette state.
	 */
	private HashMap<PaletteEntry, IPaletteState> paletteStates = new HashMap<PaletteEntry, IPaletteState>();

	/**
	 * the preference store in which the palette customizations are to be saved
	 * and retrieved from
	 */
	private IPreferenceStore preferences;

	public EntryPage getPropertiesPage(PaletteEntry entry) {
		if(entry.getType().equals(PaletteDrawer.PALETTE_TYPE_DRAWER)) {
			return new PapyrusDrawerEntryPage();
		}
		return new PapyrusDefaultEntryPage();
	}

	/**
	 * Stores the palette state for a given palette entry if the state has not
	 * yet been stored.
	 * 
	 * @param entry
	 *        the palette entry
	 */
	public void storePaletteState(PaletteEntry entry) {
		if(paletteStates.get(entry) != null) {
			// the palette state has already been stored
			return;
		}

		IPaletteState paletteState = createPaletteState(entry);
		paletteState.storeState();

		paletteStates.put(entry, paletteState);
	}

	public void revertToSaved() {
		for(Iterator<Entry<PaletteEntry, IPaletteState>> iterator = paletteStates.entrySet().iterator(); iterator.hasNext();) {
			Entry<PaletteEntry, IPaletteState> entry = iterator.next();
			entry.getValue().rollback();
		}
		paletteStates.clear();
	}

	public void save() {
		if(paletteStates.isEmpty()) {
			return;
		}

		// If there are already existing palette customizations we will add to
		// them, otherwise, create a new XML memento which makes it easy to save
		// the customizations in a tree format.
		XMLMemento rootMemento = getExistingCustomizations();
		if(rootMemento == null) {
			rootMemento = XMLMemento.createWriteRoot(PALETTE_CUSTOMIZATIONS_ID);
		}
		for(Iterator<Entry<PaletteEntry, IPaletteState>> iterator = paletteStates.entrySet().iterator(); iterator.hasNext();) {
			Entry<PaletteEntry, IPaletteState> entry = iterator.next();

			IMemento memento = getMementoForEntry(rootMemento, entry.getKey());
			if(memento != null) {
				entry.getValue().storeChangesInMemento(memento);
			}
		}

		StringWriter writer = new StringWriter();
		try {
			rootMemento.save(writer);

			if(preferences != null) {
				preferences.setValue(PALETTE_CUSTOMIZATIONS_ID, writer.toString());
			}
		} catch (IOException e) {
			Activator.getDefault().logError("Error while saving preferences for palette", e);
		}

		paletteStates.clear();
	}

	/**
	 * Given the rootMemento, gets the memento that already exists for the
	 * palette entry or creates a new one in the rootMemento (and the necessary
	 * palette container mementos) if one does not exist yet. The root memento's
	 * tree structure matches that of the palette root. If a palette entry in
	 * stack A, in drawer B is customized, the root memento will have a child
	 * memento for drawer B which has a child memento for stack A which has a
	 * child memento for the entry. The memento's use the palette entry's id.
	 * 
	 * @param rootMemento
	 *        the root memento representing the palette root
	 * @param paletteEntry
	 *        the palette entry for which a memento should be retrieved or
	 *        created
	 * @return returns the memento that already exists for the palette entry or
	 *         creates a new one in the rootMemento if one does not exist yet or
	 *         null if the memento could not be created (most likely because the
	 *         palete id is not acceptable).
	 */
	private IMemento getMementoForEntry(IMemento rootMemento, PaletteEntry paletteEntry) {

		ArrayList<String> idList = new ArrayList<String>();
		idList.add(paletteEntry.getId());

		// modification of GMF code to have the parent. takes the default parent
		// instead of the
		// actual one...
		PaletteContainer parent = changedParents.get(paletteEntry);
		if(parent == null) {
			parent = paletteEntry.getParent();
		}
		while(parent != null && !PaletteRoot.PALETTE_TYPE_ROOT.equals(parent.getType())) {
			idList.add(parent.getId());
			parent = parent.getParent();
		}

		// go through ids in reverse order and create the mementos as necessary
		IMemento containerMemento = rootMemento;
		for(int i = idList.size() - 1; i >= 0; i--) {
			String id = idList.get(i);
			IMemento memento = containerMemento.getChild(id);
			if(memento == null) {
				try {
					memento = containerMemento.createChild(id);
				} catch (Exception e) {
					Activator.getDefault().logError("Error while reading preferences for palette", e);
					return null;
				}
			}
			containerMemento = memento;
		}

		return containerMemento;
	}

	/**
	 * Recursive helper method to apply the palette customizations in a memento
	 * to a palette container.
	 * 
	 * @param containerMemento
	 *        the mememto where the container's customizations are stored
	 * @param paletteContainer
	 *        the palette container on which to apply the customizations
	 */
	private void applyCustomizations(IMemento containerMemento, PaletteContainer paletteContainer, IMemento rootMemento) {

		for(Iterator iterator = paletteContainer.getChildren().iterator(); iterator.hasNext();) {
			PaletteEntry entry = (PaletteEntry)iterator.next();
			IMemento childMemento = containerMemento.getChild(entry.getId());
			if(childMemento != null) {
				// check that the memento does not change the parent of the
				// entry
				if(isChangingParent(entry, childMemento)) {
					changedParents.put(entry, entry.getParent());
				}

				IPaletteState state = createPaletteState(entry);
				state.applyChangesFromMemento(childMemento);
				if(entry instanceof PaletteContainer) {
					applyCustomizations(childMemento, (PaletteContainer)entry, rootMemento);
				}
			}

		}
	}

	protected boolean isChangingParent(PaletteEntry entry, IMemento childMemento) {
		String parentId = childMemento.getString(PapyrusPaletteEntryState.PARENT_ID_KEY);
		if(parentId == null) {
			return false;
		}
		return !(entry.getParent().getId().equals(parentId));
	}

	/**
	 * Retrieves the root memento from the workspace preferences if there were
	 * existing palette customizations.
	 * 
	 * @return the root memento if there were existing customizations; null
	 *         otherwise
	 */
	private XMLMemento getExistingCustomizations() {
		if(preferences != null) {
			String sValue = preferences.getString(PALETTE_CUSTOMIZATIONS_ID);
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				try {
					XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
					return rootMemento;
				} catch (WorkbenchException e) {
					Activator.getDefault().logError("Error while reading preferences for palette", e);
				}
			}
		}
		return null;
	}

	/**
	 * Customized so that the palette state can be saved before the change is
	 * made to the palette model so that: <li>when the cancel button is pressed, the stored state can be restored</li> <li>when the save button is
	 * pressed, the customizations made since the state was stored can be written to the workspace preferences</li>
	 */
	private class PapyrusDefaultEntryPage extends DefaultEntryPage {

		protected void handleDescriptionChanged(String text) {
			storePaletteState(getEntry());
			super.handleDescriptionChanged(text);
		}

		protected void handleHiddenSelected(boolean isChecked) {
			storePaletteState(getEntry());
			super.handleHiddenSelected(isChecked);
		}

		protected void handleNameChanged(String text) {
			storePaletteState(getEntry());
			super.handleNameChanged(text);
		}

	}

	/**
	 * Customized so that the palette state can be saved before the change is
	 * made to the palette model so that: <li>when the cancel button is pressed, the stored state can be restored</li> <li>when the save button is
	 * pressed, the customizations made since the state was stored can be written to the workspace preferences</li>
	 */
	public class PapyrusDrawerEntryPage extends DrawerEntryPage {

		protected void handleOpenSelected(boolean selection) {
			storePaletteState(getEntry());
			super.handleOpenSelected(selection);
		}

		protected void handlePinSelected(boolean selection) {
			storePaletteState(getEntry());
			super.handlePinSelected(selection);
		}

		protected void handleDescriptionChanged(String text) {
			storePaletteState(getEntry());
			super.handleDescriptionChanged(text);
		}

		protected void handleHiddenSelected(boolean isChecked) {
			storePaletteState(getEntry());
			super.handleHiddenSelected(isChecked);
		}

		protected void handleNameChanged(String text) {
			storePaletteState(getEntry());
			super.handleNameChanged(text);
		}
	}
}
