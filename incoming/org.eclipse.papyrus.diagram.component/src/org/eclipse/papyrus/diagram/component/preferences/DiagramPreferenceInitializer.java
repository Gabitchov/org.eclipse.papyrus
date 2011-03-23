package org.eclipse.papyrus.diagram.component.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.component.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		InterfacePreferencePage.initDefaults(store);


		PortPreferencePage.initDefaults(store);


		ConstraintPreferencePage.initDefaults(store);


		CommentPreferencePage.initDefaults(store);


		PackagePreferencePage.initDefaults(store);


		ComponentPreferencePage.initDefaults(store);




		ConstraintConstrainedElementPreferencePage.initDefaults(store);


		AbstractionPreferencePage.initDefaults(store);


		CommentAnnotatedElementPreferencePage.initDefaults(store);


		SubstitutionPreferencePage.initDefaults(store);


		ManifestationPreferencePage.initDefaults(store);


		GeneralizationPreferencePage.initDefaults(store);



		DependencyPreferencePage.initDefaults(store);


		ComponentRealizationPreferencePage.initDefaults(store);


		InterfaceRealizationPreferencePage.initDefaults(store);


		UsagePreferencePage.initDefaults(store);


	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
