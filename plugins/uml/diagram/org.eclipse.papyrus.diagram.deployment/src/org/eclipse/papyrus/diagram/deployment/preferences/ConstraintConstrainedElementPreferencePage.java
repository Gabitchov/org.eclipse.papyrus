package org.eclipse.papyrus.diagram.deployment.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

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
