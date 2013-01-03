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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Image;

public class SmallSquareFigure extends PapyrusNodeFigure implements IPapyrusUMLElementFigure {

	public static final int SQUARE_SIZE = 5;
	/** How many pixels the Figure must be moved upwards and leftwards in order to center it */
	public static final int RADIUS = SQUARE_SIZE / 2;

	public SmallSquareFigure() {
		super();
	}

	@Override
	public void paintFigure(final Graphics g) {
		g.pushState();

		final int middleX = this.bounds.x + this.bounds.width / 2;
		final int middleY = this.bounds.y + this.bounds.height / 2;

		g.setLineWidth(1);

		g.fillRectangle(middleX - SQUARE_SIZE / 2, middleY - SQUARE_SIZE / 2, SQUARE_SIZE, SQUARE_SIZE);
		g.popState();
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		return new Dimension(SQUARE_SIZE, SQUARE_SIZE);
	}

	public void setStereotypeDisplay(final String stereotypes, final Image image) {
		// nothing
	}

}
