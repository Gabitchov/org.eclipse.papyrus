/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */

package org.eclipse.papyrus.uml.diagram.statemachine.custom.policies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart;

/**
 * A resizable editpolicy for shape editparts. It ensure that the resize keeps the shape as a fork or a join
 * 
 * @see ResizableShapeEditPolicy
 */
public class CustomPseudostateForkJoinResizeEditPolicy extends ResizableShapeEditPolicy {

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
		if(request.getType().equals(RequestConstants.REQ_RESIZE) && getHost() instanceof UMLNodeEditPart) {
			Dimension dim = getHostFigure().getBounds().getSize();
			Dimension preferedDim = ((UMLNodeEditPart)getHost()).getPrimaryShape().getPreferredSize();
			Dimension delta = request.getSizeDelta();
			int dH = delta.height;
			int dW = delta.width;
			if(dH > dW) {
				dW = preferedDim.width - dim.width;
			} else {
				dH = preferedDim.height - dim.height;
			}
			request.setSizeDelta(new Dimension(dW, dH));
		}
		super.showChangeBoundsFeedback(request);
	}
}
