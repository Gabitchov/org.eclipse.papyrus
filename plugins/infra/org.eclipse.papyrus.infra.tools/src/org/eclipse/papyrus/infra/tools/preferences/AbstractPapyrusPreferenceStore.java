/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.papyrus.infra.tools.Activator;
import org.eclipse.papyrus.infra.tools.preferences.ui.dialog.AbstractApplyValueOnPreferenceKeyDialog;

public abstract class AbstractPapyrusPreferenceStore extends PapyrusScopedPreferenceStore {

	/**
	 * key for element level
	 */
	private final String elementLevelPrefix;

	/**
	 * key for editor level
	 */
	private final String instanceEditorLevelPrefix;

	/**
	 * key for all editor of the same kind
	 */
	private final String editorLevelPrefix;

	/**
	 * constructor
	 * 
	 * @param context
	 *        the scope to store to
	 * @param qualifier
	 *        the qualifier used to look up the preference node
	 * @param key
	 *        for all editor of the same kind (all diagrams, all tables, ...)
	 * @param key
	 *        for an instance of this editor
	 * @param key
	 *        for an element
	 */
	public AbstractPapyrusPreferenceStore(IScopeContext context, String qualifier, String editorLevelPrefix, String instanceEditorLevelPrefix, String elementLevelPrefix) {
		super(context, qualifier);
		this.editorLevelPrefix = editorLevelPrefix;
		this.instanceEditorLevelPrefix = instanceEditorLevelPrefix;
		this.elementLevelPrefix = elementLevelPrefix;
	}

	/**
	 * constructor
	 * 
	 * @param context
	 *        the scope to store to
	 * @param qualifier
	 *        the qualifier used to look up the preference node
	 * @param defaultQualifierPath
	 *        the qualifier used when looking up the defaults
	 * @param key
	 *        for all editor of the same kind (all diagrams, all tables, ...)
	 * @param key
	 *        for an instance of this editor
	 * @param key
	 *        for an element
	 */
	public AbstractPapyrusPreferenceStore(IScopeContext context, String qualifier, String defaultQualifierPath, String editorLevelPrefix, String instanceEditorLevelPrefix, String elementLevelPrefix) {
		super(context, qualifier, defaultQualifierPath);
		this.editorLevelPrefix = editorLevelPrefix;
		this.instanceEditorLevelPrefix = instanceEditorLevelPrefix;
		this.elementLevelPrefix = elementLevelPrefix;
	}




	/**
	 * this method is used to overload all value under a level of preferences.
	 * In order to overload a pop-up is opened, and the user can choose value to overload
	 * 
	 * @param level
	 *        of preference: Editor or diagram
	 */

