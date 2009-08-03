/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

public class RequiredInterfaceDecoration extends PolylineDecoration {

	private static final Point TEMP_POINT = new Point();

	private static final Rectangle TEMP_RECTANGLE = new Rectangle();

	private final int GAP = 3;

	private int myRadius;

	private int myAngle;

	public RequiredInterfaceDecoration() {
		setRadius(1);
		setScale(1, 1);
	}

	public void setRadius(int radius) {
		myRadius = radius;
		setTemplate(new PointList(new int[] { radius - GAP, 0 }));
	}

	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			// implicitly sets bounds
			super.getBounds();
			computeArcBounds(TEMP_RECTANGLE);
			TEMP_RECTANGLE.expand(1, 1);
			bounds.union(TEMP_RECTANGLE);
		}
		return bounds;
	}

	@Override
	public void setRotation(double angle) {
		super.setRotation(angle);
		myAngle = (int) (angle * 180 / Math.PI);
	}

	@Override
	protected void fillShape(Graphics g) {
		// do nothing
	}

	@Override
	protected void outlineShape(Graphics g) {
		computeArcBounds(TEMP_RECTANGLE);
		g.drawArc(TEMP_RECTANGLE, -myAngle + 90, 180);
	}

	private void computeArcBounds(Rectangle output) {
		if (getPoints().size() == 0) {
			output.setSize(0, 0);
			return;
		}
		getPoints().getPoint(TEMP_POINT, 0);
		output.setLocation(TEMP_POINT.x - myRadius, TEMP_POINT.y - myRadius);
		output.setSize(2 * myRadius, 2 * myRadius);
	}
}
