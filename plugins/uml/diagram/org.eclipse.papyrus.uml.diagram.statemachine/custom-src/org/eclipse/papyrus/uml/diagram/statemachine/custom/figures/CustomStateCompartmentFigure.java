/****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Ansgar Radermacher (CEA LIST) - minor changes
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * This custom figure is used for state and state-machines compartments.
 * It disables the scrollbar for this compartment (containing one or more regions), not for the region
 * itself.
 */
public class CustomStateCompartmentFigure extends ShapeCompartmentFigure {

	public CustomStateCompartmentFigure(String compartmentTitle, IMapMode mm) {
		super(compartmentTitle, mm);

		setTitleVisibility(false);
	}

	@Override
	protected void configureFigure(IMapMode mm) {
		super.configureFigure(mm);
		scrollPane.setScrollBarVisibility(ScrollPane.NEVER);
		scrollPane.setBorder(null);
		setBorder(null);
	}
}
