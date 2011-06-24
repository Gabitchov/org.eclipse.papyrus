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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.navigator.internal.Activator;

/**
 * This preference initializer initializes diagram preferences specific to the activity diagram.
 */
public class NavigatorPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences specific to the activity diagram
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		// preference for showing popup dialog when transform element command is performed
		store.setDefault(INavigatorPreferenceConstants.PREF_NAVIGATOR_TRANSFORM_INTO_SHOW_POPUP, false);
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
