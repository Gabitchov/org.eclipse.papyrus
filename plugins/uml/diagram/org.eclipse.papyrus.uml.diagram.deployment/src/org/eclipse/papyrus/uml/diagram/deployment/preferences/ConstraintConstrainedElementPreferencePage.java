package org.eclipse.papyrus.uml.diagram.deployment.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class ConstraintConstrainedElementPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public ConstraintConstrainedElementPreferencePage() {
		super();
		setPreferenceKey(DeploymentDiagramEditPart.MODEL_ID + "_ConstraintConstrainedElement");
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
