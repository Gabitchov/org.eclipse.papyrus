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

import org.eclipse.draw2d.Graphics;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;

public class FullStateInvariantVerticalLineFigure extends PapyrusNodeFigure {

	public FullStateInvariantVerticalLineFigure() {
		super();
		setBorder(null);
	}

	@Override
	public void paintFigure(final Graphics g) {
		// super.paintFigure(g);
		g.setLineWidth(1);
		final int middleX = this.bounds.x + this.bounds.width / 2;
		g.drawLine(middleX, this.bounds.y, middleX, this.bounds.y + this.bounds.height);
	}

	@Override
	protected void paintBorder(final Graphics graphics) {
		// no border
	}
}
