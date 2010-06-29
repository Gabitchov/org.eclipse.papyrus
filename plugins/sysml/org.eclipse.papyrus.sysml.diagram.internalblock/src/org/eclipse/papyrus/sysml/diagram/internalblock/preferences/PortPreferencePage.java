/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;

public class PortPreferencePage extends InternalBlockDiagramNodePreferencePage {

	public static String prefKey = InternalBlockDiagramEditPart.DIAGRAM_ID + "_Port";

	public PortPreferencePage() {
		super();
		setPreferenceKey(InternalBlockDiagramEditPart.DIAGRAM_ID + "_Port"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.WIDTH), 20);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.HEIGHT), 20);
	}
}
