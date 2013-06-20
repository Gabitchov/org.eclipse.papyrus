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
package org.eclipse.papyrus.robotml.diagram.componentdef.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.robotml.diagram.componentdef.Activator;

public class ComponentdefDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.ComponentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.PortPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.PropertyPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.ClassPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.ConstraintConstrainedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.componentdef.preferences.CommentAnnotatedElementPreferencePage.initDefaults(store);
	}
}
