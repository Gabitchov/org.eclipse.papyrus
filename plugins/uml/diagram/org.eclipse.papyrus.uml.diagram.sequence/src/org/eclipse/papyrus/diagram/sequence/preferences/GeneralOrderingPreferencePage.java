package org.eclipse.papyrus.diagram.sequence.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class GeneralOrderingPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public GeneralOrderingPreferencePage() {
		super();
		setPreferenceKey(PackageEditPart.MODEL_ID + "_GeneralOrdering");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

}
