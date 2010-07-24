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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.draw2d.routers;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter;

/**
 * An oblique router which enable to draw messages from and to a same element
 * 
 * @author vhemery
 */
public class MessageRouter extends ObliqueRouter {

	/**
	 * Method insertSelfRelVertices.
	 * This method will create a routed line that routes from and to the same figure.
	 * 
	 * @param conn
	 *        the connection
	 * @param newLine
	 *        the point list line
	 */
	protected void getSelfRelVertices(Connection conn, PointList newLine) {
		if(conn.getSourceAnchor().getOwner() == null) {
			return;
		}
		// the only way of accessing to selfRelConnections is to make a fake call to super
		super.getSelfRelVertices(conn, newLine.getCopy());

		IFigure owner = conn.getSourceAnchor().getOwner();
		Point middle = owner.getBounds().getCenter();

		// ensure that the end points are anchored properly to the shape.
		Point ptS2 = newLine.getPoint(0);
		Point ptS1 = conn.getSourceAnchor().getReferencePoint();
		conn.translateToRelative(ptS1);
		Point ptAbsS2 = new Point(ptS2);
		conn.translateToAbsolute(ptAbsS2);
		Point ptEdge = conn.getSourceAnchor().getLocation(ptAbsS2);
		conn.translateToRelative(ptEdge);
		ptS1 = getStraightEdgePoint(ptEdge, ptS1, ptS2);

		Point ptE2 = newLine.getPoint(newLine.size() - 1);
		Point ptE1 = conn.getTargetAnchor().getReferencePoint();
		conn.translateToRelative(ptE1);
		Point ptAbsE2 = new Point(ptE2);
		conn.translateToAbsolute(ptAbsE2);
		ptEdge = conn.getTargetAnchor().getLocation(ptAbsE2);
		conn.translateToRelative(ptEdge);
		ptE1 = getStraightEdgePoint(ptEdge, ptE1, ptE2);

		newLine.removeAllPoints();
		newLine.addPoint(ptS1);

		// insert two points
		Point extraPoint1 = ptS2.getTranslated(ptE2).scale(0.5);
		if(ptS2.x - middle.x > 0) {
			extraPoint1.translate(SELFRELSIZEINIT, 0);
		} else {
			extraPoint1.translate(-SELFRELSIZEINIT, 0);
		}
		Point extraPoint2 = extraPoint1.getCopy();

		if(isFeedback(conn)) {
			extraPoint1.y = ptS2.y;
			extraPoint2.y = ptE2.y;
		} else {
			extraPoint1.y = ptS1.y;
			extraPoint2.y = ptE1.y;
		}
		newLine.addPoint(extraPoint1);
		newLine.addPoint(extraPoint2);


		newLine.addPoint(ptE1);
	}

	/**
	 * @param conn
	 *        the <code>Connection</code> that is to be check if it is a feedback
	 *        connection or not.
	 * @return <code>true</code> is it is a feedback connection, <code>false</code> otherwise.
	 */
	public boolean isFeedback(Connection conn) {
		Dimension dim = new Dimension(100, 100);
		Dimension dimCheck = dim.getCopy();
		conn.translateToRelative(dimCheck);
		return dim.equals(dimCheck);
	}
}
