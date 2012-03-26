package org.eclipse.papyrus.diagram.statemachine.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.util.StringComparator;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;

/**
 * @generated
 */
public class TransitionPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		String key = PackageEditPart.MODEL_ID + "_Transition";
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
		map.put("Name", "platform:/plugin/org.eclipse.papyrus.diagram.common/icons/label_role/name.png");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Guard", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Stereotype", "platform:/plugin/org.eclipse.uml2.uml.edit/icons/full/obj16/Stereotype.gif");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("Name", Boolean.FALSE);//$NON-NLS-1$
		map.put("Guard", Boolean.TRUE);
		map.put("Stereotype", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}

	/**
	 * @generated
	 */
	public TransitionPreferencePage() {
		super();
		setPreferenceKey(PackageEditPart.MODEL_ID + "_Transition");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}
}
