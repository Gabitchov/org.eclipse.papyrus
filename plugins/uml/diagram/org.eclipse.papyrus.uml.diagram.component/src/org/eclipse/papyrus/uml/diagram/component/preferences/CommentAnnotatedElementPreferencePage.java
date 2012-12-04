package org.eclipse.papyrus.uml.diagram.component.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class CommentAnnotatedElementPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public CommentAnnotatedElementPreferencePage() {
		super();
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID + "_CommentAnnotatedElement");
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
