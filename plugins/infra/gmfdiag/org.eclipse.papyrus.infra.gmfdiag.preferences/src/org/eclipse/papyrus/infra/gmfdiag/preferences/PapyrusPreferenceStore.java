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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.dialog.ApplyValueOnPreferenceKeyDialog;

/**
 * this class is a specific store that is used to look for value of element
 * by taking account the structure of preferences : papyrus editor-> Diagram -> Elements of Diagram
 * 
 */
public class PapyrusPreferenceStore extends PapyrusScopedPreferenceStore {

	/**
	 * this method is used to overload all value under a level of preferences.
	 * In order to overload a pop-up is opened, and the user can choose value to overload
	 * 
	 * @param level
	 *        of preference: Editor or diagram
	 */

	public void deleteAllSubPreference(String level) {
		//remove all sub value diagram+ element
		ArrayList<String> keytoRemove = new ArrayList<String>();
		//key to collect
		ArrayList<String> elementKey = new ArrayList<String>();
		try {
			for(int i = 0; i < getStorePreferences().keys().length; i++) {
				//level diagram collect only element
				if(level.startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					if(getStorePreferences().keys()[i].startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
						elementKey.add(getStorePreferences().keys()[i]);
					}
				}
				//editor level, collect all element+diagram
				else if(level.startsWith(PreferencesConstantsHelper.PAPYRUS_EDITOR_PREFERENCE_PREFIX)) {
					if((getStorePreferences().keys()[i].startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) || (getStorePreferences().keys()[i].startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX))) {
						elementKey.add(getStorePreferences().keys()[i]);
					}
				}

			}

		} catch (Exception e) {
			Activator.log.error(e);
		}
		if(elementKey.size() > 0) {
			String[] keyRoconsult = new String[elementKey.size()];
			ApplyValueOnPreferenceKeyDialog dialog = new ApplyValueOnPreferenceKeyDialog(elementKey.toArray(keyRoconsult));
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
	 * constructor
	 * 
	 * @param context
	 *        the scope to store to
	 * @param qualifier
	 *        the qualifier used to look up the preference node
	 */
	public PapyrusPreferenceStore(IScopeContext context, String qualifier) {
		super(context, qualifier);
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
	 */
	public PapyrusPreferenceStore(IScopeContext context, String qualifier, String defaultQualifierPath) {
		super(context, qualifier, defaultQualifierPath);
	}

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
		if(initialKey.startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
			out = initialKey.toString().replaceAll(PreferencesConstantsHelper.DIAGRAM_ELEMENT, PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX);
			out = out.substring(0, out.lastIndexOf("_")) + out.substring(out.indexOf("."), out.length());
		}
		if(initialKey.startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
			//	out=initialKey.toString().replaceAll(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX, PreferencesConstantsHelper.PAPYRUS_EDITOR_PREFERENCE_PREFIX);
			out = PreferencesConstantsHelper.PAPYRUS_EDITOR_PREFERENCE_PREFIX + out.substring(out.indexOf("."), out.length());
		}
		return out;
	}

	protected boolean hasPrefix(String key) {
		if(key.startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT) || key.startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
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
