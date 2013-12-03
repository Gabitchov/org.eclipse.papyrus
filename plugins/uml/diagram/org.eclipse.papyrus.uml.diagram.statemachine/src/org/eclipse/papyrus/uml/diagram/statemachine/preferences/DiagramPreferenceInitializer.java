package org.eclipse.papyrus.uml.diagram.statemachine.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.preferences.CustomTransitionPreferencePage;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin;

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
		ExitStateBehaviorPreferencePage.initDefaults(store);
		EntryStateBehaviorPreferencePage.initDefaults(store);
		DoActivityStateBehaviorPreferencePage.initDefaults(store);
		ConstraintPreferencePage.initDefaults(store);
		CommentPreferencePage.initDefaults(store);
		PseudostatePreferencePage.initDefaults(store);
		ConnectionPointReferencePreferencePage.initDefaults(store);
		RegionPreferencePage.initDefaults(store);
		StatePreferencePage.initDefaults(store);
		FinalStatePreferencePage.initDefaults(store);
		StateMachinePreferencePage.initDefaults(store);
		InternalTransitionPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		CustomTransitionPreferencePage.initDefaults(store);
	}
}
