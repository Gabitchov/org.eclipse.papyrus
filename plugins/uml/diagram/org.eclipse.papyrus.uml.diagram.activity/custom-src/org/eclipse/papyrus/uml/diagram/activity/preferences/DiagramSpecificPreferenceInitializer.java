/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;

/**
 * This preference initializer initializes diagram preferences specific to the
 * activity diagram.
 */
public class DiagramSpecificPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences specific to the activity diagram
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramGeneralPreferencePage.initSpecificDefaults(store);
		// preference for showing Activity edge name is common to several pages
		store.setDefault(IActivityPreferenceConstants.PREF_ACTIVITY_EDGE_SHOW_NAME_LABEL, true);
		// preferences for keeping user choices are not displayed
		store.setDefault(IActivityPreferenceConstants.PREF_NEW_CALL_BEHAVIOR_ACTION_SELECT_AS_DEFAULT, false);
		store.setDefault(IActivityPreferenceConstants.PREF_NEW_CALL_OPERATION_ACTION_SELECT_AS_DEFAULT, true);
		store.setDefault(IActivityPreferenceConstants.PREF_NEW_SEND_SIGNAL_ACTION_SELECT_AS_DEFAULT, false);
		store.setDefault(IActivityPreferenceConstants.PREF_NEW_CALL_BEHAVIOR_ACTION_CREATION_OWNER, "");
		store.setDefault(IActivityPreferenceConstants.PREF_NEW_CALL_OPERATION_ACTION_CREATION_OWNER, "");
		store.setDefault(IActivityPreferenceConstants.PREF_NEW_SEND_SIGNAL_ACTION_CREATION_OWNER, "");
		// Specific preferences for groups
		// Opacity Preferences
		store.setDefault(IActivityPreferenceConstants.PREF_ACTIVITY_PARTITION_ALPHA, 50);
		store.setDefault(IActivityPreferenceConstants.PREF_CONDITIONAL_NODE_ALPHA, 50);
		store.setDefault(IActivityPreferenceConstants.PREF_SEQUENCE_NODE_ALPHA, 50);
		store.setDefault(IActivityPreferenceConstants.PREF_EXPANSION_REGION_ALPHA, 50);
		store.setDefault(IActivityPreferenceConstants.PREF_STRUCTURED_NODE_ALPHA, 50); // TODO
		store.setDefault(IActivityPreferenceConstants.PREF_LOOP_NODE_ALPHA, 50);
		// Show Specific label preferences
		store.setDefault(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_CONDITIONAL_NODE, true);
		store.setDefault(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_LOOP_NODE, true);
		store.setDefault(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_SEQUENCE_NODE, true);
		store.setDefault(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_STRUCTURED_NODE, true);
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
