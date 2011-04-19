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
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;

public class PackagePreferencePage extends BlockDefinitionDiagramNodePreferencePage {

	/** Constant key to access preferences */
	protected static String prefKey = ElementTypes.DIAGRAM_ID + "_Package";

	/** The list of compartments for this node */
	public static final String compartments[] = { "PackageableElementCompartment" };

	/** The list of visible (default preference) compartments for this node */
	public static final String default_compartments[] = { "PackageableElementCompartment" };

	/** Default constructor */
	public PackagePreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_Package"); //$NON-NLS-1$
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
		// Initialize compartment and compartment title visibility
		for(String compartmentName : compartments) {
			// Register all compartment as masked (visible compartment are set after)
			String showCompartmentKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(showCompartmentKey, false);

			// Set compartment title visibility
			String showCompartmentTitleKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
			store.setDefault(showCompartmentTitleKey, true);
		}

		// Initialize visible compartments
		for(String compartmentName : default_compartments) {
			String showCompartmentKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(showCompartmentKey, true);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage#initializeCompartmentsList()
	 * 
	 */
	@Override
	protected void initializeCompartmentsList() {
		for(String name : compartments) {
			this.compartmentsList.add(name);
		}
	}
}
