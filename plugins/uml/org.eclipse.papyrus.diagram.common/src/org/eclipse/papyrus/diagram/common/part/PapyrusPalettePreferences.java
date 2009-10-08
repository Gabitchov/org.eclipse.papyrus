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

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.service.PapyrusPaletteService;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

/**
 * Class that manages the preferences for the papyrus palette
 */
public class PapyrusPalettePreferences {

	/** id for the preference store */
	public static final String PALETTE_CUSTOMIZATIONS_ID = "paletteCustomization";

	/**
	 * Returns the list of identifiers that should not be shown for the palette.
	 * 
	 * @param part
	 *            the editor for which the palette is shown
	 * @return a list of identifiers of palettes that should not be shown.
	 */
	public static List<String> getHiddenPalettes(IEditorPart part) {
		ArrayList<String> list = new ArrayList<String>();
		String currentEditorClass = part.getClass().getName();

		// get preferences for the editor
		XMLMemento memento = getExistingCustomizations();

		if (memento == null) {
			return list;
		}

		// retrieve the memento for the current editor. if not existant, create one
		IMemento editorMemento = getEditorMemento(memento, currentEditorClass);

		IMemento hiddenPaletteMemento = editorMemento.getChild("hiddenPalettes");
		if (hiddenPaletteMemento == null) {
			return list;
		}

		String paletteID = hiddenPaletteMemento.getString("id");
		if (paletteID == null) {
			return list;
		}

		StringTokenizer tokenizer = new StringTokenizer(paletteID, ";");
		while (tokenizer.hasMoreTokens()) {
			list.add(tokenizer.nextToken());
		}

		return list;
	}

	/**
	 * Returns the preference store used to store palette préferences.
	 * 
	 * @return the preference store of this plugin
	 */
	protected static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	/**
	 * Retrieves the root memento from the plugin preferences if there were existing palette
	 * customizations.
	 * 
	 * @return the root memento if there were existing customizations; null otherwise
	 */
	protected static XMLMemento getExistingCustomizations() {
		String sValue = getPreferenceStore().getString(PALETTE_CUSTOMIZATIONS_ID);
		if (sValue != null && !sValue.equals("")) { //$NON-NLS-1$
			try {
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} catch (WorkbenchException e) {
				Activator.getDefault().logError("Impossible to read preferences", e);
			}
		}
		return null;
	}

	/**
	 * Changes the visilibity of the palette.
	 * 
	 * @param providerDescriptor
	 * @param part
	 */
	public static void changePaletteVisibility(PapyrusPaletteService.ProviderDescriptor providerDescriptor,
			IEditorPart part) {
		String currentEditorClass = part.getClass().getName();
		System.err.println("currentEditorClass: " + currentEditorClass);
		XMLMemento rootMemento = getExistingCustomizations();

		if (rootMemento == null) {
			rootMemento = XMLMemento.createWriteRoot(PALETTE_CUSTOMIZATIONS_ID);
		}

		// retrieve the memento for the current editor. if not existant, create one
		IMemento editorMemento = getEditorMemento(rootMemento, currentEditorClass);

		IMemento hiddenPaletteMemento = editorMemento.getChild("hiddenPalettes");
		if (hiddenPaletteMemento == null) {
			hiddenPaletteMemento = editorMemento.createChild("hiddenPalettes");
		}

		String paletteID = hiddenPaletteMemento.getString("id");
		ArrayList<String> ids = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer((paletteID != null) ? paletteID : "", ";");
		while (tokenizer.hasMoreTokens()) {
			ids.add(tokenizer.nextToken());
		}

		String contributorID = providerDescriptor.getContributionID();

		// in the list, remove or add the id of the provider descriptor
		if (ids.contains(contributorID)) {
			ids.remove(contributorID);
		} else {
			ids.add(contributorID);
		}

		// builds the new id list
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = ids.iterator();
		while (it.hasNext()) {
			buffer.append(it.next());
			if (it.hasNext()) {
				buffer.append(";");
			}
		}

		hiddenPaletteMemento.putString("id", buffer.toString());

		// save memento
		StringWriter writer = new StringWriter();
		try {
			rootMemento.save(writer);

			if (getPreferenceStore() != null) {
				getPreferenceStore().setValue(PALETTE_CUSTOMIZATIONS_ID, writer.toString());
			}
		} catch (IOException e) {
			Activator.getDefault().logError("input/ouput exception", e);
		}
	}

	/**
	 * Retrieves the memento for the current editor from the root memento
	 * 
	 * @param rootMemento
	 *            the root memento from which the editor memento is retrieved
	 * @param currentEditorClass
	 *            the current editor class name
	 * @return the memento for the current editor from the root memento or <code>null</code>;
	 */
	protected static IMemento getEditorMemento(XMLMemento rootMemento, String currentEditorClass) {
		IMemento[] editorsMementos = rootMemento.getChildren("editor");
		for (int i = 0; i < editorsMementos.length; i++) {
			IMemento editorMemento = editorsMementos[i];
			String editorClass = editorMemento.getString("class");
			if (currentEditorClass.equals(editorClass)) {
				return editorMemento;
			}
		}

		// create one if none was found
		IMemento memento = rootMemento.createChild("editor");
		memento.putString("class", currentEditorClass);
		return memento;
	}

}