	public void deleteAllSubPreference(String level) {
		//remove all sub value diagram+ element

		//key to collect
		List<String> elementKey = new ArrayList<String>();
		try {
			for(int i = 0; i < getStorePreferences().keys().length; i++) {
				//level diagram collect only element
				if(level.startsWith(instanceEditorLevelPrefix)) {
					if(getStorePreferences().keys()[i].startsWith(elementLevelPrefix)) {
						elementKey.add(getStorePreferences().keys()[i]);
					}
				}
				//editor level, collect all element+diagram
				else if(level.startsWith(editorLevelPrefix)) {
					if((getStorePreferences().keys()[i].startsWith(elementLevelPrefix)) || (getStorePreferences().keys()[i].startsWith(instanceEditorLevelPrefix))) {
						elementKey.add(getStorePreferences().keys()[i]);
					}
				}

			}

		} catch (Exception e) {
			Activator.log.error(e);
		}
		if(elementKey.size() > 0) {
			List<String> keytoRemove = new ArrayList<String>();
			String[] keyRoconsult = new String[elementKey.size()];
			AbstractApplyValueOnPreferenceKeyDialog dialog = createPreferenceKeyDialog(elementKey.toArray(keyRoconsult));
			dialog.open();
			keytoRemove = dialog.getKeyToRemove();

			//remove key
			Iterator<String> iterator = keytoRemove.iterator();
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				getStorePreferences().remove(key);
			}
		}
	}

	/**
	 * 
	 * @param keys
	 * @return
	 *         the dialog to apply values
	 */
	protected abstract AbstractApplyValueOnPreferenceKeyDialog createPreferenceKeyDialog(String[] keys);



	// each get value will be overloaded
	//if not value is found for an element, a value is look for in DIAGRAM
	// if a the value is not find for Diagram a value is find for Papyrus editor


	/**
	 * this method is used to find a key that a got a value:
	 * if the key is an element. The method look for if this key exist. If no value exists, it look for the key for diagram
	 * if the key for diagram do not exist it look for key for papyrus Editor
	 * the structure of Key is:
	 * element : ELEMENT_DiagramKind_ElementKind.preferenceKind
	 * Diagram : DIAGRAM_DiagramKind.preferenceKind
	 * Editor: PAPYRUS_EDITOR.preferenceKind
	 * 
	 */
	protected String findKeyWithAValue(String initialKey) {
		String foundedKey = null;
		//first look for in value stack
		foundedKey = findKeyAStoreValue(initialKey);
		//then look for in default stack
		if(foundedKey == null) {
			foundedKey = findKeyWithADefaultValue(initialKey);
		}
		if(foundedKey == null) {
			foundedKey = initialKey;
		}
		return foundedKey;

	}

	/**
	 * look for a key with a value in the store stack
	 * 
	 * @param initialKey
	 *        element : ELEMENT_DiagramKind_ElementKind.preferenceKind
	 *        Diagram : DIAGRAM_DiagramKind.preferenceKind
	 *        Editor: PAPYRUS_EDITOR.preferenceKind
	 * @return the key that returns a value or null if there is no value
	 */
	protected String findKeyAStoreValue(String initialKey) {
		String foundedKey = null;
		if(getStorePreferences().get(initialKey, null) != null) {
			foundedKey = initialKey;
		}

		if(foundedKey == null && hasPrefix(initialKey)) {
			foundedKey = findKeyAStoreValue(getUpperKey(initialKey));
		}
		return foundedKey;
	}

	/**
	 * this method is used to find a key that a got a value:
	 * if the key is an element. The method look for if this key exist. If no value exists, it look for the key for diagram
	 * if the key for diagram do not exist it look for key for papyrus Editor
	 * the structure of Key is:
	 * element : ELEMENT_DiagramKind_ElementKind.preferenceKind
	 * Diagram : DIAGRAM_DiagramKind.preferenceKind
	 * Editor: PAPYRUS_EDITOR.preferenceKind
	 * 
	 */
	protected String findKeyWithADefaultValue(String initialKey) {
		String foundedKey = null;

		if(getDefaultPreferences().get(initialKey, null) != null) {
			foundedKey = initialKey;
		}

		if(foundedKey == null && hasPrefix(initialKey)) {
			return findKeyWithADefaultValue(getUpperKey(initialKey));
		} else {
			foundedKey = initialKey;
		}
		return foundedKey;

	}

	/**
	 * get the upper Key from the initial Key
	 * * the structure of Key is:
	 * element : ELEMENT_DiagramKind_ElementKind.preferenceKind
	 * Diagram : DIAGRAM_DiagramKind.preferenceKind
	 * Editor: PAPYRUS_EDITOR.preferenceKind
	 * 
	 * @param initialKey
	 * @return the upperKey
	 * 
	 */
	protected String getUpperKey(String initialKey) {

		String out = initialKey.toString();
		if(initialKey.startsWith(elementLevelPrefix)) {
			out = initialKey.toString().replaceAll(elementLevelPrefix, instanceEditorLevelPrefix);
			out = out.substring(0, out.lastIndexOf("_")) + out.substring(out.indexOf("."), out.length());
		}
		if(initialKey.startsWith(instanceEditorLevelPrefix)) {
			//	out=initialKey.toString().replaceAll(instanceEditorLevelPrefix, editorLevelPrefix);
			out = editorLevelPrefix + out.substring(out.indexOf("."), out.length());
		}
		return out;
	}

	protected boolean hasPrefix(String key) {
		if(key.startsWith(elementLevelPrefix) || key.startsWith(instanceEditorLevelPrefix)) {
			return true;
		}
		return false;
	}

	/**
	 * get the value from a key
	 * 
	 * @param key
	 * @return the value
	 */
	protected String internalGet(String key) {
		String newKey = findKeyWithAValue(key);
		//System.err.println("-->Initial Key "+key+"--> "+ newKey);
		return Platform.getPreferencesService().get(newKey, null, getPreferenceNodes(true));
	}

	public boolean getDefaultBoolean(String name) {

		return super.getDefaultBoolean(findKeyWithADefaultValue(name));
	}

	public double getDefaultDouble(String name) {
		return super.getDefaultDouble(findKeyWithADefaultValue(name));
	}

	public float getDefaultFloat(String name) {
		return super.getDefaultFloat(findKeyWithADefaultValue(name));
	};

	public int getDefaultInt(String name) {
		return super.getDefaultInt(findKeyWithADefaultValue(name));
	}

	public long getDefaultLong(String name) {
		return super.getDefaultLong(findKeyWithADefaultValue(name));
	}

	public String getDefaultString(String name) {
		return super.getDefaultString(findKeyWithADefaultValue(name));
	}
}
