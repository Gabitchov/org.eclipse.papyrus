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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

public class CrossFigure extends PapyrusNodeFigure implements IPapyrusUMLElementFigure {

	public static final int CROSS_SIZE = 8;

	public CrossFigure() {
		super();
		setShadow(false);
		setBorder(null);
	}

	@Override
	public void paintFigure(final Graphics graphics) {
		super.paintFigure(graphics);
		graphics.pushState();
		graphics.setAntialias(SWT.ON);
		final Rectangle clipRect = graphics.getClip(new Rectangle());
		final int additionalSizeForCross = 10;
		// draw the cross outside its bounds so that the StateInvariant lines touch the base of the cross
		// instead of its invisible border
		graphics.setClip(new Rectangle(getBounds()).expand(additionalSizeForCross, additionalSizeForCross));

		final int x = this.bounds.x - additionalSizeForCross + 1;
		final int y = this.bounds.y - additionalSizeForCross + 1;
		final int w = this.bounds.width + additionalSizeForCross * 2;
		final int h = this.bounds.height + additionalSizeForCross * 2;
		final int z = Math.max(w / 8, 1);

		graphics.setLineWidth(z);
		graphics.setLineCap(SWT.CAP_ROUND);
		graphics.drawLine(x + z, y + z, x + w - z * 2, y + h - z * 2);
		graphics.drawLine(x + w - z * 2, y + z, x + z, y + h - z * 2);
		graphics.setClip(clipRect);
		graphics.popState();
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		return new Dimension(CROSS_SIZE, CROSS_SIZE);
	}

	public void setStereotypeDisplay(final String stereotypes, final Image image) {
		// TODO Auto-generated method stub

	}

}
