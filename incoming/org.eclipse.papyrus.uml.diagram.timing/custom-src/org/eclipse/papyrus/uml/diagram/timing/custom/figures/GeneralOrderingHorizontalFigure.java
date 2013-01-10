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
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.SWT;

public class GeneralOrderingHorizontalFigure extends PapyrusNodeFigure {

	private static final int PREFERRED_HEIGHT = 11;

	public GeneralOrderingHorizontalFigure() {
		super();
		setShadow(false);
		setBorder(null);
	}

	@Override
	public void paintFigure(final Graphics g) {
		g.pushState();

		final int middleX = this.bounds.x + this.bounds.width / 2;
		final int middleY = this.bounds.y + this.bounds.height / 2;
		final int x = this.bounds.x;
		final int w = this.bounds.width - 1;
		final int arrowSize = Math.max(Math.min(w / 3, 12), 6);
		final int a = arrowSize / 2;

		g.setLineWidth(1);

		// horizontal line
		g.setLineDash(new int[]{ 4, 4 });
		g.drawLine(x, middleY, x + w, middleY);
		g.setLineDash(new int[]{});

		// arrow
		g.setAntialias(SWT.ON);
		g.setBackgroundColor(getForegroundColor());
		g.fillPolygon(new int[]{ middleX - a, this.bounds.y, middleX + a, middleY, middleX - a, this.bounds.y + this.bounds.height });

		g.popState();
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		return new Dimension(-1, PREFERRED_HEIGHT);
	}

}
