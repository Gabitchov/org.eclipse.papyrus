/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

/**
 * A resizable editpolicy for shape editparts. It constraint the resize requests so that the shape stays as a square.
 * 
 * @see ResizableShapeEditPolicy
 */
public class ResizableSquareEditPolicy extends ResizableShapeEditPolicy {

	/**
	 * Shows or updates feedback for a change bounds request.
	 * The request is updated by the way so that the shape stays a square.
	 * 
	 * @param request
	 *        the request
	 */
	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		// adapt the request for a square resize
		Point move = request.getMoveDelta();
		Dimension delta = request.getSizeDelta();
		int dH = delta.height;
		int dW = delta.width;
		int signum = 0;
		if(dH <= 0 && dW <= 0) {
			signum = -1;
		} else {
			signum = 1;
		}
		int positiveResize = Math.max(dH, dW);
		if(positiveResize <= 0) {
			if(dH == 0) {
				positiveResize = -dW;
			} else if(dW == 0) {
				positiveResize = -dH;
			} else {
				positiveResize = Math.min(-dH, -dW);
			}
		}
		int newDH = signum * positiveResize;
		int newDW = newDH;
		int dir = request.getResizeDirection();
		// adjust new position if impacted by resizing
		if((dir & PositionConstants.NORTH) > 0) {
			move.y += dH - newDH;
		}
		if((dir & PositionConstants.WEST) > 0) {
			move.x += dW - newDW;
		}
		request.setMoveDelta(move);
		delta.height = newDH;
		delta.width = newDW;
		super.showChangeBoundsFeedback(request);
	}
}
