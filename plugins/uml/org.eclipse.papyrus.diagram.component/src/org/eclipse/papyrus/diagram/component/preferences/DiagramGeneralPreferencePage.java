package org.eclipse.papyrus.diagram.component.preferences;

import org.eclipse.papyrus.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.DiagramPreferencePage;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramPreferencePage {

	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID);

	}
}
