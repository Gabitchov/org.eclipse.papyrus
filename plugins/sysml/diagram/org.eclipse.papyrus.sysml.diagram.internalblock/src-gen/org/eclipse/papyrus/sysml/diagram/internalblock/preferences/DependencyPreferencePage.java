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
package org.eclipse.papyrus.sysml.diagram.internalblock.preferences;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class DependencyPreferencePage extends InternalBlockDiagramLinkPreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID; //$NON-NLS-1$

	/** The labels default visibility for preferences */
	public static final Map<String, Boolean> labelDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		labelDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		labelDefaultVisibilityMap.put("Stereotype", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("Name", Boolean.TRUE); //$NON-NLS-1$	

		// Start of user code custom static initializations
		// End of user code

		Collections.unmodifiableMap(labelDefaultVisibilityMap);
	}

	/** Constructor */
	public DependencyPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations		
		// End of user code

		// Initialize default visibility for labels in preference page.
		for(String labelName : labelDefaultVisibilityMap.keySet()) {
			String showLabelKey = PreferencesConstantsHelper.getCompartmentElementConstant(prefKey, labelName, PreferencesConstantsHelper.LABEL_VISIBILITY);
			store.setDefault(showLabelKey, labelDefaultVisibilityMap.get(labelName));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeLabelsList() {
		for(String name : labelDefaultVisibilityMap.keySet()) {
			this.labelsList.add(name);
		}
	}
}
