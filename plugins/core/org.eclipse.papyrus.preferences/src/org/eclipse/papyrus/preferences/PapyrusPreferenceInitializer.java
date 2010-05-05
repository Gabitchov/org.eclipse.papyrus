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
package org.eclipse.papyrus.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.pages.PapyrusAllDiagramsPreferencePage;
/**
 * This class is use to initialize the preference at the level Papyrus editor
 *
 */
public class PapyrusPreferenceInitializer extends AbstractPreferenceInitializer {

	private IPreferenceStore store;

/**
 * constructor of this class
 */
	public PapyrusPreferenceInitializer() {
		store= Activator.getDefault().getPreferenceStore();
	}

	
	@Override
	public void initializeDefaultPreferences() {
		PapyrusAllDiagramsPreferencePage.initDefaults(store);

	}

}
