package org.eclipse.papyrus.diagram.clazzBis.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		org.eclipse.papyrus.diagram.clazzBis.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		org.eclipse.papyrus.diagram.clazzBis.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		org.eclipse.papyrus.diagram.clazzBis.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		org.eclipse.papyrus.diagram.clazzBis.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		org.eclipse.papyrus.diagram.clazzBis.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
