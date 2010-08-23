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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;

/**
 * An oblique router which enable to draw messages from and to a same element
 * 
 * @author vhemery
 */
@SuppressWarnings("restriction")
public class MessageHorizontalStickRouter extends RectilinearRouter {

	public static final int MAX_HORIZONTAL_DELTA = 10;

	/**
	 * convert the line into an horizontal line if the y diff is in the delta.
	 * otherwise convert to a simple oblique line by removing intermediate points.
	 */
	@Override
	public void routeLine(Connection conn, int nestedRoutingDepth, PointList newLine) {
		super.routeLine(conn, nestedRoutingDepth, newLine);

		Point sourcePoint = newLine.getFirstPoint();
		conn.translateToAbsolute(sourcePoint);
		Point targetPoint = newLine.getLastPoint();
		conn.translateToAbsolute(targetPoint);

		if(!checkSelfRelConnection(conn, newLine)) {
			if(Math.abs(sourcePoint.y - targetPoint.y) <= MAX_HORIZONTAL_DELTA) {
				targetPoint.y = sourcePoint.y;
			}

			conn.translateToRelative(sourcePoint);
			conn.translateToRelative(targetPoint);

			newLine.removeAllPoints();
			newLine.addPoint(sourcePoint);
			newLine.addPoint(targetPoint);
		}
	}

	@Override
	protected void getSelfRelVertices(Connection conn, PointList newLine) {
		// the only way of accessing to selfRelConnections is to make a fake call to super
		super.getSelfRelVertices(conn, newLine.getCopy());

		SelfMessageRouter.computeSelfRelVertices(conn, newLine);
	}

	@Override
	protected boolean checkSelfRelConnection(Connection conn, PointList newLine) {
		if((conn.getSourceAnchor().getOwner() == conn.getTargetAnchor().getOwner())) {
			getSelfRelVertices(conn, newLine);
			return true;
		} else {
			return super.checkSelfRelConnection(conn, newLine);
		}
	}

}
