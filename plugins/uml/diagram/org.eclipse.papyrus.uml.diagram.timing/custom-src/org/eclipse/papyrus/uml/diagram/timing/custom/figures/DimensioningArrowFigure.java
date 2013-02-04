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

public class DimensioningArrowFigure extends PapyrusNodeFigure {

	private static final int PREFERRED_HEIGHT = 11;

	public DimensioningArrowFigure() {
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
		final int horizontalGap = w / 3;
		final int arrowSize = Math.max(Math.min(w / 5, 7), 3);
		final int verticalLineSize = arrowSize * 3;

		g.setLineWidth(1);

		// horizontal line (left part)
		g.drawLine(x, middleY, middleX - horizontalGap / 2, middleY);
		// horizontal line (right part)
		g.drawLine(middleX + horizontalGap / 2, middleY, x + w, middleY);
		// left vertical line
		g.drawLine(x, middleY - verticalLineSize / 2, x, middleY + verticalLineSize / 2);
		// right vertical line
		g.drawLine(x + w, middleY - verticalLineSize / 2, x + w, middleY + verticalLineSize / 2);

		g.setAntialias(SWT.ON);
		// left arrow
		g.drawLine(x, middleY, x + arrowSize, middleY - arrowSize);
		g.drawLine(x, middleY, x + arrowSize, middleY + arrowSize);
		// right arrow
		g.drawLine(x + w, middleY, x + w - arrowSize, middleY - arrowSize);
		g.drawLine(x + w, middleY, x + w - arrowSize, middleY + arrowSize);

		g.popState();
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		return new Dimension(-1, PREFERRED_HEIGHT);
	}

}
