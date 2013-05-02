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
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.requirement.Activator;

public class RequirementDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.sysml.diagram.requirement.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.requirement.preferences.NamedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.requirement.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.requirement.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.requirement.preferences.AbstractionPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.requirement.preferences.ContainmentLinkPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.requirement.preferences.DependencyPreferencePage.initDefaults(store);
	}
}
