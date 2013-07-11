/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.preferences;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.ElementTypes;

public class SequenceNodePreferencePage extends InteractionOverviewDiagramNodePreferencePage {

	/** Constant key to access preferences */
	protected static String prefKey = ElementTypes.DIAGRAM_ID + "_SequenceNode"; //$NON-NLS-1$

	/** The compartments default visibility for preferences */
	public static final Map<String, Boolean> compartmentDefaultVisibilityMap;

	/** The compartment titles default visibility for preferences */
	public static final Map<String, Boolean> compartmentTitleDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		compartmentDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentDefaultVisibilityMap.put("StructuredActivityNodeContentCompartment", Boolean.TRUE); //$NON-NLS-1$	

		compartmentTitleDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentTitleDefaultVisibilityMap.put("StructuredActivityNodeContentCompartment", Boolean.TRUE); //$NON-NLS-1$

		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(compartmentDefaultVisibilityMap);
		Collections.unmodifiableMap(compartmentTitleDefaultVisibilityMap);
	}

	/** Default constructor */
	public SequenceNodePreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_SequenceNode"); //$NON-NLS-1$
	}

	/**
	 * Initialize defaults using a specified {@link IPreferenceStore}
	 * 
	 * @param store
	 *        the preference store.
	 */
	public static void initDefaults(final IPreferenceStore store) {
		// Start of user code custom default initializations
		// End of user code

		// Initialize default visibility for compartments in preference page.
		for(final String compartmentName : compartmentDefaultVisibilityMap.keySet()) {
			final String showCompartmentKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(showCompartmentKey, compartmentDefaultVisibilityMap.get(compartmentName));
		}

		// Initialize default title visibility for compartments in preference
		// page.
		for(final String compartmentName : compartmentTitleDefaultVisibilityMap.keySet()) {
			final String showCompartmentTitleKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
			store.setDefault(showCompartmentTitleKey, compartmentTitleDefaultVisibilityMap.get(compartmentName));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeCompartmentNamesList() {
		for(final String name : compartmentDefaultVisibilityMap.keySet()) {
			this.compartmentNamesList.add(name);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeCompartmentTitlesList() {
		for(final String name : compartmentTitleDefaultVisibilityMap.keySet()) {
			this.compartmentTitlesList.add(name);
		}
	}

}
