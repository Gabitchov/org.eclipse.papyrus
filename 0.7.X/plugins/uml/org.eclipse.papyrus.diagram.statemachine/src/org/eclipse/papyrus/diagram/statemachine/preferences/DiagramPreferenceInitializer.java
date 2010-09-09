package org.eclipse.papyrus.diagram.statemachine.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;

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
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		PseudostatePreferencePage.initDefaults(store);

		RegionPreferencePage.initDefaults(store);

		StatePreferencePage.initDefaults(store);

		FinalStatePreferencePage.initDefaults(store);

		StateMachinePreferencePage.initDefaults(store);

		TransitionPreferencePage.initDefaults(store);

	}
}
