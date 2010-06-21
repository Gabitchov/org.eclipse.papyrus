/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.papyrus.diagram.composite.custom.figures.PortFigure;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;

public class FlowPortFigure extends PortFigure {

	private final FlowDirection direction;

	public FlowPortFigure(FlowDirection direction) {
		this.direction = direction;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
	}

}
