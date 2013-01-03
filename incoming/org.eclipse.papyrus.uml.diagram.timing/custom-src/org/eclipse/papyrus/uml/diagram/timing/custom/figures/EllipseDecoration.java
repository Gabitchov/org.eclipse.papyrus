/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class EllipseDecoration extends Ellipse implements RotatableDecoration {

	public EllipseDecoration() {
		setPreferredSize(new Dimension(5, 5));
	}

	@Override
	public void setLocation(final Point p) {
		final Dimension delta = getPreferredSize().getScaled(0.5).getNegated();
		super.setLocation(p.getTranslated(delta));
	}

	public void setReferencePoint(final Point p) {
		// nothing
	}

	@Override
	protected void fillShape(final Graphics graphics) {
		final Color oldBack = graphics.getBackgroundColor();
		graphics.setBackgroundColor(graphics.getForegroundColor());
		graphics.fillOval(getOptimizedBounds());
		graphics.setBackgroundColor(oldBack);
	}

	private Rectangle getOptimizedBounds() {
		final float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
		final int inset = (int) Math.floor(lineInset);
		final Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
		r.x += inset;
		r.y += inset;
		return r;
	}

	@Override
	protected void outlineShape(final Graphics graphics) {
		// no outline
	}
}