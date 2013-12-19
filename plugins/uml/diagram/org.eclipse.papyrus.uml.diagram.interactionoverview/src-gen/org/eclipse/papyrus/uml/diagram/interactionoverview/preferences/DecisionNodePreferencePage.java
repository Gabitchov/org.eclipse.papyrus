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
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.ElementTypes;

public class DecisionNodePreferencePage extends InteractionOverviewDiagramNodePreferencePage {

	/** Constant key to access preferences */
	protected static String prefKey = ElementTypes.DIAGRAM_ID + "_DecisionNode"; //$NON-NLS-1$

	/** The labels default visibility for preferences */
	public static final Map<String, Boolean> labelDefaultVisibilityMap;

	/** Static attribute initialization */
	static {

		labelDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		labelDefaultVisibilityMap.put("undefined_role", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("Stereotype", Boolean.TRUE); //$NON-NLS-1$	

		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(labelDefaultVisibilityMap);
	}

	/** Default constructor */
	public DecisionNodePreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_DecisionNode"); //$NON-NLS-1$
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

		// Initialize default visibility for labels in preference page.
		for(final String labelName : labelDefaultVisibilityMap.keySet()) {
			final String showLabelKey = PreferencesConstantsHelper.getCompartmentElementConstant(prefKey, labelName, PreferencesConstantsHelper.LABEL_VISIBILITY);
			store.setDefault(showLabelKey, labelDefaultVisibilityMap.get(labelName));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeLabelsList() {
		for(final String name : labelDefaultVisibilityMap.keySet()) {
			this.labelsList.add(name);
		}
	}
}
