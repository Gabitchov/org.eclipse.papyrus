package org.eclipse.papyrus.diagram.component.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class InterfaceRealizationPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public InterfaceRealizationPreferencePage() {
		super();
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID + "_InterfaceRealization");
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
