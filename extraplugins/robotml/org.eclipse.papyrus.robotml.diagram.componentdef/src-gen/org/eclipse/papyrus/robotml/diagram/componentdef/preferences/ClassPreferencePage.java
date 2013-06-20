/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.componentdef.preferences;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;

public class ClassPreferencePage extends ComponentdefDiagramNodePreferencePage {

	public static String prefKey = ComponentdefDiagramEditPart.DIAGRAM_ID + "_Class";

	/** The compartments default visibility for preferences */
	public static final Map<String, Boolean> compartmentDefaultVisibilityMap;

	/** The compartment titles default visibility for preferences */
	public static final Map<String, Boolean> compartmentTitleDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		compartmentDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentDefaultVisibilityMap.put("structure", Boolean.TRUE); //$NON-NLS-1$	

		compartmentTitleDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentTitleDefaultVisibilityMap.put("structure", Boolean.FALSE); //$NON-NLS-1$


		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(compartmentDefaultVisibilityMap);
		Collections.unmodifiableMap(compartmentTitleDefaultVisibilityMap);
	}

	/**
	 * the list of the compartments for this node
	 */
	public static final String compartments[] = { "ClassCompositeCompartment" };

	public ClassPreferencePage() {
		super();
		setPreferenceKey(ComponentdefDiagramEditPart.DIAGRAM_ID + "_Class"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
		// set the true value for the compartment visibility
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

	/**
	 * 
	 * @see org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage#initializeCompartmentsList()
	 * 
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeCompartmentNamesList() {
		for(String name : compartmentDefaultVisibilityMap.keySet()) {
			this.compartmentNamesList.add(name);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeCompartmentTitlesList() {
		for(String name : compartmentTitleDefaultVisibilityMap.keySet()) {
			this.compartmentTitlesList.add(name);
		}
	}
}
