package org.eclipse.papyrus.diagram.profile.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class ExtensionPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public ExtensionPreferencePage() {
		super();
		setPreferenceKey(ProfileDiagramEditPart.MODEL_ID + "_Extension");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

}
