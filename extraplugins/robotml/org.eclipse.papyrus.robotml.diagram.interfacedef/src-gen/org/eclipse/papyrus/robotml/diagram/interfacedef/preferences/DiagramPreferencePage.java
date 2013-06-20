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
package org.eclipse.papyrus.robotml.diagram.interfacedef.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.part.InterfaceDefEditPart;

public class DiagramPreferencePage extends InterfaceDefNodePreferencePage {

	public static String prefKey = InterfaceDefEditPart.DIAGRAM_ID + "_Diagram";


	public DiagramPreferencePage() {
		super();
		setPreferenceKey(InterfaceDefEditPart.DIAGRAM_ID + "_Diagram"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.WIDTH), 20);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.HEIGHT), 20);
	}

}
