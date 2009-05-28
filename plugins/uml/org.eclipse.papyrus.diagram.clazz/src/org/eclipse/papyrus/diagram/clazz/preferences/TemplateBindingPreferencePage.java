package org.eclipse.papyrus.diagram.clazz.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class TemplateBindingPreferencePage extends
		AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getJumpLinkReversePreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_JUMPLINK_REVERSE;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getJumpLinkStatusPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_JUMPLINK_STATUS;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getJumpLinkTypePreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_JUMPLINK_TYPE;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getRoutingDistancePolicyPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_ROUTING_DISTANCE_POLICY;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getRoutingObstructionPolicyPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_ROUTING_OBSTRUCTION_POLICY;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getRoutingStylePreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_ROUTING_STYLE;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getSmoothnessPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_SMOOTHNESS;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontColorPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_SMOOTHNESS;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_FONT;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getLineColorPreferenceName() {
		return IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_LINE_COLOR;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

}
