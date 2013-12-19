/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.copy.ConnectionEndpointTracker;

/**
 * A DragTracker that moves the endpoint of a connection to a grid point
 */
public class PapyrusConnectionEndpointTracker extends ConnectionEndpointTracker implements DragTracker {

	/**
	 * Constructs a new ConnectionEndpointTracker for the given
	 * ConnectionEditPart.
	 * 
	 * @param cep
	 *        the ConnectionEditPart
	 */
	public PapyrusConnectionEndpointTracker(ConnectionEditPart cep) {
		super(cep);
	}


	/**
	 * Updates the request location.
	 * 
	 * @see org.eclipse.gef.tools.TargetingTool#updateTargetRequest()
	 */
	protected void updateTargetRequest() {
		//adapted code from ConnectionBendpointTrackerEx
		ReconnectRequest request = (ReconnectRequest)getTargetRequest();
		//		Request request = getTargetRequest();

		Point originalLocation = null;
		if(originalLocation == null) {
			originalLocation = getStartLocation().getCopy();
		}

		Dimension delta = getDragMoveDelta();

		if(getCurrentInput().isShiftKeyDown()) {
			float ratio = 0;
			if(delta.width != 0)
				ratio = (float)delta.height / (float)delta.width;

			ratio = Math.abs(ratio);
			if(ratio > 0.5 && ratio < 1.5) {
				if(Math.abs(delta.height) > Math.abs(delta.width)) {
					if(delta.height > 0)
						delta.height = Math.abs(delta.width);
					else
						delta.height = -Math.abs(delta.width);
				} else {
					if(delta.width > 0)
						delta.width = Math.abs(delta.height);
					else
						delta.width = -Math.abs(delta.height);
				}
			} else {
				if(Math.abs(delta.width) > Math.abs(delta.height))
					delta.height = 0;
				else
					delta.width = 0;
			}
		}
		Point moveDelta = new Point(delta.width, delta.height);
		SnapToHelper snapToHelper = (SnapToHelper)getConnectionEditPart().getAdapter(SnapToHelper.class);

		Rectangle rect = new Rectangle(originalLocation.x, originalLocation.y, 1, 1);
		PrecisionRectangle sourceRectangle = null;
		if(sourceRectangle == null) {
			sourceRectangle = new PrecisionRectangle(rect);
		}

		if(snapToHelper != null && !getCurrentInput().isModKeyDown(MODIFIER_NO_SNAPPING)) {
			PrecisionRectangle baseRect = sourceRectangle.getPreciseCopy();
			baseRect.translate(moveDelta);
			PrecisionPoint preciseDelta = new PrecisionPoint(moveDelta);
			snapToHelper.snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRect }, preciseDelta);
			Point newLocation = originalLocation.getCopy().translate(preciseDelta);
			request.setLocation(newLocation);
		} else {
			request.setLocation(getLocation());
		}
	}

}
