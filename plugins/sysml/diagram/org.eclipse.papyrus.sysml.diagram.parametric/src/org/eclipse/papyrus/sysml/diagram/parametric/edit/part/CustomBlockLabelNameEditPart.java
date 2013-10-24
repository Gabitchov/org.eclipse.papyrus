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
package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockLabelNameEditPart;

public class CustomBlockLabelNameEditPart extends BlockLabelNameEditPart {

	public CustomBlockLabelNameEditPart(View view) {
		super(view);
	}

	/**
	 * Respect the SysML diagram frame "par [Block] Block1 [DiagramName]"
	 */
	@Override
	protected String getLabelText() {
		String diagramName = getDiagramView().getName();
		return super.getLabelText() + " [" + diagramName + "]";
	}
}
