/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;

public class ConstraintPreferencePage extends BlockDefinitionDiagramNodePreferencePage {

	public ConstraintPreferencePage() {
		super();
		setPreferenceKey(BlockDefinitionDiagramEditPart.DIAGRAM_ID + "_Constraint"); //$NON-NLS-1$
	}
}
