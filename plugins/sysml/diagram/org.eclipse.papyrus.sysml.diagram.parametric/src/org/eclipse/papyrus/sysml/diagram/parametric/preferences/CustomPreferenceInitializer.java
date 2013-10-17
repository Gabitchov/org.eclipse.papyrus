/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * Custom preferences initializer.
 */
public class CustomPreferenceInitializer extends ParametricDiagramPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();

		IPreferenceStore store = getPreferenceStore();

		ConstraintParameterAsBorderItemPreferencePage.initDefaults(store);
		BlockPropertyCompositePreferencePage.initDefaults(store);
		CustomConstraintPropertyCompositePreferencePage.initDefaults(store);
		CustomConnectorPreferencePage.initDefaults(store);

		// Initialize default positions for labels.
		initDefaultPosition(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, 0, -10);
		initDefaultPosition(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, 0, -30);

		initDefaultPosition(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID, 0, -10);
		initDefaultPosition(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, 0, -30);
		initDefaultPosition(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID, 0, 10);
		initDefaultPosition(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID, 0, 10);

		initDefaultPosition(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID, -40, -15);
		initDefaultPosition(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID, 30, -20);

	}

	/**
	 * Initialize default position of a link label in preferences.
	 * 
	 * @param parentGraphicalType
	 *        the graphical type of the view owning the label
	 * @param graphicalType
	 *        the graphical type of the label
	 * @param x
	 * @param y
	 */
	protected void initDefaultPosition(String parentGraphicalType, String graphicalType, int x, int y) {
		IPreferenceStore store = getPreferenceStore();

		String xKey = PreferenceConstantHelper.getElementConstant(ElementTypes.DIAGRAM_ID + "_" + parentGraphicalType + "-" + graphicalType, PreferenceConstantHelper.LOCATION_X);
		String yKey = PreferenceConstantHelper.getElementConstant(ElementTypes.DIAGRAM_ID + "_" + parentGraphicalType + "-" + graphicalType, PreferenceConstantHelper.LOCATION_Y);

		store.setDefault(xKey, x);
		store.setDefault(yKey, y);
	}
}
