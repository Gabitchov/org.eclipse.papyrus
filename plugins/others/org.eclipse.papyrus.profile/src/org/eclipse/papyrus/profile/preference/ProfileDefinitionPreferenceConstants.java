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
	 * @param store the preference store to modify
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
