package org.eclipse.papyrus.diagram.deployment.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.util.StringComparator;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;

/**
 * @generated
 */
public class CommunicationPathPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public CommunicationPathPreferencePage() {
		super();
		setPreferenceKey(DeploymentDiagramEditPart.MODEL_ID + "_CommunicationPath");
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
		String key = DeploymentDiagramEditPart.MODEL_ID + "_CommunicationPath";
		Map<String, Boolean> map = getStaticLabelVisibilityPreferences();
		for(String role : map.keySet()) {
			String preferenceName = PreferenceConstantHelper.getLabelElementConstant(key, role, PreferenceConstantHelper.LABEL_VISIBILITY);
			store.setDefault(preferenceName, map.get(role));
		}
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, String> getStaticLabelRole() {
		TreeMap<String, String> map = new TreeMap<String, String>(new StringComparator());
		map.put("Name", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Stereotype", "");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("Name", Boolean.TRUE);
		map.put("Stereotype", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}
}
