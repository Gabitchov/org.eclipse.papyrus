/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}

	/**
	 * @generated NOT
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		AssociationClass_2013PreferencePage.initDefaults(store);
		InstanceSpecification_2001PreferencePage.initDefaults(store);
		Component_2002PreferencePage.initDefaults(store);
		Signal_2003PreferencePage.initDefaults(store);
		Interface_2004PreferencePage.initDefaults(store);
		Model_2005PreferencePage.initDefaults(store);
		Enumeration_2006PreferencePage.initDefaults(store);
		Package_2007PreferencePage.initDefaults(store);
		Class_2008PreferencePage.initDefaults(store);
		PrimitiveType_2009PreferencePage.initDefaults(store);
		DataType_2010PreferencePage.initDefaults(store);
		Constraint_2011PreferencePage.initDefaults(store);
		Comment_2012PreferencePage.initDefaults(store);

		AssociationPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		InterfaceRealizationPreferencePage.initDefaults(store);
		SubstitutionPreferencePage.initDefaults(store);
		RealizationPreferencePage.initDefaults(store);
		AbstractionPreferencePage.initDefaults(store);
		UsagePreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);
		ElementImportPreferencePage.initDefaults(store);
		PackageImportPreferencePage.initDefaults(store);
		PackageMergePreferencePage.initDefaults(store);
		ProfileApplicationPreferencePage.initDefaults(store);
		TemplateBindingPreferencePage.initDefaults(store);

		// TODO: QuickFix to enable Global Properties. Global Properties should be re-enable in the Papyrus Diagram Page (and in the corresponding generators).
		store.setDefault(IPreferenceConstants.PREF_SHOW_CONNECTION_HANDLES, true);
		store.setDefault(IPreferenceConstants.PREF_SHOW_POPUP_BARS, true);
		store.setDefault(IPreferenceConstants.PREF_ENABLE_ANIMATED_LAYOUT, true);
		store.setDefault(IPreferenceConstants.PREF_ENABLE_ANIMATED_ZOOM, true);
		store.setDefault(IPreferenceConstants.PREF_ENABLE_ANTIALIAS, true);

	}
}
