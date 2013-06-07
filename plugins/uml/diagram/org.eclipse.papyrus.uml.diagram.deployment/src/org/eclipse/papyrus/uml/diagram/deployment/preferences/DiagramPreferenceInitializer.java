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
package org.eclipse.papyrus.uml.diagram.deployment.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		ExecutionEnvironmentPreferencePage.initDefaults(store);

		ModelPreferencePage.initDefaults(store);

		DevicePreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		DependencyNodePreferencePage.initDefaults(store);

		ArtifactPreferencePage.initDefaults(store);

		NodePreferencePage.initDefaults(store);

		PackagePreferencePage.initDefaults(store);

		DefaultNamedElementPreferencePage.initDefaults(store);

		ConstraintConstrainedElementPreferencePage.initDefaults(store);

		CommentAnnotatedElementPreferencePage.initDefaults(store);

		DependencyBranchLinkPreferencePage.initDefaults(store);

		GeneralizationPreferencePage.initDefaults(store);

		ManifestationPreferencePage.initDefaults(store);

		DependencyLinkPreferencePage.initDefaults(store);

		DeploymentPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
