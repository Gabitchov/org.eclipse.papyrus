/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
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
package org.eclipse.papyrus.infra.extendedtypes.preferences;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

/**
 * Preferences management for extended types
 */
public class ExtendedTypesPreferences {

	/** id for the preference store for extended types redefinitions */
	public final static String EXTENDED_TYPES_REDEFINITIONS = "extendedTypesRedefinitions"; //$NON-NLS-1$

	/** id for the node: extended types redefinition */
	public final static String EXTENDED_TYPES_REDEFINITION = "extendedTypesRedefinition"; //$NON-NLS-1$

	public static final String EXTENDED_TYPES_SET_WORKSPACE_DEFINITION = "extendedTypeSetsWorkspaceDefinition";

	/** name of the ID attribute */
	public final static String ID = "id"; //$NON-NLS-1$

	/** name for the field giving the path to the XML file */
	public final static String PATH = "path"; //$NON-NLS-1$

	/**
	 * Returns the preference store used to store extended types preferences.
	 * 
	 * @return the preference store of the plugin
	 */
	protected static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	/**
	 * Retrieves the root memento from the plugin preferences for all extended types redefinition
	 * redefinitions.
	 * 
	 * @return the root memento if there were existing customizations, a newly created one otherwise (empty one)
	 */
	protected static XMLMemento getLocalRedefinitions() {
		String sValue = getPreferenceStore().getString(EXTENDED_TYPES_REDEFINITIONS);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(EXTENDED_TYPES_REDEFINITIONS);
			}
		} catch (WorkbenchException e) {
			Activator.log.error("Impossible to read preferences for extended types local redefinitions", e);
		}
		return null;
	}

	/**
	 * Register a new local redefinition of a extendedTypes.
	 * 
	 * @param extendedTypesID
	 *        the id of the extendedTypes to register
	 * @param path
	 *        the path to the configuration of the extendedTypes
	 * @return the memento that has been registered
	 */
	public static IMemento registerLocalRedefinition(String extendedTypesID, String path) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// try to find an existing local definition for this extendedTypes
		IMemento memento = getExtendedTypesRedefinitionNode(extendedTypesID);
		// if one exists, remove it from the preferences
		if(memento != null) {
			unregisterLocalRedefinition(extendedTypesID);
		}
		// then register the new one
		IMemento newMemento = rootMemento.createChild(EXTENDED_TYPES_REDEFINITION);
		newMemento.putString(ID, extendedTypesID);
		newMemento.putString(PATH, path);
		saveLocalRedefinitions(rootMemento);
		return newMemento;
	}

	/**
	 * Returns the memento associated to the extendedTypes, or <code>null</code> if none exists
	 * 
	 * @param extendedTypesID
	 *        the identifier of the extendedTypes to find
	 * @return the memento found or <code>null</code> if no customization exists for this extendedTypes
	 */
	private static IMemento getExtendedTypesRedefinitionNode(String extendedTypesID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		IMemento[] redefinitions = rootMemento.getChildren(EXTENDED_TYPES_REDEFINITION);
		for(IMemento redefinitionMemento : redefinitions) {
			String extendedTypesNodeID = redefinitionMemento.getString(ID);
			// check equals. extendedTypes ID is not null, as checked at the begining of the method.
			if(extendedTypesID.equals(extendedTypesNodeID)) {
				return redefinitionMemento;
			}
		}
		return null;
	}

	/**
	 * Returns the memento associated to the extendedTypes set definition in workspace, or <code>null</code> if none exists
	 * 
	 * @return the memento found or <code>null</code> if no customization exists for this extendedTypes
	 */
	protected static IMemento[] getWorkspaceDefinitions() {
		XMLMemento rootMemento = getLocalRedefinitions();
		IMemento[] workspaceDefinitions = rootMemento.getChildren(EXTENDED_TYPES_SET_WORKSPACE_DEFINITION);
		return workspaceDefinitions;
	}

	/**
	 * Returns the memento associated to the extendedTypes set definition in workspace, or <code>null</code> if none exists
	 * 
	 * @return the memento found or <code>null</code> if no customization exists for this extendedTypes
	 */
	protected static IMemento getWorkspaceDefinition(String extendedTypeSetsID) {
		if(extendedTypeSetsID == null) {
			return null;
		}
		IMemento[] workspaceDefinitions = getWorkspaceDefinitions();
		if(workspaceDefinitions == null || workspaceDefinitions.length == 0) {
			return null;
		}
		for(IMemento memento : workspaceDefinitions) {
			String id = memento.getString(ID);
			if(extendedTypeSetsID.equals(id)) {
				return memento;
			}
		}
		return null;
	}

	/**
	 * Returns the path for a given extended type local redefinition
	 * 
	 * @param extendedTypesID
	 *        the unique identifier of the extended type to retrieve
	 * @return the path to the configuration of the extended types or <code>null</code> if no customization exists for this extended type
	 *         configuration
	 */
	public static String getExtendedTypesRedefinition(String extendedTypesID) {
		if(extendedTypesID == null) {
			Activator.log.debug("Trying to find preferences for a null extended type set identifier");
		}
		IMemento memento = getExtendedTypesRedefinitionNode(extendedTypesID);
		if(memento != null) {
			return memento.getString(PATH);
		}
		return null;
	}

	/**
	 * Unregister a specific local redefinition
	 * 
	 * @param extendedTypesID
	 *        the identifier of the extended types set to unregister
	 */
	public static void unregisterLocalRedefinition(String extendedTypesID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(EXTENDED_TYPES_REDEFINITIONS);
		for(IMemento memento : rootMemento.getChildren(EXTENDED_TYPES_REDEFINITION)) {
			if(!memento.getString(ID).equals(extendedTypesID)) {
				newRootMemento.putMemento(memento);
			}
		}
		for(IMemento memento : rootMemento.getChildren(EXTENDED_TYPES_SET_WORKSPACE_DEFINITION)) {
			newRootMemento.putMemento(memento);
		}
		// save new Memento
		saveLocalRedefinitions(newRootMemento);
	}

	/**
	 * @param extendedTypesID
	 */
	public static void unregisterWorkspaceDefinition(String extendedTypesID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(EXTENDED_TYPES_REDEFINITIONS);
		for(IMemento memento : rootMemento.getChildren(EXTENDED_TYPES_REDEFINITION)) {
			newRootMemento.putMemento(memento);
		}
		for(IMemento memento : rootMemento.getChildren(EXTENDED_TYPES_SET_WORKSPACE_DEFINITION)) {
			if(!memento.getString(ID).equals(extendedTypesID)) {
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
			Activator.log.error("input/ouput exception", e);
		}
	}

	/**
	 * Saves the set of local redefinitions into the preference store
	 * 
	 * @param rootMemento
	 *        the memento to save
	 */
	public static void saveLocalRedefinitions(XMLMemento rootMemento) {
		saveMemento(rootMemento, EXTENDED_TYPES_REDEFINITIONS);
	}

	/**
	 * Returns all the paths in the workspace that should be an extended type set to load, with the id as a key
	 * 
	 * @return
	 */
	public static Map<String, String> getLocalExtendedTypesDefinitions() {
		IMemento[] mementos = getWorkspaceDefinitions();
		if(mementos != null && mementos.length > 0) {
			Map<String, String> idToPath = new HashMap<String, String>();
			for(IMemento memento : mementos) {
				String id = memento.getString(ID);
				String path = memento.getString(PATH);
				if(id != null && !"".equals(id) && path != null && !"".equals(PATH)) {
					idToPath.put(id, path);
				}
			}
			return idToPath;
		}
		return null;
	}

	/**
	 * Register a new local redefinition of a extendedTypes.
	 * 
	 * @param extendedTypesID
	 *        the id of the extendedTypes to register
	 * @param path
	 *        the path to the configuration of the extendedTypes
	 * @return the memento that has been registered
	 */
	public static IMemento registerWorkspaceDefinition(String extendedTypesID, String path) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// try to find an existing local definition for this extendedTypes
		IMemento memento = getWorkspaceDefinition(extendedTypesID);
		// if one exists, remove it from the preferences
		if(memento != null) {
			unregisterWorkspaceDefinition(extendedTypesID);
		}
		// then register the new one
		IMemento newMemento = rootMemento.createChild(EXTENDED_TYPES_SET_WORKSPACE_DEFINITION);
		newMemento.putString(ID, extendedTypesID);
		newMemento.putString(PATH, path);
		saveLocalRedefinitions(rootMemento);
		return newMemento;
	}
}
