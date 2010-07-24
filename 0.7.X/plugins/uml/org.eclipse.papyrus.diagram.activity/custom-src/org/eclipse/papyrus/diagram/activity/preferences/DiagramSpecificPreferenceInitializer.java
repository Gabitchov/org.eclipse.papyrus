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
package org.eclipse.papyrus.diagram.activity.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;

/**
 * This preference initializer initializes diagram preferences specific to the activity diagram.
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
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
