package org.eclipse.papyrus.diagram.communication.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		InteractionPreferencePage.initDefaults(store);


		TimeObservationPreferencePage.initDefaults(store);


		CommentPreferencePage.initDefaults(store);


		ConstraintPreferencePage.initDefaults(store);


		LifelinePreferencePage.initDefaults(store);


		DurationObservationPreferencePage.initDefaults(store);




		MessagePreferencePage.initDefaults(store);



	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
