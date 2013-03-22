/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;

public class EllipseDecoration extends Ellipse implements RotatableDecoration {

	private boolean myAlwaysFill;

	public EllipseDecoration() {
		setPreferredSize(new Dimension(5, 5));
	}

	public void setAlwaysFill(boolean alwaysFill) {
		myAlwaysFill = alwaysFill;
	}

	@Override
	public void setLocation(Point p) {
		Dimension delta = getPreferredSize().getScaled(0.5).getNegated();
		super.setLocation(p.getTranslated(delta));
	}

	public void setReferencePoint(Point p) {
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		if(myAlwaysFill) {
			Color oldBack = graphics.getBackgroundColor();
			graphics.setBackgroundColor(graphics.getForegroundColor());
			fillShape(graphics);
			graphics.setBackgroundColor(oldBack);
		}
		super.outlineShape(graphics);
	}
}
