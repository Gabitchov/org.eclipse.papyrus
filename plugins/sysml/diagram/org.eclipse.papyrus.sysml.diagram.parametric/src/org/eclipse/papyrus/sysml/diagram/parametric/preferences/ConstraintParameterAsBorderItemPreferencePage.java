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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * {@link Port} preference page.
 */
public class ConstraintParameterAsBorderItemPreferencePage extends ParametricDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID; //$NON-NLS-1$

	public static String prefLabelKey = prefKey + "-" + UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID; //$NON-NLS-1$

	/** Constructor */
	public ConstraintParameterAsBorderItemPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.WIDTH), 20);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.HEIGHT), 20);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.ELEMENTICON), 0);
	}

}
