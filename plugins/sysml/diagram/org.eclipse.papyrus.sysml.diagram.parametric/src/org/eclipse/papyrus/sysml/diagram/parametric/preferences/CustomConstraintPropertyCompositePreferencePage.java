/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		R�gis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * Preference page for Part and References.
 */
public class CustomConstraintPropertyCompositePreferencePage extends ParametricDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID; //$NON-NLS-1$

	public static String prefLabelKey = prefKey + "-" + UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID; //$NON-NLS-1$

	/** The compartments default visibility for preferences */
	public static final Map<String, Boolean> compartmentDefaultVisibilityMap;

	/** The compartment titles default visibility for preferences */
	public static final Map<String, Boolean> compartmentTitleDefaultVisibilityMap;

	/** Static attribute initialization */
	static {
		compartmentDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentDefaultVisibilityMap.put("structure", Boolean.TRUE); //$NON-NLS-1$

		compartmentTitleDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentTitleDefaultVisibilityMap.put("structure", Boolean.TRUE); //$NON-NLS-1$

		// Start of user code custom static initializations
		compartmentTitleDefaultVisibilityMap.remove("structure"); //$NON-NLS-1$
		compartmentTitleDefaultVisibilityMap.put("structure", Boolean.FALSE); //$NON-NLS-1$
		// End of user code

		Collections.unmodifiableMap(compartmentDefaultVisibilityMap);
		Collections.unmodifiableMap(compartmentTitleDefaultVisibilityMap);
	}

	/** Constructor */
	public CustomConstraintPropertyCompositePreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
		// End of user code

		// Initialize default visibility for compartments in preference page.
		for(String compartmentName : compartmentDefaultVisibilityMap.keySet()) {
			String showCompartmentKey = PreferencesConstantsHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferencesConstantsHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(showCompartmentKey, compartmentDefaultVisibilityMap.get(compartmentName));
		}

		// Initialize default title visibility for compartments in preference page.
		for(String compartmentName : compartmentTitleDefaultVisibilityMap.keySet()) {
			String showCompartmentTitleKey = PreferencesConstantsHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferencesConstantsHelper.COMPARTMENT_NAME_VISIBILITY);
			store.setDefault(showCompartmentTitleKey, compartmentTitleDefaultVisibilityMap.get(compartmentName));
		}
	}

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
