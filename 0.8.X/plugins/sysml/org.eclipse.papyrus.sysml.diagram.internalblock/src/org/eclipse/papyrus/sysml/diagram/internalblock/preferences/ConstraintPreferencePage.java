/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;

public class ConstraintPreferencePage extends InternalBlockDiagramNodePreferencePage {

	public static String prefKey = InternalBlockDiagramEditPart.DIAGRAM_ID + "_Constraint";

	public ConstraintPreferencePage() {
		super();
		setPreferenceKey(InternalBlockDiagramEditPart.DIAGRAM_ID + "_Constraint"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
	}

}
