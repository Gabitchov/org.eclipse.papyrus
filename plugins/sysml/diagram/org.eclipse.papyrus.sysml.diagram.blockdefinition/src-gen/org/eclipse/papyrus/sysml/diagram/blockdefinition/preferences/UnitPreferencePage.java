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
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;

public class UnitPreferencePage extends BlockDefinitionDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID; //$NON-NLS-1$


	/** Constructor */
	public UnitPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" + SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID); //$NON-NLS-1$
	}

	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.WIDTH), 100);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.HEIGHT), 60);
		// End of user code
	}

}
