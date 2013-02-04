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
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Image;

public class FullStateFigure extends PapyrusNodeFigure implements IPapyrusUMLElementFigure {

	private int posY;

	public FullStateFigure() {
		super();
		setBorder(null);
	}

	@Override
	public void paintFigure(final Graphics g) {
		// super.paintFigure(g);
		g.pushState();

		// DEBUG
		// g.setLineDash(new int[] { 1, 5 });
		// g.drawRectangle(this.bounds.x, this.bounds.y, this.bounds.width - 1, this.bounds.height - 1);
		// g.setLineDash(new int[] {});
		// END DEBUG

		// final int y = this.bounds.y;
		final int x = this.bounds.x;
		final int w = this.bounds.width;
		final int y = this.posY;

		g.setLineWidth(1);
		g.drawLine(x, y, x + w, y);

		g.popState();
	}

	public void setPosY(final int endY) {
		this.posY = endY;
	}

	@Override
	protected void paintBorder(final Graphics graphics) {
		// no border
	}

	public void setStereotypeDisplay(final String stereotypes, final Image image) {
		// TODO Auto-generated method stub

	}
}
