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
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.utils.PapyrusTrace;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.ExtendedProviderDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

/**
 * Class that manages the preferences for the papyrus palette
 */
public class PapyrusPalettePreferences implements IPapyrusPaletteConstant {

	/**
	 * Returns local palettes description contained in the preference field.
	 * 
	 * @return the list of local palette description
	 */
	public static List<IPaletteDescription> getLocalPalettes() {
		ArrayList<IPaletteDescription> paletteDescriptions = new ArrayList<IPaletteDescription>();
		// retrieve the value of the preference field
		XMLMemento rootMemento = getExistingLocalPalettes();
		if(rootMemento == null) {
			return paletteDescriptions;
		}
		// retrieve all palette descriptions
		for(IMemento memento : rootMemento.getChildren(PALETTE)) {
			// there should be a factory here ?!
			IPaletteDescription description = PapyrusPaletteDescription.create(memento);
			paletteDescriptions.add(description);
		}
		return paletteDescriptions;
	}

	/**
	 * @return
	 */
	public static List<IPaletteDescription> getWorkspacePalettes() {
		ArrayList<IPaletteDescription> paletteDescriptions = new ArrayList<IPaletteDescription>();
		// retrieve the value of the preference field
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		if(rootMemento == null) {
			return paletteDescriptions;
		}
		// retrieve all palette descriptions
		for(IMemento memento : rootMemento.getChildren(PALETTE)) {
			// there should be a factory here ?!
			IPaletteDescription description = PapyrusPaletteDescription.create(memento);
			paletteDescriptions.add(description);
		}
		return paletteDescriptions;
	}

