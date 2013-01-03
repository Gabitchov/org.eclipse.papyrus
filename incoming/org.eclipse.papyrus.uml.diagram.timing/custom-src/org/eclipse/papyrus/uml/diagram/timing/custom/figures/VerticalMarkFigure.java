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
import org.eclipse.swt.graphics.Image;

public class VerticalMarkFigure extends org.eclipse.draw2d.Figure implements IPapyrusUMLElementFigure {

	public static final int PREFERRED_WIDTH = 5;
	public static final int PREFERRED_HEIGHT = 12;

	public VerticalMarkFigure() {
		super();
	}

	@Override
	protected void paintFigure(final Graphics g) {
		super.paintFigure(g);
		g.pushState();
		final int middleX = this.bounds.x + this.bounds.width / 2;
		g.setLineWidth(3);
		g.drawLine(middleX, this.bounds.y, middleX, this.bounds.y + this.bounds.height);
		g.popState();
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
	}

	public void setStereotypeDisplay(final String stereotypes, final Image image) {
		// TODO Auto-generated method stub

	}

}
