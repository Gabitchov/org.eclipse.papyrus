package org.eclipse.papyrus.profile.preference;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Interface for constants for profile preferences
 */
public class ProfilePreferenceConstants {
	
	/** Constant for the expand stereotype tree preference */
	public final static String EXPAND_STERETOYPES_TREE = "StereotypesTree.expandAll"; 
	
	/** 
	 * this method is used to store default preference of stereotype display.
	 * default is expanded
	 * @param store the preference store used to manage persistent properties
	 */
	public static void setDefaultPreferences(IPreferenceStore store) {
		store.setDefault(EXPAND_STERETOYPES_TREE, true);
	}
}
