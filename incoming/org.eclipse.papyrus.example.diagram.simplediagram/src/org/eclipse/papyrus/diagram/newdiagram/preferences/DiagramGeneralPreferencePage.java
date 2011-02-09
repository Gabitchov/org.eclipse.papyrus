package org.eclipse.papyrus.diagram.newdiagram.preferences;

import org.eclipse.papyrus.diagram.newdiagram.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.newdiagram.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.DiagramPreferencePage;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramPreferencePage {

	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
		setPreferenceKey(ModelEditPart.MODEL_ID);

	}
}
