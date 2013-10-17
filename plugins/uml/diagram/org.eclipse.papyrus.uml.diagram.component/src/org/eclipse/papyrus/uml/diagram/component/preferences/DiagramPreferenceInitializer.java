/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class DiagramPreferenceInitializer.
 * 
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences.
	 * 
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		OperationPreferencePage.initDefaults(store);
		ModelPreferencePage.initDefaults(store);
		ConstraintPreferencePage.initDefaults(store);
		CommentPreferencePage.initDefaults(store);
		PropertyPreferencePage.initDefaults(store);
		InterfacePreferencePage.initDefaults(store);
		NamedElementPreferencePage.initDefaults(store);
		DependencyNodePreferencePage.initDefaults(store);
		PortPreferencePage.initDefaults(store);
		ReceptionPreferencePage.initDefaults(store);
		PackagePreferencePage.initDefaults(store);
		ComponentPreferencePage.initDefaults(store);
		DefaultNamedElementPreferencePage.initDefaults(store);
		ConstraintConstrainedElementPreferencePage.initDefaults(store);
		AbstractionPreferencePage.initDefaults(store);
		InterfacePortLinkPreferencePage.initDefaults(store);
		ManifestationPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);
		DependencyLinkPreferencePage.initDefaults(store);
		ComponentRealizationPreferencePage.initDefaults(store);
		InterfaceRealizationPreferencePage.initDefaults(store);
		UsagePreferencePage.initDefaults(store);
		CommentAnnotatedElementPreferencePage.initDefaults(store);
		SubstitutionPreferencePage.initDefaults(store);
	}

	/**
	 * Gets the preference store.
	 * 
	 * @return the preference store
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
