package org.eclipse.papyrus.diagram.usecase.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;

/**
 * @generated
 */
public class ComponentPreferencePage extends AbstractPapyrusNodePreferencePage {

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
	protected String getFillColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMPONENT_PREF_FILL_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getGradientColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFillPolicyPreferenceName() {
		return IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_POLICY;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMPONENT_PREF_FONT_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontPreferenceName() {
		return IPapyrusPreferencesConstant.COMPONENT_PREF_FONT;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getLineColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMPONENT_PREF_LINE_COLOR;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		PreferenceConverter.setDefault(store,
				IPapyrusPreferencesConstant.COMPONENT_PREF_FILL_COLOR,
				new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store,
				IPapyrusPreferencesConstant.COMPONENT_PREF_LINE_COLOR,
				new org.eclipse.swt.graphics.RGB(177, 207, 229));

		// Set the default for the gradient
		store.setDefault(
				IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_POLICY,
				true);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(
				new org.eclipse.swt.graphics.RGB(255, 255, 255),
				new org.eclipse.swt.graphics.RGB(177, 207, 229), 0, 0);
		store.setDefault(
				IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_COLOR,
				gradientPreferenceConverter.getPreferenceValue());

	}

}
