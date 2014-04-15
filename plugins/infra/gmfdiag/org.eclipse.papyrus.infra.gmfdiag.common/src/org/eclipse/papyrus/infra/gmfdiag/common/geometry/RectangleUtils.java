/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.geometry;

import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * Utils class for drawd2D Rectangle
 * 
 */
public class RectangleUtils {

	private RectangleUtils() {
		//to prevent instantiation
	}


	/**
	 * 
	 * @param rect
	 *        a rectangle
	 * @param segment
	 *        a segment
	 * @return
	 *         the intersection point between the segment and the rectangle, if exists
	 */
	public static final PrecisionPoint getIntersectionPoint(final Rectangle rect, final Segment segment) {
		PrecisionPoint result = null;

		//top segment
		final Segment topSegment = new Segment(rect.getTopLeft(), rect.getTopRight());
		result = segment.getIntersection(topSegment);

		if(result == null) {
			//right segment
			final Segment rightSegment = new Segment(rect.getTopRight(), rect.getBottomRight());
			result = segment.getIntersection(rightSegment);
		}

		if(result == null) {
			//bottom segment
			final Segment bottomSegment = new Segment(rect.getBottomRight(), rect.getBottomLeft());
			result = segment.getIntersection(bottomSegment);
		}

		if(result == null) {
			//left segment
			final Segment leftSegment = new Segment(rect.getBottomLeft(), rect.getTopLeft());
			result = segment.getIntersection(leftSegment);
		}
		return result;
	}
}
