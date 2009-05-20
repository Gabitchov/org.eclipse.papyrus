/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.usecase.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		Actor_2002PreferencePage.initDefaults(store);
		Actor_2003PreferencePage.initDefaults(store);
		UseCase_2004PreferencePage.initDefaults(store);
		UseCase_2005PreferencePage.initDefaults(store);
		Component_2006PreferencePage.initDefaults(store);
		Package_2009PreferencePage.initDefaults(store);
		Constraint_2008PreferencePage.initDefaults(store);
		Comment_2010PreferencePage.initDefaults(store);

		IncludePreferencePage.initDefaults(store);
		ExtendPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		AssociationPreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
