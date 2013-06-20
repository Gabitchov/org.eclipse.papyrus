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
package org.eclipse.papyrus.robotml.diagram.datatypedef.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.robotml.diagram.datatypedef.Activator;

public class DatatypeDefPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.EnumerationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.DataTypePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.PrimitiveTypePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.SignalPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.DataTypePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.EnumerationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.PrimitiveTypePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.EnumerationLiteralPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.SignalPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.DiagramPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.DependencyPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.PackageImportPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.CommentAnnotatedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.ConstraintConstrainedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.PackageMergePreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.ElementImportPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.AssociationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.robotml.diagram.datatypedef.preferences.GeneralizationPreferencePage.initDefaults(store);
	}
}
