package org.eclipse.papyrus.uml.diagram.statemachine.custom.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.preferences.StatePreferencePage;

public class CustomStatePreferencePage extends StatePreferencePage {

	public static void initDefaults(IPreferenceStore store) {

		String key = PackageEditPart.MODEL_ID + "_State";
		store.setDefault(PreferencesConstantsHelper.getElementConstant(key, PreferencesConstantsHelper.WIDTH), 40);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(key, PreferencesConstantsHelper.HEIGHT), 40);

		for(String name : compartments) {
			String preferenceName = PreferencesConstantsHelper.getCompartmentElementConstant(key, name, PreferencesConstantsHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, false);
		}
	}
}
