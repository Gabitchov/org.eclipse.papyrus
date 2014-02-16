package org.eclipse.papyrus.uml.diagram.composite.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.common.util.StringComparator;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class ConnectorPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public ConnectorPreferencePage() {
		super();
		setPreferenceKey(CompositeStructureDiagramEditPart.MODEL_ID + "_Connector");
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
		String key = CompositeStructureDiagramEditPart.MODEL_ID + "_Connector";
		Map<String, Boolean> map = getStaticLabelVisibilityPreferences();
		for(String role : map.keySet()) {
			String preferenceName = PreferencesConstantsHelper.getLabelElementConstant(key, role, PreferencesConstantsHelper.LABEL_VISIBILITY);
			store.setDefault(preferenceName, map.get(role));
		}
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, String> getStaticLabelRole() {
		TreeMap<String, String> map = new TreeMap<String, String>(new StringComparator());
		map.put("Stereotype", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Name", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("SourceMultiplicity", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("TargetMultiplicity", "");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("Stereotype", Boolean.TRUE);
		map.put("Name", Boolean.FALSE);//$NON-NLS-1$
		map.put("SourceMultiplicity", Boolean.FALSE);//$NON-NLS-1$
		map.put("TargetMultiplicity", Boolean.FALSE);//$NON-NLS-1$
		return map;
	}

	/**
	 * @generated
	 */
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}
}
