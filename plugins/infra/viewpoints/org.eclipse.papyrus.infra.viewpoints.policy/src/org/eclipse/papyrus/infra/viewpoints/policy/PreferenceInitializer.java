/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Initializes the default preferences for the viewpoints
 * 
 * @author Laurent Wouters
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_CONF_TYPE, PreferenceConstants.P_CONF_TYPE_EXTENSION_VALUE);
		store.setDefault(PreferenceConstants.P_CONF_PATH_SCHEME, PreferenceConstants.P_CONF_PATH_SCHEME_FILE_VALUE);
		store.setDefault(PreferenceConstants.P_CONF_PATH, "");
		store.setDefault(PreferenceConstants.P_STAKEHOLDER, "");
		store.setDefault(PreferenceConstants.P_VIEWPOINT, "");
		store.setDefault(PreferenceConstants.P_FORCE_MULTIPLICITY, "false");
	}

}
