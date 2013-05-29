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
package org.eclipse.papyrus.uml.diagram.sequence.draw2d.routers;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter;
import org.eclipse.gmf.runtime.notation.View;

public class DurationConstraintAutomaticRouter extends ObliqueRouter {

	public DurationConstraintAutomaticRouter(View notationView) {
		super();
	}

	protected void resetEndPointsToEdge(Connection conn, PointList newLine) {
		if(newLine.size() < 2) {
			/*
			 * Connection must have at least 2 points in the list: the source
			 * and target anchor points. Otherwise it's invalid connection.
			 * Invalid connection case: add a dumb point at the start of the
			 * list and at the end of the list. The first and the last point in
			 * the list are replaced by the new source and target anchor points
			 * in this method
			 */
			newLine.addPoint(0, 0);
			newLine.insertPoint(new Point(), 0);
		}

		PrecisionPoint sourceAnchorPoint = null, targetAnchorPoint = null;
		while(newLine.size() != 2) {
			newLine.removePoint(1);
		}
		PrecisionPoint sourceReference = getAnchorReference(conn.getTargetAnchor());
		sourceAnchorPoint = getAnchorLocation(conn.getSourceAnchor(), sourceReference);
		targetAnchorPoint = getAnchorLocation(conn.getTargetAnchor(), sourceAnchorPoint);
		Point midpoint = recomputeBenpointLocation(conn);
		newLine.addPoint(midpoint);
		newLine.setPoint(midpoint, 1);

		conn.translateToRelative(sourceAnchorPoint);
		conn.translateToRelative(targetAnchorPoint);

		newLine.setPoint(new PrecisionPoint(sourceAnchorPoint.preciseX(), sourceAnchorPoint.preciseY()), 0);
		newLine.setPoint(targetAnchorPoint, newLine.size() - 1);
	}

	public Point recomputeBenpointLocation(Connection conn) {
		PrecisionPoint a1 = new PrecisionPoint(conn.getSourceAnchor().getReferencePoint());
		PrecisionPoint a2 = new PrecisionPoint(conn.getTargetAnchor().getReferencePoint());
		PrecisionPoint a3 = new PrecisionPoint(conn.getSourceAnchor().getLocation(a1));
		PrecisionPoint a4 = new PrecisionPoint(conn.getTargetAnchor().getLocation(a2));
		conn.translateToRelative(a3);
		conn.translateToRelative(a4);
		return new PrecisionPoint(a4.preciseX() + computeOffset(a3.preciseX(), a4.preciseX()), a3.preciseY());
	}

	private double computeOffset(double x, double x2) {
		if(Math.abs(x - x2) > 20) {
			return 20 * Math.signum(x - x2);
		} else {
			return (x - x2) * 0.5;
		}
	}

	private PrecisionPoint getAnchorLocation(ConnectionAnchor anchor, Point reference) {
		return new PrecisionPoint(anchor.getLocation(reference));
	}

	private PrecisionPoint getAnchorReference(ConnectionAnchor anchor) {
		return new PrecisionPoint(anchor.getReferencePoint());
	}
}
