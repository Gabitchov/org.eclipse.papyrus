/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.pkg.Activator;

public class PackageDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.uml.diagram.pkg.CustomPackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.pkg.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.pkg.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.pkg.CustomModelPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.pkg.preferences.DependencyPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.pkg.preferences.PackageImportPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.pkg.preferences.AbstractionPreferencePage.initDefaults(store);
	}
}
