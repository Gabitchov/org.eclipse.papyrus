/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.TimeRulerLayout;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeRulerCompartmentEditPartCN;

public class CustomTimeRulerCompartmentEditPartCN extends TimeRulerCompartmentEditPartCN {

	public CustomTimeRulerCompartmentEditPartCN(final View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		final ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		result.setLayoutManager(new FillLayout());
		result.getContentPane().setLayoutManager(new TimeRulerLayout());
		return result;
	}

	/**
	 * Hide the scrollbar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		((ResizableCompartmentFigure) getFigure()).getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
		refreshBounds();
	}

	@Override
	public boolean isSelectable() {
		// No need to select the compartment.
		// This saves one click when selecting something inside.
		return false;
	}
}
