/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.draw2d.CenterLayout;

public class InteractionUseRectangleFigure extends InteractionRectangleFigure {

	protected WrappingLabel fFigureInteractionUseName1Figure;

	protected WrappingLabel fFigureInteractionUseName2Figure;

	public InteractionUseRectangleFigure() {

		super();

	}

	protected void createContents() {

		super.createContents();

		super.remove(fFigureInteractionCompartmentFigure);

		fFigureInteractionUseName2Figure = getFigureInteractionLabelFigure();

		CenterLayout layout1 = new CenterLayout();

		RectangleFigure figureTest2 = new RectangleFigure();

		layout1.getPreferredSize(figureTest2);
		figureTest2.setOutline(false);
		figureTest2.setFill(false);
		figureTest2.setLayoutManager(layout1);

		fFigureInteractionUseName1Figure = new WrappingLabel();

		figureTest2.add(fFigureInteractionUseName1Figure, BorderLayout.RIGHT);

		add(figureTest2, BorderLayout.CENTER);

	}

	public WrappingLabel getFigureInteractionUseName() {
		return fFigureInteractionUseName1Figure;
	}

	public WrappingLabel getFigureInteractionUseRef() {
		return fFigureInteractionUseName2Figure;
	}

}
