package org.eclipse.papyrus.example.diagram.simplediagram.preferences;

import org.eclipse.papyrus.example.diagram.simplediagram.edit.parts.ModelEditPart;
import org.eclipse.papyrus.example.diagram.simplediagram.part.UMLDiagramEditorPlugin;
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
