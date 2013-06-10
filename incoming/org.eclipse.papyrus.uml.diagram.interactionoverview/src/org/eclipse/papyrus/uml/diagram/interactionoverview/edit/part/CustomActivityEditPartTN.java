/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.figures.ActivityAsInteractionFigure;

public class CustomActivityEditPartTN extends ActivityEditPart {

	public CustomActivityEditPartTN(final View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new ActivityAsInteractionFigure();
	}
}
