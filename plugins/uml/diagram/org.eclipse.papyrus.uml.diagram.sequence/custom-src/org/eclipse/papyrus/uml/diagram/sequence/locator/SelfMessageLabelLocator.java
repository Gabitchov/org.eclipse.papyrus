/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.locator;

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.LabelLocator;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;

/**
 * New label locator for self linked message, the label would be located outside of the bounds of message by default.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class SelfMessageLabelLocator extends LabelLocator {

	private static final int H_MARGIN = 4;

	public SelfMessageLabelLocator(IFigure parent, int alignment) {
		super(parent, new Point(), alignment);
	}

	@Override
	public void relocate(IFigure target) {
		Dimension size = target.getPreferredSize();
		boolean relocated = false;
		PointList points = ((Connection)parent).getPoints();
		List lineSegments = PointListUtilities.getLineSegments(points);
		if(lineSegments.size() == 3) {
			Point start = points.getFirstPoint();
			LineSeg center = (LineSeg)lineSegments.get(1);
			if(center.isVertical()) {
				Point origin = center.getOrigin();
				Point terminus = center.getTerminus();
				Point loc = new Point(origin.x, -1);
				if(origin.x < terminus.x) {
					loc.y = origin.y + ((terminus.y - origin.y) / 2);
				} else {
					loc.y = terminus.y + ((origin.y - terminus.y) / 2);
				}
				Rectangle rect = new Rectangle(loc, size);
				if(start.x < loc.x) {
					rect.translate(H_MARGIN, -1 * size.height / 2);
				} else {
					rect.translate(-H_MARGIN - size.width, -1 * size.height / 2);
				}
				target.setBounds(rect);
				relocated = true;
			}
		}
		if(!relocated) {
			super.relocate(target);
		}
	}
}
