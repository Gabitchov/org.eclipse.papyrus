/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;

public class TimingRulerFigure extends InvisibleRectangleFigure {

	private final InvisibleRectangleFigure tickContainer;

	public TimingRulerFigure() {
		super();
		this.tickContainer = new InvisibleRectangleFigure();
		this.tickContainer.setLayoutManager(new FillLayout());
		add(this.tickContainer);
	}

	public IFigure getTickContainerFigure() {
		return this.tickContainer;
	}

	public IFigure getFreeTimeRulerContainerFigure() {
		return this.tickContainer;
	}

	public IFigure getLinearTimeRulerContainerFigure() {
		return this.tickContainer;
	}

}
