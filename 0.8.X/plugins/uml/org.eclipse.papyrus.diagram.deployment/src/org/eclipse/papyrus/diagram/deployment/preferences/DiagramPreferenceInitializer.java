package org.eclipse.papyrus.diagram.deployment.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.deployment.part.UMLDiagramEditorPlugin;

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


		ArtifactPreferencePage.initDefaults(store);


		DevicePreferencePage.initDefaults(store);


		NodePreferencePage.initDefaults(store);


		ConstraintPreferencePage.initDefaults(store);


		CommentPreferencePage.initDefaults(store);




		ConstraintConstrainedElementPreferencePage.initDefaults(store);


		CommentAnnotatedElementPreferencePage.initDefaults(store);


		GeneralizationPreferencePage.initDefaults(store);


		ManifestationPreferencePage.initDefaults(store);



		DependencyPreferencePage.initDefaults(store);


		DeploymentPreferencePage.initDefaults(store);


	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
