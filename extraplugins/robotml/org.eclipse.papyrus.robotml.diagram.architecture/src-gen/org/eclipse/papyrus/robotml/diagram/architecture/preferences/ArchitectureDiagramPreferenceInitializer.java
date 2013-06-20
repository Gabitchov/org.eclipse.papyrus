/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.architecture.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.robotml.diagram.architecture.Activator;

public class ArchitectureDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.robotml.diagram.architecture.preferences.ComponentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.architecture.preferences.PortPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.architecture.preferences.PropertyPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.architecture.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.architecture.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.architecture.preferences.ConnectorPreferencePage.initDefaults(store);
	}
}
