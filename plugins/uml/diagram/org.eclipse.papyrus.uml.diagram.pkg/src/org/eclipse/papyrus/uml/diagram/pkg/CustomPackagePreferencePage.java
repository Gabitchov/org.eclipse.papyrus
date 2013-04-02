/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *	Nizar GUEDIDI CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.pkg.preferences.PackagePreferencePage;

public class CustomPackagePreferencePage extends PackagePreferencePage {

	static {
		compartmentTitleDefaultVisibilityMap.put("PackageableElementCompartment", Boolean.FALSE); //$NON-NLS-1$
	}

	/**
	 * Initialize defaults using a specified {@link IPreferenceStore}
	 * 
	 * @param store
	 *        the preference store.
	 */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
		// End of user code

		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.WIDTH), 200);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.HEIGHT), 100);
		// Initialize default visibility for compartments in preference page.
		for(String compartmentName : compartmentDefaultVisibilityMap.keySet()) {
			String showCompartmentKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(showCompartmentKey, compartmentDefaultVisibilityMap.get(compartmentName));
		}

		// Initialize default title visibility for compartments in preference page.
		for(String compartmentName : compartmentTitleDefaultVisibilityMap.keySet()) {
			String showCompartmentTitleKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
			store.setDefault(showCompartmentTitleKey, compartmentTitleDefaultVisibilityMap.get(compartmentName));
		}
	}

}
