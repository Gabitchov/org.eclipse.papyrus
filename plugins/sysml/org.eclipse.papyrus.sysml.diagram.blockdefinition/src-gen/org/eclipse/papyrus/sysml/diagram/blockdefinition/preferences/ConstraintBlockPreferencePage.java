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
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;

public class ConstraintBlockPreferencePage extends BlockDefinitionDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID; //$NON-NLS-1$

	/** The list of compartments for this node */
	public static final String compartments[] = { "parameters", "constraints" };

	/** The list of visible (default preference) compartments for this node */
	public static final String default_compartments[] = { "parameters", "constraints" };

	/** Constructor */
	public ConstraintBlockPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations		
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
		// End of user code
	}

	/**
	 * @see org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage#initializeCompartmentsList()
	 */
	@Override
	protected void initializeCompartmentsList() {
		for(String name : compartments) {
			this.compartmentsList.add(name);
		}
	}
}
