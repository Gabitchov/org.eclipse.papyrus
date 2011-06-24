package org.eclipse.papyrus.diagram.statemachine.custom.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.preferences.StatePreferencePage;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;

public class CustomStatePreferencePage extends StatePreferencePage {

	public static void initDefaults(IPreferenceStore store) {

		String key = PackageEditPart.MODEL_ID + "_State";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key,
				PreferenceConstantHelper.WIDTH), 40);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key,
				PreferenceConstantHelper.HEIGHT), 40);

		for (String name : compartments) {
			String preferenceName = PreferenceConstantHelper
					.getCompartmentElementConstant(key, name,
							PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, false);
		}
	}
}
