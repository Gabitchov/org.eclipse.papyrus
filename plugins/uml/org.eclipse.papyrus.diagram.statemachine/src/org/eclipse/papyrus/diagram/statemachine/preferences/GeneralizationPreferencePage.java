package org.eclipse.papyrus.diagram.statemachine.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class GeneralizationPreferencePage extends
		AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

	/**
	 * @generated
	 */
	public GeneralizationPreferencePage() {
		super();
		setPreferenceKey(PackageEditPart.MODEL_ID + "_Generalization");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

}
