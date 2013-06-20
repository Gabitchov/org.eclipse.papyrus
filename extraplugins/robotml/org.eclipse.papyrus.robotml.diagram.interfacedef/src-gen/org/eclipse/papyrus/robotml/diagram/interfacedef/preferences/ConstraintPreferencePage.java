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
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.part.InterfaceDefEditPart;

public class ConstraintPreferencePage extends InterfaceDefNodePreferencePage {

	public static String prefKey = InterfaceDefEditPart.DIAGRAM_ID + "_Constraint";


	public ConstraintPreferencePage() {
		super();
		setPreferenceKey(InterfaceDefEditPart.DIAGRAM_ID + "_Constraint"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
	}

}
