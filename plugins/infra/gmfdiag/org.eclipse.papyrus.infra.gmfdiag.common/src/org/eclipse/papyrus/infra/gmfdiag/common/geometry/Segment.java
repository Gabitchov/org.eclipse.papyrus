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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

/**
 * 
 * This class is used to manipulate segment
 */
public class Segment {


	/**
	 * the start point of the segment
	 */
	private final PrecisionPoint start;

	/**
	 * the end point of the segment
	 */
	private final PrecisionPoint end;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param start
	 *        the start point of the segment
	 * @param end
	 *        the end point of the segment
	 */
	public Segment(final PrecisionPoint start, final PrecisionPoint end) {
		this.start = start.getPreciseCopy();
		this.end = end.getPreciseCopy();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param start
	 *        the start point of the segment
	 * @param end
	 *        the end point of the segment
	 */
	public Segment(final Point start, final Point end) {
		this.start = new PrecisionPoint(start);
		this.end = new PrecisionPoint(end);
	}

	/**
	 * 
	 * @param segment
	 *        a segment
	 * @return
	 *         <code>true</code> if the segment has a common point with this one
	 */
	public boolean hasIntersection(final Segment segment) {
		return getIntersection(segment) != null;
	}

	/**
	 * 
	 * @return
	 *         the start point of the segment
	 */
	public final PrecisionPoint getStartPoint() {
		return this.start;
	}

	/**
	 * 
	 * @return
	 *         the end point of the segment
	 */
	public final PrecisionPoint getEndPoint() {
		return this.end;
	}

	//find line intersection in awt
	//	static Point get_line_intersection(Line2D.Double pLine1, Line2D.Double pLine2) {
	//		Point result = null;
	//
	//		double s1_x = pLine1.x2 - pLine1.x1;
	//		double s1_y = pLine1.y2 - pLine1.y1;
	//		double s2_x = pLine2.x2 - pLine2.x1;
	//		double s2_y = pLine2.y2 - pLine2.y1;
	//
	//		double s = (-s1_y * (pLine1.x1 - pLine2.x1) + s1_x * (pLine1.y1 - pLine2.y1)) / (-s2_x * s1_y + s1_x * s2_y);
	//		double t = (s2_x * (pLine1.y1 - pLine2.y1) - s2_y * (pLine1.x1 - pLine2.x1)) / (-s2_x * s1_y + s1_x * s2_y);
	//
	//		if(s >= 0 && s <= 1 && t >= 0 && t <= 1) {
	//			// Collision detected
	//			result = new Point((int)(pLine1.x1 + (t * s1_x)), (int)(pLine1.y1 + (t * s1_y)));
	//		} // end if
	//
	//		return result;
	//	}

	/**
	 * 
	 * @param segment
	 *        a segment
	 * @return
	 *         the intersection point if exists or <code>null</code>
	 */
	public PrecisionPoint getIntersection(final Segment segment) {
		double s1_x = segment.getEndPoint().preciseX() - segment.getStartPoint().preciseX();
		double s1_y = segment.getEndPoint().preciseY() - segment.getStartPoint().preciseY();
		double s2_x = getEndPoint().preciseX() - getStartPoint().preciseX();
		double s2_y = getEndPoint().preciseY() - getStartPoint().preciseY();
		double s = (-s1_y * (segment.getStartPoint().preciseX() - getStartPoint().preciseX()) + s1_x * (segment.getStartPoint().preciseY() - getStartPoint().preciseY())) / (-s2_x * s1_y + s1_x * s2_y);
		double t = (s2_x * (segment.getStartPoint().preciseY() - getStartPoint().preciseY()) - s2_y * (segment.getStartPoint().preciseX() - getStartPoint().preciseX())) / (-s2_x * s1_y + s1_x * s2_y);

		PrecisionPoint result = null;
		if(s >= 0 && s <= 1 && t >= 0 && t <= 1) {
			// Collision detected
			result = new PrecisionPoint((int)(segment.getStartPoint().preciseX() + (t * s1_x)), (int)(segment.getStartPoint().preciseY() + (t * s1_y)));
		} // end if

		return result;
	}

}
