/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy - arthur.daussy@atos.net - Bug 368932 - [ActivitiyDiagram] Prevent Compartment of Activity group to be selected
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;

/**
 * Set in order to have Generation Gap Pattern.
 * 
 * @author arthur daussy
 * 
 */
public class CustomInterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart extends InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart implements IGroupCompartmentEditPart {

	public CustomInterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * remove the top border
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.setTitleVisibility(false);
		// remove the top border
		result.setBorder(null);
		// Hide scrollBar
		return result;
	}

	/**
	 * Unselectable EditPart
	 */
	@Override
	public boolean isSelectable() {
		return false;
	}
}
