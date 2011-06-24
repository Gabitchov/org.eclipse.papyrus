/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.preference;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Preference constants for profile definition page
 */
public class ProfileDefinitionPreferenceConstants {

	/** preference ID for author name */
	public final static String PREF_AUTHOR_NAME = "ProfileDefinitionPreferenceConstants.author.name";

	/** preference ID for author name */
	public final static String PREF_COPYRIGHT = "ProfileDefinitionPreferenceConstants.copyright";

	/**
	 * initialize default preferences
	 * 
	 * @param store
	 *        the preference store to modify
	 */
	public static void setDefaultPreferences(IPreferenceStore store) {
		String name = "";
		try {
			name = System.getProperty("user.name");
		} catch (Exception e) {
			name = "Unknown";
		}
		store.setDefault(PREF_AUTHOR_NAME, name);
	}
}