	/**
	 * Returns the preference store used to store palette preferences.
	 * 
	 * @return the preference store of this plugin
	 */
	protected static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	/**
	 * Retrieves the root memento from the plugin preferences if there were
	 * existing palette customizations.
	 * 
	 * @return the root memento if there were existing customizations; null
	 *         otherwise
	 */
	protected static XMLMemento getExistingCustomizations() {
		String sValue = getPreferenceStore().getString(PALETTE_CUSTOMIZATIONS_ID);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(PALETTE_CUSTOMIZATIONS_ID);
			}
		} catch (WorkbenchException e) {
			Activator.getDefault().logError("Impossible to read preferences", e);
		}
		return null;
	}

	/**
	 * Retrieves the root memento from the plugin preferences if there were
	 * existing local palette redefinitions.
	 * 
	 * @return the root memento if there were existing customizations, a newly
	 *         created one otherwise (empty one)
	 */
	protected static XMLMemento getLocalRedefinitions() {
		String sValue = getPreferenceStore().getString(PALETTE_REDEFINITIONS);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(PALETTE_REDEFINITIONS);
			}
		} catch (WorkbenchException e) {
			Activator.getDefault().logError("Impossible to read preferences for palette local redefinitions", e);
		}
		return null;
	}

	/**
	 * Register a new local redefinition of a palette.
	 * 
	 * @param paletteID
	 *        the id of the palette to register
	 * @param path
	 *        the path to the configuration of the palette
	 * @return the memento that has been registered
	 */
	public static IMemento registerLocalRedefinition(String paletteID, String path) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// try to find an existing local definition for this palette
		IMemento memento = getPaletteRedefinitionNode(paletteID);
		// if one exists, remove it from the preferences
		if(memento != null) {
			unregisterLocalRedefinition(paletteID);
		}
		// then register the new one
		IMemento newMemento = rootMemento.createChild(PALETTE_REDEFINITION);
		newMemento.putString(ID, paletteID);
		newMemento.putString(PATH, path);
		saveLocalRedefinitions(rootMemento);
		return newMemento;
	}

	/**
	 * Unregister a specific local redefinition
	 * 
	 * @param paletteID
	 *        the identifier of the palette to unregister
	 */
	public static void unregisterLocalRedefinition(String paletteID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(PALETTE_REDEFINITIONS);
		for(IMemento memento : rootMemento.getChildren(PALETTE_REDEFINITION)) {
			if(!memento.getString(ID).equals(paletteID)) {
				newRootMemento.putMemento(memento);
			}
		}
		// save new Memento
		saveLocalRedefinitions(newRootMemento);
	}

	/**
	 * saves the given root memento with the given key in the preference area
	 * 
	 * @param xmlMemento
	 *        the memento to save
	 * @param key
	 *        the key for the preference store
	 */
	private static void saveMemento(XMLMemento xmlMemento, String key) {
		// save memento
		StringWriter writer = new StringWriter();
		try {
			xmlMemento.save(writer);
			if(getPreferenceStore() != null) {
				getPreferenceStore().setValue(key, writer.toString());
			}
		} catch (IOException e) {
			Activator.getDefault().logError("input/ouput exception", e);
		}
	}

	/**
	 * Saves the set of local redefinitions into the preference store
	 * 
	 * @param rootMemento
	 *        the memento to save
	 */
	public static void saveLocalRedefinitions(XMLMemento rootMemento) {
		saveMemento(rootMemento, PALETTE_REDEFINITIONS);
	}

	/**
	 * Saves the palette customizations into the preferences
	 * 
	 * @param rootMemento
	 *        the memento to save
	 */
	public static void saveCustomizations(XMLMemento rootMemento) {
		saveMemento(rootMemento, PALETTE_CUSTOMIZATIONS_ID);
	}

	/**
	 * Saves the list of local palettes into the preferences
	 * 
	 * @param rootMemento
	 *        the memento to save
	 */
	public static void saveLocalPalettes(XMLMemento rootMemento) {
		saveMemento(rootMemento, PALETTE_LOCAL_DEFINITIONS);
	}

	/**
	 * Saves the list of local palettes into the preferences
	 * 
	 * @param rootMemento
	 *        the memento to save
	 */
	public static void saveWorkspacePalettes(XMLMemento rootMemento) {
		saveMemento(rootMemento, PALETTE_WORKSPACE_DEFINITIONS);
	}

	/**
	 * Retrieves the memento for the current editor from the root memento
	 * 
	 * @param rootMemento
	 *        the root memento from which the editor memento is retrieved
	 * @param currentEditorClass
	 *        the current editor class name
	 * @return the memento for the current editor from the root memento or <code>null</code>;
	 */
	protected static IMemento getEditorMemento(XMLMemento rootMemento, String currentEditorClass) {
		IMemento[] editorsMementos = rootMemento.getChildren(EDITOR);
		for(IMemento editorMemento : editorsMementos) {
			String editorClass = editorMemento.getString(CLASS);
			if(currentEditorClass.equals(editorClass)) {
				return editorMemento;
			}
		}
		// create one if none was found
		IMemento memento = rootMemento.createChild(EDITOR);
		memento.putString(CLASS, currentEditorClass);
		return memento;
	}

	/**
	 * Retrieves the memento corresponding to the list of hidden palettes for a
	 * given editor part
	 * 
	 * @param part
	 *        the editor for which preferences should be found
	 * @return the memento corresponding to the hidden palettes list
	 */
	public static IMemento getEditorHiddenPalettesMemento(IMemento editorMemento) {
		IMemento hiddenPaletteMemento = editorMemento.getChild(HIDDEN_PALETTES);
		if(hiddenPaletteMemento == null) {
			hiddenPaletteMemento = editorMemento.createChild(HIDDEN_PALETTES);
		}
		return hiddenPaletteMemento;
	}

	/**
	 * Returns a String from concatened hidden palettes ids
	 * 
	 * @param hiddenPalettesMemento
	 *        the memento for the hidden palettes
	 * @return the string of ids, separated by a separator
	 */
	// @unused
	public static String getHiddenPalettes(IMemento hiddenPalettesMemento) {
		return hiddenPalettesMemento.getString(ID);
	}

	/**
	 * Returns the path for a given palette
	 * 
	 * @param paletteID
	 *        the unique identifier of the palette to retrieve
	 * @return the path to the configuration of the palette or <code>null</code> if no customization exists for this palette configuration
	 */
	public static String getPaletteRedefinition(String paletteID) {
		if(paletteID == null) {
			Activator.log.debug("Trying to find preferences for a null palette identifier");
		}
		IMemento memento = getPaletteRedefinitionNode(paletteID);
		if(memento != null) {
			return memento.getString(PATH);
		}
		return null;
	}

	/**
	 * Returns the memento associated to the palette, or <code>null</code> if
	 * none exists
	 * 
	 * @param paletteID
	 *        the identifier of the palette to find
	 * @return the memento found or <code>null</code> if no customization exists
	 *         for this palette
	 */
	private static IMemento getPaletteRedefinitionNode(String paletteID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		IMemento[] redefinitions = rootMemento.getChildren(PALETTE_REDEFINITION);
		for(IMemento redefinitionMemento : redefinitions) {
			String paletteNodeID = redefinitionMemento.getString(ID);
			// check equals. Palette ID is not null, as checked at the begining
			// of the method.
			if(paletteID.equals(paletteNodeID)) {
				return redefinitionMemento;
			}
		}
		return null;
	}

	/**
	 * Returns a list of hidden palettes ids
	 * 
	 * @param hiddenPalettesMemento
	 *        the memento for the hidden palettes
	 * @return the list of ids
	 */
	public static List<String> getHiddenPalettesList(IMemento hiddenPalettesMemento) {
		String hiddenPalettes = hiddenPalettesMemento.getString(ID);
		ArrayList<String> ids = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer((hiddenPalettes != null) ? hiddenPalettes : "", ";");
		while(tokenizer.hasMoreTokens()) {
			ids.add(tokenizer.nextToken());
		}
		return ids;
	}

	/**
	 * Changes the palette visibility
	 */
	public static void changePaletteVisibility(String providerID, IEditorPart editorClass, boolean visible) {
		changePaletteVisibility(providerID, getEditorClassName(editorClass), visible);
	}

	/**
	 * Returns the name of the class of the editor
	 * 
	 * @param editorClass
	 *        the editor for which the class name is searched
	 * @return the class name
	 */
	protected static String getEditorClassName(IEditorPart editorClass) {
		return editorClass.getClass().getName();
	}

	/**
	 * Changes the palette visibility
	 */
	public static void changePaletteVisibility(String providerID, String editorClass, boolean visible) {
		// retrieve preferences for the given editor
		XMLMemento rootMemento = getExistingCustomizations();
		IMemento editorMemento = getEditorMemento(rootMemento, editorClass);
		IMemento hiddenPalettesMemento = getEditorHiddenPalettesMemento(editorMemento);
		List<String> hiddenPalettes = getHiddenPalettesList(hiddenPalettesMemento);
		// in the list, remove or add the id of the provider descriptor
		if(hiddenPalettes.contains(providerID) && visible) {
			hiddenPalettes.remove(providerID);
		} else if(!hiddenPalettes.contains(providerID) && !visible) {
			hiddenPalettes.add(providerID);
		}
		// serialize the new list
		String newIDs = serializeHiddenPalettes(hiddenPalettes);
		// sets the new value for the memento
		hiddenPalettesMemento.putString(ID, newIDs);
		// saves the root memento
		saveCustomizations(rootMemento);
	}

	/**
	 * Returns the list of identifiers that should not be shown for the palette.
	 * 
	 * @param part
	 *        the editor for which the palette is shown
	 * @return a list of identifiers of palettes that should not be shown.
	 */
	public static List<String> getHiddenPalettes(IEditorPart part) {
		// retrieve preferences for the given editor
		XMLMemento rootMemento = getExistingCustomizations();
		IMemento editorMemento = getEditorMemento(rootMemento, part.getClass().getName());
		IMemento hiddenPalettesMemento = getEditorHiddenPalettesMemento(editorMemento);
		List<String> hiddenPalettes = getHiddenPalettesList(hiddenPalettesMemento);
		// check with the id of the editor
		if(part instanceof DiagramEditorWithFlyOutPalette) {
			String editorID = ((DiagramEditorWithFlyOutPalette)part).getContributorId();
			if(editorID!=null) {
				IMemento editorIDMemento = getEditorMemento(rootMemento, editorID);
				IMemento hiddenPalettesMementoEditorID = getEditorHiddenPalettesMemento(editorIDMemento);
				List<String> hiddenPalettesEditorId = getHiddenPalettesList(hiddenPalettesMementoEditorID);
				
				if(hiddenPalettesEditorId!=null) {
					if(hiddenPalettes !=null) {
						hiddenPalettes.addAll(hiddenPalettesEditorId);
					} else {
						hiddenPalettes = hiddenPalettesEditorId;
					}
				}
			}
		}
		
		return hiddenPalettes;
	}

	/**
	 * Serialize palettes value
	 * 
	 * @param hiddenPalettes
	 *        the list to serialize
	 * @return the new string
	 */
	protected static String serializeHiddenPalettes(List<String> hiddenPalettes) {
		// builds the new id list
		return PaletteUtil.convertToFlatRepresentation(hiddenPalettes, ";");
	}

	/**
	 * Retrieves the root memento from the plugin preferences if there were
	 * existing local palettes.
	 * 
	 * @return the root memento if there were existing customizations; null
	 *         otherwise
	 */
	protected static XMLMemento getExistingLocalPalettes() {
		String sValue = getPreferenceStore().getString(PALETTE_LOCAL_DEFINITIONS);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(PALETTE_LOCAL_DEFINITIONS);
			}
		} catch (WorkbenchException e) {
			Activator.getDefault().logError("Impossible to read preferences", e);
		}
		return null;
	}

	/**
	 * Retrieves the root memento from the plugin preferences if there were
	 * existing local palettes.
	 * 
	 * @return the root memento if there were existing customizations; null
	 *         otherwise
	 */
	protected static XMLMemento getExistingWorkspacePalettes() {
		String sValue = getPreferenceStore().getString(PALETTE_WORKSPACE_DEFINITIONS);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(PALETTE_WORKSPACE_DEFINITIONS);
			}
		} catch (WorkbenchException e) {
			Activator.getDefault().logError("Impossible to read preferences", e);
		}
		return null;
	}

	/**
	 * Adds or update local palette
	 */
	public static void addLocalPalette(String paletteID, String paletteName, ProviderPriority priority, String editorID, Set<String> requiredProfiles) {
		// retrieves memento
		XMLMemento rootMemento = getExistingLocalPalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		paletteMemento.putString(NAME, paletteName);
		paletteMemento.putString(PRIORITY, priority.getName());
		paletteMemento.putString(EDITOR_ID, editorID);
		paletteMemento.putString(PATH, getPalettePathFromID(paletteID));
		// add properties if required
		IMemento propertiesMemento = paletteMemento.createChild(IPapyrusPaletteConstant.PALETTE_DESCRIPTION_PROPERTIES);
		propertiesMemento.putString(IPapyrusPaletteConstant.PROFILE_LIST, PaletteUtil.getSerializedProfileList(requiredProfiles));
		// saves the root memento
		saveLocalPalettes(rootMemento);
	}

	/**
	 * Adds or update local palette
	 */
	public static void addWorkspacePalette(String paletteID, String paletteName, String path, ProviderPriority priority, String editorID, Set<String> requiredProfiles) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		paletteMemento.putString(NAME, paletteName);
		paletteMemento.putString(PRIORITY, priority.getName());
		paletteMemento.putString(EDITOR_ID, editorID);
		paletteMemento.putString(PATH, path);
		// add properties if required
		IMemento propertiesMemento = paletteMemento.createChild(IPapyrusPaletteConstant.PALETTE_DESCRIPTION_PROPERTIES);
		propertiesMemento.putString(IPapyrusPaletteConstant.PROFILE_LIST, PaletteUtil.getSerializedProfileList(requiredProfiles));
		// saves the root memento
		saveWorkspacePalettes(rootMemento);
	}

	/**
	 * Returns the provider priority for the palette provider with the given ID
	 */
	public static ProviderPriority getLocalPalettePriority(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingLocalPalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String palettePriority = paletteMemento.getString(PRIORITY);
		return ProviderPriority.parse(palettePriority);
	}

	/**
	 * Returns the provider priority for the palette provider with the given ID
	 */
	public static ProviderPriority getWorkspacePalettePriority(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String palettePriority = paletteMemento.getString(PRIORITY);
		if(palettePriority!=null) {
			return ProviderPriority.parse(palettePriority);
		}
		return null;
	}

	/**
	 * Returns the editor id for the palette provider with the given ID
	 */
	public static String getLocalEditorID(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingLocalPalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String editorID = paletteMemento.getString(EDITOR_ID);
		return editorID;
	}

	/**
	 * Returns the editor id for the palette provider with the given ID
	 */
	public static String getWorkspaceEditorID(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String editorID = paletteMemento.getString(EDITOR_ID);
		return editorID;
	}

	/**
	 * Returns the name for the palette provider with the given ID
	 */
	public static String getLocalPaletteName(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingLocalPalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String editorID = paletteMemento.getString(NAME);
		return editorID;
	}

	/**
	 * Returns the name for the palette provider with the given ID
	 */
	public static String getWorkspacePaletteName(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String editorID = paletteMemento.getString(NAME);
		return editorID;
	}

	/**
	 * Returns the path for the palette provider with the given ID
	 */
	public static String getLocalPalettePath(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingLocalPalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String editorID = paletteMemento.getString(PATH);
		return editorID;
	}

	/**
	 * Returns the path for the palette provider with the given ID
	 */
	public static String getWorkspacePalettePath(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		String editorID = paletteMemento.getString(PATH);
		return editorID;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static Set<String> getRequiredProfiles(String paletteID) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, paletteID);
		if(paletteMemento == null) {
			paletteMemento = createMemento(rootMemento, paletteID);
		}
		// update values in the memento
		IMemento propertiesMemento = paletteMemento.getChild(PALETTE_DESCRIPTION_PROPERTIES);
		if(propertiesMemento !=null)  {
			String profilesSerializedList = propertiesMemento.getString(PROFILE_LIST);
			if(profilesSerializedList!=null && !profilesSerializedList.isEmpty()) {
				return PaletteUtil.getProfileSetFromString(profilesSerializedList);
			}
		}
		return null;
	}

	/**
	 * Deletes a local palette definition
	 * 
	 * @param id
	 *        the id of the palette to delete
	 */
	public static void deleteLocalPalette(String id) {
		// retrieves memento
		XMLMemento rootMemento = getExistingLocalPalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, id);
		if(paletteMemento == null) {
			Activator.log.warn("impossible to find the palette with id: " + id);
			return;
		}
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(PALETTE_LOCAL_DEFINITIONS);
		for(IMemento memento : rootMemento.getChildren(PALETTE)) {
			if(!memento.getString(ID).equals(paletteMemento.getString(ID))) {
				IMemento newChild = newRootMemento.createChild(PALETTE);
				newChild.putMemento(memento);
			}
		}
		// save new Memento
		saveLocalPalettes(newRootMemento);
	}

	/**
	 * @param fileName
	 */
	public static void deleteWorkspacePalette(String id) {
		// retrieves memento
		XMLMemento rootMemento = getExistingWorkspacePalettes();
		// search existing customization
		IMemento paletteMemento = searchPaletteMemento(rootMemento, id);
		if(paletteMemento == null) {
			Activator.log.warn("impossible to find the palette in workspace with id: " + id);
			return;
		}
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(PALETTE_WORKSPACE_DEFINITIONS);
		for(IMemento memento : rootMemento.getChildren(PALETTE)) {
			if(!memento.getString(ID).equals(paletteMemento.getString(ID))) {
				IMemento newChild = newRootMemento.createChild(PALETTE);
				newChild.putMemento(memento);
			}
		}
		// save new Memento
		saveWorkspacePalettes(newRootMemento);
	}

	/**
	 * Retrieves the name of the palette file, using the palette id
	 * 
	 * @param paletteID
	 *        the id of the palette
	 * @return the name of the file
	 */
	public static String getPalettePathFromID(String paletteID) {
		return "Palette_" + paletteID + ".xml";
	}

	/**
	 * Creates the palette memento for the given palette ID, in the given
	 * memento
	 * 
	 * @param rootMemento
	 *        the memento parent of the newly created memento
	 * @param paletteID
	 *        the id of the palette to create
	 * @return the newly created memento
	 */
	protected static IMemento createMemento(XMLMemento rootMemento, String paletteID) {
		IMemento memento = rootMemento.createChild(PALETTE);
		memento.putString(ID, paletteID);
		return memento;
	}

	/**
	 * search the palette memento for the given palette ID.
	 * 
	 * @param rootMemento
	 *        the root memento to look in
	 * @param paletteID
	 *        the palette ID to search
	 * @return the palette memento or <code>null</code> if none was found.
	 */
	protected static IMemento searchPaletteMemento(XMLMemento rootMemento, String paletteID) {
		for(IMemento memento : rootMemento.getChildren(PALETTE)) {
			String id = memento.getString(ID);
			if(paletteID.equals(id)) {
				return memento;
			}
		}
		// palette not found
		return null;
	}

	/**
	 * Creates the palette redefinition for the given contribution
	 * 
	 * @param descriptor
	 *        descriptor of the contribution to redefine
	 */
	public static void createPaletteRedefinition(ExtendedProviderDescriptor descriptor) {
		// copy the file in the plugin state area
		String path = null;
		// retrieve the file in the descriptor
		path = descriptor.createLocalRedefinition();
		if(path == null) {
			Activator.log.error("There was an error during creation of the local file", null);
			return;
		}
		// finally, register the new redefinition
		registerLocalRedefinition(descriptor.getContributionID(), path);
	}
}
