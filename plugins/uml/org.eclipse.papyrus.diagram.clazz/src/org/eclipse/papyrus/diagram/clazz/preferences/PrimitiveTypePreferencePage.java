package org.eclipse.papyrus.diagram.clazz.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;

/**
 * @generated
 */
public class PrimitiveTypePreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	public PrimitiveTypePreferencePage() {
		super();
		setPreferenceKey(ModelEditPart.MODEL_ID + "_PrimitiveType");
	}

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
	public static void initDefaults(IPreferenceStore store) {

		String key = ModelEditPart.MODEL_ID + "_PrimitiveType";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 100);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 50);

		//org.eclipse.jface.preference.PreferenceConverter.setDefault(store, org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		//org.eclipse.jface.preference.PreferenceConverter.setDefault(store, org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(0, 0, 0));

		// Set the default for the gradient
		//store.setDefault(org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.GRADIENT_POLICY),false);
		//org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new  org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter(
		//		new org.eclipse.swt.graphics.RGB(255, 255, 255),
		//		new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		//store.setDefault(org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());

	}

}
