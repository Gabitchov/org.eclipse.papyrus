package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ParametricEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlDiagramEditorPlugin;

/**
 * @generated
 */
public class CommentLinkPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public CommentLinkPreferencePage() {
		super();
		setPreferenceKey(ParametricEditPart.MODEL_ID + "_CommentLink");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return SysmlDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
	}
}
